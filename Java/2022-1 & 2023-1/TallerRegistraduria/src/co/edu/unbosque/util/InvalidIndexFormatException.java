package co.edu.unbosque.util;
/**
 * Excepcion que indica un error en la posicion.
 * @author Federico Vargas Rozo
 *
 */
public class InvalidIndexFormatException extends Exception{

	public InvalidIndexFormatException() {
		super("La posicion ingresada no es numerica.\nVuelva a intentarlo.");
	}
	
}
