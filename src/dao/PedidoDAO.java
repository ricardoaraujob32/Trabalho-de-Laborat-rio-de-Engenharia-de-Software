package dao;

import java.util.List;

import model.Pedido;

public class PedidoDAO extends AbstractDAO<Pedido> {

	public PedidoDAO() throws GenericDAOException {
		super();
	}

	@Override
	public void inserir(Pedido p) throws GenericDAOException {
		String inserePedido = "INSERT INTO tbl_pedido(numero_pedido, id_cliente, hora_pedido, data_pedido, "
				+ "situacao_pedido) VALUES(?, ?, ?, ?, ?)";	
		String 
	}

	@Override
	public void atualizar(Pedido p) throws GenericDAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int id) throws GenericDAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pedido> pesquisar() throws GenericDAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
