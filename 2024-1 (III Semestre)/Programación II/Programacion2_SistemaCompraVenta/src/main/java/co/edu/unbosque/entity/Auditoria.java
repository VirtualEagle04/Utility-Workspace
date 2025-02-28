package co.edu.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the auditoria database table.
 * 
 */
@Entity
@NamedQuery(name="Auditoria.findAll", query="SELECT a FROM Auditoria a")
public class Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="accion_audtria")
	private String accionAudtria;

	@Column(name="address_audtria")
	private String addressAudtria;

	@Column(name="comentario_audtria")
	private String comentarioAudtria;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fcha_audtria")
	private Date fchaAudtria;

	@Column(name="usrio_audtria")
	private String usrioAudtria;

	public Auditoria() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccionAudtria() {
		return this.accionAudtria;
	}

	public void setAccionAudtria(String accionAudtria) {
		this.accionAudtria = accionAudtria;
	}

	public String getAddressAudtria() {
		return this.addressAudtria;
	}

	public void setAddressAudtria(String addressAudtria) {
		this.addressAudtria = addressAudtria;
	}

	public String getComentarioAudtria() {
		return this.comentarioAudtria;
	}

	public void setComentarioAudtria(String comentarioAudtria) {
		this.comentarioAudtria = comentarioAudtria;
	}

	public Date getFchaAudtria() {
		return this.fchaAudtria;
	}

	public void setFchaAudtria(Date fchaAudtria) {
		this.fchaAudtria = fchaAudtria;
	}

	public String getUsrioAudtria() {
		return this.usrioAudtria;
	}

	public void setUsrioAudtria(String usrioAudtria) {
		this.usrioAudtria = usrioAudtria;
	}

}