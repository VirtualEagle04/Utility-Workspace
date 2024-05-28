package Arboles;

public class Arbol {

	Nodo raiz;
	int tam;

	public Arbol() {
		raiz = null;
		tam = 0;
	}

	public void insertar(int dato) {

		if (raiz == null)
			raiz = new Nodo(dato);
		else {
			Nodo aux = raiz;
			boolean band = true;
			while (band) {

				if (dato < aux.dato) {
					if (aux.izq != null)
						aux = aux.izq;
					else
						aux.izq = new Nodo(dato);
					tam++;
					band = false;
				} else if (aux.der != null)
					aux = aux.der;
				else
					aux.der = new Nodo(dato);
				tam++;
				band = false;
			}
		}
	}

	public boolean Buscar(int dato) {

		Nodo aux = raiz;

		while (aux != null) {

			if (aux.dato == dato)
				return true;

			if (dato < aux.dato) {
				aux = aux.izq;
			} else
				aux = aux.der;
		}
		return false;
	}

	public void imprimirArbol() {
		imprimirArbol(raiz);
	}

	private void imprimirArbol(Nodo nodo) {
		if (nodo != null) {
			imprimirArbol(nodo.izq);
			System.out.print(nodo.dato + " ");
			imprimirArbol(nodo.der);
		}
	}

}
