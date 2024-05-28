<%
    String c1=request.getParameter("user");
    String c2=request.getParameter("password");
%>

<html>
    <head>
        <title>Atender formJSP</title>
        <style>
            * {
                font-family: Arial, Helvetica, sans-serif;
            }
        </style>
    </head>
    <body align="center">
        <% out.println("<h1>Resultado del Formulario</h1>"); %>
        <p>Los valores introducidos en el formulario son:</p>
        <% if (c1.equals(c2)){ %>
            <p>Has introducido el mismo valor para Campo 1 y Campo 2: <%=c1%></p>
        <% }else{%>
            <p><b>Campo 1: </b><%=c1%></p>
            <p><b>Campo 2: </b> <%=c2%></p>
        <% } %>
    </body>
</html>