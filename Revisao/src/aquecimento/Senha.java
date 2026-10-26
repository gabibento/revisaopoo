package aquecimento;

public class Senha {
    private int numero = 0;
    private String setor;
    private static int totalEmitidas = 0;

    public Senha(String setor) {

        if (setor == null || setor.isEmpty()) {
            throw new IllegalArgumentException("Setor obrigatório");
        }

        this.setor = setor;
        totalEmitidas += 1;
        numero += totalEmitidas;
    }

    public int getNumero() {
        return numero;
    }

    public String getSetor() {
        return setor;
    }

    public static int getTotalEmitidas() {
        return totalEmitidas;
    }

    @Override
    public String toString() {
        return numero + " - " + setor;
    }
}
