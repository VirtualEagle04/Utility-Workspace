# Write (write)
with open("Salida.txt", "w") as f:
    f.write("Hello,\nWorld!")

# Leer (read)
with open("Salida.txt", "r") as f:
    data = f.read()
    print(data)

# Añadir (add)
with open("Salida.txt", "a") as f:
    f.write("Otra línea\n")


L = []

# for i in range(0,3):
#
#     dat1 = input("Ingrese un dato: ")
#     dat2 = input("Ingrese otro dato: ")
#
#     print("--------------------------------")
#
#     L.append((dat1, dat2))
#
# print(L)

T2 = []
with open("Tuplas.txt", "r") as f:
    dataL = f.readlines()

    for i in range(0, len(dataL)):
        print(i)

