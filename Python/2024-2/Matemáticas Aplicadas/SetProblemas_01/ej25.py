#Ej No.25

import random

randInt = random.randint(1, 10)
print("Random Integer: ", randInt)

randFloat = random.random()
print("Random Float: ", randFloat)

randChoice = random.choice([1, 2, 3, 4, 5])
print("Random Choice: ", randChoice)

L = [1, 2, 3, 4, 5]

random.shuffle(L)
print("Random Shuffle: ", L)

