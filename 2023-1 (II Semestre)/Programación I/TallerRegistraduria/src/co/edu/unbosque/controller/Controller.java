package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.CiudadanoDAO;
import co.edu.unbosque.model.PadreDAO;
import co.edu.unbosque.model.PadreDTO;
import co.edu.unbosque.model.NeonatoDAO;
import co.edu.unbosque.model.NeonatoDTO;
import co.edu.unbosque.model.MadreDAO;
import co.edu.unbosque.model.MadreDTO;
import co.edu.unbosque.model.TemporalNeonatos;
import co.edu.unbosque.model.TemporalPadres;
import co.edu.unbosque.util.InvalidDateFormatException;
import co.edu.unbosque.util.InvalidIndexFormatException;
import co.edu.unbosque.util.InvalidLocationException;
import co.edu.unbosque.util.InvalidNameException;
import co.edu.unbosque.util.InvalidSexException;
import co.edu.unbosque.view.Consola;
import co.edu.unbosque.view.ErrorStreamRedirector;
import co.edu.unbosque.view.VentanaPrincipal;

/**
 * Establece la lógica entre la interfaz de usuario y las representaciones planetadas en el modelo.
 * @author Federico Vargas Rozo
 * @param cdao Objeco de la clase CiudadanoDAO
 * @param ndao Objeto de la clase NeonatoDAO
 * @param pdao Objeto de la clase PadreDAO
 * @param mdao Objeto de la clase MadreDAO
 * @param con Objeto de la clase Consola
 * @param lista_padres Lista temporal para la persistencia de los Padres
 * @param lista_madres Lista temporal para la persitencia de las Madres
 * @param lista_neo Lista temporal para la persistencia de los Neonatos
 * @param error_stream Objeto de la clase ErrorStreamRedirector
 * @param temp_nombre String temporal para el nombre
 * @param temp_sexo String temporal para el sexo
 * @param temp_ciudad String temporal para la ciudad
 * @param temp_fecha Date temporal para la fecha
 * @param temp_index Entero temporal para la posicion
 * @param temp_nombre_padre String temporal para el nombre del padre
 * @param temp_ciudad_padre String temporal para la ciudad del padre
 * @param temp_fecha_padre Date temporal para la fecha del padre
 * @param temp_nombre_madre String temporal para el nombre de la madre
 * @param temp_ciudad_madre String temporal para la ciudad de la madre
 * @param temp_fecha_madre Date temporal para la fecha de la madre
 * @param tiene_madre Booleano para verificar si el neonato tiene padre
 * @param tiene_madre Booleano para verificar si el neonato tiene madre
 * @param validacion Booleano que permite o no la creacion, o actualizacion si todos los valores son validos.
 * @param vp Objeto de la clase VentanaPrincipal
 *
 */

public class Controller implements ActionListener {

	private CiudadanoDAO cdao;
	private NeonatoDAO ndao;
	private PadreDAO pdao;;
	private MadreDAO mdao;
	private Consola con;
	private ArrayList<TemporalPadres> lista_padres;
	private ArrayList<TemporalPadres> lista_madres;
	private ArrayList<TemporalNeonatos> lista_neo;
	private ErrorStreamRedirector error_stream;

	private String temp_nombre;
	private String temp_sexo;
	private String temp_ciudad;
	private Date temp_fecha;
	private int temp_index;
	private String temp_nombre_padre;
	private String temp_ciudad_padre;
	private Date temp_fecha_padre;
	private String temp_nombre_madre;
	private String temp_ciudad_madre;
	private Date temp_fecha_madre;
	private boolean tiene_padre;
	private boolean tiene_madre;
	
	private boolean validacion;

	private VentanaPrincipal vp;

