package co.edu.unbosque.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import co.edu.unbosque.controlador.Controlador;


/**
 * Todo componente visual. Partiendo desde la interfaz como:
 * Botones, Campos de texto, Paneles, y demás.
 * Permite que la interacción del usuario con el programa sea más dinámica y práctica.
 * @author fedeS
 *
 */

public class Menu extends JFrame  {
		
	private JButton agregar, listar;
	private ArrayList<JButton> botones_mat;
	private ArrayList<JPanel> panel_mat;
	private ArrayList<JLabel> paneles_nombre;
	private ArrayList<JLabel> paneles_marca;
	private ArrayList<JLabel> paneles_precio;
	private ArrayList<JLabel> paneles_dist;
	private ArrayList<JLabel> paneles_cant;
	private JPanel agregarPanel, actualizarPanel, eliminarPanel, listarPanel, scrolllist_panel_nombres;
	private JTextArea t_agregar, agregarNombre, agregarMarca, agregarPrecio, agregarDist, agregarCantidad;
	private JTextArea t_actualizar, actualizarNombre, actualizarMarca, actualizarPrecio, actualizarDist, actualizarCantidad;
	private JTextField campoE_n, campoE_m, campoE_p, campoE_d, campoE_c;
	private JTextField campo_n, campo_m, campo_p, campo_d, campo_c;
	private JButton agregarConfirmar, actualizarConfirmar;
	private JScrollPane scrollLista;
	private ArrayList<JLabel> nombres;
	
	private JButton test ,test2;
	
	
	private Controlador c = new Controlador();
	

