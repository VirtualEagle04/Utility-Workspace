package co.edu.unbosque.model.persistance;

import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.util.simplelist.MyLinkedList;

public class UserDAO implements CRUDoperations {

	MyLinkedList<UserDTO> users;

	public UserDAO() {
		users = new MyLinkedList<UserDTO>();
	}

	public MyLinkedList<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(MyLinkedList<UserDTO> users) {
		this.users = users;
	}
	
	//--CRUD--//

	@Override
	public int create(Object o) {
		try {
			UserDTO user = (UserDTO) o;
			users.addLast(user);
			return 0;
		}catch (Exception e) {
			return 1;
		}
	}

	@Override
	public String read() {
		StringBuilder sb = new StringBuilder();
		sb.append("All Users:\n");
		for(int i = 0; i < users.size(); i++) {
			sb.append("-> [ID: "+i+"]:\n"+users.get(i).getData().toString());
		}
		return sb.toString();
	}

	@Override
	public String readIndex(int index) {
		try {
			UserDTO user = users.get(index).getData();
			return user.toString();
		}catch (Exception e) {
			return "User doesn't exists.";
		}
	}

	@Override
	public int update(int index, Object o) {
		try {
			UserDTO user = (UserDTO) o;
			users.get(index).setData(user);
			return 0;
		}catch (Exception e) {
			return 1;
		}
	}

	@Override
	public int delete(int index) {
		try {
			users.remove(index);
			return 0;
		}catch (Exception e) {
			return 1;
		}
	}

}
