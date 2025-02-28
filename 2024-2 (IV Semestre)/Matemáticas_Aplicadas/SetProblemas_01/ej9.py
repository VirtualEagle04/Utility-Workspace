#Ej No.9

n = input("Number: ")
prod = 1

for i in n:
    prod *= int(i)

print(f"Result of the product of the digits: {prod}")