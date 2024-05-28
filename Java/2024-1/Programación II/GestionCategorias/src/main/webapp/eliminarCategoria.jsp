<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eliminar Categor&iacute;a</title>
<style>
* {
	font-family: JetBrains Mono, monospace;
}

body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
	background-color: #e8f0fe;
}

table {
	border: 1px solid black;
	border-collapse: collapse;
}

.panelcentral {
	background-color: white;
	padding: 20px;
	text-align: center;
	border-radius: 15px;
}

input {
	display: block;
	width: 90%;
	margin: 10px auto;
	padding: 8px;
}

.boton {
	display: block;
	width: 90%;
	margin: 10px auto;
	padding: 8px;
	background-color: #4caf50;
	color: white;
	border: none;
	cursor: pointer;
	border-radius: 10px;
}

tr {
	border-bottom: 1px solid black;
	}
</style>
</head>
<%@ page
	import="co.edu.unbosque.model.Categoria, co.edu.unbosque.util.EscribeLeeArchivo, java.util.ArrayList"%>
<%
int idCategoria = Integer.parseInt(request.getParameter("id"));

ServletContext sc = this.getServletContext();
String ruta = sc.getRealPath("/WEB-INF/categoria.txt");
ruta = ruta.replace('\\', '/');
ArrayList<Categoria> categorias = EscribeLeeArchivo.leer(ruta);

Categoria aEliminar = null;
for (Categoria c : categorias) {
	if (c.getId() == idCategoria) {
		aEliminar = c;
	}
}
%>

<body align="center">

	<div class="panelcentral" align="center">
		<form action="MostrarDatos" method="post">
			<input type="text" value="eliminar" name="validacion" style="display: none;" contenteditable="false">
			<%
			out.println("<input type='text' value='" + aEliminar.getId() + "' name='categoria' style='display:none; ' contenteditable='false'>");
			%>
			<h1>Eliminar Categor&iacute;a</h1>
			<table width='500'>
				<tr style="background-color:lightgray;">
					<th>ID</th>
					<th>Descripci&oacute;n</th>
					<th>Estado</th>
				</tr>
				<%
				out.println("<tr><td>" + aEliminar.getId() + "</td><td>" + aEliminar.getDesc() + "</td><td>" + (aEliminar.getEstado().equals("A") ? "Activo" : "Inactivo") + "</td></tr>");
				%>
			</table>
			<h4>¿Est&aacute; seguro de que desea eliminar esta
				Categor&iacute;a?</h4>
			<input type="button" value="Cancelar" onclick="history.back()" class="boton">
			<input type="submit" value="Eliminar" class="boton">
		</form>
	</div>

</body>
</html>