package br.com.projetoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.projetoMVC.model.Produto;
import br.com.projetoMVC.util.ConnectionFactory;

public class ProdutoDAOImpl implements GenericDAO {
// para implementar alguma coisa 

	private Connection conn;

	// Construtor vazio da classe ProdutoDAOImpl, iniciando a conexão com o banco
	// de dados atráves da classe ConnectionFactory

	public ProdutoDAOImpl() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
			System.out.println("ProdutoDAOImpl : Conectado com sucesso!!");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Object> listarTodos() {
		List<Object> list = new ArrayList<Object>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PRODUTO";

		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setDescricao(rs.getString("descricao"));
				list.add(produto);
			}
		} catch (SQLException ex) {
			System.out.println("Problemas na DAO ao listar Produto" + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, rs);
			} catch (Exception e) {
				System.out.println("Problemas na DAO ao fechar conexão!" + e.getMessage());
			}
		}

		return null;
	}

	@Override
	public Object listarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cadastrar(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void excluir(int id) {
		// TODO Auto-generated method stub

	}

}
