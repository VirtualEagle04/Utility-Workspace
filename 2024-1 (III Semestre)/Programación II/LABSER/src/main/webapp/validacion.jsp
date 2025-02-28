<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
* {
	font-family: Arial, Helvetica, sans-serif;
}

.validacion {
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
	border: 1px solid;
	background-color: gray;
	broder-radius: 10px;
}
</style>
</head>

<%
String usuario = request.getParameter("user");
String contrasena = request.getParameter("password");

String CARACTERES_ESPECIALES = "[ $#%&]";

boolean tieneMayusculas = contrasena.chars().anyMatch(Character::isUpperCase);
boolean tieneMinusculas = contrasena.chars().anyMatch(Character::isLowerCase);
boolean tieneNumero = contrasena.chars().anyMatch(Character::isDigit);
boolean tieneCaracter = contrasena.matches(".*" + CARACTERES_ESPECIALES + ".*");
%>

<body>
	<%@ include file="encabezado.jsp"%>
	<div class="validacion">
		<%
		if (tieneMayusculas && tieneMinusculas && tieneNumero && tieneCaracter) {
		%>
		<jsp:forward page="registro.jsp" />
		<%
		} else {
		%>
		<h1>Contrase&ntilde;a NO contiene todos los caracteres
			requeridos.</h1>
		<p>Recuerda que el formato de la contrase&ntilde;a requiere una
			Mayuscula, una Minuscula, un N&uacute;mero y un caracter entre $, #,
			%, &.</p>
		<%
		}
		%>
	</div>
	<%@ include file="piedepagina.jsp"%>
</body>

</html>