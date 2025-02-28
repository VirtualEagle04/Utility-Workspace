import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Array Size:");
		int n = sc.nextInt();
		int[] arr = generateRandomArray(n, 300000, 302500);
		int comparisons = 0;
		int swaps = 0;

		long startTime = System.nanoTime();

		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				comparisons++;
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swaps++;
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}

		long endTime = System.nanoTime();
		long duration = endTime - startTime;

		System.out.println("Stable: No");
		System.out.println("Comparisons: " + comparisons);
		System.out.println("Swaps: " + swaps);
		System.out.println("Insertions: No");
		System.out.println("Run Time: " + duration + " ns");
		System.out.println("Time Complexity: O(n^2)");
	}

	public static int[] generateRandomArray(int size, int min, int max) {
		Random rand = new Random();
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = rand.nextInt((max - min) + 1) + min;
		}
		return array;
	}

}
