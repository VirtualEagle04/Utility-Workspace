#Ej No.10

from math import factorial

e = 0
n = 0
prev = 0

while True:
    e += 1/factorial(n)
    n += 1

    if int(10000 * e) == int(10000 * prev):
        break
    prev = e

print(f"e = {e}")