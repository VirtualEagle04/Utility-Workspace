package co.edu.unbosque.model.persistance;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.ClownDTO;
import co.edu.unbosque.model.ComedianDTO;
import co.edu.unbosque.view.Console;

public class ComedianDAO implements CRUDoperations {

	private DBConnection DBcon;
	private ArrayList<ComedianDTO> comedians;

	public ComedianDAO() {
		DBcon = new DBConnection();
		comedians = new ArrayList<>();
		
		initComedianDB();
	}

	public ArrayList<ComedianDTO> getComedians() {
		return comedians;
	}

	public void setComedians(ArrayList<ComedianDTO> comedians) {
		this.comedians = comedians;
	}
	
	// -->CRUD<--//
	
	public void initComedianDB() {
		try {
			Console.print("ComedianDAO Init -> ");
			DBcon.initConnection();
			DBcon.setStatement(DBcon.getConnect().createStatement());
			DBcon.setResultSet(DBcon.getStatement().executeQuery("SELECT * FROM comedians;"));
			
			while (DBcon.getResultSet().next()) {
				int id = DBcon.getResultSet().getInt("id");
				String fullname = DBcon.getResultSet().getString("fullname");
				Long cc = DBcon.getResultSet().getLong("cc");
				int edLevel = DBcon.getResultSet().getInt("edlevel");
				int visitedOpenMic = DBcon.getResultSet().getInt("visitedopenmic");
				
				comedians.add(new ComedianDTO(id, fullname, cc, edLevel, visitedOpenMic));
			}
			
			DBcon.closeConnection();
		}catch (SQLException e) {
			Console.printErrLine("SQL Exception -> "+e.getLocalizedMessage());
		}
	}

	@Override
	public int create(String... args) {
		try {
			ComedianDTO newComedian = new ComedianDTO(Integer.parseInt(args[0]), args[1], Long.parseLong(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));
			
			Console.print("ClownDAO Create -> ");
			DBcon.initConnection();
			DBcon.setPreStatement(DBcon.getConnect().prepareStatement("INSERT INTO comedians VALUES(?, ?, ?, ?, ?);"));
			DBcon.getPreStatement().setInt(1, newComedian.getId());
			DBcon.getPreStatement().setString(2, newComedian.getFullname());
			DBcon.getPreStatement().setLong(3, newComedian.getCc());
			DBcon.getPreStatement().setInt(4, newComedian.getEdLevel());
			DBcon.getPreStatement().setInt(5, newComedian.getVisitedOpenMic());
			DBcon.getPreStatement().executeUpdate();
			DBcon.closeConnection();
			
			comedians.add(newComedian);
			return 0; //Created.
		} catch(SQLException e) {
			Console.printErrLine("SQL Exception -> "+e.getLocalizedMessage());
			return 1; //SQL Exception.
		}
	}
	
	public void overrideDB() {
		int comedianCounter = 1;
		comedians.clear();
		try {
			Console.print("ComedianDAO Read -> ");
			DBcon.initConnection();
			DBcon.setStatement(DBcon.getConnect().createStatement());
			DBcon.setResultSet(DBcon.getStatement().executeQuery("SELECT * FROM comedians;"));
			
			while (DBcon.getResultSet().next()) {
				int id = DBcon.getResultSet().getInt("id");
				String fullname = DBcon.getResultSet().getString("fullname");
				Long cc = DBcon.getResultSet().getLong("cc");
				int edLevel = DBcon.getResultSet().getInt("edlevel");
				int visitedOpenMic = DBcon.getResultSet().getInt("visitedopenmic");
				
				comedians.add(new ComedianDTO(comedianCounter, fullname, cc, edLevel, visitedOpenMic));
				comedianCounter++;
			}
			
			DBcon.setPreStatement(DBcon.getConnect().prepareStatement("DELETE FROM comedians WHERE id >= 1;"));
			DBcon.getPreStatement().executeUpdate();
			
			for(ComedianDTO comedian : comedians) {
				DBcon.setPreStatement(DBcon.getConnect().prepareStatement("INSERT INTO comedians VALUES(?, ?, ?, ?, ?);"));
				DBcon.getPreStatement().setInt(1, comedian.getId());
				DBcon.getPreStatement().setString(2, comedian.getFullname());
				DBcon.getPreStatement().setLong(3, comedian.getCc());
				DBcon.getPreStatement().setInt(4, comedian.getEdLevel());
				DBcon.getPreStatement().setInt(5, comedian.getVisitedOpenMic());
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
		comedians.clear();
		try {
			Console.print("ClownDAO Read -> ");
			DBcon.initConnection();
			DBcon.setStatement(DBcon.getConnect().createStatement());
			DBcon.setResultSet(DBcon.getStatement().executeQuery("SELECT * FROM comedians;"));
			
			while (DBcon.getResultSet().next()) {
				int id = DBcon.getResultSet().getInt("id");
				String fullname = DBcon.getResultSet().getString("fullname");
				Long cc = DBcon.getResultSet().getLong("cc");
				int edLevel = DBcon.getResultSet().getInt("edlevel");
				int visitedOpenMic = DBcon.getResultSet().getInt("visitedopenmic");
				
				comedians.add(new ComedianDTO(id, fullname, cc, edLevel, visitedOpenMic));
			}
			
			DBcon.closeConnection();
			
			for(ComedianDTO comedian : comedians) {
				aux += comedian.toString();
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
			ComedianDTO newComedian = new ComedianDTO(Integer.parseInt(args[0]), args[1], Long.parseLong(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));
			
			Console.print("ClownDAO Update -> ");
			DBcon.initConnection();
			DBcon.setPreStatement(DBcon.getConnect().prepareStatement("UPDATE comedians SET id = ?, fullname = ?, cc = ?, edlevel = ?, visitedopenmic = ? WHERE id = ?;"));
			DBcon.getPreStatement().setInt(1, newComedian.getId());
			DBcon.getPreStatement().setString(2, newComedian.getFullname());
			DBcon.getPreStatement().setLong(3, newComedian.getCc());
			DBcon.getPreStatement().setInt(4, newComedian.getEdLevel());
			DBcon.getPreStatement().setInt(5, newComedian.getVisitedOpenMic());
			DBcon.getPreStatement().setInt(6, id);
			DBcon.getPreStatement().executeUpdate();
			DBcon.closeConnection();
			
			for (int i = 0; i < comedians.size(); i++) {
				if(comedians.get(i).getId() == id) {
					comedians.get(i).setFullname(args[1]);
					comedians.get(i).setCc(Long.parseLong(args[2]));
					comedians.get(i).setEdLevel(Integer.parseInt(args[3]));
					comedians.get(i).setVisitedOpenMic(Integer.parseInt(args[4]));
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
			DBcon.setPreStatement(DBcon.getConnect().prepareStatement("DELETE FROM comedians WHERE id = ?;"));
			DBcon.getPreStatement().setInt(1, id);
			DBcon.getPreStatement().executeUpdate();
			DBcon.closeConnection();
			
			for (int i = 0; i < comedians.size(); i++) {
				if(comedians.get(i).getId() == id) {
					comedians.remove(i);
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
