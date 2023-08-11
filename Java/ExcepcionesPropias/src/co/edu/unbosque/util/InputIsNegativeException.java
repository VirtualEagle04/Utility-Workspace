package co.edu.unbosque.util;

public class InputIsNegativeException extends Exception{

	public InputIsNegativeException() {
		super("El valor ingresado es igual o menor a cero.");
	}
	
}
