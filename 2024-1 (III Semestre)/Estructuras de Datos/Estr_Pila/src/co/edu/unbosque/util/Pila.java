package co.edu.unbosque.util;

import javax.swing.JOptionPane;

public class Pila {

	private Nodo UltimoValorIngresado;
	int tamano = 0;
	String Lista = "";

	public Pila() {
		UltimoValorIngresado = null;
		tamano = 0;
	}

	// Método para saber cuando la pila esta vacia
	public void PilaVacia() {

		if (UltimoValorIngresado == null) {
			JOptionPane.showMessageDialog(null, "La Pila está vacia", "¿Pila Vacia?", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "La Pila no está vacia", "¿Pila Vacia?",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public boolean PilaVacia(int i) {
		return UltimoValorIngresado == null;
	}

	// Método para insertar un nodo en la pila
	public void InsertarNodo() {
		int info = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor del Nodo", "Insertar Nodo",
				JOptionPane.QUESTION_MESSAGE));
		Nodo nuevo_nocdo = new Nodo(info);
		nuevo_nocdo.siguiente = UltimoValorIngresado;
		UltimoValorIngresado = nuevo_nocdo;
		tamano++;
	}

	// Método para eliminar un nodo de la pila
	public void EliminarNodo() {
		if (PilaVacia(0)) {
			JOptionPane.showMessageDialog(null, "La Pila está vacia", "Eliminar Nodo", JOptionPane.WARNING_MESSAGE);
		} else {
			int auxiliar = UltimoValorIngresado.informacion;
			UltimoValorIngresado = UltimoValorIngresado.siguiente;
			tamano--;
			JOptionPane.showMessageDialog(null, "Se ha eliminado el Nodo con valor: " + auxiliar, "Eliminar Nodo",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public int EliminarNodo(int i) {
		int aux = UltimoValorIngresado.informacion;
		UltimoValorIngresado = UltimoValorIngresado.siguiente;
		tamano--;
		return aux;
	}

	// Método para conocer cual es el último valor ingresado
	public void MostrarUltimoValorIngresado() {
		if (PilaVacia(0)) {
			JOptionPane.showMessageDialog(null, "La Pila está vacia", "¿Cuál es el ultimo valor ingresado en la Pila?",
					JOptionPane.INFORMATION_MESSAGE);
		} else {

			JOptionPane.showMessageDialog(null, "Ultimo valor ingresado: " + UltimoValorIngresado.informacion,
					"Ultimo Nodo Ingresado", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// Método para conocer el tamaño de la Pila
	public void TamanoPila() {
		JOptionPane.showMessageDialog(null, "Tamaño de la Pila: " + tamano, "¿Cuántos nodos tiene la Pila?",
				JOptionPane.INFORMATION_MESSAGE);
	}

	// Método para vaciar la Pila
	public void VaciarPila() {
		if (PilaVacia(0)) {
			JOptionPane.showMessageDialog(null, "La Pila está vacia", "Vaciar Pila", JOptionPane.INFORMATION_MESSAGE);
		} else {
			while (!PilaVacia(0)) {
				EliminarNodo(0);
			}
			JOptionPane.showMessageDialog(null, "Se ha vaciado la Pila", "Vaciar Pila", JOptionPane.WARNING_MESSAGE);
		}

	}

	// Método para mostrar el contenido de la pila
	public void MostrarValores() {
		if (PilaVacia(0)) {
			JOptionPane.showMessageDialog(null, "La Pila está vacia", "Mostrar Valores",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			Nodo recorrido = UltimoValorIngresado;

			while (recorrido != null) {
				Lista += recorrido.informacion + "\n";
				recorrido = recorrido.siguiente;
			}
			JOptionPane.showMessageDialog(null, Lista);
			Lista = "";
		}

	}
}
