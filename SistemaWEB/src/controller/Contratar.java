package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Empresa;
import model.Funcionario;
import model.User;
import services.FactoryFuncionario;
import services.ResourceManager;

/**
 * Servlet implementation class Contratar
 */
@WebServlet("/contratar")
public class Contratar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = (String) request.getSession().getAttribute(User.USER_NAME);
		User user = ResourceManager.getInstance().getUserByName(uname);
		Empresa e = user.getEmpresa();
		
		Funcionario funcionario = new FactoryFuncionario().getFuncionario();
		funcionario.setNome(request.getParameter("fnome"));
		funcionario.setSalario(Double.parseDouble(request.getParameter("fsalario")));
		funcionario.setRendimentoMaximo(Double.parseDouble(request.getParameter("frenmax")));
		funcionario.setTaxaRendimento(Double.parseDouble(request.getParameter("ftaxaren")));
		
		e.adicionarFuncionario(funcionario);
		
		String json = "{\"returnCode\": \"ok\"}";
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json"); 
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().write(json);
	}

}
