package co.edu.unbosque.util;
/**
 * Excepcion que indica erroe en la fecha
 * @author Federico Vargas Rozo
 *
 */
public class InvalidDateFormatException extends Exception{

	public InvalidDateFormatException() {
		super("La fecha ingresada no existe, ya paso, o tiene un formato invalido.\nVuelva a intentarlo.");
	}
	
}
