<%--Comentario .jsp--%>

<%
    //Capturamos datos provenientes de "login.jsp"
    String user = request.getParameter("user");
    String password = request.getParameter("password");

    if(user.equals("admin") && password.equals("admin")){
        out.println("Datos Validos. ");
    }else{
        out.println("Datos Invalidos. ");
    }
%>

<html>
    <head>
        <style>
            * {
                font-family: Arial, Helvetica, sans-serif;
            }
        </style>
    </head>
</html>
