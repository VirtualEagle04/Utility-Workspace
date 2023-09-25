package co.edu.unbosque.util.algorithm;

import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.util.graphs.Edge;
import co.edu.unbosque.util.graphs.Vertex;
import co.edu.unbosque.util.stackqueue.StackImp;
import co.edu.unbosque.view.Console;
import co.edu.unbosque.util.simplelist.MyLinkedList;

public class DepthFirstSearch extends AbstractSearch {

	private StackImp<Vertex<?>> stackOfNodes = new StackImp<Vertex<?>>();
	private MyLinkedList<Vertex<?>> visitedNodes = new MyLinkedList<Vertex<?>>();
	private int degree;

	public DepthFirstSearch(Vertex<?> sourceVertex, Vertex<?> destinationVertex) {
		super(sourceVertex, destinationVertex);
		degree = 0;
	}

	@Override
	public boolean runSearch() {

		if (this.sourceVertex.equals(destinationVertex)) {
			Console.printSuccessLine("Source is Target. Depth: " + degree);
			UserDTO tempData = (UserDTO) sourceVertex.getInfo();
			Console.printSuccessLine(tempData.getUsername());
			return true;
		}

		stackOfNodes.push(sourceVertex);
		Console.printSuccessLine("Users have conection with following path: ");

		ppal: while (stackOfNodes.size() != 0) {

			Vertex<?> current = stackOfNodes.pop();
			for(int i = 0; i < visitedNodes.size(); i++) {
				if(visitedNodes.get(i).getData().equals(current)) {
					continue ppal;
				}
			}
			
			if (current.equals(destinationVertex)) {
				UserDTO tempData = (UserDTO) destinationVertex.getInfo();
				Console.printLine(tempData.getUsername());
				Console.printSuccessLine("Found Target at depth: " + degree);
				UserDTO tempSource = (UserDTO) visitedNodes.get(0).getData().getInfo();
				if(degree == 1) {
					Console.printSuccessLine(tempSource.getUsername() +" has DIRECT connection with "+tempData.getUsername());
				}else {
					Console.printSuccessLine(tempSource.getUsername() +" has INDIRECT connection with "+tempData.getUsername());
				}
				return true;
			} else {
				degree++;
				UserDTO tempData = (UserDTO) current.getInfo();
				Console.print(tempData.getUsername() + " -> ");
				visitedNodes.addLast(current);
				MyLinkedList<Edge> adyacents = current.getAdyacentEdges();

				while (!adyacents.isEmpty()) {
					stackOfNodes.push(adyacents.extract().getDestination());
				}
			}
		}
		return false;

	}

	public StackImp<Vertex<?>> getStackOfNodes() {
		return stackOfNodes;
	}

	public void setStackOfNodes(StackImp<Vertex<?>> stackOfNodes) {
		this.stackOfNodes = stackOfNodes;
	}

	public MyLinkedList<Vertex<?>> getVisitedNodes() {
		return visitedNodes;
	}

	public void setVisitedNodes(MyLinkedList<Vertex<?>> visitedNodes) {
		this.visitedNodes = visitedNodes;
	}

}
