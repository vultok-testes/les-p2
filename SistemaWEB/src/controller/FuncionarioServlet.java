package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Empresa;
import model.Funcionario;
import model.User;
import services.ResourceManager;

/**
 * Servlet implementation class FuncionarioServlet
 */
@WebServlet("/funcionarios")
public class FuncionarioServlet extends HttpServlet implements WebPageRenderer {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		render(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = (String) request.getSession().getAttribute(User.USER_NAME);
		ResourceManager rs = ResourceManager.getInstance();
		User user = rs.getUserByName(uname);
		List<Funcionario> funcionarios = user.getEmpresa().getFuncionarios();
				
		StringBuilder json = new StringBuilder();
		json.append("{\"funcionarios\":[");
		int index = 1;
		
		for(Funcionario f : funcionarios) {
			json.append(f.toJson());
			
			if(index++ != funcionarios.size()) {
				json.append(',');
			}
		}
		
		json.append("]}");
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().write(json.toString());
	}

	@Override
	public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/funcionarios.jsp");
		
		String uname = (String) request.getSession().getAttribute(User.USER_NAME);
		ResourceManager rs = ResourceManager.getInstance();
		User user = rs.getUserByName(uname);
		
		request.setAttribute(User.USER_NAME, user.getUname());
		request.setAttribute(Empresa.COMPANY_DAYS, user.getEmpresa().getDiasPassados());
		
		view.forward(request, response);
	}

}
