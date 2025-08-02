package com.appfrutaria.service;

import com.appfrutaria.model.Fruta;
import com.appfrutaria.model.Legume;
import com.appfrutaria.model.Produto;
import com.appfrutaria.model.Verdura;
import com.appfrutaria.view.ProdutoDTO;

public class ProdutoFactory {

    public static Produto InstanceOf(ProdutoDTO produtoDTO) {

        try {

            switch (produtoDTO.tipoProduto()) {

                case FRUTA :
                    return new Fruta(produtoDTO.id(), produtoDTO.nome(), produtoDTO.preco(), produtoDTO.quantidade(), produtoDTO.peso(), produtoDTO.tipoEspecifico());

                case LEGUME :
                    return new Legume(produtoDTO.id(), produtoDTO.nome(), produtoDTO.preco(), produtoDTO.quantidade(), produtoDTO.peso(), produtoDTO.tipoEspecifico());

                case VERDURA :
                    return new Verdura(produtoDTO.id(), produtoDTO.nome(), produtoDTO.preco(), produtoDTO.quantidade(), produtoDTO.peso(), produtoDTO.tipoEspecifico());

            }

        } catch (RuntimeException e) {

            System.out.println("Erro! Ocorreu um erro ao criar o Produto, observe: " + e.getMessage());

        }

        return null;

    }

}
