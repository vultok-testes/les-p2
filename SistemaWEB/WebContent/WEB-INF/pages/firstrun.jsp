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
<title>Crie sua empresa</title>
<style type="text/css">
body {
	color: #aaa;
	background-color: #272B30;
}
</style>
</head>
<body>

<div class="container">
	<div class="jumbotron text-center">
		<h1>Seja bem-vindo(a) ${uname}</h1>
		<h4>Parece que você ainda não nomeou sua empresa, por favor dê-a um nome único</h4>
	</div>
	<form class="form-horizontal" action="criarempresa" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="cname">Nome da empresa:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="cname"
						placeholder="Digite o nome da sua empresa" name="cname">
				</div>
			</div>			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">
						<span class="glyphicon glyphicon-ok"></span> Salvar
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