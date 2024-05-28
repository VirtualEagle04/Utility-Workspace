package co.edu.unbosque.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import co.edu.unbosque.model.Poblacion;

public class Controller {

	private ArrayList<Poblacion> listaPob;
	private ArrayList<Poblacion> listaSort;
	private Scanner sc;

	public Controller() {
		listaPob = new ArrayList<Poblacion>();
		listaSort = new ArrayList<Poblacion>();
		sc = new Scanner(System.in);
	}

	public void run() {
		ppal: while (true) {
			System.out.println("----------------------------------");
			System.out.println(
					"1.- Nueva Poblacion\n2.- Modificar Poblacion\n3.- Eliminar Poblacion\n4.- Mostrar Poblaciones\n5.- Finalizar");
			int op = sc.nextInt();
			System.out.println("----------------------------------");
			switch (op) {
			case 1: {
				sc.nextLine();
				System.out.print("- Ingrese el nombre de la Poblacion: ");
				String nombre = sc.nextLine();
				System.out.print("- Ingrese el numero de habitantes: ");
				long hab = sc.nextLong();

				listaPob.add(new Poblacion(nombre, hab));
				System.out.println("Poblacion " + nombre + " creada.");

				break;
			}
			case 2: {
				System.out.print("-Ingrese indice de la Poblacion a modificar: ");
				int index = sc.nextInt();
				sc.nextLine();
				System.out.print("- Ingrese el nuevo nombre de la Poblacion: ");
				String nombre = sc.nextLine();
				System.out.print("- Ingrese el nuevo numero de habitantes: ");
				long hab = sc.nextLong();

				listaPob.set(index, new Poblacion(nombre, hab));
				System.out.println("Poblacion " + nombre + " modificada.");

				break;
			}
			case 3: {
				System.out.print("-Ingrese indice de la Poblacion a eliminar: ");
				int index = sc.nextInt();
				System.err.println("- Poblacion a eliminar: " + listaPob.get(index).getNombre());
				listaPob.remove(index);
				System.out.println("Poblacion eliminada.");

				break;
			}
			case 4: {
				listaSort.clear();
				listaSort.addAll(listaPob);
				System.err.println("Lista No Ordenada");
				System.out.printf("%-3s%-15s%-15s\n", "N°", "Poblacion", "Habitantes");
				
				for (int i = 0; i < listaPob.size(); i++) {
					System.out.printf("%-3d%-15s%-15d\n", i, listaPob.get(i).getNombre(), listaPob.get(i).getHabitantes());
				}
				System.err.println("Lista Ordenada");
				System.out.printf("%-3s%-15s%-15s\n", "N°", "Poblacion", "Habitantes");
				Collections.sort(listaSort, Comparator.comparingLong(Poblacion::getHabitantes).reversed());
				for (int i = 0; i < listaSort.size(); i++) {
					System.out.printf("%-3d%-15s%-15d\n", i, listaSort.get(i).getNombre(), listaSort.get(i).getHabitantes());
				}
				break;
			}
			case 5: {
				break ppal;
			}

			}
		}

	}

}
