package co.edu.unbosque.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;

import co.edu.unbosque.modelo.Material;
import co.edu.unbosque.vista.Menu;

/**
 * Comprende la l�gica entre la interfaz de usuario y los objetos
 * representados por el Modelo.
 * @author fedeS
 * @param menu - objeto de la clase Menu.
	 * @param array_mat - ArrayList que contiene los materiales creados por el usuario.
	 * @param nombres - ArrayList que contiene los nombres de los materiales creados por el usuario.
	 * @param temp_nombre - variable que almacena temporalmente el nombre de un material.
	 * @param temp_marca - variable que almacena temporalmente la marca de un material.
	 * @param temp_precio - variable que almacena temporalmente el precio de un material.
	 * @param temp_dist - variable que almacena temporalmente el distribuidor de un material.
	 * @param temp_cant - variable que almacena temporalmente la cantidad de un material.
	 * @param actualizar_actual - variable que almacena temporalmente el indice del material que se quiere actualizar.
	 * @param eliminar_actual - variable que almacena temporalmente el indice del material que se quiere eliminar.
 * 
 *
 */


public class Controlador implements ActionListener {
	
	
	private Menu menu;
	private ArrayList<Material> array_mat;
	private ArrayList<String> nombres;
	private String temp_nombre;
	private String temp_marca;
	private double temp_precio;
	private String temp_dist;
	private int temp_cant;
	private int actualizar_actual;
	private int eliminar_actual;
	
	public Controlador() {
		array_mat = new ArrayList<Material>();
		nombres = new ArrayList<String>();
	}
	
	/**
	 * Crea una instancia de la interfaz grafica
	 * y activa las utilidades que permiten la funcionalidad del programa.
	 * 
	 */
	
	public void run() {
		menu = new Menu();
		agregarLectores();
		
		
	}
	
	/**
	 * Define cada boton de la interfaz gr�fica, con su respectiva funci�n.
	 * 
	 */
	
	public void agregarLectores() {

		
		
		menu.getAgregar().addActionListener(this);
		menu.getAgregar().setActionCommand("agregar");
		
		menu.getListar().addActionListener(this);
		menu.getListar().setActionCommand("listar");
		
		
		menu.getAgregarConfirmar().addActionListener(this);
		menu.getAgregarConfirmar().setActionCommand("agregar_confirmar");
		
		menu.getActualizarConfirmar().addActionListener(this);
		menu.getActualizarConfirmar().setActionCommand("actualizar_confirmar");
	}
	
