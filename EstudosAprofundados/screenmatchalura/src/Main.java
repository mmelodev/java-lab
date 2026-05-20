import br.com.screenmatch.modelos.Filme;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Filme poderosoChefao = new Filme();

        poderosoChefao.setNome("Poderoso Chefao");
        poderosoChefao.setAnoDeLancamento(1975);
        poderosoChefao.setDuracaoEmMinutos(175);

        poderosoChefao.exibeNome();
        poderosoChefao.exibeAnoDeLancamento();
        poderosoChefao.exibeDuracaoEmMinutos();

        poderosoChefao.novasAvaliacoes();

        poderosoChefao.exibeSaldoFinal();

    }
}