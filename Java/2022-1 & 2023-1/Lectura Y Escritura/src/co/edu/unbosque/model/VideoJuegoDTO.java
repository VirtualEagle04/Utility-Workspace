package co.edu.unbosque.model;

import java.io.Serializable;

public class VideoJuegoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8014220821562744756L;
	private String nombre;
	private String consola;
	private String rating;
	private boolean tiene_multijugador;
	
	public VideoJuegoDTO() {
		// TODO Auto-generated constructor stub
	}

	public VideoJuegoDTO(String nombre, String consola, String rating, boolean tiene_multijugador) {
		super();
		this.nombre = nombre;
		this.consola = consola;
		this.rating = rating;
		this.tiene_multijugador = tiene_multijugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getConsola() {
		return consola;
	}

	public void setConsola(String consola) {
		this.consola = consola;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public boolean isTiene_multijugador() {
		return tiene_multijugador;
	}

	public void setTiene_multijugador(boolean tiene_multijugador) {
		this.tiene_multijugador = tiene_multijugador;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre: "+getNombre()+"\n");
		sb.append("Consola: "+getConsola()+"\n");
		sb.append("Rating: "+getRating()+"\n");
		sb.append("Tiene multijugador: "+(isTiene_multijugador()? "Si": "No")+"\n");
		sb.append("---------\n");
		return sb.toString();
	}
	
	
}
