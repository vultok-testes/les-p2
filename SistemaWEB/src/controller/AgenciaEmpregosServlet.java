package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/agencia")
public class AgenciaEmpregosServlet extends HttpServlet implements WebPageRenderer {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		render(request, response);
	}
	
	@Override
	public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/agencia.jsp");
		
		String uname = (String) request.getSession().getAttribute(User.USER_NAME);
		ResourceManager rs = ResourceManager.getInstance();
		User user = rs.getUserByName(uname);
		FactoryFuncionario f = new FactoryFuncionario();
		
		request.setAttribute(User.USER_NAME, user.getUname());
		request.setAttribute(Empresa.COMPANY_DAYS, user.getEmpresa().getDiasPassados());

		for(int i = 0; i < 10; i++) {
			fillARow(request, f, i);
		}
		
		view.forward(request, response);
		
	}

	private void fillARow(HttpServletRequest request, FactoryFuncionario factory, int index) {
		Funcionario f = factory.getFuncionario();
		
		request.setAttribute("fnome" + index, f.getNome());
		request.setAttribute("fsalario" + index, f.getSalario());
		request.setAttribute("frenmax" + index, f.getRendimentoMaximo());
		request.setAttribute("ftaxaren" + index, f.getTaxaRendimento());
	}
}
