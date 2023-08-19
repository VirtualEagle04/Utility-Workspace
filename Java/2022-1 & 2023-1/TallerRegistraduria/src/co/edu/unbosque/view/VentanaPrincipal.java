package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
/**
 * Clase que hereda de JFrame y que contiene todos los componentes visuales que el usuario usara para comunicarse con el programa.
 * @author Federico Vargas Rozo
 * @param fuente Fuente personalizada para usar en los componentes
 * @param menubar La barra de los menus en la zona superior de la ventana.
 * @param p Menu de los Padres
 * @param m Menu de las Madres
 * @param n Menu de los Neonatos
 * @param g Menu de los Ciudadanos
 * @param p_crear Apartado para crear Padres
 * @param p_del Apartado para eliminar Padres
 * @param p_act Apartado para actualizar Padres
 * @param p_mostrar Apartado para mostrar Padres
 * @param m_crear Apartado para crear Madres
 * @param m_del Apartado para eliminar Madres
 * @param m_act Apartado para actualizar Madres
 * @param m_mostrar Apartado para mostrar Madres
 * @param n_crear Apartado para crear Neonatos
 * @param n_del Apartado para eliminar Neonatos
 * @param n_act Apartado para actualizar Neonatos
 * @param g_mostrar Apartado para mostrar todos los Ciudadanos
 * @param panel Panel principal donde estan todos los componentes.
 * @param confirmar_crear Boton de confirmacion para crear.
 * @param confirmar_del Boton de confirmacion para eliminar.
 * @param confirmar_act Boton de confirmacion para actualizar.
 * @param nombre Campo para ingresar el Nombre
 * @param sexo Campo para ingresar el Sexo
 * @param ciudad Campo para ingresar la Ciudad
 * @param fecha Campo para ingresar la Fecha
 * @param index Campo para ingresar la posicion
 * @param output JTextArea para mostrar todos los Ciudadanos por tipo o en General
 * @param id_p Identificador para Padres
 * @param id_m Identificador para Madres
 * @param id_n Identificador para Neonatos
 * @param id_g Identificador para Ciudadanos
 * @param formato_fecha Identificador para el formato de la fecha
 * @param scroll JScrollPane donde esta el JTextArea output
 * @param err_scroll JScrollPane donde esta el JTextArea error
 * @param error JTextArea par amostrar los errores y las excepciones
 * @param tiene_padre JCheckBox para verificar si el Neonato tiene padre
 * @param tiene_madre JCheckBox para verificar si el Neonato tiene madre
 * @param nombre_p Campo para ingresar el nombre del padre
 * @param ciudad_p Campo para ingresar la ciudad del padre
 * @param fecha_p Campo para ingresar la fecha del padre
 * @param nombre_m Campo para ingresar el nombre de la madre
 * @param ciudad_m Campo para ingresar la ciudad de la madre
 * @param fecha_m Campo para ingresar la fecha de la madre
 * @param id_nombre_p Identificador para el nombre del padre
 * @param id_ciudad_p Identificador para la ciudad del padre
 * @param id_fecha_p Identificador para la fecha del padre
 * @param id_nombre_m Identificador para el nombre del madre
 * @param id_ciudad_m Identificador para la ciudad del madre
 * @param id_fecha_m Identificador para la fecha del madre
 *
 */
public class VentanaPrincipal extends JFrame {

	private Font fuente;
	private JMenuBar menubar;
	private JMenu p, m, n, g;
	private JMenuItem p_crear, p_del, p_act, p_mostrar;
	private JMenuItem m_crear, m_del, m_act, m_mostrar;
	private JMenuItem n_crear, n_del, n_act, n_mostrar;
	private JMenuItem g_mostrar;

	private JPanel panel;
	private JButton confirmar_crear, confirmar_del, confirmar_act;
	private JTextField nombre, sexo, ciudad, fecha, index;
	private JLabel id_nombre, id_sexo, id_ciudad, id_fecha, id_index;
	private JTextArea output;

