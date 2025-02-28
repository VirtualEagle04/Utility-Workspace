package co.edu.unbosque.model;

public class ContactDTO {

	private String name;
	private long number;

	public ContactDTO() {
		
	}

	public ContactDTO(String name, long number) {
		super();
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return this.getName() + ": " + this.getNumber();
	}

}
