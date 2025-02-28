package co.edu.unbosque.evpar;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VentaProducto
 */
@WebServlet("/VentaProducto")
public class VentaProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VentaProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println(
				"<style> * {font-family: Arial, Helvetica, sans-serif;} .panelcentral{position: absolute;left:50%;top:50%;transform: translate(-50%, -50%);}</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"panelcentral\">");
		out.println("<ul>");

		String producto = request.getParameter("producto");
		String precio = request.getParameter("precio");
		String cantidad = request.getParameter("cantidad");
		String descuento = request.getParameter("descuento");

		boolean error = false;
		boolean precioError = false;
		boolean cantidadError = false;
		boolean descuentoError = false;
		int precioNum = 0;
		int cantidadNum = 0;
		int descuentoNum = 0;

		// Verificacion Producto
		if (producto.equals("Seleccionar")) {
			out.println("<li><p>Es necesario que seleccione un art&iacute;culo.</p></li>");
			error = true;
		}

		// Verificacion Precio por Unidad
		if (precio == null || precio.isEmpty()) {
			out.println("<li><p>El campo <b>'Precio Unitario'</b> est&aacute; vacio.</p></li>");
			error = true;
		} else {
			for (int i = 0; i < precio.length(); i++) {
				char c = precio.charAt(i);
				if (!Character.isDigit(c)) {
					out.println(
							"<li><p>El campo <b>'Precio Unitario'</b> contiene caracteres invalidos, recuerda utilizar unicamente n&uacute;meros.</p></li>");
					error = true;
					precioError = true;
					break;
				}
			}
			if (precioError == false) {
				int prec = Integer.parseInt(precio);
				precioNum = prec;
				if (prec <= 0 || prec > 2147483647) {
					out.println(
							"<li><p>El campo <b>'Precio Unitario'</b> contiene n&uacute;meros muy grandes.</p></li>");
					error = true;
				}
			}
		}

		// Verificacion Cantidad
		if (cantidad == null || cantidad.isEmpty()) {
			out.println("<li><p>El campo <b>'Cantidad'</b> est&aacute; vacio.</p></li>");
			error = true;
		} else {
			for (int i = 0; i < cantidad.length(); i++) {
				char c = cantidad.charAt(i);
				if (!Character.isDigit(c)) {
					out.println(
							"<li><p>El campo <b>'Cantidad'</b> contiene caracteres invalidos, recuerda utilizar unicamente n&uacute;meros.</p></li>");
					error = true;
					cantidadError = true;
					break;
				}
			}
			if (cantidadError == false) {
				int cant = Integer.parseInt(cantidad);
				cantidadNum = cant;
				if (cant <= 0 || cant > 1000) {
					out.println("<li><p>El campo <b>'Cantidad'</b> contiene n&uacute;meros muy grandes.</p></li>");
					error = true;
				}
			}
		}

		// Verificacion Descuento
		if (descuento == null || descuento.isEmpty()) {
			out.println("<li><p>El campo <b>'Descuento (%)'</b> est&aacute; vacio.</p></li>");
			error = true;
		} else {
			for (int i = 0; i < descuento.length(); i++) {
				char c = descuento.charAt(i);
				if (!Character.isDigit(c)) {
					out.println(
							"<li><p>El campo <b>'Descuento (%)'</b> contiene caracteres invalidos, recuerda utilizar unicamente n&uacute;meros.</p></li>");
					error = true;
					descuentoError = true;
					break;
				}
			}
			if (descuentoError == false) {
				int desc = Integer.parseInt(descuento);
				descuentoNum = desc;
				if (desc < 0 || desc > 25) {
					out.println(
							"<li><p>El campo <b>'Descuento (%)'</b> contiene n&uacute;meros muy grandes. Rango: [0,25] </p></li>");
					error = true;
				}
			}
		}

		// Verificar Error
		if (error) {
			// Existen Errores

			out.println("<p align=\"center\"><a href=\"javascript:history.back()\">Volver</a></p>");
			out.println("</ul>");
		} else {
			// No existen Errores

			out.println("<table border='1'>");
			out.println("<tr><th colspan='2'>RESULTADO DE LA VENTA</th></tr>");
			out.println("<tr><th>Producto:</th><td>" + producto + "</td></tr>");
			out.println("<tr height='20px'></tr>");
			out.println("<tr><th colspan='2'><b>Datos de la Compra</b></th><tr>");
			out.println("<tr><th>Precio Unitario:</th><td>" + precio + "</td></tr>");
			out.println("<tr><th>Cantidad:</th><td>" + cantidad + "</td></tr>");
			out.println("<tr><th>Descuento (%):</th><td>" + descuento + "</td></tr>");
			out.println("<tr height='20px'></tr>");
			out.println("<tr><th>Precio Total:</th><td> $ "
					+ ((precioNum * cantidadNum) - (descuentoNum * (precioNum * cantidadNum)) / 100));
			out.println("</table>");
			out.println("<p align=\"center\"><a href=\"venta.jsp\">Realizar otra Compra</a></p>");

		}

		out.println("</div>");
		request.getRequestDispatcher("pieparcial.jsp").include(request, response);
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
