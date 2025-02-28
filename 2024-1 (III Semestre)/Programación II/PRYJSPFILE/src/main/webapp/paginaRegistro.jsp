<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registro de Datos</title>
<style>
* {
	font-family: Arial, Helvetica, sans-serif;
}

.respuesta {
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
}
</style>
</head>
<body>
	<%@ page
		import="co.edu.unbosque.logic.EscribeArchivo, co.edu.unbosque.entity.Estudiante, java.util.Scanner, java.io.File"%>
	<%
	String nombre = request.getParameter("nombre");
	String apellidos = request.getParameter("apellidos");
	String promedio = request.getParameter("prom");

	Estudiante est = new Estudiante(nombre, apellidos, Double.parseDouble(promedio));

	ServletContext sc = this.getServletContext();
	String ruta = sc.getRealPath("/WEB-INF/promedios.txt");
	ruta = ruta.replace('\\', '/');

	EscribeArchivo.adicionar(est, ruta);

	// Traer valores a tabla
	Scanner scanner = new Scanner(new File(sc.getRealPath("/WEB.INF/promedios.txt").replace('\\', '/')));
	scanner.useDelimiter(",");
	while (scanner.hasNext()) {
		System.out.println(scanner.next());
	}
	scanner.close();
	%>




	<div class="respuesta">
		<h2>El registro se realizó con éxito</h2>
		<a align="center" href="paginaInicio.jsp">Volver al Inicio</a>
	</div>


</body>
</html>