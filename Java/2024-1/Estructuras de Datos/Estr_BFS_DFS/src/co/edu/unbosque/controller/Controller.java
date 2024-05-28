package co.edu.unbosque.controller;

import co.edu.unbosque.util.graphs.Vertex;
import co.edu.unbosque.util.simplelist.MyLinkedList;
import co.edu.unbosque.view.Console;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import co.edu.unbosque.util.graphs.Edge;
import co.edu.unbosque.util.graphs.Graph;

public class Controller {

	private Graph grafo;
	private MyLinkedList<Vertex> vertices;
	private Vertex v0, v1, v2, v3, v4, v5, v6, v7;

	public Controller() {
		grafo = new Graph();
		vertices = new MyLinkedList<Vertex>();

		// Creacion del Grafo
		v0 = new Vertex("0");
		v1 = new Vertex("1");
		v2 = new Vertex("2");
		v3 = new Vertex("3");
		v4 = new Vertex("4");
		v5 = new Vertex("5");
		v6 = new Vertex("6");
		v7 = new Vertex("7");

		vertices.addLast(v0);
		vertices.addLast(v1);
		vertices.addLast(v2);
		vertices.addLast(v3);
		vertices.addLast(v4);
		vertices.addLast(v5);
		vertices.addLast(v6);
		vertices.addLast(v7);

		v0.addEdge(new Edge(v0, v1, 0));

		v1.addEdge(new Edge(v1, v0, 0));
		v1.addEdge(new Edge(v1, v4, 0));
		v1.addEdge(new Edge(v1, v5, 0));

		v2.addEdge(new Edge(v2, v4, 0));
		v2.addEdge(new Edge(v2, v5, 0));
		v2.addEdge(new Edge(v2, v3, 0));

		v3.addEdge(new Edge(v3, v2, 0));
		v3.addEdge(new Edge(v3, v6, 0));

		v4.addEdge(new Edge(v4, v1, 0));
		v4.addEdge(new Edge(v4, v2, 0));

		v5.addEdge(new Edge(v5, v1, 0));
		v5.addEdge(new Edge(v5, v2, 0));
		v5.addEdge(new Edge(v5, v6, 0));

		v6.addEdge(new Edge(v6, v5, 0));
		v6.addEdge(new Edge(v6, v3, 0));

		for (int i = 0; i < vertices.size(); i++) {
			grafo.addVertex(vertices.get(i).getData());
		}

	}

	public void BFS() {
		Console.printSuccessLine("BFS (Busqueda en Anchura)");

		Vertex origen = v3;

		Queue<Vertex> cola = new LinkedList<Vertex>();
		LinkedList<Vertex> visitados = new LinkedList<Vertex>();
		cola.add(origen);
		visitados.add(origen);

		// Cola
		Console.printSuccessLine("COLA");
		Console.print("[");
		for (Vertex v : cola) {
			Console.print(v.getName() + " ");
		}
		Console.printLine("]");

		// Visitados
		Console.printSuccessLine("VISITADOS");
		Console.print("[");
		for (Vertex v : visitados) {
			Console.print(v.getName() + " ");
		}
		Console.printLine("]\n");

		while (cola.size() != 0) {
			Vertex actual = cola.poll();
			Console.printErrLine("Vertice actual: " + actual.getName());
			MyLinkedList<Edge> adjacentes = actual.getEdges();

			for (int i = 0; i < adjacentes.size(); i++) {
				if (visitados.contains(adjacentes.get(i).getData().getDestination())) {
					continue;
				} else {
					cola.add(adjacentes.get(i).getData().getDestination());
					visitados.add(adjacentes.get(i).getData().getDestination());
				}
			}
			// Cola
			Console.printSuccessLine("COLA");
			Console.print("[");
			for (Vertex v : cola) {
				Console.print(v.getName() + " ");
			}
			Console.printLine("]");

			// Visitados
			Console.printSuccessLine("VISITADOS");
			Console.print("[");
			for (Vertex v : visitados) {
				Console.print(v.getName() + " ");
			}
			Console.printLine("]\n");
		}
		Console.printSuccessLine("-------------------------------");
	}

	public void DFS() {
		Console.printSuccessLine("DFS (Busqueda en Profundidad)");

		Vertex origen = v3;

		Stack<Vertex> pila = new Stack<Vertex>();
		LinkedList<Vertex> visitados = new LinkedList<Vertex>();

		pila.push(origen);
		visitados.push(origen);

		// Pila
		Console.printSuccessLine("PILA");
		Console.print("[");
		for (Vertex v : pila) {
			Console.print(v.getName() + " ");
		}
		Console.printLine("]");

		// Visitados
		Console.printSuccessLine("VISITADOS");
		Console.print("[");
		for (Vertex v : visitados) {
			Console.print(v.getName() + " ");
		}
		Console.printLine("]\n");

		while (!pila.isEmpty()) {
			Vertex actual = pila.pop();
			Console.printErrLine("Vertice actual: " + actual.getName());
			MyLinkedList<Edge> adjacentes = actual.getEdges();

			for (int i = 0; i < adjacentes.size(); i++) {
				if (!visitados.contains(adjacentes.get(i).getData().getDestination())) {
					pila.push(adjacentes.get(i).getData().getDestination());
					visitados.add(adjacentes.get(i).getData().getDestination());
				}
			}

			// Pila
			Console.printSuccessLine("PILA");
			Console.print("[");
			for (Vertex v : pila) {
				Console.print(v.getName() + " ");
			}
			Console.printLine("]");

			// Visitados
			Console.printSuccessLine("VISITADOS");
			Console.print("[");
			for (Vertex v : visitados) {
				Console.print(v.getName() + " ");
			}
			Console.printLine("]\n");

		}
		Console.printSuccessLine("-------------------------------");

	}

}
