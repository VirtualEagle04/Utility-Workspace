package co.edu.unbosque.controller;

import co.edu.unbosque.util.Edge;
import co.edu.unbosque.util.Graph;
import co.edu.unbosque.util.MyLinkedList;
import co.edu.unbosque.util.Vertex;
import co.edu.unbosque.view.Console;

public class Controller {

	public Controller() {
		
	}

	public void run() {

		MyLinkedList<Vertex> nodos = new MyLinkedList<Vertex>();
		Graph grafo = new Graph();
		
		//Nodos / Vertices
		
		Vertex audrey = new Vertex("Audrey");
		Vertex llama = new Vertex("Llama");
		Vertex harry = new Vertex("Harry");
		Vertex gayle = new Vertex("Gayle");
		Vertex frank = new Vertex("Frank");
		Vertex emily = new Vertex("Emily");
		Vertex dave = new Vertex("Dave");
		Vertex cathy = new Vertex("Cathy");
		Vertex bill = new Vertex("Bill");
		Vertex jeff = new Vertex("Jeff");
		
		//Caminos / Aristas
		
		Edge al = new Edge(audrey, llama, 1);
		Edge ag = new Edge(audrey, gayle, 1);
		Edge ab = new Edge(audrey, bill, 1);
		audrey.addEdge(al);
		audrey.addEdge(ag);
		audrey.addEdge(ab);
		
		Edge la = new Edge(llama, audrey, 1);
		Edge lh = new Edge(llama, harry, 1);
		Edge ld = new Edge(llama, dave, 1);
		llama.addEdge(la);
		llama.addEdge(lh);
		llama.addEdge(ld);
		
		Edge hl = new Edge(harry, llama, 1);
		Edge hj = new Edge(harry, jeff, 1);
		harry.addEdge(hl);
		harry.addEdge(hj);
		
		Edge ga = new Edge(gayle, audrey, 1); 
		Edge gb = new Edge(gayle, bill, 1);
		Edge gc = new Edge(gayle, cathy, 1);
		gayle.addEdge(ga);
		gayle.addEdge(gb);
		gayle.addEdge(gc);
		
		Edge fe = new Edge(frank, emily, 1);
		Edge fd = new Edge(frank, dave, 1);
		frank.addEdge(fe);
		frank.addEdge(fd);
		
		Edge ef = new Edge(emily, frank, 1);
		Edge ej = new Edge(emily, jeff, 1);
		Edge eb = new Edge(emily, bill, 1);
		Edge ed = new Edge(emily, dave, 1);
		emily.addEdge(ef);
		emily.addEdge(ej);
		emily.addEdge(eb);
		emily.addEdge(ed);
		
		Edge de = new Edge(dave, emily, 1);
		Edge dl = new Edge(dave, llama, 1);
		Edge df = new Edge(dave, frank, 1);
		dave.addEdge(de);
		dave.addEdge(dl);
		dave.addEdge(df);
		
		Edge ce = new Edge(cathy, emily, 1);
		Edge cg = new Edge(cathy, gayle, 1);
		cathy.addEdge(ce);
		cathy.addEdge(cg);
		
		Edge ba = new Edge(bill, audrey, 1);
		Edge bj = new Edge(bill, jeff, 1);
		Edge be = new Edge(bill, emily, 1);
		Edge bg = new Edge(bill, gayle, 1);
		bill.addEdge(ba);
		bill.addEdge(bj);
		bill.addEdge(be);
		bill.addEdge(bg);
		
		
		Edge jh = new Edge(jeff, harry, 1);
		Edge je = new Edge(jeff, emily, 1);
		Edge jb = new Edge(jeff, bill, 1);
		jeff.addEdge(jh);
		jeff.addEdge(je);
		jeff.addEdge(jb);
		
		nodos.add(audrey);
		nodos.add(llama);
		nodos.add(harry);
		nodos.add(gayle);
		nodos.add(frank);
		nodos.add(emily);
		nodos.add(dave);
		nodos.add(cathy);
		nodos.add(bill);
		nodos.add(jeff);
		
		for(int i = 0; i < nodos.size(); i++) {
			grafo.addVertex(nodos.get(i).getData());
		}
		Console.printLine(grafo.toString());
		
		
//		['Harry', 'Llama', 'Dave', 'Emily', 'Jeff', 'Harry']
//		['Harry', 'Llama', 'Dave', 'Frank', 'Emily', 'Jeff', 'Harry']
//		['Harry', 'Jeff', 'Bill', 'Audrey', 'Llama', 'Harry']
//		['Harry', 'Jeff', 'Bill', 'Gayle', 'Audrey', 'Llama', 'Harry']
//		['Harry', 'Jeff', 'Emily', 'Dave', 'Llama', 'Harry']
//		['Harry', 'Jeff', 'Emily', 'Frank', 'Dave', 'Llama', 'Harry']
		
	}

}
