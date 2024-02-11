package co.edu.unbosque.model;

import java.io.Serializable;

public class SerieDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3176794191723347766L;
	private String nombre;
	private String genero;
	private int año;
	private String calificacion;
	
	public SerieDTO() {
		// TODO Auto-generated constructor stub
	}

	public SerieDTO(String nombre, String genero, int año, String calificacion) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.año = año;
		this.calificacion = calificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre: "+getNombre()+"\n");
		sb.append("Genero: "+getGenero()+"\n");
		sb.append("Año de Salida: "+getAño()+"\n");
		sb.append("Calificacion: "+getCalificacion()+"\n");
		sb.append("---------\n");
		return sb.toString();
	}
}
