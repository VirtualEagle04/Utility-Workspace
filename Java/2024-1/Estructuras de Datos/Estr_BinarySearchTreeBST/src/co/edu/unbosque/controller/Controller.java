package co.edu.unbosque.controller;

import co.edu.unbosque.util.BinarySearchTree;
import co.edu.unbosque.view.Console;

public class Controller {

	public Controller() {
	}

	public void run() {

		BinarySearchTree tree = new BinarySearchTree();

		main: while (true) {
			Console.printLine(
					"1. - Insert New Node\n2. - Delete Existing Node\n3. - Search Existing Node\n4. - Get Min and Max\n5. - Get Predecessor and Successor of an Existing Node\n6. - Show Tree\n7. - Exit");
			int op = Console.readInt();
			switch (op) {
			case 1: {

				Console.print("Enter New Node Data: ");
				int data = Console.readInt();
				tree.insert(data);
				Console.printSuccessLine("New Node with Data '" + data + "' has been added to the BST.");

				break;
			}
			case 2: {

				Console.print("Enter Node to Delete: ");
				int data = Console.readInt();
				if (tree.search(data) == null) {
					Console.printErrLine("Node doesn't exist.");
				} else {
					tree.delete(data);
					Console.printSuccessLine("Node with Data '" + data + "' has been deleted from the BST.");
				}

				break;
			}
			case 3: {

				Console.print("Enter Node to Search: ");
				int data = Console.readInt();
				if (tree.search(data) != null) {
					Console.printSuccessLine("Node with Data '" + data + "' has been found in the BST. It exists.");
				} else {
					Console.printErrLine("Node with Data '" + data + "' doesn't exist in the BST.");
				}

				break;
			}
			case 4: {

				Console.printSuccessLine("Minimum: " + tree.minValueNode(tree.getRoot()).getData());
				Console.printSuccessLine("Maximum: " + tree.maxValueNode(tree.getRoot()).getData());

				break;
			}
			case 5: {

				Console.print("Enter Node to get its Predecessor and Successor: ");
				int data = Console.readInt();
				Console.printSuccessLine("Predecessor: " + tree.predecessor(tree.getRoot(), data).getData());
				Console.printSuccessLine("Successor: " + tree.successor(tree.getRoot(), data).getData());

				break;
			}
			case 6: {

				tree.inorder(tree.getRoot());
				Console.printLine("");

				break;
			}
			case 7: {
				Console.printErrLine("Application Ended");
				break main;
			}
			}
		}

	}

}
