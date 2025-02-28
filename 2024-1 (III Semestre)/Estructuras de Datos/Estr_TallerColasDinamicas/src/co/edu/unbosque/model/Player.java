package co.edu.unbosque.model;

public class Player {

	private String id;
	private int turnos;

	public Player() {

	}

	public Player(String id, int turnos) {
		super();
		this.id = id;
		this.turnos = turnos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTurnos() {
		return turnos;
	}

	public void setTurnos(int turnos) {
		this.turnos = turnos;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.getId() + ", Turnos: " + this.getTurnos();
	}
	
}
