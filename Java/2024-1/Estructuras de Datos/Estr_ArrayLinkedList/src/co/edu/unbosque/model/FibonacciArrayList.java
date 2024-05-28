package co.edu.unbosque.model;

import java.util.ArrayList;

public class FibonacciArrayList {

	private ArrayList<Long> list;

	public FibonacciArrayList() {
		list = new ArrayList<Long>();
	}

	public FibonacciArrayList(ArrayList<Long> list) {
		super();
		this.list = list;
	}

	public long fibonacci(long i) {
		if (i == 0) {
			return 0;
		}
		if (i == 1 || i == 2) {
			return 1;
		} else {
			return fibonacci(i - 1) + fibonacci(i - 2);
		}
	}

	public void addNumbers(long nNumbers) {
		long startTime, endTime;
		startTime = System.currentTimeMillis();
		for (long i = 0; i <= nNumbers; i++) {
			list.add(fibonacci(i));
			System.out.println(i + ": " + fibonacci(i));
		}
		endTime = System.currentTimeMillis();
		System.out.println("ArrayList Add Time for " + nNumbers + " numbers: " + (endTime - startTime) + "ms");
	}

	public void searchNumber(int nNumber) {
		long startTime, endTime;
		startTime = System.currentTimeMillis();
		if (nNumber > list.get(list.size() - 1)) {
			System.err.println("El numero que busca no se encuentra en la lista.");
			return;
		}

		list.get(nNumber);
		endTime = System.currentTimeMillis();
		System.out.println("ArrayList Search Time for " + nNumber + " number: " + (endTime - startTime) + "ms");
	}

	public ArrayList<Long> getList() {
		return list;
	}

	public void setList(ArrayList<Long> list) {
		this.list = list;
	}

}
