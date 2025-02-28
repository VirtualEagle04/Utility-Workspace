package co.edu.unbosque.util;

public class Edge {

	private Vertex source, destination;
	private int weight;

	public Edge() {

	}

	public Edge(Vertex source, Vertex destination, int weight) {
		super();
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public Vertex getSource() {
		return source;
	}

	public void setSource(Vertex source) {
		this.source = source;
	}

	public Vertex getDestination() {
		return destination;
	}

	public void setDestination(Vertex destination) {
		this.destination = destination;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return source.getName() + " ---"+ weight + "--> " + destination.getName();
	}
	
	

}
