import hashlib
import random
import numpy as np
import os


def sha256_from_file():
    print("Generate SHA256 Hash From File".center(50, '-'))
    file_name = input("File Name (without extension): ")
    file_ext = input("File Extension (with dot): ")
    with open(file_name + file_ext, "rb") as f:
        data = f.read()
        file_hash = hashlib.new("sha256", data).hexdigest()

    with open(file_name + ".hs", "w") as f:
        f.write(file_hash)

    print(f"New File '{file_name}.hs' containing the Hash has been created with the given File.")


def validate_hash():
    print("Validate Hashes Match".center(50, '-'))
    file_name = input("Name of the File to Verify Hash: ")
    hash_file_name = input("Name of the File with the Hash: ")

    # Traer el hash existente y guardarlo temporalmente
    with open(hash_file_name, "r") as f:
        hs_file_hash = f.read()

    # Generar el hash del archivo
    with open(file_name, "rb") as f:
        data = f.read()
        gen_file_hash = hashlib.new("sha256", data).hexdigest()

    if hs_file_hash == gen_file_hash:
        print("The Hashes Match :)")
    else:
        print("The Hashes Doesn't Match! >:(")


def file_to_01_file():
    print('File to 01 File'.center(50, '-'))
    file_name = input("File Name: ")
    with open(file_name, "rb") as f:
        bytes_data = f.read()
        full_bloques = ""

        for byte in bytes_data:
            seq = bin(byte)[2:].zfill(8)

            full_bloques += seq

    with open(file_name + '.txt', "w") as f:
        f.write(full_bloques)

    print(f"File '{file_name}.txt' has been created that contains the binary data")


def solve_corrupted_file():
    print("Solve Corrupted File".center(50, '-'))
    bin_file = input("Plain Text in Binary Format File Name: ")
    hs_file = input("Good Hash File Name: ")
    corrupted_byte = int(input("Position of the Corrupted Byte: "))

    with open(bin_file, "r") as f:
        data = f.read()

    with open(hs_file, "r") as f:
        good_hash = f.read().strip()

    for i in range(256):
        # Convert the binary string to bytes+
        data_bytes = []
        for j in range(0, len(data), 8):
            data_bytes.append(int(data[j:j + 8], 2))

        # Replace the corrupted byte
        data_bytes[corrupted_byte] = i
        # Generate the hash
        hs = hashlib.new("sha256", bytes(data_bytes)).hexdigest()

        if hs == good_hash:
            # Convert the corrected bytes back to binary string
            data_corrected = ""
            for byte in data_bytes:
                data_corrected += bin(byte)[2:].zfill(8)

            with open(bin_file, "w") as f:
                f.write(data_corrected)
            print(f"Corrupted byte restored to {i} / {bin(i)[2:].zfill(8)}")
            return

    print("Could not restore corrupted byte")


def generate_random_phones_file():
    phones = ""
    for i in range(1000):
        phones += str(random.randint(1000000000, 9999999999))
        if i != 999:
            phones += ", "

    with open("phones.txt", "w") as f:
        f.write(phones)


def check_digit(src):
    odd_sum = sum([int(src[i]) for i in range(0, len(src), 2)])
    prod_3 = odd_sum * 3
    even_sum = sum([int(src[i]) for i in range(1, len(src), 2)])
    total_sum = prod_3 + even_sum
    ver_digit = (10 - (total_sum % 10))
    return f"{src}-{ver_digit}"


def generate_check_num():
    print("Generate Telephone Check Number".center(50, '-'))
    tele_file = input("Enter File Name Containing Telephone Numbers: ")

    with open(tele_file, "r") as f:
        data = f.read()

    tele_list = data.split(", ")

    tele_with_check_digit = ""
    for phone in tele_list:
        tele_with_check_digit += check_digit(phone) + ", "

    with open("phones_check.txt", "w") as f:
        f.write(tele_with_check_digit)

    print("File 'phones_check.txt' has been created with same phones with check digit.")


def solve_sum_problem():
    print("Solve Matrix Sum Problem".center(50, '-'))

    target_sum = 198

    matrix = np.zeros((5, 2), dtype=int)
    num_list = (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    while True:
        five_digits = []
        unused_nums = list(num_list)
        used_nums = []
        for row in range(0, 5):
            #print(f"Row {row}")
            # Right Digit
            left = random.choice(unused_nums)
            while left in used_nums:
                left = random.choice(unused_nums)

            matrix[row, 0] = left
            used_nums.append(left)
            unused_nums.remove(left)

            # Left Digit
            right = random.choice(unused_nums)
            while right in used_nums:
                right = random.choice(unused_nums)

            matrix[row, 1] = right
            used_nums.append(right)
            unused_nums.remove(right)

            five_digits.append(int(str(left) + str(right)))

        if sum(five_digits) == target_sum:
            break

    print("The following 2x5 Matrix sum is 198:")
    print(matrix)


while True:
    os.system("cls")
    print("MENU".center(50, '-'))
    print("[1] Generate SHA256 Hash From File")
    print("[2] Validate Hashes Match")
    print("[3] File to 01 File")
    print("[4] Solve Corrupted File")
    print("[5] Generate Telephone Check Number")
    print("[6] Solve Matrix Sum Problem")
    print("[7] Quit")
    op = int(input("Choose an Option: "))

    os.system("cls")
    if op == 1:
        sha256_from_file()
    elif op == 2:
        validate_hash()
    elif op == 3:
        file_to_01_file()
    elif op == 4:
        solve_corrupted_file()
    elif op == 5:
        generate_check_num()
    elif op == 6:
        solve_sum_problem()
    elif op == 7:
        break
