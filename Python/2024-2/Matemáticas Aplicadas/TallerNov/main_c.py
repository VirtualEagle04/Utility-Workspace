# Taller Cliente-Servidor
# CLIENTE
# Federico Vargas Rozo
import socket
from base64 import b64encode
import hashlib
import random
import numpy as np

# region CONFIGURACIÓN_CLIENTE
SERVER_HOST = "192.168.1.110"
SERVER_PORT = 12345
# endregion

# region EJERCICIO_1
# Cliente: Lee un número entero positivo que indica una posición y se lo envía al servidor. 
# Servidor: Imprime el número primo de la posición que recibió.  
# Tamaño de envío: Sin restricción
def ej1():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
        client_socket.connect((SERVER_HOST, SERVER_PORT))
        
        prime_index = input("Ingrese el índice del número primo a consultar: ")

        client_socket.sendall(prime_index.encode())
        print(f'Enviado: {prime_index}')

# endregion

# region EJERCICIO_2
# Cliente:  Lee  una  palabra  y  un  número  entero  positivo  que  representa  un desplazamiento. 
# Servidor: Imprime la palabra cifrada con el algoritmo Cesar y con el desplazamiento que se le indicó. 
# Tamaño de envío: Sin restricción
def ej2():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
        client_socket.connect((SERVER_HOST, SERVER_PORT))
        
        message = input("Ingrese la palabra a cifrar: ")
        step = input("Ingrese el desplazamiento del cifrado: ")

        client_socket.sendall(message.encode())
        print(f'Enviado: {message}')
        client_socket.sendall(step.encode())
        print(f'Enviado: {step}')

# endregion

# region EJERCICIO_3
# Cliente: Pide el nombre del archivo (jpg, pdf, xlsx, etc.), lo codifica en base64 y se lo envía al servidor.
# Servidor: Restaura el archivo correspondiente con el formato original (jpg, pdf, etc.) 
# Tamaño de envío: 1 byte
def ej3():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
        client_socket.connect((SERVER_HOST, SERVER_PORT))
        
        file_name = input("Ingrese el nombre del archivo a codificar: ")

        client_socket.sendall(file_name.encode())

        with open(file_name, 'rb') as file:
            data = file.read()
            cypher = b64encode(data)

            for i in range(0, len(cypher), 8):
                seq = cypher[i:i+8]
                client_socket.sendall(seq)
                print(f'Enviado: {seq}')
                
# endregion

# region EJERCICIO_4
# Cliente: Lee el nombre de un archivo donde está la llave que se usará para encriptar un mensaje. Encripta un mensaje usando el algoritmo de Hill y lo envía al servidor. 
# Servidor: El servidor también tiene la llave guardada en un archivo de texto, por lo que debe leer el archivo para poder desencriptar el mensaje. 
# Tamaño de envío: 1 byte
def ej4():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
        client_socket.connect((SERVER_HOST, SERVER_PORT))
        
        key_file_name = input("Ingrese el nombre del archivo con la llave: ")
        
        message = input("Ingrese el mensaje a encriptar (MÁX 4 Caractéres): ")
        if not message.isalpha():
            print("El mensaje debe contener unicamente letras del abecedario.")
            return
        else:
            encrypted_msg = cifrado_hill(message.upper(), leer_matriz(key_file_name))
            client_socket.sendall(encrypted_msg.encode())
            print(f'Enviado: {encrypted_msg}')

def letra_a_posicionABC(c):
    return ord(c) - ord('A')

def posicionABC_a_letra(pos):
    return chr(pos + ord('A'))

def determinante_matriz(matrix):
    det = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0])
    return det

def leer_matriz(file_name):
    key_matrix = [[0, 0],
                  [0, 0]]
    with open(file_name, 'r') as file:
        data = file.read()
        values = data.split()
        key_matrix[0][0] = int(values[0])
        key_matrix[0][1] = int(values[1])
        key_matrix[1][0] = int(values[2])
        key_matrix[1][1] = int(values[3])
    return key_matrix

def matriz_inversa(matrix):
    det = determinante_matriz(matrix)
    if det != 0:
        inverse_matrix = np.linalg.inv(matrix)
        return inverse_matrix

def multiplicacion_matrices(matrixA, matrixB):
    # return np.dot(matrixA, matrixB)

    result = [0, 0]
    for i in range(2):
        for j in range(2):
            result[i] += matrixA[i][j] * matrixB[j]
            result[i] %= 26
    return result

def cifrado_hill(msg, key_matrix):
    encrypted_msg = ''
    for i in range(0, len(msg), 2):
        vector = [letra_a_posicionABC(msg[i]), letra_a_posicionABC(msg[i + 1])]
        encrypted_vector = multiplicacion_matrices(key_matrix, vector)
        encrypted_letters = [posicionABC_a_letra(num) for num in encrypted_vector]
        encrypted_msg += ''.join(encrypted_letters)

    return encrypted_msg

