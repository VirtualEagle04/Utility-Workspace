package co.edu.unbosque.model;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Clase base que contiene todos los atributos que comparten los Ciudadanos
 * @author Federico Vargas Rozo
 * @param nombre Nombre del ciudadano
 * @param sexo Sexo del ciudadano
 * @param ciudad Ciudad de Nacimiento del ciudadano
 * @param fecha Fecha de Nacimiento del ciudadano
 * @param nombre_padre Nombre del Padre
 * @param nombre_madre Nombre de la Madre
 *
 */
public class CiudadanoDTO {

	private String nombre;
	private String sexo;
	private String ciudad;
	private Date fecha;
	private String nombre_padre;
	private String nombre_madre;

	
	
	public CiudadanoDTO() {
		
	}

	public CiudadanoDTO(String nombre, String sexo, String ciudad, Date fecha) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
		this.ciudad = ciudad;
		this.fecha = fecha;
	}
	
	

	public CiudadanoDTO(String nombre, String sexo, String ciudad, Date fecha, String nombre_padre, String nombre_madre) {
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
	/**
	 * Funcion que sobreescribe el metodo toString() de todo Objeto, utilizado para mostrar 
	 * todos los atributos del viaje.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat date_format = new SimpleDateFormat("MM/dd/yyyy");
		sb.append("Nombre: "+getNombre()+"\n");
		sb.append("Sexo: "+getSexo()+"\n");
		sb.append("Ciudad de Nacimiento: "+getCiudad()+"\n");
		sb.append("Fecha de Nacimieto: "+date_format.format(getFecha())+"\n");
		sb.append("----------\n");
		return sb.toString();
	}
	
	
}
