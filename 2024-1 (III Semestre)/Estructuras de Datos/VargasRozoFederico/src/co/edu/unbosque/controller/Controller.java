package co.edu.unbosque.controller;

import java.util.Arrays;
import java.util.HashMap;

import co.edu.unbosque.util.BinarySearchTree;
import co.edu.unbosque.util.BinarySearchTreeString;
import co.edu.unbosque.view.Console;

public class Controller {

	public HashMap<String, Integer> ALPHABET;

	public Controller() {
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

	public void run() {

		// Creating BST
		BinarySearchTreeString letterTree = new BinarySearchTreeString();
		BinarySearchTree numberTree = new BinarySearchTree();

		// Creating Letter BST String
		String letterTreeString = "P,F,B,H,G,S,R,Y,T,W,Z";
		// Creating Number BST String
		String numberTreeString = "100,50,40,60,150,111,165";

		String[] letterTreeArray = letterTreeString.split(",");
		String[] numberTreeArray = numberTreeString.split(",");

		Console.printLine("Letter BST: " + Arrays.toString(letterTreeArray));
		Console.printLine("Number BST: " + Arrays.toString(numberTreeArray));

		Console.printSuccessLine("\n----------Letter BST----------");

		for (String value : letterTreeArray) {

			letterTree.insert(value);

		}
		Console.printSuccess("Inorder: ");
		letterTree.inorder(letterTree.getRoot());
		Console.printLine("");
		Console.printSuccess("Preorder: ");
		letterTree.preorder(letterTree.getRoot());
		Console.printLine("");
		Console.printSuccess("Postorder: ");
		letterTree.postorder(letterTree.getRoot());
		Console.printLine("");

		Console.printSuccessLine("\n----------Number BST----------");

		for (String value : numberTreeArray) {

			numberTree.insert(Integer.parseInt(value));

		}

		Console.printSuccess("Inorder: ");
		numberTree.inorder(numberTree.getRoot());
		Console.printLine("");
		Console.printSuccess("Preorder: ");
		numberTree.preorder(numberTree.getRoot());
		Console.printLine("");
		Console.printSuccess("Postorder: ");
		numberTree.postorder(numberTree.getRoot());
		Console.printLine("");
	}

}
