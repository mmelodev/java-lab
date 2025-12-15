import java.util.Scanner;

public class TesteDoRetangulo {

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
		
		if (Math.pow(valor1, 2) == Math.pow(valor2, 2) + Math.pow(valor3, 2) || Math.pow(valor2, 2) == Math.pow(valor3, 2) + Math.pow(valor1, 2) || Math.pow(valor1, 2) == Math.pow(valor3, 2) + Math.pow(valor2, 2)) {
			System.out.println("\nOs valores digitados formam um triangulo retangulo :) \n");
		} else {
			System.out.println("\nOs valores digitados não formam um triangulo retangulo :( \n");
		}
		
		
	}

}
