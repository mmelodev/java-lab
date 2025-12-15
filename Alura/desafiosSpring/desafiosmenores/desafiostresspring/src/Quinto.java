import java.util.Arrays;
import java.util.List;

public class Quinto {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        for (int numero : numeros) {
            if (numero % 2 == 0) {
                System.out.println("\nO número " + numero + " é par!");
            } else {
                System.out.println("\nO número " + numero + " é impar!");
            }
        }
    }
}
