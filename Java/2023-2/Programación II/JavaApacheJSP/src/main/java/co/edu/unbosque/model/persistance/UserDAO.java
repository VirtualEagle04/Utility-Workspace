package co.edu.unbosque.model.persistance;

import java.util.ArrayList;

import co.edu.unbosque.model.UserDTO;

public class UserDAO implements CRUDoperations<UserDTO> {

	private ArrayList<UserDTO> users;
	
	public UserDAO() {
		users = new ArrayList<UserDTO>();
		users.add(new UserDTO("admin", "admin"));
	}

	public UserDAO(ArrayList<UserDTO> users) {
		super();
		this.users = users;
	}

	public ArrayList<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<UserDTO> users) {
		this.users = users;
	}

	// --CRUD--//

	public boolean validate(UserDTO login) {
		for (UserDTO user : users) {
			if (user.getUsername().equals(login.getUsername())) {
				if (user.getPassword().equals(login.getPassword())) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public int create(String... args) {
		try {
			UserDTO aux = new UserDTO(args[0], args[1]);
			users.add(aux);
			return 0;
		} catch (Exception e) {
			return 1;
		}
	}

	@Override
	public int create(Object o) {
		try {
			UserDTO aux = (UserDTO) o;
			users.add(aux);
			return 0;
		} catch (Exception e) {
			return 1;
		}
	}

	@Override
	public String readOnly() {
		StringBuilder sb = new StringBuilder();
		users.forEach((user) -> {
			sb.append(user.toString() + "\n");
		});
		return sb.toString();
	}

	@Override
	public ArrayList<UserDTO> read() {
		return users;
	}

	@Override
	public int update(int index, String... args) {
		try {
			UserDTO aux = new UserDTO(args[0], args[1]);
			users.set(index, aux);
			return 0;
		} catch (IndexOutOfBoundsException e) {
			return 1;
		}
	}

	@Override
	public int update(int index, Object o) {
		try {
			UserDTO aux = (UserDTO) o;
			users.set(index, aux);
			return 0;
		} catch (IndexOutOfBoundsException e) {
			return 1;
		}
	}

	@Override
	public int delete(int index) {
		try {
			users.remove(index);
			return 0;
		} catch (IndexOutOfBoundsException e) {
			return 1;
		}
	}

	@Override
	public int delete(Object o) {
		UserDTO aux = (UserDTO) o;
		if (users.remove(aux)) {
			return 0;
		}
		return 1;

	}

}
