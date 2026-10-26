package setup;

public abstract class ItemSetup {
    private static int totalItens;
    private int codigo;
    private String descricao;
    private double precoBase;


    public ItemSetup(double precoBase, String descricao) {

        if (precoBase <= 0) {
            throw new IllegalArgumentException("Preço base inválido");
        }
        this.precoBase = precoBase;
        this.descricao = descricao;
        totalItens++;
        codigo = totalItens;
    }

    public static int getTotalItens() {
        return totalItens;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public abstract double calcularPreco();

    @Override
    public String toString() {
        return codigo + " - " + descricao + " - " + calcularPreco();
    }
}
