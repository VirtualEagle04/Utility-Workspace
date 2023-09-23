package co.edu.unbosque.util.algorithm;

import co.edu.unbosque.util.graphs.Edge;
import co.edu.unbosque.util.graphs.Vertex;
import co.edu.unbosque.util.simplelist.MyLinkedList;
import co.edu.unbosque.util.stackqueue.QueueImp;
import co.edu.unbosque.view.Console;

public class BreadthFirstSearch extends AbstractSearch {

	private QueueImp<Vertex> nodeQueue;
	private MyLinkedList<Vertex> visitedNodes;

	public BreadthFirstSearch(Vertex sourceVertex, Vertex destinationVertex) {
		super(sourceVertex, destinationVertex);
		nodeQueue = new QueueImp<Vertex>();
		visitedNodes = new MyLinkedList<Vertex>();
	}

	public QueueImp<Vertex> getNodeQueue() {
		return nodeQueue;
	}

	public void setNodeQueue(QueueImp<Vertex> nodeQueue) {
		this.nodeQueue = nodeQueue;
	}

	public MyLinkedList<Vertex> getVisitedNodes() {
		return visitedNodes;
	}

	public void setVisitedNodes(MyLinkedList<Vertex> visitedNodes) {
		this.visitedNodes = visitedNodes;
	}

	public void printGraph(Vertex current, int layer, boolean end) {
		Console.printLine(current.getName());

		if (current.getEdges().isEmpty()) { // Sin Caminos
			Console.printTree(2);
			Console.printTree(0);
			Console.printLine("X");
		} else { // Con Caminos

			for (int i = 0; i < current.getEdges().size(); i++) { // Para cada camino
				if ((i == current.getEdges().size() - 1)) {
				}

				for (int l = 0; l < layer; l++) {
					Console.printTree(1);

					if (l >= 0) {
						Console.print(" ");
					}
				}

				if (i + 1 < current.getEdges().size()) {
					Console.printTree(3);
				} else {
					Console.printTree(2);
				}
				Console.printTree(0);
				if (!current.getEdges().get(i).getData().getDestination().getEdges().isEmpty()) {
					printGraph(current.getEdges().get(i).getData().getDestination(), layer + 1, false);
				} else {
					Console.printLine(current.getEdges().get(i).getData().getDestination().getName());
				}
			}
		}
	}

	@Override
	public boolean runSearch() {
		if (this.sourceVertex.equals(this.destinationVertex)) {
			Console.printSuccessLine("Nodo destino encontrado. Anchura: 0");
			Console.printLine(this.sourceVertex.getName());
			return true;
		}
		nodeQueue.enqueue(this.sourceVertex);
		visitedNodes.addLast(this.sourceVertex);

		printGraph(nodeQueue.peek(), 0, false);
		Console.printLine("");

		Console.printLine("Conexiones:");
		while (nodeQueue.size() != 0) {

			Vertex current = nodeQueue.dequeue();

			if (current.equals(this.destinationVertex)) {
				Console.printLine(this.destinationVertex.getName());
				Console.printSuccessLine("Nodo destino encontrado.");

				return true;
			} else {
				Console.print(current.getName() + " -> ");

				if (current.getEdges().isEmpty()) {
					continue;
				} else {
					MyLinkedList<Edge> adjacents = current.getEdges();

					while (!adjacents.isEmpty()) {
						nodeQueue.enqueue(adjacents.extract().getDestination());
					}
				}
			}
			visitedNodes.addLast(current);
		}
		return false;
	}

}
