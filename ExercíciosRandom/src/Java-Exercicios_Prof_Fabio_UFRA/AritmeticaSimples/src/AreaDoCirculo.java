
import java.util.*;

public class AreaDoCirculo {

	public static void main(String[] args) {
		
		Scanner d = new Scanner (System.in);
		
		System.out.println("Qual o valor do diametro para calcularmos a área de um circulo: \n");
		double diametro = d.nextDouble();
		
		double raio = diametro / 2;
		
		double area = Math.PI * Math.pow(raio, 2);
		
		System.out.println("\nO valor da área é de: \n" + area);
	}

}
