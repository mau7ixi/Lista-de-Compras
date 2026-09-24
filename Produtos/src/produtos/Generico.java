package produtos;

public class Generico extends Produtos {

    public Generico(String nome, int quantidade, String tipo, int qntMinima) {
        super(nome, quantidade, tipo, qntMinima);
    }

    public Generico(String nome, int quantidade, String tipo) {
        super(nome, quantidade, tipo);
    }

}
