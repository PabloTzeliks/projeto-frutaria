package com.appfrutaria.service;

import com.appfrutaria.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoService<T extends Produto<?>> implements CrudService<T> {

    private final List<T> armazenamento = new ArrayList<>();

    @Override
    public void adicionarItem(T item) {
        armazenamento.add(item);
    }

    @Override
    public void removerPorId(int id) {
        armazenamento.removeIf(p -> p.getId() == id);
    }

    @Override
    public void atualizarItem(T itemAtualizado) {

        for(int i = 0; i < armazenamento.size(); i++) {

            if (armazenamento.get(i).getId() == itemAtualizado.getId()) {

                armazenamento.set(i, itemAtualizado);
                return;

            }
            throw new IllegalArgumentException("Produto não encontrado de ID=" + itemAtualizado.getId());
        }

    }

}