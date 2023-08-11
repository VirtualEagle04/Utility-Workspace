package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * Clase que hereda de JFrame y que contiene todos los componentes visuales que el usuario usara para comunicarse con el programa.
 * @author Federico Vargas Rozo
 * @param fuente Fuente personalizada para usar en los componentes.
 * @param menubar La barra de los menus en la zona superior de la ventana.
 * @param mun Menu de los Viajes Municipales.
 * @param dep Menu de los Viajes Departamentales.
 * @param inter Menu de los Viajes Internacionales.
 * @param v Menu de los Todos los Viajes.
 * @param mun_crear JMenuItem para crear Viajes Municipales.
 * @param mun_del JMenuItem para eliminar Viajes Municipales.
 * @param mun_act JMenuItem para actualizar Viajes Municipales.
 * @param mun_mostrar JMenuItem para mostrar todos los Viajes Municipales.
 * @param dep_crear JMenuItem para crear Viajes Departamentales.
 * @param dep_del JMenuItem para eliminar Viajes Departamentales.
 * @param dep_act JMenuItem para actualizar Viajes Departamentales.
 * @param dep_mostrar JMenuItem para mostrar todos los Viajes Departamentales.
 * @param int_crear JMenuItem para crear Viajes Internacionales.
 * @param int_del JMenuItem para eliminar Viajes Internacionales.
 * @param int_act JMenuItem para actualizar Viajes Internacionales.
 * @param int_mostrar JMenuItem para mostrar todos los Viajes Internacionales.
 * @param v_mostrar JMenuItem para mostrar todo tipo de Viaje.
 * @param panel Panel principal donde estan todos los componentes.
 * @param confirmar_crear Boton de confirmacion para crear.
 * @param confirmar_del Boton de confirmacion para eliminar.
 * @param confirmar_act Boton de confirmacion para actualizar.
 * @param origen Campo para ingresar el Origen del Viaje.
 * @param destino Campo para ingresar el Destino del Viaje.
 * @param hora_salida Campo para ingresar la hora de salida del Viaje.
 * @param fecha_salida Campo para ingresar la fecha de salida del Viaje.
 * @param duracion Campo para ingresar la duracion del Viaje.
 * @param nombre Campo para ignresar el nombre del condutor del Viaje.
 * @param index Cmapo para ingresar la posicion del Viaje a eliminar o Actualizar.
 * @param id_origen Indicador del Origen.
 * @param id_destino Indicador del Destino.
 * @param id_hora_salida Indicador de la Hora de Salida.
 * @param id_fecha_salida Indicador de la Fecha de Salida.
 * @param id_duracion Indicador de la Duracion.
 * @param id_nombre Indicador del Nombre.
 * @param id_index Indicador del Indice.
 * @param mun_cant_peajes Campo para ingresar el numero de Peajes de los Viajes Municipales.
 * @param dep_cant_peajes Campo para ingresar el numero de Peajes de los Viajes Departamentales.
 * @param int_cant_aduanas Campo para ingresar el numero de Aduanas de los Viajes Internacionales.
 * @param id_cant_peajes Indicador del Numero de Peajes.
 * @param id_cant_aduanas Indicador del Numero de Aduanas.
 * @param output JTextArea para mostrar todos los Viajes por tipo o en General.
 * @param id_mun Indicador de los Viajes Municipales.
 * @param id_dep Indicador de los Viajes Departamentales.
 * @param id_int Indicador de los Viajes Internacionales.
 * @param id_v Indicador de Todos los Viajes.
 * @param scroll JScrollPane donde esta el JTextArea output.
 * @param err_scroll JScrollPane donde esta el JTextArea error.
 * @param error JTextArea para mostrar los errores y las excepciones.
 */
public class VentanaPrincipal extends JFrame{

	private Font fuente;
	private JMenuBar menubar;
	private JMenu mun, dep, inter, v;
	private JMenuItem mun_crear, mun_del, mun_act, mun_mostrar;
	private JMenuItem dep_crear, dep_del, dep_act, dep_mostrar;
	private JMenuItem int_crear, int_del, int_act, int_mostrar;
	private JMenuItem v_mostrar;
	
	private JPanel panel;
	private JButton confirmar_crear, confirmar_del, confirmar_act;
	private JTextField origen, destino, hora_salida, fecha_salida, duracion, nombre, index;
	private JLabel id_origen, id_destino, id_hora_salida, id_fecha_salida, id_duracion, id_nombre, id_index;
	private JTextField mun_cant_peajes;
	private JTextField dep_cant_peajes;
	private JTextField int_cant_aduanas;
	private JLabel id_cant_peajes, id_cant_aduanas;
	private JTextArea output;
	
