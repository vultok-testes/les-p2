package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute(User.USER_NAME) != null) {
			System.out.println("Log out de: " + session.getAttribute(User.USER_NAME));
			session.removeAttribute(User.USER_NAME);
			session.invalidate();
		} else {
			System.out.println("null");
		}
		
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("text/plain");
		response.getWriter().write("Ok, move on");
	}
	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Redirecionando GET /logout para /");
		new IndexServlet().doGet(request, response);
//		goToLoginPage(request, response, "");
	}
}
