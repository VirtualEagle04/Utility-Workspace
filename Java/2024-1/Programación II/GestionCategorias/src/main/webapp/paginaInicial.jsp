<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio de Sesión</title>
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

.login-form {
	background-color: white;
	padding: 20px;
	text-align: center;
	border-radius: 15px;
}

input{
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
<body>
	<div class="login-form">
		<h1>Inicio de Sesi&oacute;n</h1>
		<form action="MostrarDatos" method="post">
		<input type="text" value="inicio" name="validacion" style="display:none; " contenteditable="false">
			<input type="text" name="usuario" placeholder="Usuario" required>
			<input type="password" id="contrasena" name="contrasena" placeholder="Contrase&ntilde;a" required>
			<input type="submit" value="Continuar" class="boton">
		</form>
	</div>
</body>
</html>