<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Calculadora</title>
        <script language="JavaScript">
            function isNumber(value){
                return typeof value == 'number';
            }

            function valida_envia(form){
                if(form.num1.value === ""){
                    alert("Numero 1 esta vacio!");
                    form.num1.focus();
                    return;
                }else if(isNaN(form.num1.value)){
                    alert("Numero 1 no es un Numero!");
                    form.num2.focus();
                    return;
                }

                if(form.num2.value === ""){
                    alert("Numero 2 esta vacio!");
                    form.num2.focus();
                    return;
                }else if(isNaN(form.num2.value)){
                    alert("Numero 2 no es un Numero!");
                    form.num2.focus();
                    return;
                }


                if(form.operacion.value == "0"){
                    alert("Debe seleccionar una operacion!");
                    form.operacion.focus();
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
        <h1>Calculadora</h1>
        <br><br>
        <form action="resultado.jsp" method="post">
            <table align="center">
                <tr><th>N&uacute;mero 1: </th><td><input type="text" name="num1"></td></tr>
                <tr><th>N&uacute;mero 2: </th><td><input type="text" name="num2"></td></tr>
                <tr><th>Operaci&oacute;n: </th>
                    <td>
                        <select name="operacion">
                            <option value="0">Seleccionar</option>
                            <option value="1">Suma</option>
                            <option value="2">Resta</option>
                            <option value="3">Multiplicaci&oacute;n</option>
                            <option value="4">Divisi&oacute;n</option>
                            <option value="5">Todas</option>
                        </select>
                    </td>
                </tr>
                <tr><td colspan="2" align="center"><input type="button" value="Aceptar" onClick="valida_envia(this.form)"/></td></tr>
            </table>

        </form>
    </body>
</html>