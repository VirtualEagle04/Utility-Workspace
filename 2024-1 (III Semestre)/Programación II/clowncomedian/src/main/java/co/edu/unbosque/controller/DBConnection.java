package co.edu.unbosque.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import co.edu.unbosque.view.Console;

public class DBConnection {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preStatement = null;
	private ResultSet resultSet = null;
	private final String IP = "127.0.0.1";
	private final String PORT = "3306";
	private final String DATABASE = "ClownComedian";
	private final String USERNAME = "root";
	private final String PASSWORD = "";

	public DBConnection() {
	}

	public void initConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE, USERNAME, PASSWORD);
			Console.printSuccessLine("MySQL Database '" + DATABASE + "' connection stablished in -> localhost:" + PORT);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			Console.printErrLine("SQL Exception -> Password required for user: " + USERNAME);
		}
	}

	public void closeConnection() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public PreparedStatement getPreStatement() {
		return preStatement;
	}

	public void setPreStatement(PreparedStatement preStatement) {
		this.preStatement = preStatement;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public String getIP() {
		return IP;
	}

	public String getPORT() {
		return PORT;
	}

	public String getDATABASE() {
		return DATABASE;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

}
