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
        <li><a href="funcionarios">Funcionários</a></li>
        <li class="active"><a href="eventos">Eventos</a></li>
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
      $.post('eventos', function(data) {
        console.log(data);
        console.log(data.events.length);
        if(data.events.length > 0) {
        	mountTable(data);
        }
      });
  }; 
  
  function mountTable(data) {
    var table = document.getElementById("eventTable");
    var tbody = document.createElement("TBODY");
    
    for(var i = 0; i < data.events.length; i++)
	{
		var row = document.createElement("TR");
		tbody.appendChild(row);
		var tipos = new Array();
		tipos[0] = "Comum";
		tipos[1] = "Incomum";
		tipos[2] = "WTF";
		tipos[3] = "Raro";
		tipos[4] = "Muito Raro";
		var atr = new Array();
		atr[0] = "Salário";
		atr[1] = "Rendimento máximo";
		atr[2] = "Taxa de rendimento";
		
		var cell1 = document.createElement("TD");
		cell1.innerHTML = tipos[data.events[i].type];
		console.log(data.events[i].type);
		var cell2 = document.createElement("TD");
		cell2.innerHTML = 'funcionário ' + data.events[i].desc;
		var cell3 = document.createElement("TD");
		cell3.innerHTML = (data.events[i].fator * 100) + '%';
		var cell4 = document.createElement("TD");
		cell4.innerHTML = atr[data.events[i].attrib];
		
		row.appendChild(cell1);
		row.appendChild(cell2);
		row.appendChild(cell3);
		row.appendChild(cell4);
		
	}
	
    table.appendChild(tbody);
  }
  </script>
  
  <div class="container" id="mainDiv">
    <h1>Eventos do dia</h1>
    <p>Está página mostra os eventos dos funcionários do dia atual</p>           
  
    <table class="table" id="eventTable">
      <thead>
        <tr>
          <th>Tipo</th>
          <th>Descrição</th>
          <th>Fator</th>
          <th>Atributo afetado</th>
        </tr>
      </thead>
    </table>
  </div>

</body>
</html>