package co.edu.unbosque.model;

public class GalaxiaDTO {

	private String nombre;
	private int cant_planetas;
	private int cant_estrellas;
	private float radio;
	
	public GalaxiaDTO() {
		// TODO Auto-generated constructor stub
	}

	public GalaxiaDTO(String nombre, int cant_planetas, int cant_estrellas, float radio) {
		super();
		this.nombre = nombre;
		this.cant_planetas = cant_planetas;
		this.cant_estrellas = cant_estrellas;
		this.radio = radio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCant_planetas() {
		return cant_planetas;
	}

	public void setCant_planetas(int cant_planetas) {
		this.cant_planetas = cant_planetas;
	}

	public int getCant_estrellas() {
		return cant_estrellas;
	}

	public void setCant_estrellas(int cant_estrellas) {
		this.cant_estrellas = cant_estrellas;
	}

	public float getRadio() {
		return radio;
	}

	public void setRadio(float radio) {
		this.radio = radio;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("Nombre: "+getNombre());
		sb.append("Cantidad de Planetas: "+getCant_planetas());
		sb.append("Cantidad de Estrellas: "+getCant_estrellas());
		sb.append("Radio: "+getRadio());
		
		return sb.toString();
	}
	
	
	
	
	
}
