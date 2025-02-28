
import numpy as np

L= [ x for x in range(1,10) ] #Lista de numeros del 1-9
#print(L)

np.random.shuffle(L) #Desorganizar la lista
#print(L)

M = np.array(L).reshape(3, 3) #Crear una matriz con los elementos de la lista de tamano 3x3
print(M)

#print(M[:,0]) #Imprime la primera columna


#print(sum([ M[0][C] for C in range(3) ])) #Suma de la primera fila

#print(sum([ M[F][0] for F in range(3) ])) #Suma de la primera columna

for F in range(3): #Sumar digitos de cada fila
    print("Suma fila: ", sum([M[F][C] for C in range(3)]))

for C in range(3): #Sumar digitos de cada columna
    print("Suma columna: ", sum(M[F][C] for F in range(3)))

print("Suma Diagonal Negativa: ", sum(M[x][x] for x in range(3))) # Sumar digitos de la diagonal negativa
print("Suma diagonal Positiva: ", sum(M[x][2-x] for x in range(3))) # Sumar digitos de la diagonal positiva


def cumple(M):

    for F in range(3):
        if sum([M[F][C] for C in range(3)]) != 15:
            return False

    for C in range(3):
        if sum(M[F][C] for F in range(3)) != 15:
            return False

    if sum(M[x][x] for x in range(3)) != 15:
        return False
    if sum(M[x][2-x] for x in range(3)) != 15:
        return False

    return True

cont = 0
while True:
    np.random.shuffle(L)
    M = np.array(L).reshape(3, 3)
    cont += 1
    if cumple(M):
        break
print("Numero de intentos", cont)
print(M)