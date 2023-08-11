package co.edu.unbosque.controller;

import java.util.ArrayList;

import co.edu.unbosque.model.AnimalDAO;
import co.edu.unbosque.model.MarsupialDAO;
import co.edu.unbosque.model.MarsupialDTO;
import co.edu.unbosque.model.ReptilDAO;
import co.edu.unbosque.model.ReptilDTO;
import co.edu.unbosque.model.RoedorDAO;
import co.edu.unbosque.model.RoedorDTO;
import co.edu.unbosque.model.Temporal;
import co.edu.unbosque.view.Consola;

public class Controller {
	
	
	//Cedula: 1025060490
	
	
	private AnimalDAO adao;
	private ReptilDAO repdao;
	private MarsupialDAO mdao;
	private RoedorDAO roedao;
	private Consola con;
	private ArrayList<Temporal> lista;
	
	public Controller() {
		con = new Consola();
		adao = new AnimalDAO();
		repdao = new ReptilDAO();
		mdao = new MarsupialDAO();
		roedao = new RoedorDAO();
		
		
		try {
			lista = adao.cargarDesdeArchivo();
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTipo().equalsIgnoreCase("reptil")) {
					repdao.crear(new ReptilDTO(lista.get(i).getEspecie(), lista.get(i).getHabitad()));
				}
				else if(lista.get(i).getTipo().equalsIgnoreCase("marsupial")) {
					mdao.crear(new MarsupialDTO(lista.get(i).getEspecie(), lista.get(i).getHabitad()));
				}
				else if(lista.get(i).getTipo().equalsIgnoreCase("roedor")) {
					roedao.crear(new RoedorDTO(lista.get(i).getEspecie(), lista.get(i).getHabitad()));
				}
			}
			adao.agregarReptil(repdao.getLista());
			adao.agregarMarsupial(mdao.getLista());
			adao.agregarRoedor(roedao.getLista());
		} catch (ArrayIndexOutOfBoundsException e) {
			
		}
		
	}
	
	public void run() {
		con.printErrorSalto("Lectura y Escritura");
		ppal: while(true) {
			con.printSalto("Acciones: ");
			con.printSalto("1) Reptil\n2) Marsupial\n3) Roedor\n4) Todos los Animales\n5) Salir");
			int op = con.leerInt();
			switch (op) {
			case 1: {
				rep: while(true) {
					con.printSalto("Acciones: ");
					con.printSalto("1) Agregar\n2) Eliminar\n3) Actualizar\n4) Mostrar\n5) Volver");
					int op_rep = con.leerInt();
					con.quemarLinea();
					switch(op_rep) {
					case 1: {
						con.printSinSalto("Ingrese la Especie: ");
						String temp_especie = con.leerNextLine();
						con.printSinSalto("Ingrese el Habitad: ");
						String temp_hab = con.leerNextLine();
						
						repdao.crear(new ReptilDTO(temp_especie, temp_hab));
						adao.getLista().removeAll(adao.getLista());
						adao.agregarRoedor(roedao.getLista());
						adao.agregarMarsupial(mdao.getLista());
						adao.agregarReptil(repdao.getLista());
						con.printErrorSalto("Nuevo Reptil creado con exito.");
						break;
					}
					case 2: {
						con.printSalto("Ingrese la posicion que desea eliminar: ");
						con.printErrorSalto("Revise previamente la posicion a eliminar en el apartado 'Mostrar'.");
						con.printSinSalto("Posicion: ");
						int index = con.leerInt();
						if(repdao.eliminar(index)) {
							adao.getLista().removeAll(adao.getLista());
							adao.agregarRoedor(roedao.getLista());
							adao.agregarMarsupial(mdao.getLista());
							adao.agregarReptil(repdao.getLista());
							con.printErrorSalto("Posicion eliminada correctamente.");
						}else {
							con.printErrorSalto("Error: No existe la posicion.");
						}
						
						break;
					}
					case 3: {
						con.quemarLinea();
						con.printSinSalto("Ingrese la Especie: ");
						String temp_especie = con.leerNextLine();
						con.printSinSalto("Ingrese el Habitad: ");
						String temp_hab = con.leerNextLine();
						con.printSalto("Ingrese la posicion que desea eliminar: ");
						con.printErrorSalto("Revise previamente la posicion a eliminar en el apartado 'Mostrar'.");
						con.printSinSalto("Posicion: ");
						int index = con.leerInt();
						if(repdao.actualizar(index, new ReptilDTO(temp_especie, temp_hab))) {
							con.printErrorSalto("Posicion actualizada correctamente.");
							adao.getLista().removeAll(adao.getLista());
							adao.agregarRoedor(roedao.getLista());
							adao.agregarMarsupial(mdao.getLista());
							adao.agregarReptil(repdao.getLista());
						}else {
							con.printErrorSalto("Error: No existe la posicion.");
						}
						break;
					}
					case 4: {
						con.printSalto(repdao.mostrarTodo());
						break;
					}
					case 5: {
						
						break rep;
					}
					default:
					}
				}
				break;
			}
			case 2: {
				mar: while(true) {
					con.printSalto("Acciones: ");
					con.printSalto("1) Agregar\n2) Eliminar\n3) Actualizar\n4) Mostrar\n5) Volver");
					int op_mar = con.leerInt();
					switch(op_mar) {
					case 1: {
						con.quemarLinea();
						con.printSinSalto("Ingrese la Especie: ");
						String temp_especie = con.leerNextLine();
						con.printSinSalto("Ingrese el Habitad: ");
						String temp_hab = con.leerNextLine();
						
						mdao.crear(new MarsupialDTO(temp_especie, temp_hab));
						adao.getLista().removeAll(adao.getLista());
						adao.agregarRoedor(roedao.getLista());
						adao.agregarMarsupial(mdao.getLista());
						adao.agregarReptil(repdao.getLista());
						con.printErrorSalto("Nuevo Marsupial creado con exito.");
						break;
					}
					case 2: {
						con.printSalto("Ingrese la posicion que desea eliminar: ");
						con.printErrorSalto("Revise previamente la posicion a eliminar en el apartado 'Mostrar'.");
						con.printSinSalto("Posicion: ");
						int index = con.leerInt();
						if(mdao.eliminar(index)) {
							adao.getLista().removeAll(adao.getLista());
							adao.agregarRoedor(roedao.getLista());
							adao.agregarMarsupial(mdao.getLista());
							adao.agregarReptil(repdao.getLista());
							con.printErrorSalto("Posicion eliminada correctamente.");
						}else {
							con.printErrorSalto("Error: No existe la posicion.");
						}
						
						break;
					}
					case 3: {
						con.quemarLinea();
						con.printSinSalto("Ingrese la Especie: ");
						String temp_especie = con.leerNextLine();
						con.printSinSalto("Ingrese el Habitad: ");
						String temp_hab = con.leerNextLine();
						con.printSalto("Ingrese la posicion que desea eliminar: ");
						con.printErrorSalto("Revise previamente la posicion a eliminar en el apartado 'Mostrar'.");
						con.printSinSalto("Posicion: ");
						int index = con.leerInt();
						if(mdao.actualizar(index, new MarsupialDTO(temp_especie, temp_hab))) {
							adao.getLista().removeAll(adao.getLista());
							adao.agregarRoedor(roedao.getLista());
							adao.agregarMarsupial(mdao.getLista());
							adao.agregarReptil(repdao.getLista());
							con.printErrorSalto("Posicion actualizada correctamente.");
						}else {
							con.printErrorSalto("Error: No existe la posicion.");
						}
						break;
					}
					case 4: {
						con.printSalto(mdao.mostrarTodo());
						break;
					}
					case 5: {
						
						break mar;
					}
					default:
					}
				}
				break;
			}
			case 3: {
				roe: while(true) {
					con.printSalto("Acciones: ");
					con.printSalto("1) Agregar\n2) Eliminar\n3) Actualizar\n4) Mostrar\n5) Volver");
					int op_roe = con.leerInt();
					switch(op_roe) {
					case 1: {
						con.quemarLinea();
						con.printSinSalto("Ingrese la Especie: ");
						String temp_especie = con.leerNextLine();
						con.printSinSalto("Ingrese el Habitad: ");
						String temp_hab = con.leerNextLine();
						
						roedao.crear(new RoedorDTO(temp_especie, temp_hab));
						adao.getLista().removeAll(adao.getLista());
						adao.agregarRoedor(roedao.getLista());
						adao.agregarMarsupial(mdao.getLista());
						adao.agregarReptil(repdao.getLista());
						con.printErrorSalto("Nuevo Roedor creado con exito.");
						break;
					}
					case 2: {
						con.printSalto("Ingrese la posicion que desea eliminar: ");
						con.printErrorSalto("Revise previamente la posicion a eliminar en el apartado 'Mostrar'.");
						con.printSinSalto("Posicion: ");
						int index = con.leerInt();
						if(roedao.eliminar(index)) {
							adao.getLista().removeAll(adao.getLista());
							adao.agregarRoedor(roedao.getLista());
							adao.agregarMarsupial(mdao.getLista());
							adao.agregarReptil(repdao.getLista());
							con.printErrorSalto("Posicion eliminada correctamente.");
						}else {
							con.printErrorSalto("Error: No existe la posicion.");
						}
						
						break;
					}
					case 3: {
						con.quemarLinea();
						con.printSinSalto("Ingrese la Especie: ");
						String temp_especie = con.leerNextLine();
						con.printSinSalto("Ingrese el Habitad: ");
						String temp_hab = con.leerNextLine();
						con.printSalto("Ingrese la posicion que desea eliminar: ");
						con.printErrorSalto("Revise previamente la posicion a eliminar en el apartado 'Mostrar'.");
						con.printSinSalto("Posicion: ");
						int index = con.leerInt();
						if(roedao.actualizar(index, new RoedorDTO(temp_especie, temp_hab))) {
							adao.getLista().removeAll(adao.getLista());
							adao.agregarRoedor(roedao.getLista());
							adao.agregarMarsupial(mdao.getLista());
							adao.agregarReptil(repdao.getLista());
							con.printErrorSalto("Posicion actualizada correctamente.");
						}else {
							con.printErrorSalto("Error: No existe la posicion.");
						}
						break;
					}
					case 4: {
						con.printSalto(roedao.mostrarTodo());
						break;
					}
					case 5: {
						
						break roe;
					}
					default:
					}
				}
				break;
			}
			case 4: {
				con.printSalto(adao.mostrarTodo());
				break;
			}
			case 5: {
				
				break ppal;
			}
			default:
			}
		}
	}
	
}
