import os


def generate_parity():
    os.system("cls")
    print('GENERATE PARITY'.center(50, '-'))
    print()
    file_name = input("Enter File Name: ")
    parity_type = input("Type of Parity:\n[1]. Even\n[2]. Odd\nEnter Type: ")

    with open(file_name, "rb") as f:
        bytes_data = f.read()
        bytes_seq = ''

        for byte in bytes_data:
            seq = bin(byte)[2:].zfill(8)

            if parity_type == '1':
                parity_bit = str(seq.count('1') % 2)
            elif parity_type == '2':
                if seq.count('1') % 2 == 0:
                    parity_bit = '1'
                else:
                    parity_bit = '0'

            block = parity_bit + seq

            bytes_seq += block

    with open(file_name + ".zo", "w") as f:  # zo = Zero-One
        if parity_type == '2':
            parity_type = '0'
        f.write(bytes_seq + parity_type)

    print(f"A new file '{file_name}.zo' has been created with the parity bit.\nPARITY TYPE: {parity_type}")
    input("Press ENTER to continue...")


def verify_parity():
    os.system("cls")
    print('VERIFY PARITY'.center(50, '-'))
    print()
    file_name_01s = input("Enter 0s & 1s File Name: ")
    file_ext = input("Enter Original File Extension (with dot): ")

    with open(file_name_01s, "r") as f:
        data = f.read()
        L = []
        parity_type = data[-1:]

        data = data[:-1]

        for i in range(0, len(data), 9):
            block = data[i:i+9]

            if parity_type == '1':  # Even - Par
                if block.count('1') % 2 != 0:
                    print(f"Parity ERROR Found in Byte {i} with Parity Type EVEN. Exiting!")
                    exit()
            elif parity_type == '0':  # Odd - Impar
                if block.count('1') % 2 == 0:
                    print(f"Parity ERROR Found in Byte {i} with Parity Type ODD. Exiting!")
                    exit()

            L.append(int(block[1:], 2))

    with open(file_name_01s.split('.')[0] + "_new" + file_ext, "wb") as f:
        f.write(bytes(L))

        print(f"A new file '{file_name_01s.split('.')[0]}_new{file_ext}' has been created.")
        input("Press ENTER to continue...")


while True:
    os.system("cls")
    print('MENU'.center(50, '-'))
    print()
    print("[1]. GENERATE PARITY")
    print("[2]. VERIFY PARITY")
    print("[3]. EXIT")
    opc = input("Choose an option: ")

    if opc == '1':
        generate_parity()
    elif opc == '2':
        verify_parity()
    elif opc == '3':
        exit()
