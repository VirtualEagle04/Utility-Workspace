package co.edu.unbosque.vista;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
	
	public GameWindow() {
		//GameWindow 
		setTitle("Dungeons, Mazes and Forest");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		//GamePanel
		GamePanel gamePanel = new GamePanel();
		add(gamePanel);
		
		
		pack();
		setVisible(true);
		gamePanel.startGameThread();
	}
	
	
}
