package co.edu.unbosque.controller;

import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.model.persistance.UserDAO;
import co.edu.unbosque.util.algorithm.AbstractSearch;
import co.edu.unbosque.util.algorithm.DepthFirstSearch;
import co.edu.unbosque.util.graphs.Edge;
import co.edu.unbosque.util.graphs.Graph;
import co.edu.unbosque.util.graphs.Vertex;
import co.edu.unbosque.util.simplelist.MyLinkedList;
import co.edu.unbosque.view.Console;

public class Controller {

	private UserDAO uDAO;
	private Graph g;

	public Controller() {
		uDAO = new UserDAO();
		g = new Graph();
	}

	public void run() {
		ppal: while (true) {
			Console.printLine("Menu:\n1) Manage Users\n2) Display Users\n3) Connectivity Between Users\n4) Exit");
			int op = Console.readInt();
			switch (op) {
			case 1: { // Manage Users
				user: while (true) {
					Console.printLine(
							"Menu:\n1) New User\n2) Delete User\n3) Edit User\n4) Add Friends to a User\n5) Return");

					int userOp = Console.readInt();
					switch (userOp) {
					case 1: { // New User
						Console.burnLine();
						Console.print("Enter Username: ");
						String username = Console.readLine();
						Console.print("Enter Password: ");
						String password = Console.readLine();

						if (uDAO.create(new UserDTO(username, password)) == 0) {
							Console.printSuccessLine("User created.");
						} else {
							Console.printErrLine("User couldn't be created.");
						}
						break;
					}
					case 2: { // Delete User
						Console.printLine(uDAO.read());
						Console.printErr("ID of User to delete: ");
						int index = Console.readInt();

						if (uDAO.delete(index) == 0) {
							Console.printSuccessLine("User deleted.");
						} else {
							Console.printErrLine("User couldn't be deleted.");
						}
						break;
					}
					case 3: { // Edit User
						Console.printLine(uDAO.read());
						Console.printErr("ID of User to edit: ");
						int index = Console.readInt();
						Console.burnLine();
						Console.print("Enter New Username: ");
						String username = Console.readLine();
						Console.print("Enter New Password: ");
						String password = Console.readLine();

						if (uDAO.update(index, new UserDTO(username, password)) == 0) {
							Console.printSuccessLine("User updated.");
						} else {
							Console.printErrLine("User couldn't be updated.");
						}
						break;
					}
					case 4: { // Add Friends to a User
						Console.printLine(uDAO.read());

						Console.printErr("Add Friend to User with ID: ");
						int index = Console.readInt();
						Console.printErr("ID of new Friend: ");
						int friendIndex = Console.readInt();

						try {
							uDAO.getUsers().get(index).getData().getFriends()
									.addLast(uDAO.getUsers().get(friendIndex).getData());
							uDAO.getUsers().get(friendIndex).getData().getFriends()
									.addLast(uDAO.getUsers().get(index).getData());
							Console.printSuccessLine("User: " + uDAO.getUsers().get(index).getData().getUsername()
									+ " has a new Friend: " + uDAO.getUsers().get(friendIndex).getData().getUsername());
							Console.printSuccessLine("User: " + uDAO.getUsers().get(friendIndex).getData().getUsername()
									+ " has a new Friend: " + uDAO.getUsers().get(index).getData().getUsername());
						} catch (Exception e) {
							Console.printErrLine("Either User or Friend doesn't exist.");
						}
						break;
					}
					case 5: {
						break user;
					}
					default:
					}
				}

				break;
			}
			case 2: { // Display Users
				if (uDAO.getUsers().isEmpty()) {
					Console.printErrLine("It's empty...");
				} else {
					Console.printLine(uDAO.read());
				}
				break;
			}
			case 3: { // Connectivity Between Users
				Console.printLine(uDAO.read());

				Console.printErr("ID of Origin: ");
				int sourceIndex = Console.readInt();
				Console.printErr("ID of Target: ");
				int targetIndex = Console.readInt();

				UserDTO sourceUser = uDAO.getUsers().get(sourceIndex).getData();
				UserDTO targetUser = uDAO.getUsers().get(targetIndex).getData();

				g = new Graph();

				MyLinkedList<Vertex<UserDTO>> userVertexList = new MyLinkedList<>();

				for (int i = 0; i < uDAO.getUsers().size(); i++) {
					Vertex<UserDTO> tempUser = new Vertex<>(uDAO.getUsers().get(i).getData());
					userVertexList.addLast(tempUser);
				}

				for (int i = 0; i < userVertexList.size(); i++) {
					Vertex<UserDTO> tempVertex = userVertexList.get(i).getData();

					for (int f = 0; f < tempVertex.getInfo().getFriends().size(); f++) {
						Vertex<UserDTO> friend = new Vertex<UserDTO>(
								tempVertex.getInfo().getFriends().get(f).getData());

						for (int v = 0; v < userVertexList.size(); v++) {
							if (friend.getInfo().getUsername()
									.equals(userVertexList.get(v).getData().getInfo().getUsername())) {
								if (friend.getInfo().getPassword()
										.equals(userVertexList.get(v).getData().getInfo().getPassword())) {

									userVertexList.get(i).getData()
											.addEdge(new Edge(tempVertex, userVertexList.get(v).getData(), 1));
									break;
								}
							}
						}
					}
					g.addVertex(tempVertex);
				}

				Vertex<UserDTO> sourceVertexUser = null;
				Vertex<UserDTO> targetVertexUser = null;

				for (int i = 0; i < userVertexList.size(); i++) {
					Vertex<UserDTO> tempVertex = userVertexList.get(i).getData();
					if (sourceUser.equals(tempVertex.getInfo())) {
						sourceVertexUser = tempVertex;
					}
					if (targetUser.equals(tempVertex.getInfo())) {
						targetVertexUser = tempVertex;
					}
				}

				AbstractSearch DFS = new DepthFirstSearch(sourceVertexUser, targetVertexUser);
				DFS.runSearch();

				break;
			}
			case 4: {
				break ppal;
			}
			default:
			}
		}
		Console.printErrLine("Program Termination");
	}

}
