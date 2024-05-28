package co.edu.unbosque.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Servlet implementation class EjemploSesiones
 */
@WebServlet("/EjemploSesiones")
public class EjemploSesiones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjemploSesiones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		String titulo = "Ejemplo de sesiones";
		String cabecera;
		// Obtener objeto sesion
		HttpSession session = request.getSession(true);
		// Obtener del obj. sesion el numero previo de accesos
		// Si no existe el numero, es el primer acceso
		Integer numAccesos = (Integer) session.getAttribute("nAccesos");
		// Obtenemos los datos de la maquina
		String ipAdress = request.getRemoteAddr();
		
		if(numAccesos == null) {
			numAccesos = 0;
			cabecera = "Bienvenido por primera vez";
		} else {
			cabecera = "Bienvenido de nuevo";
			numAccesos = numAccesos + 1;
		}
		
		// Almacenar el nuevo valor de numero de accesos
		session.setAttribute("nAccesos", numAccesos);
		// Crear pagina para el usuario y enviar
		out.println("<!DOCTYPE HTML PUBLIC \"=!//W3C//DTD HTML 3.2//EN\">" + "<html><head><title>" + titulo
				+ "</title></head><body><center>" + "<h1>" + cabecera
				+ "</h1><h2>Informaci&oacute;n de tu sesi&oacute;n</h2>" + "<table border='1'"
				+ "<tr><th>Informaci&oacute;n</th><th>Valor</th></tr>" + "<tr><td>Session ID</td><td>" + session.getId()
				+ "</td></tr>" + "<tr><td>Ultimo acceso</td><td>" +  new Date(session.getLastAccessedTime())
				+ "</td></tr>" + "<tr><td>Instante de creaci&oacute;n</td><td>" +  new Date(session.getCreationTime())
				+ "</td></tr>" + "<tr><td>IP de la M&aacute;quina</td><td>" +  ipAdress + "</td></tr>"
				+ "<tr><td>N&uacute;mero accesos previos</td><td>" + numAccesos + "</td></tr></table>");
		out.println("</center></body></html>");
		out.close();
		// Hacer terminar la sesion cuando ya ha realizado mas de 5 conexiones
		if((numAccesos.intValue()) > 4) {
			session.invalidate();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
