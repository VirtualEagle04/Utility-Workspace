package co.edu.unbosque.util;
/**
 * Excepcion cuando el valor ingresado no contiene el formato adecuado.
 * @author Federico Vargas Rozo
 *
 */
public class InputWrongFormatException extends Exception{

	public InputWrongFormatException() {
		super("El valor ingresado no contiene el formato adecuado.");
	}
	
}
