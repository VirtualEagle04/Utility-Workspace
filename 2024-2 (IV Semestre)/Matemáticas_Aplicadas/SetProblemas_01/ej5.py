#Ej No.5

num = input("Number: ")
res = 0
for i in num:
    if i == '0':
        res += 1

print(f"Number of 0 (zeros) in the number: {res}")

#or

res = num.count('0')
print(f"Number of 0 (zeros) in the number: {res}")