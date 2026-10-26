package cacaaoserros;

public class CacaAosErros {

    // B1. Limite
    // (a) o if ta com > 5, ai com 5 itens na lista 5 > 5 da falso e deixa passar o 6º
    // (b) adicionando 6 itens diferentes, o 6º entra e a lista fica com 6. devia dar IllegalStateException "Orçamento lotado" no 6º
    // (c)
    //     if (itens.size() == 5) {
    //         throw new IllegalStateException("Orçamento lotado");
    //     }
    //     itens.add(item);

    // B2. Tipo da exceção
    // (a) item repetido nao é argumento invalido, o item ta certo, o problema é que ele ja ta no orçamento. isso é estado do objeto, entao é IllegalStateException.
    // (b) adicionando a placa de video duas vezes, dá IllegalArgumentException mas o certo era IllegalStateException
    // (c)
    //     if (itens.contains(item)) {
    //         throw new IllegalStateException("Item já incluído no orçamento");
    //     }

    // B3. Ordem das validações
    // (a) o lotado ta sendo testado antes do repetido, mas a ordem pedida é null, repetido, lotado
    // (b) com o orçamento cheio (5 itens), tentando adicionar de novo um que ja ta na lista, sai "Orçamento lotado". o certo era "Item já incluído no orçamento"
    // (c)
    //     if (item == null) throw new IllegalArgumentException("Item inválido");
    //     if (itens.contains(item)) throw new IllegalStateException("Item já incluído no orçamento");
    //     if (itens.size() == 5) throw new IllegalStateException("Orçamento lotado");

    // B4. Remoção
    // (a) o for lança a exceção no primeiro item que for diferente, sem olhar o resto da lista. e com a lista vazia o for nem roda, entao nao lança nada
    // (b) com 3 itens, removendo o segundo: o primeiro ja é diferente e da "Item não encontrado no orçamento", mesmo o item estando la. devia remover normal.
    //     com a lista vazia: nao acontece nada, o remove só devolve false. devia dar IllegalStateException
    // (c)
    //     public void removerItem(ItemSetup item) {
    //         if (!itens.remove(item)) {
    //             throw new IllegalStateException("Item não encontrado no orçamento");
    //         }
    //     }

    // B5. Contador
    // (a) o contador é incrementado antes de validar o preço, ai o item invalido gasta um codigo mesmo dando erro
    // (b) criando um valido, um invalido (preço 0) e outro valido, saem os codigos 1 e 3. deviam ser 1 e 2
    // (c)
    //     public ItemSetup(String descricao, double precoBase) {
    //         if (precoBase <= 0) {
    //             throw new IllegalArgumentException("Preço base inválido");
    //         }
    //         totalItens++;
    //         codigo = totalItens;
    //         this.descricao = descricao;
    //         this.precoBase = precoBase;
    //     }

    // B6. Base do cálculo
    // (a) a garantia ta sendo calculada em cima do preço base, sem o desconto. tem que ser 15% do preço calculado
    // (b) 3 monitores de 1200: devolve 1200 * 3 * 0.15 = 540. o certo é 1200 * 3 = 3600, com 10% de desconto da 3240, e 15% disso = 486
    // (c)
    //     @Override
    //     public double calcularGarantiaEstendida() {
    //         return calcularPreco() * 0.15;
    //     }

    // B7. toString sem @Override
    // (a) tostring ta com s minusculo, entao é um metodo novo e nao sobrescreve o toString do Object
    // (b) System.out.println(item) mostra algo tipo setup.Peca@1b6d3586 em vez de "1 - Placa de vídeo - R$ 2500.0".
    //     colocando @Override o compilador da erro dizendo que o metodo nao sobrescreve nenhum metodo da superclasse
    //     o @Override vale pro Object tambem porque toda classe herda dele, entao o toString ja existe e ta sendo sobrescrito.
    //     o @Override serve justamente pra o compilador conferir se o nome ta certo
    // (c)
    //     @Override
    //     public String toString() {
    //         return getCodigo() + " - " + getDescricao() + " - R$ " + calcularPreco();
    //     }

    // B8. main
    // (a) 4 erros: a variavel é Peca e devia ser ItemSetup. getSolicitante() imprime o objeto Cliente e nao o nome.
    //     println(getItens()) imprime a lista toda numa linha so, com colchetes. e a ultima linha adiciona a placa de novo sem try/catch
    // (b) sai "Solicitante: setup.Cliente@4e25154f" em vez de "Solicitante: Marina Souza", os itens saem tipo
    //     "[1 - Placa de vídeo - R$ 2500.0]" em vez de um por linha, e a ultima linha lança IllegalStateException e o programa para com erro
    // (c)
    //     ItemSetup placa = new Peca("Placa de vídeo", 2500.0, 1);
    //     orcamento.adicionarItem(placa);
    //     System.out.println("Solicitante: " + orcamento.getSolicitante().getNome());
    //     for (ItemSetup item : orcamento.getItens()) {
    //         System.out.println(item);
    //     }
    //     try {
    //         orcamento.adicionarItem(placa);
    //     } catch (IllegalStateException e) {
    //         System.out.println("Erro: " + e.getMessage());
    //     }
}