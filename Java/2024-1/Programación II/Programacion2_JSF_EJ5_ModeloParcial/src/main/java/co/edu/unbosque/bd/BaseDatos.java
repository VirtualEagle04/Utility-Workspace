package co.edu.unbosque.bd;

import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.entity.Transaccion;

public class BaseDatos {
	public static ArrayList<Transaccion> tablaTransaccion = new ArrayList<Transaccion>();
	public static int contadorIndex = 0;

	static {
		Transaccion tx = new Transaccion();
		tx.setId(contadorIndex);
		tx.setFechaHora((new Date()));
		tx.setUsuario("Wilson");
		tx.setIdProducto(1);
		tx.setCantComprada(2);
		tx.setValorUnitario(12000);
		tx.setIdTipoPago((short) 1);
		tx.setIdBanco((short) 1);
		tx.setIdFranquicia((short) 1);
		tx.setNumTarjeta("0000-0000-0000-0000");
		tx.setEstado("A");
		tablaTransaccion.add(tx);
		contadorIndex++;
		
		Transaccion tx1 = new Transaccion();
		tx1.setId(contadorIndex);
		tx1.setFechaHora((new Date()));
		tx1.setUsuario("Federico");
		tx1.setIdProducto(3);
		tx1.setCantComprada(1);
		tx1.setValorUnitario(8500);
		tx1.setIdTipoPago((short) 1);
		tx1.setIdBanco((short) 1);
		tx1.setIdFranquicia((short) 1);
		tx1.setNumTarjeta("9828-1840-0012-6167");
		tx1.setEstado("A");
		tablaTransaccion.add(tx1);
		contadorIndex++;
		
		Transaccion tx2 = new Transaccion();
		tx2.setId(contadorIndex);
		tx2.setFechaHora((new Date()));
		tx2.setUsuario("Miguel");
		tx2.setIdProducto(1);
		tx2.setCantComprada(1);
		tx2.setValorUnitario(6000);
		tx2.setIdTipoPago((short) 1);
		tx2.setIdBanco((short) 1);
		tx2.setIdFranquicia((short) 1);
		tx2.setNumTarjeta("8889-1758-2920-8785");
		tx2.setEstado("A");
		tablaTransaccion.add(tx2);
		contadorIndex++;
	}
}
