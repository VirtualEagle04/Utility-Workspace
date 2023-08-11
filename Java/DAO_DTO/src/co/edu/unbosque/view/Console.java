package co.edu.unbosque.view;

import java.util.Scanner;

public class Console {

	private Scanner lector;
	
	public Console() {
		lector = new Scanner(System.in);
	}
	
	public int leerEntero() {
		return lector.nextInt();
	}

	public long leerLong() {
		return lector.nextLong();
	}
	
	public float leerFlotante() {
		return lector.nextFloat();
	}
	
	public double leerDouble() {
		return lector.nextDouble();
	}
	
	public boolean leerBoolean() {
		return lector.nextBoolean();
	}
	
	public char leerCaracter() {
		return lector.next().charAt(0);
	}
	
	public String leerLineaEntera() {
		return lector.nextLine();
	}
	
	public String leerCadena() {
		return lector.next();
	}
	
	public void quemarLinea() {
		lector.nextLine();
	}
	
	public void imprimirConSalto(String salida) {
		System.out.println(salida);
	}
	
	public void imprimirSinSalto(String salida) {
		System.out.print(salida);
	}

	public void imprimirError(String salida){
		System.err.print(salida);
	}
	
}
