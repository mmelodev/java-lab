import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Primeiro {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10, 20, 30, 70, 50);

        Optional<Integer> resultado = numeros.stream().reduce(Integer::max);
        System.out.println(resultado);
    }
}
