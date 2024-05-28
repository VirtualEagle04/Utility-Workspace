package co.edu.unbosque.util;

public class NodeString {

	private String data;
	private NodeString left, right;

	public NodeString(String data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public NodeString getLeft() {
		return left;
	}

	public void setLeft(NodeString left) {
		this.left = left;
	}

	public NodeString getRight() {
		return right;
	}

	public void setRight(NodeString right) {
		this.right = right;
	}

}