	private JLabel id_mun, id_dep, id_int, id_v;
	private JLabel id_hora, id_fecha;
	private JScrollPane scroll, err_scroll;
	private JTextArea error;
	
	
	public VentanaPrincipal() {
		setTitle("Terminal de Transporte");
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
		//Municipal
		mun_crear = new JMenuItem("Nuevo Ticket");
		mun_crear.setFont(fuente);
		mun_crear.setFont(mun_crear.getFont().deriveFont(Font.PLAIN, 12));
		mun_del = new JMenuItem("Eliminar Ticket");
		mun_del.setFont(fuente);
		mun_del.setFont(mun_del.getFont().deriveFont(Font.PLAIN, 12));
		mun_act = new JMenuItem("Editar Ticket");
		mun_act.setFont(fuente);
		mun_act.setFont(mun_act.getFont().deriveFont(Font.PLAIN, 12));
		mun_mostrar = new JMenuItem("Mostrar todos los Tickets");
		mun_mostrar.setFont(fuente);
		mun_mostrar.setFont(mun_mostrar.getFont().deriveFont(Font.PLAIN, 12));
		//Departamental
		dep_crear = new JMenuItem("Nuevo Ticket");
		dep_crear.setFont(fuente);
		dep_crear.setFont(mun_crear.getFont().deriveFont(Font.PLAIN, 12));
		dep_del = new JMenuItem("Eliminar Ticket");
		dep_del.setFont(fuente);
		dep_del.setFont(mun_del.getFont().deriveFont(Font.PLAIN, 12));
		dep_act = new JMenuItem("Editar Ticket");
		dep_act.setFont(fuente);
		dep_act.setFont(mun_act.getFont().deriveFont(Font.PLAIN, 12));
		dep_mostrar = new JMenuItem("Mostrar todos los Tickets");
		dep_mostrar.setFont(fuente);
		dep_mostrar.setFont(mun_mostrar.getFont().deriveFont(Font.PLAIN, 12));
		//Internacional
		int_crear = new JMenuItem("Nuevo Ticket");
		int_crear.setFont(fuente);
		int_crear.setFont(mun_crear.getFont().deriveFont(Font.PLAIN, 12));
		int_del = new JMenuItem("Eliminar Ticket");
		int_del.setFont(fuente);
		int_del.setFont(mun_del.getFont().deriveFont(Font.PLAIN, 12));
		int_act = new JMenuItem("Editar Ticket");
		int_act.setFont(fuente);
		int_act.setFont(mun_act.getFont().deriveFont(Font.PLAIN, 12));
		int_mostrar = new JMenuItem("Mostrar todos los Tickets");
		int_mostrar.setFont(fuente);
		int_mostrar.setFont(mun_mostrar.getFont().deriveFont(Font.PLAIN, 12));
		
		v_mostrar = new JMenuItem("Mostrar todos los Viajes");
		v_mostrar.setFont(fuente);
		v_mostrar.setFont(v_mostrar.getFont().deriveFont(Font.PLAIN, 12));
		
		mun = new JMenu("Viajes Municipales");
		mun.setFont(fuente);
		mun.setFont(mun.getFont().deriveFont(Font.PLAIN, 11));
		mun.add(mun_crear);
		mun.add(mun_del);
		mun.add(mun_act);
		mun.add(mun_mostrar);
		
		dep = new JMenu("Viajes Departamentales");
		dep.setFont(fuente);
		dep.setFont(dep.getFont().deriveFont(Font.PLAIN, 11));
		dep.add(dep_crear);
		dep.add(dep_del);
		dep.add(dep_act);
		dep.add(dep_mostrar);
		
		inter = new JMenu("Viajes Internacionales");
		inter.setFont(fuente);
		inter.setFont(inter.getFont().deriveFont(Font.PLAIN, 11));
		inter.add(int_crear);
		inter.add(int_del);
		inter.add(int_act);
		inter.add(int_mostrar);
		
		v = new JMenu("Todos los Viajes");
		v.setFont(fuente);
		v.setFont(mun.getFont().deriveFont(Font.PLAIN, 11));
		v.add(v_mostrar);
		
		menubar = new JMenuBar();
		menubar.add(mun);
		menubar.add(dep);
		menubar.add(inter);
		menubar.add(v);
		add(menubar);
		setJMenuBar(menubar);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,600,600);
		panel.setBackground(Color.LIGHT_GRAY);
		
