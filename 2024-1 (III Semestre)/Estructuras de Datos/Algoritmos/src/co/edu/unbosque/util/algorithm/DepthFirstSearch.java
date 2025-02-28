package co.edu.unbosque.util.algorithm;

import co.edu.unbosque.util.graphs.Edge;
import co.edu.unbosque.util.graphs.Vertex;
import co.edu.unbosque.util.simplelist.MyLinkedList;
import co.edu.unbosque.util.stackqueue.StackImp;
import co.edu.unbosque.view.Console;

public class DepthFirstSearch extends AbstractSearch {

	private StackImp<Vertex> nodeStack;
	private MyLinkedList<Vertex> visitedNodes;

	public DepthFirstSearch(Vertex sourceVertex, Vertex destinationVertex) {
		super(sourceVertex, destinationVertex);
		nodeStack = new StackImp<Vertex>();
		visitedNodes = new MyLinkedList<Vertex>();
	}

	public StackImp<Vertex> getNodeStack() {
		return nodeStack;
	}

	public void setNodeStack(StackImp<Vertex> nodeStack) {
		this.nodeStack = nodeStack;
	}

	public MyLinkedList<Vertex> getVisitedNodes() {
		return visitedNodes;
	}

	public void setVisitedNodes(MyLinkedList<Vertex> visitedNodes) {
		this.visitedNodes = visitedNodes;
	}

	@Override
	public boolean runSearch() {
		if (this.sourceVertex.equals(this.destinationVertex)) {
			Console.printSuccessLine("Nodo destino encontrado. Profunidad: 0");
			Console.printLine(this.sourceVertex.getName());
			return true;
		}
		nodeStack.push(this.sourceVertex);
		
		Console.printLine("Ruta a seguir para ubicar el nodo");
		while (nodeStack.size() != 0) {

			Vertex current = nodeStack.pop();

			if (current.equals(this.destinationVertex)) {
				Console.printLine(this.destinationVertex.getName());
				Console.printSuccessLine("Nodo destino encontrado.");

				return true;
			} else {
				Console.print(current.getName() + " -> ");
				visitedNodes.addLast(current);
				MyLinkedList<Edge> adjacents = current.getEdges();

				while (!adjacents.isEmpty()) {
					nodeStack.push(adjacents.extract().getDestination());
				}

			}
		}
		return false;
	}

}
