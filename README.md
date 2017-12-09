# les-p2
Repositório do aluno Elton Brandão, contendo o código do Sistema WEB para P2 de Lab. de Eng. de SW.
# Vídeo
Postei um vídeo explicando o funcionamento do sistema, por favor, assista antes.
<br>
https://youtu.be/Ut-jE2eUqa4
# Links
Link do site no MS-Azure: https://vultok-webapp.azurewebsites.net/
<br>
Postei também o projeto no Google Drive: https://drive.google.com/open?id=1WH036vURhTAioYXp11k9ahvulFCyRs1f 
<br>

# Sobre o Sistema
O sistema tem como foco a simulação da gerência de uma empresa, onde os funcionários - ocasionalmente - têm seus atributos afetados por eventos.
<br>
<p>
<strong>Padrões de projeto utilizados:</strong>
<ul>
  <li> Singleton: para gerenciamento dos recursos; </li>
  <li> Factory Method: para criação das classes de entidade. </li>
</ul>
</p> <p>
<strong>Tecnologia notáveis utilizadas: </strong>
<ul>
  <li> JSP; </li>
  <li> Servlets; </li>
  <li> Bootstrap; </li>
  <li> JQuery </li>
</ul>
</p>

# Instalação
<p>
Caso queira executar o sistema localmente, pelo Tomcat ou similares, recomendo fazer download da versão do projeto que está no Google Drive e fazer import pelo eclipse.
</p>
<p>
Eu usei tanto a versão 8.5 quanto a 9 do Apache Tomcat, então creio que com essas deve funcionar tranquilamente;

Para o java, utilizei as versões 1.8 (mais especificamente o releade 144, salvo erro meu) e a versão 9. Caso você possua uma versão mais antiga do java, como anteriores à 1.8_143, creio que será necessário alterar as configurações do projeto, sendo (salvo erro meu):
<ul><li>
  Abra as propriedades do projeto -> <b>Java build path</b> -> Altere para a sua versão;
  </li><li>
  Abra as propriedades do projeto -> <b>Project Facets</b> -> <b>Java</b> -> Selecione a versão que você tem instalada;
  </li><li>
  Caso não esteja usando a versão 9 do Tomcat: Propriedades do projeto -> <b>Targeted Runtimes</b> -> Selecione sua versão;
</li></ul>
</p>

# Contato
Por favor, se tiver alguma dúvida ou o sistema por alguma razão ficar fora do ar, sinta-se livre para me contatar através do meu e-mail: <b>elton.user0@gmail.com</b>
