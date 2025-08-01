package com.appfrutaria.service;

import com.appfrutaria.exception.NullFieldException;
import com.appfrutaria.exception.ServiceException;
import com.appfrutaria.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoService<T extends Produto<?>> implements CrudService<T> {

    private final List<T> armazenamento = new ArrayList<>();

    @Override
    public void adicionarItem(T item) {

        if (item == null) {
            throw new NullFieldException("Erro! Produto não encontrado.");
        }

        if (buscarPorId(item.getId()) != null) {
            throw new ServiceException("Erro! Produto já existente.");
        }

        armazenamento.add(item);

    }

    @Override
    public void removerPorId(int id) {

        T produto = buscarPorId(id);

        if (produto == null) {

            throw new NullFieldException("Erro! Produto não encontrado. Com o ID =" + id);

        }

        armazenamento.remove(produto);

    }

    @Override
    public void atualizarItem(T itemAtualizado) {

        if (itemAtualizado == null) {

            throw new NullFieldException("Erro! Produto não encontrado.");

        }

        for (int i = 0; i < armazenamento.size(); i++) {

            if (armazenamento.get(i).getId() == itemAtualizado.getId()) {

                armazenamento.set(i, itemAtualizado);
                return;

            }
            throw new NullFieldException("Erro! Produto não encontrado");
        }

    }

    @Override
    public List<T> listarTodos() {

        if (armazenamento.isEmpty()) {

            throw new ServiceException("Erro! Lista de Produtos está vazia.");

        }

        return new ArrayList<>(armazenamento);

    }

    @Override
    public T buscarPorId(int id) {
        return armazenamento.stream()
                .filter(produto -> produto.getId() == id)
                .findFirst()
                .orElse(null);
    }

}