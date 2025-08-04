package com.appfrutaria;

import com.appfrutaria.service.ProdutoService;
import com.appfrutaria.view.ProdutoView;

public class AppFrutaria {

	public static void main(String[] args) {

		ProdutoService service = new ProdutoService();
		ProdutoView view = new ProdutoView(service);

		view.exibirMenu();

	}

}
