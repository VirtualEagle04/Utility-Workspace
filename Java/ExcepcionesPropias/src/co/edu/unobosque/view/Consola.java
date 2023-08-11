package co.edu.unobosque.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import co.edu.unbosque.util.InputContainsInvalidCharactersException;
import co.edu.unbosque.util.InputIsNegativeException;

public class Consola {

	private Scanner sc;
	
	public Consola() {
		sc = new Scanner(System.in);
	}

	public void imprimirConSalto(String salida) {
		System.out.println(salida);
	}
	
	public void imprimirSinSalto(String salida) {
		System.out.print(salida);
	}
	
	public void imprimirErrorSalto(String salida) {
		System.err.println(salida);
	}
	
	public void imprimirErrorSinSalto(String salida) {
		System.err.print(salida);
	}
	
	public int leerEntero() {
		
		while (true) {
			try {
				int temp_int = sc.nextInt();
				if(temp_int <= 0) {
					throw new InputIsNegativeException();
				}else {
					return temp_int;
				}
			}catch (InputMismatchException e) {
				System.err.println("Motivo: El valor ingresado no es numerico.");
				System.err.print("Vuelva a intentarlo: ");
				sc.nextLine();
				continue;
			}catch (InputIsNegativeException e1) {
				System.err.println("Motivo: "+e1.getMessage());
				System.err.print("Vuelva a intentarlo: ");
				continue;
			}
		}
		
	}
	
	public long leerLong() {
		while (true) {
			try {
				Long temp_long = sc.nextLong();
				if(temp_long <= 0) {
					throw new InputIsNegativeException();
				}else {
					return temp_long;
				}
			} catch (InputMismatchException e) {
				System.err.println("Motivo: El valor ingresado no es numerico o es muy extenso.");
				System.err.print("Vuelva a intentarlo: ");
				sc.nextLine();
				continue;
			} catch (InputIsNegativeException e1) {
				System.err.println("Motivo: "+e1.getMessage());
				System.err.print("Vuelva a intentarlo: ");
				continue;
			}
		}
	}
	
	public String leerLineaEntera() {
		while (true) {
			try {
				String temp_string = sc.nextLine();
				if(temp_string.matches(".*[^a-zA-Z\\s].*")){
					throw new InputContainsInvalidCharactersException();
				}else {
					return temp_string;
				}
			} catch (InputContainsInvalidCharactersException e) {
				System.err.println("Motivo: "+e.getMessage());
				System.err.print("Vuelva a intentarlo: ");
				continue;
			} 
		}
	}
	
	public String leerCadena() {
		while (true) {
			try {
				String temp_string = sc.next();
				if(temp_string.matches(".*[^a-zA-Z].*")){
					throw new InputContainsInvalidCharactersException();
				}else {
					return temp_string;
				}
			} catch (InputContainsInvalidCharactersException e) {
				System.err.println("Motivo: "+e.getMessage());
				System.err.print("Vuelva a intentarlo: ");
				continue;
			} 
		}
	}
	
	public float leerFlotante() {
		return sc.nextFloat();
	}
	
	public double leerDouble() {
		return sc.nextDouble();
	}
	
	public char leerCaracter() {
		return sc.next().charAt(0);
	}
	
	public void quemarLinea() {
		sc.nextLine();
	}
	
	public boolean leerBooleano() {
		return sc.nextBoolean();
	}
}
