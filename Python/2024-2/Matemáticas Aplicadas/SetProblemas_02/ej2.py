# Ej No.2 y Ej No.4
# Buscar una palabra en un archivo:
# Cree una funcion que busque una palabra especificada en un archivo de texto
# y devuelva la linea o lineas donde aparece.
# -----
# Desarrolle una función que lea un archivo de texto y
# cuente cuántas palabras contiene en total.

def buscar_palabra_archivo(palabra):
    with open('archivo.txt', 'r') as f:
        archivo = f.read()

        if archivo.__contains__(palabra):
            print(f"El archivo sí contiene la palabra '{palabra}', un total de {archivo.count(palabra)} veces.")

            lista = archivo.splitlines()
            print(f"La(s) linea(s) donde aparece la palabra '{palabra}', son:  ")
            for linea in lista:
                if linea.__contains__(palabra):
                    print(linea)
        else:
            print(f'El archivo no contiene la palabra {palabra}.')


string = input("Palabra: ")

buscar_palabra_archivo(string)
