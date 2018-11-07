package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GenericDAOException;
import dao.PizzaDAO;
import model.Pizza;


@WebServlet("/Pizza")
public class PizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PizzaController() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("./bebidas.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("./sabores.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
