#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void selectionSort(int arr[], int n, int* comparisons, int* swaps) {
    *comparisons = 0;
    *swaps = 0;

    struct timespec start, end;
    clock_gettime(CLOCK_MONOTONIC, &start);

    for (int i = 0; i < n - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < n; j++) {
            (*comparisons)++;
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        if (minIndex != i) {
            (*swaps)++;
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    clock_gettime(CLOCK_MONOTONIC, &end);
    long duration = (end.tv_sec - start.tv_sec) * 1000000000 + (end.tv_nsec - start.tv_nsec); // tiempo en ns

    printf("Stable: No\n");
    printf("Comparisons: %d\n", *comparisons);
    printf("Swaps: %d\n", *swaps);
    printf("Insertions: No\n");
    printf("Run Time: %ld ns\n", duration);
    printf("Time Complexity: O(n^2)\n");
}

int* generateRandomArray(int size, int min, int max) {
    int* array = (int*)malloc(size * sizeof(int));
    for (int i = 0; i < size; i++) {
        array[i] = rand() % (max - min + 1) + min;
    }
    return array;
}

int main() {
    srand(time(0));
    int n;
    printf("Array Size:");
    scanf("%d", &n);
    int* arr = generateRandomArray(n, 300000, 302500);
    int comparisons, swaps;
    selectionSort(arr, n, &comparisons, &swaps);
    free(arr);
    return 0;
}

