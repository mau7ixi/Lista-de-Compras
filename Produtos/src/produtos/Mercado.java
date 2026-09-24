package produtos;

public class Mercado extends Produtos {

    public Mercado(String nome, int quantidade, String tipo, int qntMinima) {
        super(nome, quantidade, tipo, qntMinima);
    }

    public Mercado(String nome, int quantidade, String tipo) {
        super(nome, quantidade, tipo);
    }

}