	public Menu() {
		
		botones_mat = new ArrayList<JButton>();
		panel_mat = new ArrayList<JPanel>();
		paneles_nombre = new ArrayList<JLabel>();
		paneles_marca = new ArrayList<JLabel>();
		paneles_precio = new ArrayList<JLabel>();
		paneles_dist = new ArrayList<JLabel>();
		paneles_cant = new ArrayList<JLabel>();
	
		setTitle("Papeleria");
		setSize(800, 460);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		//Botones
		agregar = new JButton();
		agregar.setBounds(10, 100, 360, 70);
		agregar.setText("Agregar material");
		agregar.setFont(new Font("Arial", Font.ITALIC, 20));
		agregar.setBackground(Color.DARK_GRAY);
		agregar.setForeground(Color.WHITE);
		
		
		listar = new JButton();
		listar.setBounds(10, 240, 360, 70);
		listar.setText("Listar materiales");
		listar.setFont(new Font("Arial", Font.ITALIC, 20));
		listar.setBackground(Color.DARK_GRAY);
		listar.setForeground(Color.WHITE);
		
		
		//Paneles
		agregarPanel = new JPanel();
		agregarPanel.setLayout(null);
		agregarPanel.setBounds(400, 5, 370, 410);
		agregarPanel.setBackground(Color.LIGHT_GRAY);
		
		actualizarPanel = new JPanel();
		actualizarPanel.setLayout(null);
		actualizarPanel.setBounds(400, 5, 370, 410);
		actualizarPanel.setBackground(Color.LIGHT_GRAY);
		
		eliminarPanel = new JPanel();
		eliminarPanel.setBounds(400, 5, 370, 410);
		eliminarPanel.setBackground(Color.LIGHT_GRAY);
		
		listarPanel = new JPanel();
		listarPanel.setLayout(null);
		listarPanel.setBounds(400, 5, 370, 410);
		listarPanel.setBackground(Color.LIGHT_GRAY);
		
		//Agregar Panel
		t_agregar = new JTextArea();
		t_agregar.setBounds(135, 10, 100, 20);
		t_agregar.setEditable(false);
		t_agregar.setOpaque(false);
		t_agregar.setText("AGREGAR");
		t_agregar.setFont(new Font("Arial", Font.BOLD, 20));
		t_agregar.setForeground(Color.BLACK);
		
		
		agregarNombre = new JTextArea();
		agregarNombre.setBounds(15, 40, 100, 20);
		agregarNombre.setEditable(false);
		agregarNombre.setOpaque(false);
		agregarNombre.setText("Nombre:");
		agregarNombre.setFont(new Font("Arial", Font.BOLD, 20));
		agregarNombre.setForeground(Color.BLACK);
		
		campo_n = new JTextField();
		campo_n.setBounds(145, 43, 200, 20);
		campo_n.setEditable(true);
		campo_n.setFont(new Font("Arial", Font.BOLD, 20));
		campo_n.setForeground(Color.BLACK);
		
		agregarMarca = new JTextArea();
		agregarMarca.setBounds(15, 110, 100, 20);
		agregarMarca.setEditable(false);
		agregarMarca.setOpaque(false);
		agregarMarca.setText("Marca:");
		agregarMarca.setFont(new Font("Arial", Font.BOLD, 20));
		agregarMarca.setForeground(Color.BLACK);
		
		campo_m = new JTextField();
		campo_m.setBounds(145, 115, 200, 20);
		campo_m.setEditable(true);
		campo_m.setFont(new Font("Arial", Font.BOLD, 20));
		campo_m.setForeground(Color.BLACK);
		
		agregarPrecio = new JTextArea();
		agregarPrecio.setBounds(15, 185, 100, 20);
		agregarPrecio.setEditable(false);
		agregarPrecio.setOpaque(false);
		agregarPrecio.setText("Precio:");
		agregarPrecio.setFont(new Font("Arial", Font.BOLD, 20));
		agregarPrecio.setForeground(Color.BLACK);
		
		campo_p = new JTextField();
		campo_p.setBounds(145, 188, 200, 20);
		campo_p.setEditable(true);
		campo_p.setFont(new Font("Arial", Font.BOLD, 20));
		campo_p.setForeground(Color.BLACK);
		
		agregarDist = new JTextArea();
		agregarDist.setBounds(15, 260, 120, 20);
		agregarDist.setEditable(false);
		agregarDist.setOpaque(false);
		agregarDist.setText("Distribuidor:");
		agregarDist.setFont(new Font("Arial", Font.BOLD, 20));
		agregarDist.setForeground(Color.BLACK);
		
		campo_d = new JTextField();
		campo_d.setBounds(145, 263, 200, 20);
		campo_d.setEditable(true);
		campo_d.setFont(new Font("Arial", Font.BOLD, 20));
		campo_d.setForeground(Color.BLACK);
		
		agregarCantidad = new JTextArea();
		agregarCantidad.setBounds(15, 338, 100, 20);
		agregarCantidad.setEditable(false);
		agregarCantidad.setOpaque(false);
		agregarCantidad.setText("Cantidad:");
		agregarCantidad.setFont(new Font("Arial", Font.BOLD, 20));
		agregarCantidad.setForeground(Color.BLACK);
		
		campo_c = new JTextField();
		campo_c.setBounds(145, 340, 200, 20);
		campo_c.setEditable(true);
		campo_c.setFont(new Font("Arial", Font.BOLD, 20));
		campo_c.setForeground(Color.BLACK);
		
		agregarConfirmar = new JButton();
		agregarConfirmar.setBounds(100, 380, 170, 20);
		agregarConfirmar.setOpaque(false);
		agregarConfirmar.setText("Confirmar");
		agregarConfirmar.setFont(new Font("Arial", Font.BOLD, 20));
		agregarConfirmar.setForeground(Color.BLACK);
		
		add(agregarPanel, JLayeredPane.DRAG_LAYER);
		this.agregarPanel.add(t_agregar);
		this.agregarPanel.add(agregarNombre);
		this.agregarPanel.add(campo_n);
		this.agregarPanel.add(agregarMarca);
		this.agregarPanel.add(campo_m);
		this.agregarPanel.add(agregarPrecio);
		this.agregarPanel.add(campo_p);
		this.agregarPanel.add(agregarDist);
		this.agregarPanel.add(campo_d);
		this.agregarPanel.add(agregarCantidad);
		this.agregarPanel.add(campo_c);
		this.agregarPanel.add(agregarConfirmar);
		
		//Actualizar Panel
		
		t_actualizar = new JTextArea();
		t_actualizar.setBounds(135, 10, 125, 20);
		t_actualizar.setEditable(false);
		t_actualizar.setOpaque(false);
		t_actualizar.setText("ACTUALIZAR");
		t_actualizar.setFont(new Font("Arial", Font.BOLD, 20));
		t_actualizar.setForeground(Color.BLACK);
		
		
		actualizarNombre = new JTextArea();
		actualizarNombre.setBounds(15, 40, 100, 20);
		actualizarNombre.setEditable(false);
		actualizarNombre.setOpaque(false);
		actualizarNombre.setText("Nombre:");
		actualizarNombre.setFont(new Font("Arial", Font.BOLD, 20));
		actualizarNombre.setForeground(Color.BLACK);
		
		campoE_n = new JTextField();
		campoE_n.setBounds(145, 43, 200, 20);
		campoE_n.setEditable(true);
		campoE_n.setFont(new Font("Arial", Font.BOLD, 20));
		campoE_n.setForeground(Color.BLACK);
		
		actualizarMarca = new JTextArea();
		actualizarMarca.setBounds(15, 110, 100, 20);
		actualizarMarca.setEditable(false);
		actualizarMarca.setOpaque(false);
		actualizarMarca.setText("Marca:");
		actualizarMarca.setFont(new Font("Arial", Font.BOLD, 20));
		actualizarMarca.setForeground(Color.BLACK);
		
		campoE_m = new JTextField();
		campoE_m.setBounds(145, 115, 200, 20);
		campoE_m.setEditable(true);
		campoE_m.setFont(new Font("Arial", Font.BOLD, 20));
		campoE_m.setForeground(Color.BLACK);
		
		actualizarPrecio = new JTextArea();
		actualizarPrecio.setBounds(15, 185, 100, 20);
		actualizarPrecio.setEditable(false);
		actualizarPrecio.setOpaque(false);
		actualizarPrecio.setText("Precio:");
		actualizarPrecio.setFont(new Font("Arial", Font.BOLD, 20));
		actualizarPrecio.setForeground(Color.BLACK);
		
		campoE_p = new JTextField();
		campoE_p.setBounds(145, 188, 200, 20);
		campoE_p.setEditable(true);
		campoE_p.setFont(new Font("Arial", Font.BOLD, 20));
		campoE_p.setForeground(Color.BLACK);
		
		actualizarDist = new JTextArea();
		actualizarDist.setBounds(15, 260, 120, 20);
		actualizarDist.setEditable(false);
		actualizarDist.setOpaque(false);
		actualizarDist.setText("Distribuidor:");
		actualizarDist.setFont(new Font("Arial", Font.BOLD, 20));
		actualizarDist.setForeground(Color.BLACK);
		
		campoE_d = new JTextField();
		campoE_d.setBounds(145, 263, 200, 20);
		campoE_d.setEditable(true);
		campoE_d.setFont(new Font("Arial", Font.BOLD, 20));
		campoE_d.setForeground(Color.BLACK);
		
		actualizarCantidad = new JTextArea();
		actualizarCantidad.setBounds(15, 338, 100, 20);
		actualizarCantidad.setEditable(false);
		actualizarCantidad.setOpaque(false);
		actualizarCantidad.setText("Cantidad:");
		actualizarCantidad.setFont(new Font("Arial", Font.BOLD, 20));
		actualizarCantidad.setForeground(Color.BLACK);
		
		campoE_c = new JTextField();
		campoE_c.setBounds(145, 340, 200, 20);
		campoE_c.setEditable(true);
		campoE_c.setFont(new Font("Arial", Font.BOLD, 20));
		campoE_c.setForeground(Color.BLACK);
		
		actualizarConfirmar = new JButton();
		actualizarConfirmar.setBounds(100, 380, 170, 20);
		actualizarConfirmar.setOpaque(false);
		actualizarConfirmar.setText("Confirmar");
		actualizarConfirmar.setFont(new Font("Arial", Font.BOLD, 20));
		actualizarConfirmar.setForeground(Color.BLACK);
		
		add(actualizarPanel, JLayeredPane.POPUP_LAYER);
		this.actualizarPanel.add(t_actualizar);
		this.actualizarPanel.add(actualizarNombre);
		this.actualizarPanel.add(campoE_n);
		this.actualizarPanel.add(actualizarMarca);
		this.actualizarPanel.add(campoE_m);
		this.actualizarPanel.add(actualizarPrecio);
		this.actualizarPanel.add(campoE_p);
		this.actualizarPanel.add(actualizarDist);
		this.actualizarPanel.add(campoE_d);
		this.actualizarPanel.add(actualizarCantidad);
		this.actualizarPanel.add(campoE_c);
		this.actualizarPanel.add(actualizarConfirmar);
		
		
		//Listar Panel
		
		scrollLista = new JScrollPane();
		scrollLista.setBounds(0,0,370, 410);
		
		scrolllist_panel_nombres = new JPanel();
		scrolllist_panel_nombres.setBackground(Color.DARK_GRAY);
		scrolllist_panel_nombres.setLayout(new GridLayout(10, 1));
		scrolllist_panel_nombres.setBounds(0,0,370, 410);
		
		scrollLista.setViewportView(scrolllist_panel_nombres);
		
		
		
		
		
		
		add(listarPanel, JLayeredPane.PALETTE_LAYER);
		this.listarPanel.add(scrollLista);
		
		add(eliminarPanel, JLayeredPane.MODAL_LAYER);
		
		
		
		
		add(agregar);
		add(listar);
		
		setVisible(true);
	
	}
	
