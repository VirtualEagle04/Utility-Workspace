package co.edu.unbosque.model;

public class AsteroideDTO {

	private String nombre;
	private float velocidad;
	private float tamano;
	private String material;
	private boolean contiene_minerales;
	
	public AsteroideDTO() {
		
	}

	public AsteroideDTO(String nombre, float velocidad, float tamano, String material, boolean contiene_minerales) {
		super();
		this.nombre = nombre;
		this.velocidad = velocidad;
		this.tamano = tamano;
		this.material = material;
		this.contiene_minerales = contiene_minerales;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}

	public float getTamano() {
		return tamano;
	}

	public void setTamano(float tamano) {
		this.tamano = tamano;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public boolean isContiene_minerales() {
		return contiene_minerales;
	}

	public void setContiene_minerales(boolean contiene_minerales) {
		this.contiene_minerales = contiene_minerales;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("Nombre: "+getNombre());
		sb.append("Velocidad: "+getVelocidad());
		sb.append("Tamano: "+getTamano());
		sb.append("Material: "+getMaterial());
		if(isContiene_minerales()) {
			sb.append("¿Contiene Minerales?: Si");
		}
		else {
			sb.append("¿Contiene Minerales?: No");
		}
		
		
		return sb.toString();
	}
	
}
