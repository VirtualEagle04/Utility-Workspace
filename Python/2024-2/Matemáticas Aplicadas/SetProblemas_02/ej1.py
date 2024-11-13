# Ej No.1
# Invertir cadena:
# Cree una funcion que invierta el orden de los caracteres en una cadena sin usar funciones predefinidas como '[::-1]'

def invertir_cadena(cadena):
    input_reves = ''

    for char in cadena:
        input_reves = char + input_reves

    return input_reves


string = input("Ingrese una cadena: ")

print(f'\nCadena inversa: {invertir_cadena(string)}')
