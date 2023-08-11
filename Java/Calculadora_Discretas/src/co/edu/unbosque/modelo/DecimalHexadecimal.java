package co.edu.unbosque.modelo;

import java.util.ArrayList;

import co.edu.unbosque.controlador.Controlador;

public class DecimalHexadecimal {
	
	private Controlador c;
	String resultado = "";
	
	public DecimalHexadecimal(long decimal) {
		c = new Controlador();
		long a_sistema = 16;
		
		long residuo = 0;
		long cociente = 0;
		
		ArrayList<String> arr_residuos = new ArrayList<String>();	
		
		cociente = decimal / a_sistema;
		residuo = decimal % a_sistema;
		
		arr_residuos.add(String.valueOf(residuo));
		
		while(cociente >= a_sistema) {
			residuo = cociente % a_sistema;
			cociente = cociente / a_sistema;
			arr_residuos.add(String.valueOf(residuo));
		}
		arr_residuos.add(String.valueOf(cociente));

		for (int i = 0; i < arr_residuos.size(); i++) {
			String temp = arr_residuos.get(i);
			switch (temp) {
				case "10": {
					arr_residuos.set(i, "A");
					break;
				}
				case "11": {
					arr_residuos.set(i, "B");
					break;
				}
				case "12": {
					arr_residuos.set(i, "C");
					break;
				}
				case "13": {
					arr_residuos.set(i, "D");
					break;
				}
				case "14": {
					arr_residuos.set(i, "E");
					break;
				}
				case "15": {
					arr_residuos.set(i, "F");
					break;
				}
			
			}
		}

		
		for (int i = arr_residuos.size()-1; i >= 0; i--) {
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
 