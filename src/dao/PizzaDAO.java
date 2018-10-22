package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Pizza;
import model.Sabor;

public class PizzaDAO extends AbstractDAO<Pizza> {

	private SaborDAO saborDao;

	public PizzaDAO() throws GenericDAOException {
		super();
		saborDao = new SaborDAO();
	}

	@Override
	public void inserir(Pizza p) throws GenericDAOException {
		String sql = "INSERT INTO tbl_pizza(id_pizza, numero_pedido, id_tamanho, qtd_sabores_pizza, valor_pizza, borda_recheada) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			List<Sabor> listaSabores = p.getSabores();

			ps.setLong(    1, p.getId() );
			ps.setLong(    2, p.getNumeroPedido() );
			ps.setLong(    3, p.getTamanho() );
			ps.setInt(     4, p.getQtdSabores() );
			ps.setDouble(  5, p.getValor() );
			ps.setBoolean( 6, p.isBordaRecheada() );

			ps.executeUpdate();
			
			for (Sabor sabor : listaSabores) {
				saborDao.inserir(sabor);
			}
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}		
	}

	@Override
	public void atualizar(Pizza p) throws GenericDAOException {
		String sql = "UPDATE tbl_pizza SET numero_pedido = ?, id_tamanho = ?, qtd_sabores_pizza = ?, "
				+ "valor_pizza = ?, borda_recheada = ? WHERE id_pizza = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			List<Sabor> listaSabores = p.getSabores();
			
			ps.setLong(    1, p.getNumeroPedido() );
			ps.setLong(    2, p.getTamanho() );
			ps.setInt(     3, p.getQtdSabores() );
			ps.setDouble(  4, p.getValor() );
			ps.setBoolean( 5, p.isBordaRecheada() );
			ps.setLong(    6, p.getId() );

			ps.executeUpdate();
			
			for (Sabor sabor : listaSabores) {
				saborDao.atualizar(sabor);
			}
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}		
	}

	@Override
	public void deletar(int id) throws GenericDAOException {
		String sql = "DELETE FROM tbl_pizza WHERE id_pizza = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong( 1, id );
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
	}

	@Override
	public List<Pizza> pesquisar() throws GenericDAOException {
		return null;
	}
	
	public List<Pizza> pesquisar(long idPedido) throws GenericDAOException {
		LinkedList<Pizza> lista =  new LinkedList<>();
		String sql = "SELECT * FROM tbl_pizza WHERE numero_pedido = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong( 1, idPedido );
			
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				Pizza p = new Pizza();
				
				p.setId( rs.getLong("id_pizza") );
				p.setNumeroPedido( rs.getLong("numero_pedido") );
				p.setTamanho( rs.getInt("id_tamanho") );
				p.setQtdSabores( rs.getInt("qtd_sabores_pizza") );
				p.setValor( rs.getDouble("valor_pizza") );
				p.setBordaRecheada( rs.getBoolean("borda_recheada") );
				
				List<Sabor> listaSabor = saborDao.pesquisar( p.getId() );
				p.setListaSabores(listaSabor);
				
				lista.addLast(p);
			}
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
		
		return lista;
	}

}
