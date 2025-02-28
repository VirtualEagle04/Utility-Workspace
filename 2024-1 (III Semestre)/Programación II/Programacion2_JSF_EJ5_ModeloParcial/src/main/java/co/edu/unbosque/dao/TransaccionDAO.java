package co.edu.unbosque.dao;

import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.bd.BaseDatos;
import co.edu.unbosque.entity.Transaccion;

public class TransaccionDAO {

	public TransaccionDAO() {
	}

	public boolean insertar(Transaccion transaccionSeleccionada) {
		
		transaccionSeleccionada.setFechaHora(new Date());
		
		return BaseDatos.tablaTransaccion.add(transaccionSeleccionada);
	}

	public boolean actualizar(Transaccion transaccionExistente) {
		for (int i = 0; i < BaseDatos.tablaTransaccion.size(); i++) {
			Transaccion tx = BaseDatos.tablaTransaccion.get(i);
			if (tx.getId() == transaccionExistente.getId()) {
				BaseDatos.tablaTransaccion.set(i, transaccionExistente);
				return true;
			}
		}
		return false;
	}

	public boolean eliminar(Integer transaccionABorrar) {
		for (int i = 0; i < BaseDatos.tablaTransaccion.size(); i++) {
			Transaccion tx = BaseDatos.tablaTransaccion.get(i);
			if (tx.getId() == transaccionABorrar) {
				BaseDatos.tablaTransaccion.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean eliminarMuchos(ArrayList<Transaccion> transaccionesABorrar) {
		
		for (int i = 0; i < transaccionesABorrar.size(); i++) {
			eliminar(transaccionesABorrar.get(i).getId());
		}
		return true;
		
	}

	public ArrayList<Transaccion> consultarTodos() {
		return BaseDatos.tablaTransaccion;
	}
}
