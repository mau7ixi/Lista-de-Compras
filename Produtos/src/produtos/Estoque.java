package produtos;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private List<Produtos> estoqueProdutos;

    public List<Produtos> getEstoqueProdutos() {
        return estoqueProdutos;
    }

    public Estoque() {
        estoqueProdutos = new ArrayList<>();
    }

    public void adicionar(Produtos p) {

        for (Produtos produtoExistente : estoqueProdutos) {

            if (produtoExistente.getNome().equalsIgnoreCase(p.getNome())) {

                // ARRUMADO:
                // soma quantidade ao invés de substituir
                produtoExistente.setQuantidade(
                        produtoExistente.getQuantidade() + p.getQuantidade()
                );

                produtoExistente.setQntMinima(p.getQntMinima());
                produtoExistente.setTipo(p.getTipo());

                System.out.println("Produto ja existe. Quantidade atualizada.");
                return;
            }
        }

        estoqueProdutos.add(p);
    }

    public ListaDeCompras verificar(ListaDeCompras lista) {

        for (Produtos p : estoqueProdutos) {

            boolean jaEstaLista = false;

            for (Produtos l : lista.getProdutos()) {

                if (l.getNome().equalsIgnoreCase(p.getNome())) {

                    jaEstaLista = true;
                    break;
                }
            }

            if (p.precisaComprar() && !jaEstaLista) {

                Produtos copia = new Generico(
                        p.getNome(),
                        p.getResultado(),
                        p.getTipo()
                );

                lista.adicionarProduto(copia);
            }
        }

        List<Produtos> paraRemover = new ArrayList<>();

        for (Produtos l : lista.getProdutos()) {

            for (Produtos e : estoqueProdutos) {

                if (e.getNome().equalsIgnoreCase(l.getNome())
                        && !e.precisaComprar()) {

                    paraRemover.add(l);
                    break;
                }
            }
        }

        lista.getProdutos().removeAll(paraRemover);

        return lista;
    }

    public void remover(String nome, int quantidade) {

        for (int i = 0; i < estoqueProdutos.size(); i++) {

            Produtos p = estoqueProdutos.get(i);

            if (p.getNome().equalsIgnoreCase(nome)) {

                if (quantidade < p.getQuantidade()) {

                    p.setQuantidade(
                            p.getQuantidade() - quantidade
                    );

                    System.out.println("Quantidade removida no estoque.");

                } else if (quantidade == p.getQuantidade()) {

                    estoqueProdutos.remove(i);

                    System.out.println("Produto removido do estoque.");

                } else {

                    System.out.println("Quantidade maior do que a existente.");
                }

                return;
            }
        }

        System.out.println("Produto nao encontrado no estoque.");
    }

    public void remover(String nome) {

        for (int i = 0; i < estoqueProdutos.size(); i++) {

            if (estoqueProdutos.get(i)
                    .getNome()
                    .equalsIgnoreCase(nome)) {

                estoqueProdutos.remove(i);

                System.out.println("Produto removido do estoque.");
                return;
            }
        }

        System.out.println("Produto nao encontrado no estoque.");
    }

    public void meuEstoque(Estoque valor) {

        if (estoqueProdutos.isEmpty()) {

            System.out.println("Estoque vazio.");
            return;
        }

        for (Produtos p : estoqueProdutos) {

            System.out.println(p.toString(valor));
        }
    }

    public void setEstoqueProdutos(List<Produtos> estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }
}
