import socket

# Configura el cliente
SERVER_HOST = "172.19.92.44"  # Dirección IP del servidor
SERVER_PORT = 12345  # Puerto del servidor

# Crea un socket TCP
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
    # Conecta al servidor
    client_socket.connect((SERVER_HOST, SERVER_PORT))
    
    while True:
        character_to_send = input("Secuencia: ")
        if character_to_send == '0':
            break

        # Envía el carácter al servidor
        client_socket.sendall(character_to_send.encode())
        print('Carácter enviado:', character_to_send)