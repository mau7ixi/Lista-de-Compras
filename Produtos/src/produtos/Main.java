package produtos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Estoque estoque = new Estoque();
        ListaDeCompras lista = new ListaDeCompras();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Bem vindo! Fique a vontade para escolher alguma das opcoes: " + "\n 1. Ver a lista de compras"
                    + "\n 2. Adicionar a lista de compras"
                    + "\n 3. Remover da lista de compras"
                    + "\n 4. Ver estoque"
                    + "\n 5. Adicionar ao estoque"
                    + "\n 6. Remover do estoque"
                    + "\n 7. Sair do programa");
            String opcao = scan.nextLine();
            if (opcao.equals("1")) {
                while (true) {
                    System.out.println("Sua lista de compras:" + "\n");
                    lista.minhaLista();
                    System.out.println("\n" + "1. Voltar");
                    String opcao1 = scan.nextLine();
                    if (opcao1.equals("1")) {
                        break;
                    } else {
                        System.out.println("Caractere invalido, tente novamente");
                        continue;
                    }
                }

            } else if (opcao.equals("2")) {
                String nome;
                int catg;
                System.out.println("Para adicionar um produto, primeiramente diga-me se ele e: 1 para MERCADO, 2 para FARMACIA ou 3 para GERAL: ");
                while (true) {
                    String categoria = scan.nextLine();
                    if (!categoria.matches("\\d+")) {
                        System.out.println("Digite apenas os numeros correspondidos.");
                        continue;
                    }
                    catg = Integer.parseInt(categoria);
                    if (catg != 1 && catg != 2 && catg != 3) {
                        System.out.println("Numero invalido. Tente novamente.");
                    } else {
                        break;
                    }
                }
                System.out.println("Digite o nome do produto: ");
                nome = scan.nextLine();
                while (true) {
                    if (nome.isBlank() || nome.matches(".*\\d+.*")) {
                        System.out.println("Por favor, digite um nome para o produto.");
                        nome = scan.nextLine();
                    } else {
                        break;
                    }
                }
                System.out.println("Em seguida, gostaria de colocar uma quantidade desse tipo de produto? Se neo, sera definido automaticamente o valor como 1): ");
                String quantidade = scan.nextLine();
                while (true) {
                    if (quantidade.matches("\\d+") || quantidade.isEmpty()) {
                        break;
                    } else {
                        System.out.println("Digite apenas numeros. Tente novamente");
                        quantidade = scan.nextLine();
                    }
                }
                System.out.println("Ha algum tipo de categoria? (EX; Alimento, Limpeza, Brinquedo...). Se sim, gostaria de adicionar? (OBS: apenas aperte enter se nao quiser adicionar):");
                String tipo = scan.nextLine();

                while (true) {
                    int qntd = quantidade.isEmpty() ? 1 : Integer.parseInt(quantidade);
                    String t = tipo.isEmpty() ? null : tipo;
                    if (catg == 1) {
                        lista.adicionarProduto(new Mercado(nome, qntd, t));
                        break;
                    } else if (catg == 2) {
                        lista.adicionarProduto(new Farmacia(nome, qntd, t));
                        break;
                    } else if (catg == 3) {
                        lista.adicionarProduto(new Generico(nome, qntd, t));
                        break;
                    }
                }

            } else if (opcao.equals("3")) {
                System.out.println("Digite o nome do produto:");
                String remover = scan.nextLine();
                Produtos produtoEncontrado = null;
                for (Produtos p : lista.getProdutos()) {
                    if (p.getNome().equalsIgnoreCase(remover)) {
                        produtoEncontrado = p;
                        break;
                    }
                }
                if (produtoEncontrado == null) {
                    System.out.println("Produto nao encontrado." + "\n");
                } else {
                    System.out.println("Voce deseja:"
                            + "\n" + "1. Remover quantidade"
                            + "\n" + "2. Remover produto inteiro"
                            + "\n");

                    String escolha = scan.nextLine();

                    if (escolha.equals("1")) {
                        System.out.println("Quantidade disponivel: " + produtoEncontrado.getQuantidade());
                        System.out.println("Digite a quantidade que deseja remover:");
                        while (true) {
                            String qntd = scan.nextLine();
                            if (!qntd.matches("\\d+")) {
                                System.out.println("Digite apenas numeros.");
                                continue;
                            }
                            int quantidade = Integer.parseInt(qntd);
                            lista.remover(remover, quantidade);
                            break;
                        }
                    } else if (escolha.equals("2")) {
                        lista.remover(remover);
                    } else {
                        System.out.println("Opcao invalida.");
                    }
                }

            } else if (opcao.equals("4")) {
                while (true) {
                    System.out.println("Seu estoque: " + "\n");
                    estoque.meuEstoque(estoque);
                    System.out.println("1. Voltar");
                    String opcao2 = scan.nextLine();
                    if (opcao2.equals("1")) {
                        break;
                    } else {
                        System.out.println("Caractere invalido. Tente Novamente");
                    }
                }
            } else if (opcao.equals("5")) {
                String nome;
                String quantidade;
                String qntMinima;
                System.out.println("Para adicionar um produto ao estoque, primeiramente diga-me o nome: ");
                while (true) {
                    nome = scan.nextLine();
                    if (nome.isBlank() || nome.matches(".*\\d+.*")) {
                        System.out.println("Por favor, digite o nome de um produto valido.");
                        continue;
                    } else {
                        break;
                    }
                }
                System.out.println("Quer especificar qual a categoria desse produto? EX: Brinquedo, Remedio, Tinta... (Se nao, apenas aperte enter): ");
                String tipo = scan.nextLine();
                System.out.println("Agora, quantos desses produtos tem em seu estoque?: ");
                while (true) {
                    quantidade = scan.nextLine();
                    if (!quantidade.matches("\\d+") || quantidade.isEmpty()) {
                        System.out.println("Por favor, digite um valor valido.");
                    } else {
                        break;
                    }
                }
                System.out.println("Agora, me forneca uma quantidade minima para esse produto: ");
                while (true) {
                    qntMinima = scan.nextLine();
                    if (!qntMinima.matches("\\d+") || qntMinima.isEmpty()) {
                        System.out.println("Por favor, informe uma quantidade minima, e necessario para que haja verificacao");
                        continue;
                    } else {
                        break;
                    }
                }
                int qntdMin = Integer.parseInt(qntMinima);
                int qntd = Integer.parseInt(quantidade);
                estoque.adicionar(new Generico(nome, qntd, tipo, qntdMin));
                lista = estoque.verificar(lista);

            } else if (opcao.equals("6")) {
                System.out.println("Digite o nome do produto:");
                String remover = scan.nextLine();
                Produtos produtoEncontrado = null;

                for (Produtos p : estoque.getEstoqueProdutos()) {

                    if (p.getNome().equalsIgnoreCase(remover)) {
                        produtoEncontrado = p;
                        break;
                    }
                }

                if (produtoEncontrado == null) {

                    System.out.println("Produto nao encontrado." + "\n");

                } else {

                    System.out.println("Voce deseja:"
                            + "\n" + "1. Remover quantidade"
                            + "\n" + "2. Remover produto inteiro"
                            + "\n");

                    String escolha = scan.nextLine();
                    if (escolha.equals("1")) {

                        System.out.println("Quantidade disponivel: " + produtoEncontrado.getQuantidade());

                        System.out.println("Digite a quantidade:");
                        while (true) {
                            escolha = scan.nextLine();
                            if (escolha.matches("\\d+")) {
                                int quantidade = Integer.parseInt(escolha);
                                estoque.remover(remover, quantidade);
                                lista = estoque.verificar(lista);
                                break;
                            }
                        }
                    } else if (escolha.equals("2")) {

                        estoque.remover(remover);
                        lista.remover(remover);

                    } else {
                        System.out.println("Opcao invalida.");
                    }
                }
            } else if (opcao.equals("7")) {
                System.out.println("Voce saiu do programa.");
                break;
            } else {
                System.out.println("Essa opcao nao esta disponivel, tente novamente.");
                System.out.println("");
            }
        }
        scan.close();
    }
}
