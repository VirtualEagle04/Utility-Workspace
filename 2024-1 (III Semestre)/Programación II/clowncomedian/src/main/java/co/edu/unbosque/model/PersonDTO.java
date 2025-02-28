package co.edu.unbosque.model;

public class PersonDTO {

	private int id;
	private String fullname;
	private long cc;
	private int edLevel;
	
	public PersonDTO() {
		// TODO Auto-generated constructor stub
	}

	public PersonDTO(int id, String fullname, long cc, int edLevel) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.cc = cc;
		this.edLevel = edLevel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public long getCc() {
		return cc;
	}

	public void setCc(long cc) {
		this.cc = cc;
	}

	public int getEdLevel() {
		return edLevel;
	}

	public void setEdLevel(int edLevel) {
		this.edLevel = edLevel;
	}
	
	@Override
	public String toString() {
		return "[" + getId() + ", " + getFullname() + ", " + getCc() + ", " + getEdLevel() + "]";
	}
	
}
