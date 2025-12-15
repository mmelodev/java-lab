import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Terceiro {
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("Alice", "Bob", "Charlie");

        String juntandoPalavras = nomes.stream()
                .collect(Collectors.joining(", "));

        System.out.println(juntandoPalavras); 

        
        
    }
}
