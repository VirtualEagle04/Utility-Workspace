package co.edu.unbosque.model.persistance;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.ClownDTO;
import co.edu.unbosque.model.ComedianDTO;
import co.edu.unbosque.model.PersonDTO;
import co.edu.unbosque.view.Console;

public class PersonDAO {

	private DBConnection DBcon;
	private ArrayList<PersonDTO> people;

	public PersonDAO() {
		DBcon = new DBConnection();
		people = new ArrayList<>();
		
		initPeopleDB();
	}

	public ArrayList<PersonDTO> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<PersonDTO> people) {
		this.people = people;
	}
	
	//-->CRUD<--//
	
	public void initPeopleDB() {
		try {
			Console.print("People Init -> ");
			DBcon.initConnection();
			DBcon.setStatement(DBcon.getConnect().createStatement());
			DBcon.setResultSet(DBcon.getStatement().executeQuery("SELECT * FROM person;"));
			
			while (DBcon.getResultSet().next()) {
				int id = DBcon.getResultSet().getInt("id");
				String fullname = DBcon.getResultSet().getString("fullname");
				Long cc = DBcon.getResultSet().getLong("cc");
				int edLevel = DBcon.getResultSet().getInt("edlevel");
				
				people.add(new PersonDTO(id, fullname, cc, edLevel));
			}
			
			DBcon.closeConnection();
		}catch (SQLException e) {
			Console.printErrLine("SQL Exception -> "+e.getLocalizedMessage());
		}
	}

	public int merge(ArrayList<ClownDTO> clowns, ArrayList<ComedianDTO> comedians) {
		try {
			people.clear();
			int peopleCont = 1;
			Console.print("PersonDAO Merge -> ");
			DBcon.initConnection();
			DBcon.setPreStatement(DBcon.getConnect().prepareStatement("DELETE FROM person WHERE id >= 1;"));
			DBcon.getPreStatement().executeUpdate();
			
			for (ClownDTO clown : clowns) {
				ClownDTO clownAux = new ClownDTO(peopleCont, clown.getFullname(), clown.getCc(), clown.getEdLevel(), clown.getSidekickNum());
				
				DBcon.setPreStatement(DBcon.getConnect().prepareStatement("INSERT INTO person VALUES(?, ?, ?, ?);"));
				DBcon.getPreStatement().setInt(1, clownAux.getId());
				DBcon.getPreStatement().setString(2, clownAux.getFullname());
				DBcon.getPreStatement().setLong(3, clownAux.getCc());
				DBcon.getPreStatement().setInt(4, clownAux.getEdLevel());
				DBcon.getPreStatement().executeUpdate();
				
				people.add(clownAux);
				peopleCont++;
			}
			for (ComedianDTO comedian : comedians) {
				ComedianDTO comedianAux = new ComedianDTO(peopleCont, comedian.getFullname(), comedian.getCc(), comedian.getEdLevel(), comedian.getVisitedOpenMic());
				
				DBcon.setPreStatement(DBcon.getConnect().prepareStatement("INSERT INTO person VALUES(?, ?, ?, ?);"));
				DBcon.getPreStatement().setInt(1, comedianAux.getId());
				DBcon.getPreStatement().setString(2, comedianAux.getFullname());
				DBcon.getPreStatement().setLong(3, comedianAux.getCc());
				DBcon.getPreStatement().setInt(4, comedianAux.getEdLevel());
				DBcon.getPreStatement().executeUpdate();
				
				people.add(comedianAux);
				peopleCont++;
			}
			
			DBcon.closeConnection();

			return 0;
		} catch (SQLException e) {
			Console.printErrLine(e.getLocalizedMessage());
			return 1;
		}

	}

	public void mergeFromClowns(ArrayList<ClownDTO> clowns) {
		people.addAll(clowns);
	}

	public void mergeFromComedians(ArrayList<ComedianDTO> comedians) {
		people.addAll(comedians);
	}

}