	private JLabel id_p, id_m, id_n, id_g;
	private JLabel formato_fecha;
	private JScrollPane scroll, err_scroll;
	private JTextArea error;
	
	private JCheckBox tiene_padre, tiene_madre;
	
	private JTextField nombre_p, ciudad_p, fecha_p, nombre_m, ciudad_m, fecha_m;
	private JLabel id_nombre_p, id_ciudad_p, id_fecha_p;
	private JLabel id_nombre_m, id_ciudad_m, id_fecha_m;

	public VentanaPrincipal() {
		ImageIcon img = new ImageIcon("src/Imagenes/reg.jpg");
		setIconImage(img.getImage());
		setTitle("Registraduría Nacional del Estado Civil");
		setSize(600, 530);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		setFocusable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		try {
			fuente = Font.createFont(Font.TRUETYPE_FONT, new File("src/Font/JetBrainsMono-Medium.ttf"));
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// picipal
		p_crear = new JMenuItem("Registro Padre");
		p_crear.setFont(fuente);
		p_crear.setFont(p_crear.getFont().deriveFont(Font.PLAIN, 12));
		p_del = new JMenuItem("Eliminar Padre");
		p_del.setFont(fuente);
		p_del.setFont(p_del.getFont().deriveFont(Font.PLAIN, 12));
		p_act = new JMenuItem("Editar Padre");
		p_act.setFont(fuente);
		p_act.setFont(p_act.getFont().deriveFont(Font.PLAIN, 12));
		p_mostrar = new JMenuItem("Mostrar todos los Padres");
		p_mostrar.setFont(fuente);
		p_mostrar.setFont(p_mostrar.getFont().deriveFont(Font.PLAIN, 12));
		// martamental
		m_crear = new JMenuItem("Registro Madre");
		m_crear.setFont(fuente);
		m_crear.setFont(p_crear.getFont().deriveFont(Font.PLAIN, 12));
		m_del = new JMenuItem("Eliminar Madre");
		m_del.setFont(fuente);
		m_del.setFont(p_del.getFont().deriveFont(Font.PLAIN, 12));
		m_act = new JMenuItem("Editar Madre");
		m_act.setFont(fuente);
		m_act.setFont(p_act.getFont().deriveFont(Font.PLAIN, 12));
		m_mostrar = new JMenuItem("Mostrar todas las Madres");
		m_mostrar.setFont(fuente);
		m_mostrar.setFont(p_mostrar.getFont().deriveFont(Font.PLAIN, 12));
		// nnacional
		n_crear = new JMenuItem("Registro Neonato");
		n_crear.setFont(fuente);
		n_crear.setFont(p_crear.getFont().deriveFont(Font.PLAIN, 12));
		n_del = new JMenuItem("Eliminar Neonato");
		n_del.setFont(fuente);
		n_del.setFont(p_del.getFont().deriveFont(Font.PLAIN, 12));
		n_act = new JMenuItem("Editar Neonato");
		n_act.setFont(fuente);
		n_act.setFont(p_act.getFont().deriveFont(Font.PLAIN, 12));
		n_mostrar = new JMenuItem("Mostrar todos los Neonatos");
		n_mostrar.setFont(fuente);
		n_mostrar.setFont(p_mostrar.getFont().deriveFont(Font.PLAIN, 12));

		g_mostrar = new JMenuItem("Listado de Ciudadanos");
		g_mostrar.setFont(fuente);
		g_mostrar.setFont(g_mostrar.getFont().deriveFont(Font.PLAIN, 12));

		p = new JMenu("Padres");
		p.setFont(fuente);
		p.setFont(p.getFont().deriveFont(Font.PLAIN, 11));
		p.add(p_crear);
		p.add(p_del);
		p.add(p_act);
		p.add(p_mostrar);

		m = new JMenu("Madres");
		m.setFont(fuente);
		m.setFont(m.getFont().deriveFont(Font.PLAIN, 11));
		m.add(m_crear);
		m.add(m_del);
		m.add(m_act);
		m.add(m_mostrar);

		n = new JMenu("Neonatos");
		n.setFont(fuente);
		n.setFont(n.getFont().deriveFont(Font.PLAIN, 11));
		n.add(n_crear);
		n.add(n_del);
		n.add(n_act);
		n.add(n_mostrar);

		g = new JMenu("Ciudadanos");
		g.setFont(fuente);
		g.setFont(p.getFont().deriveFont(Font.PLAIN, 11));
		g.add(g_mostrar);

		menubar = new JMenuBar();
		menubar.add(p);
		menubar.add(m);
		menubar.add(n);
		menubar.add(g);
		add(menubar);
		setJMenuBar(menubar);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 600, 600);
		panel.setBackground(new Color(238, 249, 253));

		// Botones Confirmar
		confirmar_crear = new JButton("Confirmar");
		confirmar_crear.setBounds(220, 330, 160, 25);

		confirmar_del = new JButton("Confirmar");
		confirmar_del.setBounds(220, 330, 160, 25);

		confirmar_act = new JButton("Confirmar");
		confirmar_act.setBounds(220, 330, 160, 25);

		// Campos
		nombre = new JTextField();
		nombre.setBounds(220, 40, 160, 25);

		sexo = new JTextField();
		sexo.setBounds(220, 70, 160, 25);

		ciudad = new JTextField();
		ciudad.setBounds(220, 100, 160, 25);

		fecha = new JTextField();
		fecha.setBounds(220, 130, 160, 25);

		index = new JTextField();
		index.setBounds(220, 160, 160, 25);
		
		tiene_padre = new JCheckBox("Tiene Padre", false);
		tiene_padre.setBounds(70, 190, 160, 25);
		tiene_padre.setBackground(Color.LIGHT_GRAY);
			
			nombre_p = new JTextField();
			nombre_p.setBounds(100, 220, 160, 25);
			nombre_p.setEditable(false);
			id_nombre_p = new JLabel("Nombre: ");
			id_nombre_p.setBounds(20, 220, 120, 25);
			
			ciudad_p = new JTextField();
			ciudad_p.setBounds(100, 250, 160, 25);
			ciudad_p.setEditable(false);
			id_ciudad_p = new JLabel("Ciudad: ");
			id_ciudad_p.setBounds(20, 250, 120, 25);
			
			fecha_p = new JTextField();
			fecha_p.setBounds(100, 280, 160, 25);
			fecha_p.setEditable(false);
			id_fecha_p = new JLabel("Fecha: ");
			id_fecha_p.setBounds(20, 280, 120, 25);
		
		tiene_madre = new JCheckBox("Tiene Madre", false);
		tiene_madre.setBounds(395, 190, 160, 25);
		tiene_madre.setBackground(Color.LIGHT_GRAY);
		
			nombre_m = new JTextField();
			nombre_m.setBounds(400, 220, 160, 25);
			nombre_m.setEditable(false);
			id_nombre_m = new JLabel("Nombre: ");
			id_nombre_m.setBounds(320, 220, 120, 25);
			
			ciudad_m = new JTextField();
			ciudad_m.setBounds(400, 250, 160, 25);
			ciudad_m.setEditable(false);
			id_ciudad_m = new JLabel("Ciudad: ");
			id_ciudad_m.setBounds(320, 250, 120, 25);
			
			fecha_m = new JTextField();
			fecha_m.setBounds(400, 280, 160, 25);
			fecha_m.setEditable(false);
			id_fecha_m = new JLabel("Fecha: ");
			id_fecha_m.setBounds(320, 280, 120, 25);

		// Indicadores
		id_nombre = new JLabel("Nombre: ");
		id_nombre.setBounds(80, 40, 160, 25);

		id_sexo = new JLabel("Sexo: ");
		id_sexo.setBounds(80, 70, 160, 25);

		id_ciudad = new JLabel("Ciudad de Nacimiento: ");
		id_ciudad.setBounds(80, 100, 160, 25);

		id_fecha = new JLabel("Fecha de Nacimiento: ");
		id_fecha.setBounds(80, 130, 160, 25);
		
		formato_fecha = new JLabel("Formato MM/dd/yyyy");
		formato_fecha.setBounds(385, 130, 160, 25);

		id_index = new JLabel("No° de ID: ");
		id_index.setBounds(80, 160, 160, 25);

		id_p = new JLabel("Padres");
		id_p.setBounds(270, 10, 220, 25);

		id_m = new JLabel("Madres");
		id_m.setBounds(270, 10, 220, 25);

		id_n = new JLabel("Neonatos");
		id_n.setBounds(270, 10, 220, 25);

		id_g = new JLabel("Ciudadanos");
		id_g.setBounds(260, 10, 220, 25);



		error = new JTextArea();
		error.setBounds(45, 370, 500, 80);
		error.setEditable(false);
		error.setFont(fuente);
		error.setFont(error.getFont().deriveFont(Font.PLAIN, 11));
		error.setBackground(Color.LIGHT_GRAY);
		error.setForeground(Color.RED);

		err_scroll = new JScrollPane();
		err_scroll.setBounds(45, 370, 500, 80);
		err_scroll.setViewportView(error);

		// Consola
		output = new JTextArea();
		output.setBounds(0, 0, 565, 410);
		output.setBackground(new Color(212, 212, 211));
		output.setEditable(false);
		output.setFont(fuente);
		output.setFont(output.getFont().deriveFont(Font.PLAIN, 15));
		output.setForeground(Color.BLACK);

		scroll = new JScrollPane();
		scroll.setBounds(10, 30, 565, 410);
		scroll.setViewportView(output);
		scroll.setBorder(BorderFactory.createLoweredBevelBorder());

		panel.add(confirmar_crear).setVisible(false);
		panel.add(confirmar_del).setVisible(false);
		panel.add(confirmar_act).setVisible(false);
		panel.add(nombre).setVisible(false);
		panel.add(sexo).setVisible(false);
		panel.add(ciudad).setVisible(false);
		panel.add(fecha).setVisible(false);
		panel.add(index).setVisible(false);
		panel.add(scroll).setVisible(true);
		panel.add(id_nombre).setVisible(false);
		panel.add(id_sexo).setVisible(false);
		panel.add(id_ciudad).setVisible(false);
		panel.add(id_fecha).setVisible(false);
		panel.add(formato_fecha).setVisible(false);
		panel.add(id_index).setVisible(false);
		panel.add(id_p).setVisible(false);
		panel.add(id_m).setVisible(false);
		panel.add(id_n).setVisible(false);
		panel.add(id_g).setVisible(true);
		panel.add(err_scroll).setVisible(false);
		panel.add(tiene_padre).setVisible(false);
		panel.add(tiene_madre).setVisible(false);
		panel.add(nombre_p).setVisible(false);
		panel.add(id_nombre_p).setVisible(false);
		panel.add(ciudad_p).setVisible(false);
		panel.add(id_ciudad_p).setVisible(false);
		panel.add(fecha_p).setVisible(false);
		panel.add(id_fecha_p).setVisible(false);
		panel.add(nombre_m).setVisible(false);
		panel.add(id_nombre_m).setVisible(false);
		panel.add(ciudad_m).setVisible(false);
		panel.add(id_ciudad_m).setVisible(false);
		panel.add(fecha_m).setVisible(false);
		panel.add(id_fecha_m).setVisible(false);

		add(panel);
		setVisible(true);
	}

