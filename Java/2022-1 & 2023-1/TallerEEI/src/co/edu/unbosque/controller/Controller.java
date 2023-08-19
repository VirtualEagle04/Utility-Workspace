package co.edu.unbosque.controller;

import co.edu.unbosque.model.AlienDAO;
import co.edu.unbosque.model.AlienDTO;
import co.edu.unbosque.model.AstronautaDTO;
import co.edu.unbosque.model.AstronutaDAO;
import co.edu.unbosque.model.HumanoideDAO;
import co.edu.unbosque.view.Consola;

public class Controller {

	private HumanoideDAO hdao;
	private AstronutaDAO adao;
	private AlienDAO aliendao;
	private Consola con;
	
	public Controller() {
		hdao = new HumanoideDAO();
		adao = new AstronutaDAO();
		aliendao = new AlienDAO();
		con = new Consola();
	}
	
	public void run() {
		con.imprimirConSalto("---Bienvenido a la Estacion Espacial Internacional (EEI)---");
		principal: while(true) {
			con.imprimirErrorSalto("|<--------------Menu Principal-------------->|");
			con.imprimirConSalto("Acciones: ");
			con.imprimirConSalto("1) Astronautas\n2) Alienigenas\n3) Tripulacion de la EEI\n4) Salir");
			int op = con.leerInt();
			switch (op) {
			case 1: {
				astro: while(true) {
					con.imprimirErrorSalto("|<--------------Menu de Astronautas-------------->|");
					con.imprimirConSalto("Acciones: ");
					con.imprimirConSalto("1) Agregar\n2) Eliminar\n3) Mostrar\n4) Volver");
					int op_astro = con.leerInt();
					switch (op_astro) {
					case 1: {
						con.imprimirErrorSalto("|<--------------Creacion Astronauta-------------->|");
						con.quemarLinea();
						
						String temp_nombre;
						int temp_edad;
						String temp_alimento;
						int sel_nacionalidad;
						String temp_nacionalidad = "";
						do {
							con.imprimirConSalto("Nacionalidad:\n1) Norteamericano\n2) Ruso\n3) Aleman\n4) Japones");
							sel_nacionalidad = con.leerInt();
						}while (sel_nacionalidad != 1 && sel_nacionalidad != 2 && sel_nacionalidad != 3 && sel_nacionalidad != 4);
						switch (sel_nacionalidad) {
							case 1: {
								temp_nacionalidad = "Norteamericano";
								break;
							}
							case 2: {
								temp_nacionalidad = "Ruso";
								break;
							}
							case 3: {
								temp_nacionalidad = "Aleman";
								break;
							}
							case 4: {
								temp_nacionalidad = "Japones";
								break;
							}
						default:
						}
						
						con.imprimirSinSalto("Nombre: ");
						temp_nombre = con.leerString();
						con.imprimirSinSalto("Edad: ");
						temp_edad = con.leerInt();
						con.quemarLinea();
						con.imprimirSinSalto("Alimento Favorito: ");
						temp_alimento = con.leerStringLine();
						
						adao.crear(new AstronautaDTO(temp_nombre, temp_edad, temp_nacionalidad, temp_alimento));
						con.imprimirErrorSalto("Astronauta "+temp_nombre+" creado con exito.");
						break;
					}
					case 2: {
						con.imprimirErrorSalto("|<--------------Eliminacion Astronauta-------------->|");
						con.imprimirConSalto("Ingrese la posicion del Astronauta a eliminar: ");
						con.imprimirConSalto("-Revise previamente las posiciones de los Astronautas en el apartado 'Mostrar'-");
						con.imprimirSinSalto("Posicion: ");
						int index = con.leerInt();
						
						if(adao.eliminar(index)) {
							con.imprimirErrorSalto("Astronauta No°"+index+" eliminado correctamente.");
						}else {
							con.imprimirErrorSalto("Error en la operacion: No existe el Astronauta No°"+index+".");
						}
						break;
					}
					case 3: {
						con.imprimirErrorSalto("|<--------------------------------------------------------->|");
						con.imprimirConSalto(adao.mostrarTodo());
						break;
					}
					case 4: {
						break astro;
					}
					default:
					}
				}
				break;
			}
			case 2: {
				alien: while(true) {
					con.imprimirConSalto("|<--------------Menu de Aliens-------------->|");
					con.imprimirConSalto("Acciones: ");
					con.imprimirConSalto("1) Agregar\n2) Eliminar\n3) Mostrar\n4) Volver");
					int op_alien = con.leerInt();
					switch (op_alien) {
					case 1: {
						con.imprimirErrorSalto("|<--------------Creacion Aliens-------------->|");
						con.quemarLinea();
						con.imprimirSinSalto("Nombre: ");
						String temp_nombre = con.leerString();
						con.imprimirSinSalto("Edad: ");
						int temp_edad = con.leerInt();
						con.quemarLinea();
						con.imprimirSinSalto("Nacionalidad: ");
						String temp_nacionalidad = con.leerString();
						con.imprimirSinSalto("Tipo de Reproduccion: ");
						String temp_reproduccion = con.leerString();
						con.imprimirSinSalto("Cantidad de Dedos: ");
						int temp_dedos = con.leerInt();
						
						aliendao.crear(new AlienDTO(temp_nombre, temp_edad, temp_nacionalidad, "Humanos", temp_reproduccion, temp_dedos));
						con.imprimirErrorSalto("Alien "+temp_nombre+" creado con exito.");
						break;
					}
					case 2: {
						con.imprimirErrorSalto("|<--------------Eliminacion Aliens-------------->|");
						con.imprimirConSalto("Ingrese la posicion del Alien a eliminar: ");
						con.imprimirConSalto("-Revise previamente las posiciones de los Aliens en el apartado 'Mostrar'-");
						con.imprimirSinSalto("Posicion: ");
						int index = con.leerInt();
						
						if(aliendao.eliminar(index)) {
							con.imprimirErrorSalto("Alien No°"+index+" eliminado correctamente.");
						}else {
							con.imprimirErrorSalto("Error en la operacion: No existe el Alien No°"+index+".");
						}
						break;
					}
					case 3: {
						con.imprimirErrorSalto("|<--------------------------------------------------------->|");
						con.imprimirConSalto(aliendao.mostrarTodo());
						break;
					}
					case 4: {
						break alien;
					}
					default:
					}
				}
				break;
			}
			case 3: {
				con.imprimirErrorSalto("|<--------------------------------------------------------->|");
				hdao.getLista().removeAll(hdao.getLista()); //Limpieza de Lista
				hdao.agregarDeAstronautas(adao.getLista());
				hdao.agregarDeAliens(aliendao.getLista());
				
				con.imprimirConSalto(hdao.mostrarTodo());
				
				break;
			}
			case 4: {
				break principal;
			}
			
			}
		}
		con.imprimirErrorSalto("Fin del Programa");
		
	}
	
}
