package aquecimento;

import java.util.ArrayList;

public class PrincipalA2 {
    static void main() {
        // a) Declarando como Midia o main não depende da classe concreta
        Midia f = new Filme("Interestelar", 20.0);
        Midia s = new Serie("Dark", 15.0, 3);
        Midia d = new Documentario("Cosmos", 10.0);

        ArrayList<Midia> catalogo = new ArrayList<>();
        catalogo.add(f);
        catalogo.add(s);
        catalogo.add(d);

        // b) O custo de legenda do documentário não entrou no total porque o instanceof só testa Serie. Saiu 4.5, quando deveria ser 5.5.
        double totalColega = 0;
        for (Midia m : catalogo) {
            if (m instanceof Serie) {
                totalColega += ((Serie) m).calcularCustoLegenda();
            }
        }
        System.out.println("Total do colega: " + totalColega);


        // c) O instanceof e o cast vao para a interface Legendavel para que qualquer classe que implementar Legendavel entre no total
        double totalLegenda = 0;
        for (Midia m : catalogo) {
            if (m instanceof Legendavel) {
                totalLegenda += ((Legendavel) m).calcularCustoLegenda();
            }
        }
        System.out.println("Total corrigido: " + totalLegenda);




    }
}