	/**
	 * 
	 * Define las interacciones de actualizaci�n y eliminaci�n presentes en los objetos 
	 * creados, los cuales contienen la informaci�n respectiva frente al material registrado.
	 * 
	 */
	
	
	public void agregarLectoresPanel() {
		for (int i = 0; i < menu.getBotones_mat().size(); i++) {
			menu.getBotones_mat().get(i).addActionListener(this);
			menu.getBotones_mat().get(i).setActionCommand("panelBoton"+i);
		}
	}
	
	
	/**
	 * Establece los comandos/funcionalidad de cada elemento interactivo.
	 * 
	 */
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "agregar": {
				
			
				menu.getAgregarPanel().setVisible(true);
				menu.getActualizarPanel().setVisible(false);
				menu.getListarPanel().setVisible(false);
				menu.getEliminarPanel().setVisible(false);
			
			break;
			}
			case "listar": {
				
				menu.getCampo_n().setText("");
				menu.getCampo_m().setText("");
				menu.getCampo_p().setText("");
				menu.getCampo_d().setText("");
				menu.getCampo_c().setText("");
				
				
				menu.getListarPanel().setVisible(true);
				menu.getAgregarPanel().setVisible(false);
				menu.getActualizarPanel().setVisible(false);
				menu.getEliminarPanel().setVisible(false);
			
			break;
			}
			case "agregar_confirmar": {
				
				int verificacion = 0;
				
				
				if(menu.getCampo_n().getText().isEmpty()) {
					menu.getCampo_n().setText("");
					menu.getCampo_n().setBackground(new Color(115, 11, 11));
				}
				else {
					temp_nombre = menu.getCampo_n().getText();
					verificacion++;
				}
				
				if(menu.getCampo_m().getText().isEmpty()) {
					menu.getCampo_m().setText("");
					menu.getCampo_m().setBackground(new Color(115, 11, 11));
				}
				else {
					temp_marca = menu.getCampo_m().getText();
					verificacion++;
				}
				
				try {
					 temp_precio = Double.parseDouble(menu.getCampo_p().getText());
					 verificacion++;
					 
				 }
				 catch (NumberFormatException e2) {
					 menu.getCampo_p().setText("");
					 menu.getCampo_p().setBackground(new Color(115, 11, 11));
				 }
				
				if(menu.getCampo_d().getText().isEmpty()) {
					menu.getCampo_d().setText("");
					menu.getCampo_d().setBackground(new Color(115, 11, 11));
				}
				else {
					temp_dist = menu.getCampo_d().getText();
					verificacion++;
				}
				
				
				try {
					 temp_cant = Integer.parseInt(menu.getCampo_c().getText());
					 verificacion++;
				 }
				 catch (NumberFormatException e2) {
					 menu.getCampo_c().setText("");
					 menu.getCampo_c().setBackground(new Color(115, 11, 11));
				 }
				
				if(verificacion == 5) {
						 
							array_mat.add(new Material(temp_nombre, temp_marca, temp_precio, temp_dist, temp_cant));
						 
							menu.adicionarContenido(temp_nombre, temp_marca, temp_precio, temp_dist, temp_cant);
						 
							agregarLectoresPanel();
							
							menu.getAgregarPanel().setVisible(false);
							menu.getListarPanel().setVisible(true);
							
							menu.getCampo_n().setText("");
							menu.getCampo_m().setText("");
							menu.getCampo_p().setText("");
							menu.getCampo_d().setText("");
							menu.getCampo_c().setText("");
				}

				
				 
				 
			
			break;
			}
			case "actualizar_confirmar": {
				
				array_mat.get(actualizar_actual).setNombre(menu.getCampoE_n().getText());
				array_mat.get(actualizar_actual).setMarca(menu.getCampoE_m().getText());
				array_mat.get(actualizar_actual).setPrecio(Double.parseDouble(menu.getCampoE_p().getText()));
				array_mat.get(actualizar_actual).setDistribuidor(menu.getCampoE_d().getText());
				array_mat.get(actualizar_actual).setCantidad(Integer.parseInt(menu.getCampoE_c().getText()));
				
				menu.getActualizarPanel().setVisible(false);
				menu.getListarPanel().setVisible(true);
				
				menu.getPaneles_nombre().get(actualizar_actual).setText(menu.getCampoE_n().getText());
				menu.getPaneles_marca().get(actualizar_actual).setText("Marca: "+menu.getCampoE_m().getText());
				menu.getPaneles_precio().get(actualizar_actual).setText("Precio (COP): "+menu.getCampoE_p().getText());
				menu.getPaneles_dist().get(actualizar_actual).setText("Distribuidor: "+menu.getCampoE_d().getText());
				menu.getPaneles_cant().get(actualizar_actual).setText("Cantidad: "+menu.getCampoE_c().getText());
				
				break;
			}
			