def descrifrado_hill(encrypted_msg, key_matrix):
    decrypted_msg = ''
    for i in range(0, len(encrypted_msg), 2):
        vector = [letra_a_posicionABC(encrypted_msg[i]), letra_a_posicionABC(encrypted_msg[i + 1])]
        decrypted_vector = multiplicacion_matrices(matriz_inversa(key_matrix), vector)
        decrypted_letters = [posicionABC_a_letra(num) for num in decrypted_vector]
        decrypted_msg += ''.join(decrypted_letters)
    
    return decrypted_msg
# endregion

# region EJERCICIO_5
# Cliente:  Lee  un  mensaje  para  luego  encriptarlo  usando  el  algoritmo  XOR  y  luego enviarlo al servidor. 
# Servidor: Desencripta lo que recibe y luego lo Imprime. 
# Tamaño de envío: 1 byte
def ej5():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
        client_socket.connect((SERVER_HOST, SERVER_PORT))

        message = input("Ingrese el mensaje a encriptar: ")

        cipher_message = xor_cifrado_descifrado(message)

        client_socket.sendall(cipher_message.encode())
        print(f'Enviado: {cipher_message}')

def xor_cifrado_descifrado(message):
    xor_key = 'F'

    for i in range(len(message)):
        message = (message[:i] + chr(ord(message[i]) ^ ord(xor_key)) + message[i + 1:])
    
    return message
# endregion

# region EJERCICIO_6
# Cliente: Lee el nombre de un archivo el cual debe convertir a texto con formato binario y enviarlo al servidor. También debe enviar el valor hash del archivo. 
# Servidor: Restaura el archivo original y verifica si el valor hash sí corresponde al archivo restaurado. 
# Tamaño de envío: 1 byte
def ej6():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
        client_socket.connect((SERVER_HOST, SERVER_PORT))

        file_name = input("Ingrese el nombre completo del archivo a enviar: ")
        client_socket.sendall(file_name.encode())

        with open(file_name, "rb") as f:
            bytes_data = f.read()
        
        for byte in bytes_data:
            seq = bin(byte)[2:].zfill(8)
            client_socket.sendall(seq.encode())
            print(f'Enviado: {seq.encode()}')

        client_socket.sendall('|'.encode())

        file_hash = hashlib.new("sha256", bytes_data).hexdigest()
        print(f'Full Hash: {file_hash}')
        for i in range(0, len(file_hash), 8):
            seq = file_hash[i:i+8]
            print(f'Fragmento de Hash: {seq}')
            client_socket.sendall(seq.encode())

# endregion

# region EJERCICIO_7
# Cliente: Genera una llave pública y una llave privada para el cliente y para el servidor las cuales se usarán en el siguiente punto.
def ej7():
    print('LLaves Cliente'.center(50, '-'))
    client_p = int(input("Ingrese un número primo (escencialmente grande): "))
    client_q = int(input("Ingrese otro número primo (escencialmente grande): "))
    # Calcular el valor de n
    client_n = client_p * client_q
    # Calcular phi_sub_n = (p - 1)(q - 1)
    client_phi_sub_n = (client_p - 1) * (client_q - 1)
    # Calcular e
    client_e = encontrar_e(client_phi_sub_n)
    # Calcular d
    client_d = pow(client_e, -1, client_phi_sub_n)

    print(f'LLave Pública: ({client_n}, {client_e})')
    print(f'LLave Privada: ({client_n}, {client_d})')

    print()
    print('LLaves Servidor'.center(50, '-'))
    serv_p = int(input("Ingrese un número primo (escencialmente grande): "))
    serv_q = int(input("Ingrese otro número primo (escencialmente grande): "))
    # Calcular el valor de n
    serv_n = serv_p * serv_q
    # Calcular phi_sub_n = (p - 1)(q - 1)
    serv_phi_sub_n = (serv_p - 1) * (serv_q - 1)
    # Calcular e
    serv_e = encontrar_e(serv_phi_sub_n)
    # Calcular d
    serv_d = pow(serv_e, -1, serv_phi_sub_n)

    print(f'LLave Pública: ({serv_n}, {serv_e})')
    print(f'LLave Privada: ({serv_n}, {serv_d})')

    keys = {
        "ClientPubK": (client_n, client_e),
        "ClientPrivK": (client_n, client_d),
        "ServPubK": (serv_n, serv_e),
        "ServPrivK": (serv_n, serv_d)
    }

    with open('ej7_llaves.txt', 'w') as f:
        for key, (n, v) in keys.items():
            f.write(f'{key}:{n},{v}\n')

def GCD(a, b):
    while b != 0:
        a, b = b, a % b
    return a

def encontrar_e(phi_sub_n):
    while True:
        e = random.randint(2, phi_sub_n - 1)
        if GCD(e, phi_sub_n) == 1:
            return e
        
def leer_llaves():
    keys_loaded = {}

    with open('ej7_llaves.txt', 'r') as f:
        for line in f:
            key, values = line.strip().split(':')
            n, v = map(int, values.split(','))
            keys_loaded[key] = (n, v)

    return keys_loaded
# endregion

