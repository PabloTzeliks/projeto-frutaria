//package com.appfrutaria.view;
//
//import com.appfrutaria.service.Estoque;
//import java.util.Scanner;
//
//public class Atendente {
//
//    private Estoque estoque;
//    private Scanner sc;
//
//    public Atendente() {
//
//        estoque = new Estoque();
//        sc = new Scanner(System.in);
//
//    }
//
//    public void iniciar() {
//
//        int opcao = -1;
//
//        do {
//
//            MenuPrincipal();
//
//            if (sc.hasNextInt()) {
//                opcao = sc.nextInt();
//                String opcaoString = String.valueOf(opcao);
//
//                switch (opcaoString) {
//                    case "1":
//                        cadastrarFruta();
//                        break;
//                    case "2":
//                        estoque.listarFrutas();
//                        break;
//                    case "3":
//                        removerFruta();
//                        break;
//                    case "0":
//                        System.out.println("Saindo...");
//                        break;
//                    default:
//                        System.out.println("Opção inválida.");
//                        break;
//                }
//            } else {
//                System.out.println("\nEntrada inválida. Por favor, insira um número.");
//                sc.next();
//            }
//
//        } while (opcao != 0);
//    }
//
//    private void MenuPrincipal() {
//
//        System.out.println("\n=========================================");
//        System.out.println("=            MENU PRINCIPAL             =");
//        System.out.println("=========================================");
//        System.out.println("= 1- Cadastrar uma Fruta                =");
//        System.out.println("= 2- Listar Produtos                    =");
//        System.out.println("= 3- Remover uma Fruta                  =");
//        System.out.println("\n= 0- Sair                               =");
//        System.out.println("=========================================\n");
//
//    }
//
//    private void cadastrarFruta() {
//
//        sc.nextLine();
//
//        boolean continuarCadastro = true;
//
//        do {
//            System.out.println("\n=========================================");
//            System.out.println("=               CADASTRO                =");
//            System.out.println("=========================================");
//            System.out.println("= Digite o nome da Fruta:               =");
//            String nomeFrutaCadastro = sc.nextLine();
//
//            System.out.println("\n= Digite o preço da Fruta:              =");
//            double precoFrutaCadastro = 0;
//
//            if (sc.hasNextDouble()) {
//                precoFrutaCadastro = sc.nextDouble();
//                sc.nextLine();
//
//                if (precoFrutaCadastro < 0) {
//                    System.out.println("\nErro! Preço não pode ser negativo.");
//                    continue;
//                }
//            } else {
//                System.out.println("\nEntrada inválida. Por favor, insira um número para o preço.");
//                sc.next();
//                continue;
//            }
//
//            System.out.println("\n= Digite a quantidade de Frutas:        =");
//            int quantidadeFrutaCadastro = 0;
//
//            if (sc.hasNextInt()) {
//                quantidadeFrutaCadastro = sc.nextInt();
//                sc.nextLine();
//
//                if (quantidadeFrutaCadastro < 0) {
//                    System.out.println("\nErro! Quantidade não pode ser negativa.");
//                    continue;
//                }
//            } else {
//                System.out.println("\nEntrada inválida. Por favor, insira um número para a quantidade.");
//                sc.next();
//                continue;
//            }
//
//            System.out.println("\n= Digite o peso de Frutas:        =");
//            double pesoFrutaCadastro = 0.0;
//
//            if (sc.hasNextInt()) {
//                pesoFrutaCadastro = sc.nextInt();
//                sc.nextLine();
//
//                if (pesoFrutaCadastro < 0) {
//                    System.out.println("\nErro! Peso não pode ser negativa.");
//                    continue;
//                }
//            } else {
//                System.out.println("\nEntrada inválida. Por favor, insira um número para o peso.");
//                sc.next();
//                continue;
//            }
//
//            System.out.println("\n=========================================\n");
//
//            estoque.adicionarFruta(nomeFrutaCadastro, precoFrutaCadastro, quantidadeFrutaCadastro, pesoFrutaCadastro);
//
//            System.out.println("Fruta cadastrada com sucesso!\n");
//            System.out.println("Deseja cadastrar outra fruta? (s/n)\n");
//            String resposta = sc.nextLine();
//
//            if (!resposta.equalsIgnoreCase("s")) {
//                continuarCadastro = false;
//            }
//
//        } while (continuarCadastro);
//    }
//
//    private void removerFruta() {
//
//        boolean continuarRemocao = true;
//
//        do {
//            System.out.println("=========================================");
//            System.out.println("=                REMOÇÃO                =");
//            System.out.println("=========================================");
//
//            if (estoque.isEmpty()) {
//                System.out.println("\nErro! Não há frutas no estoque.\n");
//                continuarRemocao = false;
//                break;
//            }
//
//            System.out.print("= ID da fruta a remover:                  =\n");
//
//            int id = 0;
//
//            if (sc.hasNextInt()) {
//                id = sc.nextInt();
//                sc.nextLine();
//
//                if (id <= 0) {
//                    System.out.println("Erro! ID inválido.");
//                    continue;
//                }
//
//            } else {
//                System.out.println("\nEntrada inválida. Por favor, insira um número para o ID.");
//                sc.next();
//                continue;
//            }
//
//            System.out.println("\n=========================================");
//
//                if (estoque.removerFrutaPorId(id)) {
//
//                    System.out.println("\nFruta removida com sucesso!");
//
//                } else {
//
//                    System.out.println("\nErro! Fruta não encontrada.");
//
//                    System.out.println("Deseja tentar novamente? (s/n)\n");
//                    String respostaRemocao = sc.nextLine();
//
//                    if (!respostaRemocao.equalsIgnoreCase("s")) {
//                        continuarRemocao = false;
//                    }
//
//                    continue;
//
//                }
//
//            System.out.println("Deseja remover outra fruta? (s/n)\n");
//            String resposta = sc.nextLine();
//
//            if (!resposta.equalsIgnoreCase("s")) {
//                continuarRemocao = false;
//            }
//
//        } while (continuarRemocao);
//    }
//
//}