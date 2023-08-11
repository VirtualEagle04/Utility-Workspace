package co.edu.unbosque.util;
/**
 * Excepcion que indica un error en el nombre.
 * @author Federico Vargas Rozo
 *
 */
public class InvalidNameException extends Exception{

	public InvalidNameException() {
		super("El nombre ingresado contiene numeros o caracteres invalidos.\nVuelva a intentarlo.");
	}
	
}
