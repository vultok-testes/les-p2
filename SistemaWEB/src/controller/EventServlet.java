package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import events.Event;
import model.Empresa;
import model.Funcionario;
import model.User;
import services.ResourceManager;

@WebServlet("/eventos")
public class EventServlet extends HttpServlet implements WebPageRenderer {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		render(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = (String) request.getSession().getAttribute(User.USER_NAME);
		ResourceManager rs = ResourceManager.getInstance();
		User user = rs.getUserByName(uname);
		List<Funcionario> funcionarios = user.getEmpresa().getFuncionarios();
		List<Event> events = new LinkedList<Event>();
		
		for(Funcionario f : funcionarios) {
			if(f.getCurrentEvent() != null) {
				events.add(f.getCurrentEvent());
			}
		}
		
		StringBuilder json = new StringBuilder();
		json.append("{\"events\":[");
		int index = 1;
		
		for(Event e : events) {
			json.append(e.toJson());
			
			if(index++ != events.size()) {
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
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/eventos.jsp");
		
		String uname = (String) request.getSession().getAttribute(User.USER_NAME);
		ResourceManager rs = ResourceManager.getInstance();
		User user = rs.getUserByName(uname);
		
		request.setAttribute(User.USER_NAME, user.getUname());
		request.setAttribute(Empresa.COMPANY_DAYS, user.getEmpresa().getDiasPassados());
		
		view.forward(request, response);
	}
}
