package co.edu.unbosque.model;

public class Poblacion {

	private String nombre;
	private long habitantes;

	public Poblacion() {

	}

	public Poblacion(String nombre, long habitantes) {
		super();
		this.nombre = nombre;
		this.habitantes = habitantes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(long habitantes) {
		this.habitantes = habitantes;
	}

	@Override
	public String toString() {
		return this.getNombre() + ": " + this.getHabitantes();
	}

}
