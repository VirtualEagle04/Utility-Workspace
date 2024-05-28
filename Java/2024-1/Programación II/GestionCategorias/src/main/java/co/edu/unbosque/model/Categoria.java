package co.edu.unbosque.model;

public class Categoria {
	private int id;
	private String desc;
	private String estado; // A, I

	public Categoria() {

	}

	public Categoria(int id, String desc, String estado) {
		super();
		this.id = id;
		this.desc = desc;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return this.getId() + ", " + this.getDesc() + ", " + this.getEstado();
	}

}
