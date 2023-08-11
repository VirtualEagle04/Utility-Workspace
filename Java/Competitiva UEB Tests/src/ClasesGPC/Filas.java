package ClasesGPC;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Filas {
	public static void main(String[] args) {
		Queue<Integer> cola = new LinkedList<Integer>();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			int siguiente = r.nextInt(400);
			System.out.println(siguiente);
			cola.offer(siguiente);
		}
		System.out.println(cola.peek()); //me devuelve el dato que está inmediatamente al frente, pero no lo atiende.
		System.out.println("-------------------");
		while (!cola.isEmpty()) {
			int actual = cola.poll(); //llama al primer dato, lo atiende, y lo despacha.
			System.out.println(actual);
		}

	}
}
