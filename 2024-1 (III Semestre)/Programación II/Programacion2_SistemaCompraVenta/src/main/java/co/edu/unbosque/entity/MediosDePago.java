package co.edu.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the medios_de_pago database table.
 * 
 */
@Entity
@Table(name="medios_de_pago")
@NamedQuery(name="MediosDePago.findAll", query="SELECT m FROM MediosDePago m")
public class MediosDePago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private short id;

	private String descripcion;

	private String estado;

	public MediosDePago() {
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