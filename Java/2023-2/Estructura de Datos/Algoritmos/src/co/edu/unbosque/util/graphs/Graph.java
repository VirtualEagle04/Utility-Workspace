package co.edu.unbosque.util.graphs;

import co.edu.unbosque.util.simplelist.MyLinkedList;

public class Graph {

	private MyLinkedList<Vertex> nodesList;

	public Graph() {
		this.nodesList = new MyLinkedList<Vertex>();
	}

	public MyLinkedList<Vertex> getNodesList() {
		return nodesList;
	}

	public void setNodesList(MyLinkedList<Vertex> nodesList) {
		this.nodesList = nodesList;
	}

	public void addVertex(Vertex newVertex) {
		this.nodesList.addLast(newVertex);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Graph:\n");
		
		for(int i = 0; i < nodesList.size(); i++) {
			sb.append(nodesList.get(i).getData().toString());
			sb.append("-----------------------------------------------------------\n");
		}
		return sb.toString();
	}

}
