package co.edu.unbosque.util;
/**
 * Excepcion cuando el valor ingresado es negativo, superior a las 23 horas o superior a los 59 minutos.
 * @author Federico Vargas Rozo
 *
 */
public class InputHoursInvalidException extends Exception{

	public InputHoursInvalidException() {
		super("El valor ingresado es negativo, superior a las 23 horas o superior a los 59 minutos.");
	}
	
}
