import hashlib
import os
import numpy as np

while True:
    os.system("cls")
    print('MENU'.center(50, '-'))
    print()
    print("1. CREATE PLAIN TEXT FILE")
    print("2. CREATE HASH FROM FILE")
    print("3. CREATE MATRIX")
    print("4. FILE TO 01 FILE")
    print("5. 01 FILE TO FILE")
    opc = input("Choose an option: ")

    if opc == '1':
        os.system("cls")
        print('CREATE PLAIN TEXT FILE'.center(50, '-'))
        file_name = input("Enter File Name: ")
        content = input("Plain Text: ")

        with open(file_name + ".txt", "w") as f:
            f.write(content)

        print(f"File '{file_name}' has been created")
        input("Press ENTER to continue...")

    if opc == '2':
        os.system("cls")
        print('CREATE HASH FROM FILE'.center(50, '-'))
        file_name = input("File Name: ")
        with open(file_name, "rb") as f:
            data = f.read()
            file_hash = hashlib.new("sha256", data).hexdigest()
            print(f"Hash of File '{file_name}' is: {file_hash}")
        input("Press ENTER to continue...")

    if opc == '3':
        os.system("cls")
        print('CREATE MATRIX'.center(50, '-'))
        n = int(input("Matrix n dimension size: "))
        m = int(input("Matrix m dimension size: "))
        matrix = np.zeros((n, m), dtype=int)

        for col in range(0, n):
            for row in range(0, m):
                matrix[col][row] = int(input(f"Data for Column {col+1} and Row {row+1}: "))

        print(matrix)
        input("Press ENTER to continue...")

    if opc == '4':
        os.system("cls")
        print('FILE TO 01 FILE'.center(50, '-'))
        file_name = input("File Name: ")
        with open(file_name, "rb") as f:
            bytes_data = f.read()
            full_bloques = ""

            for byte in bytes_data:
                seq = bin(byte)[2:].zfill(8)

                full_bloques += seq

        with open('binary.txt', "w") as f:
            f.write(full_bloques)

        print("File 'binary.txt' has been created that contains the binary data")
        input("Press ENTER to continue...")

    if opc == '5':
        os.system("cls")
        print('01 FILE TO FILE'.center(50, '-'))
        file_name = input("01 File Name: ")
        file_ext = input("01 File Extension: ")
        original_file_ext = input("Original File Extension: ")

        with open(file_name + f".{file_ext}", "r") as f:
            data = f.read()
            L = []

            for i in range(0, len(data), 8):
                seq = data[i:i + 8]

                L.append(int(seq[1:], 2))

        with open(file_name + f"_new.{original_file_ext}", "wb") as f:
            f.write(bytes(L))

        print(f"File '{file_name}' has been created")
        input("Press ENTER to continue...")

    if opc == '5':
        break