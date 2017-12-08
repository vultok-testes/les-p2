<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página de Login</title>
<style type="text/css">
body {
	color: #aaa;
	background-color: #272B30;
}
</style>
</head>
<body>

	<div class="container">
		<h2>Login</h2>
		<form class="form-horizontal" action="login" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="uname">Usuário:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="uname"
						placeholder="Digite o usuário" name="uname">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="upwd">Senha:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="upwd"
						placeholder="Digite a senha" name="upwd">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">
						<span class="glyphicon glyphicon-log-in"></span> Login
					</button>
				</div>
			</div>
		</form>
		<div class="alert alert-danger" style="display: ${divDisplayStyle}">
  			<strong>${message}</strong>
		</div>
	</div>
</body>
</html>