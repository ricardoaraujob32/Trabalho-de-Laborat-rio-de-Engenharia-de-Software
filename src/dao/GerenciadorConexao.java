package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorConexao {
	private static Connection con;
	
	private GerenciadorConexao() {}
	
	public static Connection getConnection() throws GenericDAOException {
		
	String 	GLOBAL_PASSWORD =System.getenv("PASSWORD");
	String 	GLOBAL_USERNAME =System.getenv("USERNAME");
	String 	GLOBAL_PORT =System.getenv("PORT");
	String 	GLOBAL_DATABASE =System.getenv("DATABASE");
	String 	GLOBAL_HOST =System.getenv("HOST");
		
		if (con == null) {
			final String URL;
			if(GLOBAL_HOST != null && GLOBAL_HOST != null  ) {
				URL = GLOBAL_HOST + GLOBAL_PORT + GLOBAL_DATABASE;
			}else {
				URL = "jdbc:mariadb://localhost:3306/bancofatec";
			}
			
			
			final String USUARIO;
			if(GLOBAL_USERNAME != null) {
				USUARIO = GLOBAL_USERNAME;
			}else {
				USUARIO = "root";
			}
			
			
			final String SENHA;
			if(GLOBAL_PASSWORD != null) {
				SENHA = GLOBAL_PASSWORD;
			}else {
				SENHA = "root";
			}
			
			
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
