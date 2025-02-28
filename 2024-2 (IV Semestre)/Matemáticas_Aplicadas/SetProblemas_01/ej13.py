#Ej No.13

n = input("String ONLY of letters: ")

new = ''

for i in n:
    if i.lower() not in 'aeiou':
        new += i

print(f"String without vocals: {new}")