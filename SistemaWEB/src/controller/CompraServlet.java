package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import services.ResourceManager;

@WebServlet("/comprar")
public class CompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] params = {"qtdMesas", "qtdCadeiras",  
				"qtdPcLesma", "qtdPcCor", "qtdPcPastel", "qtdPcFoguete"};
		double[] values = {8.5D, 12.5D, 1.55D, 10.5D, 20.45D, 4500};
		double total = 0;
		int[] cta = new int[6];
		
		for(int i = 0; i < 6; i++) {
			String tmp = request.getParameter(params[i]);
			
			if( !( tmp.isEmpty() ) && !( tmp == null ) ) {
				cta[i] = Integer.parseInt(tmp);
				total = total + (cta[i] * values[i]);
			}
		}
		
		String uname = (String) request.getSession().getAttribute(User.USER_NAME);
		User user = ResourceManager.getInstance().getUserByName(uname);
		double saldo = user.getEmpresa().getSaldo();
		
		String json;
		String message;
		int returnCode;
		
		if(saldo >= total) {
			int[] current = user.getEmpresa().getQtdAtivos();			
			
			for(int i = 0; i < current.length; i++) {
				current[i] = current[i] + cta[i];
			}
			
			saldo = saldo - total;
			user.getEmpresa().setSaldo(saldo);
			user.getEmpresa().setQtdAtivos(current);
			
			message = "Compra feita com sucesso.";
			returnCode = 0;
		} else {
			message = "Sua empresa não possui saldo suficiente para efetuar a compra.";
			returnCode = 1;
		}
		
		json = "{\"returnCode\": \"" + returnCode + "\", \"message\": \"" + message + "\"}";
		System.out.println(json);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().write(json);
	}
}
