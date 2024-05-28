package com.unbosque.edu.co.dao;

import java.util.ArrayList;

import com.unbosque.edu.co.bd.BaseDatos;
import com.unbosque.edu.co.entity.Estudiante;

public class EstudianteDAO {

	public EstudianteDAO() {
	}

	public boolean insertar(Estudiante estudianteNuevo) {
		return BaseDatos.tablaEstudiante.add(estudianteNuevo);
	}

	public boolean actualizar(Estudiante estudianteExistente) {
		for (int i = 0; i < BaseDatos.tablaEstudiante.size(); i++) {
			Estudiante est = BaseDatos.tablaEstudiante.get(i);
			if (est.getIdentificacion().equals(
					estudianteExistente.getIdentificacion())) {
				BaseDatos.tablaEstudiante.set(i, estudianteExistente);
				return true;
			}
		}
		return false;
	}

	public boolean eliminar(Integer estudianteABorrar) {
		for (int i = 0; i < BaseDatos.tablaEstudiante.size(); i++) {
			Estudiante est = BaseDatos.tablaEstudiante.get(i);
			if (est.getIdentificacion().equals(estudianteABorrar)) {
				BaseDatos.tablaEstudiante.remove(i);
				return true;
			}
		}
		return false;
	}

	public ArrayList<Estudiante> consultarTodos() {
		return BaseDatos.tablaEstudiante;
	}
}
