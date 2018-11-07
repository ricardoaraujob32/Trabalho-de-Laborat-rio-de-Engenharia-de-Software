package controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;


@WebServlet("/auth")

public class AuthenticatorController extends HttpServlet {
	
	private static final long serialVersionUID = -5250452579844179902L;
	
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, 
				HttpServletResponse response) {
		String user = request.getParameter("TXTUSER");
		String pass = request.getParameter("TXTPASS");
		String msg = null;
		HttpSession session = request.getSession();
		try {
			if ("convidado".equals(user) && "123456".equals(pass)) { 
				Cliente userinfo = new Cliente();
				userinfo.setNome("Antonio Rodrigues");
				userinfo.setLogado(true);
				session.setAttribute("LOGADO", userinfo);
				
				response.sendRedirect("./sabores.jsp");
			} else if ("admin".equals(user) && "password".equals(pass)) { 
				Cliente userinfo = new Cliente();
				userinfo.setNome("admin");
				userinfo.setLogado(true);
				session.setAttribute("LOGADO", userinfo); 
				response.sendRedirect("./admin.jsp");
			} else { 
				msg = "Usuário ou senha incorretos";
				session.setAttribute("MENSAGEM", msg);
				session.setAttribute("LOGADO", null);
				response.sendRedirect("./login.jsp");
				
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}