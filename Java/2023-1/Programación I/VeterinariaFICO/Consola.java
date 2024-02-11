package co.edu.unobosque.view;

import java.util.Scanner;

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
		return sc.nextInt();
	}
	
	public long leerLong() {
		return sc.nextLong();
	}
	
	public String leerLineaEntera() {
		return sc.nextLine();
	}
	
	public String leerCadena() {
		return sc.next();
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
