package dao;

import java.sql.Connection;

public abstract class AbstractDAO<E> implements DAO<E> {
	protected Connection con;
	
	public AbstractDAO() throws GenericDAOException {
		con  = GerenciadorConexao.getConnection();
	}
}
