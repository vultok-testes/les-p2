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
import services.FactoryAtivos;
import services.ResourceManager;

@WebServlet("/loja")
public class LojaServlet extends HttpServlet implements WebPageRenderer {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		render(request, response);
	}
	
	@Override
	public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/loja.jsp");
		
		String uname = (String) request.getSession().getAttribute(User.USER_NAME);
		ResourceManager rs = ResourceManager.getInstance();
		User user = rs.getUserByName(uname);
		FactoryAtivos f = new FactoryAtivos();
		Ativo a = f.getAtivo(Ativo.CADEIRA);
		
		request.setAttribute(User.USER_NAME, user.getUname());
		request.setAttribute(Empresa.COMPANY_DAYS, user.getEmpresa().getDiasPassados());

		request.setAttribute("cadeiraNome", a.getNome());
		request.setAttribute("cadeiraDescricao", a.getDescrição());
		request.setAttribute("cadeiraPreco", a.getValorCompra());
		
		a = f.getAtivo(Ativo.MESA);
		
		request.setAttribute("mesaNome", a.getNome());
		request.setAttribute("mesaDescricao", a.getDescrição());
		request.setAttribute("mesaPreco", a.getValorCompra());
		
		a = f.getAtivo(Ativo.PC_LESMA);
		
		request.setAttribute("pc_lesmaNome", a.getNome());
		request.setAttribute("pc_lesmaDescricao", a.getDescrição());
		request.setAttribute("pc_lesmaPreco", a.getValorCompra());
		
		a = f.getAtivo(Ativo.PC_CORREIOS);
		
		request.setAttribute("pc_corNome", a.getNome());
		request.setAttribute("pc_corDescricao", a.getDescrição());
		request.setAttribute("pc_corPreco", a.getValorCompra());
		
		a = f.getAtivo(Ativo.PC_PASTEL);
		
		request.setAttribute("pc_pastelNome", a.getNome());
		request.setAttribute("pc_pastelDescricao", a.getDescrição());
		request.setAttribute("pc_pastelPreco", a.getValorCompra());
		
		a = f.getAtivo(Ativo.PC_FOGUETE);
		
		request.setAttribute("pc_fogueteNome", a.getNome());
		request.setAttribute("pc_fogueteDescricao", a.getDescrição());
		request.setAttribute("pc_foguetePreco", a.getValorCompra());
		
		
		view.forward(request, response);
	}
	
	
}
