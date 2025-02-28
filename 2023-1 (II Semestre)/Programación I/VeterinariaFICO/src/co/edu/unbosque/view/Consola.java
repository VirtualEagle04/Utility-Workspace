package co.edu.unbosque.view;

import java.util.Scanner;

public class Consola {
	private Scanner lector;

	public Consola() {
		lector = new Scanner(System.in);
	}

	public void imprimirConSalto(String str) {
		System.out.println(str);
	}
	
	public void imprimirSinSalto(String str) {
		System.out.print(str);
	}
	
	public void imprimirErrorSalto(String str) {
		System.err.println(str);
	}
	
	public void imprimirErrorNoSalto(String str) {
		System.err.print(str);
	}

	public void quemarLinea() {
		lector.nextLine();
	}

	public int leerInt() {
		return lector.nextInt();
	}

	public long leerLong() {
		return lector.nextLong();
	}

	public float leerFloat() {
		return lector.nextFloat();
	}

	public double leerDouble() {
		return lector.nextDouble();
	}
	
	public boolean leerBooleano() {
		return lector.nextBoolean();
	}

	public String leerStringLine() {
		return lector.nextLine();
	}

	public String leerString() {
		return lector.next();
	}
}
