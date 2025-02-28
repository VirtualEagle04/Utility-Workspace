#Recopilacion de Ejercicios y Demas

import math
import datetime
import re
import time
import random
import numpy
import secrets

# Variables
x = "Hello, World!" #str
x = 20 #int
x = 20.5 #float
x = 1j #complex
x = ["apple", "banana", "cherry"] #list
x = ("apple", "banana", "cherry") #tuple
x = range(6) #range
x = {"name":"John", "age": 36} #dict
x = {"apple", "banana", "cherry"} #set
x = frozenset({"apple", "banana", "cherry"}) #frozenset
x = True #bool
x = b"Hello" #bytes
x = bytearray(5) #bytearray
x = memoryview(bytes(5)) #memoryview
x = None #NoneType

# Asignando Multiples Valores
x, y, z = "apple", "banana", "cherry"
x = y = z = ["a"]

# Manejo de Cadenas (str)
str(7) #Convierte 7 a "7"
"Hello"[0] #Refiere al primer caracter
"Hello"[-1] #Refiere al ultimo caracter
"Hello"[-2] #Refiere al penultimo caracter
"hello".capitalize() #Pone en mayuscula la primera letra
"hello".upper() #Pone en mayuscula el string
"hello".lower() #Pone en minuscula el string
"Hello".center(20, "-") #Centra el string dentro de 20 caracteres -
"Hello".rjust(20, "-") #Alinea a la derecha dentro de 20 caracteres -
"Hello".ljust(20, "-") #Alinea a la izquierda dentro de 20 caracteres -
"Hello"[1:4] #Toma los caracteres del 1 al 3
"Hello"[1:] #Toma los caracteres desde el 1
"Hello".count("i") #Cuenta cuantos caracteres "i" tiene el string
"Hello".find("H") #Busca la primera posicion del caracter H
"Hello".find("H", 7) #Busca la primera posicion del caracter H desde 7
len("Hello") #Longitud del string
"Hello".strip() #Remueve espacios en blanco
"Hello".rstrip() #Remueve espacios en blanco a la derecha
"Hello".lstrip() #Remueve espacios en blanco a la izquierda
"Hello".replace("H", "A", 3) #Reemplaza la letra H por A hasta 3 veces
"25".zfill(4) #Rellena con ceros a la izquierda hasta completar 4 digitos

#Manejo de Listas y Tuplas(list, tuple)

lista = ["Hello", 25, 20.5, True, None]

lista[3] #Refiere al elemento 3
lista[-1] #Refiere al ultimo elemento
lista[-2] #Refiere al penultimo elemento
lista[2:6] #Refiere a los elementos que van desde el 2 al 5
lista.remove("Luis") #Elimina el elemento Luis de la lista
lista.pop() #Elimina el ultimo elemento de la lista
lista.pop(2) #Elimina el elemento 2 de la lista
lista.index("Sofia") #Indica la posicion del elemento Sofia en la lista
lista.insert(2, "Juan") #Insertar el elemento Juan en la posicion 2 de la lista
lista.reverse() #Invierte el orden de una lista
lista.sort() #Ordena los elementos de una lista
sorted(lista) #Ordena los elementos de una lista sin alterar la lista
sum(lista) #Suma los elementos de la lista si estos son numeros
lista.count("Diana") #Cuenta cuantos elementos Diana hay en la lista
lista.append("Diana") #Agrega al final de la lista el elemento Diana
lista.clear() #Borra la lista completamente dejandola vacia
lista.extend(x) #Amplia la lista, donde x puede ser otra lista o tupla
lista + x #Al sumar dos listas, se produce una nueva lista
min(lista) #Muestra el menor elemento de la lista
max(lista) #Muestra el mayor elemento de la lista
len(lista) #Indica el numero de elementos que tiene la lista
x in lista #Indica si el elemento de la variable x esta en la lista
3 * lista #Triplica una lista
"".join(lista) #Concatena los elementos de la lista
#del lista #Borra de memoria una lista

#Manejo de Diccionarios (dict)

x = {"name":"John", "age": 36}

