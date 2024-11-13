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

        union_bloques = []
        nombre_archivo_original = "generadoGato.jpg"

        while True:
            # Recibe bloques del cliente
            data = conn.recv(8)
            if not data:
                break

            print(f"Servidor Recibió Bloque: {data}. Decodificado: {data.decode()}")
            union_bloques.append(int(data.decode(), 2))

        
        with open(nombre_archivo_original, "wb") as f:
            f.write(bytes(union_bloques))

