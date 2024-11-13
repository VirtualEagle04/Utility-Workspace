# Ej No.6
# Conversion de binario a decimal:
# Cree una funcion que reciba un numero en binario (como cadena) y lo convierta a su
# equivalente en decimal, sin usar funciones predefinidas como int()

def bin_a_dec(binario):
    decimal = 0
    i = 0
    while binario > 0:
        digito = binario % 10
        binario = int(binario//10)
        decimal = decimal + digito * (2**i)
        i += 1

    return decimal


num_binario = int(input('Ingrese un numero binario: '))

print(f"El numero binario '{num_binario}' es '{bin_a_dec(num_binario)}' en decimal.")
