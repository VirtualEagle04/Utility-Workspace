package co.edu.unbosque.controller;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.CarroDAO;
import co.edu.unbosque.model.CarroDTO;
import co.edu.unbosque.model.persistance.FileHandler;
import co.edu.unbosque.view.Console;
import co.edu.unbosque.view.MainWindow;

public class Controller implements ActionListener{

	private Console con;
	private MainWindow mw;
	private Properties prop_lang;
	private Properties prop_layout;
	private CarroDAO cdao;
	private ArrayList<String> lang;
	private ArrayList<String> layout;
	private int lang_op;
	private int layout_op;
	private String input;

	//Debug (no va aqui)
	private Scanner sc;
	
	public Controller() {
		con = new Console();
		prop_lang = new Properties();
		prop_layout = new Properties();
		cdao = new CarroDAO();
		sc = new Scanner(System.in);
		
		initialize();
	}
	
	public void agregarLectores() {
		mw.getInput().addActionListener(this);
		
		System.setIn(new InputStream() {
			public int read() {
				return sc.hasNext() ? sc.next().charAt(0) : -1;
			}
		});
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		input = mw.getInput().getText();
		mw.getOutput().append(input+"\n");
		mw.getInput().setText("");
	}

	public void initialize() {
		lang = (ArrayList<String>) FileHandler.leerSerializado("lang.txt");
		if (lang == null) {
			lang = new ArrayList<String>();
		}
		try {
			lang_op = Integer.parseInt(lang.get(0));
		} catch (Exception e) {
			
		}
		
		layout = (ArrayList<String>) FileHandler.leerSerializado("layout.txt");
		if (layout == null) {
			layout = new ArrayList<String>();
		}
		try {
			layout_op = Integer.parseInt(layout.get(0));
		}catch (Exception e) {
			
		}
	}
	
