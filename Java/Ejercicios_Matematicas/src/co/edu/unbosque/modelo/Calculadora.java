package co.edu.unbosque.modelo;

import java.util.Arrays;
import java.util.Collections;

public class Calculadora {

	/* 1 */public String calcularMultiplos(int num) {
		String resultado = "";
		if (num % 2 == 0) {
			resultado += "Es multiplo de 2\n";
		}
		if (num % 3 == 0) {
			resultado += "Es multiplo de 3\n";
		}
		if (num % 5 == 0) {
			resultado += "Es multiplo de 5\n";
		}
		if (num % 7 == 0) {
			resultado += "Es multiplo de 7\n";
		}
		if (num % 11 == 0) {
			resultado += "Es multiplo de 11\n";
		}
		if (resultado.isEmpty()) {
			resultado += "No es multiplo de ninguno";
		}
		return resultado;
	}

	/* 4 */public String calcularMayor(int num1, int num2) {
		String resultado = "";
		if (num1 > num2) {
			resultado += num1 + " es mayor que " + num2;
		}
		if (num1 < num2) {
			resultado += num2 + " es mayor que " + num1;
		}
		if (num1 == num2) {
			resultado += "Los dos numeros son iguales.";
		}
		return resultado;
	}

	/* 2 */public String calcularPrimos(long num) {
		int contador = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				contador++;
			}
		}
		if (contador <= 2) {
			return "El numero " + num + " es primo";
		} else {
			return "El numero " + num + " no es primo";
		}
	}

	/* 3 */public String verificarVocalesEspacios(String texto) {
		int contadorVocales = 0;
		int contadorEspacios = 0;
		texto = texto.toLowerCase();
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) == 'a' || texto.charAt(i) == 'e' || texto.charAt(i) == 'i' || texto.charAt(i) == 'o'
					|| texto.charAt(i) == 'u') {
				contadorVocales++;
			}
			if (texto.charAt(i) == ' ') {
				contadorEspacios++;
			}
		}
		return "Tu texto contiene " + contadorVocales + " vocales y " + contadorEspacios + " espacios.";
	}

	/* 5 */public String ordenarPoggers(int nu1, int nu2, int nu3) {
		String resultado = "";
		Integer[] arr = { nu1, nu2, nu3 };
		Arrays.sort(arr, Collections.reverseOrder());

		System.out.println("El arreglo ordenado es: ");
		for (int num : arr) {
			resultado += num + " ";
		}
		return resultado;
	}

	/* 6 */public String cifras(long numero) {
		int cuenta_cifras = 0;
		String numero_String = Long.toString(numero);
		char[] arrString = numero_String.toCharArray();
		for (char i : arrString) {
			cuenta_cifras++;
		}
		return "El numero tiene " + cuenta_cifras + " cifras";
	}

	/* 7 */public String login(String usuario, String contresena, String usuarioAuth, String passAuth) {

		int validacion = 0;
		if (usuario.equals(usuarioAuth)) {
			validacion++;
		}
		if (contresena.equals(passAuth)) {
			validacion++;
		}
		if (validacion < 2) {
			return "Usuario o contreseña incorrecta";
		}
		if (validacion == 2) {
			return "Bienvenido " + usuario;
		} else {
			return "Creedenciales incorrectas";
		}

	}
}