package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ativo;
import model.Empresa;
import model.User;
import services.ResourceManager;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet implements WebPageRenderer {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			render(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
			String message = "Por favor, faça login primeiro.";
			RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("divDisplayStyle", "inherit");
			request.setAttribute("message", message);
			view.forward(request, response);
		}

	}
	
	public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/welcome.jsp");
		
		String uname = (String) request.getSession().getAttribute(User.USER_NAME);
		ResourceManager rs = ResourceManager.getInstance();
		User user = rs.getUserByName(uname);
		int[] qtdAtivos = user.getEmpresa().getQtdAtivos();
		
		request.setAttribute(User.USER_NAME, user.getUname());
		request.setAttribute("saldoEmpresa", user.getEmpresa().getSaldo());
		request.setAttribute("lucroDiario", user.getEmpresa().calculateDailyProfit());
		request.setAttribute("despesaDiaria", user.getEmpresa().calculateDailyExpense());
		request.setAttribute(Empresa.COMPANY_DAYS, user.getEmpresa().getDiasPassados());
		request.setAttribute("qtdFuncionarios", user.getEmpresa().getFuncionarios().size());
		request.setAttribute("qtdCadeiras", qtdAtivos[Ativo.CADEIRA]);
		request.setAttribute("qtdMesas", qtdAtivos[Ativo.MESA]);
		request.setAttribute("qtdPCs", qtdAtivos[Ativo.PC_PASTEL]);

		view.forward(request, response);
	}
}
