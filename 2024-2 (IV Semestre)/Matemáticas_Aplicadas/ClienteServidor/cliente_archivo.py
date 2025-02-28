import socket

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
    
    for byte in bytes_data:
        seq = bin(byte)[2:].zfill(8)
        print(f"Cliente Enviando Bloque: {seq}. Codificado: {seq.encode()}")
        client_socket.sendall(seq.encode())