package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

import model.Bebida;
import model.ItemPedido;
import model.Pedido;
import model.Pizza;

public class PedidoDAO extends AbstractDAO<Pedido> {

	private PizzaDAO pizzaDao;
	private BebidaDAO bebidaDao;

	public PedidoDAO() throws GenericDAOException {
		super();
		pizzaDao = new PizzaDAO();
		bebidaDao = new BebidaDAO();
	}

	@Override
	public void inserir(Pedido p) throws GenericDAOException {
		String sql = "INSERT INTO tbl_pedido(numero_pedido, id_cliente, hora_pedido, data_pedido, "
				+ "situacao_pedido) VALUES(?, ?, ?, ?, ?)";
		List<Pizza> listaPizza = p.getPizzas();
		List<Bebida> listaBebida = p.getBebidas();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong( 1, p.getNumeroPedido() );
			ps.setLong( 2, p.getIdCliente() );
			ps.setTime( 3, new Time( p.getHora().toSecondOfDay() ) );
			ps.setDate( 4, new Date( p.getData().toEpochDay() ) );
			ps.setInt(  5, p.getSituacaoPedido() );
						
			ps.executeUpdate();
			
			for (Pizza pizza : listaPizza) {
				pizzaDao.inserir(pizza);				
			}
			
			for (Bebida bebida : listaBebida) {
				bebidaDao.inserir(bebida);
			}
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}	
	}

	@Override
	public void atualizar(Pedido p) throws GenericDAOException {
		String sql = "UPDATE tbl_pedido SET id_cliente = ?, hora_pedido = ?, data_pedido = ?, "
				+ "situacao_pedido = ? WHERE numero_pedido = ?";
		List<Pizza> listaPizza = p.getPizzas();
		List<Bebida> listaBebida = p.getBebidas();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
						
			ps.setLong( 1, p.getIdCliente() );
			ps.setTime( 2, new Time( p.getHora().toSecondOfDay() ) );
			ps.setDate( 3, new Date( p.getData().toEpochDay() ) );
			ps.setInt(  4, p.getSituacaoPedido() );
			ps.setLong( 5, p.getNumeroPedido() );
						
			ps.executeUpdate();
			
			for (Pizza pizza : listaPizza) {
				pizzaDao.atualizar(pizza);				
			}
			
			for (Bebida bebida : listaBebida) {
				bebidaDao.atualizar(bebida);
			}
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}	
	}

	@Override
	public void deletar(int id) throws GenericDAOException {
		String sql = "DELETE FROM tbl_pedido WHERE numero_pedido = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong( 1, id );
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
	}

	@Override
	public List<Pedido> pesquisar() throws GenericDAOException {
		String sql = "SELECT * FROM tbl_pedido WHERE situacao_pedido = ?";
		LinkedList<Pedido> lista = new LinkedList<>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt( 1, Pedido.AGUARDANDO_PAGAMENTO );
			
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				Pedido p = new Pedido();
				
				p.setNumeroPedido( rs.getLong("numero_pedido") );
				p.setIdCliente( rs.getLong("id_cliente") );
				p.setHora( rs.getTime("hora_pedido").toLocalTime() );
				p.setData( rs.getDate("data_pedido").toLocalDate() );
				p.setSituacaoPedido( rs.getInt("situacao_pedido") );
				
				List<Pizza> listaPizza = pizzaDao.pesquisar( p.getNumeroPedido() );
				List<Bebida> listaBebida = bebidaDao.pesquisar( p.getNumeroPedido() );
				LinkedList<ItemPedido> listaItens = new LinkedList<>();
				
				listaItens.addAll(listaPizza);
				listaItens.addAll(listaBebida);
				p.setListaItens(listaItens);
				
				lista.addLast(p);
			}
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
		
		return lista;
	}

}
