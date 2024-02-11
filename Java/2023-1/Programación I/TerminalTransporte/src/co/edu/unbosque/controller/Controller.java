package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.ViajeDAO;
import co.edu.unbosque.model.ViajeDepartamentalDAO;
import co.edu.unbosque.model.ViajeInternacionalDAO;
import co.edu.unbosque.model.ViajeInternacionalDTO;
import co.edu.unbosque.model.ViajeMunicipalDAO;
import co.edu.unbosque.model.ViajeMunicipalDTO;
import co.edu.unbosque.util.InputContainsInvalidCharactersException;
import co.edu.unbosque.util.InputDateInvalidException;
import co.edu.unbosque.util.InputHoursInvalidException;
import co.edu.unbosque.util.InputWrongFormatException;
import co.edu.unbosque.model.ViajeDepartamentalDTO;
import co.edu.unbosque.view.Consola;
import co.edu.unbosque.view.ErrorStreamRedirector;
import co.edu.unbosque.view.VentanaPrincipal;

/**
 * Establece la lógica entre la interfaz de usuario y las representaciones planteadas en el modelo.
 * @author Federico Vargas Rozo
 * @param vdao Objeto de la clase ViajeDAO.
 * @param vmdao Objeto de la clase ViajeMunicipalDAO.
 * @param vddao Objeto de la clase ViajeDepartamentalDAO.
 * @param vidao Objeto de la clase ViajeInternacionalDAO.
 * @param vp Objeto de la clase VentanaPrincipal.
 * @param con Objeto de la clase Consola.
 * @param error_stream Objeto de la clase ErrorStreamRedirector.
 * @param validacion Booleano que permite o no la creacion, o actualizacion si todos los valores son validos.
 * @param origen Variable temporal que almacena el Origen del viaje.
 * @param destino Variable temporal que almacena el Destino del viaje.
 * @param hora_salida Variable temporal que almacena la hora de salida del viaje.
 * @param fecha_salida Variable temporal que almacena la fecha de salida del viaje.
 * @param duracion Variable temporal que almacena la duracion en horas del viaje.
 * @param nombre_c Variable temporal que almacena el nombre del conductor del viaje.
 * @param cant Variable temporal que almancena el numero de peajes o aduanas.
 * @param index Variable temporal que almancena el indice del ViajeDTO a actualizar.
 */

public class Controller implements ActionListener {

	private ViajeDAO vdao;
	private ViajeMunicipalDAO vmdao;
	private ViajeDepartamentalDAO vddao;
	private ViajeInternacionalDAO vidao;
	private VentanaPrincipal vp;
	private Consola con;
	private ErrorStreamRedirector error_stream;
	private boolean validacion;
	private String origen;
	private String destino;
	private String[] hora_salida;
	private int[] fecha_salida;
	private float duracion;
	private String nombre_c;
	private int cant;
	private int index;

