package co.edu.unbosque.model;

public class AnimalDTO {
	private String especie;
	private String habitad;
	
	public AnimalDTO() {
		
	}

	public AnimalDTO(String especie, String habitad) {
		super();
		this.especie = especie;
		this.habitad = habitad;
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Especie: "+getEspecie()+"\n");
		sb.append("Habitad: "+getHabitad()+"\n");
		sb.append("----------\n");
		return sb.toString();
		
	}
	
	
}
