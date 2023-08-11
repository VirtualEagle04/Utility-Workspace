package co.edu.unbosque.model;

import java.io.Serializable;

public class CarroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8145094164038044674L;
	private String marca;
	private String modelo;
	private float vmax;

	public CarroDTO() {
		// TODO Auto-generated constructor stub
	}

	public CarroDTO(String marca, String modelo, float vmax) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.vmax = vmax;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getVmax() {
		return vmax;
	}

	public void setVmax(float vmax) {
		this.vmax = vmax;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Marca: " + getMarca() + "\n");
		sb.append("Modelo: " + getModelo() + "\n");
		sb.append("Velocidad Maxima: " + getVmax() + "\n");
		sb.append("----------------------\n");

		return sb.toString();
	}

}