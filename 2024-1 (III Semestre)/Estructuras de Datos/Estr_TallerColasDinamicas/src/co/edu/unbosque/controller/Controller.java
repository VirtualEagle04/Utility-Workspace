package co.edu.unbosque.controller;

import java.util.LinkedList;
import java.util.Queue;
import co.edu.unbosque.model.Player;
import co.edu.unbosque.view.Console;

public class Controller {
	private Queue<Player> q;
	private static float duracion;

	public Controller() {
		duracion = 3f;
		q = new LinkedList<>();
	}

	public void run() {
		ppal: while (true) {
			Console.printLine(
					"1.- Agregar Jugador\n2.- Eliminar Jugador\n3.- Turno a Efectuar\n4.- Efectuar Turno\n5.- Estado de la Cola\n6.- Salir");
			int op = Console.readInt();
			switch (op) {
			case 1: {
				// Agregar Jugador
				Console.burnLine();
				Console.print("Ingrese el Numero de Jugador: ");
				String tempID = Console.readLine();
				Console.print("Ingrese el Numero de Turnos del Jugador: ");
				int tempTurnos = Console.readInt();
				q.add(new Player(tempID, tempTurnos));
				Console.printSuccessLine("Jugador No." + tempID + ", con " + tempTurnos + " turnos ha sido encolado.");
				break;
			}
			case 2: {
				// Eliminar Jugador
				if (q.isEmpty()) {
					Console.printErrLine("La cola esta vacia. Ingresa Jugadores antes.");
					break;
				}
				break;
			}
			case 3: {
				// Turno a Efectuar
				if (q.isEmpty()) {
					Console.printErrLine("La cola esta vacia. Ingresa Jugadores antes.");
					break;
				}
				Console.printSuccessLine("El jugador [" + q.peek().toString() + "] es el siguiente en gastar un turno.");
				break;
			}
			case 4: {
				// Efectuar Turno
				if (q.isEmpty()) {
					Console.printErrLine("La cola esta vacia. Ingresa Jugadores antes.");
					break;
				}
				Player temp = q.remove();
				temp.setTurnos(temp.getTurnos() - 1);
				if (temp.getTurnos() > 0) {
					// Tiene turnos restantes
					q.add(temp);
				}
				// Iniciar timer en otro hilo
				ejecutarCronometro();
				Console.printSuccessLine("Jugador con ID: " + temp.getId() + " ahora tiene -1 turno.");
				break;
			}
			case 5: {
				// Estado de la Cola
				if (q.isEmpty()) {
					Console.printErrLine("La cola esta vacia. Ingresa Jugadores antes.");
					break;
				}
				for (Player p : q) {
					Console.printSuccessLine("- " + p.toString() + "\n");
				}
				break;
			}
			case 6: {
				// Salir
				break ppal;
			}
			default:
			}
		}
	}

	public void ejecutarCronometro() {
		int min = 0;
		int sec = 0;
		while ((sec + (min * 60)) != duracion) {
			sec++;
			if (sec == 60) {
				min++;
				sec = 0;
			}
			clearScreen();
			System.out.printf("%02d:%02d\n", min, sec);
			try {
				Thread.sleep(1000); // Dormir por 1 segundo
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.err.println("Timer finished!");
	}

	public static void clearScreen() {
		System.out.print("\n".repeat(50));
	}
}
