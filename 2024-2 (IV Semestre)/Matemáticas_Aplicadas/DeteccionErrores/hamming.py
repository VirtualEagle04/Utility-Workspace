# Método de Hamming
# Usado para detectar y corregir errores de 1 solo bit dañado.
# Aplica a COMUNICACIONES y ALMACENAMIENTO

# 4 Bits de Mensaje
# 3 Bits de Paridad

# Trama:
# [P1][P2][M1][P3][M2][M3][M4]
# Posición
# [01][02][03][04][05][06][07]
# Total: 7 Bits

# Bits de Paridad:
# P1 = f(3, 5, 7), siempre en Pos = 1
# P2 = f(3, 6, 7), siempre en Pos = 2
# P3 = f(5, 6, 7), siempre en Pos = 4

# C3 = (1, 3, 5, 7)
# C2 = (2, 3, 6, 7)
# C1 = (4, 5, 6, 7)

# Ejemplo:
# Si MSG = 1011
# M1 = 1, Pos = 
# M2 = 0
# M3 = 1
# M4 = 1
# [X][X][1][X][0][1][1]

# P1 = f(3, 5, 7) = 101, Bit de Paridad = 0
# [0][X][1][X][0][1][1]

# P2 = f(3, 6, 7) = 111, Bit de Paridad = 1
# [0][1][1][X][0][1][1]

# P3 = f(5, 6, 7) = 011, Bit de Paridad = 0
# [0][1][1][0][0][1][1]

# Trama MSG EMISOR:
# [0][1][1][0][0][1][1]

# Se Modifica

# Trama MSG RECEPTOR:
# [0][1][1][1][0][1][1]

# C3 = (1, 3, 5, 7) = 0101, Está Bien = 0
# C2 = (2, 3, 6, 7) = 1111, Está Bien = 0
# C1 = (4, 5, 6, 7) = 1011, Está Mal = 1
# Posicion 100, base BIN = 4, base DEC
# Posición del Error = 4

# Se Corrige:
# [0][1][1][0][0][1][1]

def hamming_emisor(msg):
    trama = ['0', '0', '0', '0', '0', '0', '0']
    #      1  2  3  4  5  6  7
    trama[2] = msg[0]
    trama[4] = msg[1]
    trama[5] = msg[2]
    trama[6] = msg[3]

    p1 = (trama[2] + trama[4] + trama[6]).count('1') % 2
    p2 = (trama[2] + trama[5] + trama[6]).count('1') % 2
    p3 = (trama[4] + trama[5] + trama[6]).count('1') % 2

    trama[0] = str(p1)
    trama[1] = str(p2)
    trama[3] = str(p3)

    return trama


def hamming_receptor(trama):

    p1_str = trama[0] + trama[2] + trama[4] + trama[6] # LSB
    p2_str = trama[1] + trama[2] + trama[5] + trama[6]
    p3_str = trama[3] + trama[4] + trama[5] + trama[6] # MSB

    print(p3_str, p2_str, p1_str)

    p3 = str(p3_str.count('1') % 2)
    p2 = str(p2_str.count('1') % 2)
    p1 = str(p1_str.count('1') % 2)

    err_pos_bin = p3 + p2 + p1
    err_pos_dec = int(err_pos_bin, 2) 

    if err_pos_dec == 0:
        print("No existe error.")
    else:
        print(f"Si existe error en la posición {err_pos_dec}")
        trama[err_pos_dec - 1] = '1' if trama[err_pos_dec - 1] == 0 else '0'


trama_emisor = hamming_emisor('1011')
trama_str = "".join(trama_emisor)
print(f"Trama para MSG = 1011: {trama_emisor}")

trama_emisor[0] = str(1)
print(trama_emisor)

hamming_receptor(trama_str)

