<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log-In</title>
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

.login {
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
}
</style>

</head>

<body align="center">
	<%@ include file="encabezado.jsp"%>

	<div class="login">
		<h1>Log-In</h1>
		<form action="validacion.jsp" method="post">
			<table align="center">
				<tr>
					<th>User:</th>
					<td><input type="text" maxlength="5" name="user"
						placeholder="Username" style="border: 2px solid;"></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" maxlength="5" name="password"
						placeholder="Password" style="border: 2px solid;"></td>
				</tr>
				<tr height="20px"></tr>
				<tr>
					<td colspan="2" align="center"><input type="button"
						value="Login" onClick="valida_envia(this.form)"></td>
				</tr>
			</table>

		</form>

	</div>

	<%@ include file="piedepagina.jsp"%>
</body>
</html>