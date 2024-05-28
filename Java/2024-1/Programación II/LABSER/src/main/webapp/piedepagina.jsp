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

			footer {
				position: fixed;
				left: 0;
				bottom: 0;
				width: 100%;
				background-color: gray;
				text-align: center;
			}
</style>
</head>
<body align="center">
	<footer>
		<%
			String remoteUser = request.getRemoteUser();
			String remoteHost = request.getRemoteHost();
			
			out.println("<p><b>ID de Sesi&oacute;n: </b><i>" + session.getId() + "</i></p>");
			out.println("<p><b>Usuario Remoto: </b><i>" + remoteUser + "</i></p>");
			out.println("<p><b>Anfitrion Remoto: </b><i>" + remoteHost + "</i></p>");
		%>
	
		<p>Contacto: Federico Vargas Rozo</p>
		<p>
			<a href="fvargasr@unbosque.edu.co">fvargasr@unbosque.edu.co</a>
			
		</p>
		<p>Copyright © 2024 Sistema de Compras en L&iacute;nea. All Rights Reserved</p>
	</footer>
</body>
</html>