#Ej No.12
n = 0
while True:
    n = input("String with even length: ")
    if len(n) % 2 != 0:
        print("Number doesn't have an even character count")
    else:
        print(f"Default string: {n}")

        firstHalf = n[:int(len(n)/2)]
        secondHalf = n[int(len(n)/2):]

        print(f"Split string: {firstHalf} - {secondHalf}")