	public JTextField getNombre_p() {
		return nombre_p;
	}

	public void setNombre_p(JTextField nombre_p) {
		this.nombre_p = nombre_p;
	}

	public JTextField getCiudad_p() {
		return ciudad_p;
	}

	public void setCiudad_p(JTextField ciudad_p) {
		this.ciudad_p = ciudad_p;
	}

	public JTextField getFecha_p() {
		return fecha_p;
	}

	public void setFecha_p(JTextField fecha_p) {
		this.fecha_p = fecha_p;
	}

	public JTextField getNombre_m() {
		return nombre_m;
	}

	public void setNombre_m(JTextField nombre_m) {
		this.nombre_m = nombre_m;
	}

	public JTextField getCiudad_m() {
		return ciudad_m;
	}

	public void setCiudad_m(JTextField ciudad_m) {
		this.ciudad_m = ciudad_m;
	}

	public JTextField getFecha_m() {
		return fecha_m;
	}

	public void setFecha_m(JTextField fecha_m) {
		this.fecha_m = fecha_m;
	}

	public JLabel getId_nombre_p() {
		return id_nombre_p;
	}

	public void setId_nombre_p(JLabel id_nombre_p) {
		this.id_nombre_p = id_nombre_p;
	}

	public JLabel getId_ciudad_p() {
		return id_ciudad_p;
	}

