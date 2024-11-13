import socket
import random

# Configura el cliente
SERVER_HOST = "172.19.92.44"  # Dirección IP del servidor
SERVER_PORT = 12345  # Puerto del servidor

# Crea un socket TCP
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
    # Conecta al servidor
    client_socket.connect((SERVER_HOST, SERVER_PORT))

    nombre_archivo = input("Ingrese el nombre completo del archivo a enviar: ")

    with open(nombre_archivo, "rb") as f:
        bytes_data = f.read()

    client_socket.sendall(nombre_archivo.encode())

    op = input("Desea alterar bits aleatoriamente? (s/n): ")
    
    for byte in bytes_data:
        seq = bin(byte)[2:].zfill(8)
        parity_bit = str(seq.count('1') % 2)

        block = parity_bit + seq

        altered = False
        block_copy = ''
        if op.upper() == 'S':

            alter_chance = random.randint(0, 1)

            if alter_chance == 1:
                altered = True
                block_copy = block
                k = random.randint(0, 8)

                new_bit = '0' if block[k] == '1' else '1'
                block = block[:k] + new_bit + block[k+1:]

        if altered:
            print(f"C: Enviando >>>Alterado: {block} | Original: {block_copy}")
        else:
            print(f"C: Enviando >>>{block}")
        
        client_socket.sendall(block.encode())