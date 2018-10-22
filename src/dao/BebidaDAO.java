package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Bebida;

public class BebidaDAO extends AbstractDAO<Bebida> {

	public BebidaDAO() throws GenericDAOException {
		super();
	}

	@Override
	public void inserir(Bebida b) throws GenericDAOException {
		String sql = "INSERT INTO tbl_item_bebida(id_item_bebida, numero_pedido, valor_item) "
				+ "VALUES(?, ?, ?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setLong(   1, b.getId() );
			ps.setLong(   2, b.getNumeroPedido() );
			ps.setDouble( 3, b.getValor() );

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
	}

	@Override
	public void atualizar(Bebida b) throws GenericDAOException {
		String sql = "UPDATE tbl_item_bebida SET numero_pedido = ?, valor_item = ? "
				+ "WHERE id_item_bebida = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(   1, b.getNumeroPedido() );
			ps.setDouble( 2, b.getValor() );
			ps.setLong(   3, b.getId() );

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
	}

	@Override
	public void deletar(int id) throws GenericDAOException {
		String sql = "DELETE FROM tbl_item_bebida WHERE id_item_bebida = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong( 1, id );
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
	}

	@Override
	public List<Bebida> pesquisar() throws GenericDAOException {
		return null;
	}
	
	public List<Bebida> pesquisar(long idPedido) throws GenericDAOException {
		LinkedList<Bebida> lista = new LinkedList<>();
		String sql = "SELECT tbl_item_bebida.id_item_bebida, tbl_item_bebida.valor_item, "
				+ "tbl_bebida.descricao_bebida, tbl_tipo_bebida.descricao_tipo "
				+ "FROM tbl_item_bebida tib INNER JOIN tbl_bebida tb ON tib.id_bebida = tb.id_bebida "
				+ "INNER JOIN tbl_tipo_bebida ttb ON tb.id_tipo_bebida = ttb.id_tipo_bebida "
				+ "WHERE tbl_item_bebida.numero_pedido = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong( 1, idPedido );
			
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				Bebida b = new Bebida();
				
				b.setId( rs.getLong("id_item_bebida") );
				b.setNumeroPedido( idPedido );
				b.setDescricao( rs.getString("descricao_bebida") );
				b.setTipo( rs.getString("descricao_tipo") );
				
				lista.addLast(b);
			}
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
		
		return lista;
	}
}
