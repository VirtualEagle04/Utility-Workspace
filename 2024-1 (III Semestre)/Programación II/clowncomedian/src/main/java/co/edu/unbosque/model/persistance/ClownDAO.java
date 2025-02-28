package co.edu.unbosque.model.persistance;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.ClownDTO;
import co.edu.unbosque.model.ComedianDTO;
import co.edu.unbosque.view.Console;

public class ClownDAO implements CRUDoperations{

	private DBConnection DBcon;
	private ArrayList<ClownDTO> clowns;
	
	public ClownDAO() {
		DBcon = new DBConnection();
		clowns = new ArrayList<>();
		
		initClownDB();
	}

	public ArrayList<ClownDTO> getClowns() {
		return clowns;
	}

	public void setClowns(ArrayList<ClownDTO> clowns) {
		this.clowns = clowns;
	}
	
	//-->CRUD<--//
	
	public void initClownDB() {
		try {
			Console.print("ClownDAO Init -> ");
			DBcon.initConnection();
			DBcon.setStatement(DBcon.getConnect().createStatement());
			DBcon.setResultSet(DBcon.getStatement().executeQuery("SELECT * FROM clowns;"));
			
			while (DBcon.getResultSet().next()) {
				int id = DBcon.getResultSet().getInt("id");
				String fullname = DBcon.getResultSet().getString("fullname");
				Long cc = DBcon.getResultSet().getLong("cc");
				int edLevel = DBcon.getResultSet().getInt("edlevel");
				int sidekickNum = DBcon.getResultSet().getInt("sidekicknum");
				
				clowns.add(new ClownDTO(id, fullname, cc, edLevel, sidekickNum));
			}
			
			DBcon.closeConnection();
		}catch (SQLException e) {
			Console.printErrLine("SQL Exception -> "+e.getLocalizedMessage());
		}
	}

	@Override
	public int create(String... args) {
		try {
			ClownDTO newClown = new ClownDTO(Integer.parseInt(args[0]), args[1], Long.parseLong(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));
			
			Console.print("ClownDAO Create -> ");
			DBcon.initConnection();
			DBcon.setPreStatement(DBcon.getConnect().prepareStatement("INSERT INTO clowns VALUES(?, ?, ?, ?, ?);"));
			DBcon.getPreStatement().setInt(1, newClown.getId());
			DBcon.getPreStatement().setString(2, newClown.getFullname());
			DBcon.getPreStatement().setLong(3, newClown.getCc());
			DBcon.getPreStatement().setInt(4, newClown.getEdLevel());
			DBcon.getPreStatement().setInt(5, newClown.getSidekickNum());
			DBcon.getPreStatement().executeUpdate();
			DBcon.closeConnection();
			
			clowns.add(newClown);
			return 0; //Created.
		} catch(SQLException e) {
			Console.printErrLine("SQL Exception -> "+e.getLocalizedMessage());
			return 1; //SQL Exception.
		}
	}
	
	public void overrideDB() {
		int clownCounter = 1;
		clowns.clear();
		try {
			Console.print("ClownDAO Read -> ");
			DBcon.initConnection();
			DBcon.setStatement(DBcon.getConnect().createStatement());
			DBcon.setResultSet(DBcon.getStatement().executeQuery("SELECT * FROM clowns;"));
			
			while (DBcon.getResultSet().next()) {
				int id = DBcon.getResultSet().getInt("id");
				String fullname = DBcon.getResultSet().getString("fullname");
				Long cc = DBcon.getResultSet().getLong("cc");
				int edLevel = DBcon.getResultSet().getInt("edlevel");
				int sidekickNum = DBcon.getResultSet().getInt("sidekicknum");
				
				clowns.add(new ClownDTO(clownCounter, fullname, cc, edLevel, sidekickNum));
				clownCounter++;
			}
			
			DBcon.setPreStatement(DBcon.getConnect().prepareStatement("DELETE FROM clowns WHERE id >= 1;"));
			DBcon.getPreStatement().executeUpdate();
			
			for(ClownDTO clown : clowns) {
				DBcon.setPreStatement(DBcon.getConnect().prepareStatement("INSERT INTO clowns VALUES(?, ?, ?, ?, ?);"));
				DBcon.getPreStatement().setInt(1, clown.getId());
				DBcon.getPreStatement().setString(2, clown.getFullname());
				DBcon.getPreStatement().setLong(3, clown.getCc());
				DBcon.getPreStatement().setInt(4, clown.getEdLevel());
				DBcon.getPreStatement().setInt(5, clown.getSidekickNum());
				DBcon.getPreStatement().executeUpdate();
			}
			
			DBcon.closeConnection();

		}catch (SQLException e) {
			Console.printErrLine("SQL Exception -> "+e.getLocalizedMessage());
		}
	}

