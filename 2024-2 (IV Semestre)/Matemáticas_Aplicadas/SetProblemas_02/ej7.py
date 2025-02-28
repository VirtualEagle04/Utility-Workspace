# Ej No.7
# Frecuencia de elementos:
# Cree una funcion que reciba una lista y devuelva un diccionario con la
# frecuencia de aparicion de cada elemento en la lista.

def frecuencia(lista):
    diccionario = {}

    for elemento in lista:
        if elemento not in diccionario:
            diccionario.update({elemento: 0})
        else:
            diccionario[elemento] = diccionario.get(elemento) + 1

    return diccionario


lista_entrada = input('Ingrese elementos de una lista separados por espacio: ').split()

print(f'El diccionario generado es el siguiente: {frecuencia(lista_entrada)}')
