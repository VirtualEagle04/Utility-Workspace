package co.edu.unbosque.controller;

import co.edu.unbosque.util.graphs.Edge;
import co.edu.unbosque.util.graphs.Graph;
import co.edu.unbosque.util.graphs.Vertex;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import co.edu.unbosque.util.algorithm.AbstractSearch;
import co.edu.unbosque.util.algorithm.BreadthFirstSearch;
import co.edu.unbosque.util.algorithm.DepthFirstSearch;
import co.edu.unbosque.view.Console;

public class MainGraphs {

	public static void main(String[] args) {
		//doGraph1();
		doGraph2();
	}

	public static void doGraph1() {
		Graph g1 = new Graph();
		Vertex bogota = new Vertex("Bogota");
		Vertex neiva = new Vertex("Neiva");
		Vertex villavicencio = new Vertex("Villavicencio");
		Vertex melgar = new Vertex("Melgar");
		Vertex medellin = new Vertex("Medellin");

		bogota.addEdge(new Edge(bogota, medellin, 200));
		bogota.addEdge(new Edge(bogota, neiva, 100));

		medellin.addEdge(new Edge(medellin, neiva, 300));
		medellin.addEdge(new Edge(medellin, melgar, 400));

		villavicencio.addEdge(new Edge(villavicencio, bogota, 200));
		villavicencio.addEdge(new Edge(villavicencio, melgar, 100));

		g1.addVertex(bogota);
		g1.addVertex(neiva);
		g1.addVertex(villavicencio);
		g1.addVertex(melgar);
		g1.addVertex(medellin);
		
		Console.printLine(g1.toString());

		AbstractSearch dfs = new DepthFirstSearch(bogota, villavicencio);
		if (dfs.runSearch()) {
			Console.printSuccessLine("Destino alcanzado!");
		} else {
			Console.printErrLine("El destino no se alcanzo");
		}

	}

	public static void doGraph2() {
		Graph g2 = new Graph();
		Vertex v0 = new Vertex("0");
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Vertex v6 = new Vertex("6");
		Vertex v7 = new Vertex("7");
		Vertex v8 = new Vertex("8");

		v0.addEdge(new Edge(v0, v1, 1));
		v0.addEdge(new Edge(v0, v2, 1));
		v0.addEdge(new Edge(v0, v3, 1));

		v2.addEdge(new Edge(v2, v6, 1));
		v2.addEdge(new Edge(v2, v5, 1));
		v2.addEdge(new Edge(v2, v8, 1));

		v3.addEdge(new Edge(v3, v4, 1));

		v4.addEdge(new Edge(v4, v8, 1));

		v5.addEdge(new Edge(v5, v7, 1));

		g2.addVertex(v0);
		g2.addVertex(v1);
		g2.addVertex(v2);
		g2.addVertex(v3);
		g2.addVertex(v4);
		g2.addVertex(v5);
		g2.addVertex(v6);
		g2.addVertex(v7);
		g2.addVertex(v8);

		BreadthFirstSearch bfs = new BreadthFirstSearch(v0, v8);
		if (bfs.runSearch()) {
			Console.printSuccessLine("Destino alcanzado!");
		} else {
			Console.printErrLine("El destino no se alcanzo");
		}

	}

}
