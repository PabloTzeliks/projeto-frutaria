package com.appfrutaria.view;

import com.appfrutaria.model.enums.TipoProduto;
import com.appfrutaria.model.enums.TipoProdutoEspecifico;

public record ProdutoDTO(int id, String nome, double preco, int quantidade, double peso, TipoProduto tipoProduto, TipoProdutoEspecifico tipoEspecifico) {

}
