package co.edu.unbosque.model;

public class Fibonacci {
	
	public Fibonacci() {
	}

	public int calcularFibonnaci(int i) {

		if (i == 0) {
			return 0;
		}
		if (i == 1 || i == 2) {
			return 1;
		} else {
			return (calcularFibonnaci(i - 1) + calcularFibonnaci(i - 2));
		}

	}

}
