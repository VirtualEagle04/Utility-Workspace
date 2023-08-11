package co.edu.unbosque.model;

public abstract class VehiculoDTO {
	
	private int num_llantas;
	private float peso;
	private String medio; //Maritimo, Aereo, Terrestre
	private int cant_pasajeros;
	private String nombre;
	private String forma_potencia;
	
	public VehiculoDTO() {
		// TODO Auto-generated constructor stub
	}

	public VehiculoDTO(int num_llantas, float peso, String medio, int cant_pasajeros, String nombre,
			String forma_potencia) {
		super();
		this.num_llantas = num_llantas;
		this.peso = peso;
		this.medio = medio;
		this.cant_pasajeros = cant_pasajeros;
		this.nombre = nombre;
		this.forma_potencia = forma_potencia;
	}

	public int getNum_llantas() {
		return num_llantas;
	}

	public void setNum_llantas(int num_llantas) {
		this.num_llantas = num_llantas;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getMedio() {
		return medio;
	}

	public void setMedio(String medio) {
		this.medio = medio;
	}

	public int getCant_pasajeros() {
		return cant_pasajeros;
	}

	public void setCant_pasajeros(int cant_pasajeros) {
		this.cant_pasajeros = cant_pasajeros;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getForma_potencia() {
		return forma_potencia;
	}

	public void setForma_potencia(String forma_potencia) {
		this.forma_potencia = forma_potencia;
	}
	
	/**
	 * Funciones abstract
	 * Solamente indico el nombre y retorno, pero no el bloque de codigo.
	 * Esto OBLIGA a las clases que heredan de esta, a sobreescribir esta clase con logica.
	 */
	public abstract boolean estaEncendido();
	
	public abstract void cargarEnergia();
	
	
}
