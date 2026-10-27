package setup;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Itens criados: " + ItemSetup.getTotalItens());

        Cliente marina = new Cliente("Marina Souza", "123.456.789-00");
        Orcamento orcamento = new Orcamento(marina, "Blumenau", 7);

        ItemSetup placa = new Peca("Placa de vídeo", 2500.0, 1);
        ItemSetup monitor = new Peca("Monitor 27 polegadas", 1200.0, 3);
        ItemSetup montagem = new Montagem("Montagem e cabeamento", 80.0, 2);

        orcamento.adicionarItem(placa);
        orcamento.adicionarItem(monitor);
        orcamento.adicionarItem(montagem);

        System.out.println("Solicitante: " + orcamento.getSolicitante().getNome());
        System.out.println("Entrega: " + orcamento.getCidadeEntrega() + ", em " + orcamento.getPrazoEntrega() + " dias");

        for (ItemSetup item : orcamento.getItens()) {
            System.out.println(item);
        }

        System.out.println("Valor total: R$ " + orcamento.calcularValorTotal());
        System.out.println("Garantia estendida: R$ " + orcamento.calcularTotalGarantia());

        try {
            orcamento.adicionarItem(placa);
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        // a montagem invalida gastou codigo porque o super(...) roda primeiro. o ItemSetup valida o preço (80 ta ok),
        // incrementa o contador e só depois volta pra Montagem, que ai ve que as horas sao 0 e lança a exceção.
        // na A1 a validação do setor tava no mesmo construtor, antes do incremento, entao a senha invalida nao gastava numero
        try {
            ItemSetup montagemZerada = new Montagem("Montagem extra", 80.0, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("Itens criados: " + ItemSetup.getTotalItens());
    }
}