		//Botones Confirmar
		confirmar_crear = new JButton("Confirmar");
		confirmar_crear.setBounds(220, 330, 160, 25);
		
		confirmar_del = new JButton("Confirmar");
		confirmar_del.setBounds(220, 330, 160, 25);
		
		confirmar_act = new JButton("Confirmar");
		confirmar_act.setBounds(220, 330, 160, 25);
		
		//Campos
		origen = new JTextField();
		origen.setBounds(220, 60, 160, 25);
		
		destino = new JTextField();
		destino.setBounds(220, 90, 160, 25);
		
		hora_salida = new JTextField();
		hora_salida.setBounds(220, 120, 160, 25);
		
		fecha_salida = new JTextField();
		fecha_salida.setBounds(220, 150, 160, 25);
		
		duracion = new JTextField();
		duracion.setBounds(220, 180, 160, 25);
		
		nombre = new JTextField();
		nombre.setBounds(220, 210, 160, 25);
		
		mun_cant_peajes = new JTextField();
		mun_cant_peajes.setBounds(220, 240, 160, 25);
		
		dep_cant_peajes = new JTextField();
		dep_cant_peajes.setBounds(220, 240, 160, 25);
		
		int_cant_aduanas = new JTextField();
		int_cant_aduanas.setBounds(220, 240, 160, 25);
		
		index = new JTextField();
		index.setBounds(220, 270, 160, 25);
		
		//Indicadores
		id_origen = new JLabel("Origen: ");
		id_origen.setBounds(80, 60, 160, 25);
		
		id_destino = new JLabel("Destino: ");
		id_destino.setBounds(80, 90, 160, 25);
		
		id_hora_salida = new JLabel("Hora de Salida: ");
		id_hora_salida.setBounds(80, 120, 160, 25);
		
		id_fecha_salida = new JLabel("Fecha de Salida: ");
		id_fecha_salida.setBounds(80, 150, 160, 25);
		
		id_duracion = new JLabel("Duracion: ");
		id_duracion.setBounds(80, 180, 160, 25);
		
		id_nombre = new JLabel("Nombre del Conductor: ");
		id_nombre.setBounds(80, 210, 160, 25);
		
		id_cant_peajes = new JLabel("Numero de Peajes: ");
		id_cant_peajes.setBounds(80, 240, 160, 25);
		
		id_cant_aduanas = new JLabel("Numero de Aduanas: ");
		id_cant_aduanas.setBounds(80, 240, 160, 25);
		
		id_index = new JLabel("Numero de Ticket: ");
		id_index.setBounds(80, 270, 160, 25);
		
		id_mun = new JLabel("Viajes Municipales");
		id_mun.setBounds(240,10, 220, 25);
		
		id_dep = new JLabel("Viajes Departamentales");
		id_dep.setBounds(240, 10, 220, 25);
		
		id_int = new JLabel("Viajes Internacionales");
		id_int.setBounds(240, 10, 220, 25);
		
		id_v = new JLabel("Todos los Viajes");
		id_v.setBounds(240, 10, 220, 25);
		
		id_hora = new JLabel("Siga el formato H:mm (24 horas)");
		id_hora.setBounds(385, 120, 210, 25);
		
		id_fecha = new JLabel("Siga el formato M/d/yyyy");
		id_fecha.setBounds(385, 150, 160, 25);
		
		error = new JTextArea();
		error.setBounds(120, 370, 360, 80);
		error.setEditable(false);
		error.setFont(fuente);
		error.setFont(error.getFont().deriveFont(Font.PLAIN, 11));
		error.setBackground(Color.LIGHT_GRAY);
		error.setForeground(Color.RED);
		
		err_scroll = new JScrollPane();
		err_scroll.setBounds(120, 370, 360, 80);
		err_scroll.setViewportView(error);
		
		//Consola
		output = new JTextArea();
		output.setBounds(0, 0, 565, 410);
		output.setBackground(Color.DARK_GRAY);
		output.setEditable(false);
		output.setFont(fuente);
		output.setFont(output.getFont().deriveFont(Font.PLAIN, 15));
		output.setForeground(Color.WHITE);
		
