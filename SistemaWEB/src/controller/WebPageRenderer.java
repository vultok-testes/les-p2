package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface WebPageRenderer {
	/**
	 * Método faz com que cada servlet que o implemente tenha a responsibilidade de renderizar 
	 * a página da qual é responsável. <br>
	 * Por exemplo:
	 * <ul><li>
	 * O <code>IndexServlet</code> deve ter a responsabilidade de renderizar a página de <strong>index</strong>
	 * </li><li>
	 * O <code>WelcomeServlet</code> deve ter a responsabilidade de renderizar a página <strong>'welcome'</strong>
	 * </li></ul>
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
