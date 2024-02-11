package co.edu.unbosque.view;

import java.util.Scanner;

public class Console {
	private Scanner sc;
	
	public Console() {
		sc = new Scanner(System.in);
	}
	
	public void printSalto(String str) {
		System.out.println(str);
	}
	
	public void printSinSalto(String str) {
		System.out.print(str);
	}
	
	public void printErrorSalto(String str) {
		System.err.println(str);
	}
	
	public void printErrorSinSalto(String str) {
		System.err.print(str);
	}
	
	public int leerInt() {
		return sc.nextInt();
	}
	
	public float leerFloat() {
		return sc.nextFloat();
	}
	
	public long leerLong() {
		return sc.nextLong();
	}
	
	public double leerDouble() {
		return sc.nextDouble();
	}
	
	public boolean leerBooleano() {
		return sc.nextBoolean();
	}
	
	public String leerNextLine() {
		return sc.nextLine();
	}
	
	public String leerNext() {
		return sc.next();
	}
	
	public void quemarLinea() {
		sc.nextLine();
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}
	
	
	
}
