package controller;

import model.MyLinkedList;

public class AplMain {

	public static void main(String[] args) {
		MyLinkedList<Long> fico = new MyLinkedList<>();
		fico.add(18l); // [18]
		fico.add(13l); // [13, 18]
		fico.add(11l); // [11, 13, 18]
		fico.addLast(7l); // [11, 13, 18, 7]
		fico.addLast(69l);// [11, 13, 18, 7, 69]
		fico.addLast(420l); // [11, 13, 18, 7, 69, 420]
		fico.addLast(8l); // [11, 13, 18, 7, 69, 420, 8]
		System.out.println(fico.toString());
		
		
	}

}
