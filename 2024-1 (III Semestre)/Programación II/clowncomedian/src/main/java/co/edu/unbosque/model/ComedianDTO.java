package co.edu.unbosque.model;

public class ComedianDTO extends PersonDTO {

	private int visitedOpenMic;

	public ComedianDTO() {
	}

	public ComedianDTO(int visitedOpenMic) {
		super();
		this.visitedOpenMic = visitedOpenMic;
	}

	public ComedianDTO(int id, String fullname, long cc, int edLevel) {
		super(id, fullname, cc, edLevel);
		// TODO Auto-generated constructor stub
	}

	public ComedianDTO(int id, String fullname, long cc, int edLevel, int visitedOpenMic) {
		super(id, fullname, cc, edLevel);
		this.visitedOpenMic = visitedOpenMic;
	}

	public int getVisitedOpenMic() {
		return visitedOpenMic;
	}

	public void setVisitedOpenMic(int visitedOpenMic) {
		this.visitedOpenMic = visitedOpenMic;
	}
	
	@Override
	public String toString() {
		return "[" + getId() + ", " + getFullname() + ", " + getCc() + ", " + getEdLevel() + ", " + getVisitedOpenMic() + "]";
	}

}
