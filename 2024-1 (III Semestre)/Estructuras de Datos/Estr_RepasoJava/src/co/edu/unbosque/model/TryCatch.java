package co.edu.unbosque.model;

public class TryCatch {

	public TryCatch() {

	}

	public void testNumber(String input) {

		try {

			int num = Integer.parseInt(input);

			System.out.println("Numero: " + num);

		} catch (NumberFormatException e) {
			System.err.println("Error: Ingrese unicamente numeros!\nValor ingresado: " + input);
		}

	}

}
