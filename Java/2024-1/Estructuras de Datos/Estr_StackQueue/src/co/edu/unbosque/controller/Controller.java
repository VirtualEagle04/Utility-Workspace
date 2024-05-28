package co.edu.unbosque.controller;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.sound.sampled.Line;

import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.Persona;

public class Controller {

	private Scanner sc;

	public Controller() {
		sc = new Scanner(System.in);
	}

	public void run() {

		// Pilas

//		//Ejemplo 1
//		Stack pila = new Stack();
//		pila.push(1);
//		pila.push(2);
//		pila.push(3);
//		
//		while(!pila.empty()) {
//			System.out.println(pila.pop());
//		}
//		
//		//Ejemplo 2
//		Stack<Persona> pila2 = new Stack<Persona>();
//		pila2.push(new Persona("Juan", 24));
//		pila2.push(new Persona("Javier", 19));
//		pila2.push(new Persona("Esteban", 22));
//		
//		while(!pila2.empty()) {
//			System.out.println("Vamos a desapilar: " + pila2.peek().getNombre());
//			System.out.println(pila2.pop().getEdad());
//		}
//		
//		//Ejemplo 3
//		Stack pila3 = new Stack();
//		System.out.println("Dibuje una figura bidimensional: ");
//		
//		String line;
//		do {
//			line = sc.nextLine();
//			pila3.push(line);
//		}while(!line.equals(""));
//		
//		
//		while(!pila3.empty()) {
//			System.out.println(pila3.pop());
//		}
//		
//		//Colas
//		
//		//Ejemplo 1
//		LinkedList<Persona> cola = new LinkedList<Persona>();
//		String nombre = "";
//		int edad = 0;
//		
//		do {
//			nombre = "";
//			edad = 0;
//			System.out.print("Ingrese el nombre: ");
//			nombre = sc.nextLine();
//			System.out.print("Ingrese la edad: ");
//			String edadString = sc.nextLine();
//			if(edadString.equals("")) { break; }
//			edad = Integer.parseInt(edadString);
//			
//			if(edad >= 18) {				
//				cola.add(new Persona(nombre, edad));
//			}
//			
//			System.out.println(nombre + ": " + edad);
//		}while(!nombre.equals("") || edad != 0);
//		
//		while(!cola.isEmpty()) {
//			System.out.println(cola.peek());
//			cola.remove();
//		}

		// Ejemplo 2
		LinkedList<Jugador> fila = new LinkedList<Jugador>();

		int ronda = 1;
		boolean op = false;

		do {
			System.out.println("Ronda " + ronda);
			System.out.print("Desea agregar un jugador? (y/n): ");
			op = sc.next().equals("y") ? true : false;
			while (op) {
				System.out.print("Numero de jugador: ");
				int num = sc.nextInt();
				System.out.print("Numero de tiros: ");
				int tiros = sc.nextInt();
				fila.add(new Jugador(num, tiros));
				System.out.print("Desea agregar un jugador? (y/n): ");
				op = sc.next().equals("y") ? true : false;
			}
			if(ronda == 1) {
				for (Jugador jugador : fila) {
					System.out.println(jugador.toString());
				}
			}else {
				
				for(Jugador jugador : fila) {
					jugador.setTiros(jugador.getTiros()-1);
					if(jugador.getTiros() == 0) {
						fila.remove(jugador);
					}else {
						System.out.println(jugador.toString());
					}
				}
				
			}
			ronda++;
		} while (!fila.isEmpty());

	}

}
