<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar Nueva Categor&iacute;a</title>
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
<body align="center">

	<div class="panelcentral">
		<h1>Registrar Nueva Categor&iacute;a</h1>
		<form action="MostrarDatos" method="post">
			<input type="text" value="crear" name="validacion" style="display: none;" contenteditable="false">
			<table align="center">
				<tr>
					<td><input required type="text" name="descripcion" placeholder="Descipci&oacute;n" style="width: 350px;"></td>
				</tr>
				<tr height="20px"></tr>
				<tr>
					<td><input type="submit" value="Aceptar" class="boton"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>