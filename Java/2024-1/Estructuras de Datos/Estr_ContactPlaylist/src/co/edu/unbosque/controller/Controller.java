package co.edu.unbosque.controller;

import java.util.Scanner;

import javax.sound.midi.SysexMessage;

import co.edu.unbosque.model.ContactDTO;
import co.edu.unbosque.model.SongDTO;
import co.edu.unbosque.model.persistance.ContactDAO;
import co.edu.unbosque.model.persistance.SongDAO;

public class Controller {

	private ContactDAO cDAO;
	private SongDAO sDAO;
	private Scanner sc;

	public Controller() {
		cDAO = new ContactDAO();
		sDAO = new SongDAO();
		sc = new Scanner(System.in);
	}

	public void runPlaylist() {

		ppal: while (true) {
			System.out.println("------------------------------------");
			System.out.println("1. -Create\n2. -Delete\n3. -Update\n4. -Read\n5. -Exit");
			int op = sc.nextInt();
			switch (op) {
			case 1: {
				sc.nextLine();
				System.out.print("Enter new song name: ");
				String name = sc.nextLine();
				System.out.print("Enter new song artist: ");
				String artist = sc.nextLine();
				System.out.print("Enter new song genre: ");
				String genre = sc.nextLine();
				System.out.print("Enter new song duration: ");
				float duration = sc.nextFloat();

				sDAO.create(new SongDTO(name, artist, genre, duration));
				System.err.println("New song added to playlist.");
				break;
			}
			case 2: {
				System.out.print("Enter song index to delete: ");
				int delIndex = sc.nextInt();

				if (sDAO.delete(delIndex) == 0) {
					System.err.println("Song deleted from playlist.");
				} else {
					System.err.println("Song doesn't exist in playlist.");
				}

				break;
			}
			case 3: {
				System.out.print("Enter song index to delete: ");
				int delIndex = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter new song name: ");
				String name = sc.nextLine();
				System.out.print("Enter new song artist: ");
				String artist = sc.nextLine();
				System.out.print("Enter new song genre: ");
				String genre = sc.nextLine();
				System.out.print("Enter new song duration: ");
				float duration = sc.nextFloat();

				if (sDAO.update(delIndex, new SongDTO(name, artist, genre, duration)) == 0) {
					System.err.println("Song updated in playlist.");
				} else {
					System.err.println("Song doesn't exist in playlist.");
				}

				break;
			}
			case 4: {
				System.out.println("1. -Read ordered\n2. -Read shuffled");
				int read = sc.nextInt();

				switch (read) {
				case 1: {
					System.out.println(sDAO.read());
					break;
				}
				case 2: {
					System.out.println(sDAO.readShuffled());
				}
				default:
				}
				break;
			}
			case 5: {
				break ppal;
			}
			}
		}
	}

	public void runContact() {

		ppal: while (true) {
			System.out.println("------------------------------------");
			System.out.println("1. -Create\n2. -Delete\n3. -Update\n4. -Read\n5. -Exit");
			int op = sc.nextInt();
			switch (op) {
			case 1: {
				sc.nextLine();
				System.out.print("Enter new contact name: ");
				String name = sc.nextLine();
				System.out.print("Enter new contact number: ");
				long number = sc.nextLong();

				cDAO.create(new ContactDTO(name, number));
				System.err.println("New contact created.");
				break;
			}
			case 2: {

				System.out.println("1. -Delete by index\n2. -Delete by name");
				int del = sc.nextInt();
				switch (del) {
				case 1: {
					System.out.print("Enter contact index to delete: ");
					int delIndex = sc.nextInt();
					if (cDAO.delete(delIndex) == 0) {
						System.err.println("Contact deleted.");
					} else {
						System.err.println("Contact doesn't exist.");
					}
					break;
				}
				case 2: {
					sc.nextLine();
					System.out.print("Enter contact name to delete:  ");
					String delName = sc.nextLine();
					if (cDAO.delete(delName) == 0) {
						System.err.println("Contact deleted.");
					} else {
						System.err.println("Contact doesn't exist.");
					}
					break;
				}

				}

				break;
			}
			case 3: {
				System.out.print("Enter contact index to update: ");
				int updtIndex = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter new name: ");
				String name = sc.nextLine();
				System.out.print("Enter new number: ");
				long number = sc.nextLong();

				if (cDAO.update(updtIndex, new ContactDTO(name, number)) == 0) {
					System.err.println("Contact updated.");
				} else {
					System.err.println("Contact doesn't exist.");
				}

				break;
			}
			case 4: {

				System.out.println("1. -Read All\n2. -Read by name");
				int read = sc.nextInt();
				switch (read) {
				case 1: {
					System.out.println(cDAO.read());
					break;
				}
				case 2: {
					sc.nextLine();
					System.out.print("Enter contact name to search:  ");
					String readName = sc.nextLine();
					String response = cDAO.read(readName);
					if (response != "-1") {
						System.out.println(response);
					} else {
						System.err.println("Contact doesn't exist.");
					}
					break;
				}

				}

				break;
			}
			case 5: {
				break ppal;
			}
			default:
			}

		}

	}

}
