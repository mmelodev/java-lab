package poo.classe_private;

public class main {
    static void main() {
        Livro sociedadeDoAnel = new Livro();

        sociedadeDoAnel.setAutor("Tolken");
        sociedadeDoAnel.setNumeroPaginas(320);
        sociedadeDoAnel.setFamoso(true);

        System.out.println("Informações Completas do livro Sociedade do Anel: " + sociedadeDoAnel.toString());

        System.out.println("Apenas quantidade de páginas de Sociedade do Anel: " + sociedadeDoAnel.getNumeroPaginas());
    }
}
