package co.edu.unbosque.entity;

public class Category {

	private int id;
	private String desc;
	private State state;

	public Category() {
	}

	public Category(int id, String desc, State state) {
		super();
		this.id = id;
		this.desc = desc;
		this.state = state;
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