	public Controller() {
		con = new Consola();
		cdao = new CiudadanoDAO();
		ndao = new NeonatoDAO();
		pdao = new PadreDAO();
		mdao = new MadreDAO();
		tiene_padre = false;
		tiene_madre = false;
		validacion = true;

		// Persistencia Lista Padres
		try {
			lista_padres = pdao.cargarDesdeArchivo();
			for (TemporalPadres tp : lista_padres) {
				pdao.crear(new PadreDTO(tp.getNombre(), tp.getSexo(), tp.getCiudad(), tp.getFecha()));
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}

		// Persistencia Lista Madres
		try {
			lista_madres = mdao.cargarDesdeArchivo();
			for (TemporalPadres tm : lista_madres) {
				mdao.crear(new MadreDTO(tm.getNombre(), tm.getSexo(), tm.getCiudad(), tm.getFecha()));
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}

		// Persistencia Lista Neonatos
		try {
			lista_neo = ndao.cargarDesdeArchivo();
			for (TemporalNeonatos tn : lista_neo) {
				ndao.crear(new NeonatoDTO(tn.getNombre(), tn.getSexo(), tn.getCiudad(), tn.getFecha(),
						new PadreDTO(tn.getNombre_padre(), null, null, null),
						new MadreDTO(tn.getNombre_madre(), null, null, null)));
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}

		// Persistecia Lista General
		cdao.agregarNeonato(ndao.getLista());
		cdao.agregarPadre(pdao.getLista());
		cdao.agregarMadre(mdao.getLista());

	}
	/**
	 * Funcion para inicializar atributos, lectores, variables y añadir todos los Pokemones a las respectivas listas.
	 */
	public void run() {
		vp = new VentanaPrincipal();
		agregarLectores();
		vp.getOutput().setText(cdao.mostrarTodo());
		error_stream = new ErrorStreamRedirector(vp.getError());
	}
	/**
	 * Se crean los lectores para que todo JButton, JTextField y JList, permitan la lectura.
	 */
	public void agregarLectores() {
		// JMenuItems
		// Padres
		vp.getP_crear().addActionListener(this);
		vp.getP_crear().setActionCommand("crear padre");

		vp.getP_del().addActionListener(this);
		vp.getP_del().setActionCommand("eliminar padre");

		vp.getP_act().addActionListener(this);
		vp.getP_act().setActionCommand("editar padre");

		vp.getP_mostrar().addActionListener(this);
		vp.getP_mostrar().setActionCommand("mostrar padres");
		// Madres
		vp.getM_crear().addActionListener(this);
		vp.getM_crear().setActionCommand("crear madre");

		vp.getM_del().addActionListener(this);
		vp.getM_del().setActionCommand("eliminar madre");

		vp.getM_act().addActionListener(this);
		vp.getM_act().setActionCommand("editar madre");

		vp.getM_mostrar().addActionListener(this);
		vp.getM_mostrar().setActionCommand("mostrar madres");
		// Neonatos
		vp.getN_crear().addActionListener(this);
		vp.getN_crear().setActionCommand("crear neonato");

		vp.getN_del().addActionListener(this);
		vp.getN_del().setActionCommand("eliminar neonato");

		vp.getN_act().addActionListener(this);
		vp.getN_act().setActionCommand("editar neonato");

		vp.getN_mostrar().addActionListener(this);
		vp.getN_mostrar().setActionCommand("mostrar neonatos");
		// Ciudadanos
		vp.getG_mostrar().addActionListener(this);
		vp.getG_mostrar().setActionCommand("mostrar ciudadanos");

		// Botones Confirmar
		vp.getConfirmar_crear().addActionListener(this);
		vp.getConfirmar_crear().setActionCommand("confirmar crear");

		vp.getConfirmar_del().addActionListener(this);
		vp.getConfirmar_del().setActionCommand("confirmar eliminar");

		vp.getConfirmar_act().addActionListener(this);
		vp.getConfirmar_act().setActionCommand("confirmar actualizar");

		// CheckBox
		vp.getTiene_padre().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					vp.getNombre_p().setEditable(true);
					vp.getCiudad_p().setEditable(true);
					vp.getFecha_p().setEditable(true);
					tiene_padre = true;
				} else {
					vp.getNombre_p().setEditable(false);
					vp.getCiudad_p().setEditable(false);
					vp.getFecha_p().setEditable(false);
					tiene_padre = false;
				}
			}
		});

