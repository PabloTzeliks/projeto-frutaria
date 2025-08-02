package com.appfrutaria.service;

import com.appfrutaria.exception.ServiceException;
import com.appfrutaria.model.*;
import com.appfrutaria.view.ProdutoDTO;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService implements CrudService<ProdutoDTO> {

    private final List<Produto> armazenamento = new ArrayList<>();
    private static int nextId = 1;

    @Override
    public void adicionarItem(ProdutoDTO dto) {
        validarDTO(dto);

        // Gera ID automático se não fornecido
        if (dto.id() <= 0) {
            dto = new ProdutoDTO(
                    nextId++,
                    dto.nome(),
                    dto.preco(),
                    dto.quantidade(),
                    dto.peso(),
                    dto.tipoProduto(),
                    dto.tipoEspecifico()
            );
        }

        Produto produto = ProdutoFactory.InstanceOf(dto);
        if (produto == null) {
            throw new ServiceException("Não foi possível criar o produto");
        }

        // Verifica se já existe um produto com o mesmo ID
        if (buscarPorId(dto.id()) != null) {
            throw new ServiceException("Já existe um produto com o ID " + dto.id());
        }

        armazenamento.add(produto);
    }

    @Override
    public void removerPorId(int id) {
        if (!armazenamento.removeIf(p -> p.getId() == id)) {
            throw new ServiceException("Produto não encontrado com ID " + id);
        }
    }

    @Override
    public void atualizarItem(ProdutoDTO dto) {
        validarDTO(dto);

        int index = -1;
        for (int i = 0; i < armazenamento.size(); i++) {
            if (armazenamento.get(i).getId() == dto.id()) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            throw new ServiceException("Produto não encontrado com ID " + dto.id());
        }

        Produto produtoAtualizado = ProdutoFactory.InstanceOf(dto);
        if (produtoAtualizado == null) {
            throw new ServiceException("Não foi possível atualizar o produto");
        }

        armazenamento.set(index, produtoAtualizado);
    }

    @Override
    public List<ProdutoDTO> listarTodos() {
        return armazenamento.stream()
                .map(this::converterParaDTO)
                .toList();
    }

    @Override
    public ProdutoDTO buscarPorId(int id) {
        return armazenamento.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .map(this::converterParaDTO)
                .orElse(null);
    }

    private void validarDTO(ProdutoDTO dto) {
        if (dto == null) {
            throw new ServiceException("DTO não pode ser nulo");
        }
        if (dto.nome() == null || dto.nome().trim().isEmpty()) {
            throw new ServiceException("Nome do produto é obrigatório");
        }
        if (dto.preco() < 0) {
            throw new ServiceException("Preço não pode ser negativo");
        }
        if (dto.quantidade() < 0) {
            throw new ServiceException("Quantidade não pode ser negativa");
        }
        if (dto.peso() <= 0) {
            throw new ServiceException("Peso deve ser maior que zero");
        }
        if (dto.tipoProduto() == null) {
            throw new ServiceException("Tipo do produto é obrigatório");
        }
        if (dto.tipoEspecifico() == null) {
            throw new ServiceException("Tipo específico do produto é obrigatório");
        }
    }

    private ProdutoDTO converterParaDTO(Produto produto) {
        return new ProdutoDTO(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getQuantidade(),
                produto.getPeso(),
                produto.getTipoProduto(),
                produto.getTipoProdutoEspecifico()
        );
    }

//    @Override
//    public void adicionarItem(ProdutoDTO dto) {
//
//        if (dto == null) {
//            throw new NullFieldException("Erro! Produto não encontrado.");
//        }
//
//        if (buscarPorId(dto.getId()) != null) {
//            throw new ServiceException("Erro! Produto já existente.");
//        }
//
//        armazenamento.add(dto);
//
//    }
//
//    @Override
//    public void removerPorId(int id) {
//
//        T produto = buscarPorId(id);
//
//        if (produto == null) {
//
//            throw new NullFieldException("Erro! Produto não encontrado. Com o ID =" + id);
//
//        }
//
//        armazenamento.remove(produto);
//
//    }
//
//    @Override
//    public void atualizarItem(T itemAtualizado) {
//
//        if (itemAtualizado == null) {
//
//            throw new NullFieldException("Erro! Produto não encontrado.");
//
//        }
//
//        for (int i = 0; i < armazenamento.size(); i++) {
//
//            if (armazenamento.get(i).getId() == itemAtualizado.getId()) {
//
//                armazenamento.set(i, itemAtualizado);
//                return;
//
//            }
//            throw new NullFieldException("Erro! Produto não encontrado");
//        }
//
//    }
//
//    @Override
//    public List<T> listarTodos() {
//
//        if (armazenamento.isEmpty()) {
//
//            throw new ServiceException("Erro! Lista de Produtos está vazia.");
//
//        }
//
//        return new ArrayList<>(armazenamento);
//
//    }
//
//    @Override
//    public T buscarPorId(int id) {
//        return armazenamento.stream()
//                .filter(produto -> produto.getId() == id)
//                .findFirst()
//                .orElse(null);
//    }

}