package co.edu.unbosque.model;

import java.util.Date;
/**
 * Permite almancenar temporalmente los datos de un Ciudadano para la persistencia de los datos
 * @author Federico Vargas Rozo
 * @param nombre Nombre del Ciudadano
 * @param sexo Sexo del Ciudadano
 * @param ciudad Ciudad de Nacimiento del Ciudadano
 * @param fecha Fecha de Nacimiento del Ciudadano
 * @param nombre_padre Nombre del padre del Ciudadano
 * @param nombre_madre Nombre de la madre del Ciudadano
 * @param tipo Tipo del Ciudadano (Neonato, Padre, Madre)
 *
 */
public class TemporalGeneral {

	private String nombre;
	private String sexo;
	private String ciudad;
	private Date fecha;
	private String padre;
	private String madre;
	private String tipo;

	public TemporalGeneral() {
		// TODO Auto-generated constructor stub
	}

	public TemporalGeneral(String nombre, String sexo, String ciudad, Date fecha, String padre, String madre,
			String tipo) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
		this.ciudad = ciudad;
		this.fecha = fecha;
		this.padre = padre;
		this.madre = madre;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getPadre() {
		return padre;
	}

	public void setPadre(String padre) {
		this.padre = padre;
	}

	public String getMadre() {
		return madre;
	}

	public void setMadre(String madre) {
		this.madre = madre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}