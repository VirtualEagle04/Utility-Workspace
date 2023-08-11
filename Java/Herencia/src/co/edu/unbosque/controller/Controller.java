package co.edu.unbosque.controller;

import co.edu.unbosque.model.AguilaDAO;
import co.edu.unbosque.model.AnimalDTO;
import co.edu.unbosque.model.AracnidoDAO;
import co.edu.unbosque.model.BallenaDAO;
import co.edu.unbosque.model.FelinoDAO;
import co.edu.unbosque.model.HumanoDAO;
import co.edu.unbosque.model.TiburonDAO;
import co.edu.unbosque.view.Console;

public class Controller {

	private AnimalDTO adto;
	private TiburonDAO tdao;
	private BallenaDAO bdao;
	private FelinoDAO fdao;
	private HumanoDAO hdao;
	private AracnidoDAO ardao;
	private AguilaDAO agdao;
	private Console con;

	public Controller() {
		adto = new AnimalDTO();
		tdao = new TiburonDAO();
		bdao = new BallenaDAO();
		fdao = new FelinoDAO();
		hdao = new HumanoDAO();
		ardao = new AracnidoDAO();
		agdao = new AguilaDAO();
		con = new Console();
	}
	
	public void run() {
		con.imprimirConSalto("------Bienvenido a la Biblioteca Taxonomica------");
		principal: while(true){
			con.imprimirConSalto("Ingrese lo que quiera realizar: ");
			con.imprimirConSalto("1) Tiburon\n2) Aguila\n3) Ballena\n4) Felino\n5) Aracnido\n6) Humano\n7) Salir");
			
			int op = con.leerEntero();
			switch(op) {
			case 1: {
				con.imprimirConSalto("-------------------------------------------------------------------------");
				tiburon: while(true) {
					con.imprimirConSalto("Ingrese lo que quiera realizar: ");
					con.imprimirConSalto("1) Agregar\n2) Eliminar\n3) Actualizar\n4) Mostrar\n5) Volver");
					
					int op_tib = con.leerEntero();
					switch (op_tib) {
					case 1: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.quemarLinea();
						con.imprimirSinSalto("Ingrese la subespecie: ");
						String temp_subespecie = con.leerLineaEntera();
						con.imprimirSinSalto("Ingrese la cantidad de dientes: ");
						int temp_dientes = con.leerEntero();
						con.quemarLinea();
						con.imprimirSinSalto("Ingrese el tipo de mandibula: ");
						String temp_mandibula = con.leerLineaEntera();
						
						tdao.crear(temp_subespecie, temp_dientes, temp_mandibula);
						con.imprimirError("Tiburon creado con exito");
						con.imprimirConSalto("-------------------------------------------------------------------------");


						break;
					}
					case 2: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.quemarLinea();
						con.imprimirConSalto("Ingrese la posicion del Tiburon que desea eliminar: ");
						con.imprimirConSalto("Sugerencia: En el apartado 'Mostrar' indentifique las posiciones.");
						con.imprimirSinSalto("Indice: ");
						int temp_indice = con.leerEntero();
						if(tdao.eliminarIndex(temp_indice)){
							con.imprimirError("Tiburon "+temp_indice+" eliminado con exito.");
						}else{
							con.imprimirError("Error en la operacion");
						}
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 3: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.quemarLinea();
						con.imprimirConSalto("Ingrese la posicion del Tiburon que desea editar: ");
						con.imprimirConSalto("Sugerencia: En el apartado 'Mostrar' indentifique las posiciones.");
						con.imprimirSinSalto("Indice: ");
						int temp_indice = con.leerEntero();
						con.quemarLinea();
						con.imprimirSinSalto("Ingrese la subespecie: ");
						String temp_subespecie = con.leerLineaEntera();
						con.imprimirSinSalto("Ingrese la cantidad de dientes: ");
						int temp_dientes = con.leerEntero();
						con.quemarLinea();
						con.imprimirSinSalto("Ingrese el tipo de mandibula: ");
						String temp_mandibula = con.leerLineaEntera();
						if(tdao.actualizarIndex(temp_indice, temp_subespecie, temp_dientes, temp_mandibula)){
							con.imprimirError("Tiburon "+temp_indice+" actualizado con exito.");
						}else{
							con.imprimirError("Error en la operacion.");
						}
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 4: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.imprimirConSalto(tdao.mostrarTodo());
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 5: {
						break tiburon;
					}
					default:
					}
				}
				con.imprimirConSalto("-------------------------------------------------------------------------");
				break;
			}
			case 2: {
				con.imprimirConSalto("-------------------------------------------------------------------------");
				aguila: while(true) {
					con.imprimirConSalto("Ingrese lo que quiera realizar: ");
					con.imprimirConSalto("1) Agregar\n2) Eliminar\n3) Actualizar\n4) Mostrar\n5) Volver");
					
					int op_ag = con.leerEntero();
					switch (op_ag) {
					case 1: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.quemarLinea();
						con.imprimirSinSalto("Ingrese la longitud de las alas: ");
						float temp_alas = con.leerFloat();
						con.quemarLinea();
						con.imprimirSinSalto("Ingrese el tipo de pico: ");
						String temp_pico = con.leerLineaEntera();

						agdao.crear(temp_alas, temp_pico);
						con.imprimirError("Tiburon creado con exito");
						
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 2: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.quemarLinea();
						con.imprimirConSalto("Ingrese la posicion del Aguila que desea eliminar: ");
						con.imprimirConSalto("Sugerencia: En el apartado 'Mostrar' indentifique las posiciones.");
						con.imprimirSinSalto("Indice: ");
						int temp_indice = con.leerEntero();
						if(agdao.eliminarIndex(temp_indice)){
							con.imprimirError("Aguila "+temp_indice+" eliminada con exito.");
						}else{
							con.imprimirError("Error en la operacion");
						}
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 3: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.quemarLinea();
						con.imprimirConSalto("Ingrese la posicion del Aguila que desea editar: ");
						con.imprimirConSalto("Sugerencia: En el apartado 'Mostrar' indentifique las posiciones.");
						con.imprimirSinSalto("Indice: ");
						int temp_indice = con.leerEntero();
						con.quemarLinea();
						con.imprimirSinSalto("Ingrese la longitud de las alas: ");
						float temp_alas = con.leerFloat();
						con.quemarLinea();
						con.imprimirSinSalto("Ingrese el tipo de pico: ");
						String temp_pico = con.leerLineaEntera();
						if(agdao.actualizarIndex(temp_indice, temp_alas, temp_pico)){
							con.imprimirError("Aguila "+temp_indice+" actualizada con exito.");
						}else{
							con.imprimirError("Error en la operacion.");
						}
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 4: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.imprimirConSalto(agdao.mostrarTodo());
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 5: {
						break aguila;
					}
					default:
					}
				}
				con.imprimirConSalto("-------------------------------------------------------------------------");
				break;
			}
			case 3: {
				con.imprimirConSalto("-------------------------------------------------------------------------");
				ballena: while(true) {
					con.imprimirConSalto("Ingrese lo que quiera realizar: ");
					con.imprimirConSalto("1) Agregar\n2) Eliminar\n3) Actualizar\n4) Mostrar\n5) Volver");
					
					int op_ball = con.leerEntero();
					switch (op_ball) {
					case 1: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.quemarLinea();
						con.imprimirSinSalto("Ingrese el oceano de procedencia: ");
						String temp_oceano = con.leerLineaEntera();
						con.imprimirSinSalto("Ingrese la duracion de la migracion (meses): ");
						float temp_duracion = con.leerFloat();

						bdao.crear(temp_oceano, temp_duracion);
						con.imprimirError("Ballena creada con exito");
						
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 2: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.quemarLinea();
						con.imprimirConSalto("Ingrese la posicion de la Ballena que desea eliminar: ");
						con.imprimirConSalto("Sugerencia: En el apartado 'Mostrar' indentifique las posiciones.");
						con.imprimirSinSalto("Indice: ");
						int temp_indice = con.leerEntero();
						if(bdao.eliminarIndex(temp_indice)){
							con.imprimirError("Ballena "+temp_indice+" eliminada con exito.");
						}else{
							con.imprimirError("Error en la operacion");
						}
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 3: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.quemarLinea();
						con.imprimirConSalto("Ingrese la posicion del Aguila que desea editar: ");
						con.imprimirConSalto("Sugerencia: En el apartado 'Mostrar' indentifique las posiciones.");
						con.imprimirSinSalto("Indice: ");
						int temp_indice = con.leerEntero();
						con.quemarLinea();
						con.imprimirSinSalto("Ingrese el oceano de procedencia: ");
						String temp_oceano = con.leerLineaEntera();
						con.imprimirSinSalto("Ingrese la duracion de la migracion (meses): ");
						float temp_duracion = con.leerFloat();
						if(bdao.actualizarIndex(temp_indice, temp_oceano, temp_duracion)){
							con.imprimirError("Ballena "+temp_indice+" actualizada con exito.");
						}else{
							con.imprimirError("Error en la operacion.");
						}
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 4: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.imprimirConSalto(bdao.mostrarTodo());
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 5: {
						break ballena;
					}
					default:
					}
				}
				con.imprimirConSalto("-------------------------------------------------------------------------");
				break;
			}
			case 4: {
				con.imprimirConSalto("-------------------------------------------------------------------------");
				felino: while(true) {
					con.imprimirConSalto("Ingrese lo que quiera realizar: ");
					con.imprimirConSalto("1) Agregar\n2) Eliminar\n3) Actualizar\n4) Mostrar\n5) Volver");
					
					int op_fel = con.leerEntero();
					switch (op_fel) {
					case 1: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.quemarLinea();
						con.imprimirSinSalto("Ingrese si es domesitico (si/no): ");
						String temp_domestico = con.leerCadena();
						con.imprimirSinSalto("Ingrese el tipo de morfologia: ");
						String temp_morfologia = con.leerLineaEntera();

						fdao.crear(temp_domestico.equalsIgnoreCase("si")?true : false, temp_morfologia);
						con.imprimirError("Felino creado con exito");
						
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 2: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.quemarLinea();
						con.imprimirConSalto("Ingrese la posicion del Felino que desea eliminar: ");
						con.imprimirConSalto("Sugerencia: En el apartado 'Mostrar' indentifique las posiciones.");
						con.imprimirSinSalto("Indice: ");
						int temp_indice = con.leerEntero();
						if(fdao.eliminarIndex(temp_indice)){
							con.imprimirError("Felino "+temp_indice+" eliminado con exito.");
						}else{
							con.imprimirError("Error en la operacion");
						}
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 3: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.quemarLinea();
						con.imprimirConSalto("Ingrese la posicion del Aguila que desea editar: ");
						con.imprimirConSalto("Sugerencia: En el apartado 'Mostrar' indentifique las posiciones.");
						con.imprimirSinSalto("Indice: ");
						int temp_indice = con.leerEntero();
						con.quemarLinea();
						con.imprimirSinSalto("Ingrese si es domesitico (si/no): ");
						String temp_domestico = con.leerCadena();
						con.imprimirSinSalto("Ingrese el tipo de morfologia: ");
						String temp_morfologia = con.leerLineaEntera();
						if(fdao.actualizarIndex(temp_indice, temp_domestico.equalsIgnoreCase("si")?true : false, temp_morfologia)){
							con.imprimirError("Felino "+temp_indice+" actualizado con exito.");
						}else{
							con.imprimirError("Error en la operacion.");
						}
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 4: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.imprimirConSalto(fdao.mostrarTodo());
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 5: {
						break felino;
					}
					default:
					}
				}
				con.imprimirConSalto("-------------------------------------------------------------------------");
				break;
			}
			case 5: {
				con.imprimirConSalto("-------------------------------------------------------------------------");
				aracnido: while(true) {
					con.imprimirConSalto("Ingrese lo que quiera realizar: ");
					con.imprimirConSalto("1) Agregar\n2) Eliminar\n3) Actualizar\n4) Mostrar\n5) Volver");
					
					int op_ar = con.leerEntero();
					switch (op_ar) {
					case 1: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.quemarLinea();
						con.imprimirSinSalto("Ingrese si es toxico (si/no): ");
						String temp_toxico = con.leerCadena();
						con.imprimirSinSalto("Ingrese el color: ");
						String temp_color = con.leerLineaEntera();

						ardao.crear(temp_toxico.equalsIgnoreCase("si")?true : false, temp_color);
						con.imprimirError("Aracnido creado con exito");
						
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 2: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.quemarLinea();
						con.imprimirConSalto("Ingrese la posicion del Aracnido que desea eliminar: ");
						con.imprimirConSalto("Sugerencia: En el apartado 'Mostrar' indentifique las posiciones.");
						con.imprimirSinSalto("Indice: ");
						int temp_indice = con.leerEntero();
						if(ardao.eliminarIndex(temp_indice)){
							con.imprimirError("Aracnido "+temp_indice+" eliminado con exito.");
						}else{
							con.imprimirError("Error en la operacion");
						}
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 3: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.quemarLinea();
						con.imprimirConSalto("Ingrese la posicion del Aguila que desea editar: ");
						con.imprimirConSalto("Sugerencia: En el apartado 'Mostrar' indentifique las posiciones.");
						con.imprimirSinSalto("Indice: ");
						int temp_indice = con.leerEntero();
						con.quemarLinea();
						con.imprimirSinSalto("Ingrese si es toxico (si/no): ");
						String temp_toxico = con.leerCadena();
						con.imprimirSinSalto("Ingrese el color: ");
						String temp_color = con.leerLineaEntera();
						if(ardao.actualizarIndex(temp_indice, temp_toxico.equalsIgnoreCase("si")?true : false, temp_color)){
							con.imprimirError("Aracnido "+temp_indice+" actualizado con exito.");
						}else{
							con.imprimirError("Error en la operacion.");
						}
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 4: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.imprimirConSalto(ardao.mostrarTodo());
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 5: {
						break aracnido;
					}
					default:
					}
				}
				con.imprimirConSalto("-------------------------------------------------------------------------");
				break;
			}
			case 6: {
				con.imprimirConSalto("-------------------------------------------------------------------------");
				humano: while(true) {
					con.imprimirConSalto("Ingrese lo que quiera realizar: ");
					con.imprimirConSalto("1) Agregar\n2) Eliminar\n3) Actualizar\n4) Mostrar\n5) Volver");
					
					int op_ar = con.leerEntero();
					switch (op_ar) {
					case 1: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.quemarLinea();
						con.imprimirSinSalto("Ingrese color del piel: ");
						String temp_color = con.leerLineaEntera();
						con.imprimirSinSalto("Ingrese el nombre propio: ");
						String temp_nombre = con.leerLineaEntera();

						hdao.crear(temp_color, temp_nombre);
						con.imprimirError("Humano creado con exito");
						
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 2: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.quemarLinea();
						con.imprimirConSalto("Ingrese la posicion del Humano que desea eliminar: ");
						con.imprimirConSalto("Sugerencia: En el apartado 'Mostrar' indentifique las posiciones.");
						con.imprimirSinSalto("Indice: ");
						int temp_indice = con.leerEntero();
						if(hdao.eliminarIndex(temp_indice)){
							con.imprimirError("Humano "+temp_indice+" eliminado con exito.");
						}else{
							con.imprimirError("Error en la operacion");
						}
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 3: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.quemarLinea();
						con.imprimirConSalto("Ingrese la posicion del Humano que desea editar: ");
						con.imprimirConSalto("Sugerencia: En el apartado 'Mostrar' indentifique las posiciones.");
						con.imprimirSinSalto("Indice: ");
						int temp_indice = con.leerEntero();
						con.quemarLinea();
						con.imprimirSinSalto("Ingrese color del piel: ");
						String temp_color = con.leerLineaEntera();
						con.imprimirSinSalto("Ingrese el nombre propio: ");
						String temp_nombre = con.leerLineaEntera();
						if(hdao.actualizarIndex(temp_indice, temp_color, temp_nombre)){
							con.imprimirError("Humano "+temp_indice+" actualizado con exito.");
						}else{
							con.imprimirError("Error en la operacion.");
						}
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 4: {
						con.imprimirConSalto("-------------------------------------------------------------------------");
						con.imprimirConSalto(hdao.mostrarTodo());
						con.imprimirConSalto("-------------------------------------------------------------------------");
						break;
					}
					case 5: {
						break humano;
					}
					default:
					}
				}
				con.imprimirConSalto("-------------------------------------------------------------------------");
				break;
			}
			case 7: {
				
				
				break principal;
			}
			
			default:
			}
			
			
			
		}
		
		
	}

}
