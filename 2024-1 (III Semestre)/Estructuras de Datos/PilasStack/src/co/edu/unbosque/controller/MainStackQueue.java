package co.edu.unbosque.controller;

import co.edu.unbosque.util.QueueImp;
import co.edu.unbosque.util.StackImp;

public class MainStackQueue {

	public static void main(String[] args) {
		
		QueueImp<Long> longsQ = new QueueImp<>();
		for(int i = 0; i < 10; i++) {
			longsQ.enqueue((long) i);
		}
		System.out.println(longsQ.toString());
		System.out.println("Queue Peek: " + longsQ.peek());
		System.out.println("----------");
		
		StackImp<Character> charS = new StackImp<>();
		for(int i = 64; i < 91; i++) {
			charS.push((char) i);
		}
		System.out.println(charS.toString());
		System.out.println("Stack Peek: " + charS.peek());
		System.out.println("----------");
		System.out.println("Stack Pop: " + charS.pop());
		System.out.println("Stack Pop: " + charS.pop());
	}

}
