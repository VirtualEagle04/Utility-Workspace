package co.edu.unbosque.modelo;

import co.edu.unbosque.controlador.Controlador;

public class Factorial {
	
	private Controlador c;
	String resultado = "";
	
	public Factorial(long n) {
		c = new Controlador();
		long acumulado = 1;
		
		for (int i = 1; i <= n; i++) {
			acumulado *= i;
		}
		resultado += acumulado;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
}