	/**
	 * 
	 * Crea un objeto de la clase Material, dado unos parametros ingresados por el usuario.
	 * 
	 * @param nombre - nombre del producto, ingresado por el usuario.
	 * @param marca - marca del producto, ingresada por el usuario.
	 * @param precio - precio del producto, ingresado por el usuario.
	 * @param dist - distribuidor del producto, ingresado por el usuario.
	 * @param cant - cantidad del producto, ingresado por el usuario
	 */
	
	
	public void adicionarContenido(String nombre, String marca, double precio, String dist, int cant) {
		
		JPanel temp_panel = new JPanel();
		temp_panel.setBounds(0,0,370, 200);
		temp_panel.setLayout(null);
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		temp_panel.setBorder(blackline);
		
		JButton temp_editar = new JButton();
		temp_editar.setBounds(310, 3, 50, 15);
		temp_editar.setBackground(new Color(12, 99, 35));
		temp_editar.setForeground(Color.BLACK);
		temp_panel.add(temp_editar);
		
		JButton temp_eliminar = new JButton();
		temp_eliminar.setBounds(310, 21, 50, 15);
		temp_eliminar.setBackground(new Color(115, 11, 11));
		temp_eliminar.setForeground(Color.BLACK);
		temp_panel.add(temp_eliminar);
		
		botones_mat.add(temp_editar);
		botones_mat.add(temp_eliminar);
		
		
		JLabel indicadorEditar = new JLabel();
		indicadorEditar.setBounds(250 ,3, 50, 15);
		indicadorEditar.setText("Editar:");
		indicadorEditar.setForeground(Color.BLACK);
		temp_panel.add(indicadorEditar);
		
		
		JLabel indicadorEliminar = new JLabel();
		indicadorEliminar.setBounds(250 ,21, 50, 15);
		indicadorEliminar.setText("Eliminar:");
		indicadorEliminar.setForeground(Color.BLACK);
		temp_panel.add(indicadorEliminar);
		
		
		JLabel temp_nombre = new JLabel();
		temp_nombre.setBounds(5, 2, 250, 15);
		temp_nombre.setText(nombre);
		temp_nombre.setFont(new Font("Arial", Font.BOLD, 15));
		temp_nombre.setForeground(Color.BLACK);
		temp_panel.add(temp_nombre);
		paneles_nombre.add(temp_nombre);
		
		JLabel temp_marca = new JLabel();
		temp_marca.setBounds(5, 15, 200, 10);
		temp_marca.setText("Marca: "+marca);
		temp_marca.setFont(new Font("Arial", Font.ITALIC, 10));
		temp_marca.setForeground(Color.BLACK);
		temp_panel.add(temp_marca);
		paneles_marca.add(temp_marca);
		
		JLabel temp_precio = new JLabel();
		temp_precio.setBounds(125, 25, 200, 10);
		temp_precio.setText("Precio (COP): "+precio);
		temp_precio.setFont(new Font("Arial", Font.ITALIC, 10));
		temp_precio.setForeground(Color.BLACK);
		temp_panel.add(temp_precio);
		paneles_precio.add(temp_precio);
		
		JLabel temp_dist = new JLabel();
		temp_dist.setBounds(125, 15, 200, 10);
		temp_dist.setText("Distribuidor: "+dist);
		temp_dist.setFont(new Font("Arial", Font.ITALIC, 10));
		temp_dist.setForeground(Color.BLACK);
		temp_panel.add(temp_dist);
		paneles_dist.add(temp_dist);
		
		JLabel temp_cant = new JLabel();
		temp_cant.setBounds(5, 25, 200, 10);
		temp_cant.setText("Cantidad: "+cant);
		temp_cant.setFont(new Font("Arial", Font.ITALIC, 10));
		temp_cant.setForeground(Color.BLACK);
		temp_panel.add(temp_cant);
		paneles_cant.add(temp_cant);
		
		scrolllist_panel_nombres.add(temp_panel);
		panel_mat.add(temp_panel);
	}
	
	
	//Getters & Setters

