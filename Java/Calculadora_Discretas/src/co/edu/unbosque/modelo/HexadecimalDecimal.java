package co.edu.unbosque.modelo;

import java.util.ArrayList;

import co.edu.unbosque.controlador.Controlador;

public class HexadecimalDecimal {
	
	private Controlador c;
	int resultado = 0;
	
	public HexadecimalDecimal(String hexadecimal) {
		c = new Controlador();
		
		String[] strArray = hexadecimal.split("");
		
		//Reemplazando las letras con sus respectivos valores.
		for (int i = 0; i < strArray.length; i++) {
			String temp = strArray[i].toUpperCase();
			switch (temp) {
				case "A": {
					strArray[i] = "10";
					break;
				}
				case "B": {
					strArray[i] = "11";
					break;
				}
				case "C": {
					strArray[i] = "12";
					break;
				}
				case "D": {
					strArray[i] = "13";
					break;
				}
				case "E": {
					strArray[i] = "14";
					break;
				}
				case "F": {
					strArray[i] = "15";
					break;
				}
			}
			
		}
		
		//Convertir cada posicion del string de caracteres convertidos a numero int y meterlos al ArrayList
		ArrayList<Integer> numOrdenados = new ArrayList<Integer>();
		
		for (int i = 0; i < strArray.length; i++) {
			int temp = Integer.parseInt(strArray[i]);
			numOrdenados.add(temp);
		}
		
		//Invertir el orden del anterior ArrayList para poder usar sus posiciones como potencia.
		ArrayList<Integer> numReves = new ArrayList<Integer>();
		
		for (int i = numOrdenados.size()-1; i >= 0; i--) {
			numReves.add(numOrdenados.get(i));
		}
		
		//Suma del resultado final, usando Math.pow(base, potencia)

		
		for (int i = 0; i < numReves.size(); i++) {
			int num_temp = numReves.get(i);
			resultado += (int) (num_temp * Math.pow(16, i));
		}
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
}
