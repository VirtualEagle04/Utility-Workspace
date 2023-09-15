package co.edu.unbosque.model;

public class ClownDTO extends PersonDTO {

	private int sidekickNum;

	public ClownDTO() {
	}

	public ClownDTO(int sidekickNum) {
		super();
		this.sidekickNum = sidekickNum;
	}

	public ClownDTO(int id, String fullname, long cc, int edLevel) {
		super(id, fullname, cc, edLevel);
	}

	public ClownDTO(int id, String fullname, long cc, int edLevel, int sidekickNum) {
		super(id, fullname, cc, edLevel);
		this.sidekickNum = sidekickNum;
	}

	public int getSidekickNum() {
		return sidekickNum;
	}

	public void setSidekickNum(int sidekickNum) {
		this.sidekickNum = sidekickNum;
	}

	@Override
	public String toString() {
		return "[" + getId() + ", " + getFullname() + ", " + getCc() + ", " + getEdLevel() + ", " + getSidekickNum() + "]";
	}

}
