package co.edu.unbosque.controller;

import co.edu.unbosque.util.graphs.Edge;
import co.edu.unbosque.util.graphs.Graph;
import co.edu.unbosque.util.graphs.Vertex;
import co.edu.unbosque.util.simplelist.MyLinkedList;
import co.edu.unbosque.view.Console;

public class Controller {

	public Controller() {

	}

	public void runGraph() {

		MyLinkedList<Vertex> vertexes = new MyLinkedList<Vertex>();
		MyLinkedList<Edge> edges = new MyLinkedList<Edge>();
		Graph testGraph = new Graph();

		ppal: while (true) {
			Console.printLine("1) Manage Vertex\n2) Manage Edges\n3) View Graph\n4) Exit");

			int op = Console.readInt();
			switch (op) {
			case 1: { // Manage Vertex
				vertex: while (true) {
					Console.printLine("1) Add Vertex\n2) Delete Vertex\n3) Return");
					int vertexOp = Console.readInt();
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
						Console.printLine("Insert Vertex name to delete: ");
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
					case 3: { // Return
						break vertex;
					}
					}
				}
				break;
			}
			case 2: { // Manage Edges
				edge: while (true) {
					Console.printLine("1) Add Edge\n2) Delete Edge\n3) Return");
					int edgeOp = Console.readInt();
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
				for (int i = testGraph.getNodesList().size() - 1; i >= 0; i--) {
					testGraph.getNodesList().remove(i);
				}
				for (int i = 0; i < vertexes.size(); i++) {
					testGraph.addVertex(vertexes.get(i).getData());
				}
				if (testGraph.getNodesList().isEmpty()) {
					Console.printErrLine("Graph is empty.");
				} else {
					Console.printLine(testGraph.toString());
				}
				break;
			}
			case 4: {
				break ppal;
			}
			default:
				break;
			}

		}

	}
	
}
