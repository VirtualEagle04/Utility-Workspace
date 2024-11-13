import re
import socket

# Configurar el servidor
HOST = '0.0.0.0'
PORT = 12345

# Crea un socket TCP
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:
    # Enlaza el socket al host y al puerto
    server_socket.bind((HOST, PORT))
    # Escucha conexiones entrantes
    server_socket.listen()

    print("Esperando Conexión...")

    # Acepta la conexión entrante
    conn, addr = server_socket.accept()
    with conn:
        print('Conexión establecida desde', addr)
        while True:
            # Recibe datos del cliente
            data = conn.recv(1024)
            if not data:
                break

            operaciones = ['+', '-', '*', '/', '%']

            receptor = str(data.decode())
            op = "!"

            for operacion in operaciones:
                if receptor.__contains__(operacion):
                    op = operacion
                    break
            if op == '!':
                server_socket.sendall("La cadena no contiene una operacion valida!")
                break

            valores = receptor.split(op)
            
            res = 0

            if op == "+":
                res = int(valores[0]) + int(valores[1])
            elif op == "-":
                res = int(valores[0]) - int(valores[1])
            elif op == "*":
                res = int(valores[0]) * int(valores[1])
            elif op == "/":
                res = int(valores[0]) / int(valores[1])
            elif op == "%":
                res = int(valores[0]) % int(valores[1])

            print(f"El resultado de la operacion es: {res}")
            server_socket.sendall(f"El resultado es: {res.encode()}")

