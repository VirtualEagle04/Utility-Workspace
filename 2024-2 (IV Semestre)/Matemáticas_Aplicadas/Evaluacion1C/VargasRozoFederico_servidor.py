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
        error_count = 0
        first = False
        nombre_archivo = ''

        while True:
            # Recibe bloques del cliente
            data = conn.recv(9)
            if not data:
                break

            if first == False:
                nombre_archivo = data.decode()
                first = True
            else:

                block = data.decode() 

                if block.count('1') % 2 != 0:
                    print(f'S: Recibió >>>{block} con errores de paridad!')
                    error_count += 1
                else:
                    print(f"S: Recibió >>>{block}")

                union_bloques.append(int(block[1:], 2))

        
        if (error_count == 0):
            with open('restaurado_'+nombre_archivo, "wb") as f:
                f.write(bytes(union_bloques))
        else:
            print(f'Hubo {error_count} errores de paridad. No se restaurará el archivo.')

