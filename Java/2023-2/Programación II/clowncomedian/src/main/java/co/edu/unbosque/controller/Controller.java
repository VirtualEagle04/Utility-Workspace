package co.edu.unbosque.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.ClownDTO;
import co.edu.unbosque.model.ComedianDTO;
import co.edu.unbosque.model.PersonDTO;
import co.edu.unbosque.model.persistance.ClownDAO;
import co.edu.unbosque.model.persistance.ComedianDAO;
import co.edu.unbosque.model.persistance.PersonDAO;
import co.edu.unbosque.view.Console;
import co.edu.unbosque.view.MainWindow;

public class Controller implements ActionListener {

	private PersonDAO pDAO;
	private ClownDAO clownDAO;
	private ComedianDAO comedianDAO;

	private MainWindow mw;

	private int tableState; // 0 = People, 1 = Clowns, 2 = Comedians

	public Controller() {
		pDAO = new PersonDAO();
		clownDAO = new ClownDAO();
		comedianDAO = new ComedianDAO();
	}

	public void run() {
		mw = new MainWindow();
		addListeners();
		updateTables();
		tableState = 0;

		JOptionPane.showMessageDialog(mw,
				"Wecome to CCManager: Clowns and Comedians Manager\n• Select People Table to see all people.\n• Select Clowns Table to see all clowns.\n"
				+"• Select Comedians Table to see all comedians.\n\n\nMade with 2 hours of sleep by, Federico Vargas Rozo\n(o _ °)", "Welcome", JOptionPane.INFORMATION_MESSAGE);
	}

	public void addListeners() {
		// -->Menu Items<--//
		mw.getpMenu().addActionListener(this);
		mw.getpMenu().setActionCommand("people_menu_item");

		mw.getClownsEditMenu().addActionListener(this);
		mw.getClownsEditMenu().setActionCommand("clowns_menu_item");

		mw.getComediansEditMenu().addActionListener(this);
		mw.getComediansEditMenu().setActionCommand("comedians_menu_item");

		// -->Buttons<--//
		mw.getMainPanel().getConfirmButton().addActionListener(this);
		mw.getMainPanel().getConfirmButton().setActionCommand("confirm_button");

		mw.getMainPanel().getResetButton().addActionListener(this);
		mw.getMainPanel().getResetButton().setActionCommand("reset_button");

		// -->Combo Box<--//
		mw.getMainPanel().getCRUDbox().addActionListener(this);
		mw.getMainPanel().getCRUDbox().setActionCommand("combobox_changed");

	}

	public void updateTables() {
		DefaultTableModel peopleModel = (DefaultTableModel) mw.getMainPanel().getpTable().getModel();
		DefaultTableModel clownsModel = (DefaultTableModel) mw.getMainPanel().getClownsTable().getModel();
		DefaultTableModel comediansModel = (DefaultTableModel) mw.getMainPanel().getComediansTable().getModel();
		
		clownDAO.overrideDB();
		comedianDAO.overrideDB();

		ArrayList<ClownDTO> clowns = clownDAO.getClowns();
		ArrayList<ComedianDTO> comedians = comedianDAO.getComedians();

		pDAO.merge(clownDAO.getClowns(), comedianDAO.getComedians());
		Console.printLine("-------------------------------------------------------------------------------------------------");

		ArrayList<PersonDTO> people = pDAO.getPeople();

		peopleModel.setRowCount(0); // Clear
		clownsModel.setRowCount(0); // Clear
		comediansModel.setRowCount(0); // Clear

		for (ClownDTO clown : clowns) {
			clownsModel.insertRow(clownsModel.getRowCount(), new Object[] { clown.getId(), clown.getFullname(),
					clown.getCc(), clown.getEdLevel(), clown.getSidekickNum() });
		}
		for (ComedianDTO comedian : comedians) {
			comediansModel.insertRow(comediansModel.getRowCount(), new Object[] { comedian.getId(),
					comedian.getFullname(), comedian.getCc(), comedian.getEdLevel(), comedian.getVisitedOpenMic() });
		}
		for (PersonDTO person : people) {
			peopleModel.insertRow(peopleModel.getRowCount(),
					new Object[] { person.getId(), person.getFullname(), person.getCc(), person.getEdLevel() });
		}

		mw.getMainPanel().getpTable().setModel(peopleModel);
		mw.getMainPanel().getClownsTable().setModel(clownsModel);
		mw.getMainPanel().getComediansTable().setModel(comediansModel);

		mw.getMainPanel().getpTable().repaint();
		mw.getMainPanel().getClownsTable().repaint();
		mw.getMainPanel().getComediansTable().repaint();

	}

