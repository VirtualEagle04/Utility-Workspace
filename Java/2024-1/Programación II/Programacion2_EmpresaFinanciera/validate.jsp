<html>
    <head>
        <style>
            * {
                font-family: Arial, Helvetica, sans-serif;
            }
        </style>
    </head>
</html>

<%
    String user = request.getParameter("user");
    String password = request.getParameter("password");

    if("admin".equals(user) && "admin".equals(password)){
%>
    <jsp:forward page="admin.jsp"/>
<%
    }else{
%>
    <jsp:forward page="accessError.jsp"/>
<%
    }
%>
