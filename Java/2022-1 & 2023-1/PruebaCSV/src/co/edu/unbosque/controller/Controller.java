package co.edu.unbosque.controller;

import java.util.Random;

import co.edu.unbosque.model.Si;
import co.edu.unbosque.model.persistance.FileHandler;

public class Controller {

	private Si sdao;

	public Controller() {
		sdao = new Si();
	}

	public void run() {
		System.out.println(sdao.mostrarEstudiantes());

		//arreglarCsv();
		
	}

	public void arreglarCsv() {

		StringBuilder sb = new StringBuilder();

		String cont = FileHandler.abrirArchivoText("datosEst.csv");

		System.out.println();

		String[] estudiantes = cont.split("\n");

		int index = 0;
		for (String s : estudiantes) {
			int municipio = (int) (Math.random() * 1120);
			int pais = (int) (Math.random() * 249);
			int ind = (int) (Math.random() * 11);
			Random aleatorio = new Random();
			if (index == 0) {
				sb.append(s + ",LugarNacimiento,FechaRegistro,NacionalExtranjero\n");
			} else {
				if (ind == 2 || ind == 6 || ind == 8) {
					int año = (aleatorio.nextInt(8) + 2015);
					sb.append(s + ",(" + sdao.getLista_paises().get(47) + "/"
							+ sdao.getLista_municipios().get(municipio) + ")," + (aleatorio.nextInt(30) + 1) + "/"
							+ (aleatorio.nextInt(12) + 1) + "/" + año + "," + "Nacional\n");
				} else {
					int año = (aleatorio.nextInt(8) + 2016);
					sb.append(s + "," + sdao.getLista_paises().get(pais) + "," + (aleatorio.nextInt(30) + 1) + "/"
							+ (aleatorio.nextInt(12) + 1) + "/" + año + "," + "Extranjero\n");
				}
			}
			index++;
		}
		System.out.println(sb.toString());
		FileHandler.escribirArchivo("datosEst.csv", sb.toString());
	}
}