	public void setId_ciudad_p(JLabel id_ciudad_p) {
		this.id_ciudad_p = id_ciudad_p;
	}

	public JLabel getId_fecha_p() {
		return id_fecha_p;
	}

	public void setId_fecha_p(JLabel id_fecha_p) {
		this.id_fecha_p = id_fecha_p;
	}

	public JLabel getId_nombre_m() {
		return id_nombre_m;
	}

	public void setId_nombre_m(JLabel id_nombre_m) {
		this.id_nombre_m = id_nombre_m;
	}

	public JLabel getId_ciudad_m() {
		return id_ciudad_m;
	}

	public void setId_ciudad_m(JLabel id_ciudad_m) {
		this.id_ciudad_m = id_ciudad_m;
	}

	public JLabel getId_fecha_m() {
		return id_fecha_m;
	}

	public void setId_fecha_m(JLabel id_fecha_m) {
		this.id_fecha_m = id_fecha_m;
	}

	public JCheckBox getTiene_padre() {
		return tiene_padre;
	}

	public void setTiene_padre(JCheckBox tiene_padre) {
		this.tiene_padre = tiene_padre;
	}

	public JCheckBox getTiene_madre() {
		return tiene_madre;
	}

	public void setTiene_madre(JCheckBox tiene_madre) {
		this.tiene_madre = tiene_madre;
	}

