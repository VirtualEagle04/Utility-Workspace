package com.unbosque.edu.co.beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.unbosque.edu.co.services.EstudianteServicio;
import com.unbosque.edu.co.entity.Estudiante;

@ManagedBean
@SessionScoped
public class EstudianteMB {
	private EstudianteServicio estudianteServicio = new EstudianteServicio();
	private ArrayList<Estudiante> listaEstudiantes;
	private Estudiante estudianteNuevo;
	private Estudiante estudianteExistente;
	private Integer identificacionEstudianteAEliminar;

	public EstudianteMB() {
		listaEstudiantes = estudianteServicio.consultarTodos();
	}

	public String crearEstudiante() {
		estudianteNuevo = new Estudiante();
		return "estudianteNuevo.xhtml";
	}

	public String guardarEstudianteNuevo() {
		
		for(int i = 0; i < listaEstudiantes.size(); i++) {
			if(listaEstudiantes.get(i).getIdentificacion() == estudianteNuevo.getIdentificacion()) {
				return "estudianteError.xhtml";
			}
		}
		
		estudianteServicio.insertar(estudianteNuevo);
		return "listaEstudiante.xhtml";
	}

	public String eliminarEstudiante() {
		estudianteServicio.eliminar(identificacionEstudianteAEliminar);
		return null;
	}

	public String actualizarEstudianteExistente() {
		for(int i = 0; i < listaEstudiantes.size(); i++) {
			if(listaEstudiantes.get(i).getIdentificacion() == estudianteExistente.getIdentificacion()) {
				return "estudianteError.xhtml";
			}
		}
		
		estudianteServicio.actualizar(estudianteExistente);
		return "listaEstudiante.xhtml";
	}
	
	// Getters & Setters

	public ArrayList<Estudiante> getListaEstudiantes() {
		return listaEstudiantes;
	}

	public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

	public Estudiante getEstudianteNuevo() {
		return estudianteNuevo;
	}

	public void setEstudianteNuevo(Estudiante estudianteNuevo) {
		this.estudianteNuevo = estudianteNuevo;
	}

	public Estudiante getEstudianteExistente() {
		return estudianteExistente;
	}

	public void setEstudianteExistente(Estudiante estudianteExistente) {
		this.estudianteExistente = estudianteExistente;
	}

	public Integer getIdentificacionEstudianteAEliminar() {
		return identificacionEstudianteAEliminar;
	}

	public void setIdentificacionEstudianteAEliminar(
			Integer identificacionEstudianteAEliminar) {
		this.identificacionEstudianteAEliminar = identificacionEstudianteAEliminar;
	}

}
