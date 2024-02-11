package co.edu.unbosque.modelo;

import co.edu.unbosque.controlador.Controlador;

public class MCD {
	
	private Controlador c;
	private long resultado;
	
	public MCD(long num1, long num2) {
		c = new Controlador();
		
		long residuo;
		long cociente;
		long a = 0;
		long b = 0;
		
		if (num1 > num2) {
			a = num1;
			b = num2;
//			System.out.println("num1 > num2");
		}
		if(num2 > num1) {
			a = num2;
			b = num1; 
//			System.out.println("num2 > num1");
		}
		
		do {
			residuo = a % b;
//			System.out.println("Residuo: "+residuo);
			cociente = b;
//			System.out.println("Cociente: "+cociente);
			
			a = cociente;
			b = residuo;
			
			
		} while (residuo != 0);
		
		resultado = cociente;
	}

	public long getResultado() {
		return resultado;
	}

	public void setResultado(long resultado) {
		this.resultado = resultado;
	}
}
