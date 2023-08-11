 package co.edu.unbosque.model;

public class PlanetaDTO {

	private String nombre;
	private float tamano;
	private boolean es_habitable;
	private float gravedad;
	private double distancia_desde_tierra;
	
	public PlanetaDTO() {
		
	}
	
	
	public PlanetaDTO(String nombre, float tamano, boolean es_habitable, float gravedad,
			double distancia_desde_tierra) {
		super();
		this.nombre = nombre;
		this.tamano = tamano;
		this.es_habitable = es_habitable;
		this.gravedad = gravedad;
		this.distancia_desde_tierra = distancia_desde_tierra;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public float getTamano() {
		return tamano;
	}


	public void setTamano(float tamano) {
		this.tamano = tamano;
	}


	public boolean isEs_habitable() {
		return es_habitable;
	}


	public void setEs_habitable(boolean es_habitable) {
		this.es_habitable = es_habitable;
	}


	public float getGravedad() {
		return gravedad;
	}


	public void setGravedad(float gravedad) {
		this.gravedad = gravedad;
	}


	public double getDistancia_desde_tierra() {
		return distancia_desde_tierra;
	}


	public void setDistancia_desde_tierra(double distancia_desde_tierra) {
		this.distancia_desde_tierra = distancia_desde_tierra;
	}
	
	
	@Override //Anotacion
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("Nombre: "+getNombre());
		if (isEs_habitable()) {
			sb.append("Es habitable: Si");
		}
		else {
			sb.append("Es habitable: No");
		}
		sb.append("Tamaño: "+getTamano());
		sb.append("Gravedad: "+getGravedad());
		sb.append("Distancia desde la tierra: "+getDistancia_desde_tierra());
		
		return sb.toString();
	}
	
	
	
	
}
