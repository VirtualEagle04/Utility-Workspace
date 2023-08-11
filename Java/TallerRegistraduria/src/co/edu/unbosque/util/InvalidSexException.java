package co.edu.unbosque.util;
/**
 * Excepcion que indica un error en el sexo
 * @author Federico Vargas Rozo
 *
 */
public class InvalidSexException extends Exception{

	public InvalidSexException() {
		super("El sexo ingresado no es valido.\nIngrese 'Masculino' o 'Femenino'.");
	}
	
}
