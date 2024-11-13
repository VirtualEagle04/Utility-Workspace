#Ej No.11

n = input("Numbers: ")
res = 0
for i in n:
    if int(i) % 2 == 0:
        res += int(i)

print(f"Result: {res}")