	public Font getFuente() {
		return fuente;
	}

	public void setFuente(Font fuente) {
		this.fuente = fuente;
	}

	public JMenuBar getMenubar() {
		return menubar;
	}

	public void setMenubar(JMenuBar menubar) {
		this.menubar = menubar;
	}

	public JMenu getP() {
		return p;
	}

	public void setP(JMenu p) {
		this.p = p;
	}

	public JMenu getM() {
		return m;
	}

	public void setM(JMenu m) {
		this.m = m;
	}

	public JMenu getN() {
		return n;
	}

	public void setN(JMenu n) {
		this.n = n;
	}

	public JMenu getG() {
		return g;
	}

	public void setG(JMenu g) {
		this.g = g;
	}

	public JMenuItem getP_crear() {
		return p_crear;
	}

	public void setP_crear(JMenuItem p_crear) {
		this.p_crear = p_crear;
	}

	public JMenuItem getP_del() {
		return p_del;
	}

	public void setP_del(JMenuItem p_del) {
		this.p_del = p_del;
	}

	public JMenuItem getP_act() {
		return p_act;
	}

	public void setP_act(JMenuItem p_act) {
		this.p_act = p_act;
	}

	public JMenuItem getP_mostrar() {
		return p_mostrar;
	}

	public void setP_mostrar(JMenuItem p_mostrar) {
		this.p_mostrar = p_mostrar;
	}

	public JMenuItem getM_crear() {
		return m_crear;
	}

	public void setM_crear(JMenuItem m_crear) {
		this.m_crear = m_crear;
	}

	public JMenuItem getM_del() {
		return m_del;
	}

	public void setM_del(JMenuItem m_del) {
		this.m_del = m_del;
	}

	public JMenuItem getM_act() {
		return m_act;
	}

	public void setM_act(JMenuItem m_act) {
		this.m_act = m_act;
	}

	public JMenuItem getM_mostrar() {
		return m_mostrar;
	}

