def calcularFibonacci(n):
    
    if n == 0: 
        return 0
    if n == 1 or n == 2:
        return 1
    else:
        return calcularFibonacci(n-1) + calcularFibonacci(n-2)
    
print(calcularFibonacci(9))

#---------------------------------------------------------------
    
contAscendente = 0;
contDescendente = 0;

def masCercano(n, pos, ascendente, cont):
    global contAscendente, contDescendente
    
    if pos >= n:
        contAscendente = cont
        return
    elif pos <= 0:
        contDescendente = cont
        return
    
    if ascendente:
        cont += 1
        masCercano(n, pos+1, True, cont)
    elif not ascendente:
        cont += 1
        masCercano(n, pos-1, False, cont)
    

masCercano(1000, 300, True, 0)
masCercano(1000, 300, False, 0)

print(contAscendente)
print(contDescendente)

#---------------------------------------------------------------

def calcularFactorial(n):
    if n == 1:
        return 1
    else:
        return n * calcularFactorial(n-1)
    
print(calcularFactorial(5))

#---------------------------------------------------------------

respuesta = 0

def contarVocales(texto, cont, pos):
    global respuesta
    
    if pos == len(texto):
        respuesta = cont
        return
    else:
        if texto[pos] in ['a', 'e', 'i', 'o', 'u']:
            cont += 1
        contarVocales(texto, cont, pos+1)

contarVocales("Hello World!", 0, 0)
print(respuesta)

#---------------------------------------------------------------

def numeroCatalan(n):
    if n == 0:
        return 1
    else:
        return (calcularFactorial(2*n))/((calcularFactorial(n))*(calcularFactorial(n+1)))
    
print(numeroCatalan(10))

#---------------------------------------------------------------

def calcularTribonacci(n):
    if n == 0 or n == 1:
        return 0
    if n == 2:
        return 1
    else:
        return (calcularTribonacci(n-1) + (calcularTribonacci(n-2) + calcularTribonacci(n-3)))
    
print(calcularTribonacci(10))