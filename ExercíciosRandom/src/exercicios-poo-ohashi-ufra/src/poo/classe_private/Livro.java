package poo.classe_private;

public class Livro {
    private String autor;
    private int numeroPaginas;
    private Boolean famoso;

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public void setFamoso(Boolean famoso) {
        this.famoso = famoso;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public Boolean getFamoso() {
        return famoso;
    }

    @Override
    public String toString() {
        return "Autor:" + autor + "\n" +
                "NumeroPaginas=" + numeroPaginas + "\n" +
                "Famoso=" + famoso + "\n";
    }
}
