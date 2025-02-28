import time


def selection_sort(arr):
    comparaciones = 0
    intercambios = 0
    n = len(arr)

    for i in range(n):
        # Encontrar el indice del elemento más pequeño en el arreglo desordenado
        min_idx = i
        for j in range(i + 1, n):
            comparaciones += 1
            if arr[j] < arr[min_idx]:
                min_idx = j
        # Intercambiar el elemento encontrado por el primer elemento desordenado
        if i != min_idx:
            arr[i], arr[min_idx] = arr[min_idx], arr[i]
            intercambios += 1

    return comparaciones, intercambios


def leer_archivo():
    with open("PasswordsUEB.txt", "r") as f:
        return [line.strip() for line in f.readlines()]


palabras = leer_archivo()
arr_original = palabras.copy()

# Parte A: Ordenar el arreglo copiado
arr_a = arr_original.copy()
tiempo_inicio = time.time_ns()
comparaciones_a, intercambios_a = selection_sort(arr_a)
tiempo_final = time.time_ns()
tiempo_a = tiempo_final - tiempo_inicio
print("Resultados Parte A".center(50, '-'))
print(f"Comparaciones: {comparaciones_a}\nIntercambios: {intercambios_a}\nTiempo de Ejecución: {tiempo_a} ns")
print()

# Parte A: Ordenar el arreglo copiado
arr_b = arr_a.copy()
tiempo_inicio = time.time_ns()
comparaciones_b, intercambios_b = selection_sort(arr_b)
tiempo_final = time.time_ns()
tiempo_b = tiempo_final - tiempo_inicio
print("Resultados Parte B".center(50, '-'))
print(f"Comparaciones: {comparaciones_b}\nIntercambios: {intercambios_b}\nTiempo de Ejecución: {tiempo_b} ns")
print()
