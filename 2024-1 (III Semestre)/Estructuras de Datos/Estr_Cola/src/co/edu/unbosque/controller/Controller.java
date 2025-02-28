package co.edu.unbosque.controller;

import java.util.Scanner;

import co.edu.unbosque.model.Persona;
import co.edu.unbosque.util.ColaDinamica;
import co.edu.unbosque.util.Metodos;

public class Controller {

	public final int NINO = 5000; // 5 - 10
	public final int ADOLECENTE = 7000;// 11 - 17
	public final int ADULTO = 9000;// 18 - ...

	public ColaDinamica<Persona> colaCine;
	public Scanner sc;

	public Controller() {
		colaCine = new ColaDinamica<Persona>();
		sc = new Scanner(System.in);
	}

	public void run() {

		llenarCola();
		System.out.println(colaCine.toString());
		System.out.println("Ganancia: " + calcularGanancia());
		
	}

	public void llenarCola() {

		int cant = Metodos.generaNumeroAleatorio(1, 5);

		for (int i = 0; i < cant; i++) {
			int edad = Metodos.generaNumeroAleatorio(5, 99);
			colaCine.enqueue(new Persona(edad));
		}

	}
	
	public int calcularGanancia() {
		int total = 0;
		
		for(int i = 0; i < colaCine.size(); i++) {
			int tempEdad = colaCine.dequeue().getEdad();
			if(5 <= tempEdad && tempEdad <= 10) {
				total += NINO;
			}else if(11 <= tempEdad && tempEdad <= 17) {
				total += ADOLECENTE;
			}
			else if(18 <= tempEdad) {
				total += ADULTO;
			}
		
		}
		return total;
	}

}
