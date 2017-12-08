package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import services.ResourceManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResourceManager rs = ResourceManager.getInstance();
		HttpSession session = request.getSession();
		boolean newUser = true;
		
		try {
			User user = getUserFromRequest(request);
			
//			if(user == null) {
//				throw new IllegalArgumentException();
//			}
				
			List<User> users = rs.getList();
			System.out.println("# de usuários: " + users.size());
			if(!(users.isEmpty())) {
				System.out.println("lista não está vazia");
				for(User tmp : users) {
					if(tmp.getUname().equalsIgnoreCase(user.getUname())) {
						newUser = false;
						System.out.println("usuário já cadastrado");
						if( ! tmp.getUpwd().equals(user.getUpwd()) ) {
							String message = "Senha incorreta";
							goToLoginPage(request, response, message);
						} else {
							user = tmp;
							break;
						}
					}
				}
			}

			session.setAttribute(User.USER_NAME, user.getUname());
			System.out.println("{\"user\":\"" + user.getUname() + "\", \"pwd\": \"" + user.getUpwd() + "\"}");
			
			if(newUser) {
				System.out.println("new user: " + user.getUname());
				users.add(user);
			}
			
			if(user.getEmpresa().getNome() == null) {
				goToFirstRunPage(request, response, user);
			} else {
				new WelcomeServlet().render(request, response);
				//goToWelcomePage(request, response, user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String message = "Campos usuário e senha devem ser preenchidos";
			goToLoginPage(request, response, message);
		}
	}

	private void goToLoginPage(HttpServletRequest request, HttpServletResponse response, String message)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
		String divStyle = "block";
		
		if(message == null || message.isEmpty()) {
			divStyle = "none";
		}
		
		request.setAttribute("message", message);
		request.setAttribute("divDisplayStyle", divStyle);

		view.forward(request, response);
	}

	public static boolean isUserLoged(HttpServletRequest request) {
		if (request.getSession().getAttribute(User.USER_NAME) != null && request.getSession().getAttribute(User.USER_NAME) != "") {
			return true;
		}

		return false;
	}
	
	private User getUserFromRequest(HttpServletRequest request) throws IllegalArgumentException {
			User user = new User();
			user.setUname(request.getParameter(User.USER_NAME));
			user.setUpwd(request.getParameter(User.USER_PWD));
//			System.out.println("{\"user\":\"" + user.getUname() + "\", \"pwd\": \"" + user.getUpwd() + "\"}");
			return user;
	}

	public static void goToFirstRunPage(HttpServletRequest request, HttpServletResponse response, User user)
			throws IOException, ServletException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/firstrun.jsp");
		request.setAttribute(User.USER_NAME, user.getUname());
		request.setAttribute("divDisplayStyle", "none");

		view.forward(request, response);
	}
	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Redirecionando GET /login para /");
		new IndexServlet().doGet(request, response);
//		goToLoginPage(request, response, "");
	}
}