# region EJERCICIO_8
# Cliente: Lee un mensaje y lo encripta con la llave pública del servidor. Luego lo envía al servidor. 
# Servidor: Descifra el mensaje y lo imprime. Se supone que el servidor conoce su llave pública generada en el punto anterior. 
# Tamaño de envío: Sin restricción
def ej8():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
        client_socket.connect((SERVER_HOST, SERVER_PORT))
        
        message = int(input("Ingrese el mensaje numerico a encriptar: "))

        keys = leer_llaves()
        serv_pubK = keys['ServPubK']

        encrypted_msg = pow(message, int(serv_pubK[1])) % int(serv_pubK[0])

        client_socket.sendall(str(encrypted_msg).encode())
        print(f'Enviado: {encrypted_msg}')


# endregion

# region EJERCICIO_9
# Cliente:  Lee  un  número  de  cédula  y  su  dígito  de  verificación  de  acuerdo  con  el algoritmo 1 para luego enviarlo al servidor. 
# Servidor: Verifica si el número de celular concuerda con el dígito de verificación. 
# Tamaño de envío: Sin restricción
def ej9():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
        client_socket.connect((SERVER_HOST, SERVER_PORT))
        
        cc = int(input("Ingrese el número de cécula: "))
        check_digit = int(input("Ingrese el número de verificación: "))

        client_socket.sendall(f"{cc}-{check_digit}".encode())
        print(f'Enviado: {f"{cc}-{check_digit}"}')

# endregion

# region EJERCICIO_10
# Cliente: Lee una palabra, y la transforma en una secuencia binaria para transmitir. Aleatoriamente altere uno de los bits que se van a transmitir. 
# Servidor: Mediante el método de Hamming, el programa detecta el bit alterado y lo corrige. Luego de recibir toda la información debe imprimir la palabra original. 
# Tamaño de envío: 1 byte
def ej10():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
        client_socket.connect((SERVER_HOST, SERVER_PORT))
        
        message = input("Ingrese una palabra a transmitir: ")

        # Convertir el mensaje a un binario completo
        bin_message = ''
        for c in message:
            bin_message += bin(ord(c))[2:].zfill(8)
        # print(f'Binario Original: {bin_message}')

        # Como Hamming utiliza 4 bits de Mensaje y 3 de Paridad, si la palabra original se pasa de 4 bits de Mensaje
        # es necesario separar el binario completo en bloques de 4 bits, y tratar cada bloque como 1 mensaje
        blocks = []
        for i in range(0, len(bin_message), 4):
            blocks.append(bin_message[i:i+4])
        # print(f'Bloques de Mensaje: {blocks}')

        # Calcular la Trama completa de Hamming para cada bloque
        hamming_blocks = []
        for block in blocks:
            block.zfill(4)

            hamming_block = generar_hamming(block)
            hamming_blocks.append(hamming_block)
        # print(f'Tramas de Hamming: {hamming_blocks}')

        # Alterar aleatoriamente 1 bit de solo 1 trama
        block_pos_to_alter = random.randint(0, len(hamming_blocks) - 1)
        bit_to_alter = random.randint(0, 6)
        print(f'Bit a Alterar: {bit_to_alter}')
        block_to_alter = hamming_blocks[block_pos_to_alter]
        print(f'Trama a Alterar| Posición: {block_pos_to_alter}, Trama: {block_to_alter}')
        block_to_alter[bit_to_alter] = 1 if block_to_alter[bit_to_alter] == 0 else 0

        # print(f'Tramas de Hamming: {hamming_blocks}')

        for hamming_block in hamming_blocks:
            string_block = ''
            for c in hamming_block:
                string_block += str(c)
            client_socket.sendall(string_block.encode())
            print(f'Enviado: {string_block}')

def generar_hamming(msg):
    # Bits de Mensaje
    M1, M2, M3, M4 = msg

    M1, M2, M3, M4 = int(M1), int(M2), int(M3), int(M4)

    # Bits de Paridad
    P1 = M1 ^ M2 ^ M4
    P2 = M1 ^ M3 ^ M4
    P3 = M2 ^ M2 ^ M4

    # Trama Hamming
    return [P1, P2, M1, P3, M2, M3, M4]
# endregion

while True:
    print('MENU'.center(50, '-'))
    print()
    print("[1]. Ejercicio 1")
    print("[2]. Ejercicio 2")
    print("[3]. Ejercicio 3")
    print("[4]. Ejercicio 4")
    print("[5]. Ejercicio 5")
    print("[6]. Ejercicio 6")
    print("[7]. Ejercicio 7")
    print("[8]. Ejercicio 8")
    print("[9]. Ejercicio 9")
    print("[10]. Ejercicio 10")
    print("[e]. Salir")
    print()
    opc = input("Elija una opción: ")

    if opc == '1':
        ej1()
    elif opc == '2':
        ej2()
    elif opc == '3':
        ej3()
    elif opc == '4':
        ej4()
    elif opc == '5':
        ej5()
    elif opc == '6':
        ej6()
    elif opc == '7':
        ej7()
    elif opc == '8':
        ej8()
    elif opc == '9':
        ej9()
    elif opc == '10':
        ej10()
    elif opc == 'e':
        exit()