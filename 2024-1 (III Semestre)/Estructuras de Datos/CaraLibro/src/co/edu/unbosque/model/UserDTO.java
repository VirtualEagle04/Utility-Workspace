package co.edu.unbosque.model;

import co.edu.unbosque.util.simplelist.MyLinkedList;

public class UserDTO {
	
	private String username;
	private String password;
	private MyLinkedList<UserDTO> friends;
	
	public UserDTO() {
		this.friends = new MyLinkedList<UserDTO>();
	}

	public UserDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.friends = new MyLinkedList<UserDTO>();
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

	public MyLinkedList<UserDTO> getFriends() {
		return friends;
	}

	public void setFriends(MyLinkedList<UserDTO> friends) {
		this.friends = friends;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("	Username: "+getUsername()+" / Password: "+getPassword()+"\n");
		sb.append("	Friends:\n");
		if(friends.isEmpty()) {
			sb.append("	User does not have Friends. User is DISCONNECTED.");
		}else {
			for(int i = 0; i < friends.size(); i++) {
				sb.append("	-> "+getFriends().get(i).getData().getUsername()+"\n");
			}
		}
		
		return sb.toString();
		
	}
}
