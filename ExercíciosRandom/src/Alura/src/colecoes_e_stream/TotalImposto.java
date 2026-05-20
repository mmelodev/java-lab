import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TotalImposto{
	public static void main(String[] args) {
		List<Double> precosProdutos = List.of(29.99, 49.50, 15.75, 99.99);
		double valorTotal = precosProdutos.stream()
				.reduce(0.0, Double::sum);
		System.out.println("Total gasto: " + valorTotal);
		double valorDeCadaComImposto = precosProdutos.stream()
				.reduce(0.0, (acumulado, atual) -> acumulado + (atual * 0.08));
		System.out.println("Valor de Cada com imposto de 8%: " + valorDeCadaComImposto);
		double valorTotalComImposto = valorTotal + (valorTotal * 0.08);
		System.out.println("Valor total com imposto de 8%: " + valorTotalComImposto);
	}
}