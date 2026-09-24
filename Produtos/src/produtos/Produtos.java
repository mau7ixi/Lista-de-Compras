package produtos;

abstract class Produtos {

    private String nome;
    private int quantidade;
    private String tipo;
    private int qntMinima;

    public Produtos(String nome, int quantidade, String tipo, int qntMinima) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.qntMinima = qntMinima;
        this.tipo = (tipo == null || tipo.isEmpty()) ? this.getClass().getSimpleName() : tipo;
    }

    public int getResultado() {
        return qntMinima - quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQntMinima() {
        return qntMinima;
    }

    public void setQntMinima(int qntMinima) {
        this.qntMinima = qntMinima;
    }

    public Produtos(String nome, int quantidade, String tipo) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.tipo = (tipo == null || tipo.isEmpty()) ? this.getClass().getSimpleName() : tipo;
    }
    
    @Override
    public String toString() {
        if (precisaComprar() == false) {
            return nome + "   Quantidade: " + quantidade + "   Categoria: " + tipo;
        } else {
            return nome + "   Quantidade: " + getResultado() + "   Categoria: " + tipo;
        }
    }   
    
    public String toString(Estoque e) {
        return nome + "   Quantidade: " + quantidade + "   Categoria: " + tipo + "    Quantidade minima definida: " + qntMinima;
    }

    public boolean precisaComprar() {
        return quantidade < qntMinima;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