	public JButton getAgregar() {
		return agregar;
	}

	public void setAgregar(JButton agregar) {
		this.agregar = agregar;
	}


	public JButton getListar() {
		return listar;
	}

	public void setListar(JButton listar) {
		this.listar = listar;
	}

	public JPanel getAgregarPanel() {
		return agregarPanel;
	}

	public void setAgregarPanel(JPanel agregarPanel) {
		this.agregarPanel = agregarPanel;
	}

	public JPanel getActualizarPanel() {
		return actualizarPanel;
	}

	public void setActualizarPanel(JPanel actualizarPanel) {
		this.actualizarPanel = actualizarPanel;
	}

	public JPanel getEliminarPanel() {
		return eliminarPanel;
	}

	public void setEliminarPanel(JPanel eliminarPanel) {
		this.eliminarPanel = eliminarPanel;
	}

	public JPanel getListarPanel() {
		return listarPanel;
	}

	public void setListarPanel(JPanel listarPanel) {
		this.listarPanel = listarPanel;
	}

	public JTextArea getAgregarNombre() {
		return agregarNombre;
	}

	public void setAgregarNombre(JTextArea agregarNombre) {
		this.agregarNombre = agregarNombre;
	}

	public JTextArea getAgregarMarca() {
		return agregarMarca;
	}

