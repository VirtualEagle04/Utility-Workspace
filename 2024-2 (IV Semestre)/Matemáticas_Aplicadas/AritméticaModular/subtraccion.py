# Aritmética Modular (Operaciones)

import numpy as np

# Substracción
L = [i for i in range(1, 1501)]
np.random.shuffle(L)
ok = True

for _ in range(500):
    a = L.pop()
    b = L.pop()
    n = L.pop()

    if (a-b) % n != (a%n - b%n) % n:
        ok = False
        break

print("Cumple" if ok else "No cumple.")
