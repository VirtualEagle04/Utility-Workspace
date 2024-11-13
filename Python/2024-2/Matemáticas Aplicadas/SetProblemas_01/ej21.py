#Ej No.21

import time
def isPrime(n):
    if n == 1: return False
    if n == 2: return True

    for i in range(2,n):
        if n % i == 0:
            return False

    return True


t0 = time.time()

for i in range(1, 10_000):
    isPrime(i)

t1 = time.time()

print(f"Execution time: {t1-t0}")