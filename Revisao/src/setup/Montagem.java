package setup;

public class Montagem extends ItemSetup {

    private int horas;

    public Montagem(double precoBase, String descricao, int horas) {
        super(precoBase, descricao);

        if (horas <= 0) {
            throw new IllegalArgumentException("Quantidade de horas inválida");
        }
        this.horas = horas;
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase() * horas;
    }
}
