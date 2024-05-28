package co.edu.unbosque.business;

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
 * Servlet implementation class ProcesoCompra
 */
@WebServlet("/ProcesoCompra")
public class ProcesoCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcesoCompra() {
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

		String articulo = request.getParameter("articulo");
		String cantidad = request.getParameter("cantidad");
		String precio = request.getParameter("precio");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String tarjeta = request.getParameter("tarjeta");
		String confirmacion = request.getParameter("confirmacion");

		int[] tarj = new int[4];
		int[] conf = new int[4];

		boolean cantidadError = false;
		boolean precioError = false;
		boolean error = false;
		int cantidadNum = 0;
		int precioNum = 0;

		// Verificacion Articulo
		if (articulo.equals("Seleccionar")) {
			out.println("<li><p>Es necesario que seleccione un art&iacute;culo.</p></li>");
			error = true;
		}

		// Verificacion Cantidad
		if (cantidad == null || cantidad.isEmpty()) {
			out.println("<li><p>El campo <b>'Cantidad' est&aacute;</b> vacio.</p></li>");
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
					out.println(
							"<li><p>El campo <b>'Cantidad'</b> contiene n&uacute;meros negativos o muy grandes.</p></li>");
					error = true;
				}
			}
		}

		// Verificacion Precio por Unidad
		if (precio == null || precio.isEmpty()) {
			out.println("<li><p>El campo <b>'Precio por Unidad'</b> est&aacute; vacio.</p></li>");
			error = true;
		} else {
			for (int i = 0; i < precio.length(); i++) {
				char c = precio.charAt(i);
				if (!Character.isDigit(c)) {
					out.println(
							"<li><p>El campo <b>'Precio por Unidad'</b> contiene caracteres invalidos, recuerda utilizar unicamente n&uacute;meros.</p></li>");
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
							"<li><p>El campo <b>'Precio por Unidad'</b> contiene n&uacute;meros negativos o muy grandes.</p></li>");
					error = true;
				}
			}
		}

		// Verifiacion Nombre del Cliente
		if (nombre == null || nombre.isEmpty()) {
			out.println("<li><p>El campo <b>'Nombres del Cliente'</b> est&aacute; vacio.</p></li>");
			error = true;
		}

		// Verifiacion Apellidos del Cliente
		if (apellidos == null || apellidos.isEmpty()) {
			out.println("<li><p>El campo <b>'Apellidos del Cliente'</b> est&aacute; vacio.</p></li>");
			error = true;
		}

		// Verificacion Numero de Tarjeta de Credito
		if (tarjeta == null || tarjeta.isEmpty()) {
			out.println(
					"<li><p>El campo <b>'N&uacute;mero de Tarjeta de Cr&eacute;dito'</b> est&aacute; vacio.</p></li>");
			error = true;
		} else {
			String tarj1 = tarjeta.substring(0, 3);
			String tarj2 = tarjeta.substring(4, 7);
			String tarj3 = tarjeta.substring(8, 11);
			String tarj4 = tarjeta.substring(12);

			tarj[0] = Integer.parseInt(tarj1);
			tarj[1] = Integer.parseInt(tarj2);
			tarj[2] = Integer.parseInt(tarj3);
			tarj[3] = Integer.parseInt(tarj4);

			for (int i = 0; i < tarjeta.length(); i++) {
				char c = tarjeta.charAt(i);
				if (!Character.isDigit(c)) {
					out.println(
							"<li><p>El campo <b>'N&uacute;mero de Tarjeta de Cr&eacute;dito'</b> contiene caracteres invalidos, recuerda utilizar unicamente n&uacute;meros.</p></li>");
					error = true;
					break;
				}
			}
		}

		// Verificacion Confirmacion Numero de Tarjeta de Credito
		if (confirmacion == null || confirmacion.isEmpty()) {
			out.println(
					"<li><p>El campo <b>'Confirmar N&uacute;mero de Tarjeta de Cr&eacute;dito'</b> est&aacute; vacio.</p></li>");
			error = true;
		} else {
			String conf1 = confirmacion.substring(0, 3);
			String conf2 = confirmacion.substring(4, 7);
			String conf3 = confirmacion.substring(8, 11);
			String conf4 = confirmacion.substring(12);

			conf[0] = Integer.parseInt(conf1);
			conf[1] = Integer.parseInt(conf2);
			conf[2] = Integer.parseInt(conf3);
			conf[3] = Integer.parseInt(conf4);

			for (int i = 0; i < confirmacion.length(); i++) {
				char c = confirmacion.charAt(i);
				if (!Character.isDigit(c)) {
					out.println(
							"<li><p>El campo <b>'Confirmar N&uacute;mero de Tarjeta de Cr&eacute;dito'</b> contiene caracteres invalidos, recuerda utilizar unicamente n&uacute;meros.</p></li>");
					error = true;
					break;
				}
			}
		}

		// Verificacion Numero y Confirmacion de Numero de Tarjeta de Credito
		for (int i = 0; i < tarj.length; i++) {
			if (tarj[i] == conf[i]) {
				continue;
			} else {
				out.println("<li><p>La tarjeta no coincide con la confirmaci&oacute;n.</p></li>");
				error = true;
				break;
			}
		}

		// Verificar Error
		if (error) {
			// Existen Errores

			out.println("<p align=\"center\"><a href=\"javascript:history.back()\">Volver</a></p>");
			out.println("</ul>");
		} else {
			// No existen Errores

			out.println("<p>Señor Usuario: <b>" + nombre.toUpperCase() + " " + apellidos.toUpperCase() + "</b></p>");

			out.println("<p>Su compra fue realizada satisfactoriamente por un valor de <b>$"
					+ ((cantidadNum * precioNum) + ((cantidadNum * precioNum) * 19) / 100)
					+ ".</b> Correspondiente a <b>" + cantidadNum + " "
					+ ((cantidadNum >= 2) ? articulo + "s" : articulo) + ".</b></p>");

			out.println("<br>");
			out.println("<p>El precio por unidad fue de: <b>$" + precioNum
					+ "</b> y el valor del impuesto <b>IVA (19%)</b> fue de <b>$"
					+ ((cantidadNum * precioNum) * 19) / 100 + ".</b></p><br>");

			long primerosDos = Long.parseLong(tarjeta.substring(0, 2));
			String franquicia = "DESCONOCIDA";
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

			if (tarjeta.length() == 16) {
				if (51 <= primerosDos && primerosDos <= 55) {
					franquicia = "MASTERCARD";
				} else if (tarjeta.substring(0, 1).equals("4")) {
					franquicia = "VISA";
				}
			} else {
				if (primerosDos == 34 || primerosDos == 37) {
					franquicia = "AMERICAN EXPRESS";
				}
			}
			out.println("<p>La compra fue realizada con la tarjeta de cr&eacute;dito n&uacute;mero: **** **** **** "
					+ tarjeta.substring(tarjeta.length() - 4) + " de la franquicia <b>" + franquicia
					+ ".</b> Fecha de compra: <b>" + dateFormat.format(new Date()) + ".</b></p>");

			out.println("<p align=\"center\"><a href=\"registro.jsp\">Realizar otra Compra</a></p>");
			out.println("<p></p>");

		}

		out.println("</div>");
		request.getRequestDispatcher("piedepagina.jsp").include(request, response);
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
