import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
            new Produto("Smartphone", 800.0, "Eletrônicos"),
            new Produto("Notebook", 1500.0, "Eletrônicos"),
            new Produto("Teclado", 200.0, "Eletrônicos"),
            new Produto("Cadeira", 300.0, "Móveis"),
            new Produto("Monitor", 900.0, "Eletrônicos"),
            new Produto("Mesa", 700.0, "Móveis")
        );

        produtos.stream()
            .filter(p -> p.getCategoria().equalsIgnoreCase("eletrônicos") && p.getPreco() < 1000)
            .forEach(System.out::println);

        Map <String, List<Produto>> listaDeProdutos = produtos.stream()
            .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.toList()));
        
        System.out.println(listaDeProdutos);
    }
}
