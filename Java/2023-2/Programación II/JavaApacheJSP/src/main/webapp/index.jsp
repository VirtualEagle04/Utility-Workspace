<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>


<title>Java - Apache - JSP</title>
<link rel="stylesheet" href="styles/styles.css">

<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto+Mono&display=swap" rel="stylesheet">

</head>
<body>
	<h1>Create (doPost)</h1>
	<form action="usercontrollerservlet" method="POST">
		<div class="input-group mb-3">
			<span class="input-group-text">@</span>
			<div class="form-floating">
				<input type="text" class="form-control" id="username"
					name="username" placeholder="Username"> <label
					for="username">Username</label>
			</div>
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text">@</span>
			<div class="form-floating">
				<input type="password" class="form-control" id="password"
					name="password" placeholder="Password"> <label
					for="password">Password</label>
			</div>
		</div>
		<button type="submit" class="btn btn-primary mb-3">Login</button>
	</form>
	<hr>
	<h1>Display (doGet)</h1>
	<form action="usercontrollerservlet" method="GET">
		<button type="submit" class="btn btn-primary mb-3">Show all
			Users</button>
	</form>
	<hr>
	<h1>Update (doPut)</h1>
	<form action="usercontrollerservlet" method="PUT">
		<div class="input-group mb-3">
			<span class="input-group-text">@</span>
			<div class="form-floating">
				<input type="text" class="form-control" id="username"
					name="username" placeholder="Username"> <label
					for="username">Username</label>
			</div>
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text">@</span>
			<div class="form-floating">
				<input type="password" class="form-control" id="password"
					name="password" placeholder="Password"> <label
					for="password">Password</label>
			</div>
		</div>
		<div class="input-group mb-3">
			<input type="number" class="form-control" id="index" name="index"
				placeholder="Update Index">
		</div>
		<button type="submit" class="btn btn-primary mb-3">Login</button>
	</form>
</body>
</html>