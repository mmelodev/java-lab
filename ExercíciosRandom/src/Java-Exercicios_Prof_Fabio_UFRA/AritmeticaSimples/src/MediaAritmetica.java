
import java.util.*;

public class MediaAritmetica {

	public static void main(String[] args) {
		
		Scanner v1 = new Scanner(System.in);
		Scanner v2 = new Scanner(System.in);
		Scanner v3 = new Scanner(System.in);
		Scanner v4 = new Scanner(System.in);
		
		System.out.println("Digite o primeiro valor: \n");
		double valor1 = v1.nextDouble();
		
		System.out.println("Digite o segundo valor: \n");
		double valor2 = v2.nextDouble();
		
		System.out.println("Digite o terceiro valor: \n");
		double valor3 = v3.nextDouble();
		
		System.out.println("Digite o quarto valor: \n");
		double valor4 = v4.nextDouble();
		
		double mediaarit = (valor1 * valor2 * valor3 * valor4) / 4; //O ideal é o programa identificar quantos valores estão no código, acredito que a uma boa seja colocar num array
		
		System.out.println("\nA Média Artimética é de: \n" + mediaarit);
	}

}
