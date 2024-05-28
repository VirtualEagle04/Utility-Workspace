<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro de Compra</title>
<style>
* {
	font-family: Arial, Helvetica, sans-serif;
}

.panelcentral {
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
	border: 1px solid;
	background-color: rgb(222, 222, 222);
	border-radius: 10px;
}
</style>
</head>
<body>
	<%@ include file="encabezado.jsp"%>

	<div class="panelcentral">
		<form action="ProcesoCompra" method="post">
			<table>
				<tr>
					<th colspan="2">Registro de Compras</th>
				</tr>
				<tr height="20px"></tr>
				<tr>
					<th>Art&iacute;culo:</th>
					<td><select name="articulo">
							<option value="Seleccionar">Seleccionar</option>
							<option value="Camisa">Camisa</option>
							<option value="Reloj">Reloj</option>
							<option value="Libro">Libro</option>
							<option value="Computador">Computador</option>
					</select></td>

				</tr>
				<tr>
					<th>Cantidad:</th>
					<td><input type="text" name="cantidad" size="20px"
						style="border: 1px solid;" /></td>
				</tr>
				<tr>
					<th>Precio por Unidad:</th>
					<td><input type="text" name="precio" size="20px"
						style="border: 1px solid;" /></td>
				</tr>
				<tr>
					<th>Nombres del Cliente:</th>
					<td><input type="text" name="nombre" size="40px"
						style="border: 1px solid;" /></td>
				</tr>
				<tr>
					<th>Apellidos del Cliente:</th>
					<td><input type="text" name="apellidos" size="40px"
						style="border: 1px solid;" /></td>
				</tr>
				<tr>
					<th>N&uacute;mero de tarjeta de cr&eacute;dito:</th>
					<td><input type="text" name="tarjeta" minlength="15"
						maxlength="16" size="40px" style="border: 1px solid;" /></td>
				</tr>
				<tr>
					<th>Confirmar n&uacute;mero de tarjeta de cr&eacute;dito:</th>
					<td><input type="text" name="confirmacion" minlength="15"
						maxlength="16" size="40px" style="border: 1px solid;" /></td>
				</tr>
				<tr height="20px"></tr>
				<tr>
					<td colspan="2"><input type="submit" align="center"
						value="CONFIRMAR COMPRA"></td>
				</tr>

			</table>
		</form>
	</div>


	<%@ include file="piedepagina.jsp"%>

</body>
</html>