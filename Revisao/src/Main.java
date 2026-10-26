import aquecimento.Senha;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    System.out.println("Emitidas: " + Senha.getTotalEmitidas());

    System.out.println(new Senha("Caixa"));
    System.out.println(new Senha("Gerência"));
    System.out.println(new Senha("Caixa"));

    try {
        System.out.println(new Senha(null));
    } catch (IllegalArgumentException e) {
        System.out.println("Erro: " + e.getMessage());
    }

    System.out.println(new Senha("Caixa"));

    System.out.println("Emitidas: " + Senha.getTotalEmitidas());

    // 1) O contador totalEmitidas precisa ser static porque é da classe, não de cada senha
    // Sem o static, cada senha tem o próprio contador começando do zero, então todas saíram com número 1.

    // 2) Porque chamo ele pela classe (Senha.getTotalEmitidas()) antes de existir qualquer senha. Sem static não compila

    // 3) O incremento fica depois do if que valida o setor. Se o setor for inválido, o throw para o construtor antes do incremento, e a senha inválida não gasta número.

}
