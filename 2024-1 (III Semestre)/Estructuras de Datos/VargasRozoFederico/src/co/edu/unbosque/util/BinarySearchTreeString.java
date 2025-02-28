package co.edu.unbosque.util;

import java.util.HashMap;

import co.edu.unbosque.view.Console;

public class BinarySearchTreeString {

	private NodeString root;
	private int size;

	public HashMap<String, Integer> ALPHABET;

	// Constructor
	public BinarySearchTreeString() {
		root = null;
		size = 0;
		ALPHABET = new HashMap<String, Integer>();
		ALPHABET.put("A", 1);
		ALPHABET.put("B", 2);
		ALPHABET.put("C", 3);
		ALPHABET.put("D", 4);
		ALPHABET.put("E", 5);
		ALPHABET.put("F", 6);
		ALPHABET.put("G", 7);
		ALPHABET.put("H", 8);
		ALPHABET.put("I", 9);
		ALPHABET.put("J", 10);
		ALPHABET.put("K", 11);
		ALPHABET.put("L", 12);
		ALPHABET.put("M", 13);
		ALPHABET.put("N", 14);
		ALPHABET.put("Ñ", 15);
		ALPHABET.put("O", 16);
		ALPHABET.put("P", 17);
		ALPHABET.put("Q", 18);
		ALPHABET.put("R", 19);
		ALPHABET.put("S", 20);
		ALPHABET.put("T", 21);
		ALPHABET.put("U", 22);
		ALPHABET.put("V", 23);
		ALPHABET.put("W", 24);
		ALPHABET.put("X", 25);
		ALPHABET.put("Y", 26);
		ALPHABET.put("Z", 27);
	}

	// Inorder Traversal
	public void inorder(NodeString root) {
		if (root != null) {
			inorder(root.getLeft());
			Console.print(root.getData() + ",");
			inorder(root.getRight());
		}
	}

	// Preorder Traversal
	public void preorder(NodeString root) {
		if (root != null) {
			Console.print(root.getData() + ",");
			inorder(root.getLeft());
			inorder(root.getRight());
		}
	}

	// Postorder Traversal
	public void postorder(NodeString root) {
		if (root != null) {
			inorder(root.getLeft());
			inorder(root.getRight());
			Console.print(root.getData() + ",");
		}
	}

	// Insert
	public void insert(String data) {
		root = insertRec(root, data);
	}

	// Insert Recursive
	public NodeString insertRec(NodeString current, String data) {

		if (current == null) {
			size++;
			return new NodeString(data);
		}

		if (ALPHABET.get(data) < ALPHABET.get(current.getData())) {
			current.setLeft(insertRec(current.getLeft(), data));
		} else if (ALPHABET.get(data) > ALPHABET.get(current.getData())) {
			current.setRight(insertRec(current.getRight(), data));
		} else {
			return current;
		}

		return current;

	}

	// Search
	public NodeString search(String data) {

		return searchRec(root, data);

	}

	// Search Recursive
	public NodeString searchRec(NodeString root, String data) {

		if (root == null || root.getData().equals(data)) {
			return root;
		}

		if (ALPHABET.get(root.getData()) < ALPHABET.get(data)) {
			return searchRec(root.getRight(), data);
		}

		return searchRec(root.getLeft(), data);

	}

	// Delete
	public void delete(String data) {

		deleteRec(root, data);

	}

	// Delete Recursive
	public NodeString deleteRec(NodeString root, String data) {
		if (root == null) {
			return root;
		}

		if (ALPHABET.get(data) < ALPHABET.get(root.getData())) {
			root.setLeft(deleteRec(root.getLeft(), data));
		} else if (ALPHABET.get(data) > ALPHABET.get(root.getData())) {
			root.setRight(deleteRec(root.getRight(), data));
		} else {

			if (root.getLeft() == null) {
				return root.getLeft();
			} else if (root.getRight() == null) {
				return root.getRight();
			}

			root.setData(minValueNodeString(root.getRight()).getData());

			root.setRight(deleteRec(root.getRight(), root.getData()));

		}

		return root;
	}

	// Minimum Value NodeString
	public NodeString minValueNodeString(NodeString root) {
		NodeString current = root;
		while (current.getLeft() != null) {
			current = current.getLeft();
		}
		return current;
	}

	// Maximum Value NodeString
	public NodeString maxValueNodeString(NodeString root) {
		NodeString current = root;
		while (current.getRight() != null) {
			current = current.getRight();
		}
		return current;
	}

	// Successor NodeString of a NodeString
	public NodeString successor(NodeString root, String data) {
		NodeString current = searchRec(root, data);
		if (current == null) {
			return null;
		}

		if (current.getRight() != null) {
			return minValueNodeString(current.getRight());
		}

		NodeString successor = null;
		NodeString ancestor = root;
		while (ancestor != current) {
			if (ALPHABET.get(current.getData()) < ALPHABET.get(ancestor.getData())) {
				successor = ancestor;
				ancestor = ancestor.getLeft();
			} else {
				ancestor = ancestor.getRight();
			}
		}
		return successor;
	}

	// Predecessor NodeString of a NodeString
	public NodeString predecessor(NodeString root, String data) {
		NodeString current = searchRec(root, data);
		if (current == null) {
			return null;
		}

		if (current.getLeft() != null) {
			return maxValueNodeString(current.getLeft());
		}

		NodeString predecessor = null;
		NodeString ancestor = root;
		while (ancestor != current) {
			if (ALPHABET.get(current.getData()) > ALPHABET.get(ancestor.getData())) {
				predecessor = ancestor;
				ancestor = ancestor.getRight();
			} else {
				ancestor = ancestor.getLeft();
			}
		}
		return predecessor;
	}

	public NodeString getRoot() {
		return root;
	}

	public void setRoot(NodeString root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
