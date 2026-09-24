package produtos;

public class Farmacia extends Produtos {

    public Farmacia(String nome, int quantidade, String tipo, int qntMinima) {
        super(nome, quantidade, tipo, qntMinima);
    }

    public Farmacia(String nome, int quantidade, String tipo) {
        super(nome, quantidade, tipo);
    }

}
