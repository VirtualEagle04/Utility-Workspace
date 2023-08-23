package controller;

import java.util.Scanner;

import model.MarcaPaqueteGomitasDAO;
import model.MarcaPaqueteGomitasDTO;

public class AplMain {

	public static void main(String[] args) {
//		MyLinkedList<Long> fico = new MyLinkedList<>();
//		fico.add(18l); // [18]
//		fico.add(13l); // [13, 18]
//		fico.add(11l); // [11, 13, 18]
//		fico.addLast(7l); // [11, 13, 18, 7]
//		fico.addLast(69l);// [11, 13, 18, 7, 69]
//		fico.addLast(420l); // [11, 13, 18, 7, 69, 420]
//		fico.addLast(8l); // [11, 13, 18, 7, 69, 420, 8]
//		System.out.println(fico.toString());

		Scanner sc = new Scanner(System.in);
		MarcaPaqueteGomitasDAO gDAO = new MarcaPaqueteGomitasDAO();

		while (true) {

			System.out.println("1) Agregar\n2) Eliminar\n3) Actualizar\n4) Mostrar\n5) Terminar Programa");
			int op = sc.nextInt();
			sc.nextLine();
			switch (op) {
			case 1: {
				System.out.print("Nombre de la marca: ");
				String nombre = sc.nextLine();
				System.out.print("Presentacion del producto: ");
				String presentacion = sc.nextLine();
				System.out.print("Precio del producto: ");
				double precio = sc.nextDouble();
				sc.nextLine();

				MarcaPaqueteGomitasDTO nuevaMarca = new MarcaPaqueteGomitasDTO(nombre, presentacion, precio);

				gDAO.agregar(nuevaMarca);

				System.out.println("Marca y producto agregados exitosamente.");
				break;
			}
			case 2: {
				System.out.print("Ingrese la posicion que desea eliminar: ");
				int pos = sc.nextInt();
				sc.nextLine();
				
				gDAO.eliminar(pos);
				System.out.println("Marca eliminada exitosamente.");
				

				break;
			}
			case 3: {
				System.out.print("Ingrese la posicion que desea actualizar: ");
				int pos = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Nombre de la marca: ");
				String nombre = sc.nextLine();
				System.out.print("Presentacion del producto: ");
				String presentacion = sc.nextLine();
				System.out.print("Precio del producto: ");
				double precio = sc.nextDouble();

				MarcaPaqueteGomitasDTO nuevaMarca = new MarcaPaqueteGomitasDTO(nombre, presentacion, precio);

				gDAO.actualizar(pos, nuevaMarca);

				System.out.println("Marca y producto actualizados exitosamente.");
				

				break;
			}
			case 4: {
				
				System.out.println(gDAO.mostrar());

				break;
			}
			case 5: {
				
				System.exit(0);

				break;
			}
			default:
				break;

			}

		}

	}

}
