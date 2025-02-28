package co.edu.unbosque.controlador;

import java.util.Scanner;

import co.edu.unbosque.modulo.Galletas;
import co.edu.unbosque.modulo.Huevos;
import co.edu.unbosque.modulo.Leche;
import co.edu.unbosque.modulo.Pan;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Desea pan? (true/false)");
		boolean desea_pan = sc.nextBoolean();
		if (desea_pan) {
			sc.nextLine();
			System.out.println("Ingrese el tipo de pan: ");
			String a = sc.nextLine();
			System.out.println("Ingrese la cantidad entera deseada: ");
			int b = sc.nextInt();
			sc.nextLine();
			System.out.println("Ingrese la temperatura deseada: ");
			String c = sc.nextLine();
			System.out.println("Tiene azucar? (true/false)");
			boolean d = sc.nextBoolean();
			sc.nextLine();
			System.out.println("Es integral? (true/false):");
			boolean e = sc.nextBoolean();
			sc.nextLine();

			Pan pan1 = new Pan(a, b, c, d, e);
			System.out.println("Su orden de pan es la siguiente: ");
			System.out.println("Tipo de pan: " + pan1.getTipo_pan());
			System.out.println("Cantidad de pan: " + pan1.getCantidad_unidades());
			System.out.println("Temperatura: " + pan1.getTemperatura());
			System.out.println("Azucar: " + pan1.isTiene_azucar());
			System.out.println("Integral: " + pan1.isEs_integral());
		}
		System.out.println("Desea leche? (true/false)");
		boolean desea_leche = sc.nextBoolean();
		if (desea_leche == true) {
			sc.nextLine();
			System.out.println("Cual es la marca de la leche?:");
			String marca = sc.nextLine();
			System.out.println("Cual es la cantidad de litos que desea? Resulta que nuestros proveedores solo tienen volumenes enteros:");
			int litros = sc.nextInt();
			sc.nextLine();
			System.out.println("Es entera? (true/false)");
			boolean es_entera = sc.nextBoolean();
			sc.nextLine();
			System.out.println("Tiene lactosa? (true/false)");
			boolean tiene_lactosa = sc.nextBoolean();
			sc.nextLine();
			System.out.println("Ingrese el tipo de empaque (bolsa/caja):");
			String empaque = sc.nextLine();

			Leche leche1 = new Leche(marca, litros, es_entera, tiene_lactosa, empaque);
			System.out.println("Su orden de leche es la siguiente: ");
			System.out.println("Marca: " + leche1.getMarca());
			System.out.println("Litros: " + leche1.getLitros_enteros());
			System.out.println("Entera: " + leche1.isEs_entera());
			System.out.println("Lactosa: " + leche1.isTiene_lactosa());
			System.out.println("Empaque: " + leche1.getEmpaque());

		}
		System.out.println("Desea huevos? (true/false)");
		boolean desea_huevos = sc.nextBoolean();
		if (desea_huevos == true) {
			sc.nextLine();
			System.out.println("Cual es el tipo de huevo?:");
			String tipo = sc.nextLine();
			System.out.println("Cuantas cajas de huevos desea?");
			int unidades = sc.nextInt();
			sc.nextLine();
			System.out.println("Desea su entrega de huevos a domicilio? (true/false)");
			boolean domicilio = sc.nextBoolean();
			sc.nextLine();
			System.out.println("Cual es su distribuidor por excelencia?:");
			String distribuidor = sc.nextLine();
			System.out.println("Que tamano de huevos desea?");
			String tamano = sc.nextLine();
			
			Huevos huevo1 = new Huevos(tipo, unidades, domicilio, distribuidor, tamano);
			System.out.println("Su orden de huevos es la siguiente: ");
			System.out.println("Tipo de huevo: " + huevo1.getTipo_de_huevo());
			System.out.println("Unidades por caja: " + huevo1.getUnidades_por_caja());
			System.out.println("A domicilio: " + huevo1.isA_domicilio());
			System.out.println("Distribuidor: " + huevo1.getDistribuidor());
			System.out.println("Tama�o: " + huevo1.getTamano());
		}
		System.out.println("Desea galletas? (true/false)");
		boolean desea_galletas = sc.nextBoolean();
		if(desea_galletas == true) {
			sc.nextLine();
			System.out.println("Que marca de galletas desea?");
			String marca = sc.nextLine();
			System.out.println("Desea azucar en sus galletas? (true/false)");
			boolean azucar = sc.nextBoolean();
			sc.nextLine();
			System.out.println("Desea que sus galletas sean integrales? (true/false);");
			boolean integral = sc.nextBoolean();
			sc.nextLine();
			System.out.println("Cuantos empaques quiere de galletas?");
			int cantidad = sc.nextInt();
			sc.nextLine();
			System.out.println("Desea que sus galletas sean de trigo? (true/false):");
			boolean trigo = sc.nextBoolean();
			sc.nextLine();
			
			Galletas galleta1 = new Galletas(marca, azucar, integral, cantidad, trigo);
			System.out.println("Su orden de huevos es la siguiente: ");
			System.out.println("Marca: " + galleta1.getMarca());
			System.out.println("Azucar: " + galleta1.isTiene_azucar());
			System.out.println("Integral: " + galleta1.isEs_integral());
			System.out.println("Unidades: " + galleta1.getUnidades_por_empaque());
			System.out.println("Trigo: " + galleta1.isDe_trigo());
		}
		System.out.println("Perfecto, muchas gracias por la compra.");
	}
}
