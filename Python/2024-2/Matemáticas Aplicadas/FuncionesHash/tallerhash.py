import hashlib
# Taller Práctica No. 1
# Nombres:  Oscar Chavarro y Federico Vargas Rozo

# 1. Cree dos funciones hash y verifique qué características cumple.
# 2. Cree una función hash en Python y genere la salida en hexadecimal.
# 3. Determine el valor hash para un archivo con formato JPG. Cree una función
# cuyos parámetros sean el archivo, el cual puede contener la ruta, y un indicador
# que indique cuál hash va a usar (MD5, SHA256, SHA512)
# 4. Cree un programa que pida una contraseña y guarde su valor hash en un archivo
# plano llamado passwords.dat.

# Solución  1:
# Primera Función Hash
# 1. Recibe un string
# 2. Genera el valor ASCII de cada caracter
# 3. La posición 0 de la cadena de caracteres siempre inicia en 1,
# y a medida que aumenta la posición de la cadena se multiplica x2
# y luego, el valor ASCII del caracter asignado, se multiplica por el valor de la posición.
# 4. Se suman los valores de cada caracter.
# 5. Se eleva la suma al cuadrado para general el código hash.
# Características que cumple
# 1. Determinismo [SI]
# 2. Velocidad [SI]
# 3. Resistencia a la Colisión [SI]
# 4. Dificil de Invertir [SI]
# 5. Efecto Avalancha [SI]

# Segunda Función Hash
# 1. Recibe un string.
# 2. Genera el valor ASCII de cada caracter.
# 3. Se multiplican los valores ASCII.
# 4. Este resultado se eleva al numero de caracteres de la cadena.
# Caracteristicas que cumple
# 1. Determinismo [SI]
# 2. Velocidad [NO]
# 3. Resistencia a la Colisión [NO]
# 4. Dificil de Invertir [NO]
# 5. Efecto Avalancha [SI]

# Solución 2:
def hash1(s):
    mult = 1

    for c in s:
        mult *= (ord(c))

    res = mult ** len(s)

    print(f'Hexadecimal: {hex(res)}')

hash1("ABC")

# Solución 3:
def hashJPG(ruta, metodo):
    with open(ruta, "rb") as f:
        data = f.read()

        h = hashlib.new(metodo, data).hexdigest()

    return h


print(f'MD5: {hashJPG("test/kanye.jpg", "md5")}')
print(F'SHA-256: {hashJPG("test/kanye.jpg", "sha256")}')
print(F'SHA-512: {hashJPG("test/kanye.jpg", "sha512")}')

# Solución 4:

def guardarContrasena(psw):
    with open('password.dat', "w") as f:
        data = psw
        bdata = bytes(data, "utf-8")
        h3 = hashlib.new("sha512", bdata).hexdigest()
        f.write(h3)


guardarContrasena('qwerty')