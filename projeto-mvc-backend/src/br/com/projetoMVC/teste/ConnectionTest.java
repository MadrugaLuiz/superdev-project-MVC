package br.com.projetoMVC.teste;

import java.sql.Connection;

import br.com.projetoMVC.util.ConnectionFactory;

public class ConnectionTest {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		try {
			Connection conn = ConnectionFactory.getConnection();
			if (conn != null) {
				System.out.println("Conexão foi estabelecida!");
				conn.close();
			} else {
				System.out.println("Houve algum problema de conectar ! ");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