	public Controller() {
		vdao = new ViajeDAO();
		vmdao = new ViajeMunicipalDAO();
		vddao = new ViajeDepartamentalDAO();
		vidao = new ViajeInternacionalDAO();
		con = new Consola();
		validacion = true;
	}
	/**
	 * Funcion para inicializar atributos, lectores, variables y añadir todos los Pokemones a las respectivas listas.
	 */
	public void run() {
		vp = new VentanaPrincipal();
		agregarLectores();
		error_stream = new ErrorStreamRedirector(vp.getError());
	}
	/**
	 * Se crean los lectores para que todo JButton, JTextField y JList, permitan la lectura.
	 */
	public void agregarLectores() {
		vp.getConfirmar_crear().addActionListener(this);
		vp.getConfirmar_crear().setActionCommand("Creacion");

		vp.getConfirmar_del().addActionListener(this);
		vp.getConfirmar_del().setActionCommand("Eliminacion");

		vp.getConfirmar_act().addActionListener(this);
		vp.getConfirmar_act().setActionCommand("Actualizacion");

		// Menus
		// Municipal
		vp.getMun_crear().addActionListener(this);
		vp.getMun_crear().setActionCommand("Mun_crear");

		vp.getMun_del().addActionListener(this);
		vp.getMun_del().setActionCommand("Mun_del");

		vp.getMun_act().addActionListener(this);
		vp.getMun_act().setActionCommand("Mun_act");

		vp.getMun_mostrar().addActionListener(this);
		vp.getMun_mostrar().setActionCommand("Mun_mostrar");
		// Departamental
		vp.getDep_crear().addActionListener(this);
		vp.getDep_crear().setActionCommand("Dep_crear");

		vp.getDep_del().addActionListener(this);
		vp.getDep_del().setActionCommand("Dep_del");

		vp.getDep_act().addActionListener(this);
		vp.getDep_act().setActionCommand("Dep_act");

		vp.getDep_mostrar().addActionListener(this);
		vp.getDep_mostrar().setActionCommand("Dep_mostrar");
		// Internacional
		vp.getInt_crear().addActionListener(this);
		vp.getInt_crear().setActionCommand("Int_crear");

		vp.getInt_del().addActionListener(this);
		vp.getInt_del().setActionCommand("Int_del");

		vp.getInt_act().addActionListener(this);
		vp.getInt_act().setActionCommand("Int_act");

		vp.getInt_mostrar().addActionListener(this);
		vp.getInt_mostrar().setActionCommand("Int_mostrar");
		// Viajes
		vp.getV_mostrar().addActionListener(this);
		vp.getV_mostrar().setActionCommand("V_mostrar");
	}
	/**
	 * Se llama cuando se presiona un JButton previamente inicializado.
	 * Establece los comandos y la funcionalidad de cada elemento interactivo.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Creacion": {
			try {
				//Municipal
				if (vp.getId_mun().isVisible()) {
					origen = con.leerLineaEntera(vp.getOrigen().getText());
					destino = con.leerLineaEntera(vp.getDestino().getText());
					hora_salida = con.leerHora(vp.getHora_salida().getText());
					fecha_salida = con.leerFecha(vp.getFecha_salida().getText());
					duracion = con.leerFlotante(vp.getDuracion().getText());
					nombre_c = con.leerLineaEntera(vp.getNombre().getText());
					cant = con.leerEntero(vp.getMun_cant_peajes().getText());
					validacion = true;
					if (validacion) {
						vmdao.crear(new ViajeMunicipalDTO(origen, destino, hora_salida, fecha_salida, duracion,
								nombre_c, cant));
						con.imprimirErrorSalto("Nuevo ticket creado con exito.\nRevise el apartado de Mostrar");
						vp.getOrigen().setText("");
						vp.getDestino().setText("");
						vp.getHora_salida().setText("");
						vp.getFecha_salida().setText("");
						vp.getDuracion().setText("");
						vp.getNombre().setText("");
						vp.getMun_cant_peajes().setText("");
					}
					//Departamental
				} else if (vp.getId_dep().isVisible()) {
					origen = con.leerLineaEntera(vp.getOrigen().getText());
					destino = con.leerLineaEntera(vp.getDestino().getText());
					hora_salida = con.leerHora(vp.getHora_salida().getText());
					fecha_salida = con.leerFecha(vp.getFecha_salida().getText());
					duracion = con.leerFlotante(vp.getDuracion().getText());
					nombre_c = con.leerLineaEntera(vp.getNombre().getText());
					cant = con.leerEntero(vp.getDep_cant_peajes().getText());
					validacion = true;
					if (validacion) {
						vddao.crear(new ViajeDepartamentalDTO(origen, destino, hora_salida, fecha_salida, duracion,
								nombre_c, cant));
						con.imprimirErrorSalto("Nuevo ticket creado con exito.\nRevise el apartado de Mostrar");
						vp.getOrigen().setText("");
						vp.getDestino().setText("");
						vp.getHora_salida().setText("");
						vp.getFecha_salida().setText("");
						vp.getDuracion().setText("");
						vp.getNombre().setText("");
						vp.getDep_cant_peajes().setText("");
					}
					//Internacional
				} else if (vp.getId_int().isVisible()) {
					origen = con.leerLineaEntera(vp.getOrigen().getText());
					destino = con.leerLineaEntera(vp.getDestino().getText());
					hora_salida = con.leerHora(vp.getHora_salida().getText());
					fecha_salida = con.leerFecha(vp.getFecha_salida().getText());
					duracion = con.leerFlotante(vp.getDuracion().getText());
					nombre_c = con.leerLineaEntera(vp.getNombre().getText());
					cant = con.leerEntero(vp.getInt_cant_aduanas().getText());
					validacion = true;
					if (validacion) {
						vidao.crear(new ViajeInternacionalDTO(origen, destino, hora_salida, fecha_salida, duracion,
								nombre_c, cant));
						con.imprimirErrorSalto("Nuevo ticket creado con exito.\nRevise el apartado de Mostrar");
						vp.getOrigen().setText("");
						vp.getDestino().setText("");
						vp.getHora_salida().setText("");
						vp.getFecha_salida().setText("");
						vp.getDuracion().setText("");
						vp.getNombre().setText("");
						vp.getInt_cant_aduanas().setText("");
					}
				}
			} catch (InputContainsInvalidCharactersException e1) {
				con.imprimirErrorSalto(e1.getMessage());
				con.imprimirErrorSalto("Vuelva a intentarlo.");
				validacion = false;
			} catch (InputHoursInvalidException e2) {
				con.imprimirErrorSalto(e2.getMessage());
				con.imprimirErrorSalto("Vuelva a intentarlo.");
				validacion = false;
			} catch (InputWrongFormatException e3) {
				con.imprimirErrorSalto(e3.getMessage());
				con.imprimirErrorSalto("Vuelva a intentarlo.");
				validacion = false;
			} catch (InputDateInvalidException e4) {
				con.imprimirErrorSalto(e4.getMessage());
				con.imprimirErrorSalto("Vuelva a intentarlo.");
			}
			break;
		}
		case "Eliminacion": {
			try {
				if (vp.getId_mun().isVisible()) {
					int index = con.leerEntero(vp.getIndex().getText());
					if (vmdao.eliminar(index)) {
						con.imprimirErrorSalto("Ticket eliminado correctamente.");
					} else {
						con.imprimirErrorSalto("El ticket No°" + index + " no existe.");
					}
				} else if (vp.getId_dep().isVisible()) {
					int index = con.leerEntero(vp.getIndex().getText());
					if (vddao.eliminar(index)) {
						con.imprimirErrorSalto("Ticket eliminado correctamente.");
					} else {
						con.imprimirErrorSalto("El ticket No°" + index + " no existe.");
					}
				} else if (vp.getId_int().isVisible()) {
					int index = con.leerEntero(vp.getIndex().getText());
					if (vidao.eliminar(index)) {
						con.imprimirErrorSalto("Ticket eliminado correctamente.");
					} else {
						con.imprimirErrorSalto("El ticket No°" + index + " no existe.");
					}
				}
			} catch (InputWrongFormatException e1) {
				con.imprimirErrorSalto(e1.getMessage());
				con.imprimirErrorSalto("Vuelva a intentarlo.");
			}
			break;
		}
		case "Actualizacion": {
			try {
				//Municipal
				if (vp.getId_mun().isVisible()) {
					origen = con.leerLineaEntera(vp.getOrigen().getText());
					destino = con.leerLineaEntera(vp.getDestino().getText());
					hora_salida = con.leerHora(vp.getHora_salida().getText());
					fecha_salida = con.leerFecha(vp.getFecha_salida().getText());
					duracion = con.leerFlotante(vp.getDuracion().getText());
					nombre_c = con.leerLineaEntera(vp.getNombre().getText());
					cant = con.leerEntero(vp.getMun_cant_peajes().getText());
					index = con.leerEntero(vp.getIndex().getText());
					validacion = true;
					if (validacion) {
						vmdao.actualizar(index, new ViajeMunicipalDTO(origen, destino, hora_salida, fecha_salida, duracion,nombre_c, cant));
						con.imprimirErrorSalto("Nuevo ticket creado con exito.\nRevise el apartado de Mostrar");
						vp.getOrigen().setText("");
						vp.getDestino().setText("");
						vp.getHora_salida().setText("");
						vp.getFecha_salida().setText("");
						vp.getDuracion().setText("");
						vp.getNombre().setText("");
						vp.getMun_cant_peajes().setText("");
					}
					//Departamental
				} else if (vp.getId_dep().isVisible()) {
					origen = con.leerLineaEntera(vp.getOrigen().getText());
					destino = con.leerLineaEntera(vp.getDestino().getText());
					hora_salida = con.leerHora(vp.getHora_salida().getText());
					fecha_salida = con.leerFecha(vp.getFecha_salida().getText());
					duracion = con.leerFlotante(vp.getDuracion().getText());
					nombre_c = con.leerLineaEntera(vp.getNombre().getText());
					cant = con.leerEntero(vp.getDep_cant_peajes().getText());
					index = con.leerEntero(vp.getIndex().getText());
					validacion = true;
					if (validacion) {
						vddao.actualizar(index, new ViajeDepartamentalDTO(origen, destino, hora_salida, fecha_salida, duracion,nombre_c, cant));
						con.imprimirErrorSalto("Nuevo ticket creado con exito.\nRevise el apartado de Mostrar");
						vp.getOrigen().setText("");
						vp.getDestino().setText("");
						vp.getHora_salida().setText("");
						vp.getFecha_salida().setText("");
						vp.getDuracion().setText("");
						vp.getNombre().setText("");
						vp.getDep_cant_peajes().setText("");
					}
					//Internacional
				} else if (vp.getId_int().isVisible()) {
					origen = con.leerLineaEntera(vp.getOrigen().getText());
					destino = con.leerLineaEntera(vp.getDestino().getText());
					hora_salida = con.leerHora(vp.getHora_salida().getText());
					fecha_salida = con.leerFecha(vp.getFecha_salida().getText());
					duracion = con.leerFlotante(vp.getDuracion().getText());
					nombre_c = con.leerLineaEntera(vp.getNombre().getText());
					cant = con.leerEntero(vp.getInt_cant_aduanas().getText());
					index = con.leerEntero(vp.getIndex().getText());
					validacion = true;
					if (validacion) {
						vidao.actualizar(index, new ViajeInternacionalDTO(origen, destino, hora_salida, fecha_salida, duracion,nombre_c, cant));
						con.imprimirErrorSalto("Nuevo ticket creado con exito.\nRevise el apartado de Mostrar");
						vp.getOrigen().setText("");
						vp.getDestino().setText("");
						vp.getHora_salida().setText("");
						vp.getFecha_salida().setText("");
						vp.getDuracion().setText("");
						vp.getNombre().setText("");
						vp.getInt_cant_aduanas().setText("");
					}
				}
			} catch (InputContainsInvalidCharactersException e1) {
				con.imprimirErrorSalto(e1.getMessage());
				con.imprimirErrorSalto("Vuelva a intentarlo.");
				validacion = false;
			} catch (InputHoursInvalidException e2) {
				con.imprimirErrorSalto(e2.getMessage());
				con.imprimirErrorSalto("Vuelva a intentarlo.");
				validacion = false;
			} catch (InputWrongFormatException e3) {
				con.imprimirErrorSalto(e3.getMessage());
				con.imprimirErrorSalto("Vuelva a intentarlo.");
				validacion = false;
			} catch (InputDateInvalidException e4) {
				con.imprimirErrorSalto(e4.getMessage());
				con.imprimirErrorSalto("Vuelva a intentarlo.");
			}
			break;
		}
		case "Mun_crear": {
			vp.getConfirmar_crear().setVisible(true);
			vp.getOrigen().setVisible(true);
			vp.getDestino().setVisible(true);
			vp.getHora_salida().setVisible(true);
			vp.getFecha_salida().setVisible(true);
			vp.getDuracion().setVisible(true);
			vp.getNombre().setVisible(true);
			vp.getMun_cant_peajes().setVisible(true);
			vp.getId_origen().setVisible(true);
			vp.getId_destino().setVisible(true);
			vp.getId_hora_salida().setVisible(true);
			vp.getId_fecha_salida().setVisible(true);
			vp.getId_duracion().setVisible(true);
			vp.getId_nombre().setVisible(true);
			vp.getId_cant_peajes().setVisible(true);
			vp.getId_mun().setVisible(true);
			vp.getId_dep().setVisible(false);
			vp.getId_int().setVisible(false);
			vp.getId_v().setVisible(false);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(false);
			vp.getDep_cant_peajes().setVisible(false);
			vp.getInt_cant_aduanas().setVisible(false);
			vp.getIndex().setVisible(false);
			vp.getId_cant_aduanas().setVisible(false);
			vp.getId_index().setVisible(false);
			vp.getScroll().setVisible(false);
			vp.getId_hora().setVisible(true);
			vp.getId_fecha().setVisible(true);
			vp.getErr_scroll().setVisible(true);
			break;
		}
		case "Mun_del": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getOrigen().setVisible(false);
			vp.getDestino().setVisible(false);
			vp.getHora_salida().setVisible(false);
			vp.getFecha_salida().setVisible(false);
			vp.getDuracion().setVisible(false);
			vp.getNombre().setVisible(false);
			vp.getMun_cant_peajes().setVisible(false);
			vp.getId_origen().setVisible(false);
			vp.getId_destino().setVisible(false);
			vp.getId_hora_salida().setVisible(false);
			vp.getId_fecha_salida().setVisible(false);
			vp.getId_duracion().setVisible(false);
			vp.getId_nombre().setVisible(false);
			vp.getId_cant_peajes().setVisible(false);
			vp.getId_mun().setVisible(true);
			vp.getId_dep().setVisible(false);
			vp.getId_int().setVisible(false);
			vp.getId_v().setVisible(false);
			vp.getConfirmar_del().setVisible(true);
			vp.getConfirmar_act().setVisible(false);
			vp.getDep_cant_peajes().setVisible(false);
			vp.getInt_cant_aduanas().setVisible(false);
			vp.getIndex().setVisible(true);
			vp.getId_cant_aduanas().setVisible(false);
			vp.getId_index().setVisible(true);
			vp.getScroll().setVisible(false);
			vp.getId_hora().setVisible(false);
			vp.getId_fecha().setVisible(false);
			vp.getErr_scroll().setVisible(true);
			break;
		}
		case "Mun_act": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getOrigen().setVisible(true);
			vp.getDestino().setVisible(true);
			vp.getHora_salida().setVisible(true);
			vp.getFecha_salida().setVisible(true);
			vp.getDuracion().setVisible(true);
			vp.getNombre().setVisible(true);
			vp.getMun_cant_peajes().setVisible(true);
			vp.getId_origen().setVisible(true);
			vp.getId_destino().setVisible(true);
			vp.getId_hora_salida().setVisible(true);
			vp.getId_fecha_salida().setVisible(true);
			vp.getId_duracion().setVisible(true);
			vp.getId_nombre().setVisible(true);
			vp.getId_cant_peajes().setVisible(true);
			vp.getId_mun().setVisible(true);
			vp.getId_dep().setVisible(false);
			vp.getId_int().setVisible(false);
			vp.getId_v().setVisible(false);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(true);
			vp.getDep_cant_peajes().setVisible(false);
			vp.getInt_cant_aduanas().setVisible(false);
			vp.getIndex().setVisible(true);
			vp.getId_cant_aduanas().setVisible(false);
			vp.getId_index().setVisible(true);
			vp.getScroll().setVisible(false);
			vp.getId_hora().setVisible(true);
			vp.getId_fecha().setVisible(true);
			vp.getErr_scroll().setVisible(true);
			break;
		}
		case "Mun_mostrar": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getOrigen().setVisible(false);
			vp.getDestino().setVisible(false);
			vp.getHora_salida().setVisible(false);
			vp.getFecha_salida().setVisible(false);
			vp.getDuracion().setVisible(false);
			vp.getNombre().setVisible(false);
			vp.getMun_cant_peajes().setVisible(false);
			vp.getId_origen().setVisible(false);
			vp.getId_destino().setVisible(false);
			vp.getId_hora_salida().setVisible(false);
			vp.getId_fecha_salida().setVisible(false);
			vp.getId_duracion().setVisible(false);
			vp.getId_nombre().setVisible(false);
			vp.getId_cant_peajes().setVisible(false);
			vp.getId_mun().setVisible(true);
			vp.getId_dep().setVisible(false);
			vp.getId_int().setVisible(false);
			vp.getId_v().setVisible(false);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(false);
			vp.getDep_cant_peajes().setVisible(false);
			vp.getInt_cant_aduanas().setVisible(false);
			vp.getIndex().setVisible(false);
			vp.getId_cant_aduanas().setVisible(false);
			vp.getId_index().setVisible(false);
			vp.getScroll().setVisible(true);
			vp.getId_hora().setVisible(false);
			vp.getId_fecha().setVisible(false);
			vp.getErr_scroll().setVisible(false);

			vp.getOutput().setText(vmdao.mostrarTodo());
			break;
		}
		case "Dep_crear": {
			vp.getConfirmar_crear().setVisible(true);
			vp.getOrigen().setVisible(true);
			vp.getDestino().setVisible(true);
			vp.getHora_salida().setVisible(true);
			vp.getFecha_salida().setVisible(true);
			vp.getDuracion().setVisible(true);
			vp.getNombre().setVisible(true);
			vp.getMun_cant_peajes().setVisible(false);
			vp.getId_origen().setVisible(true);
			vp.getId_destino().setVisible(true);
			vp.getId_hora_salida().setVisible(true);
			vp.getId_fecha_salida().setVisible(true);
			vp.getId_duracion().setVisible(true);
			vp.getId_nombre().setVisible(true);
			vp.getId_cant_peajes().setVisible(true);
			vp.getId_mun().setVisible(false);
			vp.getId_dep().setVisible(true);
			vp.getId_int().setVisible(false);
			vp.getId_v().setVisible(false);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(false);
			vp.getDep_cant_peajes().setVisible(true);
			vp.getInt_cant_aduanas().setVisible(false);
			vp.getIndex().setVisible(false);
			vp.getId_cant_aduanas().setVisible(false);
			vp.getId_index().setVisible(false);
			vp.getScroll().setVisible(false);
			vp.getId_hora().setVisible(true);
			vp.getId_fecha().setVisible(true);
			vp.getErr_scroll().setVisible(true);
			break;
		}
		case "Dep_del": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getOrigen().setVisible(false);
			vp.getDestino().setVisible(false);
			vp.getHora_salida().setVisible(false);
			vp.getFecha_salida().setVisible(false);
			vp.getDuracion().setVisible(false);
			vp.getNombre().setVisible(false);
			vp.getMun_cant_peajes().setVisible(false);
			vp.getId_origen().setVisible(false);
			vp.getId_destino().setVisible(false);
			vp.getId_hora_salida().setVisible(false);
			vp.getId_fecha_salida().setVisible(false);
			vp.getId_duracion().setVisible(false);
			vp.getId_nombre().setVisible(false);
			vp.getId_cant_peajes().setVisible(false);
			vp.getId_mun().setVisible(false);
			vp.getId_dep().setVisible(true);
			vp.getId_int().setVisible(false);
			vp.getId_v().setVisible(false);
			vp.getConfirmar_del().setVisible(true);
			vp.getConfirmar_act().setVisible(false);
			vp.getDep_cant_peajes().setVisible(false);
			vp.getInt_cant_aduanas().setVisible(false);
			vp.getIndex().setVisible(true);
			vp.getId_cant_aduanas().setVisible(false);
			vp.getId_index().setVisible(true);
			vp.getScroll().setVisible(false);
			vp.getId_hora().setVisible(false);
			vp.getId_fecha().setVisible(false);
			vp.getErr_scroll().setVisible(true);
			break;
		}
		case "Dep_act": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getOrigen().setVisible(true);
			vp.getDestino().setVisible(true);
			vp.getHora_salida().setVisible(true);
			vp.getFecha_salida().setVisible(true);
			vp.getDuracion().setVisible(true);
			vp.getNombre().setVisible(true);
			vp.getMun_cant_peajes().setVisible(false);
			vp.getId_origen().setVisible(true);
			vp.getId_destino().setVisible(true);
			vp.getId_hora_salida().setVisible(true);
			vp.getId_fecha_salida().setVisible(true);
			vp.getId_duracion().setVisible(true);
			vp.getId_nombre().setVisible(true);
			vp.getId_cant_peajes().setVisible(true);
			vp.getId_mun().setVisible(false);
			vp.getId_dep().setVisible(true);
			vp.getId_int().setVisible(false);
			vp.getId_v().setVisible(false);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(true);
			vp.getDep_cant_peajes().setVisible(true);
			vp.getInt_cant_aduanas().setVisible(false);
			vp.getIndex().setVisible(true);
			vp.getId_cant_aduanas().setVisible(false);
			vp.getId_index().setVisible(true);
			vp.getScroll().setVisible(false);
			vp.getId_hora().setVisible(true);
			vp.getId_fecha().setVisible(true);
			vp.getErr_scroll().setVisible(true);
			break;
		}
		case "Dep_mostrar": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getOrigen().setVisible(false);
			vp.getDestino().setVisible(false);
			vp.getHora_salida().setVisible(false);
			vp.getFecha_salida().setVisible(false);
			vp.getDuracion().setVisible(false);
			vp.getNombre().setVisible(false);
			vp.getMun_cant_peajes().setVisible(false);
			vp.getId_origen().setVisible(false);
			vp.getId_destino().setVisible(false);
			vp.getId_hora_salida().setVisible(false);
			vp.getId_fecha_salida().setVisible(false);
			vp.getId_duracion().setVisible(false);
			vp.getId_nombre().setVisible(false);
			vp.getId_cant_peajes().setVisible(false);
			vp.getId_mun().setVisible(false);
			vp.getId_dep().setVisible(true);
			vp.getId_int().setVisible(false);
			vp.getId_v().setVisible(false);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(false);
			vp.getDep_cant_peajes().setVisible(false);
			vp.getInt_cant_aduanas().setVisible(false);
			vp.getIndex().setVisible(false);
			vp.getId_cant_aduanas().setVisible(false);
			vp.getId_index().setVisible(false);
			vp.getScroll().setVisible(true);
			vp.getId_hora().setVisible(false);
			vp.getId_fecha().setVisible(false);
			vp.getErr_scroll().setVisible(false);

			vp.getOutput().setText(vddao.mostrarTodo());
			break;
		}
		case "Int_crear": {
			vp.getConfirmar_crear().setVisible(true);
			vp.getOrigen().setVisible(true);
			vp.getDestino().setVisible(true);
			vp.getHora_salida().setVisible(true);
			vp.getFecha_salida().setVisible(true);
			vp.getDuracion().setVisible(true);
			vp.getNombre().setVisible(true);
			vp.getMun_cant_peajes().setVisible(false);
			vp.getId_origen().setVisible(true);
			vp.getId_destino().setVisible(true);
			vp.getId_hora_salida().setVisible(true);
			vp.getId_fecha_salida().setVisible(true);
			vp.getId_duracion().setVisible(true);
			vp.getId_nombre().setVisible(true);
			vp.getId_cant_peajes().setVisible(false);
			vp.getId_mun().setVisible(false);
			vp.getId_dep().setVisible(false);
			vp.getId_int().setVisible(true);
			vp.getId_v().setVisible(false);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(false);
			vp.getDep_cant_peajes().setVisible(false);
			vp.getInt_cant_aduanas().setVisible(true);
			vp.getIndex().setVisible(false);
			vp.getId_cant_aduanas().setVisible(true);
			vp.getId_index().setVisible(false);
			vp.getScroll().setVisible(false);
			vp.getId_hora().setVisible(true);
			vp.getId_fecha().setVisible(true);
			vp.getErr_scroll().setVisible(true);
			break;
		}
		case "Int_del": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getOrigen().setVisible(false);
			vp.getDestino().setVisible(false);
			vp.getHora_salida().setVisible(false);
			vp.getFecha_salida().setVisible(false);
			vp.getDuracion().setVisible(false);
			vp.getNombre().setVisible(false);
			vp.getMun_cant_peajes().setVisible(false);
			vp.getId_origen().setVisible(false);
			vp.getId_destino().setVisible(false);
			vp.getId_hora_salida().setVisible(false);
			vp.getId_fecha_salida().setVisible(false);
			vp.getId_duracion().setVisible(false);
			vp.getId_nombre().setVisible(false);
			vp.getId_cant_peajes().setVisible(false);
			vp.getId_mun().setVisible(false);
			vp.getId_dep().setVisible(false);
			vp.getId_int().setVisible(true);
			vp.getId_v().setVisible(false);
			vp.getConfirmar_del().setVisible(true);
			vp.getConfirmar_act().setVisible(false);
			vp.getDep_cant_peajes().setVisible(false);
			vp.getInt_cant_aduanas().setVisible(false);
			vp.getIndex().setVisible(true);
			vp.getId_cant_aduanas().setVisible(false);
			vp.getId_index().setVisible(true);
			vp.getScroll().setVisible(false);
			vp.getId_hora().setVisible(false);
			vp.getId_fecha().setVisible(false);
			vp.getErr_scroll().setVisible(true);
			break;
		}
		case "Int_act": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getOrigen().setVisible(true);
			vp.getDestino().setVisible(true);
			vp.getHora_salida().setVisible(true);
			vp.getFecha_salida().setVisible(true);
			vp.getDuracion().setVisible(true);
			vp.getNombre().setVisible(true);
			vp.getMun_cant_peajes().setVisible(false);
			vp.getId_origen().setVisible(true);
			vp.getId_destino().setVisible(true);
			vp.getId_hora_salida().setVisible(true);
			vp.getId_fecha_salida().setVisible(true);
			vp.getId_duracion().setVisible(true);
			vp.getId_nombre().setVisible(true);
			vp.getId_cant_peajes().setVisible(false);
			vp.getId_mun().setVisible(false);
			vp.getId_dep().setVisible(false);
			vp.getId_int().setVisible(true);
			vp.getId_v().setVisible(false);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(true);
			vp.getDep_cant_peajes().setVisible(false);
			vp.getInt_cant_aduanas().setVisible(true);
			vp.getIndex().setVisible(true);
			vp.getId_cant_aduanas().setVisible(true);
			vp.getId_index().setVisible(true);
			vp.getScroll().setVisible(false);
			vp.getId_hora().setVisible(true);
			vp.getId_fecha().setVisible(true);
			vp.getErr_scroll().setVisible(true);
			break;
		}
		case "Int_mostrar": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getOrigen().setVisible(false);
			vp.getDestino().setVisible(false);
			vp.getHora_salida().setVisible(false);
			vp.getFecha_salida().setVisible(false);
			vp.getDuracion().setVisible(false);
			vp.getNombre().setVisible(false);
			vp.getMun_cant_peajes().setVisible(false);
			vp.getId_origen().setVisible(false);
			vp.getId_destino().setVisible(false);
			vp.getId_hora_salida().setVisible(false);
			vp.getId_fecha_salida().setVisible(false);
			vp.getId_duracion().setVisible(false);
			vp.getId_nombre().setVisible(false);
			vp.getId_cant_peajes().setVisible(false);
			vp.getId_mun().setVisible(false);
			vp.getId_dep().setVisible(false);
			vp.getId_int().setVisible(true);
			vp.getId_v().setVisible(false);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(false);
			vp.getDep_cant_peajes().setVisible(false);
			vp.getInt_cant_aduanas().setVisible(false);
			vp.getIndex().setVisible(false);
			vp.getId_cant_aduanas().setVisible(false);
			vp.getId_index().setVisible(false);
			vp.getScroll().setVisible(true);
			vp.getId_hora().setVisible(false);
			vp.getId_fecha().setVisible(false);
			vp.getErr_scroll().setVisible(false);

			vp.getOutput().setText(vidao.mostrarTodo());
			break;
		}
		case "V_mostrar": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getOrigen().setVisible(false);
			vp.getDestino().setVisible(false);
			vp.getHora_salida().setVisible(false);
			vp.getFecha_salida().setVisible(false);
			vp.getDuracion().setVisible(false);
			vp.getNombre().setVisible(false);
			vp.getMun_cant_peajes().setVisible(false);
			vp.getId_origen().setVisible(false);
			vp.getId_destino().setVisible(false);
			vp.getId_hora_salida().setVisible(false);
			vp.getId_fecha_salida().setVisible(false);
			vp.getId_duracion().setVisible(false);
			vp.getId_nombre().setVisible(false);
			vp.getId_cant_peajes().setVisible(false);
			vp.getId_mun().setVisible(false);
			vp.getId_dep().setVisible(false);
			vp.getId_int().setVisible(false);
			vp.getId_v().setVisible(true);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(false);
			vp.getDep_cant_peajes().setVisible(false);
			vp.getInt_cant_aduanas().setVisible(false);
			vp.getIndex().setVisible(false);
			vp.getId_cant_aduanas().setVisible(false);
			vp.getId_index().setVisible(false);
			vp.getScroll().setVisible(true);
			vp.getId_hora().setVisible(false);
			vp.getId_fecha().setVisible(false);
			vp.getErr_scroll().setVisible(false);

			vdao.getLista().removeAll(vdao.getLista());
			vdao.agregarMunicipal(vmdao.getLista());
			vdao.agregarDepartamental(vddao.getLista());
			vdao.agregarInternacional(vidao.getLista());

			vp.getOutput().setText(vdao.mostrarTodo());
			break;
		}
		default:
		}
	}

}
