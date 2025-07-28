package com.appfrutaria.service;

import java.util.List;

public interface CrudService<T> {

    void adcionarItem(T item);
    void removerPorId(int id);
    void atualizarItem(T item);
    List<T> listarTodos();
    T buscarPorId(int id);

}