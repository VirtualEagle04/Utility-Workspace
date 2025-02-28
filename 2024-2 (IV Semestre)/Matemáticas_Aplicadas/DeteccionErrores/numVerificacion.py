# Determinar el dígito de verificación de código:
# 05432122345

num = "05432122345"


def num_verificacion(src):
    odd_sum = sum([int(src[i]) for i in range(0, len(src), 2)])
    prod_3 = odd_sum * 3
    even_sum = sum([int(src[i]) for i in range(1, len(src), 2)])
    total_sum = prod_3 + even_sum
    ver_digit = 10 - (total_sum % 10)
    return f"{src}-{ver_digit}"


print(f'Número Final: {num_verificacion('05432122345')}')

# Paso 1:
# Sumar todos los dígitos en las posiciones impares "para no ingenieros" = (0, 2, ...)
# (dígitos en la pos 1,3,5,7,9 y 11)

# 0 + 4 + 2 + 2 + 3 + 5 = 16

paso1 = 0

for dig in range(0, len(num), 2):
    paso1 += int(num[dig])

print(f"Paso 1: {paso1}")

# Paso 2:
# Multiplicar por 3 el resultado anterior
# 16 * 3 = 48

paso2 = paso1 * 3

print(f"Paso 2: {paso2}")

# Paso 3:
# Sumar todos los dígitos en las posiciones pares "para no ingenieros" = (1, 3, ...) (dígitos en la pos 2,4,6,8 y 10)
# 5 + 3 + 1 + 2 + 4 = 15

paso3 = 0

for dig in range(1, len(num), 2):
    paso3 += int(num[dig])

print(f"Paso 3: {paso3}")

# Paso 4:
# Sumar los resultados de los pasos 2 y 3.
# 48 + 15 = 63

paso4 = paso2 + paso3

print(f"Paso 4: {paso4}")

# Paso 5:
# Determinar qué número hay que añadir al resultado del paso 4 para crear un múltiplo de 10
# 63 + 7 = 70

paso5 = 10 - (paso4 % 10)

print(f"Paso 5: {paso5}")

# Ese número que hay que añadir es el dígito de verificación
# es decir, 7 para este ejemplo
# 05432122345-7

print(f"Número final: {num}-{paso5}")
