package co.edu.unbosque.model;

public class UserDTO {

	// De ahora en adelante, solo la base de datos tiene el ID
	private String username;
	private String password;

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [" + getUsername() + ", " + getPassword() + "]";
	}

}
