#Ej No.3

L = [49, 5.2, 'Hello World!', True, False]
res = 0
for i in L:
    if type(i) == int | type(i) == float:
        res += i

print(f"Sum is: {res}")



