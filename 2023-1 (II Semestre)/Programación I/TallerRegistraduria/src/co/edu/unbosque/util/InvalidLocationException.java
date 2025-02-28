package co.edu.unbosque.util;
/**
 * Excepcion que indica un error en la ciudad.
 * @author Federico Vargas Rozo
 *
 */
public class InvalidLocationException extends Exception{

	
	public InvalidLocationException() {
		super("La ciudad ingresada contiene numeros o caracteres invalidos.\nVuelva a intentarlo.");
	}
	
}
