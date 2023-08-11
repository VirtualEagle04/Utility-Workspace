package co.edu.unbosque.controller;

import co.edu.unbosque.model.SerieDAO;
import co.edu.unbosque.model.SerieDTO;
import co.edu.unbosque.model.VideoJuegoDAO;
import co.edu.unbosque.model.VideoJuegoDTO;
import co.edu.unbosque.view.Consola;

public class Controller {

	private Consola con;
	private VideoJuegoDAO vdao;
	private SerieDAO sdao;

	public Controller() {
		con = new Consola();
		vdao = new VideoJuegoDAO();
		sdao = new SerieDAO();
	}

	public void run() {
		con.printErrorSalto("Ingrese accion:");
		ppal: while (true) {
			con.printSalto("1) Videojuegos\n2) Series\n3) Salir");
			int op_ppal = con.leerInt();
			switch (op_ppal) {
			// Videojuegos
			case 1: {
				v: while (true) {
					con.printErrorSalto("Ingrese accion:");
					con.printSalto("1) Crear\n2) Eliminar\n3) Actualizar\n4) Mostrar\n5) Salir");
					int op_v = con.leerInt();
					switch (op_v) {
					case 1: {
						con.quemarLinea();
						con.printErrorSinSalto("Nombre: ");
						String nombre = con.leerNextLine();
						con.printErrorSinSalto("Consola: ");
						String consola = con.leerNextLine();
						con.printErrorSinSalto("Rating: ");
						String rating = con.leerNextLine();
						con.printErrorSinSalto("Tiene multijugador: ");
						boolean multjugador = con.leerNextLine().equalsIgnoreCase("si");

						vdao.crear(new VideoJuegoDTO(nombre, consola, rating, multjugador));
						con.printErrorSalto("Videojuego creado correctamente.");
						break;
					}
					case 2: {
						con.printErrorSinSalto("Ingrese la posicion a eliminar: ");
						int index = con.leerInt();

						if (vdao.eliminar(index)) {
							con.printErrorSalto("Posicion eliminada correctamente.");
						} else {
							con.printErrorSalto("No existe la posicion.");
						}
						break;
					}
					case 3: {
						con.quemarLinea();
						con.printErrorSinSalto("Nombre: ");
						String nombre = con.leerNextLine();
						con.printErrorSinSalto("Consola: ");
						String consola = con.leerNextLine();
						con.printErrorSinSalto("Rating: ");
						String rating = con.leerNextLine();
						con.printErrorSinSalto("Tiene multijugador: ");
						boolean multjugador = con.leerNextLine().equalsIgnoreCase("si");
						con.printErrorSinSalto("Ingrese la posicion a actualizar: ");
						int index = con.leerInt();

						if (vdao.actualizar(index, new VideoJuegoDTO(nombre, consola, rating, multjugador))) {
							con.printErrorSalto("Posicion actualizada correctamente.");
						} else {
							con.printErrorSalto("No existe la posicion.");
						}
						break;
					}
					case 4: {
						con.printSalto(vdao.mostrarTodo());
						break;
					}
					case 5: {
						break v;
					}
					default:
					}
				}
				break;
			}
			// Series
			case 2: {
				s: while (true) {
					con.printErrorSalto("Ingrese accion:");
					con.printSalto("1) Crear\n2) Eliminar\n3) Actualizar\n4) Mostrar\n5) Salir");
					int op_s = con.leerInt();
					switch (op_s) {
					case 1: {
						con.quemarLinea();
						con.printErrorSinSalto("Nombre: ");
						String nombre = con.leerNextLine();
						con.printErrorSinSalto("Genero: ");
						String genero = con.leerNextLine();
						con.printErrorSinSalto("Año: ");
						int año = con.leerInt();
						con.quemarLinea();
						con.printErrorSinSalto("Calificacion: ");
						String calificacion = con.leerNextLine();

						sdao.crear(new SerieDTO(nombre, genero, año, calificacion));
						con.printErrorSalto("Serie creada exitosamente");
						break;
					}
					case 2: {
						con.printErrorSinSalto("Ingrese la posicion a eliminar: ");
						int index = con.leerInt();

						if (sdao.eliminar(index)) {
							con.printErrorSalto("Posicion eliminada correctamente.");
						} else {
							con.printErrorSalto("No existe la posicion.");
						}
						break;
					}
					case 3: {
						con.quemarLinea();
						con.printErrorSinSalto("Nombre: ");
						String nombre = con.leerNextLine();
						con.printErrorSinSalto("Genero: ");
						String genero = con.leerNextLine();
						con.printErrorSinSalto("Año: ");
						int año = con.leerInt();
						con.quemarLinea();
						con.printErrorSinSalto("Calificacion: ");
						String calificacion = con.leerNextLine();
						con.printErrorSinSalto("Ingrese la posicion a actualizar: ");
						int index = con.leerInt();

						if (sdao.actualizar(index, new SerieDTO(nombre, genero, año, calificacion))) {
							con.printErrorSalto("Posicion actualizada correctamente.");
						} else {
							con.printErrorSalto("No existe la posicion.");
						}
						break;
					}
					case 4: {
						con.printSalto(sdao.mostrarTodo());
						break;
					}
					case 5: {
						break s;
					}
					default:
					}
				}
				break;
			}
			case 3: {
				break ppal;
			}
			default:
			}
		}
		con.printErrorSalto("Fin del Programa.");
	}

}
