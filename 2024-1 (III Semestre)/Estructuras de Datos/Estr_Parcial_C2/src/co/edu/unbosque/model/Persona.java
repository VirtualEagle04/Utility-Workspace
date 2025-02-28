package co.edu.unbosque.model;

public class Persona {

	private String nombre;
	
	 public Persona() {
		// TODO Auto-generated constructor stub
	}

	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	 
	 @Override
	public String toString() {
		return this.getNombre();
	}
	
}
