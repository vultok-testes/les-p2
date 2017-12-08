package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import services.ResourceManager;

@WebServlet("")
public class IndexServlet extends HttpServlet implements WebPageRenderer {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		System.out.println("0");
		if (LoginServlet.isUserLoged(request)) {
			String uName = (String) request.getSession().getAttribute(User.USER_NAME);
			User user = ResourceManager.getInstance().getUserByName(uName);
			
			if(user == null) {
				request.getSession().removeAttribute(User.USER_NAME);
				request.getSession().invalidate();
				render(request, response);
			} else {
				System.out.println(request.getSession().getAttribute(User.USER_NAME));
				System.out.println("{\"user\":\"" + user.getUname() + "\", \"pwd\": \"" + user.getUpwd() + "\"}");
				new WelcomeServlet().render(request, response);
			}
		} else {
			render(request, response);
		}
	}

	@Override
	public void render(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("New non-logged user");

		RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
		request.setAttribute("divDisplayStyle", "none");
		view.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}
}
