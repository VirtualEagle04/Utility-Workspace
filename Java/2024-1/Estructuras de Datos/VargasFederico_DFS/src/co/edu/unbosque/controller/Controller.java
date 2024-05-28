package co.edu.unbosque.controller;

import java.util.LinkedList;
import java.util.Stack;
import co.edu.unbosque.util.graphs.Edge;
import co.edu.unbosque.util.graphs.Graph;
import co.edu.unbosque.util.graphs.Vertex;
import co.edu.unbosque.util.simplelist.MyLinkedList;
import co.edu.unbosque.view.Console;

public class Controller {

	private Graph grafo;
	private Vertex juanCarlos, felipe, elena, cristina, leonor, sofia, frollan, victoriaFederica, juanValentin,
			pabloNicolas, miguel, irene;

	public Controller() {
	}

	public void run() {

		// Creacion del Grafo

		grafo = new Graph();

		juanCarlos = new Vertex("Juan Carlos");
		felipe = new Vertex("Felipe");
		elena = new Vertex("Elena");
		cristina = new Vertex("Cristina");
		leonor = new Vertex("Leonor");
		sofia = new Vertex("Sofia");
		frollan = new Vertex("Frollan");
		victoriaFederica = new Vertex("Victoria Federica");
		juanValentin = new Vertex("Juan Valentin");
		pabloNicolas = new Vertex("Pablo Nicolas");
		miguel = new Vertex("Miguel");
		irene = new Vertex("Irene");

		juanCarlos.addEdge(new Edge(juanCarlos, cristina, 0));
		juanCarlos.addEdge(new Edge(juanCarlos, elena, 0));
		juanCarlos.addEdge(new Edge(juanCarlos, felipe, 0));

		felipe.addEdge(new Edge(felipe, sofia, 0));
		felipe.addEdge(new Edge(felipe, leonor, 0));

		elena.addEdge(new Edge(elena, victoriaFederica, 0));
		elena.addEdge(new Edge(elena, frollan, 0));

		cristina.addEdge(new Edge(cristina, irene, 0));
		cristina.addEdge(new Edge(cristina, miguel, 0));
		cristina.addEdge(new Edge(cristina, pabloNicolas, 0));
		cristina.addEdge(new Edge(cristina, juanValentin, 0));

		grafo.addVertex(juanCarlos);
		grafo.addVertex(felipe);
		grafo.addVertex(elena);
		grafo.addVertex(cristina);
		grafo.addVertex(leonor);
		grafo.addVertex(sofia);
		grafo.addVertex(frollan);
		grafo.addVertex(victoriaFederica);
		grafo.addVertex(juanValentin);
		grafo.addVertex(pabloNicolas);
		grafo.addVertex(miguel);
		grafo.addVertex(irene);

		DFS();

	}

	public void DFS() {

		Vertex origen = juanCarlos;

		Stack<Vertex> pila = new Stack<Vertex>();
		LinkedList<Vertex> visitados = new LinkedList<Vertex>();

		pila.push(origen);
		visitados.add(origen);

		impGrafo(pila.peek(), 0, false);
		Console.printLine("");
		impPila(pila);
		Console.printLine("");
		impLista(visitados);

		while (!pila.isEmpty()) {
			Vertex actual = pila.pop();
			visitados.add(actual);

			Console.printErrLine("Vertice Actual: " + actual.getName());

			MyLinkedList<Edge> adjacentes = actual.getEdges();
			for (int i = 0; i < adjacentes.size(); i++) {
				if (!visitados.contains(adjacentes.get(i).getData().getDestination())) {
					pila.push(adjacentes.get(i).getData().getDestination());
				}
			}
			impPila(pila);
			Console.printLine("");
			impLista(visitados);
		}

	}

	public void impGrafo(Vertex actual, int capa, boolean end) {
		Console.printLine(actual.getName());

		if (actual.getEdges().isEmpty()) { // Sin Caminos
			Console.print(">");
			Console.printLine("X");
		} else { // Con Caminos

			for (int i = 0; i < actual.getEdges().size(); i++) { // Para cada camino
				if ((i == actual.getEdges().size() - 1)) {
				}

				for (int l = 0; l < capa; l++) {
					Console.print(" ");

					if (l >= 0) {
						Console.print(">");
					}
				}

				if (i + 1 < actual.getEdges().size()) {
					Console.print(">");
				} else {
					Console.print(">");
				}
				if (!actual.getEdges().get(i).getData().getDestination().getEdges().isEmpty()) {
					impGrafo(actual.getEdges().get(i).getData().getDestination(), capa + 1, false);
				} else {
					Console.printLine(actual.getEdges().get(i).getData().getDestination().getName());
				}
			}
		}
	}

	public void impPila(Stack<Vertex> p) {
		Console.printSuccessLine("PILA");

		Stack<Vertex> temp = new Stack<Vertex>();
		temp.addAll(p);
		Stack<Vertex> temp2 = new Stack<Vertex>();
		temp2.addAll(p);

		String masLargo = "";
		while (!temp.isEmpty()) {
			String nombre = (String) temp.pop().getName();
			if (nombre.length() > masLargo.length()) {
				masLargo = nombre;
			}
		}

		Console.print("+-");
		for (int i = 0; i < masLargo.length(); i++) {
			Console.print("-");
		}
		Console.printLine("-+");
		
		while (!temp2.isEmpty()) {
			Console.print("| ");
			String nombre = temp2.pop().getName();
			Console.print(nombre);
			for(int i = 0; i < masLargo.length()-nombre.length(); i++) {
				Console.print(" ");
			}
			Console.printLine(" |");
			
			Console.print("+-");
			for (int i = 0; i < masLargo.length(); i++) {
				Console.print("-");
			}
			Console.printLine("-+");
		}
	}

	public void impLista(LinkedList<Vertex> l) {
		Console.printSuccessLine("VISITADOS");
		Console.print("[ ");
		for (Vertex v : l) {
			Console.print(v.getName() + " - ");
		}
		Console.printLine("]\n\n");
	}

}
