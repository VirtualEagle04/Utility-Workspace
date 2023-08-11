package co.edu.unbosque.model;

import java.util.Date;
/**
 * Permite almancenar temporalmente los datos de un Padre/Madre para la persistencia de los datos
 * @author Federico Vargas Rozo
 * @param nombre Nombre del Padre/Madre
 * @param sexo Sexo del Padre/Madre
 * @param ciudad Ciudad de Nacimiento del Padre/Madre
 * @param fecha Fecha de Nacimiento del Padre/Madre
 *
 */
public class TemporalPadres {
	
	private String nombre;
	private String sexo;
	private String ciudad;
	private Date fecha;
	
	public TemporalPadres() {
		// TODO Auto-generated constructor stub
	}

	public TemporalPadres(String nombre, String sexo, String ciudad, Date fecha) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
		this.ciudad = ciudad;
		this.fecha = fecha;
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

	
}
