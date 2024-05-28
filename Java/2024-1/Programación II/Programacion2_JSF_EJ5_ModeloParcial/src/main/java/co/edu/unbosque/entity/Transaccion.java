package co.edu.unbosque.entity;

import java.util.Date;

public class Transaccion {

	private int id;
	private Date fechaHora;
	private String usuario;
	private int idProducto;
	private int cantComprada;
	private int valorUnitario;
	private short idTipoPago;
	private short idBanco;
	private short idFranquicia;
	private String numTarjeta;
	private String estado;

	public Transaccion(int id, Date fechaHora, String usuario, int idProducto, int cantComprada, int valorUnitario,
			short idTipoPago, short idBanco, short idFranquicia, String numTarjeta, String estado) {
		this.id = id;
		this.fechaHora = fechaHora;
		this.usuario = usuario;
		this.idProducto = idProducto;
		this.cantComprada = cantComprada;
		this.valorUnitario = valorUnitario;
		this.idTipoPago = idTipoPago;
		this.idBanco = idBanco;
		this.idFranquicia = idFranquicia;
		this.numTarjeta = numTarjeta;
		this.estado = estado;
	}

	public Transaccion() {
		this.id = -1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.util.Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(java.util.Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantComprada() {
		return cantComprada;
	}

	public void setCantComprada(int cantComprada) {
		this.cantComprada = cantComprada;
	}

	public int getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(int valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public short getIdTipoPago() {
		return idTipoPago;
	}

	public void setIdTipoPago(short idTipoPago) {
		this.idTipoPago = idTipoPago;
	}

	public short getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(short idBanco) {
		this.idBanco = idBanco;
	}

	public short getIdFranquicia() {
		return idFranquicia;
	}

	public void setIdFranquicia(short idFranquicia) {
		this.idFranquicia = idFranquicia;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Transaccion other = (Transaccion) obj;
        if (id == 0) {
            return other.id == 0;
        }
        else {
            return id == other.id;
        }
    }

}
