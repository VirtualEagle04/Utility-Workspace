package co.edu.unbosque.util;

public class InvalidCharactersException extends Exception{

	public InvalidCharactersException() {
		super("La entrada contiene caracteres invalidos.\nVuelva a intentarlo.");
	}
	
}
