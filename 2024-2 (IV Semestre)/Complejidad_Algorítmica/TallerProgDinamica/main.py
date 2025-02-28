# Taller - Programación Dinámica
def divFactorial(n):
    dictFact = {0:1, 1:1}
    for i in range(2, n+1):
        dictFact[i] = dictFact[i - 1] * i

    divCont = 0
    for i in range(dictFact[n], 0, -1):
        if dictFact[n] % i == 0:
            divCont += 1

    print(f'El factorial de "{n}" es "{dictFact[n]}", y tiene "{divCont}" divisores.')

n = int(input('Ingrese el valor al que le desea calcular el número de divisores del Factorial: '))
divFactorial(n)