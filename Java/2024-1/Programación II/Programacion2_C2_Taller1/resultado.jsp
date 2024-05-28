<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
    <title>Resultados</title>
        <style>
            * {
                font-family: Arial, Helvetica, sans-serif;
            }
        </style>
    </head>
    <body align="center">
        <h1>Resultados</h1>

        <%
        String numeroString1 = request.getParameter("num1");
        String numeroString2 = request.getParameter("num2");
        String operacion = request.getParameter("operacion");
        
        float numero1 = Float.parseFloat(numeroString1);
        float numero2 = Float.parseFloat(numeroString2);

        switch(operacion){
            case "1": {
                //Suma
                float resultado = numero1 + numero2;
                String op = "Suma (+)";
                
                    out.println("<table align='center' border='1'><tr><th>N&uacute;mero 1</th><th>N&uacute;mero 2</th><th>Operaci&oacute;n</th><th>Resultado</th></tr><tr><td>"+numero1+"</td><td>"+numero2+"</td><td>"+op+"</td><td>"+resultado+"</td></tr></table>");
                

                break;
            }
            case "2": {
                //Resta
                float resultado = numero1 - numero2;
                String op = "Resta (-)";
                
                    out.println("<table align='center' border='1'><tr><th>N&uacute;mero 1</th><th>N&uacute;mero 2</th><th>Operaci&oacute;n</th><th>Resultado</th></tr><tr><td>"+numero1+"</td><td>"+numero2+"</td><td>"+op+"</td><td>"+resultado+"</td></tr></table>");
                

                break;
            }
            case "3": {
                //Multiplicacion
                float resultado = numero1 * numero2;
                String op = "Multiplicacion (*)";
                
                    out.println("<table align='center' border='1'><tr><th>N&uacute;mero 1</th><th>N&uacute;mero 2</th><th>Operaci&oacute;n</th><th>Resultado</th></tr><tr><td>"+numero1+"</td><td>"+numero2+"</td><td>"+op+"</td><td>"+resultado+"</td></tr></table>");
                

                break;
            }
            case "4": {     
                //Division
                float resultado = numero1 / numero2;
                String op = "Division (/)";
                
                    out.println("<table align='center' border='1'><tr><th>N&uacute;mero 1</th><th>N&uacute;mero 2</th><th>Operaci&oacute;n</th><th>Resultado</th></tr><tr><td>"+numero1+"</td><td>"+numero2+"</td><td>"+op+"</td><td>"+resultado+"</td></tr></table>");
            

                break;
            }
            case "5": {
                //Todas
                out.println("<table align='center' border='1'><tr><th>N&uacute;mero 1</th><th>N&uacute;mero 2</th><th>Operaci&oacute;n</th><th>Resultado</th></tr><tr><td>"+numero1+"</td><td>"+numero2+"</td><td>Suma (+)</td><td>"+(numero1 + numero2)+"</td></tr><tr><td>"+numero1+"</td><td>"+numero2+"</td><td>Resta (-)</td><td>"+(numero1 - numero2)+"</td></tr><tr><td>"+numero1+"</td><td>"+numero2+"</td><td>Multiplicaci&oacute;n (*)</td><td>"+(numero1 * numero2)+"</td></tr><tr><td>"+numero1+"</td><td>"+numero2+"</td><td>Divisi&oacute;n</td><td>"+(numero1 / numero2)+"</td></tr></table>");

                break;
            }
        }
        %>
    </body>

</html>