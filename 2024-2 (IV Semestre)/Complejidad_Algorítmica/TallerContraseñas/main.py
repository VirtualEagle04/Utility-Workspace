import pymysql  # Conexión con MySQL
import re  # Expresiones Regulares
import hashlib  # Funciones de Hasheo
import time  # Registro de tiempos
import configparser  # Archivos .properties e .ini

# Cargar configuración desde el archivo .properties
config = configparser.ConfigParser()
config.read("config.properties")


cleaned_passwords = []


# Función para traer las contraseñas y eliminar las mas tontas
def clean_passwords():
    # Traer todas las contraseñas del archivo .txt
    with open(config.get("DEFAULT", "passwords.file"), "r") as file:
        for line in file:
            password = line.strip()  # Quitamos espacios y valores en blanco antes y después de la contraseña (por si tiene...)

            if cleaned_passwords.__contains__(
                password
            ):  # Ya existe la misma contraseña
                # print(f"Contraseña: {password} ya está en la lista. ELIMINANDO")
                continue
            if len(password) < 4:  # Menor a 4 caracteres
                # print(f"Contraseña: {password} tiene menos de 4 caracteres. ELIMINANDO")
                continue
            if len(set(password)) == 1:  # Solo un tipo de caracter (ej: $$$$$)
                # print(f"Contraseña: {password} solo tiene 1 tipo de caracter. ELIMINANDO")
                continue
            if re.fullmatch(r"\d*", password):  # Solo números (ej: 12345)
                # print(f"Contraseña: {password} tiene solo números. ELIMINANDO")
                continue

            cleaned_passwords.append(password)
            # print(f"Contraseña: {password} es valida. AGREGANDO")


hashed_passwords_dict = {}


# Función para hashear las claves limpias usando MD5 y asignarlas usando un diccionario
def hash_cleaned_passwords():
    for password in cleaned_passwords:
        hashed_passwords_dict[password] = hashlib.md5(password.encode()).hexdigest()
        # print(f'{password} : {hashlib.md5(password.encode()).hexdigest()}')


# Función para realizar la comparación de Hashes y verificar la contraseña
def execute_attack():
    # Crear conexión con la base de datos
    connection = pymysql.connect(
        host=config.get("DEFAULT", "db.host"),
        user=config.get("DEFAULT", "db.user"),
        password=config.get("DEFAULT", "db.password"),
        database=config.get("DEFAULT", "db.database"),
    )

    try:
        with connection.cursor() as cursor:
            cursor.execute("SELECT login, clave FROM Usuario;")  # Realizar consulta
            rows = cursor.fetchall()  # Traer los resultados de la consulta

            for row in rows:
                print("".center(50, "-"))
                login = row[0]  # Tomo el usuario (ej: 'usuario1')
                clave = row[
                    1
                ]  # Tomo la clave hash (ej: '6253e1406b64bbe6ba7b00ac0bf81257')

                total_comp = 0
                comp_incorrect = 0
                comp_correct = 0
                start_time = time.time_ns()
                found_pw = False

                for pw, hashed_pw in hashed_passwords_dict.items():
                    total_comp += 1
                    if clave == hashed_pw:
                        comp_correct += 1
                        print(f"HASH IGUAL | {clave} = {hashed_pw}\n")
                        print(f"La contraseña para el '{login}' es '{pw}'\n")
                        found_pw = True
                        break
                    else:
                        comp_incorrect += 1

                end_time = time.time_ns()
                execution_time = end_time - start_time

                if found_pw:
                    print(
                        f"Tiempo de ejecución para encontrar la contraseña del '{login}' fue '{execution_time}' ns.\n"
                    )
                    print(
                        f"Se realizaron:\nComparaciones Incorrectas: {comp_incorrect}\nComparaciones Correctas: {comp_correct}\nComparaciones Totales: {total_comp}"
                    )
                else:
                    print(
                        f"No se encontró la contraseña del '{login}'. Tiempo de ejecución fue '{execution_time}' ns.\n"
                    )
                    print(
                        f"Se realizaron:\nComparaciones Incorrectas: {comp_incorrect}\nComparaciones Correctas: {comp_correct}\nComparaciones Totales: {total_comp}"
                    )

    finally:
        connection.close()


clean_passwords()
hash_cleaned_passwords()
execute_attack()
