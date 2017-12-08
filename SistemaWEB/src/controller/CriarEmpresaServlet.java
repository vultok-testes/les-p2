package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Empresa;
import model.User;
import services.ResourceManager;

@WebServlet("/criarempresa")
public class CriarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String uName = (String) request.getSession().getAttribute(User.USER_NAME);
			String cName = request.getParameter(Empresa.COMPANY_NAME);
			ResourceManager rs = ResourceManager.getInstance();
			
			if(cName == null || cName.isEmpty()) {
				throw new IllegalArgumentException("Nome da empresa não pode ser nulo");
			} else {
				User user = rs.getUserByName(uName);
				
				user.getEmpresa().setNome(cName);
				System.out.println("empresa cadastrada: " + user.getEmpresa().getNome());
				
				new WelcomeServlet().render(request, response);
//				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/welcome.jsp");
//				request.setAttribute(User.USER_NAME, user.getUname());
//				view.forward(request, response);
			}
		} catch(Exception e) {
			e.printStackTrace();
			String message = "Por favor, verifique o campo nome";
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/firstrun.jsp");
			
			request.setAttribute("message", message);
			request.setAttribute("divDisplayStyle", "inherit");

			view.forward(request, response);
		}
	}
}
