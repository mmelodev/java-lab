
import java.util.*;

public class VolumeDaEsfera {

	public static void main(String[] args) {
		
		Scanner d = new Scanner (System.in);
		
		System.out.println("Vamos calcular o volume de uma esfera :)) \n \n");
		System.out.println("Qual o valor do diametro da esfera? \n");
		double diametro = d.nextDouble();
		
		double raio = diametro / 2;
		
		double area = (4 * Math.PI * Math.pow(raio, 3)) / 3;
		
		System.out.println("\nO valor do volume da esfera é de: " + area);
	}

}
