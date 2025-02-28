import time


def bubble_sort_v1(arr):
    comparaciones = 0
    intercambios = 0
    n = len(arr)

    for i in range(n):
        for j in range(0, n - i - 1):
            comparaciones += 1
            if arr[j] > arr[j + 1]:
                intercambios += 1
                arr[j], arr[j + 1] = arr[j + 1], arr[j]

    return comparaciones, intercambios


def bubble_sort_v2(arr):
    comparaciones = 0
    intercambios = 0
    n = len(arr)

    for i in range(n):
        intercambiado = False
        for j in range(0, n - i - 1):
            comparaciones += 1
            if arr[j] > arr[j + 1]:
                intercambios += 1
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                intercambiado = True
        if not intercambiado:
            break

    return comparaciones, intercambios


def leer_archivo():
    with open("PasswordsUEB.txt", "r") as f:
        return [line.strip() for line in f.readlines()]


palabras = leer_archivo()
arr_original = palabras.copy()


# Versión 3
print(" BUBBLE SORT VERSIÓN 1 ".center(50, '='))

# Parte A: Ordenar el arreglo copiado
arr_a = arr_original.copy()
tiempo_inicio = time.time_ns()
comparaciones_a, intercambios_a = bubble_sort_v1(arr_a)
tiempo_final = time.time_ns()
tiempo_a = tiempo_final - tiempo_inicio
print(" Resultados Parte A ".center(50, '-'))
print(f"Comparaciones: {comparaciones_a}\nIntercambios: {intercambios_a}\nTiempo de Ejecución: {tiempo_a} ns")
print()

# Parte A: Ordenar el arreglo copiado
arr_b = arr_a.copy()
tiempo_inicio = time.time_ns()
comparaciones_b, intercambios_b = bubble_sort_v1(arr_b)
tiempo_final = time.time_ns()
tiempo_b = tiempo_final - tiempo_inicio
print(" Resultados Parte B ".center(50, '-'))
print(f"Comparaciones: {comparaciones_b}\nIntercambios: {intercambios_b}\nTiempo de Ejecución: {tiempo_b} ns")
print()


# Versión 2
print(" BUBBLE SORT VERSIÓN 2 ".center(50, '='))

# Parte A: Ordenar el arreglo copiado
arr_a = arr_original.copy()
tiempo_inicio = time.time_ns()
comparaciones_a, intercambios_a = bubble_sort_v2(arr_a)
tiempo_final = time.time_ns()
tiempo_a = tiempo_final - tiempo_inicio
print(" Resultados Parte A ".center(50, '-'))
print(f"Comparaciones: {comparaciones_a}\nIntercambios: {intercambios_a}\nTiempo de Ejecución: {tiempo_a} ns\n")

# Parte A: Ordenar el arreglo copiado
arr_b = arr_a.copy()
tiempo_inicio = time.time_ns()
comparaciones_b, intercambios_b = bubble_sort_v2(arr_b)
tiempo_final = time.time_ns()
tiempo_b = tiempo_final - tiempo_inicio
print(" Resultados Parte B ".center(50, '-'))
print(f"Comparaciones: {comparaciones_b}\nIntercambios: {intercambios_b}\nTiempo de Ejecución: {tiempo_b} ns\n")
