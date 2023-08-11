package co.edu.unbosque.modelo;

import java.util.ArrayList;

import co.edu.unbosque.controlador.Controlador;

public class DecimalBinario {
	
	private Controlador c;
	String resultado = "";
	
	public DecimalBinario(int decimal) {
		c = new Controlador();
		
		long a_sistema = 2;
		
		long residuo = 0;
		long cociente = 0;
		ArrayList<Long> arr_residuos = new ArrayList<Long>();	
		
		
		cociente = decimal / a_sistema;
		residuo = decimal % a_sistema;
				
		arr_residuos.add(residuo);

		while(cociente >= a_sistema) {
			residuo = cociente % a_sistema;
			cociente /= a_sistema;
			arr_residuos.add(residuo);
		}
		arr_residuos.add(cociente);
		
		
		
		for (int i = (arr_residuos.size()-1); i >= 0; i--) {
			resultado += arr_residuos.get(i);
		}
		
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}
