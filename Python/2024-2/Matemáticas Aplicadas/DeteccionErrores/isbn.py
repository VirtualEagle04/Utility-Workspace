# International Standard Book Number

ISBN = '978-3-16-148410'  # Así es con el código de verificación ya adjunto 978-3-16-148410-0


def num_verificacion_ISBN(src):
    src = src.replace('-', "")[:12]
    return (10 - sum(int(src[i]) * (1 if i % 2 == 0 else 3) for i in range(12)) % 10) % 10


print(f"Número ISBN Final: {ISBN}-{num_verificacion_ISBN(ISBN)}")

# Paso 1:
# Tomar los primeros 12 dígitos del ISBN
dig_12 = ISBN.replace('-', '')[:12]

# Paso 2:
# Multiplicar cada uno de estos dígitos por la secuencia
# de pesos 1,3,1,3,1,3,1,... respectivamente

# Paso 3:
# Suma los productos de cada multiplicación


prod_sum = 0

for i in range(12):
    prod_sum += int(dig_12[i]) * (1 if i % 2 == 0 else 3)

print(prod_sum)

# Paso 4:
# Tome el residuo de la división de esta suma por 10

res = prod_sum % 10

print(res)

# Paso 5:
# Reste el residuo de 10 para obtener el dígito de verificación.
# Si el residuo es 0, el dígito de verificación es 0.

if res == 0:
    sub = 0
else:
    sub = 10 - res

print(sub)
