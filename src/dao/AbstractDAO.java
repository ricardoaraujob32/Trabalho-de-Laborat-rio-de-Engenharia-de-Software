package dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDAO<E> implements DAO<E> {
	protected Connection con;
	
	public AbstractDAO() throws GenericDAOException {
		con  = GerenciadorConexao.getConnection();
	}
	
	public void fecharConexao() throws GenericDAOException {
		try {
			con.close();
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
	}
}
