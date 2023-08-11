package co.edu.unbosque.controller;

import java.util.ArrayList;

import co.edu.unbosque.model.AnimalDAO;
import co.edu.unbosque.model.AnimalDTO;
import co.edu.unbosque.model.GatoDAO;
import co.edu.unbosque.model.GatoDTO;
import co.edu.unbosque.model.LagartijaDAO;
import co.edu.unbosque.model.LagartijaDTO;
import co.edu.unbosque.model.PerroDAO;
import co.edu.unbosque.model.PerroDTO;
import co.edu.unbosque.view.Consola;

public class Controller {
	
	private AnimalDAO adao;
	private PerroDAO pdao;
	private GatoDAO gdao;
	private LagartijaDAO ldao;
	private Consola con;
	private ArrayList<AnimalDTO> temp_animales;
	
	public Controller() {	
		adao = new AnimalDAO();
		pdao = new PerroDAO();
		gdao = new GatoDAO();
		ldao = new LagartijaDAO();
		con = new Consola();
	}
	
	public void run() {
		
		
//		pdao.crear(new PerroDTO("Javier", "Suba", 11, "No Tiene", true, "Ingeniero", "Bicho"));
//		gdao.crear(new GatoDTO("Juanes", "Tierras de Ark", 12, "No Tiene", true, "Ingeniero", 0f));
//		ldao.crear(new LagartijaDTO("Maria Amparo Mejia Alias: Lapras", "Tierras de -iq", -100, "No Tiene", false, "La picha"));
//		

//		
//		con.imprimirSinSalto(adao.mostrarTodo());
		
		
		
		con.imprimirConSalto("---Bienveido a la Veterinaria Fico---");
		principal: while (true) {
			con.imprimirConSalto("Que desea hacer:\n1) Perros (Agregar, Eliminar, Mostrar)\n2) "
					+ "Gatos (Agregar, Eliminar, Mostrar)\n3) Lagartijas (Agregar, Eliminar, Mostrar)\n4) "
					+ "Nuevo Animal\n5) Mostrar todos los Animales\n6) Salir");
			int opp = con.leerInt();
			switch (opp) {
			case 1: {
				perros: while (true) {
					con.imprimirConSalto("1) Agregar\n2) Eliminar\n3) Mostrar\n4) Volver");
					int op_perros = con.leerInt();
					switch (op_perros) {
					case 1: {
						con.quemarLinea();
						con.imprimirSinSalto("Nombre: ");
						String temp_nombre = con.leerStringLine();
						con.imprimirSinSalto("Habitad: ");
						String temp_habitad = con.leerStringLine();
						con.imprimirSinSalto("Nivel de Peligro: ");
						int temp_peligro = con.leerInt();
						con.quemarLinea();
						con.imprimirSinSalto("Tipo de Reproduccion: ");
						String temp_rep = con.leerStringLine();
						con.imprimirSinSalto("Tiene Pelaje (si/no): ");
						String temp_pelaje = con.leerStringLine();
						con.imprimirSinSalto("Raza: ");
						String temp_raza = con.leerStringLine();
						con.imprimirSinSalto("Alimento Favorito: ");
						String temp_alimento = con.leerStringLine();
						
						pdao.crear(new PerroDTO(temp_nombre, temp_habitad, temp_peligro, temp_rep, temp_pelaje.contains("si")? true : false, temp_raza, temp_alimento));
						con.imprimirErrorSalto("Perro creado correctamente.");
						
						break;
					}
					case 2: {
						con.imprimirConSalto("Sugerencia: Revise las posiciones en el apartado 'Mostrar'");
						con.imprimirSinSalto("Ingrese la posicion del Perro a eliminar: ");
						int index = con.leerInt();
						
						if(pdao.eliminar(index, 1)) {
							con.imprimirErrorSalto("Perro eliminado correctamente.");
						}else {
							con.imprimirErrorSalto("Error en la operacion.");
						}
						break;
					}
					case 3: {
						con.imprimirConSalto(pdao.mostrarTodo());
						break;
					}
					case 4: {
						
						break perros;
					}
					default: 
					}
					break;
				}
			}
			case 2: {
				gatos: while (true) {
					con.imprimirConSalto("1) Agregar\n2) Eliminar\n3) Mostrar\n4) Volver");
					int op_gatos = con.leerInt();
					switch (op_gatos) {
					case 1: {
						con.quemarLinea();
						con.imprimirSinSalto("Nombre: ");
						String temp_nombre = con.leerStringLine();
						con.imprimirSinSalto("Habitad: ");
						String temp_habitad = con.leerStringLine();
						con.imprimirSinSalto("Nivel de Peligro: ");
						int temp_peligro = con.leerInt();
						con.quemarLinea();
						con.imprimirSinSalto("Tipo de Reproduccion: ");
						String temp_rep = con.leerStringLine();
						con.imprimirSinSalto("Tiene Pelaje (si/no): ");
						String temp_pelaje = con.leerStringLine();
						con.imprimirSinSalto("Raza: ");
						String temp_raza = con.leerStringLine();
						con.imprimirSinSalto("Horas de Sueño: ");
						float temp_horas = con.leerFloat();
						
						gdao.crear(new GatoDTO(temp_nombre, temp_habitad, temp_peligro, temp_rep, temp_pelaje.contains("si")? true : false, temp_raza, temp_horas));
						con.imprimirErrorSalto("Gato creado correctamente.");
						
						break;
					}
					case 2: {
						con.imprimirConSalto("Sugerencia: Revise las posiciones en el apartado 'Mostrar'");
						con.imprimirSinSalto("Ingrese la posicion del Perro a eliminar: ");
						int index = con.leerInt();
						
						if(gdao.eliminar(index, 1)) {
							con.imprimirErrorSalto("Gato eliminado correctamente.");
						}else {
							con.imprimirErrorSalto("Error en la operacion.");
						}
						break;
					}
					case 3: {
						con.imprimirConSalto(gdao.mostrarTodo());
						break;
					}
					case 4: {
						
						break gatos;
					}
					default: 
					}
				}
				
				break;
			}
			case 3: {
				lagartijas: while (true) {
					con.imprimirConSalto("1) Agregar\n2) Eliminar\n3) Mostrar\n4) Volver");
					int op_lagartijas = con.leerInt();
					switch (op_lagartijas) {
					case 1: {
						con.quemarLinea();
						con.imprimirSinSalto("Nombre: ");
						String temp_nombre = con.leerStringLine();
						con.imprimirSinSalto("Habitad: ");
						String temp_habitad = con.leerStringLine();
						con.imprimirSinSalto("Nivel de Peligro: ");
						int temp_peligro = con.leerInt();
						con.quemarLinea();
						con.imprimirSinSalto("Tipo de Reproduccion: ");
						String temp_rep = con.leerStringLine();
						con.imprimirSinSalto("Tiene Pelaje (si/no): ");
						String temp_pelaje = con.leerStringLine();
						con.imprimirSinSalto("Comida Favorita: ");
						String temp_comida = con.leerStringLine();
						
						ldao.crear(new LagartijaDTO(temp_nombre, temp_habitad, temp_peligro, temp_rep, temp_pelaje.contains("si")? true : false, temp_comida));
						con.imprimirErrorSalto("Lagartija creada correctamente.");
						
						break;
					}
					case 2: {
						con.imprimirConSalto("Sugerencia: Revise las posiciones en el apartado 'Mostrar'");
						con.imprimirSinSalto("Ingrese la posicion del Perro a eliminar: ");
						int index = con.leerInt();
						
						if(ldao.eliminar(index, 1)) {
							con.imprimirErrorSalto("Lagartija eliminada correctamente.");
						}else {
							con.imprimirErrorSalto("Error en la operacion.");
						}
						break;
					}
					case 3: {
						con.imprimirConSalto(ldao.mostrarTodo());
						break;
					}
					case 4: {
						
						break lagartijas;
					}
					default: 
					}
				}
				
				break;
			}
			case 4: {
				animales: while (true) {
					con.imprimirConSalto("1) Agregar\n2) Eliminar\n3) Mostrar\n4) Volver");
					int op_lagartijas = con.leerInt();
					switch (op_lagartijas) {
					case 1: {
						con.quemarLinea();
						con.imprimirSinSalto("Nombre: ");
						String temp_nombre = con.leerStringLine();
						con.imprimirSinSalto("Habitad: ");
						String temp_habitad = con.leerStringLine();
						con.imprimirSinSalto("Nivel de Peligro: ");
						int temp_peligro = con.leerInt();
						con.quemarLinea();
						con.imprimirSinSalto("Tipo de Reproduccion: ");
						String temp_rep = con.leerStringLine();
						con.imprimirSinSalto("Tiene Pelaje (si/no): ");
						String temp_pelaje = con.leerStringLine();
						
						adao.crear(new AnimalDTO(temp_nombre, temp_habitad, temp_peligro, temp_rep, temp_pelaje.contains("si")? true : false));
						con.imprimirErrorSalto("Animal creado correctamente.");
						
						break;
					}
					case 2: {
						con.imprimirConSalto("Sugerencia: Revise las posiciones en el apartado 'Mostrar'");
						con.imprimirSinSalto("Ingrese la posicion del Perro a eliminar: ");
						int index = con.leerInt();
						
						if(adao.eliminar(index, 1)) {
							con.imprimirErrorSalto("Animal eliminado correctamente.");
						}else {
							con.imprimirErrorSalto("Error en la operacion.");
						}
						break;
					}
					case 3: {
						con.imprimirConSalto(ldao.mostrarTodo());
						break;
					}
					case 4: {
						
						break animales;
					}
					default: 
					}
				}
				
				break;
			}
			case 5: {
				temp_animales = adao.getLista();
				adao.getLista().removeAll(temp_animales);
				adao.agregarDePerros(pdao.getLista());
				adao.agregarDeGatos(gdao.getLista());
				adao.agregarDeLagartijas(ldao.getLista());
				adao.getLista().addAll(temp_animales);
				con.imprimirConSalto(adao.mostrarTodo());
				
				break;
			}
			case 6: {
				
				
				break principal;
			}
			default: 
			}	
		}
		con.imprimirErrorNoSalto("Fin del Programa");
	}
}