	public void setAgregarMarca(JTextArea agregarMarca) {
		this.agregarMarca = agregarMarca;
	}

	public JTextArea getAgregarPrecio() {
		return agregarPrecio;
	}

	public void setAgregarPrecio(JTextArea agregarPrecio) {
		this.agregarPrecio = agregarPrecio;
	}

	public JTextArea getAgregarDist() {
		return agregarDist;
	}

	public void setAgregarDist(JTextArea agregarDist) {
		this.agregarDist = agregarDist;
	}

	public JTextArea getAgregarCantidad() {
		return agregarCantidad;
	}

	public void setAgregarCantidad(JTextArea agregarCantidad) {
		this.agregarCantidad = agregarCantidad;
	}


	public JTextArea getT_agregar() {
		return t_agregar;
	}


	public void setT_agregar(JTextArea t_agregar) {
		this.t_agregar = t_agregar;
	}


	public JTextField getCampo_n() {
		return campo_n;
	}


	public void setCampo_n(JTextField campo_n) {
		this.campo_n = campo_n;
	}


	public JTextField getCampo_m() {
		return campo_m;
	}


	public void setCampo_m(JTextField campo_m) {
		this.campo_m = campo_m;
	}


	public JTextField getCampo_p() {
		return campo_p;
	}


	public void setCampo_p(JTextField campo_p) {
		this.campo_p = campo_p;
	}


	public JTextField getCampo_d() {
		return campo_d;
	}


	public void setCampo_d(JTextField campo_d) {
		this.campo_d = campo_d;
	}


	public JTextField getCampo_c() {
		return campo_c;
	}


	public void setCampo_c(JTextField campo_c) {
		this.campo_c = campo_c;
	}


	public JButton getAgregarConfirmar() {
		return agregarConfirmar;
	}


	public void setAgregarConfirmar(JButton agregarConfirmar) {
		this.agregarConfirmar = agregarConfirmar;
	}


	public JScrollPane getScrollLista() {
		return scrollLista;
	}


	public void setScrollLista(JScrollPane scrollLista) {
		this.scrollLista = scrollLista;
	}


	public ArrayList<JLabel> getNombres() {
		return nombres;
	}


	public void setNombres(ArrayList<JLabel> nombres) {
		this.nombres = nombres;
	}


	public JPanel getScrolllist_panel_nombres() {
		return scrolllist_panel_nombres;
	}


