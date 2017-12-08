package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import events.Event;
import events.EventGenerator;
import events.EventGeneratorImpl;
import model.Funcionario;
import model.User;
import services.ResourceManager;

@WebServlet("/nextday")
public class NextDayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("indo para o próximo dia");
		String uname = (String) request.getSession().getAttribute(User.USER_NAME);
		User user = ResourceManager.getInstance().getUserByName(uname);
		
		if(user == null) {
			new IndexServlet().doGet(request, response);
		} else {
			List<Funcionario> funcionarios = user.getEmpresa().getFuncionarios();
			EventGenerator evt = new EventGeneratorImpl();
			List<Event> events = new LinkedList<Event>();
			
			for(Funcionario tmp : funcionarios) {
				Event e = evt.generateEvent();
				
				if(e != null) {
					tmp.handleEvent(e);
					events.add(e);
				} else {
					tmp.returnToDefault();
				}
			}
			
			user.getEmpresa().nextDay();
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/plain");
			response.getWriter().write("move on");
			//new WelcomeServlet().render(request, response);
			//new EventServlet().render(request, response);
		}
		
		
	}
}
