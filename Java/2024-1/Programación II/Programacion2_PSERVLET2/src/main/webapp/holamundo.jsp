<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<p>Hola, este texto se escribe desde la p�gina JSP.</p>

	<form action="HolaMundoServlet" method="get">
	     Palabra:<input type="text" name="palabra"/></br>
		<button type="submit">Get Mensaje</button>
	</form>
	<br>
	<form action="HolaMundoServlet" method="post">
	     Palabra:<input type="text" name="palabra"/></br>
		<button type="submit">Post Mensaje</button>
	</form>

</body>
</html>