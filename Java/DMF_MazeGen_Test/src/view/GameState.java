package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;

public class GameState extends JPanel{
	
	private Controller c;
	private JButton[] celdas;
	private JPanel tablero;
	
	public GameState() {
		setSize(1024, 768);
		setLocation(0,0);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		c = new Controller();
		
		tablero = new JPanel();
		tablero.setBackground(Color.CYAN);
		tablero.setSize(400, 400);
		tablero.setLocation(312, 184);
		tablero.setLayout(new GridLayout(c.getAncho(), c.getAlto()));
		
		celdas = new JButton[c.getAncho() * c.getAlto()];
		for (int i = 0; i < celdas.length; i++) {
			if (c.getMazeMap().get(i) == 1) {
				celdas[i] = new JButton();
				celdas[i].setBackground(Color.BLACK);
				celdas[i].setBorderPainted(false);
				tablero.add(celdas[i]);
			}
			if (c.getMazeMap().get(i) == 0) {
				celdas[i] = new JButton();
				celdas[i].setBackground(Color.WHITE);
				celdas[i].setBorderPainted(false);
				tablero.add(celdas[i]);
			}
		}
		
		
		
		add(tablero);
	}
	
}
