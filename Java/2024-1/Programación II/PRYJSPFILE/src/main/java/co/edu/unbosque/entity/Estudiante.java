package co.edu.unbosque.entity;

public class Estudiante {
	
	private String nombre;
	private String apellidos;
	private Double promedio;
	
	public Estudiante(String nombre, String apellidos, Double promedio) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.promedio = promedio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Double getPromedio() {
		return promedio;
	}

	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}
	
	public String toString() {
		return (nombre + " " + apellidos + "Tiene promedio: "+ promedio);
	}
	
	
	
	

}
