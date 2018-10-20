package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Cliente;

public class ClienteDAO extends AbstractDAO<Cliente> {
	
	private static final String CAMPOS =  "id_cliente, login_cliente, senha_cliente, nome_cliente, bairro_cliente, " + 
							"logradouro_cliente, telefone_cliente, email_cliente";

	public ClienteDAO() throws GenericDAOException {
		super();
	}

	@Override
	public void inserir(Cliente c) throws GenericDAOException {
		String sql = "INSERT INTO tbl_cliente(" + CAMPOS + ") "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(   1, c.getId() );
			ps.setString( 2, c.getLogin() );
			ps.setString( 3, c.getSenha() );
			ps.setString( 4, c.getNome() );
			ps.setString( 5, c.getBairro() );
			ps.setString( 6, c.getLogradouro() );
			ps.setString( 7, c.getTelefone() );
			ps.setString( 8, c.getEmail() );
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
	}

	@Override
	public void atualizar(Cliente c) throws GenericDAOException {
		String sql = "UPDATE tbl_cliente SET login_cliente = ?, senha_cliente = ?, nome_cliente = ?, "
				+ "bairro_cliente = ?, logradouro_cliente = ?, telefone_cliente = ?, email_cliente = ? "
				+ "WHERE id_cliente = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString( 1, c.getLogin() );
			ps.setString( 2, c.getSenha() );
			ps.setString( 3, c.getNome() );
			ps.setString( 4, c.getBairro() );
			ps.setString( 5, c.getLogradouro() );
			ps.setString( 6, c.getTelefone() );
			ps.setString( 7, c.getEmail() );
			ps.setLong(   8, c.getId() );
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
	}

	@Override
	public void deletar(int id) throws GenericDAOException {
		String sql = "DELETE FROM tbl_cliente WHERE id_cliente = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong( 1, id );
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
	}

	@Override
	public List<Cliente> pesquisar() throws GenericDAOException {
		String sql = "SELECT * FROM tbl_cliente";
		LinkedList<Cliente> lista = new LinkedList<>();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				Cliente c = new Cliente();
				
				c.setId( rs.getLong("id_cliente") );
				c.setLogin( rs.getString("login_cliente") );
				c.setSenha( rs.getString("senha_cliente") );
				c.setNome( rs.getString("nome_cliente") );
				c.setBairro( rs.getString("bairro_cliente") );
				c.setLogradouro( rs.getString("logradouro_cliente") );
				c.setTelefone( rs.getString("telefone_cliente") );
				c.setEmail( rs.getString("email_cliente") );
				
				lista.addLast(c);
			}
		} catch (SQLException e) {
			throw new GenericDAOException(e);
		}
		
		return lista;
	}

}
