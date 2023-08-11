package co.edu.unbosque.model;

import java.util.Date;
/**
 * Permite almancenar temporalmente los datos de un Neonato para la persistencia de los datos
 * @author Federico Vargas Rozo
 * @param nombre Nombre del Neonato
 * @param sexo Sexo del Neonato
 * @param ciudad Ciudad de Nacimiento del Neonato
 * @param fecha Fecha de Nacimiento del Neonato
 * @param nombre_padre Nombre del padre del Neonato
 * @param nombre_madre Nombre de la madre del Neonato
 *
 */
public class TemporalNeonatos {
	
	private String nombre;
	private String sexo;
	private String ciudad;
	private Date fecha;
	private String nombre_padre;
	private String nombre_madre;
	
	public TemporalNeonatos() {
		// TODO Auto-generated constructor stub
	}

	public TemporalNeonatos(String nombre, String sexo, String ciudad, Date fecha, String nombre_padre,
			String nombre_madre) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
		this.ciudad = ciudad;
		this.fecha = fecha;
		this.nombre_padre = nombre_padre;
		this.nombre_madre = nombre_madre;
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

	public String getNombre_padre() {
		return nombre_padre;
	}

	public void setNombre_padre(String nombre_padre) {
		this.nombre_padre = nombre_padre;
	}

	public String getNombre_madre() {
		return nombre_madre;
	}

	public void setNombre_madre(String nombre_madre) {
		this.nombre_madre = nombre_madre;
	}

	
	
	
}
