import socket

# Configura el servidor
HOST = '0.0.0.0'  # Escucha en todas las interfaces de red disponibles
PORT = 12345  # Puerto de escucha

# Crea un socket TCP
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:
    # Enlaza el socket al host y al puerto
    server_socket.bind((HOST, PORT))
    # Escucha conexiones entrantes
    server_socket.listen()

    print("Esperando conexión...")

    # Acepta la conexión entrante
    conn, addr = server_socket.accept()
    with conn:
        print('Conexión establecida desde', addr)
        while True:
            # Recibe datos del cliente
            data = conn.recv(1024)
            if not data:
                break
            print('Carácter recibido:', data.decode())

