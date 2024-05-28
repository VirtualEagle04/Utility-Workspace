package co.edu.unbosque.controller;

import co.edu.unbosque.util.Edge;
import co.edu.unbosque.util.Graph;
import co.edu.unbosque.util.MyLinkedList;
import co.edu.unbosque.util.Vertex;
import co.edu.unbosque.view.Console;

public class Controller {

	private MyLinkedList<Vertex> vertexes;
	private MyLinkedList<Edge> edges;
	private Graph graph;

	// Bellman-Ford Variables
	private final int INF = Integer.MAX_VALUE;
	private int[] distances;
	private int[] previous;

	public Controller() {

		vertexes = new MyLinkedList<>();
		edges = new MyLinkedList<>();
		graph = new Graph();

	}

	public void initialization(Vertex source) {
		distances = new int[vertexes.size()];
		previous = new int[vertexes.size()];

		for (int i = 0; i < vertexes.size(); i++) {
			distances[i] = INF;
			previous[i] = -1;

			if (vertexes.get(i).getData().equals(source)) {
				distances[i] = 0;
			}
		}
	}

	public boolean relaxation(int originIndex, int destinationIndex, int weight) {
		if (distances[originIndex] + weight < distances[destinationIndex]) {
			distances[destinationIndex] = distances[originIndex] + weight;
			previous[destinationIndex] = originIndex;
			return true;
		}
		return false;
	}

	public void bellmanFord(Vertex source) {
		// Print Node Row
		Console.print("Node  ");
		for (int i = 0; i < vertexes.size(); i++) {
			Console.print(" " + i + " ");
		}
		Console.printLine("");

		initialization(source);

		// Print Initialization Row
		Console.print("Init. ");
		Console.print("[");
		for (int i = 0; i < distances.length; i++) {
			if (i == distances.length - 1) {
				if (distances[i] == INF) {
					Console.print("-");
				} else {
					Console.print(distances[i] + "");
				}

			} else {
				if (distances[i] == INF) {
					Console.print("-, ");
				} else {
					Console.print(distances[i] + ", ");
				}
			}
		}
		Console.printLine("]");

		for (int current = 0; current < vertexes.size() - 1; current++) {
			for (int edges = 0; edges < vertexes.get(current).getData().getEdges().size(); edges++) {
				Vertex origin = vertexes.get(current).getData().getEdges().get(edges).getData().getSource();
				Vertex destination = vertexes.get(current).getData().getEdges().get(edges).getData().getDestination();
				int weight = vertexes.get(current).getData().getEdges().get(edges).getData().getWeight();

				int originIndex = 0;
				int destinationIndex = 0;

				for (int i = 0; i < vertexes.size(); i++) {
					if (vertexes.get(i).getData().equals(origin)) {
						originIndex = i;
					}
					if (vertexes.get(i).getData().equals(destination)) {
						destinationIndex = i;
					}
				}

				relaxation(originIndex, destinationIndex, weight);
			}
			Console.print("  " + current + "  ");
			Console.print("[");
			for (int i = 0; i < distances.length; i++) {
				if (i == distances.length - 1) {
					if (distances[i] == INF) {
						Console.print("-");
					} else {
						Console.print(distances[i] + "");
					}

				} else {
					if (distances[i] == INF) {
						Console.print("-, ");
					} else {
						Console.print(distances[i] + ", ");
					}
				}
			}
			Console.printLine("]");
		}
		Console.printLine("");

		// Check for Negative Cycles
		for (int e = 0; e < edges.size(); e++) {
			Vertex origin = edges.get(e).getData().getSource();
			Vertex destination = edges.get(e).getData().getDestination();
			int weight = edges.get(e).getData().getWeight();

			int originIndex = 0;
			int destinationIndex = 0;

			for (int i = 0; i < vertexes.size(); i++) {
				if (vertexes.get(i).getData().equals(origin)) {
					originIndex = i;
				}
				if (vertexes.get(i).getData().equals(destination)) {
					destinationIndex = i;
				}
			}

			if (relaxation(originIndex, destinationIndex, weight)) {
				Console.printErrLine("There is a Negative Cycle in the Graph.");
				return;
			}

		}
		Console.printSuccessLine("There is no Negative Cycle in the Graph.");
		Console.printLine("");
		Console.printLine("Shortest distance from Vertex {" + source.getName() + "}");
		for (int i = 0; i < vertexes.size(); i++) {
			Console.printLine("To Vertex {" + vertexes.get(i).getData().getName() + ": " + distances[i] + "}");
		}
	}

