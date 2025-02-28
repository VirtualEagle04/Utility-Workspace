# Ej No.3
# Eliminar duplicados:
# Escriba una funcion que elimine los elementos duplicados en una lista,
# manteniendo solo la primera aparicion de cada elemento

def eliminar_duplicados(lista_original):
    lista_res = []
    for elemento in lista:
        if elemento not in lista_res:
            lista_res.append(elemento)

    return lista_res


lista = input('Elementos de una lista separados por espacio: ').split()

print(f'Lista sin elementos duplicados: {eliminar_duplicados(lista)}.')
