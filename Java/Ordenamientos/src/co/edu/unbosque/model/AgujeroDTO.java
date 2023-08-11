package co.edu.unbosque.model;

public class AgujeroDTO {
	
	private float tamano;
	private float distancia;
	private String nombre;
	
	public AgujeroDTO() {
		// TODO Auto-generated constructor stub
	}

	public AgujeroDTO(float tamano, float distancia, String nombre) {
		super();
		this.tamano = tamano;
		this.distancia = distancia;
		this.nombre = nombre;
	}

	public float getTamano() {
		return tamano;
	}

	public void setTamano(float tamano) {
		this.tamano = tamano;
	}

	public float getDistancia() {
		return distancia;
	}

	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