		vp.getTiene_madre().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					vp.getNombre_m().setEditable(true);
					vp.getCiudad_m().setEditable(true);
					vp.getFecha_m().setEditable(true);
					tiene_madre = true;
				} else {
					vp.getNombre_m().setEditable(false);
					vp.getCiudad_m().setEditable(false);
					vp.getFecha_m().setEditable(false);
					tiene_madre = false;
				}
			}
		});
	}
	/**
	 * Se llama cuando se presiona un JButton previamente inicializado.
	 * Establece los comandos y la funcionalidad de cada elemento interactivo.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		// Botones
		case "confirmar crear": {
			try {

				temp_nombre = con.leerNombre(vp.getNombre().getText());
				temp_ciudad = con.leerCiudad(vp.getCiudad().getText());
				temp_fecha = new Date(con.leerFecha(vp.getFecha().getText()));
				validacion = true;

				// Padres
				if (vp.getId_p().isVisible()) {
					if(validacion) {
						pdao.crear(new PadreDTO(temp_nombre, "Masculino", temp_ciudad, temp_fecha));

						cdao.getLista().removeAll(cdao.getLista());
						cdao.agregarNeonato(ndao.getLista());
						cdao.agregarPadre(pdao.getLista());
						cdao.agregarMadre(mdao.getLista());
						con.printErrorSalto("Nuevo Padre creado con exito.");
					}

				}
				// Madres
				else if (vp.getId_m().isVisible()) {
					if(validacion) {
						mdao.crear(new MadreDTO(temp_nombre, "Femenino", temp_ciudad, temp_fecha));

						cdao.getLista().removeAll(cdao.getLista());
						cdao.agregarNeonato(ndao.getLista());
						cdao.agregarPadre(pdao.getLista());
						cdao.agregarMadre(mdao.getLista());
						con.printErrorSalto("Nueva Madre craeda con exito.");
					}
				}
				// Neonatos
				else if (vp.getId_n().isVisible()) {
					temp_sexo = con.leerSexo(vp.getSexo().getText());
					validacion = true;
					if (tiene_padre) {
						temp_nombre_padre = con.leerNombre(vp.getNombre_p().getText());
						temp_ciudad_padre = con.leerCiudad(vp.getCiudad_p().getText());
						temp_fecha_padre = new Date(con.leerFecha(vp.getFecha_p().getText()));
						validacion = true;
					}
					if (tiene_madre) {
						temp_nombre_madre = con.leerNombre(vp.getNombre_m().getText());
						temp_ciudad_madre = con.leerCiudad(vp.getCiudad_m().getText());
						temp_fecha_madre = new Date(con.leerFecha(vp.getFecha_m().getText()));
						validacion = true;
					}
					if(validacion) {

						// Verificaciones
						if (tiene_padre && tiene_madre) {
							ndao.crear(new NeonatoDTO(temp_nombre, temp_sexo, temp_ciudad, temp_fecha,
									new PadreDTO(temp_nombre_padre, "Masculino", temp_ciudad_padre, temp_fecha_padre),
									new MadreDTO(temp_nombre_madre, "Femenino", temp_ciudad_madre, temp_fecha_madre)));

							pdao.crear(new PadreDTO(temp_nombre_padre, "Masculino", temp_ciudad_padre, temp_fecha_padre));
							mdao.crear(new MadreDTO(temp_nombre_madre, "Femenino", temp_ciudad_madre, temp_fecha_madre));
						} else if (tiene_padre && tiene_madre == false) {
							ndao.crear(new NeonatoDTO(temp_nombre, temp_sexo, temp_ciudad, temp_fecha,
									new PadreDTO(temp_nombre_padre, "Masculino", temp_ciudad_padre, temp_fecha_padre),
									new MadreDTO("n/a", null, null, null)));
							pdao.crear(new PadreDTO(temp_nombre_padre, "Masculino", temp_ciudad_padre, temp_fecha_padre));
						} else if (tiene_madre && tiene_padre == false) {
							ndao.crear(new NeonatoDTO(temp_nombre, temp_sexo, temp_ciudad, temp_fecha,
									new PadreDTO("n/a", null, null, null),
									new MadreDTO(temp_nombre_madre, "Femenino", temp_ciudad_madre, temp_fecha_madre)));
							mdao.crear(new MadreDTO(temp_nombre_madre, "Femenino", temp_ciudad_madre, temp_fecha_madre));
						} else if (tiene_padre == false && tiene_madre == false) {
							ndao.crear(new NeonatoDTO(temp_nombre, temp_sexo, temp_ciudad, temp_fecha,
									new PadreDTO("n/a", null, null, null), new MadreDTO("n/a", null, null, null)));
						}

						cdao.getLista().removeAll(cdao.getLista());
						cdao.agregarNeonato(ndao.getLista());
						cdao.agregarPadre(pdao.getLista());
						cdao.agregarMadre(mdao.getLista());
						con.printErrorSalto("Nuevo Neonato creado con exito.");
					}

				}
				vp.getNombre().setText("");
				vp.getSexo().setText("");
				vp.getCiudad().setText("");
				vp.getFecha().setText("");
				vp.getNombre_p().setText("");
				vp.getCiudad_p().setText("");
				vp.getFecha_p().setText("");
				vp.getNombre_m().setText("");
				vp.getCiudad_m().setText("");
				vp.getFecha_m().setText("");
				vp.getTiene_padre().setSelected(false);
				vp.getTiene_madre().setSelected(false);
			} catch (InvalidDateFormatException e1) {
				validacion = false;
				con.printErrorSalto(e1.getMessage());
			} catch (InvalidLocationException e2) {
				validacion = false;
				con.printErrorSalto(e2.getMessage());
			} catch (InvalidNameException e3) {
				validacion = false;
				con.printErrorSalto(e3.getMessage());
			} catch (InvalidSexException e4){
				validacion = false;
				con.printErrorSalto(e4.getMessage());
			}
			break;
		}
		case "confirmar eliminar": {
			try {
				temp_index = con.leerInt(vp.getIndex().getText());
				validacion = true;
				if(validacion) {
					if (vp.getId_p().isVisible()) {
						if (pdao.eliminar(temp_index)) {
							con.printErrorSalto("Padre Eliminado con exito.");
						} else {
							con.printErrorSalto("Error en la operacion: No existe el Padre con ID No°" + temp_index);
						}
					} else if (vp.getId_m().isVisible()) {
						if (mdao.eliminar(temp_index)) {
							con.printErrorSalto("Madre Eliminado con exito.");
						} else {
							con.printErrorSalto("Error en la operacion: No existe la Madre con ID No°" + temp_index);
						}
					} else if (vp.getId_n().isVisible()) {
						if (ndao.eliminar(temp_index)) {
							con.printErrorSalto("Neonato Eliminado con exito.");
						} else {
							con.printErrorSalto("Error en la operacion: No existe el Neonato con ID No°" + temp_index);
						}
					}
				}
				vp.getIndex().setText("");
			} catch (InvalidIndexFormatException e5) {
				validacion = false;
				con.printErrorSalto(e5.getMessage());
			}
			break;
		}
		case "confirmar actualizar": {
			try {
				temp_nombre = con.leerNombre(vp.getNombre().getText());
				temp_ciudad = con.leerCiudad(vp.getCiudad().getText());
				temp_fecha = new Date(con.leerFecha(vp.getFecha().getText()));
				temp_index = con.leerInt(vp.getIndex().getText());
				validacion = true;
				// Padres
				if (vp.getId_p().isVisible()) {
					if(validacion) {
						if(pdao.actualizar(temp_index, new PadreDTO(temp_nombre, "Masculino", temp_ciudad, temp_fecha))) {
							con.printErrorSalto("Padre modificado con exito.");
							cdao.getLista().removeAll(cdao.getLista());
							cdao.agregarNeonato(ndao.getLista());
							cdao.agregarPadre(pdao.getLista());
							cdao.agregarMadre(mdao.getLista());
						}else {
							con.printErrorSalto("Error en la operacion: No existe el Padre con ID No°"+temp_index);
						}
					}
				}
				// Madres
				else if (vp.getId_m().isVisible()) {
					if(validacion) {
						if(mdao.actualizar(temp_index, new MadreDTO(temp_nombre, "Femenino", temp_ciudad, temp_fecha))) {
							con.printErrorSalto("Madre modificada con exito.");
							cdao.getLista().removeAll(cdao.getLista());
							cdao.agregarNeonato(ndao.getLista());
							cdao.agregarPadre(pdao.getLista());
							cdao.agregarMadre(mdao.getLista());
						}else {
							con.printErrorSalto("Error en la operacion: No existe la Madre con ID No°"+temp_index);
						}
					}
				}
				// Neonatos
				else if (vp.getId_n().isVisible()) {
					temp_sexo = con.leerSexo(vp.getSexo().getText());
					validacion = true;
					if (tiene_padre) {
						temp_nombre_padre = con.leerNombre(vp.getNombre_p().getText());
						temp_ciudad_padre = con.leerCiudad(vp.getCiudad_p().getText());
						temp_fecha_padre = new Date(con.leerFecha(vp.getFecha_p().getText()));
						validacion = true;
					}
					if (tiene_madre) {
						temp_nombre_madre = con.leerNombre(vp.getNombre_m().getText());
						temp_ciudad_madre = con.leerCiudad(vp.getCiudad_m().getText());
						temp_fecha_madre = new Date(con.leerFecha(vp.getFecha_m().getText()));
						validacion = true;
					}
					if(validacion) {

						// Verificaciones
						if (tiene_padre && tiene_madre) {
							if(ndao.actualizar(temp_index,
									new NeonatoDTO(temp_nombre, temp_sexo, temp_ciudad, temp_fecha,
											new PadreDTO(temp_nombre_padre, "Masculino", temp_ciudad_padre, temp_fecha_padre),
											new MadreDTO(temp_nombre_madre, "Femenino", temp_ciudad_madre, temp_fecha_madre)))) {
								con.printErrorSalto("Neonato modificado con exito.");
								cdao.getLista().removeAll(cdao.getLista());
								cdao.agregarNeonato(ndao.getLista());
								cdao.agregarPadre(pdao.getLista());
								cdao.agregarMadre(mdao.getLista());
							}else {
								con.printErrorSalto("Error en la operacion: No existe el Neonato con ID No°"+temp_index);
							}

						} else if (tiene_padre && tiene_madre == false) {
							if(ndao.actualizar(temp_index,
									new NeonatoDTO(temp_nombre, temp_sexo, temp_ciudad, temp_fecha,
											new PadreDTO(temp_nombre_padre, "Masculino", temp_ciudad_padre, temp_fecha_padre),
											new MadreDTO("n/a", null, null, null)))) {
								con.printErrorSalto("Neonato modificado con exito.");
								cdao.getLista().removeAll(cdao.getLista());
								cdao.agregarNeonato(ndao.getLista());
								cdao.agregarPadre(pdao.getLista());
								cdao.agregarMadre(mdao.getLista());
							}else {
								con.printErrorSalto("Error en la operacion: No existe el Neonato con ID No°"+temp_index);
							}

						} else if (tiene_madre && tiene_padre == false) {
							if(ndao.actualizar(temp_index,
									new NeonatoDTO(temp_nombre, temp_sexo, temp_ciudad, temp_fecha,
											new PadreDTO("n/a", null, null, null),
											new MadreDTO(temp_nombre_madre, "Femenino", temp_ciudad_madre, temp_fecha_madre)))) {
								con.printErrorSalto("Neonato modificado con exito.");
								cdao.getLista().removeAll(cdao.getLista());
								cdao.agregarNeonato(ndao.getLista());
								cdao.agregarPadre(pdao.getLista());
								cdao.agregarMadre(mdao.getLista());
							}else {
								con.printErrorSalto("Error en la operacion: No existe el Neonato con ID No°"+temp_index);
							}
							
						} else if (tiene_padre == false && tiene_madre == false) {
							if(ndao.actualizar(temp_index, new NeonatoDTO(temp_nombre, temp_sexo, temp_ciudad, temp_fecha,
									new PadreDTO("n/a", null, null, null), new MadreDTO("n/a", null, null, null)))) {
								con.printErrorSalto("Neonato modificado con exito.");
								cdao.getLista().removeAll(cdao.getLista());
								cdao.agregarNeonato(ndao.getLista());
								cdao.agregarPadre(pdao.getLista());
								cdao.agregarMadre(mdao.getLista());
							}else {
								con.printErrorSalto("Error en la operacion: No existe el Neonato con ID No°"+temp_index);
							}
						}



					}

				}
				vp.getNombre().setText("");
				vp.getSexo().setText("");
				vp.getCiudad().setText("");
				vp.getFecha().setText("");
				vp.getIndex().setText("");
				vp.getNombre_p().setText("");
				vp.getCiudad_p().setText("");
				vp.getFecha_p().setText("");
				vp.getNombre_m().setText("");
				vp.getCiudad_m().setText("");
				vp.getFecha_m().setText("");
				vp.getTiene_padre().setSelected(false);
				vp.getTiene_madre().setSelected(false);
			} catch (InvalidDateFormatException e1) {
				validacion = false;
				con.printErrorSalto(e1.getMessage());
			} catch (InvalidLocationException e2) {
				validacion = false;
				con.printErrorSalto(e2.getMessage());
			} catch (InvalidNameException e3) {
				validacion = false;
				con.printErrorSalto(e3.getMessage());
			} catch (InvalidSexException e4){
				validacion = false;
				con.printErrorSalto(e4.getMessage());
			} catch (InvalidIndexFormatException e5) {
				validacion = false;
				con.printErrorSalto(e5.getMessage());
			}
			break;
		}

		// Padres
		case "crear padre": {
			vp.getConfirmar_crear().setVisible(true);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(false);
			vp.getNombre().setVisible(true);
			vp.getSexo().setVisible(false);
			vp.getCiudad().setVisible(true);
			vp.getFecha().setVisible(true);
			vp.getId_nombre().setVisible(true);
			vp.getId_sexo().setVisible(false);
			vp.getId_ciudad().setVisible(true);
			vp.getId_fecha().setVisible(true);
			vp.getFormato_fecha().setVisible(true);
			vp.getIndex().setVisible(false);
			vp.getId_index().setVisible(false);
			vp.getErr_scroll().setVisible(true);
			vp.getOutput().setVisible(false);
			vp.getScroll().setVisible(false);
			vp.getId_p().setVisible(true);
			vp.getId_m().setVisible(false);
			vp.getId_n().setVisible(false);
			vp.getId_g().setVisible(false);
			vp.getTiene_padre().setVisible(false);
			vp.getNombre_p().setVisible(false);
			vp.getId_nombre_p().setVisible(false);
			vp.getCiudad_p().setVisible(false);
			vp.getId_ciudad_p().setVisible(false);
			vp.getFecha_p().setVisible(false);
			vp.getId_fecha_p().setVisible(false);
			vp.getTiene_madre().setVisible(false);
			vp.getNombre_m().setVisible(false);
			vp.getId_nombre_m().setVisible(false);
			vp.getCiudad_m().setVisible(false);
			vp.getId_ciudad_m().setVisible(false);
			vp.getFecha_m().setVisible(false);
			vp.getId_fecha_m().setVisible(false);
			vp.getError().setText("");

			break;
		}
		case "eliminar padre": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getConfirmar_del().setVisible(true);
			vp.getConfirmar_act().setVisible(false);
			vp.getNombre().setVisible(false);
			vp.getSexo().setVisible(false);
			vp.getCiudad().setVisible(false);
			vp.getFecha().setVisible(false);
			vp.getId_nombre().setVisible(false);
			vp.getId_sexo().setVisible(false);
			vp.getId_ciudad().setVisible(false);
			vp.getId_fecha().setVisible(false);
			vp.getFormato_fecha().setVisible(false);
			vp.getIndex().setVisible(true);
			vp.getId_index().setVisible(true);
			vp.getErr_scroll().setVisible(true);
			vp.getOutput().setVisible(false);
			vp.getScroll().setVisible(false);
			vp.getId_p().setVisible(true);
			vp.getId_m().setVisible(false);
			vp.getId_n().setVisible(false);
			vp.getId_g().setVisible(false);
			vp.getTiene_padre().setVisible(false);
			vp.getNombre_p().setVisible(false);
			vp.getId_nombre_p().setVisible(false);
			vp.getCiudad_p().setVisible(false);
			vp.getId_ciudad_p().setVisible(false);
			vp.getFecha_p().setVisible(false);
			vp.getId_fecha_p().setVisible(false);
			vp.getTiene_madre().setVisible(false);
			vp.getNombre_m().setVisible(false);
			vp.getId_nombre_m().setVisible(false);
			vp.getCiudad_m().setVisible(false);
			vp.getId_ciudad_m().setVisible(false);
			vp.getFecha_m().setVisible(false);
			vp.getId_fecha_m().setVisible(false);
			vp.getError().setText("");
			break;
		}
		case "editar padre": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(true);
			vp.getNombre().setVisible(true);
			vp.getSexo().setVisible(false);
			vp.getCiudad().setVisible(true);
			vp.getFecha().setVisible(true);
			vp.getId_nombre().setVisible(true);
			vp.getId_sexo().setVisible(false);
			vp.getId_ciudad().setVisible(true);
			vp.getId_fecha().setVisible(true);
			vp.getFormato_fecha().setVisible(true);
			vp.getIndex().setVisible(true);
			vp.getId_index().setVisible(true);
			vp.getErr_scroll().setVisible(true);
			vp.getOutput().setVisible(false);
			vp.getScroll().setVisible(false);
			vp.getId_p().setVisible(true);
			vp.getId_m().setVisible(false);
			vp.getId_n().setVisible(false);
			vp.getId_g().setVisible(false);
			vp.getTiene_padre().setVisible(false);
			vp.getNombre_p().setVisible(false);
			vp.getId_nombre_p().setVisible(false);
			vp.getCiudad_p().setVisible(false);
			vp.getId_ciudad_p().setVisible(false);
			vp.getFecha_p().setVisible(false);
			vp.getId_fecha_p().setVisible(false);
			vp.getTiene_madre().setVisible(false);
			vp.getNombre_m().setVisible(false);
			vp.getId_nombre_m().setVisible(false);
			vp.getCiudad_m().setVisible(false);
			vp.getId_ciudad_m().setVisible(false);
			vp.getFecha_m().setVisible(false);
			vp.getId_fecha_m().setVisible(false);
			vp.getError().setText("");
			break;
		}
		case "mostrar padres": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(false);
			vp.getNombre().setVisible(false);
			vp.getSexo().setVisible(false);
			vp.getCiudad().setVisible(false);
			vp.getFecha().setVisible(false);
			vp.getId_nombre().setVisible(false);
			vp.getId_sexo().setVisible(false);
			vp.getId_ciudad().setVisible(false);
			vp.getId_fecha().setVisible(false);
			vp.getFormato_fecha().setVisible(false);
			vp.getIndex().setVisible(false);
			vp.getId_index().setVisible(false);
			vp.getErr_scroll().setVisible(false);
			vp.getOutput().setVisible(true);
			vp.getScroll().setVisible(true);
			vp.getId_p().setVisible(true);
			vp.getId_m().setVisible(false);
			vp.getId_n().setVisible(false);
			vp.getId_g().setVisible(false);
			vp.getTiene_padre().setVisible(false);
			vp.getNombre_p().setVisible(false);
			vp.getId_nombre_p().setVisible(false);
			vp.getCiudad_p().setVisible(false);
			vp.getId_ciudad_p().setVisible(false);
			vp.getFecha_p().setVisible(false);
			vp.getId_fecha_p().setVisible(false);
			vp.getTiene_madre().setVisible(false);
			vp.getNombre_m().setVisible(false);
			vp.getId_nombre_m().setVisible(false);
			vp.getCiudad_m().setVisible(false);
			vp.getId_ciudad_m().setVisible(false);
			vp.getFecha_m().setVisible(false);
			vp.getId_fecha_m().setVisible(false);

			vp.getOutput().setText(pdao.mostrarTodo());
			break;
		}
		// Madres
		case "crear madre": {
			vp.getConfirmar_crear().setVisible(true);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(false);
			vp.getNombre().setVisible(true);
			vp.getSexo().setVisible(false);
			vp.getCiudad().setVisible(true);
			vp.getFecha().setVisible(true);
			vp.getId_nombre().setVisible(true);
			vp.getId_sexo().setVisible(false);
			vp.getId_ciudad().setVisible(true);
			vp.getId_fecha().setVisible(true);
			vp.getFormato_fecha().setVisible(true);
			vp.getIndex().setVisible(false);
			vp.getId_index().setVisible(false);
			vp.getErr_scroll().setVisible(true);
			vp.getOutput().setVisible(false);
			vp.getScroll().setVisible(false);
			vp.getId_p().setVisible(false);
			vp.getId_m().setVisible(true);
			vp.getId_n().setVisible(false);
			vp.getId_g().setVisible(false);
			vp.getTiene_padre().setVisible(false);
			vp.getNombre_p().setVisible(false);
			vp.getId_nombre_p().setVisible(false);
			vp.getCiudad_p().setVisible(false);
			vp.getId_ciudad_p().setVisible(false);
			vp.getFecha_p().setVisible(false);
			vp.getId_fecha_p().setVisible(false);
			vp.getTiene_madre().setVisible(false);
			vp.getNombre_m().setVisible(false);
			vp.getId_nombre_m().setVisible(false);
			vp.getCiudad_m().setVisible(false);
			vp.getId_ciudad_m().setVisible(false);
			vp.getFecha_m().setVisible(false);
			vp.getId_fecha_m().setVisible(false);
			vp.getError().setText("");
			break;
		}
		case "eliminar madre": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getConfirmar_del().setVisible(true);
			vp.getConfirmar_act().setVisible(false);
			vp.getNombre().setVisible(false);
			vp.getSexo().setVisible(false);
			vp.getCiudad().setVisible(false);
			vp.getFecha().setVisible(false);
			vp.getId_nombre().setVisible(false);
			vp.getId_sexo().setVisible(false);
			vp.getId_ciudad().setVisible(false);
			vp.getId_fecha().setVisible(false);
			vp.getFormato_fecha().setVisible(false);
			vp.getIndex().setVisible(true);
			vp.getId_index().setVisible(true);
			vp.getErr_scroll().setVisible(true);
			vp.getOutput().setVisible(false);
			vp.getScroll().setVisible(false);
			vp.getId_p().setVisible(false);
			vp.getId_m().setVisible(true);
			vp.getId_n().setVisible(false);
			vp.getId_g().setVisible(false);
			vp.getTiene_padre().setVisible(false);
			vp.getNombre_p().setVisible(false);
			vp.getId_nombre_p().setVisible(false);
			vp.getCiudad_p().setVisible(false);
			vp.getId_ciudad_p().setVisible(false);
			vp.getFecha_p().setVisible(false);
			vp.getId_fecha_p().setVisible(false);
			vp.getTiene_madre().setVisible(false);
			vp.getNombre_m().setVisible(false);
			vp.getId_nombre_m().setVisible(false);
			vp.getCiudad_m().setVisible(false);
			vp.getId_ciudad_m().setVisible(false);
			vp.getFecha_m().setVisible(false);
			vp.getId_fecha_m().setVisible(false);
			vp.getError().setText("");
			break;
		}
		case "editar madre": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(true);
			vp.getNombre().setVisible(true);
			vp.getSexo().setVisible(false);
			vp.getCiudad().setVisible(true);
			vp.getFecha().setVisible(true);
			vp.getId_nombre().setVisible(true);
			vp.getId_sexo().setVisible(false);
			vp.getId_ciudad().setVisible(true);
			vp.getId_fecha().setVisible(true);
			vp.getFormato_fecha().setVisible(true);
			vp.getIndex().setVisible(true);
			vp.getId_index().setVisible(true);
			vp.getErr_scroll().setVisible(true);
			vp.getOutput().setVisible(false);
			vp.getScroll().setVisible(false);
			vp.getId_p().setVisible(false);
			vp.getId_m().setVisible(true);
			vp.getId_n().setVisible(false);
			vp.getId_g().setVisible(false);
			vp.getTiene_padre().setVisible(false);
			vp.getNombre_p().setVisible(false);
			vp.getId_nombre_p().setVisible(false);
			vp.getCiudad_p().setVisible(false);
			vp.getId_ciudad_p().setVisible(false);
			vp.getFecha_p().setVisible(false);
			vp.getId_fecha_p().setVisible(false);
			vp.getTiene_madre().setVisible(false);
			vp.getNombre_m().setVisible(false);
			vp.getId_nombre_m().setVisible(false);
			vp.getCiudad_m().setVisible(false);
			vp.getId_ciudad_m().setVisible(false);
			vp.getFecha_m().setVisible(false);
			vp.getId_fecha_m().setVisible(false);
			vp.getError().setText("");
			break;
		}
		case "mostrar madres": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(false);
			vp.getNombre().setVisible(false);
			vp.getSexo().setVisible(false);
			vp.getCiudad().setVisible(false);
			vp.getFecha().setVisible(false);
			vp.getId_nombre().setVisible(false);
			vp.getId_sexo().setVisible(false);
			vp.getId_ciudad().setVisible(false);
			vp.getId_fecha().setVisible(false);
			vp.getFormato_fecha().setVisible(false);
			vp.getIndex().setVisible(false);
			vp.getId_index().setVisible(false);
			vp.getErr_scroll().setVisible(false);
			vp.getOutput().setVisible(true);
			vp.getScroll().setVisible(true);
			vp.getId_p().setVisible(false);
			vp.getId_m().setVisible(true);
			vp.getId_n().setVisible(false);
			vp.getId_g().setVisible(false);
			vp.getTiene_padre().setVisible(false);
			vp.getNombre_p().setVisible(false);
			vp.getId_nombre_p().setVisible(false);
			vp.getCiudad_p().setVisible(false);
			vp.getId_ciudad_p().setVisible(false);
			vp.getFecha_p().setVisible(false);
			vp.getId_fecha_p().setVisible(false);
			vp.getTiene_madre().setVisible(false);
			vp.getNombre_m().setVisible(false);
			vp.getId_nombre_m().setVisible(false);
			vp.getCiudad_m().setVisible(false);
			vp.getId_ciudad_m().setVisible(false);
			vp.getFecha_m().setVisible(false);
			vp.getId_fecha_m().setVisible(false);

			vp.getOutput().setText(mdao.mostrarTodo());
			break;
		}
		// Neonatos
		case "crear neonato": {
			vp.getConfirmar_crear().setVisible(true);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(false);
			vp.getNombre().setVisible(true);
			vp.getSexo().setVisible(true);
			vp.getCiudad().setVisible(true);
			vp.getFecha().setVisible(true);
			vp.getId_nombre().setVisible(true);
			vp.getId_sexo().setVisible(true);
			vp.getId_ciudad().setVisible(true);
			vp.getId_fecha().setVisible(true);
			vp.getFormato_fecha().setVisible(true);
			vp.getIndex().setVisible(false);
			vp.getId_index().setVisible(false);
			vp.getErr_scroll().setVisible(true);
			vp.getOutput().setVisible(false);
			vp.getScroll().setVisible(false);
			vp.getId_p().setVisible(false);
			vp.getId_m().setVisible(false);
			vp.getId_n().setVisible(true);
			vp.getId_g().setVisible(false);
			vp.getTiene_padre().setVisible(true);
			vp.getNombre_p().setVisible(true);
			vp.getId_nombre_p().setVisible(true);
			vp.getCiudad_p().setVisible(true);
			vp.getId_ciudad_p().setVisible(true);
			vp.getFecha_p().setVisible(true);
			vp.getId_fecha_p().setVisible(true);
			vp.getTiene_madre().setVisible(true);
			vp.getNombre_m().setVisible(true);
			vp.getId_nombre_m().setVisible(true);
			vp.getCiudad_m().setVisible(true);
			vp.getId_ciudad_m().setVisible(true);
			vp.getFecha_m().setVisible(true);
			vp.getId_fecha_m().setVisible(true);
			vp.getError().setText("");
			break;
		}
		case "eliminar neonato": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getConfirmar_del().setVisible(true);
			vp.getConfirmar_act().setVisible(false);
			vp.getNombre().setVisible(false);
			vp.getSexo().setVisible(false);
			vp.getCiudad().setVisible(false);
			vp.getFecha().setVisible(false);
			vp.getId_nombre().setVisible(false);
			vp.getId_sexo().setVisible(false);
			vp.getId_ciudad().setVisible(false);
			vp.getId_fecha().setVisible(false);
			vp.getFormato_fecha().setVisible(false);
			vp.getIndex().setVisible(true);
			vp.getId_index().setVisible(true);
			vp.getErr_scroll().setVisible(true);
			vp.getOutput().setVisible(false);
			vp.getScroll().setVisible(false);
			vp.getId_p().setVisible(false);
			vp.getId_m().setVisible(false);
			vp.getId_n().setVisible(true);
			vp.getId_g().setVisible(false);
			vp.getTiene_padre().setVisible(false);
			vp.getNombre_p().setVisible(false);
			vp.getId_nombre_p().setVisible(false);
			vp.getCiudad_p().setVisible(false);
			vp.getId_ciudad_p().setVisible(false);
			vp.getFecha_p().setVisible(false);
			vp.getId_fecha_p().setVisible(false);
			vp.getTiene_madre().setVisible(false);
			vp.getNombre_m().setVisible(false);
			vp.getId_nombre_m().setVisible(false);
			vp.getCiudad_m().setVisible(false);
			vp.getId_ciudad_m().setVisible(false);
			vp.getFecha_m().setVisible(false);
			vp.getId_fecha_m().setVisible(false);
			vp.getError().setText("");
			break;
		}
		case "editar neonato": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(true);
			vp.getNombre().setVisible(true);
			vp.getSexo().setVisible(true);
			vp.getCiudad().setVisible(true);
			vp.getFecha().setVisible(true);
			vp.getId_nombre().setVisible(true);
			vp.getId_sexo().setVisible(true);
			vp.getId_ciudad().setVisible(true);
			vp.getId_fecha().setVisible(true);
			vp.getFormato_fecha().setVisible(true);
			vp.getIndex().setVisible(true);
			vp.getId_index().setVisible(true);
			vp.getErr_scroll().setVisible(true);
			vp.getOutput().setVisible(false);
			vp.getScroll().setVisible(false);
			vp.getId_p().setVisible(false);
			vp.getId_m().setVisible(false);
			vp.getId_n().setVisible(true);
			vp.getId_g().setVisible(false);
			vp.getTiene_padre().setVisible(true);
			vp.getNombre_p().setVisible(true);
			vp.getId_nombre_p().setVisible(true);
			vp.getCiudad_p().setVisible(true);
			vp.getId_ciudad_p().setVisible(true);
			vp.getFecha_p().setVisible(true);
			vp.getId_fecha_p().setVisible(true);
			vp.getTiene_madre().setVisible(true);
			vp.getNombre_m().setVisible(true);
			vp.getId_nombre_m().setVisible(true);
			vp.getCiudad_m().setVisible(true);
			vp.getId_ciudad_m().setVisible(true);
			vp.getFecha_m().setVisible(true);
			vp.getId_fecha_m().setVisible(true);
			vp.getError().setText("");
			break;
		}
		case "mostrar neonatos": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(false);
			vp.getNombre().setVisible(false);
			vp.getSexo().setVisible(false);
			vp.getCiudad().setVisible(false);
			vp.getFecha().setVisible(false);
			vp.getId_nombre().setVisible(false);
			vp.getId_sexo().setVisible(false);
			vp.getId_ciudad().setVisible(false);
			vp.getId_fecha().setVisible(false);
			vp.getFormato_fecha().setVisible(false);
			vp.getIndex().setVisible(false);
			vp.getId_index().setVisible(false);
			vp.getErr_scroll().setVisible(false);
			vp.getOutput().setVisible(true);
			vp.getScroll().setVisible(true);
			vp.getId_p().setVisible(false);
			vp.getId_m().setVisible(false);
			vp.getId_n().setVisible(true);
			vp.getId_g().setVisible(false);
			vp.getTiene_padre().setVisible(false);
			vp.getNombre_p().setVisible(false);
			vp.getId_nombre_p().setVisible(false);
			vp.getCiudad_p().setVisible(false);
			vp.getId_ciudad_p().setVisible(false);
			vp.getFecha_p().setVisible(false);
			vp.getId_fecha_p().setVisible(false);
			vp.getTiene_madre().setVisible(false);
			vp.getNombre_m().setVisible(false);
			vp.getId_nombre_m().setVisible(false);
			vp.getCiudad_m().setVisible(false);
			vp.getId_ciudad_m().setVisible(false);
			vp.getFecha_m().setVisible(false);
			vp.getId_fecha_m().setVisible(false);

			vp.getOutput().setText(ndao.mostrarTodo());
			break;
		}
		// Ciudadanos
		case "mostrar ciudadanos": {
			vp.getConfirmar_crear().setVisible(false);
			vp.getConfirmar_del().setVisible(false);
			vp.getConfirmar_act().setVisible(false);
			vp.getNombre().setVisible(false);
			vp.getSexo().setVisible(false);
			vp.getCiudad().setVisible(false);
			vp.getFecha().setVisible(false);
			vp.getId_nombre().setVisible(false);
			vp.getId_sexo().setVisible(false);
			vp.getId_ciudad().setVisible(false);
			vp.getId_fecha().setVisible(false);
			vp.getFormato_fecha().setVisible(false);
			vp.getIndex().setVisible(false);
			vp.getId_index().setVisible(false);
			vp.getErr_scroll().setVisible(false);
			vp.getOutput().setVisible(true);
			vp.getScroll().setVisible(true);
			vp.getId_p().setVisible(false);
			vp.getId_m().setVisible(false);
			vp.getId_n().setVisible(false);
			vp.getId_g().setVisible(true);
			vp.getTiene_padre().setVisible(false);
			vp.getNombre_p().setVisible(false);
			vp.getId_nombre_p().setVisible(false);
			vp.getCiudad_p().setVisible(false);
			vp.getId_ciudad_p().setVisible(false);
			vp.getFecha_p().setVisible(false);
			vp.getId_fecha_p().setVisible(false);
			vp.getTiene_madre().setVisible(false);
			vp.getNombre_m().setVisible(false);
			vp.getId_nombre_m().setVisible(false);
			vp.getCiudad_m().setVisible(false);
			vp.getId_ciudad_m().setVisible(false);
			vp.getFecha_m().setVisible(false);
			vp.getId_fecha_m().setVisible(false);

			vp.getOutput().setText(cdao.mostrarTodo());

			break;
		}
		}

	}

}
