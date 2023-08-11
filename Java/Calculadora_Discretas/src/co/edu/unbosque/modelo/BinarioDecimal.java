package co.edu.unbosque.modelo;

import java.util.ArrayList;

import co.edu.unbosque.controlador.Controlador;

public class BinarioDecimal {

	private Controlador c;
	int resultado = 0;

	public BinarioDecimal(int binario) {
		c = new Controlador();

		String binString = String.valueOf(binario);


		String binStringReves = "";
		char ch;

		// El mismo número al reves
		for (int i = 0; i < binString.length(); i++) {
			ch = binString.charAt(i);
			binStringReves = ch + binStringReves;
		}

		// El binario al reves
		char[] charBinario = binStringReves.toCharArray();

		ArrayList<Integer> intBinarioReves = new ArrayList<Integer>();
		for (int i = 0; i < charBinario.length; i++) {
			char c = charBinario[i];
			int num = c - '0';
			intBinarioReves.add(num);
		}



		for (int i = 0; i < intBinarioReves.size(); i++) {
			int num_temp = intBinarioReves.get(i);
			resultado += (int) (num_temp * Math.pow(2.0, i));
		}

	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
}
