package co.edu.unbosque.view;

import co.edu.unbosque.util.InvalidDateFormatException;
import co.edu.unbosque.util.InvalidIndexFormatException;
import co.edu.unbosque.util.InvalidLocationException;
import co.edu.unbosque.util.InvalidNameException;
import co.edu.unbosque.util.InvalidSexException;

/**
 * Clase que facilita las impresiones en consola y el control de excepciones.
 * 
 * @author Federico Vargas Rozo
 *
 */
public class Consola {
	public Consola() {
	}

	/**
	 * Imprimir en consola y saltar la linea.
	 * 
	 * @param salida String para imprimir en consola.
	 */
	public void printSalto(String salida) {
		System.out.println(salida);
	}

	/**
	 * Imprimir en consola y no saltar la linea.
	 * 
	 * @param salida String para imprimir en consola.
	 */
	public void printSinSalto(String salida) {
		System.out.print(salida);
	}

	/**
	 * Imprimir en consola en forma de error y saltar la linea.
	 * 
	 * @param salida String para imprimir en consola.
	 */
	public void printErrorSalto(String salida) {
		System.err.println(salida);
	}

	/**
	 * Imprimir en consola en forma de error y no saltar.
	 * 
	 * @param salida String para imprimir en consola.
	 */
	public void printErrorSinSalto(String salida) {
		System.err.print(salida);
	}

	/**
	 * Permite las verificaciones de formato al leer el nombre ingresado
	 * 
	 * @param str El nombre a verificar
	 * @return Retorna el nombre como el usuario lo ingresa.
	 * @throws InvalidNameException Si el nombre contiene caracteres invalidos
	 *                              (numeros, caracteres no alfabeticos)
	 */
	public String leerNombre(String str) throws InvalidNameException {
		if (str.matches(".*[^a-zA-Z\\s].*")) {
			throw new InvalidNameException();
		} else {
			return str;
		}

	}

	/**
	 * Permite las verificaciones de formato al leer el sexo ingresado
	 * 
	 * @param str El sexo a verificar
	 * @return Retorna el sexo como el usuario lo ingresa.
	 * @throws InvalidSexException Si el sexo contiene no es ninguno de los dos
	 *                             (Masculino o Femenino)
	 */
	public String leerSexo(String str) throws InvalidSexException {
		if (str.toLowerCase().contains("masculino") == false && str.toLowerCase().contains("femenino") == false) {
			throw new InvalidSexException();
		} else {
			return str;
		}
	}

	/**
	 * Permite las verificaciones de formato al leer la ciudad ingresada
	 * @param str La ciudad a verificar
	 * @return Retorno la ciudad como el usuario lo ingresa.
	 * @throws InvalidLocationException Si la ciudad contiene caracteres invalidos (numeros, caracteres no alfabeticos, excepto el punto)
	 */
	public String leerCiudad(String str) throws InvalidLocationException {
		if (str.matches("^[a-zA-Z.\\s]*$") == false) {
			throw new InvalidLocationException();
		} else {
			return str;
		}
	}
	/**
	 * Permite las verificaciones de formato al leer la fecha ingresada
	 * @param str La fecha a verificar
	 * @return Retorna la fecha como el usuario lo ingresa.
	 * @throws InvalidDateFormatException Si la fecha no existe, ya paso o es invalida
	 */
	public String leerFecha(String str) throws InvalidDateFormatException {
		if (str.matches("\\d{1,2}/\\d{1,2}/\\d{4}") == false) {
			throw new InvalidDateFormatException();
		} else {
			String[] split = str.split("/");
			int[] digitos = new int[3];
			for (int i = 0; i < split.length; i++) {
				digitos[i] = Integer.parseInt(split[i]);
			}
			if (digitos[0] > 12 || digitos[0] < 1 || digitos[1] > 31 || digitos[1] < 1 || digitos[2] > 9999
					|| digitos[2] < 1970) {
				throw new InvalidDateFormatException();
			} else {
				return str;
			}
		}
	}
	/**
	 * Permite las verificaciones de formato al leer la posicion ingresada
	 * @param str La posicion a verificar
	 * @return Retorna la posicion como el usuario lo ingresa.
	 * @throws InvalidIndexFormatException Si la posicion contiene caracteres alfabeticos o invalidos
	 */
	public int leerInt(String str) throws InvalidIndexFormatException {
		if (str.matches("^[0-9]+$") == false) {
			throw new InvalidIndexFormatException();
		} else {
			return Integer.parseInt(str);
		}
	}

}
