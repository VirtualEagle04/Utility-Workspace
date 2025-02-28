import random
import time


def selection_sort(arr):
    comparisons = 0
    swaps = 0
    n = len(arr)

    start_time = time.time_ns()

    for i in range(n):
        min_idx = i
        for j in range(i+1, n):
            comparisons += 1
            if arr[j] < arr[min_idx]:
                min_idx = j
        if min_idx != i:
            swaps += 1
            arr[i], arr[min_idx] = arr[min_idx], arr[i]

    end_time = time.time_ns()  # tiempo en ns
    duration = end_time - start_time

    print(f"Stable: No")
    print(f"Comparisons: {comparisons}")
    print(f"Swaps: {swaps}")
    print(f"Insertions: No")
    print(f"Run Time: {duration} ns")
    print("Time Complexity: O(n^2)")


if __name__ == "__main__":
    n = int(input("Array Size:"))
    arr = [random.randint(300000, 302500) for _ in range(n)]
    selection_sort(arr)
