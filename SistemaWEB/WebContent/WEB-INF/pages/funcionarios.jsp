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
<title>Agência de Empregos</title>
<style type="text/css">
body {
  color: #aaa;
  background-color: #272B30;
}
</style>
</head>
<body onload=getEventos()>

  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="#"><span
          class="glyphicon glyphicon-user"></span> Bem vindo ${uname}</a>
      </div>
      <ul class="nav navbar-nav">
        <li><a href="welcome">Home</a></li>
        <li class="active"><a href="funcionarios">Funcionários</a></li>
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
  
  function getEventos(){
      $.post('funcionarios', function(data) {
        console.log(data);
        console.log(data.funcionarios.length);
        if(data.funcionarios.length > 0) {
          mountTable(data);
        }
      });
  }; 
  
  function mountTable(data) {
    var table = document.getElementById("eventTable");
    var tbody = document.createElement("TBODY");
    
    for(var i = 0; i < data.funcionarios.length; i++) {
      var row = document.createElement("TR");
      tbody.appendChild(row);
      
      var cell1 = document.createElement("TD");
      cell1.innerHTML = data.funcionarios[i].nome;
      var cell2 = document.createElement("TD");
      cell2.innerHTML = data.funcionarios[i].salario;
      var cell3 = document.createElement("TD");
      cell3.innerHTML = data.funcionarios[i].rendimento;
      var cell4 = document.createElement("TD");
      cell4.innerHTML = (data.funcionarios[i].taxa * 100) + '%';
      
      row.appendChild(cell1);
      row.appendChild(cell2);
      row.appendChild(cell3);
      row.appendChild(cell4);
      
    }
  
    table.appendChild(tbody);
  }
  </script>
  
  <div class="container" id="mainDiv">
    <h1>Funcionários Contratados</h1>
    <p>Está página mostra os funcionários da sua empresa</p>           
  
    <table class="table" id="eventTable">
      <thead>
        <tr>
          <th>Nome</th>
          <th>Salario</th>
          <th>Rendimento Máximo</th>
          <th>Taxa de rendimento</th>
        </tr>
      </thead>
    </table>
  </div>

</body>
</html>