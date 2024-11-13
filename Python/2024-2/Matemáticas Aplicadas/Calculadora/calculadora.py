import os

while True:
    os.system("cls")
    print('MENU'.center(50, '-'))
    print()
    print("1. SUM")
    print("2. SUB")
    print("3. MULT")
    print("4. DIV")
    print("5. EXIT")
    opc = input("Choose an option: ")

    if opc == '1':
        os.system("cls")
        print('SUM'.center(50, '-'))
        a = int(input("Value N°1: "))
        b = int(input("Value N°2: "))
        print("Sum is: ", a+b)
        input("Press ENTER to continue...")

    if opc == '2':
        os.system("cls")
        print('SUB'.center(50, '-'))
        a = int(input("Value N°1: "))
        b = int(input("Value N°2: "))
        print("Subtraction is: ", a-b)
        input("Press ENTER to continue...")

    if opc == '3':
        os.system("cls")
        print('MULT'.center(50, '-'))
        a = int(input("Value N°1: "))
        b = int(input("Value N°2: "))
        print("Multiplication is: ", a*b)
        input("Press ENTER to continue...")

    if opc == '4':
        os.system("cls")
        print('DIV'.center(50, '-'))
        a = int(input("Value N°1: "))
        b = int(input("Value N°2: "))
        print("Division is: ", a/b)
        input("Press ENTER to continue...")

    if opc == '5':
        break