
public class NascarCarDTO {

	private String driverName;
	private String team;
	private float maxVel;
	private int currentPos;
	private float gasLt;
	
	public NascarCarDTO() {
	}

	public NascarCarDTO(String driverName, String team, float maxVel, int currentPos, float gasLt) {
		super();
		this.driverName = driverName;
		this.team = team;
		this.maxVel = maxVel;
		this.currentPos = currentPos;
		this.gasLt = gasLt;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public float getMaxVel() {
		return maxVel;
	}

	public void setMaxVel(float maxVel) {
		this.maxVel = maxVel;
	}

	public int getCurrentPos() {
		return currentPos;
	}

	public void setCurrentPos(int currentPos) {
		this.currentPos = currentPos;
	}

	public float getGasLt() {
		return gasLt;
	}

	public void setGasLt(float gasLt) {
		this.gasLt = gasLt;
	}

	@Override
	public String toString() {
		return "(" + driverName + ", " + team + ", " + maxVel + ", " + currentPos + ", " + gasLt + ")";
	}
	
	
	
}
