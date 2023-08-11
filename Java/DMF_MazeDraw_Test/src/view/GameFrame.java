package view;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	
	private GameState gameState;
	
	 public GameFrame() {
		setTitle("Maze Gen");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		gameState = new GameState();
		
		
		add(gameState);
		setVisible(true);
	}
}
