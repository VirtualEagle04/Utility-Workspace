package co.edu.unbosque.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class HolaMundoServlet
 */
@WebServlet("/HolaMundoServlet")
public class HolaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Mensaje desde método doGet desde una página JSP</h1>");

		String texto = request.getParameter("palabra");
		for (int tamano = 1; tamano <= 7; ++tamano) {
			out.println("<font size=" + tamano + " color=blue>");
			out.println(texto);
			out.println("<br>");
		}
		out.println("<br>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Mensaje desde método doPost desde una página JSP</h1>");

		String texto = request.getParameter("palabra");
		for (int tamano = 1; tamano <= 7; ++tamano) {
			out.println("<font size=" + tamano + " color=blue>");
			out.println(texto);
			out.println("<br>");
		}
		out.println("<br>");
	}

}
