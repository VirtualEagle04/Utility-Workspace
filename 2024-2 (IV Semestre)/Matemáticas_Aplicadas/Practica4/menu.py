import os


def pdf_to_checksum_01():
    os.system("cls")
    print("PDF FILE TO 01 FILE WITH CHECKSUM".center(50, "-"))
    print()
    pdf_name = input("Enter PDF File Name: ")

    with open(pdf_name, "rb") as f:
        bytes_data = f.read()
        bytes_seq = ""

        # Initialize checksum to 0
        checksum = 0

        for byte in bytes_data:
            seq = bin(byte)[2:].zfill(8)

            bytes_seq += seq

            # Add the byte to the checksum
            checksum += byte

            # If checksum is more than 8 bits (255 max), keep adding the overflowing bits
            checksum = (checksum % 255) + (checksum // 255)

        print(f"Final Checksum: {checksum} --- to BIN --> {bin(checksum)[2:].zfill(8)}")

        # Make the complement of 1 of each bit to get the checksum
        checksum = 255 - checksum
        print(
            f"Checksum Complement: {checksum} --- to BIN --> {bin(checksum)[2:].zfill(8)}"
        )

        # Join checksum to the start of the message
        bytes_seq = bin(checksum)[2:].zfill(8) + bytes_seq

    with open(pdf_name + ".zo", "w") as f:
        f.write(bytes_seq)

    print(
        f"File '{pdf_name}.zo' has been created that contains the 01 data and a 8-bit checksum."
    )
    input("Press ENTER to continue...")


def validate_01_checksum():
    os.system("cls")
    print("VALIDATE 01 FILE WITH CHECKSUM")
    print()
    file_name = input("Enter 01 File Name: ")

    with open(file_name, "r") as f:
        data = f.read()

        # Extract the checksum from the beginning of the data
        checksum = int(data[:8], 2)
        print(f"Checksum: {checksum} --- to BIN --> {bin(checksum)[2:].zfill(8)}")

        # Extract the rest of the data
        bytes_seq = data[8:]

        # Calculate the checksum of the rest of the data
        calculated_checksum = 0
        for i in range(0, len(bytes_seq), 8):
            byte = int(bytes_seq[i : i + 8], 2)
            calculated_checksum += byte
            calculated_checksum = (calculated_checksum % 255) + (
                calculated_checksum // 255
            )

        # Make the complement of 1 of each bit to get the calculated checksum
        calculated_checksum = 255 - calculated_checksum

        # Compare the extracted checksum with the calculated checksum
        if checksum == calculated_checksum:
            print("The checksum matches the rest of the file's information.")
        else:
            print("The checksum does not match the rest of the file's information.")

    input("Press ENTER to continue...")


def xor(a, b):
    result = []
    for i in range(1, len(b)):
        result.append("0" if a[i] == b[i] else "1")
    return "".join(result)


def mod2div(dividend, divisor):
    pick = len(divisor)
    temp = dividend[0:pick]

    while pick < len(dividend):
        if temp[0] == "1":
            temp = xor(divisor, temp) + dividend[pick]
        else:
            temp = xor("0" * pick, temp) + dividend[pick]
        pick += 1

    if temp[0] == "1":
        temp = xor(divisor, temp)
    else:
        temp = xor("0" * pick, temp)

    return temp


def calculate_crc():
    os.system("cls")
    print("CALCULATE CRC (Cycle Redundancy Check) FROM 01 FILE")
    print()
    file_name = input("Enter 01 File Name: ")
    generator_poly = input("Enter Generator Poly: ")

    with open(file_name, "r") as f:
        data = f.read()

    # Generate CRC
    appended_data = data + "0" * (len(generator_poly) - 1)
    crc = mod2div(appended_data, generator_poly)


    with open(file_name + ".crc", "w") as f:
        f.write(data + crc)

    print(
        f"File '{file_name}.crc' has been created that contains the 01 data and the CRC generated."
    )
    input("Press ENTER to continue...")


def validate_crc():
    os.system("cls")
    print("VALIDATE CRC FROM FILE")
    print()
    file_name = input("Enter 01 with CRC File Name: ")
    generator_poly = input("Enter Generator Poly: ")

    with open(file_name, "r") as f:
        data = f.read()


    # Extract the CRC from the end of the data
    crc = data[-(len(generator_poly) - 1) :]

    # Extract the rest of the data
    data = data[:-3]

    # Generate CRC again
    appended_data = data + "0" * (len(generator_poly) - 1)
    generated_crc = mod2div(appended_data, generator_poly)


    # Compare CRC
    if crc == generated_crc:
        print("The CRC matches the rest of the file's information.")
    else:
        print("The CRC does not match the rest of the file's information.")

    input("Press ENTER to continue...")


while True:
    os.system("cls")
    print("MENU".center(50, "-"))
    print()
    print("[1]. PDF FILE TO 01 FILE WITH CHECKSUM")
    print("[2]. VALIDATE 01 FILE WITH CHECKSUM")
    print("[3]. CALCULATE CRC (Cycle Redundancy Check) FROM FILE")
    print("[4]. VALIDATE CRC FROM FILE")
    print("[5]. EXIT")
    opc = input("Choose an option: ")

    if opc == "1":
        pdf_to_checksum_01()
    elif opc == "2":
        validate_01_checksum()
    elif opc == "3":
        calculate_crc()
    elif opc == "4":
        validate_crc()
    elif opc == "5":
        exit()