len(x) #Muestra cuantos elementos tiene el diccionario
x.clear() #Remueve todos los elementos del diccionario
x.copy() #Crea una copia del diccionario
x = dict(lista) #Crea un diccionario a partir de una lista de tuplas
5 in x #Retorna verdadero si la llave 5 existe en el diccionario
x.keys() #Muestra los elementos de las llaves del diccionario
x.values() #Muestra los elementos de los valores del diccionario
sorted(x) #Crea una lista ordenada de las llaves
x.pop(5) #Borra el el elemento llave 5 si esta en el diccionario y recoge el valor
x.update(y) #Actualiza el diccionario x con lo del diccionario y
list(x.keys()) #Crea una lista con las llaves del diccionario
list(x.values()) #Crea una lista con los valores del diccionario
x["Cedula"] = 102506 #Agrega el elemento Cedula:102506 al diccionario
del x["Cedula"] #Elimina el item con la llave Cedula
x.get(y) #Para la llave y retorna el valor, u otro resultado por defecto si la llave no existe
x = zip(("id", "name", "age"), ("1", "Andres", 18)) #Crea un diccionario con las llaves siendo una primera tupla, y los valores siendo la segunda tupla

#Bucles for y while

for i in lista:
    x = 1
    #Efectua una instruccion por cada elemento en la lista

for i in "Hello":
    x = 1
    #Efectua una instruccion por cada caracter del string

while len(lista) > 1:
    x = 1
    #Efectua una instruccion hasta que no se cumpla la condicion

#Condicionales if, else elif

if x > 1:
    x = 1
    #Efectua una instruccion si se cumple la condicion
elif x == 1:
    x = 1
    #Efectua o una o la otra instruccion, solo una
else:
    x = 1
    #Efectua una instruccion si no cumple con ninguna condicion

if 'A' not in lista:
    x = 1
    #Efectua una instrucción si A no esta en la lista

#Manejo de Fechas

datetime.datetime.now() #Indica la fecha actual con el formato: año-mes-dia hora:minuto:segundo:microsegundo

x = datetime.datetime(2020, 5, 17) #Crea una fecha

x.strftime("%A") #Formatea la salida de la fecha. En este caso %A indica el dia de la semana completo. Wednesday

days = ['L', 'M', 'Mi', 'J', 'V', 'S', 'D']

d = datetime.date.today().weekday()
n = int(input("Extra days: "))
r = n % 7
i = (r+d) % 7

#Manejo de Caracteres y Regex

re.findall("[A-Z]", "Hola") #Regresa una lista con los caracteres mayusculas del string

ord('A') #Regresa el identificador Unicode/ASCII para el caracter A
ord('$') #Regresa el identificador Unicode/ASCII para el caracter $

#Miscelanea

#Funciones
def esPrimo(n):
    if n == 1: 
        return False
    if n == 2: 
        return True

    for i in range(2,n):
        if n % 1 == 0:
            return False

    return True

def esPrimo2(n):
    if n == 1:
        return False
    if n == 2:
        return True

    for i in range(2,n):
        if n % i == 0:
            return False

    return True

def esPrimo3(n):
    if n == 1: 
        return False

    maxDiv = math.floor(math.sqrt(n))

    for i in range(2,maxDiv + 1):
        if n % i == 0:
            return False

    return True

def esPrimo4(n):
    if n == 1: 
        return False
    if n == 2: 
        return True
    if n > 2 and n % 2 == 0: 
        return False

    maxDiv = math.floor(math.sqrt(n))

    for i in range(3, maxDiv + 1, 2):
        if n % i == 0:
            return False

    return True

#Tiempo
x = time.time()

#Generacion de Elementos Aleatorios

randInt = random.randint(1, 10) #Crea un numero entero aleatorio

randFloat = random.random() #Crea un numero flotante aleatorio

randChoice = random.choice([1, 2, 3, 4, 5]) #Elige aleatoriamente un elemento de la lista

random.shuffle(lista) #Desordena la lista aleatoriamente

randArray = numpy.random.randint(1, 11, size=5) #Crea un array tamaño 5 con numeros aleatorios desde 1 hasta 11

randMatrix = numpy.random.rand(3,3) #Crea una matriz de 3x3 con valores aleatorios entre [0,1)

randNormal = numpy.random.normal(loc=0.0, scale=1.0, size=10) #Selecciona un valor aleatorio de una distribucion normal

numpy.random.seed(37) #Establece una semilla


secureRandInt = secrets.randbelow(10) + 1 #Genera un numero entero seguro desde 1 hasta 10

secureToken = secrets.token_hex(16) #Genera un token seguro aleatorio hexadecimal



