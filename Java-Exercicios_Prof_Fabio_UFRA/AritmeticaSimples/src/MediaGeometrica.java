
import java.util.*;

public class MediaGeometrica {

	public static void main(String[] args) {
		
		Scanner v1 = new Scanner(System.in);
		Scanner v2 = new Scanner (System.in);
		
		System.out.println("Digite o primeiro valor: \n");
		double valor1 = v1.nextDouble();
		
		System.out.println("Digite o segundo valor: \n");
		double valor2 = v2.nextDouble();
		
		double mediageo = Math.sqrt(valor1 * valor2);
		
		System.out.println("\nA média Geométrica é de: \n" + mediageo);

	}

}
