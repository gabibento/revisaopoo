package aquecimento;

public abstract class Midia {

    private String descricao;
    private double precoBase;

    public Midia(String descricao, double precoBase) {
        this.descricao = descricao;
        this.precoBase = precoBase;
    }

    public abstract double calcularPreco();

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoBase() {
        return precoBase;
    }
}
