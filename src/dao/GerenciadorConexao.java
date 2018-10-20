package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorConexao {
	private static Connection con;
	
	private GerenciadorConexao() {}
	
	public static Connection getConnection() throws GenericDAOException {		
		if (con == null) {
			final String URL = "jdbc:mariadb://localhost:3306/bancofatec";
			final String USUARIO = "root";
			final String SENHA = "root";
			
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				con = DriverManager.getConnection(URL, USUARIO, SENHA);
			} catch (ClassNotFoundException | SQLException e) {
				throw new GenericDAOException(e);
			} 
		}
		
		return con;
	}
	
	public static void fecharConexao() throws GenericDAOException {
		try {
			con.close();
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
	}
	
}
