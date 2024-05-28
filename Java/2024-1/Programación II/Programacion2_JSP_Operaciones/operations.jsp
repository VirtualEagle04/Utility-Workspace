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
    int num1 = Integer.parseInt(request.getParameter("num1"));
    int num2 = Integer.parseInt(request.getParameter("num2"));

    out.println("Sum: " + num1+num2);
    out.println("Subtraction Num1-Num2: " + num1-num2);
    out.println("Subtraction Num2-Num1: " + num2-num1);
    out.println("Multiplication: " + num1*num2);
    out.println("Divison Num1/Num2: " + num1/num2);
    out.println("Division Num2/Num1: " + num2/num1);
%>