	public void run() {
			
			if(lang.isEmpty()) {
				Object[] idiomas = { "Espa�ol", "Ingles", "Frances", "Italiano", "Ruso", "Aleman" };
				int langsel = JOptionPane.showOptionDialog(null, "Seleccione el idioma deseado:", "Seleccion de Idioma", JOptionPane.DEFAULT_OPTION, 3, null, idiomas, idiomas[0]);
				lang.clear();
				switch (langsel) {
					case 0: {
						lang.add("0");
						FileHandler.escribirSerializado("lang.txt", lang);
						break;
					}
					case 1: {
						lang.add("1");
						FileHandler.escribirSerializado("lang.txt", lang);
						break;
					}
					case 2: {
						lang.add("2");
						FileHandler.escribirSerializado("lang.txt", lang);
						break;
					}
					case 3: {
						lang.add("3");
						FileHandler.escribirSerializado("lang.txt", lang);
						break;
					}
					case 4: {
						lang.add("4");
						FileHandler.escribirSerializado("lang.txt", lang);
						break;
					}
					case 5: {
						lang.add("5");
						FileHandler.escribirSerializado("lang.txt", lang);
						break;
					}
					default: 
				}
			}

			if(layout.isEmpty()) {
				Object[] ventanas = {"Smartphone", "Laptop", "Tablet", "Fullscreen"};
				int layoutsel = JOptionPane.showOptionDialog(null, prop_lang.getProperty("properties.menu.ventana"), "Seleccion de Ventana", JOptionPane.DEFAULT_OPTION, 3, null, ventanas, ventanas[0]);
				layout.clear();
				switch (layoutsel) {
					case 0: {
						layout.add("0");
						FileHandler.escribirSerializado("layout.txt", layout);
						break;
					}
					case 1: {
						layout.add("1");
						FileHandler.escribirSerializado("layout.txt", layout);
						break;
					}
					case 2: {
						layout.add("2");
						FileHandler.escribirSerializado("layout.txt", layout);
						break;
					}
					case 3: {
						layout.add("3");
						FileHandler.escribirSerializado("layout.txt", layout);
						break;
					}
					default: 
				}
			}
			
			initialize();
			mw = new MainWindow();
			
			switch(lang_op) {
				case 0: {
					prop_lang = FileHandler.cargarPropiedades("textESP.properties");
					break;
				}
				case 1: {
					prop_lang = FileHandler.cargarPropiedades("textING.properties");
					break;
				}
				case 2: {
					prop_lang = FileHandler.cargarPropiedades("textFRA.properties");
					break;
				}
				case 3: {
					prop_lang = FileHandler.cargarPropiedades("textITA.properties");
					break;
				}
				case 4: {
					prop_lang = FileHandler.cargarPropiedades("textRUS.properties");
					break;
				}
				case 5: {
					prop_lang = FileHandler.cargarPropiedades("textALE.properties");
					break;
				}
				default:
			}
			switch(layout_op) {
				case 0: {
					prop_layout = FileHandler.cargarPropiedades("DIMsmartphone.properties");
					mw.setSize( Integer.parseInt(prop_layout.getProperty("properties.mainwindow.width")), Integer.parseInt(prop_layout.getProperty("properties.mainwindow.height")));
					break;
				}
				case 1: {
					prop_layout = FileHandler.cargarPropiedades("DIMlaptop.properties");
					mw.setSize( Integer.parseInt(prop_layout.getProperty("properties.mainwindow.width")), Integer.parseInt(prop_layout.getProperty("properties.mainwindow.height")));
					break;
				}
				case 2: {
					prop_layout = FileHandler.cargarPropiedades("DIMtablet.properties");
					mw.setSize( Integer.parseInt(prop_layout.getProperty("properties.mainwindow.width")), Integer.parseInt(prop_layout.getProperty("properties.mainwindow.height")));
					break;
				}
				case 3: {
					Toolkit toolkit = Toolkit.getDefaultToolkit();
					Dimension dim = toolkit.getScreenSize();
					mw.setSize(dim.width, dim.height);
					break;
				}
				default:
		}
		mw.setVisible(true);
		agregarLectores();
		con.printSalto(prop_lang.getProperty("properties.menu.action"));
		con.printSalto(prop_lang.getProperty("properties.menu.options"));
		int op = con.leerInt();
		System.out.println(op);
		switch (op) {
		case 1: {
			con.quemarLinea();
			con.printSinSalto(prop_lang.getProperty("properties.menu.brand"));
			String marca = sc.nextLine();
			con.printSinSalto(prop_lang.getProperty("properties.menu.model"));
			String modelo =sc.nextLine();
			con.printSinSalto(prop_lang.getProperty("properties.menu.vmax"));
			float vmax = sc.nextFloat();
			
			cdao.crear(new CarroDTO(marca, modelo, vmax));
			con.printSalto(prop_lang.getProperty("properties.menu.created"));
			break;
		}
		case 2: {
			con.printSinSalto(prop_lang.getProperty("properties.menu.index"));
			int index = sc.nextInt();
			
			if(cdao.eliminar(index)) {
				con.printSalto(prop_lang.getProperty("properties.menu.deleted"));
			}else {
				con.printSalto(prop_lang.getProperty("properties.menu.notdeleted"));
			}
			break;
		}
		case 3: {
			con.printSinSalto(prop_lang.getProperty("properties.menu.indexupdate"));
			int index = sc.nextInt();
			con.quemarLinea();
			con.printSinSalto(prop_lang.getProperty("properties.menu.brand"));
			String marca = sc.nextLine();
			con.printSinSalto(prop_lang.getProperty("properties.menu.model"));
			String modelo = sc.nextLine();
			con.printSinSalto(prop_lang.getProperty("properties.menu.vmax"));
			float vmax = sc.nextFloat();
			
			if(cdao.actualizar(index, new CarroDTO(marca, modelo, vmax))) {
				con.printSalto(prop_lang.getProperty("properties.menu.edited"));
			}else {
				con.printSalto(prop_lang.getProperty("properties.menu.notedited"));
			}
			break;
		}
		case 4: {
			con.printSalto(cdao.mostrarTodo());
			break;
		}
		}
		
	}

}
