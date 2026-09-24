package produtos;

import java.util.ArrayList;
import java.util.List;

public class ListaDeCompras {

    private List<Produtos> produtos;

    public ListaDeCompras() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produtos p) {

        for (Produtos existente : produtos) {

            if (existente.getNome().equalsIgnoreCase(p.getNome())) {

                existente.setQuantidade(p.getQuantidade());
                existente.setTipo(p.getTipo());

                System.out.println("Produto ja existe. A quantidade foi atualizada e sua categoria tambem.");
                return;
            }
        }

        produtos.add(p);
    }

    // ARRUMADO:
    // agora altera apenas a lista, sem afetar o estoque
    public void remover(String nome, int quantidade) {

        for (int i = 0; i < produtos.size(); i++) {

            Produtos p = produtos.get(i);

            if (p.getNome().equalsIgnoreCase(nome)) {

                if (quantidade < p.getQuantidade()) {

                    p.setQuantidade(p.getQuantidade() - quantidade);

                    System.out.println("Quantidade removida na lista de compras.");

                } else if (quantidade == p.getQuantidade()) {

                    produtos.remove(i);

                    System.out.println("Produto removido da lista de compras.");

                } else {

                    System.out.println("Quantidade maior do que a existente na lista de compras.");
                }

                return;
            }
        }

        System.out.println("Produto nao encontrado na lista de compras.");
    }

    public void remover(String nome) {

        for (int i = 0; i < produtos.size(); i++) {

            if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {

                produtos.remove(i);

                System.out.println("Produto removido da lista de compras.");
                return;
            }
        }

        System.out.println("Produto nao encontrado na lista de compras.");
    }

    public void minhaLista() {

        if (produtos.isEmpty()) {

            System.out.println("Lista vazia.");
            return;
        }

        for (Produtos p : produtos) {

            System.out.println(p.toString());
        }
    }

    public List<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produtos> produtos) {
        this.produtos = produtos;
    }
}