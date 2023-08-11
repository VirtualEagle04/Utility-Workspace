package co.edu.unbosque.util;

import java.util.InputMismatchException;

public class InputContainsInvalidCharactersException extends Exception{

	public InputContainsInvalidCharactersException() {
		super("El valor ingresado contiene numeros o simbolos.");
	}
}
