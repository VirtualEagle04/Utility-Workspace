package co.edu.unbosque.beans;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.PrimeFaces;

import co.edu.unbosque.entity.Transaccion;
import co.edu.unbosque.services.TransaccionServicio;

@ManagedBean
@SessionScoped
public class TransaccionMB {

	private TransaccionServicio transaccionServicio;

	private ArrayList<Transaccion> transacciones;

	private Transaccion transaccionSeleccionada;

	private ArrayList<Transaccion> transaccionesSeleccionadas;

	public TransaccionMB() {

		transaccionServicio = new TransaccionServicio();

		transacciones = transaccionServicio.consultarTodos();

		transaccionesSeleccionadas = new ArrayList<Transaccion>();

	}

	// Getters y Setters

	public Transaccion getTransaccionSeleccionada() {
		return transaccionSeleccionada;
	}

	public void setTransaccionSeleccionada(Transaccion transaccionSeleccionada) {
		this.transaccionSeleccionada = transaccionSeleccionada;
	}

	public ArrayList<Transaccion> getTransaccionesSeleccionadas() {
		return transaccionesSeleccionadas;
	}

	public void setTransaccionesSeleccionadas(ArrayList<Transaccion> transaccionesSeleccionadas) {
		this.transaccionesSeleccionadas = transaccionesSeleccionadas;
	}

	public ArrayList<Transaccion> getTransacciones() {
		return transacciones;
	}

	// CRUD

	public void abrirNuevaTransaccion() {
		transaccionSeleccionada = new Transaccion();
	}

	public void guardarTransaccion() {

		// Nueva Transaccion
		if (transaccionSeleccionada.getId() == -1) {

			transaccionSeleccionada.setId(transacciones.size());
			//transacciones.add(transaccionSeleccionada);
			transaccionServicio.insertar(transaccionSeleccionada);
			transacciones = transaccionServicio.consultarTodos();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Transacción Añadida"));
		} // Actualizar Transaccion
		else {
			//transacciones.set(transaccionSeleccionada.getId(), transaccionSeleccionada);
			transaccionServicio.actualizar(transaccionSeleccionada);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Transacción Actualizada"));
		}

		PrimeFaces.current().executeScript("PF('dialogoGestionarTransaccion').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-transacciones");
	}

	public void eliminarTransaccion() {
		//transacciones.remove(transaccionSeleccionada);

		transaccionServicio.eliminar(transaccionSeleccionada.getId());
		transacciones = transaccionServicio.consultarTodos();

		transaccionSeleccionada = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Transacción Eliminada"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-transacciones");
	}

	public String getMensajeBotonEliminar() {
		if (haSeleccionadoTransacciones()) {
			int tamano = transaccionesSeleccionadas.size();
			return tamano > 1 ? tamano + " Transacciones selecionadas" : "1 Transacción seleccionada";
		}

		return "Eliminar";
	}

	public boolean haSeleccionadoTransacciones() {
		return transaccionesSeleccionadas != null && !transaccionesSeleccionadas.isEmpty();
	}

	public void eliminarTransaccionesSeleccionadas() {
		//transacciones.removeAll(transaccionesSeleccionadas);

		transaccionServicio.eliminarMuchos(transaccionesSeleccionadas);
		transacciones = transaccionServicio.consultarTodos();

		transaccionesSeleccionadas = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Transacciones Eliminadas"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-transacciones");
		PrimeFaces.current().executeScript("PF('dtTransacciones').clearFilters()");
	}

}
