<%@page import="co.edu.unbosque.model.UserDTO"%>
<%@page import="co.edu.unbosque.model.persistance.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

UserDAO uDAO = new UserDAO();
for(UserDTO u : uDAO.getUsers()){
	
}


%>

</body>
</html>