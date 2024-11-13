#Ej No.17

n = input("String ONLY of letters: ")

new = 0

for i in n:
    if i.lower() in 'aeiou':
        new += 1

print(f"Number of vocals: {new}")