		scroll = new JScrollPane();
		scroll.setBounds(10, 30, 565, 410);
		scroll.setViewportView(output);
		
		
		panel.add(confirmar_crear).setVisible(false);
		panel.add(confirmar_del).setVisible(false);
		panel.add(confirmar_act).setVisible(false);
		panel.add(origen).setVisible(false);
		panel.add(destino).setVisible(false);
		panel.add(hora_salida).setVisible(false);
		panel.add(fecha_salida).setVisible(false);
		panel.add(duracion).setVisible(false);
		panel.add(nombre).setVisible(false);
		panel.add(mun_cant_peajes).setVisible(false);
		panel.add(dep_cant_peajes).setVisible(false);
		panel.add(int_cant_aduanas).setVisible(false);
		panel.add(index).setVisible(false);
		panel.add(scroll).setVisible(true);
		panel.add(id_origen).setVisible(false);
		panel.add(id_destino).setVisible(false);
		panel.add(id_hora_salida).setVisible(false);
		panel.add(id_fecha_salida).setVisible(false);
		panel.add(id_duracion).setVisible(false);
		panel.add(id_nombre).setVisible(false);
		panel.add(id_cant_peajes).setVisible(false);
		panel.add(id_cant_aduanas).setVisible(false);
		panel.add(id_index).setVisible(false);
		panel.add(id_mun).setVisible(false);
		panel.add(id_dep).setVisible(false);
		panel.add(id_int).setVisible(false);
		panel.add(id_v).setVisible(true);
		panel.add(id_hora);
		panel.add(id_fecha);
		panel.add(err_scroll);
		
		
		add(panel);
		setVisible(true);
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




	public JLabel getId_hora() {
		return id_hora;
	}




	public void setId_hora(JLabel id_hora) {
		this.id_hora = id_hora;
	}




	public JLabel getId_fecha() {
		return id_fecha;
	}




	public void setId_fecha(JLabel id_fecha) {
		this.id_fecha = id_fecha;
	}




	public JMenuItem getV_mostrar() {
		return v_mostrar;
	}




	public void setV_mostrar(JMenuItem v_mostrar) {
		this.v_mostrar = v_mostrar;
	}




