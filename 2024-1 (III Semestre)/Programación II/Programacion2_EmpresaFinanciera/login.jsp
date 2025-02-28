<%--
Ejercicio Corte 2 Empresa Financiera

1. Admin puede agregar Entidades en las que el usuario puede pagar.
2. El usuario DEBE REGISTRARSE para hacer un pago.
3. Podemos recordar datos que el usuario quiera, para sugerirlos una proxima entrada.
 
--%>

<html>
    <head>
        <title>Login</title>
        <script language="JavaScript">
            function valida_envia(form){
                if(form.user.value==""){
                    alert("User is needed!");
                    form.long.focus();
                    return;
                }
                if(form.password.value==""){
                    alert("Password is needed!");
                    form.clave.focus();
                    return;
                }
                form.submit();
            }
        </script>
        <style>
            * {
                font-family: Arial, Helvetica, sans-serif;
            }
        </style>
    </head>

    <body align="center">
        Hoy es: <%@ include file="date.jsp" %>

        <h1>Log-In</h1>
        <br><br>
        <form action="show.jsp" method="post">
            <table align="center">
                <tr><th>User: </th><td><input type="text" name="user" placeholder="Username"></td></tr>
                <tr><th>Password: </th><td><input type="password" name="password" placeholder="Password"></td></tr>
                <tr><td colspan="2" align="center"><input type="button" value="Login" onClick="valida_envia(this.form)"/></td></tr>
            </table>

        </form>
    </body>
</html>
