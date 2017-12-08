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
<title>Bem vindo ${uname}</title>
<style type="text/css">
body {
	color: #aaa;
	background-color: #272B30;
}
</style>
</head>
<body>

  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="#"><span
          class="glyphicon glyphicon-user"></span> Bem vindo ${uname}</a>
      </div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="welcome">Home</a></li>
        <li><a href="funcionarios">Funcionários</a></li>
        <li><a href="eventos">Eventos</a></li>
        <li><a href="loja">Loja de Equipamentos</a></li>
        <li><a href="agencia">Agência de empregos</a></li>
      </ul>
      <p class="navbar-text">Dia: ${dias}</p>
      <button class="btn btn-primary navbar-btn" onclick="nextDay()">Próximo dia</button>
      <ul class="nav navbar-nav navbar-right">
        <li>
          <button type="button" class="btn btn-success navbar-btn"
            onclick="logout()">
            <span class="glyphicon glyphicon-log-out"></span> Log out
          </button>
        </li>
      </ul>
    </div>
  </nav>
  
  <script>
  	function nextDay() {
  		$.post('nextday', function(data) {
  			window.location.href = "./eventos";
  		});
  	};
  	
	function logout() {
		$.post('logout', function(data) {
			window.location.href = "./";
		});
	};
  </script>

  <div class="container">
    
    <h2>Sumário de sua empresa</h2>
    
    <div class="panel panel-default" id="dadosFinanceirosDiv">
      <div class="panel-heading">Situação financeira</div>
      <div class="panel-body">
        <ul class="list-group">
          <li class="list-group-item">Saldo : ${saldoEmpresa}</li>
          <li class="list-group-item">Rendimento diário: ${lucroDiario}</li>
          <li class="list-group-item">Despesa diária: ${despesaDiaria}</li>
        </ul>
      </div>
    </div>
    
    <div class="panel panel-default" id="dadosFuncionariosDiv">
      <div class="panel-heading">Funcionários</div>
      <div class="panel-body">
        <ul class="list-group">
          <li class="list-group-item">Total : ${qtdFuncionarios}</li>
        </ul>
      </div>
    </div>
    
    <div class="panel panel-default" id="dadosMateriasDiv">
      <div class="panel-heading">Ativos</div>
      <div class="panel-body">
        <ul class="list-group">
          <li class="list-group-item">Cadeiras : ${qtdCadeiras}</li>
          <li class="list-group-item">Mesas: ${qtdMesas}</li>
          <li class="list-group-item">PCs: ${qtdPCs}</li>
        </ul>
      </div>
    </div>
    
  </div>

</body>
</html>