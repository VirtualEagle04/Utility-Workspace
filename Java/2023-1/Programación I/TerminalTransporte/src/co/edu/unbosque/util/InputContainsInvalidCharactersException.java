package co.edu.unbosque.util;
/**
 * Excepcion cuando el valor ingresado contiene caracteres invalidos.
 * @author Federico Vargas Rozo
 *
 */
public class InputContainsInvalidCharactersException extends Exception{

	public InputContainsInvalidCharactersException() {
		super("El valor ingresado contiene caracteres invalidos.");
	}
	
}