	public void run() {

		Graph graph = new Graph();

		Vertex pNorte = new Vertex("P. Norte");
		Vertex pSur = new Vertex("P. Sur");
		Vertex heroes = new Vertex("Heroes");
		Vertex pDorado = new Vertex("P. Dorado");
		Vertex suba = new Vertex("Suba");
		Vertex cll76 = new Vertex("Cll. 76");
		Vertex cll80 = new Vertex("Cll. 80");
		Vertex sMateo = new Vertex("S. Mateo");

		vertexes.addLast(pNorte);
		vertexes.addLast(pSur);
		vertexes.addLast(heroes);
		vertexes.addLast(pDorado);
		vertexes.addLast(suba);
		vertexes.addLast(cll76);
		vertexes.addLast(cll80);
		vertexes.addLast(sMateo);

		pNorte.addEdge(new Edge(pNorte, pSur, 8));
		pNorte.addEdge(new Edge(pNorte, heroes, 2));
		pNorte.addEdge(new Edge(pNorte, suba, 10));

		pSur.addEdge(new Edge(pSur, pDorado, 3));

		heroes.addEdge(new Edge(heroes, cll76, 1));
		heroes.addEdge(new Edge(heroes, suba, 2));

		pDorado.addEdge(new Edge(pDorado, sMateo, 5));

		suba.addEdge(new Edge(suba, cll80, 3));

		cll76.addEdge(new Edge(cll76, suba, 5));

		cll80.addEdge(new Edge(cll80, sMateo, 2));

		for (int i = 0; i < vertexes.size(); i++) {
			for (int e = 0; e < vertexes.get(i).getData().getEdges().size(); e++) {
				edges.addLast(vertexes.get(i).getData().getEdges().get(e).getData());
			}
		}

		graph.addVertex(pNorte);
		graph.addVertex(pSur);
		graph.addVertex(heroes);
		graph.addVertex(pDorado);
		graph.addVertex(suba);
		graph.addVertex(cll76);
		graph.addVertex(cll80);
		graph.addVertex(sMateo);

		ppal: while (true) {
			Console.printLine(
					"1) Manage Vertex\n2) Manage edges\n3) View Graph\n4) Run Bellman-Ford Algorithm\n5) Exit");

			int op = Console.readInt();
			Console.printLine("-----------------------------------------------------------");
			switch (op) {
			case 1: { // Manage Vertex
				vertex: while (true) {
					Console.printLine("1) Add Vertex\n2) Delete Vertex\n3) Return");
					int vertexOp = Console.readInt();
					Console.printLine("-----------------------------------------------------------");
					switch (vertexOp) {
					case 1: { // Add Vertex
						Console.print("Vertex Amount: ");
						int vertexCount = Console.readInt();
						Console.burnLine();
						for (int i = 0; i < vertexCount; i++) {
							Console.printLine("Vertex " + i + " name: ");
							vertexes.addLast(new Vertex(Console.readLine()));
							Console.printSuccessLine("Vertex " + i + " created.");
						}

						break;
					}
					case 2: { // Delete Vertex
						if (graph.getNodesList().isEmpty()) {
							Console.printErrLine("The graph is empty.");
							break;
						} else {
							Console.printLine("Insert Vertex name to delete: ");
							Console.burnLine();
							String targetVertex = Console.readLine();

							for (int i = 0; i < vertexes.size(); i++) {
								if (vertexes.get(i).getData().getName().equals(targetVertex)) {
									vertexes.remove(vertexes.indexOf(vertexes.get(i).getData()));
									Console.printSuccessLine("Vertex " + targetVertex + " deleted.");
									break;
								}
							}
							break;
						}

					}
					case 3: { // Return
						break vertex;
					}
					}
				}
				break;
			}
			case 2: { // Manage edges
				edge: while (true) {
					Console.printLine("1) Add Edge\n2) Delete Edge\n3) Return");
					int edgeOp = Console.readInt();
					Console.printLine("-----------------------------------------------------------");
					switch (edgeOp) {
					case 1: { // Add Edge
						Console.print("Edge Amount: ");
						int edgeCount = Console.readInt();
						Console.burnLine();
						for (int i = 0; i < edgeCount; i++) {
							Console.printLine("Edge [" + i + "] origin: ");
							for (int v = 0; v < vertexes.size(); v++) {
								Console.printLine(v + ") " + vertexes.get(v).getData().getName());
							}
							Vertex origin = vertexes.get(Console.readInt()).getData();

							Console.printLine("Edge [" + i + "] destination: ");
							for (int v = 0; v < vertexes.size(); v++) {
								Console.printLine(v + ") " + vertexes.get(v).getData().getName());
							}
							Vertex destination = vertexes.get(Console.readInt()).getData();

							Console.printLine("Edge [" + i + "] weight");
							int weight = Console.readInt();

							Edge tempEdge = new Edge(origin, destination, weight);
							edges.addLast(tempEdge);

							origin.addEdge(tempEdge);

							Console.printSuccessLine("Edge " + i + " created.");
						}

						break;
					}
					case 2: { // Delete Edge
						Console.printLine("Insert Edge index to delete: ");
						for (int i = 0; i < edges.size(); i++) {
							Console.printLine(i + ") " + edges.get(i).toString());
						}
						int targetIndex = Console.readInt();

						edges.remove(targetIndex);
						Console.printSuccessLine("Edge [" + targetIndex + "] deleted.");
						break;
					}
					case 3: { // Return
						break edge;
					}
					}
				}
				break;
			}
			case 3: { // View Graph
				for (int i = graph.getNodesList().size() - 1; i >= 0; i--) {
					graph.getNodesList().remove(i);
				}
				for (int i = 0; i < vertexes.size(); i++) {
					graph.addVertex(vertexes.get(i).getData());
				}
				if (graph.getNodesList().isEmpty()) {
					Console.printErrLine("Graph is empty.");
				} else {
					Console.printLine(graph.toString());
				}
				break;

			}
			case 4: { // Do Bellman-Ford
				if (graph.getNodesList().isEmpty()) {
					Console.printErrLine("Graph is empty.");
					break;
				}

				Console.printLine("Insert Source Vertex:");
				for (int v = 0; v < vertexes.size(); v++) {
					Console.printLine(v + ") " + vertexes.get(v).getData().getName());
				}
				Vertex source = vertexes.get(Console.readInt()).getData();
				Console.printLine("-----------------------------------------------------------");
				bellmanFord(source);
			}
			case 5: {
				break ppal;
			}
			default:
				break;
			}

		}

	}

}
