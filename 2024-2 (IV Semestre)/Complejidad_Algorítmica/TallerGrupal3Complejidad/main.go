package main

import (
	"fmt"
	"math/rand"
	"time"
)

func selectionSort(arr []int) (comparisons int, swaps int, duration int64) {
	start := time.Now()

	for i := 0; i < len(arr)-1; i++ {
		minIndex := i
		for j := i + 1; j < len(arr); j++ {
			comparisons++
			if arr[j] < arr[minIndex] {
				minIndex = j
			}
		}
		if minIndex != i {
			swaps++
			arr[i], arr[minIndex] = arr[minIndex], arr[i]
		}
	}

	duration = time.Since(start).Nanoseconds()
	return
}

func generateRandomArray(size, min, max int) []int {
	arr := make([]int, size)
	for i := range arr {
		arr[i] = rand.Intn(max-min+1) + min
	}
	return arr
}

func main() {
	var n int
	fmt.Print("Array Size:")
	fmt.Scan(&n)
	arr := generateRandomArray(n, 300000, 302500)
	comparisons, swaps, duration := selectionSort(arr)

	fmt.Println("Stable: No")
	fmt.Printf("Comparisons: %d\n", comparisons)
	fmt.Printf("Swaps: %d\n", swaps)
	fmt.Println("Insertions: No")
	fmt.Printf("Run Time: %d ns\n", duration)
	fmt.Println("Time Complexity: O(n^2)")
}
