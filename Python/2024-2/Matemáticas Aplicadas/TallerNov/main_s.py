# Taller Cliente-Servidor
# SERVIDOR
# Federico Vargas Rozo
import socket
from base64 import b64decode
import numpy as np
import hashlib

# region CONFIGURACIÓN_SERVIDOR
HOST = '0.0.0.0'
PORT = 12345
# endregion

# region EJERCICIO_1
# Cliente: Lee un número entero positivo que indica una posición y se lo envía al servidor. 
# Servidor: Imprime el número primo de la posición que recibió.  
# Tamaño de envío: Sin restricción
def ej1():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:
        server_socket.bind((HOST, PORT))
        server_socket.listen()
        print("Esperando conexión...")
        conn, addr = server_socket.accept()
        with conn:
            print('Conexión establecida desde', addr)
            data = conn.recv(1024).decode()
            print(f'Recibido: {data}')
            print(f'El número primo en el índice {data} es: {num_primo_indice(int(data)-1)}')

def es_primo(num):
    if num < 2:
        return False
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return False
    return True

def num_primo_indice(index):
    count = 0
    num = 2
    while True:
        if es_primo(num):
            if count == index:
                return num
            count += 1
        num += 1
# endregion

# region EJERCICIO_2
# Cliente:  Lee  una  palabra  y  un  número  entero  positivo  que  representa  un desplazamiento. 
# Servidor: Imprime la palabra cifrada con el algoritmo Cesar y con el desplazamiento que se le indicó. 
# Tamaño de envío: Sin restricción
def ej2():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:
        server_socket.bind((HOST, PORT))
        server_socket.listen()
        print("Esperando conexión...")
        conn, addr = server_socket.accept()
        with conn:
            print('Conexión establecida desde', addr)

            message = conn.recv(1024).decode()
            print(f'Recibido: {message}')
            step = conn.recv(1024).decode()
            print(f'Recibido: {step}')

            print(f'La palabra cifrada con un desplazamiento de {step} es: {cifrado_cesar(message, int(step))}')

def cifrado_cesar(message, step):
    res = ''

    for c in message:
        if c.isalpha(): # Es letra (no caractér especial)
            is_upper = c.isupper()

            current_pos = ord(c.lower()) - ord('a') # ASCII del caractér en minuscula - ASCII de 'a' (que es 97)
            new_pos = (current_pos + step) % 26 # índice (comenzando en 1) de la letra en el Abecedario (sin la ñ)
            new_char = chr(new_pos + ord('a')) # ASCII de la letra en el Abecedario

            if is_upper: # Si es Mayuscula, convertir el caractér a Mayusculas
                new_char = new_char.upper()
            
            res += new_char
        else: # Es carácter especial, lo pegamos igual
            res += c
    
    return res
# endregion

# region EJERCICIO_3
# Cliente: Pide el nombre del archivo (jpg, pdf, xlsx, etc.), lo codifica en base64 y se lo envía al servidor.
# Servidor: Restaura el archivo correspondiente con el formato original (jpg, pdf, etc.) 
# Tamaño de envío: 1 byte
def ej3():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:
        server_socket.bind((HOST, PORT))
        server_socket.listen()
        print("Esperando conexión...")
        conn, addr = server_socket.accept()
        with conn:
            print('Conexión establecida desde', addr)

            file_name = conn.recv(1024).decode()
            print(f'Recibido: {file_name}')

            bytes_data = []

            while True:
                data = conn.recv(8)
                if not data:
                    break

                print(f'Recibido: {data}')
                bytes_data.append(data)
            
            with open('servidor_' + file_name, 'wb') as file:
                file.write(b64decode(b"".join(bytes_data)))
                print(f'Se ha restaurado el archivo {file_name} con un nuevo nombre {'servidor_' + file_name}')

# endregion

