package com.appfrutaria.service;

import java.util.List;
import com.appfrutaria.view.ProdutoDTO;

public interface CrudService<ProdutoDTO> {

    void adicionarItem(ProdutoDTO item);
    void removerPorId(int id);
    void atualizarItem(ProdutoDTO item);
    List<ProdutoDTO> listarTodos();
    ProdutoDTO buscarPorId(int id);

}