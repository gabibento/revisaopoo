package setup;

public class Orcamento {

    private Cliente solicitante;
    private Entrega entrega;

    public Orcamento(Cliente solicitante, String cidade, int prazoDias) {
        this.solicitante = solicitante;
        this.entrega = new Entrega(cidade, prazoDias);
    }

    public Cliente getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Cliente solicitante) {
        this.solicitante = solicitante;
    }

    public String getCidadeEntrega() {
        return entrega.getCidade();
    }


    public int getPrazoEntrega() {
        return entrega.getPrazoDias();
    }


}
