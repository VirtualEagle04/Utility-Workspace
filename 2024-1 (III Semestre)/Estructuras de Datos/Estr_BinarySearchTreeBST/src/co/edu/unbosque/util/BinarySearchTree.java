package co.edu.unbosque.util;

import co.edu.unbosque.view.Console;

public class BinarySearchTree {

	private Node root;
	private int size;

	// Constructor
	public BinarySearchTree() {
		root = null;
		size = 0;
	}

	// Inorder Traversal
	public void inorder(Node root) {
		if (root != null) {
			inorder(root.getLeft());
			Console.print(root.getData() + " ");
			inorder(root.getRight());
		}
	}

	// Insert
	public void insert(int data) {
		root = insertRec(root, data);
	}

	// Insert Recursive
	public Node insertRec(Node current, int data) {

		if (current == null) {
			size++;
			return new Node(data);
		}

		if (data < current.getData()) {
			current.setLeft(insertRec(current.getLeft(), data));
		} else if (data > current.getData()) {
			current.setRight(insertRec(current.getRight(), data));
		} else {
			return current;
		}

		return current;

	}

	// Search
	public Node search(int data) {

		return searchRec(root, data);

	}

	// Search Recursive
	public Node searchRec(Node root, int data) {

		if (root == null || root.getData() == data) {
			return root;
		}

		if (root.getData() < data) {
			return searchRec(root.getRight(), data);
		}

		return searchRec(root.getLeft(), data);

	}

	// Delete
	public void delete(int data) {

		deleteRec(root, data);

	}

	// Delete Recursive
	public Node deleteRec(Node root, int data) {
		if (root == null) {
			return root;
		}

		if (data < root.getData()) {
			root.setLeft(deleteRec(root.getLeft(), data));
		} else if (data > root.getData()) {
			root.setRight(deleteRec(root.getRight(), data));
		} else {

			if (root.getLeft() == null) {
				return root.getLeft();
			} else if (root.getRight() == null) {
				return root.getRight();
			}

			root.setData(minValueNode(root.getRight()).getData());

			root.setRight(deleteRec(root.getRight(), root.getData()));

		}

		return root;
	}

	// Minimum Value Node
	public Node minValueNode(Node root) {
		Node current = root;
		while (current.getLeft() != null) {
			current = current.getLeft();
		}
		return current;
	}

	// Maximum Value Node
	public Node maxValueNode(Node root) {
		Node current = root;
		while (current.getRight() != null) {
			current = current.getRight();
		}
		return current;
	}

	// Successor Node of a Node
	public Node successor(Node root, int data) {
		Node current = searchRec(root, data);
		if (current == null) {
			return null;
		}

		if (current.getRight() != null) {
			return minValueNode(current.getRight());
		}

		Node successor = null;
		Node ancestor = root;
		while (ancestor != current) {
			if (current.getData() < ancestor.getData()) {
				successor = ancestor;
				ancestor = ancestor.getLeft();
			} else {
				ancestor = ancestor.getRight();
			}
		}
		return successor;
	}

	// Predecessor Node of a Node
	public Node predecessor(Node root, int data) {
		Node current = searchRec(root, data);
		if (current == null) {
			return null;
		}

		if (current.getLeft() != null) {
			return maxValueNode(current.getLeft());
		}

		Node predecessor = null;
		Node ancestor = root;
		while (ancestor != current) {
			if (current.getData() > ancestor.getData()) {
				predecessor = ancestor;
				ancestor = ancestor.getRight();
			} else {
				ancestor = ancestor.getLeft();
			}
		}
		return predecessor;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
