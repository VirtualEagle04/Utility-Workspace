# Problema 4
# Crear una función que cifre y descifre un mensaje de acuerdo con al algoritmo
# XOR visto en clase y teniendo una llave compuesta.
def cifraDescifraXOR(mensaje, llave):

    res = ''
    # Para cada caracter...
    for c in range(len(mensaje)):
        # Convertirlo a binario de 8 bits
        charBinMensaje = ord(mensaje[c])

        # Convertir la clave a binario de 8 bits tambien
        charBinLlave = ord(llave[c % len(llave)])

        res += chr(charBinMensaje ^ charBinLlave)

    return res


print("---Cifrado XOR---")
mensaje = input("Ingrese un mensaje: ")
llave = input("Ingrese una llave: ")

e = cifraDescifraXOR(mensaje, llave)
d = cifraDescifraXOR(e, llave)

print(f'\nMensaje Encriptado: {e}')
print(f'Mensaje Encriptado: {d}\n')


# Problema 5
# Crear una función que codifique un mensaje de texto en Base64 sin usar
# ninguna librería de Python.

def tobase64(n: int) -> str:
    import string
    base64 = string.ascii_uppercase + string.ascii_lowercase + string.digits + "+/"
    return base64[n]


print("---Cifrado Base64---")
mensaje = input("Ingrese un mensaje: ")
res = ''
for c in mensaje:
    res += bin(ord(c))[2:].zfill(8)
print(f'\nMensaje en BIN: {res}\n')

junto = ''
for i in range(0, len(res), 6):
    print(f"BIN: {res[i:i+6]}, DEC: {int(res[i:i+6].zfill(8), 2)}, CHR: {tobase64(int(res[i:i+6].zfill(8), 2))}")
    junto += tobase64(int(res[i:i+6].zfill(8), 2))

print(f'\nMensaje Cifrado: {junto}\n')