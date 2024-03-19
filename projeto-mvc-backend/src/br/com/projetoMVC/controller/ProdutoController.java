package br.com.projetoMVC.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.projetoDAO.GenericDAO;
import br.com.projetoDAO.ProdutoDAOImpl;
import br.com.projetoMVC.model.Produto;

public class ProdutoController {

	public List<Produto> listarTodos() {
		try {
			GenericDAO dao = new ProdutoDAOImpl();
			List<Produto> lista = new ArrayList<Produto>();

			for (Object object : dao.listarTodos()) {
				lista.add((Produto) object);

			}
			return lista;

		} catch (Exception ex) {
			System.out.println("Problemas na controller para listar Produtos" + ex.getMessage());
			ex.printStackTrace();
			return null;
		}

	}

	public boolean cadastrar(Produto produto) {
		try {
			GenericDAO dao = new ProdutoDAOImpl();
			dao.cadastrar(produto);
			return true;

		} catch (Exception e) {
			System.out.println("Problemas no Controler para cadastrar produto" + e.getLocalizedMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean alterar(Produto produto) {
		try {
			GenericDAO dao = new ProdutoDAOImpl();
			dao.alterar(produto);
			return true;
		} catch (Exception e) {
			System.out.println("Problemas na Controller para alterar Produto" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public void excluir(int id) {
		try {
			GenericDAO dao = new ProdutoDAOImpl();
			dao.excluir(id);
		} catch (Exception e) {
			System.out.println("Problemas na Controller para excliur Produto" + e.getMessage());
			e.printStackTrace();

		}
	}

}
