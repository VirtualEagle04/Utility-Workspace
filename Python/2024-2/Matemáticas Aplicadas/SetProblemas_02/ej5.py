# Ej No.5
# Contar vocales:
# Escriba una funcion que reciba una cadena y devuelva el numero de vocales
# (a, e, i, o, u) que contiene.

def contar_vocales(cadena):
    vocales = ('a', 'e', 'i', 'o', 'u')
    contador_vocales = 0
    for char in cadena.lower():
        for vocal in vocales:
            if char == vocal:
                contador_vocales += 1

    return contador_vocales


string = input('Ingrese una cadena: ')

print(f'La cadena ingresada contiene un total de {contar_vocales(string)} vocales')
