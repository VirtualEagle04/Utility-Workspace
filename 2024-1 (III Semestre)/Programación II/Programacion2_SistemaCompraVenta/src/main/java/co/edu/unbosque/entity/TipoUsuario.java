package co.edu.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_usuario database table.
 * 
 */
@Entity
@Table(name="tipo_usuario")
@NamedQuery(name="TipoUsuario.findAll", query="SELECT t FROM TipoUsuario t")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private short id;

	private String descripcion;

	private String estado;

	public TipoUsuario() {
	}

	public short getId() {
		return this.id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}