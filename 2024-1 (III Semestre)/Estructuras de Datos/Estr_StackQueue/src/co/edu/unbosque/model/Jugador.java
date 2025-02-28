package co.edu.unbosque.model;

public class Jugador {

	private int num;
	private int tiros;
	
	public Jugador() {
		// TODO Auto-generated constructor stub
	}

	public Jugador(int num, int tiros) {
		super();
		this.num = num;
		this.tiros = tiros;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getTiros() {
		return tiros;
	}

	public void setTiros(int tiros) {
		this.tiros = tiros;
	}

	@Override
	public String toString() {
		return this.getNum() + ": " + this.getTiros();
	}
	
}