	public JScrollPane getScroll() {
		return scroll;
	}




	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}




	public JTextField getIndex() {
		return index;
	}


	public void setIndex(JTextField index) {
		this.index = index;
	}


	public JLabel getId_origen() {
		return id_origen;
	}


	public void setId_origen(JLabel id_origen) {
		this.id_origen = id_origen;
	}


	public JLabel getId_destino() {
		return id_destino;
	}


	public void setId_destino(JLabel id_destino) {
		this.id_destino = id_destino;
	}


	public JLabel getId_hora_salida() {
		return id_hora_salida;
	}


	public void setId_hora_salida(JLabel id_hora_salida) {
		this.id_hora_salida = id_hora_salida;
	}


	public JLabel getId_fecha_salida() {
		return id_fecha_salida;
	}


	public void setId_fecha_salida(JLabel id_fecha_salida) {
		this.id_fecha_salida = id_fecha_salida;
	}


	public JLabel getId_duracion() {
		return id_duracion;
	}


	public void setId_duracion(JLabel id_duracion) {
		this.id_duracion = id_duracion;
	}


	public JLabel getId_nombre() {
		return id_nombre;
	}


	public void setId_nombre(JLabel id_nombre) {
		this.id_nombre = id_nombre;
	}


	public JLabel getId_index() {
		return id_index;
	}


	public void setId_index(JLabel id_index) {
		this.id_index = id_index;
	}


	public JLabel getId_cant_peajes() {
		return id_cant_peajes;
	}


	public void setId_cant_peajes(JLabel id_cant_peajes) {
		this.id_cant_peajes = id_cant_peajes;
	}


	public JLabel getId_cant_aduanas() {
		return id_cant_aduanas;
	}


	public void setId_cant_aduanas(JLabel id_cant_aduanas) {
		this.id_cant_aduanas = id_cant_aduanas;
	}


	public JLabel getId_mun() {
		return id_mun;
	}


	public void setId_mun(JLabel id_mun) {
		this.id_mun = id_mun;
	}


	public JLabel getId_dep() {
		return id_dep;
	}


	public void setId_dep(JLabel id_dep) {
		this.id_dep = id_dep;
	}


	public JLabel getId_int() {
		return id_int;
	}


	public void setId_int(JLabel id_int) {
		this.id_int = id_int;
	}


	public JLabel getId_v() {
		return id_v;
	}


	public void setId_v(JLabel id_v) {
		this.id_v = id_v;
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


	public JMenu getMun() {
		return mun;
	}


	public void setMun(JMenu mun) {
		this.mun = mun;
	}


	public JMenu getDep() {
		return dep;
	}


	public void setDep(JMenu dep) {
		this.dep = dep;
	}


	public JMenu getInter() {
		return inter;
	}


	public void setInter(JMenu inter) {
		this.inter = inter;
	}


	public JMenu getV() {
		return v;
	}


	public void setV(JMenu v) {
		this.v = v;
	}


	public JMenuItem getMun_crear() {
		return mun_crear;
	}


	public void setMun_crear(JMenuItem mun_crear) {
		this.mun_crear = mun_crear;
	}


	public JMenuItem getMun_del() {
		return mun_del;
	}


	public void setMun_del(JMenuItem mun_del) {
		this.mun_del = mun_del;
	}


	public JMenuItem getMun_act() {
		return mun_act;
	}


	public void setMun_act(JMenuItem mun_act) {
		this.mun_act = mun_act;
	}


	public JMenuItem getMun_mostrar() {
		return mun_mostrar;
	}


	public void setMun_mostrar(JMenuItem mun_mostrar) {
		this.mun_mostrar = mun_mostrar;
	}


	public JMenuItem getDep_crear() {
		return dep_crear;
	}


	public void setDep_crear(JMenuItem dep_crear) {
		this.dep_crear = dep_crear;
	}


	public JMenuItem getDep_del() {
		return dep_del;
	}


	public void setDep_del(JMenuItem dep_del) {
		this.dep_del = dep_del;
	}


	public JMenuItem getDep_act() {
		return dep_act;
	}


	public void setDep_act(JMenuItem dep_act) {
		this.dep_act = dep_act;
	}


	public JMenuItem getDep_mostrar() {
		return dep_mostrar;
	}


	public void setDep_mostrar(JMenuItem dep_mostrar) {
		this.dep_mostrar = dep_mostrar;
	}


	public JMenuItem getInt_crear() {
		return int_crear;
	}


	public void setInt_crear(JMenuItem int_crear) {
		this.int_crear = int_crear;
	}


	public JMenuItem getInt_del() {
		return int_del;
	}


	public void setInt_del(JMenuItem int_del) {
		this.int_del = int_del;
	}


	public JMenuItem getInt_act() {
		return int_act;
	}


	public void setInt_act(JMenuItem int_act) {
		this.int_act = int_act;
	}


	public JMenuItem getInt_mostrar() {
		return int_mostrar;
	}


	public void setInt_mostrar(JMenuItem int_mostrar) {
		this.int_mostrar = int_mostrar;
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


	public JTextField getOrigen() {
		return origen;
	}


	public void setOrigen(JTextField origen) {
		this.origen = origen;
	}


	public JTextField getDestino() {
		return destino;
	}


	public void setDestino(JTextField destino) {
		this.destino = destino;
	}


	public JTextField getHora_salida() {
		return hora_salida;
	}


	public void setHora_salida(JTextField hora_salida) {
		this.hora_salida = hora_salida;
	}


	public JTextField getFecha_salida() {
		return fecha_salida;
	}


	public void setFecha_salida(JTextField fecha_salida) {
		this.fecha_salida = fecha_salida;
	}


	public JTextField getDuracion() {
		return duracion;
	}


	public void setDuracion(JTextField duracion) {
		this.duracion = duracion;
	}


	public JTextField getNombre() {
		return nombre;
	}


	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}


	public JTextField getMun_cant_peajes() {
		return mun_cant_peajes;
	}


	public void setMun_cant_peajes(JTextField mun_cant_peajes) {
		this.mun_cant_peajes = mun_cant_peajes;
	}


	public JTextField getDep_cant_peajes() {
		return dep_cant_peajes;
	}


	public void setDep_cant_peajes(JTextField dep_cant_peajes) {
		this.dep_cant_peajes = dep_cant_peajes;
	}


	public JTextField getInt_cant_aduanas() {
		return int_cant_aduanas;
	}


	public void setInt_cant_aduanas(JTextField int_cant_aduanas) {
		this.int_cant_aduanas = int_cant_aduanas;
	}


	public JTextArea getOutput() {
		return output;
	}


	public void setOutput(JTextArea output) {
		this.output = output;
	}
	
	
	
}
