package co.edu.unbosque.controller;

import co.edu.unbosque.model.persitance.UserDAO;
import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.view.Console;

public class Controller {

	private UserDAO udao;

	public Controller() {
		udao = new UserDAO();
	}

	public void run() {
		ppal: while (true) {
			Console.printLine(
					"1) Create\n2) Create By Args\n3) Read All\n4) Read By Name\n5) Update By Id\n6) Delete By Id\n7) Exit");

			switch (Console.readInt()) {

			case 1: {
				Console.printLine("Id: ");
				int id = Console.readInt();
				Console.burnLine();
				Console.printLine("Name: ");
				String name = Console.readLine();
				Console.printLine("Username: ");
				String username = Console.readLine();
				Console.printLine("Password: ");
				String password = Console.readLine();

				udao.create(new UserDTO(id, name, username, password));
				Console.printLine("New User with Id: " + id + " has been created");
				break;
			}
			case 2: {
				Console.printLine("Id: ");
				int id = Console.readInt();
				Console.burnLine();
				Console.printLine("Name: ");
				String name = Console.readLine();
				Console.printLine("Username: ");
				String username = Console.readLine();
				Console.printLine("Password: ");
				String password = Console.readLine();

				udao.create(id + "", name, username, password);
				Console.printErrLine("New User with Id: " + id + " has been created");
				break;
			}
			case 3: {
				Console.printLine(udao.readAll());
				break;
			}
			case 4: {
				Console.burnLine();
				Console.printLine("Name to search: ");
				String name = Console.readLine();
				Console.printLine(udao.readByName(name));
				break;
			}
			case 5: {
				Console.printLine("Id to search: ");
				int id = Console.readInt();
				Console.burnLine();
				Console.printLine("Name: ");
				String name = Console.readLine();
				Console.printLine("Username: ");
				String username = Console.readLine();
				Console.printLine("Password: ");
				String password = Console.readLine();

				if (udao.updateById(id, name, username, password) == 0) {
					Console.printLine("User with Id: " + id + " has been updated.");
				} else {
					Console.printErrLine("Could not update User with Id: " + id + " as it doesn't exist.");
				}

				break;
			}
			case 6: {
				Console.printLine("Id to search: ");
				int id = Console.readInt();
				if (udao.deleteById(id) == 0) {
					Console.printLine("User with Id: " + id + " has been deleted.");
				} else {
					Console.printErrLine("Could not delete User with Id: " + id + " as it doesn't exist.");
				}
				break;
			}
			case 7: {
				break ppal;
			}

			default: {
				Console.printErrLine("Insert valid operation");
				break;
			}

			}

		}
	}

}
