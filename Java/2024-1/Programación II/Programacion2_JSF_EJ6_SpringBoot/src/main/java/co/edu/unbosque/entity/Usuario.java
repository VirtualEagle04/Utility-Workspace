package co.edu.unbosque.entity;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity // Indica que la clase es un objeto persistente
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "clave")
	private String clave;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "nombres")
	private String nombres;
	@Column(name = "idTipoUsuario")
	private String idTipoUsuario;
	@Column(name = "estado")
	private String estado;

	public Usuario() {
	}

	public Usuario(Long id, String login, String clave, String apellidos, String nombres, String idTipoUsuario,
			String estado) {
		this.id = id;
		this.login = login;
		this.clave = clave;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.idTipoUsuario = idTipoUsuario;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(String idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}