	@Override
	public String readAll() {
		String aux = "";
		clowns.clear();
		try {
			Console.print("ClownDAO Read -> ");
			DBcon.initConnection();
			DBcon.setStatement(DBcon.getConnect().createStatement());
			DBcon.setResultSet(DBcon.getStatement().executeQuery("SELECT * FROM clowns;"));
			
			while (DBcon.getResultSet().next()) {
				int id = DBcon.getResultSet().getInt("id");
				String fullname = DBcon.getResultSet().getString("fullname");
				Long cc = DBcon.getResultSet().getLong("cc");
				int edLevel = DBcon.getResultSet().getInt("edlevel");
				int sidekickNum = DBcon.getResultSet().getInt("sidekicknum");
				
				clowns.add(new ClownDTO(id, fullname, cc, edLevel, sidekickNum));
			}
			
			DBcon.closeConnection();
			
			for(ClownDTO clown : clowns) {
				aux += clown.toString();
			}
			return aux; //Read.
		}catch (SQLException e) {
			Console.printErrLine("SQL Exception -> "+e.getLocalizedMessage());
			return aux; //SQL Exception.
		}
	}

	@Override
	public int update(int id, String... args) {
		try {
			ClownDTO newClown = new ClownDTO(Integer.parseInt(args[0]), args[1], Long.parseLong(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));
			
			Console.print("ClownDAO Update -> ");
			DBcon.initConnection();
			DBcon.setPreStatement(DBcon.getConnect().prepareStatement("UPDATE clowns SET id = ?, fullname = ?, cc = ?, edlevel = ?, sidekicknum = ? WHERE id = ?;"));
			DBcon.getPreStatement().setInt(1, newClown.getId());
			DBcon.getPreStatement().setString(2, newClown.getFullname());
			DBcon.getPreStatement().setLong(3, newClown.getCc());
			DBcon.getPreStatement().setInt(4, newClown.getEdLevel());
			DBcon.getPreStatement().setInt(5, newClown.getSidekickNum());
			DBcon.getPreStatement().setInt(6, id);
			DBcon.getPreStatement().executeUpdate();
			DBcon.closeConnection();
			
			for (int i = 0; i < clowns.size(); i++) {
				if(clowns.get(i).getId() == id) {
					clowns.get(i).setFullname(args[1]);
					clowns.get(i).setCc(Long.parseLong(args[2]));
					clowns.get(i).setEdLevel(Integer.parseInt(args[3]));
					clowns.get(i).setSidekickNum(Integer.parseInt(args[4]));
					return 0; // Updated.
				}
			}
			return 2; //ID not found.
		}catch (SQLException e) {
			Console.printErrLine("SQL Exception -> "+e.getLocalizedMessage());
			return 1; //SQL exception.
		}
	}

	@Override
	public int delete(int id) {
		try {
			Console.print("ClownDAO Delete -> ");
			DBcon.initConnection();
			DBcon.setPreStatement(DBcon.getConnect().prepareStatement("DELETE FROM clowns WHERE id = ?;"));
			DBcon.getPreStatement().setInt(1, id);
			DBcon.getPreStatement().executeUpdate();
			DBcon.closeConnection();
			
			for (int i = 0; i < clowns.size(); i++) {
				if(clowns.get(i).getId() == id) {
					clowns.remove(i);
					return 0; // Deleted.
				}
			}
			return 2; //ID not found.
		}catch (SQLException e) {
			Console.printErrLine("SQL Exception -> "+e.getLocalizedMessage());
			return 1; //SQL exception.
		}
	}
	
	
	
}
