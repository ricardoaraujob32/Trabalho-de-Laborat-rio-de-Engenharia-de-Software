package dao;

import java.util.List;

public interface DAO<E> {
	void inserir(E entidade) throws GenericDAOException;
	void atualizar(E entidade) throws GenericDAOException;
	void deletar(int id) throws GenericDAOException;
	List<E> pesquisar() throws GenericDAOException;
}
