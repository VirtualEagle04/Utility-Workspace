<html>
    <head>
        <style>
            * {
                font-family: Arial, Helvetica, sans-serif;
            }
        </style>
    </head>

    <form action="resultado.jsp" method="post">
        <table align="center" border="1">
            <tr><th colspan="2">REGISTRO DE COMPRAS</th></tr>
            <tr>
                <th>Art&iacute;culo</th>
                <td align="center">
                    <select name="articulo">
                        <option value="Seleccionar">Seleccionar</option>
                        <option value="Zapatos">Zapatos</option>
                        <option value="Camisa">Camisa</option>
                        <option value="Reloj">Reloj</option>
                        <option value="Libro">Libro</option>
                        <option value="Computador">Computador</option>
                    </select>
                </td>
            </tr>
            <tr><th>Cantidad</th><td align="center"><input type="text" name="cantidad" required="true"></td></tr>
            <tr><th>Precio por Unidad</th><td align="center"><input type="text" name="precioPorUnidad" required="true"></td></tr>
            <tr>
                <th>Tarjeta de Cr&eacute;dito</th>
                <td align="center">
                    <select name="tarjeta">
                        <option value="Mastercard">Mastercard</option>
                        <option value="Visa">Visa</option>
                        <option value="American Express">American Express</option>
                        <option value="Diners Club">Diners Club</option>
                    </select>
                </td>
            </tr>
            <tr><th>N&uacute;mero de Tarjeta de Cr&eacute;dito</th><td align="center"><input type="text" name="numero" required="true" minlength="15" maxlength="16"></td></tr>
            <tr><td align="center" colspan="2"><input type="submit" value="CONFIRMAR COMPRA" name="submit"></td></tr>
        </table>
    </form>
</html>