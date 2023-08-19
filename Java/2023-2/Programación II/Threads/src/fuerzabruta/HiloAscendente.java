package fuerzabruta;

public class HiloAscendente extends Thread {

	int valor;
	String nombre;

	public HiloAscendente(int valor, String nombre) {
		super();
		this.valor = valor;
		this.nombre = nombre;
	}

	@Override
	public void run() {
		for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
			if (i == valor) {
				System.err.println(nombre + ":" + Thread.currentThread().getName() + " Se encontro el numero");
				return;

			}

		}
	}

}
