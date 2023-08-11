package co.edu.unbosque.controller;

import java.util.ArrayList;
import java.util.Arrays;

import co.edu.unbosque.model.AgujeroDTO;
import co.edu.unbosque.model.AgujeroDAO;

public class AplMain {
	
	
	public static void main(String[] args) {
		double[] arrDouble = {12.5, 17.9, -31.2, 2.2, 0.5, 54.87, 42.123, 22.321, 10.5};
		System.out.println("Inicial: "+Arrays.toString(arrDouble));
		System.out.println("Ascendente: "+Arrays.toString(bubbleSort(arrDouble, true)));
		System.out.println("Descendente: "+Arrays.toString(bubbleSort(arrDouble, false)));
		int[] arrInt = {32, 165, 52, 64, 19, -17, 162};
		System.out.println("Inicial: "+Arrays.toString(arrInt));
		System.out.println("Ascendente: "+Arrays.toString(bubbleSort(arrInt, true)));
		System.out.println("Descendente: "+Arrays.toString(bubbleSort(arrInt, false)));
		long[] arrLong = {1234, 2345, 3456, 4321, 37571, 196172, -1234, 1826, 10293};
		System.out.println("Inicial: "+Arrays.toString(arrLong));
		System.out.println("Ascendente: "+Arrays.toString(bubbleSort(arrLong, true)));
		System.out.println("Descendente: "+Arrays.toString(bubbleSort(arrLong, false)));
		float[] arrFloat = { 1.2f, -2.9f, 100.0f, 94.2f };
		System.out.println("Inicial: "+Arrays.toString(arrFloat));
		System.out.println("Ascendente: "+Arrays.toString(bubbleSort(arrFloat, true)));
		System.out.println("Descendente: "+Arrays.toString(bubbleSort(arrFloat, false)));
		String[] arrString = {"Sam", "Sam2", "SAM", "Fico", "Joann", "Joann?"};
		System.out.println("Inicial: "+Arrays.toString(arrString));
		System.out.println("Ascendente: "+Arrays.toString(bubbleSort(arrString, true)));
		System.out.println("Descendente: "+Arrays.toString(bubbleSort(arrString, false)));
		
		AgujeroDAO adao = new AgujeroDAO();
		System.out.println("Tamano: ");
		System.out.println("Inicial: "+Arrays.toString(adao.getLista().toArray()));
		System.out.println("Ascendente: "+Arrays.toString(bubbleSortTamano(adao.getLista(), true).toArray()));
		System.out.println("Descendente: "+Arrays.toString(bubbleSortTamano(adao.getLista(), false).toArray()));
		System.out.println("Distancia: ");
		System.out.println("Inicial: "+Arrays.toString(adao.getLista().toArray()));
		System.out.println("Ascendente: "+Arrays.toString(bubbleSortDistancia(adao.getLista(), true).toArray()));
		System.out.println("Descendente: "+Arrays.toString(bubbleSortDistancia(adao.getLista(), false).toArray()));
		System.out.println("Nombre: ");
		System.out.println("Inicial: "+Arrays.toString(adao.getLista().toArray()));
		System.out.println("Ascendente: "+Arrays.toString(bubbleSortNombre(adao.getLista(), true).toArray()));
		System.out.println("Descendente: "+Arrays.toString(bubbleSortNombre(adao.getLista(), false).toArray()));

	}

	public static ArrayList<AgujeroDTO> bubbleSortTamano(ArrayList<AgujeroDTO> lista, boolean ascendente) {
		ArrayList<AgujeroDTO> res = lista;
		for (int i = 0; i < res.size(); i++) {

			for (int j = 0; j < res.size() - 1; j++) {
				if (ascendente) {

					// MENOR A MAYOR
					if (res.get(j).getTamano() > res.get(j + 1).getTamano()) {
						AgujeroDTO aux = res.get(j);
						res.set(j, res.get(j + 1));
						res.set(j + 1, aux);
					}

				} else {
					// MAYOR A MENOR
					if (res.get(j).getTamano() < res.get(j + 1).getTamano()) {
						AgujeroDTO aux = res.get(j);
						res.set(j, res.get(j + 1));
						res.set(j + 1, aux);
					}
				}

			}

		}
		return res;

	}
	
