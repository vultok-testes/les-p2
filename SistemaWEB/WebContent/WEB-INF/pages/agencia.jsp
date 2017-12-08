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
<body>

  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="#"><span
          class="glyphicon glyphicon-user"></span> Bem vindo ${uname}</a>
      </div>
      <ul class="nav navbar-nav">
        <li><a href="welcome">Home</a></li>
        <li><a href="funcionarios">Funcionários</a></li>
        <li><a href="eventos">Eventos</a></li>
        <li><a href="loja">Loja de Equipamentos</a></li>
        <li class="active"><a href="agencia">Agência de empregos</a></li>
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
  
  function contratar(arg){
      var dados = {
        fnome: document.getElementById("fnome" + arg).innerHTML,
        fsalario: document.getElementById("fsalario" + arg).innerHTML,
        frenmax: document.getElementById("frenmax"+ arg).innerHTML,
        ftaxaren: document.getElementById("ftaxaren"+ arg).innerHTML
      };
      
	  console.log(dados);
      
      $.post('contratar', dados, function(data) {
    	  alterBtn(arg);
      });
  }; 
  
  function alterBtn(arg) {
    var btn = document.getElementById("btn" + arg);
    btn.setAttribute("class", "btn btn-success disabled");
    btn.setAttribute("onclick", "");
    btn.innerHTML = "Contratado";
  }
  </script>
  
  <div class="container" id="mainDiv">
    <h1>Candidatos a vaga de Funcionário</h1>
    <p>Selecione os funcionários que mais se adequam à sua organização</p>           
  
    <table class="table">
      <thead>
        <tr>
          <th>Nome</th>
          <th>Salário</th>
          <th>Rendimento Máximo diário</th>
          <th>Taxa de Rendimento</th>
          <th>Contratar</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td id="fnome0">${fnome0}</td>
          <td id="fsalario0">${fsalario0}</td>
          <td id="frenmax0">${frenmax0}</td>
          <td id="ftaxaren0">${ftaxaren0}</td>
          <td>
            <button type="button" id="btn0" class="btn btn-primary" onclick=contratar(0) >Contratar</button>
          </td>
        </tr>
        <tr>
          <td id="fnome1">${fnome1}</td>
          <td id="fsalario1">${fsalario1}</td>
          <td id="frenmax1">${frenmax1}</td>
          <td id="ftaxaren1">${ftaxaren1}</td>
          <td>
            <button type="button" id="btn1" class="btn btn-primary" onclick=contratar(1)>Contratar</button>
          </td>
        </tr>
        <tr>
          <td id="fnome2">${fnome2}</td>
          <td id="fsalario2">${fsalario2}</td>
          <td id="frenmax2">${frenmax2}</td>
          <td id="ftaxaren2">${ftaxaren2}</td>
          <td>
            <button type="button" id="btn2" class="btn btn-primary" onclick=contratar(2)>Contratar</button>
          </td>
        </tr>
        <tr>
          <td id="fnome3">${fnome3}</td>
          <td id="fsalario3">${fsalario3}</td>
          <td id="frenmax3">${frenmax3}</td>
          <td id="ftaxaren3">${ftaxaren3}</td>
          <td>
            <button type="button" id="btn3" class="btn btn-primary" onclick=contratar(3)>Contratar</button>
          </td>
        </tr>
        <tr>
          <td id="fnome4">${fnome4}</td>
          <td id="fsalario4">${fsalario4}</td>
          <td id="frenmax4">${frenmax4}</td>
          <td id="ftaxaren4">${ftaxaren4}</td>
          <td>
            <button type="button" id="btn4" class="btn btn-primary" onclick=contratar(4)>Contratar</button>
          </td>
        </tr>
        <tr>
          <td id="fnome5">${fnome5}</td>
          <td id="fsalario5">${fsalario5}</td>
          <td id="frenmax5">${frenmax5}</td>
          <td id="ftaxaren5">${ftaxaren5}</td>
          <td>
            <button type="button" id="btn5" class="btn btn-primary" onclick=contratar(5)>Contratar</button>
          </td>
        </tr>
        <tr>
          <td id="fnome6">${fnome6}</td>
          <td id="fsalario6">${fsalario6}</td>
          <td id="frenmax6">${frenmax6}</td>
          <td id="ftaxaren6">${ftaxaren6}</td>
          <td>
            <button type="button" id="btn6" class="btn btn-primary" onclick=contratar(6)>Contratar</button>
          </td>
        </tr>
        <tr>
          <td id="fnome7">${fnome7}</td>
          <td id="fsalario7">${fsalario7}</td>
          <td id="frenmax7">${frenmax7}</td>
          <td id="ftaxaren7">${ftaxaren7}</td>
          <td>
            <button type="button" id="btn7" class="btn btn-primary" onclick=contratar(7)>Contratar</button>
          </td>
        </tr>
        <tr>
          <td id="fnome8">${fnome8}</td>
          <td id="fsalario8">${fsalario8}</td>
          <td id="frenmax8">${frenmax8}</td>
          <td id="ftaxaren8">${ftaxaren8}</td>
          <td>
            <button type="button" id="btn8" class="btn btn-primary" onclick=contratar(8)>Contratar</button>
          </td>
        </tr>
        <tr>
          <td id="fnome9">${fnome9}</td>
          <td id="fsalario9">${fsalario9}</td>
          <td id="frenmax9">${frenmax9}</td>
          <td id="ftaxaren9">${ftaxaren9}</td>
          <td>
            <button type="button" id="btn9" class="btn btn-primary" onclick=contratar(9)>Contratar</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>

</body>
</html>