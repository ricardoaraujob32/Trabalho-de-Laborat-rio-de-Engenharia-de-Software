package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Sabor;

public class SaborDAO extends AbstractDAO<Sabor> {

	public SaborDAO() throws GenericDAOException {
		super();
	}

	@Override
	public void inserir(Sabor s) throws GenericDAOException {
		String sql = "INSERT INTO tbl_item_sabor(id_item_sabor, id_pizza, valor_item) "
				+ "VALUES(?, ?, ?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setLong( 1, s.getId() );
			ps.setLong( 2, s.getIdPizza() );
			ps.setDouble( 5, s.getValor() );

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
	}

	@Override
	public void atualizar(Sabor s) throws GenericDAOException {
		String sql = "UPDATE tbl_item_sabor SET id_pizza = ?, valor_item = ? WHERE id_item_sabor = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(   1, s.getIdPizza() );
			ps.setDouble( 2, s.getValor() );
			ps.setLong(   3, s.getId() );

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
	}

	@Override
	public void deletar(int id) throws GenericDAOException {
		String sql = "DELETE FROM tbl_item_sabor WHERE id_item_sabor = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong( 1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
		
	}

	@Override
	public List<Sabor> pesquisar() throws GenericDAOException {
		return null;
	}

	public List<Sabor> pesquisar(long idPizza) throws GenericDAOException {
		LinkedList<Sabor> lista = new LinkedList<>();
		String sql = "SELECT tbl_item_sabor.id_item_sabor, tbl_item_sabor.valor_item, tbl_sabor.nome_sabor "
				+ "FROM tbl_item_sabor tis INNER JOIN tbl_sabor ts ON tis.id_sabor = ts.id_sabor "
				+ "WHERE id_pizza = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong( 1, idPizza );
			
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				Sabor s = new Sabor();
				
				s.setId( rs.getLong("id_item_sabor") );
				s.setIdPizza( idPizza );
				s.setNome( rs.getString("nome_sabor") );
				s.setValor( rs.getDouble("valor_item") );
				
				lista.addLast(s);
			}
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
		
		return lista;
	}
}
