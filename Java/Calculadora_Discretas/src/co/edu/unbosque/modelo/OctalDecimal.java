package co.edu.unbosque.modelo;

import java.util.ArrayList;

import co.edu.unbosque.controlador.Controlador;

public class OctalDecimal {
	
	private Controlador c;
	int resultado = 0; 
	
	public OctalDecimal(int octal) {
		c = new Controlador();
		
		String octalString = String.valueOf(octal);
		
		String octalStringReves = "";
		char ch;
		
		//El mismo numero al reves
		for (int i = 0; i < octalString.length(); i++) {
			ch = octalString.charAt(i);
			octalStringReves = ch+octalStringReves;
		}
		
		//El octal al reves
		char[] charOctal = octalStringReves.toCharArray();
		
		ArrayList<Integer> intOctalReves = new ArrayList<Integer>();
		for (int i = 0; i < charOctal.length; i++) {
			char c = charOctal[i];
			int num = c - '0';
			intOctalReves.add(num);
		}
		

		
		for (int i = 0; i < intOctalReves.size(); i++) {
			int num_temp = intOctalReves.get(i);
			resultado += (int) (num_temp * Math.pow(8.0, i));
		}
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
}
