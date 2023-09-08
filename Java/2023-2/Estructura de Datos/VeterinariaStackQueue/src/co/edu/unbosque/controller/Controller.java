package co.edu.unbosque.controller;

import co.edu.unbosque.model.AnimalDTO;
import co.edu.unbosque.model.BlanketDTO;
import co.edu.unbosque.model.persistance.AnimalDAO;
import co.edu.unbosque.model.persistance.BlanketDAO;
import co.edu.unbosque.view.Console;

public class Controller {

	private AnimalDAO adao;
	private BlanketDAO bdao;
	
	public Controller() {
		adao = new AnimalDAO();
		bdao = new BlanketDAO();
	}
	
	public void run() {
		int blanketNum;
		do {
			Console.printLine("Cuantas cobijas desea almacenar? (Min: 5 / Max: 50): ");
			blanketNum = Console.readInt();
		}while(blanketNum < 5 || blanketNum > 50);
		
		for(int i = 0; i < blanketNum; i++) {
			bdao.insert(new BlanketDTO());
		}
		
		ppal: while(true) {
			
			Console.printLine("---Veterinaria----\n1) Agregar Animal a la Fila\n2) Atender Animal de la Fila\n3) Mostrar Fila\n4) Mostrar Cobijas\n5) Salir");
			switch(Console.readInt()) {
				case 1: {
					if(bdao.getList().size() == 0) {
						Console.printErrLine("Lo sentimos. Ya hay un maximo de animales que atender por ahora.");
					}else {
						Console.burnLine();
						Console.printLine("Nombre del Animal: ");
						String name = Console.readLine();
						
						Console.printLine("Edad del Animal: ");
						int age = Console.readInt();
						Console.burnLine();
						
						Console.printLine("Especie del Animal: ");
						String specie = Console.readLine();
						
						Console.printLine("Sexo (Macho [M] / Hembra [H]): ");
						char sex = Console.readChar();
						
						if(adao.insert(new AnimalDTO(name, age, specie, sex, true))) {
							Console.printLine(name + " ha ingresado a la fila. Por favor espere su turno.");
							bdao.remove();
							Console.printErrLine("Debug | Cobijas-1");
						}else {
							Console.printErrLine("Debug | Error de agregacion.");
						}
					}
					break;
				}
				case 2: {
					if(adao.getList().size() == 0) {
						Console.printErrLine("Debug | No hay animales en espera.");
					}else {
						Console.printLine(adao.remove().getName() + " sera atendido ahora.");
						bdao.insert(new BlanketDTO());
						Console.printErrLine("Debug | Cobijas+1");
					}
					break;
				}
				case 3: {
					if(adao.getList().size() == 0) {
						Console.printErrLine("Debug | No hay animales en espera.");
					}else {
						Console.printLine(adao.display());
					}
					break;
				}
				case 4: {
					Console.printLine("Cobijas restantes: " + bdao.getList().size());
					break;
				}
				case 5: {
					break ppal;
				}
				
				default: {
					Console.printErrLine("Ingrese una operacion valida.");
					break;
				}
			}
			
			
		}
		
	}
	
}
