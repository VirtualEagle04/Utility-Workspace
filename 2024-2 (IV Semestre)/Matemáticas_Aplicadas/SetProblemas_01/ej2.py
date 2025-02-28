#Ej No.2

qty = int(input("Quantity of products: "))
res = 0
for i in range(qty):
    res += int(input(f"Price for product No. {i+1}: "))

print(f"Total: {res}")