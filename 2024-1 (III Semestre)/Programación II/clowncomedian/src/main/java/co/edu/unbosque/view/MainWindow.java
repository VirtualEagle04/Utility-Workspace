package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainWindow extends JFrame {

	private MainPanel mainPanel;

	private JMenuBar menubar;
	private JMenu peopleMenu, clownsMenu, comediansMenu;
	private JMenuItem pMenu, clownsEditMenu, comediansEditMenu;

	public MainWindow() {
		setTitle("CCManager: Clowns and Comedians Manager");
		setSize(920, 480);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		menubar = new JMenuBar();
		peopleMenu = new JMenu("People Table");
		clownsMenu = new JMenu("Clowns Table");
		comediansMenu = new JMenu("Comedians Table");

		pMenu = new JMenuItem("Show People Table");
		clownsEditMenu = new JMenuItem("Edit Clowns Table");
		comediansEditMenu = new JMenuItem("Edit Comedians Table");

		peopleMenu.add(pMenu);
		clownsMenu.add(clownsEditMenu);
		comediansMenu.add(comediansEditMenu);

		menubar.add(peopleMenu);
		menubar.add(clownsMenu);
		menubar.add(comediansMenu);

		setJMenuBar(menubar);

		mainPanel = new MainPanel();
		add(mainPanel);

		setVisible(true);
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JMenuBar getMenubar() {
		return menubar;
	}

	public void setMenubar(JMenuBar menubar) {
		this.menubar = menubar;
	}

	public JMenu getPeopleMenu() {
		return peopleMenu;
	}

	public void setPeopleMenu(JMenu peopleMenu) {
		this.peopleMenu = peopleMenu;
	}

	public JMenu getClownsMenu() {
		return clownsMenu;
	}

	public void setClownsMenu(JMenu clownsMenu) {
		this.clownsMenu = clownsMenu;
	}

	public JMenu getComediansMenu() {
		return comediansMenu;
	}

	public void setComediansMenu(JMenu comediansMenu) {
		this.comediansMenu = comediansMenu;
	}

	public JMenuItem getpMenu() {
		return pMenu;
	}

	public void setpMenu(JMenuItem pMenu) {
		this.pMenu = pMenu;
	}

	public JMenuItem getClownsEditMenu() {
		return clownsEditMenu;
	}

	public void setClownsEditMenu(JMenuItem clownsEditMenu) {
		this.clownsEditMenu = clownsEditMenu;
	}

	public JMenuItem getComediansEditMenu() {
		return comediansEditMenu;
	}

	public void setComediansEditMenu(JMenuItem comediansEditMenu) {
		this.comediansEditMenu = comediansEditMenu;
	}

}
