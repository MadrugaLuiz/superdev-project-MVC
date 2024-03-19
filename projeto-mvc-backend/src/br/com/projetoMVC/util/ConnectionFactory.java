package br.com.projetoMVC.util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

public class ConnectionFactory {

	public static final String PATH = "jdbc:postgresql://localhost:5432/db_superdev"; // caminho do drive do banco de
																						// dados
	public static final String USER = "postgres"; // usuario do banco
	public static final String PASSWORD = "pgadmin"; // senha do banco

	// metodo que retorna a conexão estabelecida

	public static Connection getConnection() throws Exception {
		try {
			// carregar o drive do postgresql
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(PATH, USER, PASSWORD);
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	// Criar os metodos para fechar a conexao com o banco de dados
	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {
		close(conn, stmt, rs);
	}

	public static void closeConnection(Connection conn, Statement stmt) throws Exception {
		close(conn, stmt, null);
	}

	public static void closeConnection(Connection conn) throws Exception {
		close(conn, null, null);
	}

	private static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