# region EJERCICIO_4
# Cliente: Lee el nombre de un archivo donde está la llave que se usará para encriptar un mensaje. Encripta un mensaje usando el algoritmo de Hill y lo envía al servidor. 
# Servidor: El servidor también tiene la llave guardada en un archivo de texto, por lo que debe leer el archivo para poder desencriptar el mensaje. 
# Tamaño de envío: 1 byte
def ej4():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:
        server_socket.bind((HOST, PORT))
        server_socket.listen()
        print("Esperando conexión...")
        conn, addr = server_socket.accept()
        with conn:
            print('Conexión establecida desde', addr)

            encrypted_msg = conn.recv(4).decode()
            print(f'Recibido: {encrypted_msg}')

            key_file_name = input("Ingrese el nombre del archivo con la llave: ")

            decrypted_msg = descrifrado_hill(encrypted_msg.upper(), leer_matriz(key_file_name))
            print(f"El Mensaje Descifrado es: {decrypted_msg}")

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
    # if det != 0:
    #     inverse_matrix = np.linalg.inv(matrix)
    #     return inverse_matrix
    # No me funcióno la inversa, me tira valores unicamente ceros

    # Calcular la inversa manualmente
    scalar = 0
    if det == 0 or not len(matrix) == 2:
        return None
    for i in range(26):
        ecuation = (i * det) % 26
        if ecuation == 1:
            scalar = i
            break
        else:
            None
    return [[(matrix[1][1] * scalar) % 26, ((-1 * matrix[0][1] % 26) * scalar) % 26],
            [((-1 * matrix[1][0] % 26) * scalar) % 26, (matrix[0][0] * scalar) % 26]]

def multiplicacion_matrices(matrixA, matrixB):
    # return np.dot(matrixA, matrixB)

    result = [0, 0]
    for i in range(2):
        for j in range(2):
            result[i] += matrixA[i][j] * matrixB[j]
            result[i] %= 26
    return result

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
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:
        server_socket.bind((HOST, PORT))
        server_socket.listen()
        print("Esperando conexión...")
        conn, addr = server_socket.accept()
        with conn:
            print('Conexión establecida desde', addr)

            data = conn.recv(8).decode()
            print(f'Recibido: {data}')

            print(f"Mensaje descifrado: {xor_cifrado_descifrado(data)}")

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
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:
        server_socket.bind((HOST, PORT))
        server_socket.listen()
        print("Esperando conexión...")
        conn, addr = server_socket.accept()
        with conn:
            print('Conexión establecida desde', addr)

            file_name = conn.recv(1024).decode()
            print(f'Recibido: {file_name}')

            joined_bytes = []
            while True:
                data = conn.recv(8).decode()
                if not data:
                    break

                if data.__contains__('|'):
                    print('Recibido "|", rompiendo ciclo')
                    break

                print(f'Recibido: {data}')
                joined_bytes.append(int(data, 2))

            file_hash = ''
            for i in range(8):
                seq = conn.recv(8).decode()
                if not seq: 
                    break
                print(f'Recibido: {seq}')
                file_hash += seq
            
            with open('servidor_' + file_name, "wb") as f:
                f.write(bytes(joined_bytes))
                print(f'Se ha restaurado el archivo {file_name} con un nuevo nombre {'servidor_' + file_name}')

            with open('servidor_' + file_name, "rb") as f:
                calculated_hash = hashlib.file_digest(f, "sha256").hexdigest()

                print(f'Hash Calculado: {calculated_hash}')
                print(f'Hash Recibido: {file_hash}')
                if file_hash == calculated_hash:
                    print('Los Hashes SHA-256 son iguales. El archivo es el mismo.')
                else:
                    print('Los Hashes SHA-256 son diferentes. El archivo no es el mismo.')
            

# endregion

# region EJERCICIO_7
# Cliente: Genera una llave pública y una llave privada para el cliente y para el servidor las cuales se usarán en el siguiente punto.
def ej7():
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
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:
        server_socket.bind((HOST, PORT))
        server_socket.listen()
        print("Esperando conexión...")
        conn, addr = server_socket.accept()
        with conn:
            print('Conexión establecida desde', addr)

            encrypted_msg = conn.recv(1024).decode()
            print(f'Recibido: {encrypted_msg}')

            keys = ej7()
            serv_privK = keys['ServPrivK']

            decrypted_msg = pow(int(encrypted_msg), int(serv_privK[1])) % int(serv_privK[0])
            print(f'Mensaje Decencriptado: {decrypted_msg}')

