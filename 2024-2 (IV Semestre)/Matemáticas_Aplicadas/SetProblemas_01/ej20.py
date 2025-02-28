#Ej No.20

numbers = input('Space separated numbers: ')

L = numbers.split()

div = []

for i in L:
    if int(i) % 5 == 0:
        div.append(i)

print(div)