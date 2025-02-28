package co.edu.unbosque.controller;

import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.util.TreeNode;
import co.edu.unbosque.view.Console;

public class Controller {

	private List<TreeNode<String>> nodes;

	public Controller() {
		nodes = new ArrayList<>();
	}

	public void run() {

		main: while (true) {

			Console.printSuccessLine("Enter Action:");
			Console.printLine("1. - Add Node\n2. - View Tree\n3. - Postorder Traversal\n4. - Exit");

			int a = Console.readInt();
			Console.printSuccessLine("-----------------------------------");
			switch (a) {
			case 1: {
				// Add Node
				Console.printSuccessLine("Enter Node data: ");
				Console.burnLine();
				String data = Console.readLine();

				TreeNode<String> tempNode = new TreeNode<>(data);

				if (nodes.isEmpty()) {

					nodes.add(tempNode);

					Console.printSuccessLine("Node '" + tempNode.getData() + "' is the root of the Tree.");
					break;
				} else {
					Console.printSuccessLine("This Node is children of...?");
					for (int i = 0; i < nodes.size(); i++) {
						Console.printLine(i + ". - " + nodes.get(i).getData());
					}
					int parentIndex = Console.readInt();
					// Check that parent doesn't already have his two children full
					if (nodes.get(parentIndex).getLeft() != null && nodes.get(parentIndex).getRight() != null) {
						// Full
						Console.printErrLine("Parent Node alreay has two children Nodes.");
						break;
					} else {
						// Free
						if (nodes.get(parentIndex).getLeft() == null) {
							// Doesn't have left node.
							Console.printSuccessLine("Insert Node to the Left (L) or Right (R)?");
							Console.burnLine();
							String dir = Console.readLine().toLowerCase();

							if (dir.equals("l")) {

								nodes.get(parentIndex).setLeft(tempNode);
								nodes.add(tempNode);
								Console.printSuccessLine("Node '" + nodes.get(parentIndex).getData()
										+ "' has a new Node Children to the Left '" + tempNode.getData() + "'");
								break;

							} else if (dir.equals("r")) {

								nodes.get(parentIndex).setRight(tempNode);
								nodes.add(tempNode);
								Console.printSuccessLine("Node '" + nodes.get(parentIndex).getData()
										+ "' has a new Node Children to the Right '" + tempNode.getData() + "'");
								break;

							} else {
								Console.printErrLine("That's not a valid Child.");
								break;
							}

						} else {
							// Does have left node.
							nodes.get(parentIndex).setRight(tempNode);
							nodes.add(tempNode);
							Console.printSuccessLine("Node '" + nodes.get(parentIndex).getData()
									+ "' has a new Node Children to the Right '" + tempNode.getData() + "'");
							break;
						}
					}

				}
			}
			case 2: {
				// View Tree
				Console.printLine(nodes.get(0).printTree());

				break;
			}
			case 3: {
				// Postorder Traversal
				printPostorder(nodes.get(0));
				Console.printLine("");

				break;
			}
			case 4: {
				// Exit

				break main;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + a);
			}

		}

	}

	public void printPostorder(TreeNode<String> node) {
		if (node == null) {
			return;
		}

		printPostorder(node.getLeft());

		printPostorder(node.getRight());

		Console.print(node.getData() + " ");
	}

}
