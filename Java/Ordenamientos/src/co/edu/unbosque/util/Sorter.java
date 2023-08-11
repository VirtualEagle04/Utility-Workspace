package co.edu.unbosque.util;

public class Sorter {

	public static String[] bubbleSort(String[] arr, boolean ascendente) {
		String[] res = arr;
		for (int i = 0; i < res.length; i++) {

			for (int j = 0; j < res.length - 1; j++) {
				if (ascendente) {
					// MENOR A MAYOR
					if (res[j].compareTo(res[j + 1]) > 0) {
						String aux = res[j];
						res[j] = res[j + 1];
						res[j + 1] = aux;
					}
				} else {
					// MAYOR A MENOR
					if (res[j].compareTo(res[j + 1]) < 0) {
						String aux = res[j];
						res[j] = res[j + 1];
						res[j + 1] = aux;
					}
				}
			}
		}
		return res;
	}
	
	public static int[] bubbleSort(int[] arr, boolean ascendente) {
		int[] res = arr;
		for (int i = 0; i < res.length; i++) {

			for (int j = 0; j < res.length - 1; j++) {
				if (ascendente) {
					// MENOR A MAYOR
					if (res[j] > res[j + 1]) {
						int aux = res[j];
						res[j] = res[j + 1];
						res[j + 1] = aux;
					}
				} else {
					// MAYOR A MENOR
					if (res[j] < res[j + 1]) {
						int aux = res[j];
						res[j] = res[j + 1];
						res[j + 1] = aux;
					}
				}
			}
		}
		return res;
	}
	
	public static long[] bubbleSort(long[] arr, boolean ascendente) {
		long[] res = arr;
		for (int i = 0; i < res.length; i++) {

			for (int j = 0; j < res.length - 1; j++) {
				if (ascendente) {
					// MENOR A MAYOR
					if (res[j] > res[j + 1]) {
						long aux = res[j];
						res[j] = res[j + 1];
						res[j + 1] = aux;
					}
				} else {
					// MAYOR A MENOR
					if (res[j] < res[j + 1]) {
						long aux = res[j];
						res[j] = res[j + 1];
						res[j + 1] = aux;
					}
				}
			}
		}
		return res;
	}
	
	public static float[] bubbleSort(float[] arr, boolean ascendente) {
		float[] res = arr;
		for (int i = 0; i < res.length; i++) {

			for (int j = 0; j < res.length - 1; j++) {
				if (ascendente) {
					// MENOR A MAYOR
					if (res[j] > res[j + 1]) {
						float aux = res[j];
						res[j] = res[j + 1];
						res[j + 1] = aux;
					}
				} else {
					// MAYOR A MENOR
					if (res[j] < res[j + 1]) {
						float aux = res[j];
						res[j] = res[j + 1];
						res[j + 1] = aux;
					}
				}
			}
		}
		return res;
	}
	
	public static double[] bubbleSort(double[] arr, boolean ascendente) {
		double[] res = arr;
		for (int i = 0; i < res.length; i++) {

			for (int j = 0; j < res.length - 1; j++) {
				if (ascendente) {
					// MENOR A MAYOR
					if (res[j] > res[j + 1]) {
						double aux = res[j];
						res[j] = res[j + 1];
						res[j + 1] = aux;
					}
				} else {
					// MAYOR A MENOR
					if (res[j] < res[j + 1]) {
						double aux = res[j];
						res[j] = res[j + 1];
						res[j + 1] = aux;
					}
				}
			}
		}
		return res;
	}

}