	public static ArrayList<AgujeroDTO> bubbleSortDistancia(ArrayList<AgujeroDTO> lista, boolean ascendente) {
		ArrayList<AgujeroDTO> res = lista;
		for (int i = 0; i < res.size(); i++) {

			for (int j = 0; j < res.size() - 1; j++) {
				if (ascendente) {

					// MENOR A MAYOR
					if (res.get(j).getDistancia() > res.get(j + 1).getDistancia()) {
						AgujeroDTO aux = res.get(j);
						res.set(j, res.get(j + 1));
						res.set(j + 1, aux);
					}

				} else {
					// MAYOR A MENOR
					if (res.get(j).getDistancia() < res.get(j + 1).getDistancia()) {
						AgujeroDTO aux = res.get(j);
						res.set(j, res.get(j + 1));
						res.set(j + 1, aux);
					}
				}

			}

		}
		return res;

	}
	
	public static ArrayList<AgujeroDTO> bubbleSortNombre(ArrayList<AgujeroDTO> lista, boolean ascendente) {
		ArrayList<AgujeroDTO> res = lista;
		for (int i = 0; i < res.size(); i++) {

			for (int j = 0; j < res.size() - 1; j++) {
				if (ascendente) {

					// MENOR A MAYOR
					if (res.get(j).getNombre().compareTo(res.get(j + 1).getNombre()) > 0) {
						AgujeroDTO aux = res.get(j);
						res.set(j, res.get(j + 1));
						res.set(j + 1, aux);
					}

				} else {
					// MAYOR A MENOR
					if (res.get(j).getNombre().compareTo(res.get(j + 1).getNombre()) < 0) {
						AgujeroDTO aux = res.get(j);
						res.set(j, res.get(j + 1));
						res.set(j + 1, aux);
					}
				}

			}

		}
		return res;

	}
	//MERGE SORT
    /*Une dos subarrays de arr[]
    Primer subarray es arr[1...m]
    Segundo subarray es arr[m+1..r]*/
    static void merge(int arr[], int l, int m, int r) {
        //Encuentra tamaños de dos subarrays a ser unidos
        int n1 = m - l + 1;
        int n2 = r - m;
        /* Crear arrays temporales */
        int L[] = new int[n1];
        int R[] = new int[n2];
        /*Copia datos en los arrays temporales*/
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }
        /*Une los arreglos temporales*/
        // Indices iniciales del los dos subarrays
        int i = 0, j = 0;
        //indice inicial de array unido
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        /*Copia los elementos restanes de L[] si hay*/
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        //Copia los elementos restanes de R[] si hay
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    static void sort(int arr[], int l, int r) {
        if (l < r) {
            //Encuentra el punto medio
            int m = (l + r) / 2;
            // Ordena los dos subarrays
            sort(arr, l, m);
            sort(arr, m + 1, r);
            // Une los subarrays
            merge(arr, l, m, r);
        }
    }
    
    //QUICK SORT
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // Indice del elemento más pequeño
        for (int j = low; j < high; j++) {
            /*Si el actual elemento es más pequeño
            p igual que el pivote*/
            if (arr[j] <= pivot) {
                i++;
                //intercambia arr[i] y arr[j] 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Intercambia arr[i+1] y arr[high] (o pivote) 
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    static void sortQuick(int arr[], int low, int high) {
        if (low < high) {
            /* pi esta particionando indices, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high);
            // Recursivamente ordena elementos antes de 
            // la partición y despues de la partición
            sortQuick(arr, low, pi - 1);
            sortQuick(arr, pi + 1, high);
        }
    }

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
