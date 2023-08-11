package co.edu.unbosque.util;
/**
 * Excepcion cuando la fecha ingresada es negativa, ya paso, o no existe.
 * @author Federico Vargas Rozo
 *
 */
public class InputDateInvalidException extends Exception{

	public InputDateInvalidException() {
		super("La fecha ingresada es negativa, ya paso, o no existe.");
	}
	
}
