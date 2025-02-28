<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro de Ventas</title>
<style>
* {
	font-family: Arial, Helvetica, sans-serif;
}

.panelcentral {
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
}
</style>
</head>
<body>

	<div class="panelcentral">
		<form action="VentaProducto" method="post">
			<table border="1">
				<tr>
					<th colspan="2">Registro de Ventas</th>
				</tr>
				<tr>
					<th>Producto:</th>
					<td><select name="producto" style="border: 1px solid;">
							<option value="Seleccionar">Seleccionar</option>
							<option value="Camisas">Camisas</option>
							<option value="Billeteras">Billeteras</option>
							<option value="Bolsos">Bolsos para Damas</option>
					</select></td>

				</tr>
				<tr>
					<th>Precio Unitario:</th>
					<td><input type="text" name="precio" size="20px"
						style="border: 1px solid;" /></td>
				</tr>
				<tr>
					<th>Cantidad:</th>
					<td><input type="text" name="cantidad" size="20px"
						style="border: 1px solid;" /></td>
				</tr>
				<tr>
					<th>Descuento (%):</th>
					<td><input type="text" name="descuento" size="20px"
						style="border: 1px solid;" /></td>
				</tr>
				<tr>
					<td colspan="2"><center><input type="submit" value="ACEPTAR"></center></td>
				</tr>

			</table>
		</form>
	</div>
	<%@ include file="pieparcial.jsp"%>

</body>
</html>