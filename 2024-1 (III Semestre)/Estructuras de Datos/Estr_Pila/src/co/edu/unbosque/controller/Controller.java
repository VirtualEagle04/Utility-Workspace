package co.edu.unbosque.controller;

import javax.swing.JOptionPane;

import co.edu.unbosque.util.Pila;

public class Controller {
	private Pila stack;

	public Controller() {
		stack = new Pila();
	}

	public void run() {

		ppal: while (true) {

			int op = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Ingrese la operacion que desea realizar\n" + "1. - Insertar un Nodo\n" + "2. - Eliminar un Nodo\n"
							+ "3. - ¿La pila está vacía?\n" + "4. - ¿Cuál es el ultimo valor ingresado en la Pila?\n"
							+ "5. - ¿Cuántos nodos tiene la Pila?\n" + "6. - Vaciar pila\n" + "7. - Mostrar Pila\n"
							+ "8. - Salir",
					"Ingresar Operacion", JOptionPane.INFORMATION_MESSAGE));
			switch (op) {

			case 1: {

				stack.InsertarNodo();

				break;
			}
			case 2: {

				stack.EliminarNodo();

				break;
			}
			case 3: {

				stack.PilaVacia();

				break;
			}
			case 4: {

				stack.MostrarUltimoValorIngresado();

				break;
			}
			case 5: {

				stack.TamanoPila();

				break;
			}
			case 6: {

				stack.VaciarPila();

				break;
			}
			case 7: {

				stack.MostrarValores();

				break;
			}
			case 8: {
				break ppal;
			}
			default: {

			}

			}

		}

	}

}
