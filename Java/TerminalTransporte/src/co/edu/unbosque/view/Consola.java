package co.edu.unbosque.view;

import java.util.Scanner;

import co.edu.unbosque.util.InputContainsInvalidCharactersException;
import co.edu.unbosque.util.InputDateInvalidException;
import co.edu.unbosque.util.InputHoursInvalidException;
import co.edu.unbosque.util.InputWrongFormatException;
/**
 * Clase que facilita las impresiones en consola y el control de excepciones.
 * @author Federico Vargas Rozo
 * @param sc Objeto de la clase Scanner que permite la lectura de input desde la consola.
 */
public class Consola {

	private Scanner sc;

	public Consola() {
		sc = new Scanner(System.in);
	}
	/**
	 * Imprimir en consola y saltar la linea.
	 * @param salida String para imprimir en consola.
	 */
	public void imprimirConSalto(String salida) {
		System.out.println(salida);
	}
	/**
	 * Imprimir en consola y no saltar la linea.
	 * @param salida String para imprimir en consola.
	 */
	public void imprimirSinSalto(String salida) {
		System.out.print(salida);
	}
	/**
	 * Imprimir en consola en forma de error y saltar la linea.
	 * @param salida String para imprimir en consola.
	 */
	public void imprimirErrorSalto(String salida) {
		System.err.println(salida);
	}
	/**
	 * Imprimir en consola en forma de error y no saltar.
	 * @param salida String para imprimir en consola.
	 */
	public void imprimirErrorSinSalto(String salida) {
		System.err.print(salida);
	}
	/**
	 * Funcion para convertir una hora en forma "digito:digito" a un Array de enteros con las horas y los minutos por separado.
	 * @param temp String donde esta la hora.
	 * @return Retorna la hora y los minuos en forma de enteros separados en posiciones de un Array.
	 * @throws InputHoursInvalidException Si las horas son superiores a 23 o los minutos a 59 o si las horas son negativas.
	 * @throws InputWrongFormatException Si el formato de la hora no es "digito:digito".
	 */
	public String[] leerHora(String temp)
			throws InputHoursInvalidException, InputWrongFormatException {
		if (temp.matches("\\d{1,2}:\\d{2}") == false) {
			throw new InputWrongFormatException();
		} else {
			String[] splitted = temp.split(":");
			int[] num_splitted = { Integer.parseInt(splitted[0]), Integer.parseInt(splitted[1]) };
			if (splitted[1].length() < 2 || num_splitted[0] < 0 || num_splitted[0] > 23 || num_splitted[1] > 59) {
				throw new InputHoursInvalidException();
			} else {
				return splitted;
			}
		}

	}
	/**
	 * Funcion para convertir una fecha en forma "digito/digito/digito" a un Array de enteros con las los meses, los dias y el anio por separado.
	 * @param temp String donde esta la fecha.
	 * @return Retorna los meses, los dias y el año en forma de un Array de enteros.
	 * @throws InputDateInvalidException Si el mes es mayor a 12, si los dias son superiores a 31, o si el año es menor a 2023 o si cualquiera de los digitos es negativo.
	 * @throws InputWrongFormatException Si el formato de la fecha no es "digito/digito/digito".
	 */
	public int[] leerFecha(String temp) throws InputWrongFormatException, InputDateInvalidException {
		if (temp.matches("\\d{1,2}/\\d{1,2}/\\d{4}") == false) {
			throw new InputWrongFormatException();
		} else {
			String[] temp_arr = temp.split("/");
			int[] int_arr = { Integer.parseInt(temp_arr[0]), Integer.parseInt(temp_arr[1]),
					Integer.parseInt(temp_arr[2]) };
			if (int_arr[0] < 0 || int_arr[1] < 0 || int_arr[2] < 2023 || int_arr[0] > 12 || int_arr[1] > 31 || int_arr[2] > 9999) {
				throw new InputDateInvalidException();
			} else {
				return int_arr;
			}
		}

	}
	/**
	 * 
	 * @param temp String donde esta el entero.
	 * @return Retorna el entero convertiro a Integer.
	 * @throws InputWrongFormatException Si el string inicial contiene caracteres invalidos (es decir, no es digito).
	 */
	public int leerEntero(String temp) throws InputWrongFormatException {
		if(temp.matches("^[0-9]+$") == false) {
			throw new InputWrongFormatException();
		} else {
			return Integer.parseInt(temp);
		}
	}
	/**
	 * 
	 * @param temp String donde esta el long.
	 * @return Retorna el long convertiro a Long.
	 */
	public long leerLong(String temp) {
		return Long.parseLong(temp);
	}
	/**
	 * 
	 * @param temp String del usuario.
	 * @return El mismo string del usuario.
	 * @throws InputContainsInvalidCharactersException Si el string inicial contiene caracteres invalidos (numeros, y todos tipo de caracteres).
	 */
	public String leerLineaEntera(String temp) throws InputContainsInvalidCharactersException {

		if (temp.matches(".*[^a-zA-Z\\s].*")) {
			throw new InputContainsInvalidCharactersException();
		} else {
			return temp;
		}

	}
	/**
	 * 
	 * @param temp String del usuario.
	 * @return Retorna la primera palabra del string del usuario.
	 */
	public String leerCadena(String temp) {
		return temp.split(" ")[0];
	}
	/**
	 * 
	 * @param temp String donde esta el flotante.
	 * @return Retorna el flotante convertido a Float.
	 * @throws InputWrongFormatException Si el string inicial contiene caracteres invalidos (es decir, no es digito). 
	 */
	public float leerFlotante(String temp) throws InputWrongFormatException {
		if(temp.matches("^[0-9.]+$") == false) {
			throw new InputWrongFormatException();
		}else {
			return Float.parseFloat(temp);
		}
	}
	/**
	 * 
	 * @param temp String donde esta el Double.
	 * @return Retorna el double convertido a Double.
	 */
	public double leerDouble(String temp) {
		return Double.parseDouble(temp);
	}
	/**
	 * 
	 * @param temp String del usuario.
	 * @return Retorna el primer caracter del String del usuario.
	 */
	public char leerCaracter(String temp) {
		return temp.charAt(0);
	}
	/**
	 * Utilizado para saltar de linea y evitar errores entre los lectores.
	 */
	public void quemarLinea() {
		sc.nextLine();
	}
}
