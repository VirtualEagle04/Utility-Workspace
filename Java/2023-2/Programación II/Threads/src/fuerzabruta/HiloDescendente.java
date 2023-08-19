package fuerzabruta;

public class HiloDescendente implements Runnable {

	int valor;
	String nombre;

	public HiloDescendente(int valor, String nombre) {
		super();
		this.valor = valor;
		this.nombre = nombre;
	}

	@Override
	public void run() {
		for (int i = Integer.MAX_VALUE; i > Integer.MIN_VALUE; i--) {

			if (i == valor) {
				System.err.println(nombre + ":" + Thread.currentThread().getName() + " Se encontro el numero");
				return;

			}

		}
	}

}
