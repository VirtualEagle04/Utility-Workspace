package co.edu.unbosque.controller;

import java.util.Scanner;

import co.edu.unbosque.model.Fibonacci;
import co.edu.unbosque.model.TryCatch;

public class Controller {
	
	private Scanner sc;
	private Fibonacci fib;
	private TryCatch tc;
	
	public Controller() {
		sc = new Scanner(System.in);
		fib = new Fibonacci();
		tc = new TryCatch();
	}

	public void run() {
		
		
		System.out.print("N° de Fibonacci: ");
		int num = sc.nextInt();
		
		System.out.println("----------FOR----------");
		
		for(int i = 0; i < num; i++) {
			System.out.println("Numero de Fibonnaci de " + i + " >>> " + fib.calcularFibonnaci(i));
		}
		
		System.out.println("----------WHILE----------");
		
		int contWhile = 0;
		while(contWhile != num) {
			System.out.println("Numero de Fibonnaci de " + contWhile + " >>> " + fib.calcularFibonnaci(contWhile));
			contWhile++;
		}
		
		System.out.println("----------DO-WHILE----------");
		
		int contDoWhile = 0;
		do {
			System.out.println("Numero de Fibonnaci de " + contDoWhile + " >>> " + fib.calcularFibonnaci(contDoWhile));
			contDoWhile++;
		}while(contDoWhile != num);
		
		sc.nextLine();		
		System.out.print("Ingrese un numero: ");
		String input = sc.nextLine();
		
		System.out.println("----------TRY-CATCH----------");
		
		tc.testNumber(input);
		
	}
	
	

}
