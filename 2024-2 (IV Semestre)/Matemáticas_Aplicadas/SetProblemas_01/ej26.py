#Ej No.26

import numpy as np

randArray = np.random.randint(1, 11, size=5)
print("Random Array: ", randArray)

randMatrix = np.random.rand(3,3)
print("Random Matrix:\n", randMatrix)

randNormal = np.random.normal(loc=0.0, scale=1.0, size=10)
print("Random Normal:\n", randNormal)

np.random.seed(37)

print("Random Number with Seed 37: ", np.random.randint(1, 101))
print("Random Number with Seed 37: ", np.random.randint(1, 101))

