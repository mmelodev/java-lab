import java.util.Arrays;
import java.util.List;

public class Quarto {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        int soma = 0;
        for (int numero : numeros) {
            if (numero % 2 == 0) {
                int quadrado = (int) Math.pow(numero, 2);
                soma += quadrado;
            } 
        }
        System.out.println("\nA soma dos quadrados da lista é: " + soma);
    }
}
