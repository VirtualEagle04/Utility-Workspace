# Paridad
# Introducir un bit valor '1' como el nuevo MSB, a los bytes que
# sumando los '1' (unos) que tiene, es impar, entonces con el nuevo bit
# se convierte en un valor cuya suma de los 1 que tiene es par

# Desventaja: Solo funciona cuando unicamente se cambia 1 bit de un bloque
# si se cambian 2 o más, el sistema de paridad no funcionará
import random

# Un simple mensaje
# cadena = 'Mi nombre es Nerón'

# with open("Salida.txt", "w") as f:
#     for c in cadena:
#         seq = bin(ord(c))[2:].zfill(8)
#         bp = str(seq.count('1') % 2)
#         bloque = bp + seq
#         f.write(bloque + '\n')

bloques_alterados = 0

# Un archivo binario, ej. PNG
with open("Gato.jpg", "rb") as f:
    bytes_data = f.read()
    union_bloques = ""

    for byte in bytes_data:
        cont_bloque = byte
        seq = bin(byte)[2:].zfill(8)
        bp = str(seq.count('1') % 2)

        bloque = bp + seq

        # Ruido
        n = random.randint(1, 100)

        if n == 1:
            # Se modifica el bloque en un solo bit
            k = random.randint(0, 8)
            new_bit = '0' if bloque[k] == '1' else '1'
            bloque = bloque[:k] + new_bit + bloque[k+1:]
            print('Se ha modificado un bit')
            bloques_alterados += 1
        union_bloques += bloque

with open("Gato.txt", "w") as f:
    f.write(union_bloques)

# Verificar paridad
with open("Gato.txt", "r") as f:
    data = f.read()
    L = []

    for i in range(0, len(data), 9):
        bloque = data[i:i+9]

        if bloque.count('1') % 2 != 0:
            print(f'Bloque {i}. Hay errores de paridad!')
            # exit()

        L.append(int(bloque[1:], 2))

with open("Gato_new.jpg", "wb") as f:
    f.write(bytes(L))

print(f'Bloques alterados: {bloques_alterados}')