# endregion

# region EJERCICIO_9
# Cliente:  Lee  un  número  de  cédula  y  su  dígito  de  verificación  de  acuerdo  con  el algoritmo 1 para luego enviarlo al servidor. 
# Servidor: Verifica si el número de celular concuerda con el dígito de verificación. 
# Tamaño de envío: Sin restricción
def ej9():
   with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:
        server_socket.bind((HOST, PORT))
        server_socket.listen()
        print("Esperando conexión...")
        conn, addr = server_socket.accept()
        with conn:
            print('Conexión establecida desde', addr)
            data = conn.recv(1024).decode()
            print(f'Recibido: {data}')
            
            cc, check_digit = data.split('-')

            true_check_digit = num_verificacion(cc)

            if check_digit == true_check_digit.split('-')[1]:
                print('El número de verificación es correcto')
            else:
                print(f'El número de verificación es incorrecto. El verdadero es: {true_check_digit}')


def num_verificacion(src):
    odd_sum = sum([int(src[i]) for i in range(0, len(src), 2)])
    prod_3 = odd_sum * 3
    even_sum = sum([int(src[i]) for i in range(1, len(src), 2)])
    total_sum = prod_3 + even_sum
    ver_digit = 10 - (total_sum % 10)
    return f"{src}-{ver_digit}"
# endregion

# region EJERCICIO_10
# Cliente: Lee una palabra, y la transforma en una secuencia binaria para transmitir. Aleatoriamente altere uno de los bits que se van a transmitir. 
# Servidor: Mediante el método de Hamming, el programa detecta el bit alterado y lo corrige. Luego de recibir toda la información debe imprimir la palabra original. 
# Tamaño de envío: 1 byte
def ej10():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:
        server_socket.bind((HOST, PORT))
        server_socket.listen()
        print("Esperando conexión...")
        conn, addr = server_socket.accept()
        with conn:
            print('Conexión establecida desde', addr)

            hamming_blocks = []
            while True:
                hamming_block = conn.recv(7).decode()
                if not hamming_block:
                    break

                print(f'Recibido: {hamming_block}')
                hamming_blocks.append(hamming_block)
            
            full_binary_msg = ''
            for block in hamming_blocks:
                correct_block = detectar_corregir_hamming(block)
                full_binary_msg += correct_block
            
            original_msg = ''
            for i in range(0, len(full_binary_msg), 8):
                c = chr(int(full_binary_msg[i:i+8], 2))
                original_msg += c
            
            print(f'Palabra Original Restaurada: {original_msg}')

def detectar_corregir_hamming(block):
    P1, P2, M1, P3, M2, M3, M4 = block
    trama = [P1, P2, M1, P3, M2, M3, M4]

    # Recalcular los Bits de Paridad
    str_P1 = trama[0] + trama[2] + trama[4] + trama[6] # LSB
    str_P2 = trama[1] + trama[2] + trama[5] + trama[6]
    str_P3 = trama[3] + trama[4] + trama[5] + trama[6] # MSB

    new_P3 = str(str_P3.count('1') % 2)
    new_P2 = str(str_P2.count('1') % 2)
    new_P1 = str(str_P1.count('1') % 2)

    # Encontrar posición del error
    err_pos_bin = str(new_P3) + str(new_P2) + str(new_P1)
    err_pos_dec = int(err_pos_bin, 2)
    
    if err_pos_dec:
        print(f"Si Existe Error en Bloque: {block}, en la pos: {err_pos_dec - 1}")
        trama[err_pos_dec - 1] = '1' if trama[err_pos_dec - 1] == 0 else '0'
    else:
        print(f"No Existe Error en Bloque: {block}")

    # Retornar los Bits de Mensaje
    return f'{trama[2]}{trama[4]}{trama[5]}{trama[6]}'

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