package co.edu.unbosque.controlador;

import java.util.Scanner;
import co.edu.unbosque.modelo.Calculadora;

public class Controlador {

	public Calculadora cal;
	private Scanner sc;

	// Constructor
	public Controlador() {
		cal = new Calculadora();
		sc = new Scanner(System.in);
	}
	
	public void ejecutar() {
		// Calcular Mayor
		System.out.println("Ingrese dos numeros: ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		System.out.println(cal.calcularMayor(num1, num2));

		// Calcular Primos
		System.out.println("Ingrese un numero para verificar si es primo: ");
		long num = sc.nextLong();
		System.out.println(cal.calcularPrimos(num));

		// Calcular Multiplos
		System.out.println("Ingrese un numero para verificar sus multiplos: ");
		int nume = sc.nextInt();
		System.out.println(cal.calcularMultiplos(nume));
		sc.nextLine();

		// Verificar Vocales y Espacios
		System.out.println("Ingrese un texto para verificar sus vocales y sus espacios: ");
		System.out.println(cal.verificarVocalesEspacios(sc.nextLine()));

		// Ordenar Numeros
		System.out.println("Ingrese 3 numeros:");
		System.out.println(cal.ordenarPoggers(sc.nextInt(), sc.nextInt(), sc.nextInt()));

		// Cifras
		System.out.println("Ingrese un numero para contar sus cifras: ");
		System.out.println(cal.cifras(sc.nextLong()));

		// Login
		System.out.println("---REGISTRO---");
		System.out.println("Ingrese el usuario con el que desea registrarse: ");
		String usuario = sc.nextLine();
		System.out.println("Cree una contraseña");
		String password = sc.nextLine();
		System.out.println("---Inicio Sesion---");
		System.out.println("Ingrese su usuario: ");
		String usuarioAuth = sc.nextLine();
		System.out.println("Ingrese su contreseña: ");
		String passAuth = sc.nextLine();
		System.out.println(cal.login(usuario, password, usuarioAuth, passAuth));

	}

}
