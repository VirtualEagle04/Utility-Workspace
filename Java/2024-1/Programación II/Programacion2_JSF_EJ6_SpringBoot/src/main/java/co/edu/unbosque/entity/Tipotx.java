package co.edu.unbosque.entity;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The persistent class for the tipotx database table.
 * 
 */
@Entity
@Table(name = "tipotx")
public class Tipotx implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	private String descripcion;

	private String estado_tipoTx;

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

	public String getEstado_tipoTx() {
		return this.estado_tipoTx;
	}

	public void setEstado_tipoTx(String estado_tipoTx) {
		this.estado_tipoTx = estado_tipoTx;
	}

}