	public void setM_mostrar(JMenuItem m_mostrar) {
		this.m_mostrar = m_mostrar;
	}

	public JMenuItem getN_crear() {
		return n_crear;
	}

	public void setN_crear(JMenuItem n_crear) {
		this.n_crear = n_crear;
	}

	public JMenuItem getN_del() {
		return n_del;
	}

	public void setN_del(JMenuItem n_del) {
		this.n_del = n_del;
	}

	public JMenuItem getN_act() {
		return n_act;
	}

	public void setN_act(JMenuItem n_act) {
		this.n_act = n_act;
	}

	public JMenuItem getN_mostrar() {
		return n_mostrar;
	}

	public void setN_mostrar(JMenuItem n_mostrar) {
		this.n_mostrar = n_mostrar;
	}

	public JMenuItem getG_mostrar() {
		return g_mostrar;
	}

	public void setG_mostrar(JMenuItem g_mostrar) {
		this.g_mostrar = g_mostrar;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JButton getConfirmar_crear() {
		return confirmar_crear;
	}

	public void setConfirmar_crear(JButton confirmar_crear) {
		this.confirmar_crear = confirmar_crear;
	}

	public JButton getConfirmar_del() {
		return confirmar_del;
	}

	public void setConfirmar_del(JButton confirmar_del) {
		this.confirmar_del = confirmar_del;
	}

	public JButton getConfirmar_act() {
		return confirmar_act;
	}

	public void setConfirmar_act(JButton confirmar_act) {
		this.confirmar_act = confirmar_act;
	}

	public JTextField getNombre() {
		return nombre;
	}

	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	public JTextField getSexo() {
		return sexo;
	}

	public void setSexo(JTextField sexo) {
		this.sexo = sexo;
	}

	public JTextField getCiudad() {
		return ciudad;
	}

	public void setCiudad(JTextField ciudad) {
		this.ciudad = ciudad;
	}

	public JTextField getFecha() {
		return fecha;
	}

	public void setFecha(JTextField fecha) {
		this.fecha = fecha;
	}

	public JTextField getIndex() {
		return index;
	}

	public void setIndex(JTextField index) {
		this.index = index;
	}

	public JLabel getId_nombre() {
		return id_nombre;
	}

	public void setId_nombre(JLabel id_nombre) {
		this.id_nombre = id_nombre;
	}

	public JLabel getId_sexo() {
		return id_sexo;
	}

	public void setId_sexo(JLabel id_sexo) {
		this.id_sexo = id_sexo;
	}

	public JLabel getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(JLabel id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	public JLabel getId_fecha() {
		return id_fecha;
	}

	public void setId_fecha(JLabel id_fecha) {
		this.id_fecha = id_fecha;
	}

	public JLabel getId_index() {
		return id_index;
	}

	public void setId_index(JLabel id_index) {
		this.id_index = id_index;
	}

	public JTextArea getOutput() {
		return output;
	}

	public void setOutput(JTextArea output) {
		this.output = output;
	}

	public JLabel getId_p() {
		return id_p;
	}

	public void setId_p(JLabel id_p) {
		this.id_p = id_p;
	}

	public JLabel getId_m() {
		return id_m;
	}

	public void setId_m(JLabel id_m) {
		this.id_m = id_m;
	}

	public JLabel getId_n() {
		return id_n;
	}

	public void setId_n(JLabel id_n) {
		this.id_n = id_n;
	}

	public JLabel getId_g() {
		return id_g;
	}

	public void setId_g(JLabel id_g) {
		this.id_g = id_g;
	}

	public JLabel getFormato_fecha() {
		return formato_fecha;
	}

	public void setFormato_fecha(JLabel formato_fecha) {
		this.formato_fecha = formato_fecha;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JScrollPane getErr_scroll() {
		return err_scroll;
	}

	public void setErr_scroll(JScrollPane err_scroll) {
		this.err_scroll = err_scroll;
	}

	public JTextArea getError() {
		return error;
	}

	public void setError(JTextArea error) {
		this.error = error;
	}

}
