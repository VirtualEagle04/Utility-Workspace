package co.edu.unbosque.services;

import java.util.ArrayList;

import co.edu.unbosque.dao.TransaccionDAO;
import co.edu.unbosque.entity.Transaccion;


public class TransaccionServicio {
	private TransaccionDAO transaccionDAO = new TransaccionDAO();

	public boolean insertar(Transaccion transaccionSeleccionada) {
		return transaccionDAO.insertar(transaccionSeleccionada);
	}

	public boolean actualizar(Transaccion transaccionSeleccionada) {
		return transaccionDAO.actualizar(transaccionSeleccionada);
	}

	public boolean eliminar(Integer transaccionABorrar) {
		return transaccionDAO.eliminar(transaccionABorrar);
	}
	
	public boolean eliminarMuchos(ArrayList<Transaccion> transaccionesABorrar) {
		return transaccionDAO.eliminarMuchos(transaccionesABorrar);
	}

	public ArrayList<Transaccion> consultarTodos() {
		return transaccionDAO.consultarTodos();
	}
}
