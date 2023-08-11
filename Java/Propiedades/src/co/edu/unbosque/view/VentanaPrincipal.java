package co.edu.unbosque.view;

import java.awt.Color;
import java.util.Properties;

import javax.swing.JFrame;

import co.edu.unbosque.model.persistance.FileHandler;

public class VentanaPrincipal extends JFrame{

	private Properties prop;
	
	public VentanaPrincipal() {
		prop = new Properties();
		prop = FileHandler.cargarPropiedades("configvp.properties");
		
		
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.MAGENTA);
		
		
		setVisible(true);
	}
	
}
