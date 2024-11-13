#Ej No.18

numbers = input('Space separated numbers: ')

def isPrime(n):
    if n == 1: return False
    if n == 2: return True

    for i in range(2,n):
        if n % 1 == 0:
            return False

    return True


L = numbers.split()

res = 0

for i in L:
    if isPrime(int(i)):
        res += int(i)

print('Sum of prime numbers')