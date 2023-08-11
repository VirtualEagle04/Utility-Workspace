import java.util.Arrays;

public class AplMain {

	public static void main(String[] args) {
		
		int[] array = {70, 90, 0, 80, 60, 85};
		//selectionSort(array);
		//bubbleSort(array);
		insertionSort(array);
		
	}
	
	public static void insertionSort(int[] array) {
		System.out.println("---Selection Sort---");
		System.out.println("Antes de ordenar: ");
		int[] copia = array;
		System.out.println(Arrays.toString(copia));
		
		for (int i = 1; i < copia.length; i++) {
			int insert_value = copia[i];
			int insert_index = i;
			System.out.println("Pasada: "+insert_index);
			System.out.println("Valor a comparar: "+insert_value);
			
			while(insert_index > 0 && insert_value < copia[insert_index - 1]) {
				copia[insert_index] = copia[insert_index -1];
				insert_index--;
			}
			
			copia[insert_index] = insert_value;
			
		}
		System.out.println("Despues de ordenar: ");
		System.out.println(Arrays.toString(copia));
		
	}
	
	public static void selectionSort(int[] array) {
		System.out.println("---Selection Sort---");
		System.out.println("Antes de ordenar: ");
		int[] copia = array;
		System.out.println(Arrays.toString(copia));
		
		for(int i = 0; i < copia.length; i++) { //Pasada
			int min_index = i;
			int min_value = copia[min_index];
			
			for(int j = i; j < copia.length-1; j++) {
				
				if(min_value > copia[j+1]) {
					min_value = copia[j+1];
					min_index = j +1;
				}
			}
			
			if(min_index != i) {
				int aux = copia[i];
				copia[i] = copia[min_index];
				copia[min_index] = aux;
			}
		}
		System.out.println("Despues de ordenar: ");
		System.out.println(Arrays.toString(copia));
	}
	
	public static void bubbleSort(int[] array) {
		System.out.println("---Bubble Sort---");
		System.out.println("Antes de ordenar: ");
		int[] copia = array;
		System.out.println(Arrays.toString(copia));
		
		for (int i = 0; i < copia.length; i++) {

			for (int j = 0; j < copia.length - 1; j++) {
					if (copia[j] > copia[j + 1]) {
						int aux = copia[j];
						copia[j] = copia[j + 1];
						copia[j + 1] = aux;
					}
			}

		}
		
		System.out.println("Despues de ordenar: ");
		System.out.println(Arrays.toString(copia));
	}

}
