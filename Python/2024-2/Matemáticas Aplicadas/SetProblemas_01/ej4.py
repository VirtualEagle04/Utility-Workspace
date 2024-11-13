#Ej No.4 (suma reducida)

num = input("Number: ")
L = list(num)

while len(L) > 1:
    num = sum(map(int, L))
    L = list(str(num))

print(f"Reduced sum: {L[0]}")