	public void resetInputFields() {
		mw.getMainPanel().getIdField().setText("");
		mw.getMainPanel().getCcField().setText("");
		mw.getMainPanel().getFullnameField().setText("");
		mw.getMainPanel().getEdLevelField().setText("");
		mw.getMainPanel().getSidekickNumField().setText("");
		mw.getMainPanel().getVisitedOpenMicField().setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "people_menu_item": {
			tableState = 0;

			mw.getMainPanel().getIdPanel().setBorder(new TitledBorder("ID"));
			mw.getMainPanel().getCRUDbox().setSelectedIndex(0);
			resetInputFields();

			mw.getMainPanel().getpScroll().setEnabled(true);
			mw.getMainPanel().getpScroll().setVisible(true);

			mw.getMainPanel().getClownsScroll().setEnabled(false);
			mw.getMainPanel().getClownsScroll().setVisible(false);

			mw.getMainPanel().getComediansScroll().setEnabled(false);
			mw.getMainPanel().getComediansScroll().setVisible(false);

			mw.getMainPanel().getIdPanel().setEnabled(false);
			mw.getMainPanel().getIdPanel().setVisible(false);

			mw.getMainPanel().getFullnamePanel().setEnabled(false);
			mw.getMainPanel().getFullnamePanel().setVisible(false);

			mw.getMainPanel().getCcPanel().setEnabled(false);
			mw.getMainPanel().getCcPanel().setVisible(false);

			mw.getMainPanel().getEdLevelPanel().setEnabled(false);
			mw.getMainPanel().getEdLevelPanel().setVisible(false);

			mw.getMainPanel().getSidekickNumPanel().setEnabled(false);
			mw.getMainPanel().getSidekickNumPanel().setVisible(false);

			mw.getMainPanel().getVisitedOpenMicPanel().setEnabled(false);
			mw.getMainPanel().getVisitedOpenMicPanel().setVisible(false);

			mw.getMainPanel().getCRUDbox().setEnabled(false);
			mw.getMainPanel().getCRUDbox().setVisible(false);

			mw.getMainPanel().getConfirmButton().setEnabled(false);
			mw.getMainPanel().getConfirmButton().setVisible(false);

			mw.getMainPanel().getResetButton().setEnabled(false);
			mw.getMainPanel().getResetButton().setVisible(false);

			mw.getMainPanel().getEditPanel().setBackground(Color.LIGHT_GRAY);

			break;
		}
		case "clowns_menu_item": {
			tableState = 1;

			mw.getMainPanel().getIdPanel().setBorder(new TitledBorder("ID"));
			mw.getMainPanel().getCRUDbox().setSelectedIndex(0);
			resetInputFields();

			mw.getMainPanel().getpScroll().setEnabled(false);
			mw.getMainPanel().getpScroll().setVisible(false);

			mw.getMainPanel().getClownsScroll().setEnabled(true);
			mw.getMainPanel().getClownsScroll().setVisible(true);

			mw.getMainPanel().getComediansScroll().setEnabled(false);
			mw.getMainPanel().getComediansScroll().setVisible(false);

			mw.getMainPanel().getIdPanel().setEnabled(true);
			mw.getMainPanel().getIdPanel().setVisible(true);

			mw.getMainPanel().getFullnamePanel().setEnabled(true);
			mw.getMainPanel().getFullnamePanel().setVisible(true);

			mw.getMainPanel().getCcPanel().setEnabled(true);
			mw.getMainPanel().getCcPanel().setVisible(true);

			mw.getMainPanel().getEdLevelPanel().setEnabled(true);
			mw.getMainPanel().getEdLevelPanel().setVisible(true);

			mw.getMainPanel().getSidekickNumPanel().setEnabled(true);
			mw.getMainPanel().getSidekickNumPanel().setVisible(true);

			mw.getMainPanel().getVisitedOpenMicPanel().setEnabled(false);
			mw.getMainPanel().getVisitedOpenMicPanel().setVisible(false);

			mw.getMainPanel().getCRUDbox().setEnabled(true);
			mw.getMainPanel().getCRUDbox().setVisible(true);

			mw.getMainPanel().getConfirmButton().setEnabled(true);
			mw.getMainPanel().getConfirmButton().setVisible(true);

			mw.getMainPanel().getResetButton().setEnabled(true);
			mw.getMainPanel().getResetButton().setVisible(true);

			mw.getMainPanel().getEditPanel().setBackground(Color.WHITE);

			break;
		}
		case "comedians_menu_item": {
			tableState = 2;

			mw.getMainPanel().getIdPanel().setBorder(new TitledBorder("ID"));
			mw.getMainPanel().getCRUDbox().setSelectedIndex(0);
			resetInputFields();

			mw.getMainPanel().getpScroll().setEnabled(false);
			mw.getMainPanel().getpScroll().setVisible(false);

			mw.getMainPanel().getClownsScroll().setEnabled(false);
			mw.getMainPanel().getClownsScroll().setVisible(false);

			mw.getMainPanel().getComediansScroll().setEnabled(true);
			mw.getMainPanel().getComediansScroll().setVisible(true);

			mw.getMainPanel().getIdPanel().setEnabled(true);
			mw.getMainPanel().getIdPanel().setVisible(true);

			mw.getMainPanel().getFullnamePanel().setEnabled(true);
			mw.getMainPanel().getFullnamePanel().setVisible(true);

			mw.getMainPanel().getCcPanel().setEnabled(true);
			mw.getMainPanel().getCcPanel().setVisible(true);

			mw.getMainPanel().getEdLevelPanel().setEnabled(true);
			mw.getMainPanel().getEdLevelPanel().setVisible(true);

			mw.getMainPanel().getSidekickNumPanel().setEnabled(false);
			mw.getMainPanel().getSidekickNumPanel().setVisible(false);

			mw.getMainPanel().getVisitedOpenMicPanel().setEnabled(true);
			mw.getMainPanel().getVisitedOpenMicPanel().setVisible(true);

			mw.getMainPanel().getCRUDbox().setEnabled(true);
			mw.getMainPanel().getCRUDbox().setVisible(true);

			mw.getMainPanel().getConfirmButton().setEnabled(true);
			mw.getMainPanel().getConfirmButton().setVisible(true);

			mw.getMainPanel().getResetButton().setEnabled(true);
			mw.getMainPanel().getResetButton().setVisible(true);

			mw.getMainPanel().getEditPanel().setBackground(Color.WHITE);

			break;
		}
		case "confirm_button": {
			int CRUDop = mw.getMainPanel().getCRUDbox().getSelectedIndex(); // 0 = Add, 1 = Delete, 2 = Update

			switch (tableState) {
			case 1: { // Clowns Table
				switch (CRUDop) {
				case 0: { // ADD
					try {
						int id = Integer.parseInt(mw.getMainPanel().getIdField().getText());
						String fullname = mw.getMainPanel().getFullnameField().getText();
						long cc = Long.parseLong(mw.getMainPanel().getCcField().getText());
						int edLevel = Integer.parseInt(mw.getMainPanel().getEdLevelField().getText());
						int sidekickNum = Integer.parseInt(mw.getMainPanel().getSidekickNumField().getText());

						if (clownDAO.create(id + "", fullname, cc + "", edLevel + "", sidekickNum + "") == 0) {
							JOptionPane.showMessageDialog(mw, "A Clown has been created with ID: " + id,
									"Clown Created", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(mw,
									"Error with MySQL database.\n• DO NOT REPEAT ID's!\n• DO NOT REPEAT CC's!",
									"SQL Exception", JOptionPane.ERROR_MESSAGE);
						}
						updateTables();
						resetInputFields();

					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(mw,
								"Insert values with correct format:\nID: Number\nFullname: String\nCC: Number\nEducation Level: Number\nNo. of Sidekicks: Number",
								"Format Exception", JOptionPane.ERROR_MESSAGE);
					}
					break;
				}
				case 1: { // DELETE
					try {
						int id = Integer.parseInt(mw.getMainPanel().getIdField().getText());

						int result = clownDAO.delete(id);
						if (result == 0) {
							JOptionPane.showMessageDialog(mw, "A Clown with ID: " + id + " has been deleted.",
									"Clown Deleted", JOptionPane.INFORMATION_MESSAGE);
						} else if (result == 1) {
							JOptionPane.showMessageDialog(mw,
									"Error with MySQL database.\n• DO NOT REPEAT ID's!\n• DO NOT REPEAT CC's!",
									"SQL Exception", JOptionPane.ERROR_MESSAGE);
						} else if (result == 2) {
							JOptionPane.showMessageDialog(mw, "ID: " + id + " does not exist.", "ID Exception",
									JOptionPane.ERROR_MESSAGE);
						}
						updateTables();
						resetInputFields();

					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(mw, "Insert values with correct format:\nID: Number",
								"Format Exception", JOptionPane.ERROR_MESSAGE);
					}
					break;
				}
				case 2: { // UPDATE
					try {
						int id = Integer.parseInt(mw.getMainPanel().getIdField().getText());
						String fullname = mw.getMainPanel().getFullnameField().getText();
						long cc = Long.parseLong(mw.getMainPanel().getCcField().getText());
						int edLevel = Integer.parseInt(mw.getMainPanel().getEdLevelField().getText());
						int sidekickNum = Integer.parseInt(mw.getMainPanel().getSidekickNumField().getText());

						int result = clownDAO.update(id, id + "", fullname, cc + "", edLevel + "", sidekickNum + "");
						if (result == 0) {
							JOptionPane.showMessageDialog(mw, "A Clown with ID: " + id + " has been updated.",
									"Clown Updated", JOptionPane.INFORMATION_MESSAGE);
						} else if (result == 1) {
							JOptionPane.showMessageDialog(mw,
									"Error with MySQL database.\n• DO NOT REPEAT ID's!\n• DO NOT REPEAT CC's!",
									"SQL Exception", JOptionPane.ERROR_MESSAGE);
						} else if (result == 2) {
							JOptionPane.showMessageDialog(mw, "ID: " + id + " does not exist.", "ID Exception",
									JOptionPane.ERROR_MESSAGE);
						}
						updateTables();
						resetInputFields();

					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(mw,
								"Insert values with correct format:\nID: Number\nFullname: String\nCC: Number\nEducation Level: Number\nNo. of Sidekicks: Number",
								"Format Exception", JOptionPane.ERROR_MESSAGE);
					}
					break;
				}
				}
				break;
			}
			case 2: { // Comedians Table
				switch (CRUDop) {
				case 0: { // ADD
					try {
						int id = Integer.parseInt(mw.getMainPanel().getIdField().getText());
						String fullname = mw.getMainPanel().getFullnameField().getText();
						long cc = Long.parseLong(mw.getMainPanel().getCcField().getText());
						int edLevel = Integer.parseInt(mw.getMainPanel().getEdLevelField().getText());
						int visitedOpenMic = Integer.parseInt(mw.getMainPanel().getVisitedOpenMicField().getText());

						if (comedianDAO.create(id + "", fullname, cc + "", edLevel + "", visitedOpenMic + "") == 0) {
							JOptionPane.showMessageDialog(mw, "A Comedian has been created with ID: " + id,
									"Comedian Created", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(mw,
									"Error with MySQL database.\n• DO NOT REPEAT ID's!\n• DO NOT REPEAT CC's!",
									"SQL Exception", JOptionPane.ERROR_MESSAGE);
						}
						updateTables();
						resetInputFields();

					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(mw,
								"Insert values with correct format:\nID: Number\nFullname: String\nCC: Number\nEducation Level: Number\nNo. of Open Mic Visited: Number",
								"Format Exception", JOptionPane.ERROR_MESSAGE);
					}
					break;
				}
				case 1: { // DELETE
					try {
						int id = Integer.parseInt(mw.getMainPanel().getIdField().getText());

						int result = comedianDAO.delete(id);
						if (result == 0) {
							JOptionPane.showMessageDialog(mw, "A Comedian with ID: " + id + " has been deleted.",
									"Comedian Deleted", JOptionPane.INFORMATION_MESSAGE);
						} else if (result == 1) {
							JOptionPane.showMessageDialog(mw,
									"Error with MySQL database.\n• DO NOT REPEAT ID's!\n• DO NOT REPEAT CC's!",
									"SQL Exception", JOptionPane.ERROR_MESSAGE);
						} else if (result == 2) {
							JOptionPane.showMessageDialog(mw, "ID: " + id + " does not exist.", "ID Exception",
									JOptionPane.ERROR_MESSAGE);
						}
						updateTables();
						resetInputFields();

					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(mw, "Insert values with correct format:\nID: Number",
								"Format Exception", JOptionPane.ERROR_MESSAGE);
					}
					break;
				}
				case 2: { // UPDATE
					try {
						int id = Integer.parseInt(mw.getMainPanel().getIdField().getText());
						String fullname = mw.getMainPanel().getFullnameField().getText();
						long cc = Long.parseLong(mw.getMainPanel().getCcField().getText());
						int edLevel = Integer.parseInt(mw.getMainPanel().getEdLevelField().getText());
						int visitedOpenMic = Integer.parseInt(mw.getMainPanel().getVisitedOpenMicField().getText());

						int result = comedianDAO.update(id, id + "", fullname, cc + "", edLevel + "",
								visitedOpenMic + "");
						if (result == 0) {
							JOptionPane.showMessageDialog(mw, "A Comedian with ID: " + id + " has been updated.",
									"Comedian Updated", JOptionPane.INFORMATION_MESSAGE);
						} else if (result == 1) {
							JOptionPane.showMessageDialog(mw,
									"Error with MySQL database.\n• DO NOT REPEAT ID's!\n• DO NOT REPEAT CC's!",
									"SQL Exception", JOptionPane.ERROR_MESSAGE);
						} else if (result == 2) {
							JOptionPane.showMessageDialog(mw, "ID: " + id + " does not exist.", "ID Exception",
									JOptionPane.ERROR_MESSAGE);
						}
						updateTables();
						resetInputFields();

					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(mw,
								"Insert values with correct format:\nID: Number\nFullname: String\nCC: Number\nEducation Level: Number\nNo. of Open Mic Visited: Number",
								"Format Exception", JOptionPane.ERROR_MESSAGE);
					}
					break;
				}
				}
				break;
			}
			}

			break;
		}
		case "reset_button": {
			resetInputFields();
			break;
		}
		case "combobox_changed": {
			int CRUDop = mw.getMainPanel().getCRUDbox().getSelectedIndex(); // 0 = Add, 1 = Delete, 2 = Update
			switch (CRUDop) {
			case 0: {
				mw.getMainPanel().getIdPanel().setBorder(new TitledBorder("ID"));

				mw.getMainPanel().getFullnamePanel().setEnabled(true);
				mw.getMainPanel().getFullnamePanel().setVisible(true);

				mw.getMainPanel().getCcPanel().setEnabled(true);
				mw.getMainPanel().getCcPanel().setVisible(true);

				mw.getMainPanel().getEdLevelPanel().setEnabled(true);
				mw.getMainPanel().getEdLevelPanel().setVisible(true);

				if (tableState == 1) {
					mw.getMainPanel().getSidekickNumPanel().setEnabled(true);
					mw.getMainPanel().getSidekickNumPanel().setVisible(true);
				} else if (tableState == 2) {
					mw.getMainPanel().getVisitedOpenMicPanel().setEnabled(true);
					mw.getMainPanel().getVisitedOpenMicPanel().setVisible(true);
				}

				break;
			}
			case 1: {
				mw.getMainPanel().getIdPanel().setBorder(new TitledBorder("ID to Delete"));

				mw.getMainPanel().getFullnamePanel().setEnabled(false);
				mw.getMainPanel().getFullnamePanel().setVisible(false);

				mw.getMainPanel().getCcPanel().setEnabled(false);
				mw.getMainPanel().getCcPanel().setVisible(false);

				mw.getMainPanel().getEdLevelPanel().setEnabled(false);
				mw.getMainPanel().getEdLevelPanel().setVisible(false);

				mw.getMainPanel().getSidekickNumPanel().setEnabled(false);
				mw.getMainPanel().getSidekickNumPanel().setVisible(false);

				mw.getMainPanel().getVisitedOpenMicPanel().setEnabled(false);
				mw.getMainPanel().getVisitedOpenMicPanel().setVisible(false);
				break;
			}
			case 2: {
				mw.getMainPanel().getIdPanel().setBorder(new TitledBorder("ID to Update"));

				mw.getMainPanel().getFullnamePanel().setEnabled(true);
				mw.getMainPanel().getFullnamePanel().setVisible(true);

				mw.getMainPanel().getCcPanel().setEnabled(true);
				mw.getMainPanel().getCcPanel().setVisible(true);

				mw.getMainPanel().getEdLevelPanel().setEnabled(true);
				mw.getMainPanel().getEdLevelPanel().setVisible(true);

				if (tableState == 1) {
					mw.getMainPanel().getSidekickNumPanel().setEnabled(true);
					mw.getMainPanel().getSidekickNumPanel().setVisible(true);
				} else if (tableState == 2) {
					mw.getMainPanel().getVisitedOpenMicPanel().setEnabled(true);
					mw.getMainPanel().getVisitedOpenMicPanel().setVisible(true);
				}

				break;
			}
			}
			break;
		}
		}

	}

}
