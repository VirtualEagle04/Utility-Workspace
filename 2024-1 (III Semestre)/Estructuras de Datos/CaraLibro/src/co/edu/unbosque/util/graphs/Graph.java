package co.edu.unbosque.util.graphs;

import co.edu.unbosque.util.simplelist.MyLinkedList;

public class Graph {
	private MyLinkedList<Vertex<?>> listOfNodes;
	
	public Graph() {
		listOfNodes= new MyLinkedList<Vertex<?>>();
	}
	
	public void addVertex(Vertex<?> v) {
		listOfNodes.addLast(v);
	}

	public MyLinkedList<Vertex<?>> getListOfNodes() {
		return listOfNodes;
	}

	public void setListOfNodes(MyLinkedList<Vertex<?>> listOfNodes) {
		this.listOfNodes = listOfNodes;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Graph:\n");
		
		for(int i = 0; i < listOfNodes.size(); i++) {
			sb.append(listOfNodes.get(i).getData().toString());
			sb.append("-----------------------------------------------------------\n");
		}
		return sb.toString();
	}
	
}
