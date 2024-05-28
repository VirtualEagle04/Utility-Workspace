<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Categor&iacute;a</title>
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

Categoria aEditar = null;
for (Categoria c : categorias) {
	if (c.getId() == idCategoria) {
		aEditar = c;
	}
}
%>

<body align="center">
	<div class="panelcentral" align="center">
		<form action="MostrarDatos" method="post">
			<input type="text" value="editar" name="validacion"
				style="display: none;" contenteditable="false">
			<%
			out.println("<input type='text' value='" + aEditar.getId()
					+ "' name='categoria' style='display:none; ' contenteditable='false'>");
			%>
			<h1>Editar Categor&iacute;a</h1>
			<table align="center">
				<tr>
					<th>Descripci&oacute;n:</th>
					<% out.println("<td><input required type='text' name='descripcion' value='"+ aEditar.getDesc() +"' style='width: 350px;'></td>"); %>
					
				</tr>
				<tr>
					<th>Estado:</th>
					<td align="center">
					<select name="estado">
						<option value="Activo">Activo</option>
						<option value="Inactivo">Inactivo</option>
					</select>
					</td>
				</tr>
				
			</table>
			<h4>¿Est&aacute; seguro de que desea editar esta
				Categor&iacute;a?</h4>
			<input type="button" value="Cancelar" onclick="history.back()" class="boton">
			<input type="submit" value="Editar" class="boton">
		</form>

	</div>

</body>
</html>