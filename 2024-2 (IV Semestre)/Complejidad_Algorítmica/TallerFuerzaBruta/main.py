def esPalindromo(string):
    return string == string[::-1]

entrada_valida = True
horas = 0
minutos = 0

entrada = input("Ingresar (HH:MM): ")

if len(entrada) != 5:
    entrada_valida = False

if entrada.__contains__(":") == False:
    print("Entrada no contiene ':'")
    entrada_valida = False
else:
    horas = int(entrada.split(":")[0])
    minutos = int(entrada.split(":")[1])

if horas < 00 or horas > 23:
    print("Entrada no contiene horas validas (rango: 00-23)!")
    entrada_valida = False

if minutos < 00 or minutos > 59:
    print("Entrada no contiene minutos validos (rango: 00-59)!")
    entrada_valida = False


while entrada_valida == False:
    entrada = input("Ingresar (HH:MM): ")

    if len(entrada) != 5:
        entrada_valida = False
    else:
        entrada_valida = True

    if entrada.__contains__(":") == False:
        print("Entrada no contiene ':'")
        entrada_valida = False
    else:
        horas = int(entrada.split(":")[0])
        minutos = int(entrada.split(":")[1])
        entrada_valida = True

    if horas < 00 or horas > 23:
        print("Entrada no contiene horas validas (rango: 00-23)!")
        entrada_valida = False
    else:
        entrada_valida = True

    if minutos < 00 or minutos > 59:
        print("Entrada no contiene minutos validos (rango: 00-59)!")
        entrada_valida = False
    else:
        entrada_valida = True

for m in range(minutos, 60):

    sh = str(horas).zfill(2)
    sm = str(m).zfill(2)

    string = sh + sm

    if esPalindromo(string):
        print(f"{sh}:{sm}, es palindromo")

for h in range(horas+1, 24):
    for m in range(0, 60):

        sh = str(h).zfill(2)
        sm = str(m).zfill(2)

        string = sh + sm

        if esPalindromo(string):
            print(f"{sh}:{sm}, es palindromo")

    
