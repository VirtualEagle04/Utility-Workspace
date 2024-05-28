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
				background-color: silver;
				text-align: center;
			}
</style>
</head>
<body align="center">
<footer>
	<%@ page import="java.text.SimpleDateFormat, java.util.Date" %>
	<%		
			String remoteAddr = request.getRemoteAddr();
			String remoteUser = request.getRemoteUser();
			String remoteHost = request.getRemoteHost();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			
			out.println("<p><b>ID de Sesi&oacute;n: </b><i>" + session.getId() + "</i></p>");
			out.println("<p><b>Direcci&oacute;n Remota: </b><i>" + remoteAddr + "</i></p>");
			out.println("<p><b>Usuario Remoto: </b><i>" + remoteUser + "</i></p>");
			out.println("<p><b>Host Remoto: </b><i>" + remoteHost + "</i></p>");
			
			
			out.println("<br>");
			out.println("<p><b>EVALUACI&Oacute;N PARCIAL - SEGUNDO CORTE. FECHA-HORA: " + dateFormat.format(new Date()) + "</b></p>");
	%>
</footer>
</body>
</html>