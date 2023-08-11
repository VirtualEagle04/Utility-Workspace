package co.edu.unbosque.controller;

import java.util.Properties;

import co.edu.unbosque.model.persistance.FileHandler;
import co.edu.unbosque.view.Consola;
import co.edu.unbosque.view.VentanaPrincipal;

public class Controller {
	
	private Consola con;
	private Properties prop;
	private VentanaPrincipal vp;
	
	public Controller() {
		con = new Consola();
		prop = new Properties();
	}
	
	public void run() {
		
		con.printErrorSalto("1) Tamaño Smartphone\n2) Tamaño Laptop\n3) Tamaño Tablet");
		int op = con.leerInt();
		
		switch (op) {
		case 1: {
				prop = FileHandler.cargarPropiedades("configvpsmartphone.properties");
			break;
		}
		case 2: {
				prop = FileHandler.cargarPropiedades("configvplaptop.properties");
			break;
		}
		case 3: {
			prop = FileHandler.cargarPropiedades("configvptablet.properties");
		break;
		}
		default: {
			con.printErrorSalto("Tamaño valido");
			System.exit(0);
		}
	
		vp.setSize(Integer.parseInt(prop.getProperty("properties.ventanaprincipal.configuracion.anchura")), Integer.parseInt(prop.getProperty("properties.ventanaprincipal.configuracion.altura")));
		vp.repaint();
		vp = new VentanaPrincipal();
		}
	}
	
}
