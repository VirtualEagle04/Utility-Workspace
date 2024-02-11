package co.edu.unbosque.modelo;

import co.edu.unbosque.controlador.Controlador;

public class Divisores {
	
	private Controlador c;
	private String divisores = "";
	private String tipo;
	
	public Divisores(long numero) {
		c = new Controlador();

        int contador_divisores = 0;

        for (int i = 1; i <= numero; i++){
            if (numero % i == 0){
            	divisores += i+"\n";
                contador_divisores++;
            }
        }
        if (contador_divisores == 2){
           tipo = "Primo";
        }
        else{
           tipo = "Compuesto";
        }
	}

	public String getDivisores() {
		return divisores;
	}

	public void setDivisores(String divisores) {
		this.divisores = divisores;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
