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
            <tr><th colspan="2">TRANSACCI&Oacute;N</th></tr>
            <tr><th>Valor</th><td align="center"><input type="text" name="valor" placeholder = "0" required="true"></td></tr>
            <tr>
                <th>Banco</th>
                <td align="center">
                    <select name="banco">
                        <option value="Seleccionar">Seleccionar</option>
                        <option value="Banco Caja Social">Banco Caja Social</option>
                        <option value="Bancolombia">Bancolombia</option>
                        <option value="Davivienda">Davivienda</option>
                        <option value="Nequi">Nequi</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Franquicia</th>
                <td align="center">
                    <select name="franquicia">
                        <option value="Seleccionar">Seleccionar</option>
                        <option value="Mastercard">Mastercard</option>
                        <option value="Visa">Visa</option>
                        <option value="American Express">American Express</option>
                        <option value="Diners Club">Diners Club</option>
                    </select>
                </td>
            </tr>
            <tr><th>N&uacute;mero de Tarjeta de Cr&eacute;dito</th><td align="center"><input type="text" name="numero" placeholder="1234567890123456" minlength="15" maxlength="16"></td></tr>
            <tr><td align="center" colspan="2"><input type="submit" value="CONFIRMAR COMPRA" name="submit"></td></tr>
        </table>
    </form>
</html>