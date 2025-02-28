package co.edu.unbosque.model.persitance;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.UserDTO;

public class UserDAO implements CRUDoperation {

	private ArrayList<UserDTO> users;
	private DBConnection dbcon;

	public UserDAO() {
		users = new ArrayList<UserDTO>();
		dbcon = new DBConnection();
	}

	public ArrayList<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<UserDTO> users) {
		this.users = users;
	}

	// ---CRUD---//

	@Override
	public void create(Object o) {
		UserDTO newUser = (UserDTO) o;
		try {
			dbcon.initConnection();
			dbcon.setPreStatement(dbcon.getConnect().prepareStatement("INSERT INTO myuser VALUES(?,?,?,?);"));
			dbcon.getPreStatement().setInt(1, newUser.getId());
			dbcon.getPreStatement().setString(2, newUser.getName());
			dbcon.getPreStatement().setString(3, newUser.getUsername());
			dbcon.getPreStatement().setString(4, newUser.getPassword());
			dbcon.getPreStatement().executeUpdate();
			dbcon.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		users.add(newUser);
	}

	@Override
	public void create(String... args) {
		UserDTO newUser = new UserDTO(Integer.parseInt(args[0]), args[1], args[2], args[3]);
		try {
			dbcon.initConnection();
			dbcon.setPreStatement(dbcon.getConnect().prepareStatement("INSERT INTO myuser VALUES(?,?,?,?);"));
			dbcon.getPreStatement().setInt(1, newUser.getId());
			dbcon.getPreStatement().setString(2, newUser.getName());
			dbcon.getPreStatement().setString(3, newUser.getUsername());
			dbcon.getPreStatement().setString(4, newUser.getPassword());
			dbcon.getPreStatement().executeUpdate();
			dbcon.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		users.add(newUser);
	}

	@Override
	public String readAll() {
		String temp = "";
		users.clear();
		try {
			dbcon.initConnection();
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery("SELECT * FROM myuser;"));
			while (dbcon.getResultSet().next()) {
				int id = dbcon.getResultSet().getInt("id");
				String fullname = dbcon.getResultSet().getString("fullname");
				String username = dbcon.getResultSet().getString("username");
				String passw = dbcon.getResultSet().getString("passw");
				users.add(new UserDTO(id, fullname, username, passw));
			}
			dbcon.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (UserDTO user : users) {
			temp += user.toString();
		}
		return temp;
	}
	
	@Override
	public String readByName(String name) {
		String temp = "";
		users.clear();
		try {
			dbcon.initConnection();
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResultSet(dbcon.getStatement().executeQuery("SELECT * FROM myuser WHERE fullname = ?;"));
			while (dbcon.getResultSet().next()) {
				int id = dbcon.getResultSet().getInt("id");
				String fullname = dbcon.getResultSet().getString("fullname");
				String username = dbcon.getResultSet().getString("username");
				String passw = dbcon.getResultSet().getString("passw");
				users.add(new UserDTO(id, fullname, username, passw));
			}
			dbcon.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (UserDTO user : users) {
			if (user.getName().equals(name)) {
				temp += user.toString();
			}
		}
		return temp;
	}

	//Hello World!
	
	@Override
	public int updateById(int id, String... args) {
		UserDTO newUser = new UserDTO(Integer.parseInt(args[0]), args[1], args[2], args[3]);
		try {
			dbcon.initConnection();
			dbcon.setPreStatement(dbcon.getConnect().prepareStatement("UPDATE myuser SET id = ?, fullname = ?, username = ?, passw = ? WHERE id = ?;"));
			dbcon.getPreStatement().setInt(1, newUser.getId());
			dbcon.getPreStatement().setString(2, newUser.getName());
			dbcon.getPreStatement().setString(3, newUser.getUsername());
			dbcon.getPreStatement().setString(4, newUser.getPassword());
			dbcon.getPreStatement().setInt(5, id);
			dbcon.getPreStatement().executeUpdate();
			dbcon.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == id) {
				users.get(i).setName(args[0]);
				users.get(i).setUsername(args[1]);
				users.get(i).setPassword(args[2]);
				return 0; // Se encontro el id y se modificaron los datos.
			}
		}
		return 1; // No se encontro el id.
	}

	@Override
	public int deleteById(int id) {
		try {
			dbcon.initConnection();
			dbcon.setPreStatement(dbcon.getConnect().prepareStatement("DELETE FROM myuser WHERE id = ?;"));
			dbcon.getPreStatement().setInt(1, id);
			dbcon.getPreStatement().executeUpdate();
			dbcon.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == id) {
				users.remove(i);
				return 0; // Se encontro el id y se elimino de la lista.
			}
		}
		return 1; // No se encontro el id.
	}

}
