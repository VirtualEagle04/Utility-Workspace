<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>This is a normal HTML Header</h1>

	<%
	out.write("This is a Java Statement");
	out.write(new Date().toString());
	%>
	<br>
	<%=Math.sqrt(9)%>
</body>
</html>