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

for i in range(1, 10_000):
    isPrime(i)

t1 = time.time()

print(f"Execution time: {t1 - t0}")