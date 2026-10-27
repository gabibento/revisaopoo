package setup;

public class Peca extends ItemSetup implements ComGarantia {
    private int quantidade;

    public Peca( String descricao, double precoBase, int quantidade) {
        super(precoBase, descricao);

        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade inválida");
        }
        this.quantidade = quantidade;
    }

    @Override
    public double calcularPreco() {
        double preco = calcularPreco() * quantidade;

        if (quantidade >= 3) {
            preco -= getPrecoBase() * 0.10;
        }
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public double calcularGarantiaEstendida() {
        return calcularPreco() * 0.15;
    }
}
