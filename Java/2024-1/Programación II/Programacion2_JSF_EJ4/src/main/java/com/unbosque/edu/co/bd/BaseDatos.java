package com.unbosque.edu.co.bd;

import java.util.ArrayList;
import com.unbosque.edu.co.entity.Estudiante;

public class BaseDatos {
	public static ArrayList<Estudiante> tablaEstudiante = new ArrayList<Estudiante>();

	static {
		Estudiante e = new Estudiante();
		e.setApellidos("Rojas");
		e.setIdentificacion(1);
		e.setInactivo(true);
		e.setNombres("Wilson");
		e.setPromedio(5.0);
		tablaEstudiante.add(e);
	}
}