	public void setScrolllist_panel_nombres(JPanel scrolllist_panel_nombres) {
		this.scrolllist_panel_nombres = scrolllist_panel_nombres;
	}


	public JButton getTest() {
		return test;
	}


	public void setTest(JButton test) {
		this.test = test;
	}


	public JButton getTest2() {
		return test2;
	}


	public void setTest2(JButton test2) {
		this.test2 = test2;
	}




	public JTextArea getT_actualizar() {
		return t_actualizar;
	}


	public void setT_actualizar(JTextArea t_actualizar) {
		this.t_actualizar = t_actualizar;
	}


	public JTextArea getActualizarNombre() {
		return actualizarNombre;
	}


	public void setActualizarNombre(JTextArea actualizarNombre) {
		this.actualizarNombre = actualizarNombre;
	}


	public JTextArea getActualizarMarca() {
		return actualizarMarca;
	}


	public void setActualizarMarca(JTextArea actualizarMarca) {
		this.actualizarMarca = actualizarMarca;
	}


	public JTextArea getActualizarPrecio() {
		return actualizarPrecio;
	}


	public void setActualizarPrecio(JTextArea actualizarPrecio) {
		this.actualizarPrecio = actualizarPrecio;
	}


	public JTextArea getActualizarDist() {
		return actualizarDist;
	}


	public void setActualizarDist(JTextArea actualizarDist) {
		this.actualizarDist = actualizarDist;
	}


	public JTextArea getActualizarCantidad() {
		return actualizarCantidad;
	}


	public void setActualizarCantidad(JTextArea actualizarCantidad) {
		this.actualizarCantidad = actualizarCantidad;
	}


	public JTextField getCampoE_n() {
		return campoE_n;
	}


	public void setCampoE_n(JTextField campoE_n) {
		this.campoE_n = campoE_n;
	}


	public JTextField getCampoE_m() {
		return campoE_m;
	}


	public void setCampoE_m(JTextField campoE_m) {
		this.campoE_m = campoE_m;
	}


	public JTextField getCampoE_p() {
		return campoE_p;
	}


	public void setCampoE_p(JTextField campoE_p) {
		this.campoE_p = campoE_p;
	}


	public JTextField getCampoE_d() {
		return campoE_d;
	}


	public void setCampoE_d(JTextField campoE_d) {
		this.campoE_d = campoE_d;
	}


	public JTextField getCampoE_c() {
		return campoE_c;
	}


	public void setCampoE_c(JTextField campoE_c) {
		this.campoE_c = campoE_c;
	}


	public JButton getActualizarConfirmar() {
		return actualizarConfirmar;
	}


	public void setActualizarConfirmar(JButton actualizarConfirmar) {
		this.actualizarConfirmar = actualizarConfirmar;
	}


	public ArrayList<JButton> getBotones_mat() {
		return botones_mat;
	}


	public void setBotones_mat(ArrayList<JButton> botones_mat) {
		this.botones_mat = botones_mat;
	}


	public ArrayList<JPanel> getPanel_mat() {
		return panel_mat;
	}


	public void setPanel_mat(ArrayList<JPanel> panel_mat) {
		this.panel_mat = panel_mat;
	}


	public ArrayList<JLabel> getPaneles_nombre() {
		return paneles_nombre;
	}


	public void setPaneles_nombre(ArrayList<JLabel> paneles_nombre) {
		this.paneles_nombre = paneles_nombre;
	}


	public ArrayList<JLabel> getPaneles_marca() {
		return paneles_marca;
	}


	public void setPaneles_marca(ArrayList<JLabel> paneles_marca) {
		this.paneles_marca = paneles_marca;
	}


	public ArrayList<JLabel> getPaneles_precio() {
		return paneles_precio;
	}


	public void setPaneles_precio(ArrayList<JLabel> paneles_precio) {
		this.paneles_precio = paneles_precio;
	}


	public ArrayList<JLabel> getPaneles_dist() {
		return paneles_dist;
	}


	public void setPaneles_dist(ArrayList<JLabel> paneles_dist) {
		this.paneles_dist = paneles_dist;
	}


	public ArrayList<JLabel> getPaneles_cant() {
		return paneles_cant;
	}


	public void setPaneles_cant(ArrayList<JLabel> paneles_cant) {
		this.paneles_cant = paneles_cant;
	}



}
