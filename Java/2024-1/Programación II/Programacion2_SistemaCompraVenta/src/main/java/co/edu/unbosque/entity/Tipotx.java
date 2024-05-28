package co.edu.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipotx database table.
 * 
 */
@Entity
@NamedQuery(name="Tipotx.findAll", query="SELECT t FROM Tipotx t")
public class Tipotx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private short id;

	private String descripcion;

	private String estado;

	public Tipotx() {
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