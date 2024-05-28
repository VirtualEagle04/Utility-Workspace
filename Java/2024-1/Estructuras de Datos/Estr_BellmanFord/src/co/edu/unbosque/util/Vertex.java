package co.edu.unbosque.util;

public class Vertex {

	private String name;
	private MyLinkedList<Edge> edges; // TODOS LOS CAMINOS A LOS NODOS ADYACENTES. (Con nuestra propia LinkedList)

	public Vertex(String name) {
		this.name = name;
		this.edges = new MyLinkedList<Edge>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyLinkedList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(MyLinkedList<Edge> edges) {
		this.edges = edges;
	}

	public void addEdge(Edge newEdge) {
		this.edges.addLast(newEdge);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("• Vertex: " + name + "\n");
		for (int i = 0; i < edges.size(); i++) {
			sb.append("		> Edge: " + edges.get(i).getData().toString() + "\n");
		}
		return sb.toString();
	}

}
