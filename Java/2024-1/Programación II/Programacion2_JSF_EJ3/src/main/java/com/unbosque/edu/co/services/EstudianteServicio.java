package com.unbosque.edu.co.services;

import java.util.ArrayList;

import com.unbosque.edu.co.dao.EstudianteDAO;
import com.unbosque.edu.co.entity.Estudiante;

public class EstudianteServicio {
	private EstudianteDAO estudianteDAO = new EstudianteDAO();

	public boolean insertar(Estudiante estudianteNuevo) {
		return estudianteDAO.insertar(estudianteNuevo);
	}

	public boolean actualizar(Estudiante estudianteExistente) {
		return estudianteDAO.actualizar(estudianteExistente);
	}

	public boolean eliminar(Integer estudianteABorrar) {
		return estudianteDAO.eliminar(estudianteABorrar);
	}

	public ArrayList<Estudiante> consultarTodos() {
		return estudianteDAO.consultarTodos();
	}
}
