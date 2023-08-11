package co.edu.unbosque.controller;

import co.edu.unbosque.model.PaisDAO;
import co.edu.unbosque.model.PaisDTO;
import co.edu.unobosque.view.Consola;

public class Controller {
	
	private PaisDAO pdao;
	private Consola con;

	public Controller() {
		pdao = new PaisDAO();
		con = new Consola();
	}
	
	public void run() {
		con.imprimirErrorSalto("---Biblioteca de Paises---");
		ppal: while(true) {
			con.imprimirErrorSalto("Acciones: ");
			con.imprimirConSalto("1) Agregar\n2) Eliminar\n3) Actualizar\n4) Mostrar\n5) Salir");
			int op = con.leerEntero();
			switch (op) {
			//Agregar
			case 1: {
				con.imprimirErrorSalto("---Crear---");
				con.imprimirSinSalto("Ingrese el prefijo: ");
				int temp_prefijo = con.leerEntero();
				con.quemarLinea();
				con.imprimirSinSalto("Ingrese el nombre: ");
				String temp_nombre = con.leerLineaEntera();
				con.imprimirSinSalto("Ingrese la poblacion total: ");
				long temp_poblacion = con.leerLong();
				con.imprimirSinSalto("Ingrese el continente: ");
				String temp_continente = con.leerCadena();
				con.imprimirSinSalto("Ingrese el idioma: ");
				String temp_idioma = con.leerCadena();
				
				pdao.crear(new PaisDTO(temp_prefijo, temp_nombre, temp_poblacion, temp_continente, temp_idioma));
				con.imprimirErrorSalto("Pais '"+temp_nombre+"' creado exitosamente.");
				break;
			}
			//Eliminar
			case 2: {
				con.imprimirErrorSalto("---Eliminar---");
				con.imprimirConSalto("Ingrese la posicion del Pais a eliminar.");
				con.imprimirConSalto("Sugerencia: En el apartado 'Mostrar', revisar las posiciones de los Paises.");
				con.imprimirSinSalto("Indice: ");
				int temp_indice = con.leerEntero();
				
				if(pdao.eliminar(temp_indice)) {
					con.imprimirErrorSalto("Pais eliminado con exito.");
				}else {
					con.imprimirErrorSalto("Error en la operacion: El Pais No°"+temp_indice+" no existe.");
				}
				
				break;
			}
			//Actualizar
			case 3: {
				con.imprimirErrorSalto("---Actualizar---");
				con.imprimirSinSalto("Ingrese el prefijo: ");
				int temp_prefijo = con.leerEntero();
				con.quemarLinea();
				con.imprimirSinSalto("Ingrese el nombre: ");
				String temp_nombre = con.leerLineaEntera();
				con.imprimirSinSalto("Ingrese la poblacion total: ");
				long temp_poblacion = con.leerLong();
				con.imprimirSinSalto("Ingrese el continente: ");
				String temp_continente = con.leerCadena();
				con.imprimirSinSalto("Ingrese el idioma: ");
				String temp_idioma = con.leerCadena();
				con.imprimirConSalto("Ingrese la posicion del Pais a eliminar.");
				con.imprimirConSalto("Sugerencia: En el apartado 'Mostrar', revisar las posiciones de los Paises.");
				con.imprimirSinSalto("Indice: ");
				int temp_indice = con.leerEntero();
				
				if(pdao.actualizar(temp_indice, new PaisDTO(temp_prefijo, temp_nombre, temp_poblacion, temp_continente, temp_idioma))) {
					con.imprimirErrorSalto("Pais '"+temp_nombre+"' ahora ocupa la posicion No°"+temp_indice);
				}else {
					con.imprimirErrorSalto("Error en la operacion:  El Pais No°"+temp_indice+" no existe.");
				}
				break;
			}
			//Mostrar
			case 4: {
				con.imprimirErrorSalto("---Lista de Paises---");
				con.imprimirConSalto(pdao.mostrarTodo());
				break;
			}
			//Salir
			case 5: {
				break ppal;
			}
			default:
			}
		}
		con.imprimirErrorSinSalto("Fin del programa.");
	}
	
}
