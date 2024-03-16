package br.com.projetoMVC;

import br.com.projetoMVC.controller.ProdutoController;
import br.com.projetoMVC.model.Produto;

public class main {

	public static void main(String[] args) {

		ProdutoController controller = new ProdutoController();

		System.out.println("--Lista de Produtos-");
		System.out.println("id   DESCRIÇÃO");
		;
		for (Produto produto : controller.listarTodos()) {
			System.out.println(produto.getId() + "    " + produto.getDescricao());
		}
	}

}
