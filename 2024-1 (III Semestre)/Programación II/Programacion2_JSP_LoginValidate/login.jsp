<%--Comentario .jsp--%>

<html>
    <head>
        <style>
            * {
                font-family: Arial, Helvetica, sans-serif;
            }
        </style>
    </head>

    <br><br><br><br><br><br><br><br>
    <form action="validate.jsp" method="post">
        <table align="center">
            <tr><th>User: </th><td><input type="text" name="user" required="true" placeholder="Username"></td></tr>
            <tr><th>Password: </th><td><input type="password" name="password" required="true" placeholder="Password"></td></tr>
            <tr><td colspan="2" align="center"><input type="submit" value="Log-In"></td></tr>
        </table>
    </form>
</html>
