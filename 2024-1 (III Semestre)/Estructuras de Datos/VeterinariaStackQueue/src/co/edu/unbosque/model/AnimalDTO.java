package co.edu.unbosque.model;

public class AnimalDTO {

	private String name;
	private int age;
	private String specie;
	private char sex;
	private boolean hasBlanket;

	public AnimalDTO() {
	}

	public AnimalDTO(String name, int age, String specie, char sex, boolean hasBlanket) {
		super();
		this.name = name;
		this.age = age;
		this.specie = specie;
		this.sex = sex;
		this.hasBlanket = hasBlanket;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public boolean isHasBlanket() {
		return hasBlanket;
	}

	public void setHasBlanket(boolean hasBlanket) {
		this.hasBlanket = hasBlanket;
	}

	@Override
	public String toString() {
		return "[" + getName() + ", " + getAge() + ", " + getSpecie() + ", " + getSex() + ", " + isHasBlanket() + "]";
	}

}
