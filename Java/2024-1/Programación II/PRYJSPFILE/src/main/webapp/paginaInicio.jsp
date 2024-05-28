<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pagina de Inicio</title>
<script language="JavaScript">
            function valida_envia(form){
                if(form.nombre.value==""){
                    alert("Escriba un Nombre!");
                    form.nombre.focus();
                    return;
                }
                if(form.apellidos.value==""){
                    alert("Escriba los Apellidos!");
                    form.apellidos.focus();
                    return;
                }
                if(form.prom.value==""){
                    alert("Escriba el Promedio!");
                    form.prom.focus();
                    return;
                }
                if(isNaN(form.prom.value)){
                    alert("El Promedio no es un Numero!");
                    form.num2.focus();
                    return;
                }
                if(form.prom.value > 5 || form.prom.value < 0){
                	alert("El Promedio no es un Numero valido!");
                	return;
                }
                
                form.submit();
            }
</script>
<style>
* {
	font-family: Arial, Helvetica, sans-serif;
}
.ingreso {
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
}
</style>
</head>
<body>
<div class="ingreso">
		<h1>Ingrese Datos del Estudiante</h1>
		<form action="paginaRegistro.jsp" method="post">
			<table align="center">
				<tr>
					<th>Nombres:</th>
					<td><input type="text" name="nombre"
						placeholder="Nombre" style="border: 2px solid;"></td>
				</tr>
				<tr>
					<th>Apellidos:</th>
					<td><input type="text" name="apellidos"
						placeholder="Apellidos" style="border: 2px solid;"></td>
				</tr>
				<tr>
					<th>Promedio:</th>
					<td><input type="text" name="prom"
						placeholder="Promedio ej. 2.9" style="border: 2px solid;"></td>
				</tr>
				<tr height="20px"></tr>
				<tr>
					<td colspan="2" align="center"><input type="button" onClick="valida_envia(this.form)" value="Registrar"></td>
				</tr>
			</table>

		</form>

	</div>


</body>
</html>