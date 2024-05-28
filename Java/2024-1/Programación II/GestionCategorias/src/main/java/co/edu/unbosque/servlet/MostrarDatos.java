package co.edu.unbosque.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.unbosque.model.Categoria;
import co.edu.unbosque.util.EscribeLeeArchivo;

/**
 * Servlet implementation class MostrarDatos
 */
@WebServlet("/MostrarDatos")
public class MostrarDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MostrarDatos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		ServletContext sc = this.getServletContext();
		String ruta = sc.getRealPath("/WEB-INF/categoria.txt"); // Depende de la instalacion del
																// Tomcat->wtpwebapps->GestionarCategorias->WEB-INF->categoria.txt
		ruta = ruta.replace('\\', '/');

		String accion = request.getParameter("validacion");

		if (accion.equals("crear")) {
			// Existe un problema donde, si se refresca la pagina, va a hacer otra vez este
			// proceso con la misma informacion del anterior request. Por lo tanto, se sigue
			// duplicando en la tabla.
			ArrayList<Categoria> categorias = EscribeLeeArchivo.leer(ruta);
			String desc = request.getParameter("descripcion");
			boolean contains = false;
			while (true) {
				int randomId = new Random().nextInt(100);
				for (Categoria c : categorias) {
					if (c.getId() != randomId) {
						contains = false;
					} else {
						contains = true;
						break;
					}
				}
				if (contains) {
					continue;
				} else {
					EscribeLeeArchivo.escribir(new Categoria(randomId, desc, "A"), ruta);
					break;
				}
			}
		} else if (accion.equals("eliminar")) {

			ArrayList<Categoria> categorias = EscribeLeeArchivo.leer(ruta);
			int aEliminar = Integer.parseInt(request.getParameter("categoria"));

			for (Categoria c : categorias) {
				if (c.getId() == aEliminar) {
					c.setEstado("I");
					break;
				}
			}
			EscribeLeeArchivo.actualizar(categorias, ruta);

		} else if (accion.equals("editar")) {
			
			ArrayList<Categoria> categorias = EscribeLeeArchivo.leer(ruta);
			int aEditar = Integer.parseInt(request.getParameter("categoria"));
			String desc = request.getParameter("descripcion");
			String estado = request.getParameter("estado");
			
			for (Categoria c : categorias) {
				if (c.getId() == aEditar) {
					c.setDesc(desc);
					if(estado.equals("Inactivo")) {
						c.setEstado("I");						
					}else {
						c.setEstado("A");
					}
					break;
				}
			}
			EscribeLeeArchivo.actualizar(categorias, ruta);

		}

		ArrayList<Categoria> categorias = EscribeLeeArchivo.leer(ruta);

		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("* {font-family: JetBrains Mono, monospace;}");
		out.println("body { display:flex; justify-content: center; align-items: center; height: 100vh; margin: 0; background-color: #e8f0fe;}");
		out.println(".panelcentral {background-color: white; padding: 20px; text-align: center; border-radius: 15px;}");
		out.println("table {border: 1px solid black; border-collapse: collapse;}");
		out.println("tr:hover {background-color: slategray;}");
		out.println("tr {border-bottom: 1px solid black;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='panelcentral' align='center'>");

		out.println("<table width='500'>");
		out.println("<tr style='background-color:lightgray'><th colspan='6'> Categor&iacute;as</th></tr>");
		out.println("<tr style='background-color:lightgray'><th>ID</th><th>Descripci&oacute;n</th><th>Estado</th><th colspan='2'>Acci&oacute;n</th></tr>");

		for (Categoria c : categorias) {

			if (c.getEstado().equals("I")) {
				// Está desactivado
				out.println("<tr align='center' style='color:ghostwhite; font-style: italic; background-color:gray;'><td>" + c.getId()
						+ "</td><td >" + c.getDesc() + "</td><td>Inactivo</td>"
						+ "<td><?xml version='1.0' ?><svg width='30px' height='30px' id='Layer_1' style='enable-background:new 0 0 80 80;' version='1.1' viewBox='0 0 80 80' xml:space='preserve' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink'><title/><g id='Layer_2'><g id='Layer_3'><polygon points='61.8,71.8 8.4,71.8 8.4,18.4 35.1,18.4 35.1,15.4 5.4,15.4 5.4,74.8 64.8,74.8 64.8,41.5 61.8,41.5   '/><path d='M22.6,46.2l-2.1,13.1l13.1-2.1l1.3-1.4l0,0l39.8-39.7L63.7,5.2L24,44.9L22.6,46.2z M25.3,48.3l6.1,6.2L24,55.7L25.3,48.3z     M70.4,16.1l-3.9,4l-6.6-6.7l4-3.9L70.4,16.1z M57.7,15.5l6.7,6.7L33.8,52.7L27.2,46L57.7,15.5z'/></g></g></svg></td>"
						+ "<td><?xml version='1.0' ?><!DOCTYPE svg  PUBLIC '-//W3C//DTD SVG 1.1//EN'  'http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd'><svg width='30px' height='30px' enable-background='new 0 0 48 48' version='1.1' viewBox='0 0 48 48' xml:space='preserve' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink'><g id='Expanded'><g><g><path d='M41,48H7V7h34V48z M9,46h30V9H9V46z'/></g><g><path d='M35,9H13V1h22V9z M15,7h18V3H15V7z'/></g><g><path d='M16,41c-0.553,0-1-0.447-1-1V15c0-0.553,0.447-1,1-1s1,0.447,1,1v25C17,40.553,16.553,41,16,41z'/></g><g><path d='M24,41c-0.553,0-1-0.447-1-1V15c0-0.553,0.447-1,1-1s1,0.447,1,1v25C25,40.553,24.553,41,24,41z'/></g><g><path d='M32,41c-0.553,0-1-0.447-1-1V15c0-0.553,0.447-1,1-1s1,0.447,1,1v25C33,40.553,32.553,41,32,41z'/></g><g><rect height='2' width='48' y='7'/></g></g></g></svg></td>"
						+ "</tr>");
			} else {
				// Está activado
				out.println("<tr align='center'><td>" + c.getId() + "</td><td>" + c.getDesc() + "</td><td>Activo</td>"
						+ "<td><a href='editarCategoria.jsp?id=" + c.getId() + "' id='" + c.getId()
						+ "'><?xml version='1.0' ?><svg width='30px' height='30px' id='Layer_1' style='enable-background:new 0 0 80 80;' version='1.1' viewBox='0 0 80 80' xml:space='preserve' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink'><title/><g id='Layer_2'><g id='Layer_3'><polygon points='61.8,71.8 8.4,71.8 8.4,18.4 35.1,18.4 35.1,15.4 5.4,15.4 5.4,74.8 64.8,74.8 64.8,41.5 61.8,41.5   '/><path d='M22.6,46.2l-2.1,13.1l13.1-2.1l1.3-1.4l0,0l39.8-39.7L63.7,5.2L24,44.9L22.6,46.2z M25.3,48.3l6.1,6.2L24,55.7L25.3,48.3z     M70.4,16.1l-3.9,4l-6.6-6.7l4-3.9L70.4,16.1z M57.7,15.5l6.7,6.7L33.8,52.7L27.2,46L57.7,15.5z'/></g></g></svg></a></td>"
						+ "<td><a href='eliminarCategoria.jsp?id=" + c.getId() + "' id='" + c.getId()
						+ "'><?xml version='1.0' ?><!DOCTYPE svg  PUBLIC '-//W3C//DTD SVG 1.1//EN'  'http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd'><svg width='30px' height='30px' enable-background='new 0 0 48 48' version='1.1' viewBox='0 0 48 48' xml:space='preserve' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink'><g id='Expanded'><g><g><path d='M41,48H7V7h34V48z M9,46h30V9H9V46z'/></g><g><path d='M35,9H13V1h22V9z M15,7h18V3H15V7z'/></g><g><path d='M16,41c-0.553,0-1-0.447-1-1V15c0-0.553,0.447-1,1-1s1,0.447,1,1v25C17,40.553,16.553,41,16,41z'/></g><g><path d='M24,41c-0.553,0-1-0.447-1-1V15c0-0.553,0.447-1,1-1s1,0.447,1,1v25C25,40.553,24.553,41,24,41z'/></g><g><path d='M32,41c-0.553,0-1-0.447-1-1V15c0-0.553,0.447-1,1-1s1,0.447,1,1v25C33,40.553,32.553,41,32,41z'/></g><g><rect height='2' width='48' y='7'/></g></g></g></svg></a></td>"
						+ "</tr>");
			}
		}

		out.println("</table><br>");
		out.println("<a href='nuevaCategoria.jsp'>Nuevo</a>");

		out.println("</div>");
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
