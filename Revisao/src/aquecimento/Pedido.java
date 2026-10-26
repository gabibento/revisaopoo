package aquecimento;

// Versão 1 está errado póis Pedido não é um endereço, Pedido TEM um endereço de entrega

// Versão 2 está errada pois cria o Endereco numa variável local dentro do construtor que só existe no construtor

public class Pedido {
    private Cliente comprador;
    private Endereco entrega;

    public Pedido(Cliente comprador, String rua, int numero) {
        this.comprador = comprador;
        this.entrega = new Endereco(rua, numero); // composição: o todo cria a parte
    }

    public Cliente getComprador() {
        return comprador;
    }

    public String getRuaEntrega() {
        return entrega.getRua();
    }

    public int getNumeroEntrega() {
        return entrega.getNumero();
    }
}