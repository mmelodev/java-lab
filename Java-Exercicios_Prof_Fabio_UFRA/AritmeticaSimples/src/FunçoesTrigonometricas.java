
import java.util.*;

public class FunçoesTrigonometricas {

	public static void main(String[] args) {
		
		Scanner ag = new Scanner (System.in);
		
		System.out.println("Digite o valor de um ângulo em graus: \n");
		double graus = ag.nextDouble();
		
		double radianos = (graus * Math.PI) / 180;
		
		double seno = Math.sin(radianos);
		
		double cos = Math.cos(radianos);
		
		double tan = Math.tan(radianos);
		
		double sec = 1.0 / cos;
		
		
		System.out.println("\nO valor do seno é: \n" + seno);
		System.out.println("\nO valor do cosseno é: \n" + cos);
		System.out.println("\nO valor da tangente é: \n" + tan);
		System.out.println("\nO valor do secante é: \n" + sec);
		
		
	}

}
