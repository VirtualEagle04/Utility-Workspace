package co.edu.unbosque.controller;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import co.edu.unbosque.model.Persona;
import co.edu.unbosque.util.Edge;
import co.edu.unbosque.util.Graph;
import co.edu.unbosque.util.Vertex;
import co.edu.unbosque.view.Console;

public class Controller {

	private Queue<Persona> cola; // Cola Estacion
	private Stack<Persona> pila; // Bus
	private Graph grafo;
	private int estacion;

	public Controller() {
		cola = new LinkedList<Persona>();
		pila = new Stack<Persona>();
		grafo = new Graph();
		estacion = 0;

		Vertex usaquen = new Vertex("Usaquen");
		Vertex suba = new Vertex("Suba");
		Vertex chapinero = new Vertex("Chapinero");

		Edge usaquenSuba = new Edge(usaquen, suba, 0);
		Edge subaChapinero = new Edge(suba, chapinero, 0);
		Edge chapineroUsaquen = new Edge(chapinero, usaquen, 0);

		usaquen.addEdge(usaquenSuba);
		suba.addEdge(subaChapinero);
		chapinero.addEdge(chapineroUsaquen);

		grafo.addVertex(usaquen);
		grafo.addVertex(suba);
		grafo.addVertex(chapinero);

	}

	public void run() {

		ppal: while (true) {

			Console.printLine(
					"1. -Agregar Personas a la Cola\n2. -Ver Personas en la Cola\n3. -Desencolar Personas de la Cola\n4. -Ver Personas en el Bus\n5. -Desapilar Personas en el Bus\n6. -Visualizar Trajectoria\n7. -Finalizar");

			int op = Console.readInt();

			switch (op) {
			case 1: {
				Console.burnLine();
				Console.print("Ingrese el nombre de la Persona: ");
				String nombre = Console.readLine();

				cola.add(new Persona(nombre));
				Console.printSuccessLine(nombre + " esta ahora haciendo cola.");

				break;
			}
			case 2: {
				if (cola.isEmpty()) {
					Console.printErrLine("La Cola esta vacia. Ingresa Personas primero.");
				} else {
					Console.printSuccessLine("PRIMERO");
					for (Persona p : cola) {
						Console.printLine("> " + p.toString());
					}
					Console.printSuccessLine("ULTIMO");
				}

				break;
			}
			case 3: {
				if (cola.isEmpty()) {
					Console.printErrLine("La Cola esta vacia. Ingresa Personas primero.");
				} else {
					Persona temp = cola.remove();
					pila.push(temp);
					Console.printSuccessLine("La Persona con nombre " + temp.getNombre() + " ha salido de la Cola.");
					Console.printSuccess("La Persona con nombre " + temp.getNombre() + " ha ingresado al Bus en la estacion ");
					switch(estacion) {
					case 0: {
						Console.printSuccessLine("Usaquen (Terminal).");
						break;
					}
					case 1: {
						Console.printSuccessLine("Suba.");
						break;
					}
					case 2: {
						Console.printSuccessLine("Chapinero.");
						break;
					}
					}
					Console.printLine("El nuevo estado de la Cola es: ");
					if (cola.isEmpty()) {
						Console.printErrLine("La Cola esta vacia");
					} else {
						Console.printSuccessLine("PRIMERO");
						for (Persona p : cola) {
							Console.printLine("> " + p.toString());
						}
						Console.printSuccessLine("ULTIMO");
					}
				}

				break;
			}
			case 4: {
				if (pila.isEmpty()) {
					Console.printErrLine("El Bus esta vacio. Desencola Persona primero.");
				} else {
					Console.printSuccessLine("INFERIOR");
					for (Persona p : pila) {
						Console.printLine("> " + p.toString());
					}
					Console.printSuccessLine("SUPERIOR");
				}

				break;
			}
			case 5: {
				if (estacion == 0) {
					if (pila.isEmpty()) {
						Console.printErrLine("El Bus esta vacio. El Bus esperara hasta que haya por lo menos 1 Persona.");
					} else {
						Console.printSuccessLine("Partiendo de Usaquen (Terminal) a Suba");
						Console.printLine("...");
						Persona temp = pila.pop();
						Console.printSuccessLine("La Persona " + temp.getNombre() + " se ha bajado en Suba.");
						estacion++;
					}
				} else if (estacion == 1) {
					if (pila.isEmpty()) {
						Console.printErrLine("El Bus esta vacio. El Bus volvera a la terminal.");
						estacion = 0;
					} else {
						Console.printSuccessLine("Partiendo de Suba a Chapinero");
						Console.printLine("...");
						Persona temp = pila.pop();
						Console.printSuccessLine("La Persona " + temp.getNombre() + " se ha bajado en Chapinero.");
						estacion++;
					}
				} else if (estacion == 2) {
					if (pila.isEmpty()) {
						Console.printErrLine("El Bus esta vacio. El Bus volvera a la terminal.");
						Console.printLine("...");
						Console.printErrLine("El Bus ha llegado a la terminal. Esperando pasajeros...");
						estacion = 0;
					} else {
						Console.printSuccessLine("Partiendo de Chapinero a Usaquen (Terminal)");
						Console.printLine("...");
						Persona temp = pila.pop();
						Console.printSuccessLine(
								"La Persona " + temp.getNombre() + " se ha bajado en Usaquen (Terminal).");
						estacion = 0;
					}
				}

				break;
			}
			case 6: {
				Console.printLine("La trajectoria del Bus es: ");
				Console.printErrLine("Usaquen (Terminal) -> Suba -> Chapinero -> Usaquen (Terminal)");
				break;
			}
			case 7: {
				break ppal;
			}

			}

		}

	}

}
