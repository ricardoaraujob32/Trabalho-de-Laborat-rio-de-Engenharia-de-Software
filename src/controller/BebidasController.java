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


@WebServlet("/bebidas")
public class BebidasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BebidasController() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("./finaliza-pedido.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("./bebidas.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
