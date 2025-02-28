package co.edu.unbosque.model;

public class Temporal {
	
	private String especie;
	private String habitad;
	private String tipo;
	
	public Temporal() {
		// TODO Auto-generated constructor stub
	}

	public Temporal(String especie, String habitad, String tipo) {
		super();
		this.especie = especie;
		this.habitad = habitad;
		this.tipo = tipo;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getHabitad() {
		return habitad;
	}

	public void setHabitad(String habitad) {
		this.habitad = habitad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
