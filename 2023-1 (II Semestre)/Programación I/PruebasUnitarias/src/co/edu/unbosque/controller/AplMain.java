package co.edu.unbosque.controller;

import java.util.Scanner;

public class AplMain {

	public static Scanner lector;

	public static void main(String[] args) {
		lector = new Scanner(System.in);
		System.out.print("Ingrese un numero: ");
		int num1 = lector.nextInt();
		System.out.print("Ingrese otro numero: ");
		int num2 = lector.nextInt();
		System.out.println("La suma es: " + suma(num1, num2));
		System.out.println("La resta es: " + resta(num1, num2));
	}

	public static int suma(int num1, int num2) {
		return num1 + num2;
	}

	public static int resta(int num1, int num2) {
		return num1 - num2;
	}

}
