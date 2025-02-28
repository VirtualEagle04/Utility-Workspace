# Ej No.22

import math, time


def isPrime(n):
    if n == 1: return False
    if n == 2: return True
    if n > 2 and n % 2 == 0: return False

    maxDiv = math.floor(math.sqrt(n))

    for i in range(3, maxDiv + 1, 2):
        if n % i == 0:
            return False

    return True


t0 = time.time()

c = 0
n = 2

while c < 50:
    if isPrime(n):
        c += 1
        print(f"[{c}]. {n}")
    n += 1

t1 = time.time()

print(f"Execution time: {t1 - t0}")