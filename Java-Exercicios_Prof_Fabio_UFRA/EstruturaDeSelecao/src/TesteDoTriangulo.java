
import java.util.*;

public class TesteDoTriangulo {

	public static void main(String[] args) {
		
		Scanner v1 = new Scanner (System.in);
		Scanner v2 = new Scanner (System.in);
		Scanner v3 = new Scanner (System.in);
		
		System.out.println("Digite o primeiro valor: \n");
		double valor1 = v1.nextDouble();
		System.out.println("\nDigite o segundo valor: \n");
		double valor2 = v2.nextDouble();
		System.out.println("\nDigite o terceiro valor: \n");
		double valor3 = v3.nextDouble();
		
		if (valor1 + valor2 > valor3 || valor2 + valor3 > valor1 || valor1 + valor3 > valor2) {
			System.out.println("\nOs valores digitados formam um triangulo \n");
			if(valor1 == valor2 && valor2 == valor3) {
				System.out.println("\nO triângulo é equilatero \n");
			} else if (valor1 != valor2 && valor2 != valor3 && valor1 != valor3) {
				System.out.println("\nO triângulo é escaleno \n");
			} else {
				System.out.println("\nO triângulo é isósceles \n");
			}
		} else {
			System.out.println("\nOs valores digitados não formam um triangulo \n");
		}
	}

}
