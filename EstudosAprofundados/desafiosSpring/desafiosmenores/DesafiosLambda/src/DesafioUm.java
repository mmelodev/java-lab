public class DesafioUm{
    public static void main(String[] args) {
        ISoma vezes = (a, b) -> a * b;
        System.out.println(vezes.multiplicacao(5, 5));
    }
}
