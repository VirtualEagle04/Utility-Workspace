package co.edu.unbosque.entity;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The persistent class for the tipo_usuario database table.
 * 
 */
@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "estado")
	private String estado;

	public TipoUsuario() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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