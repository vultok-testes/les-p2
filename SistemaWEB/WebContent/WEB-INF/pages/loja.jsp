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
<title>Loja</title>
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
        <li class="active"><a href="loja">Loja de Equipamentos</a></li>
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
  
  function submitForm(){
	  	var dados = {
  			qtdCadeiras: document.getElementById("qtdCadeiras").value,
  			qtdMesas: document.getElementById("qtdMesas").value,
  			qtdPcLesma: document.getElementById("qtdPcLesma").value,
	  		qtdPcCor: document.getElementById("qtdPcCor").value,
	  		qtdPcPastel: document.getElementById("qtdPcPastel").value,
  			qtdPcFoguete: document.getElementById("qtdPcFoguete").value
	  	};

	    $.post('comprar', dados, function(data) {
	    	showAlert(data);
	    });
	    /*
	    $.ajax({
	       type: "POST",
	       url: "/comprar",
	       data: $(this).serialize(),
	       success: function() {
	         console.log('success');
	       },
	       error: function() {
	    	   console.log("error");
	       }
	    });*/
	}; 
	
	function showAlert(data) {
		var div = document.createElement("DIV");
		if(data.returnCode == 0) {
			div.setAttribute("class", "alert alert-success fade in");
		} else {
			div.setAttribute("class", "alert alert-danger fade in");
		}
		var a = document.createElement("A");
		a.setAttribute("class", "close");
		a.setAttribute("href", "#");
		a.setAttribute("data-dismiss", "alert");
		var aText = document.createTextNode("x");
		a.appendChild(aText);
		var text = document.createTextNode(data.message);
		div.appendChild(a);
		div.appendChild(text);
		
		var divMain = document.getElementById("mainDiv");
		divMain.appendChild(div);
	}
  </script>
  
  <form action="comprar" method="post" id="formCompra">
  <div class="container" id="mainDiv">
    <h1>Loja de Equipamentos</h1>
    <p>Escolha os equipamentos necesários à sua organização</p>           
  
    <table class="table">
      <thead>
        <tr>
          <th>Componente</th>
          <th>Descrição</th>
          <th>Preço</th>
          <th>Comprar </th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>${cadeiraNome}</td>
          <td>${cadeiraDescricao}</td>
          <td>${cadeiraPreco}</td>
          <td>
            <input type="number" name="qtdCadeiras" 
              id="qtdCadeiras" class="form-control" placeholder="0">
          </td>
        </tr>
        <tr>
          <td>${mesaNome}</td>
          <td>${mesaDescricao}</td>
          <td>${mesaPreco}</td>
          <td>
            <input type="number" name="qtdMesas" 
              id="qtdMesas" class="form-control" placeholder="0">
          </td>
        </tr>
        <tr>
          <td>${pc_lesmaNome}</td>
          <td>${pc_lesmaDescricao}</td>
          <td>${pc_lesmaPreco}</td>
          <td>
            <input type="number" name="qtdPcLesma" 
              id="qtdPcLesma" class="form-control" placeholder="0">
          </td>
        </tr>
        <tr>
          <td>${pc_corNome}</td>
          <td>${pc_corDescricao}</td>
          <td>${pc_corPreco}</td>
          <td>
            <input type="number" name="qtdPcCor" 
              id="qtdPcCor" class="form-control" placeholder="0">
          </td>
        </tr>
        <tr>
          <td>${pc_pastelNome}</td>
          <td>${pc_pastelDescricao}</td>
          <td>${pc_pastelPreco}</td>
          <td>
            <input type="number" name="qtdPcPastel" 
              id="qtdPcPastel" class="form-control" placeholder="0">
          </td>
        </tr>
        <tr>
          <td>${pc_fogueteNome}</td>
          <td>${pc_fogueteDescricao}</td>
          <td>${pc_foguetePreco}</td>
          <td>
            <input type="number" name="qtdPcFoguete" 
              id="qtdPcFoguete" class="form-control" placeholder="0">
          </td>
        </tr>
      </tbody>
    </table>
    <button type="button" class="btn btn-primary" onclick="submitForm()">Comprar</button>
  </div>
  </form>

</body>
</html>