			case "panelBoton0": {
				menu.getActualizarPanel().setVisible(true);
				menu.getAgregarPanel().setVisible(false);
				menu.getListarPanel().setVisible(false);
				actualizar_actual = 0;
				
				menu.getCampoE_n().setText(array_mat.get(0).getNombre());
				menu.getCampoE_m().setText(array_mat.get(0).getMarca());
				menu.getCampoE_p().setText(Double.parseDouble(array_mat.get(0).getPrecio()+"")+"");
				menu.getCampoE_d().setText(array_mat.get(0).getDistribuidor());
				menu.getCampoE_c().setText(array_mat.get(0).getCantidad()+"");
				
			break;
			}
			case "panelBoton1": {
				
				eliminar_actual = 0;
				
				array_mat.get(eliminar_actual).setNombre("");
				array_mat.get(eliminar_actual).setMarca("");
				array_mat.get(eliminar_actual).setPrecio(0);
				array_mat.get(eliminar_actual).setDistribuidor("");
				array_mat.get(eliminar_actual).setCantidad(0);
				
				
				menu.getScrolllist_panel_nombres().repaint();
				menu.getPaneles_nombre().get(eliminar_actual).setText("");
				menu.getPaneles_marca().get(eliminar_actual).setText("Marca: ");
				menu.getPaneles_precio().get(eliminar_actual).setText("Precio (COP): ");
				menu.getPaneles_dist().get(eliminar_actual).setText("Distribuidor: ");
				menu.getPaneles_cant().get(eliminar_actual).setText("Cantidad: ");
				
			break;
			}
			case "panelBoton2": {
				menu.getActualizarPanel().setVisible(true);
				menu.getAgregarPanel().setVisible(false);
				menu.getListarPanel().setVisible(false);
				actualizar_actual = 1;
				
				menu.getCampoE_n().setText(array_mat.get(1).getNombre());
				menu.getCampoE_m().setText(array_mat.get(1).getMarca());
				menu.getCampoE_p().setText(Double.parseDouble(array_mat.get(0).getPrecio()+"")+"");
				menu.getCampoE_d().setText(array_mat.get(1).getDistribuidor());
				menu.getCampoE_c().setText(array_mat.get(1).getCantidad()+"");
				
			break;
			}
			case "panelBoton3": {
				
				eliminar_actual = 1;
				
				array_mat.get(eliminar_actual).setNombre("");
				array_mat.get(eliminar_actual).setMarca("");
				array_mat.get(eliminar_actual).setPrecio(0);
				array_mat.get(eliminar_actual).setDistribuidor("");
				array_mat.get(eliminar_actual).setCantidad(0);
				
				menu.getScrolllist_panel_nombres().repaint();
				menu.getPaneles_nombre().get(eliminar_actual).setText("");
				menu.getPaneles_marca().get(eliminar_actual).setText("Marca: ");
				menu.getPaneles_precio().get(eliminar_actual).setText("Precio (COP): ");
				menu.getPaneles_dist().get(eliminar_actual).setText("Distribuidor: ");
				menu.getPaneles_cant().get(eliminar_actual).setText("Cantidad: ");
				
			break;
			}
			case "panelBoton4": {
				menu.getActualizarPanel().setVisible(true);
				menu.getAgregarPanel().setVisible(false);
				menu.getListarPanel().setVisible(false);
				actualizar_actual = 2;
				
				menu.getCampoE_n().setText(array_mat.get(2).getNombre());
				menu.getCampoE_m().setText(array_mat.get(2).getMarca());
				menu.getCampoE_p().setText(Double.parseDouble(array_mat.get(0).getPrecio()+"")+"");
				menu.getCampoE_d().setText(array_mat.get(2).getDistribuidor());
				menu.getCampoE_c().setText(array_mat.get(2).getCantidad()+"");
				
			break;
			}
			case "panelBoton5": {
				
				eliminar_actual = 2;
				
				array_mat.get(eliminar_actual).setNombre("");
				array_mat.get(eliminar_actual).setMarca("");
				array_mat.get(eliminar_actual).setPrecio(0);
				array_mat.get(eliminar_actual).setDistribuidor("");
				array_mat.get(eliminar_actual).setCantidad(0);
				
				menu.getScrolllist_panel_nombres().repaint();
				menu.getPaneles_nombre().get(eliminar_actual).setText("");
				menu.getPaneles_marca().get(eliminar_actual).setText("Marca: ");
				menu.getPaneles_precio().get(eliminar_actual).setText("Precio (COP): ");
				menu.getPaneles_dist().get(eliminar_actual).setText("Distribuidor: ");
				menu.getPaneles_cant().get(eliminar_actual).setText("Cantidad: ");
				
			break;
			}
			case "panelBoton6": {
				menu.getActualizarPanel().setVisible(true);
				menu.getAgregarPanel().setVisible(false);
				menu.getListarPanel().setVisible(false);
				actualizar_actual = 3;
				
				menu.getCampoE_n().setText(array_mat.get(3).getNombre());
				menu.getCampoE_m().setText(array_mat.get(3).getMarca());
				menu.getCampoE_p().setText(Double.parseDouble(array_mat.get(0).getPrecio()+"")+"");
				menu.getCampoE_d().setText(array_mat.get(3).getDistribuidor());
				menu.getCampoE_c().setText(array_mat.get(3).getCantidad()+"");
				
			break;
			}
			case "panelBoton7": {
				
				eliminar_actual = 3;
				
				array_mat.get(eliminar_actual).setNombre("");
				array_mat.get(eliminar_actual).setMarca("");
				array_mat.get(eliminar_actual).setPrecio(0);
				array_mat.get(eliminar_actual).setDistribuidor("");
				array_mat.get(eliminar_actual).setCantidad(0);
				
				menu.getScrolllist_panel_nombres().repaint();
				menu.getPaneles_nombre().get(eliminar_actual).setText("");
				menu.getPaneles_marca().get(eliminar_actual).setText("Marca: ");
				menu.getPaneles_precio().get(eliminar_actual).setText("Precio (COP): ");
				menu.getPaneles_dist().get(eliminar_actual).setText("Distribuidor: ");
				menu.getPaneles_cant().get(eliminar_actual).setText("Cantidad: ");
				
			break;
			}
			case "panelBoton8": {
				menu.getActualizarPanel().setVisible(true);
				menu.getAgregarPanel().setVisible(false);
				menu.getListarPanel().setVisible(false);
				actualizar_actual = 4;
				
				menu.getCampoE_n().setText(array_mat.get(4).getNombre());
				menu.getCampoE_m().setText(array_mat.get(4).getMarca());
				menu.getCampoE_p().setText(Double.parseDouble(array_mat.get(0).getPrecio()+"")+"");
				menu.getCampoE_d().setText(array_mat.get(4).getDistribuidor());
				menu.getCampoE_c().setText(array_mat.get(4).getCantidad()+"");
				
			break;
			}
			case "panelBoton9": {
				
				eliminar_actual = 4;
				
				array_mat.get(eliminar_actual).setNombre("");
				array_mat.get(eliminar_actual).setMarca("");
				array_mat.get(eliminar_actual).setPrecio(0);
				array_mat.get(eliminar_actual).setDistribuidor("");
				array_mat.get(eliminar_actual).setCantidad(0);
				
				menu.getScrolllist_panel_nombres().repaint();
				menu.getPaneles_nombre().get(eliminar_actual).setText("");
				menu.getPaneles_marca().get(eliminar_actual).setText("Marca: ");
				menu.getPaneles_precio().get(eliminar_actual).setText("Precio (COP): ");
				menu.getPaneles_dist().get(eliminar_actual).setText("Distribuidor: ");
				menu.getPaneles_cant().get(eliminar_actual).setText("Cantidad: ");
				
			break;
			}
			case "panelBoton10": {
				menu.getActualizarPanel().setVisible(true);
				menu.getAgregarPanel().setVisible(false);
				menu.getListarPanel().setVisible(false);
				actualizar_actual = 5;
				
				menu.getCampoE_n().setText(array_mat.get(5).getNombre());
				menu.getCampoE_m().setText(array_mat.get(5).getMarca());
				menu.getCampoE_p().setText(Double.parseDouble(array_mat.get(0).getPrecio()+"")+"");
				menu.getCampoE_d().setText(array_mat.get(5).getDistribuidor());
				menu.getCampoE_c().setText(array_mat.get(5).getCantidad()+"");
				
			break;
			}
			case "panelBoton11": {
				
				eliminar_actual = 5;
				
				array_mat.get(eliminar_actual).setNombre("");
				array_mat.get(eliminar_actual).setMarca("");
				array_mat.get(eliminar_actual).setPrecio(0);
				array_mat.get(eliminar_actual).setDistribuidor("");
				array_mat.get(eliminar_actual).setCantidad(0);
				
				menu.getScrolllist_panel_nombres().repaint();
				menu.getPaneles_nombre().get(eliminar_actual).setText("");
				menu.getPaneles_marca().get(eliminar_actual).setText("Marca: ");
				menu.getPaneles_precio().get(eliminar_actual).setText("Precio (COP): ");
				menu.getPaneles_dist().get(eliminar_actual).setText("Distribuidor: ");
				menu.getPaneles_cant().get(eliminar_actual).setText("Cantidad: ");
				
			break;
			}
			case "panelBoton12": {
				menu.getActualizarPanel().setVisible(true);
				menu.getAgregarPanel().setVisible(false);
				menu.getListarPanel().setVisible(false);
				actualizar_actual = 6;
				
				menu.getCampoE_n().setText(array_mat.get(6).getNombre());
				menu.getCampoE_m().setText(array_mat.get(6).getMarca());
				menu.getCampoE_p().setText(Double.parseDouble(array_mat.get(0).getPrecio()+"")+"");
				menu.getCampoE_d().setText(array_mat.get(6).getDistribuidor());
				menu.getCampoE_c().setText(array_mat.get(6).getCantidad()+"");
				
			break;
			}
			case "panelBoton13": {
				
				eliminar_actual = 6;
				
				array_mat.get(eliminar_actual).setNombre("");
				array_mat.get(eliminar_actual).setMarca("");
				array_mat.get(eliminar_actual).setPrecio(0);
				array_mat.get(eliminar_actual).setDistribuidor("");
				array_mat.get(eliminar_actual).setCantidad(0);
				
				menu.getScrolllist_panel_nombres().repaint();
				menu.getPaneles_nombre().get(eliminar_actual).setText("");
				menu.getPaneles_marca().get(eliminar_actual).setText("Marca: ");
				menu.getPaneles_precio().get(eliminar_actual).setText("Precio (COP): ");
				menu.getPaneles_dist().get(eliminar_actual).setText("Distribuidor: ");
				menu.getPaneles_cant().get(eliminar_actual).setText("Cantidad: ");
				
			break;
			}
			case "panelBoton14": {
				menu.getActualizarPanel().setVisible(true);
				menu.getAgregarPanel().setVisible(false);
				menu.getListarPanel().setVisible(false);
				actualizar_actual = 7;
				
				menu.getCampoE_n().setText(array_mat.get(7).getNombre());
				menu.getCampoE_m().setText(array_mat.get(7).getMarca());
				menu.getCampoE_p().setText(Double.parseDouble(array_mat.get(0).getPrecio()+"")+"");
				menu.getCampoE_d().setText(array_mat.get(7).getDistribuidor());
				menu.getCampoE_c().setText(array_mat.get(7).getCantidad()+"");
				
			break;
			}
			case "panelBoton15": {
				
				eliminar_actual = 7;
				
				array_mat.get(eliminar_actual).setNombre("");
				array_mat.get(eliminar_actual).setMarca("");
				array_mat.get(eliminar_actual).setPrecio(0);
				array_mat.get(eliminar_actual).setDistribuidor("");
				array_mat.get(eliminar_actual).setCantidad(0);
				
				menu.getScrolllist_panel_nombres().repaint();
				menu.getPaneles_nombre().get(eliminar_actual).setText("");
				menu.getPaneles_marca().get(eliminar_actual).setText("Marca: ");
				menu.getPaneles_precio().get(eliminar_actual).setText("Precio (COP): ");
				menu.getPaneles_dist().get(eliminar_actual).setText("Distribuidor: ");
				menu.getPaneles_cant().get(eliminar_actual).setText("Cantidad: ");
				
			break;
			}
			case "panelBoton16": {
				menu.getActualizarPanel().setVisible(true);
				menu.getAgregarPanel().setVisible(false);
				menu.getListarPanel().setVisible(false);
				actualizar_actual = 8;
				
				menu.getCampoE_n().setText(array_mat.get(8).getNombre());
				menu.getCampoE_m().setText(array_mat.get(8).getMarca());
				menu.getCampoE_p().setText(Double.parseDouble(array_mat.get(0).getPrecio()+"")+"");
				menu.getCampoE_d().setText(array_mat.get(8).getDistribuidor());
				menu.getCampoE_c().setText(array_mat.get(8).getCantidad()+"");
				
			break;
			}
			case "panelBoton17": {
				
				eliminar_actual = 8;
				
				array_mat.get(eliminar_actual).setNombre("");
				array_mat.get(eliminar_actual).setMarca("");
				array_mat.get(eliminar_actual).setPrecio(0);
				array_mat.get(eliminar_actual).setDistribuidor("");
				array_mat.get(eliminar_actual).setCantidad(0);
				
				menu.getScrolllist_panel_nombres().repaint();
				menu.getPaneles_nombre().get(eliminar_actual).setText("");
				menu.getPaneles_marca().get(eliminar_actual).setText("Marca: ");
				menu.getPaneles_precio().get(eliminar_actual).setText("Precio (COP): ");
				menu.getPaneles_dist().get(eliminar_actual).setText("Distribuidor: ");
				menu.getPaneles_cant().get(eliminar_actual).setText("Cantidad: ");
				
			break;
			}
			case "panelBoton18": {
				menu.getActualizarPanel().setVisible(true);
				menu.getAgregarPanel().setVisible(false);
				menu.getListarPanel().setVisible(false);
				actualizar_actual = 9;
				
				menu.getCampoE_n().setText(array_mat.get(9).getNombre());
				menu.getCampoE_m().setText(array_mat.get(9).getMarca());
				menu.getCampoE_p().setText(Double.parseDouble(array_mat.get(0).getPrecio()+"")+"");
				menu.getCampoE_d().setText(array_mat.get(9).getDistribuidor());
				menu.getCampoE_c().setText(array_mat.get(9).getCantidad()+"");
				
			break;
			}
			case "panelBoton19": {
				
				eliminar_actual = 9;
				
				array_mat.get(eliminar_actual).setNombre("");
				array_mat.get(eliminar_actual).setMarca("");
				array_mat.get(eliminar_actual).setPrecio(0);
				array_mat.get(eliminar_actual).setDistribuidor("");
				array_mat.get(eliminar_actual).setCantidad(0);
				
				menu.getScrolllist_panel_nombres().repaint();
				menu.getPaneles_nombre().get(eliminar_actual).setText("");
				menu.getPaneles_marca().get(eliminar_actual).setText("Marca: ");
				menu.getPaneles_precio().get(eliminar_actual).setText("Precio (COP): ");
				menu.getPaneles_dist().get(eliminar_actual).setText("Distribuidor: ");
				menu.getPaneles_cant().get(eliminar_actual).setText("Cantidad: ");
				
			break;
			}
			
			
			
			default: {
				
			}
		}
		
		
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public ArrayList<Material> getArray_mat() {
		return array_mat;
	}

	public void setArray_mat(ArrayList<Material> array_mat) {
		this.array_mat = array_mat;
	}

	public String getTemp_nombre() {
		return temp_nombre;
	}

	public void setTemp_nombre(String temp_nombre) {
		this.temp_nombre = temp_nombre;
	}

	public String getTemp_marca() {
		return temp_marca;
	}

	public void setTemp_marca(String temp_marca) {
		this.temp_marca = temp_marca;
	}

	public double getTemp_precio() {
		return temp_precio;
	}

	public void setTemp_precio(double temp_precio) {
		this.temp_precio = temp_precio;
	}

	public String getTemp_dist() {
		return temp_dist;
	}

	public void setTemp_dist(String temp_dist) {
		this.temp_dist = temp_dist;
	}

	public int getTemp_cant() {
		return temp_cant;
	}

	public void setTemp_cant(int temp_cant) {
		this.temp_cant = temp_cant;
	}

	public ArrayList<String> getNombres() {
		return nombres;
	}

	public void setNombres(ArrayList<String> nombres) {
		this.nombres = nombres;
	}
	
}
