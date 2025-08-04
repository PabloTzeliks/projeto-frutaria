package com.appfrutaria.view;

import com.appfrutaria.exception.ServiceException;
import com.appfrutaria.model.enums.*;
import com.appfrutaria.service.ProdutoService;

import java.util.List;
import java.util.Scanner;

public class ProdutoView {

    private final ProdutoService service;
    private final Scanner scanner;

    public ProdutoView(ProdutoService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("\n==========================================");
            System.out.println("=       MENU PRINCIPAL AppFrutaria       =");
            System.out.println("==========================================");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Listar Todos");
            System.out.println("3 - Buscar Produto por ID");
            System.out.println("4 - Atualizar Produto");
            System.out.println("5 - Remover Produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int op = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            try {
                switch (op) {
                    case 1 -> adicionarProduto();
                    case 2 -> listarTodos();
                    case 3 -> buscarPorId();
                    case 4 -> atualizarProduto();
                    case 5 -> removerProduto();
                    case 0 -> { System.out.println("Saindo..."); return; }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (ServiceException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private void adicionarProduto() {

        System.out.println("\n==========================================");
        System.out.println("=                CADASTRO                =");
        System.out.println("==========================================");

        ProdutoDTO dto = lerProdutoDTO(false);
        service.adicionarItem(dto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private void listarTodos() {

        List<ProdutoDTO> produtos = service.listarTodos();
        exibirProdutos(produtos);
    }

    private void exibirProdutos(List<ProdutoDTO> produtos) {

        if (produtos.isEmpty()) {
            System.out.println("\nErro! Não há produtos na Lista.");

            return;
        }

        System.out.println("==========================================");
        System.out.println("=               LISTAGEM                 =");
        System.out.println("==========================================\n");

        for (ProdutoDTO produto : produtos) {
            String produtoFormatado = formatarProduto(produto);

            System.out.println(produtoFormatado);
        }
    }

    private String formatarProduto(ProdutoDTO produto) {

        return String.format(
                "ID: %d\n" + "Nome: %s\n" + "Preço: R$%.2f\n" + "Quantidade: %d\n" + "Peso: %.2f Kg\n" + "Tipo: %s\n" + "Tipo Específico: %s\n",
                produto.id(),
                produto.nome(),
                produto.preco(),
                produto.quantidade(),
                produto.peso(),
                produto.tipoProduto(),
                produto.tipoEspecifico().getNome()
        );

    }

    private void buscarPorId() {
        System.out.print("\nID do produto: ");
        int id = scanner.nextInt();
        ProdutoDTO dto = service.buscarPorId(id);
        if (dto == null) System.out.println("Não encontrado.");
        else System.out.println(dto);
    }

    private void atualizarProduto() {
        ProdutoDTO dto = lerProdutoDTO(true);
        service.atualizarItem(dto);
        System.out.println("Produto atualizado!");
    }

    private void removerProduto() {

        System.out.println("==========================================");
        System.out.println("=                REMOÇÃO                 =");
        System.out.println("==========================================");

        System.out.print("\nID para remover: ");
        int id = scanner.nextInt();
        service.removerPorId(id);
        System.out.println("Removido!");
    }

    private ProdutoDTO lerProdutoDTO(boolean atualizar) {
        int id = 0;
        if (atualizar) {
            System.out.print("ID: ");
            id = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        System.out.print("Peso: ");
        double peso = scanner.nextDouble();
        scanner.nextLine();

        // Selecionar TipoProduto
        System.out.println("Tipo do produto:");
        for (TipoProduto tipo : TipoProduto.values()) {
            System.out.println(tipo.ordinal() + 1 + " - " + tipo.name());
        }
        int tipoIndex = scanner.nextInt() - 1;
        TipoProduto tipoProduto = TipoProduto.values()[tipoIndex];

        // Selecionar TipoEspecifico
        TipoProdutoEspecifico tipoEspecifico = null;
        if (tipoProduto == TipoProduto.FRUTA) {
            tipoEspecifico = escolherTipoEspecifico(TipoFruta.values());
        } else if (tipoProduto == TipoProduto.LEGUME) {
            tipoEspecifico = escolherTipoEspecifico(TipoLegume.values());
        } else if (tipoProduto == TipoProduto.VERDURA) {
            tipoEspecifico = escolherTipoEspecifico(TipoVerdura.values());
        }

        return new ProdutoDTO(id, nome, preco, quantidade, peso, tipoProduto, tipoEspecifico);
    }

    private <T extends TipoProdutoEspecifico> T escolherTipoEspecifico(T[] valores) {
        System.out.println("Tipo Específico:");
        for (int i = 0; i < valores.length; i++) {
            System.out.println((i+1) + " - " + valores[i].getNome() + " (" + valores[i].getDescricao() + ")");
        }
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        return valores[idx];
    }
}