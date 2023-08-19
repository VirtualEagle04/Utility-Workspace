package co.edu.unbosque.model;

import java.io.Serializable;

public class NumeroDTO implements Serializable{
	
	private static final long serialVersionUID = -5415798615987903896L;
	
	private long valor;
	
	public NumeroDTO() {  }

	public NumeroDTO(long valor) {
		super();
		this.valor = valor;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "NumeroDTO [valor=" + valor + "]";
	}
	
}
