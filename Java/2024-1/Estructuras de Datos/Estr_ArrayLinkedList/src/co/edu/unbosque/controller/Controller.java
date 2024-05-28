package co.edu.unbosque.controller;

import java.util.Scanner;

import co.edu.unbosque.model.FibonacciArrayList;
import co.edu.unbosque.model.FibonacciLinkedList;

public class Controller {

	private FibonacciArrayList arrayList;
	private FibonacciLinkedList linkedList;
	private Scanner sc;

	public Controller() {
		arrayList = new FibonacciArrayList();
		linkedList = new FibonacciLinkedList();
		sc = new Scanner(System.in);
	}

	public void run() {
		System.out.print("Hasta que numero de la serie Fibonacci quiere ingresar? ");
		long num = sc.nextLong();
		arrayList.addNumbers(num);
		linkedList.addNumbers(num);
		
		System.out.print("Cual numero de la serie Fibonacci desea buscar? ");
		int index = sc.nextInt();
		arrayList.searchNumber(index);
		linkedList.searchNumber(index);
	}

}
