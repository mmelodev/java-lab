
import java.util.*;

public class VolumeDoCuboEDaEsfera {

	public static void main(String[] args) {
		
		Scanner r = new Scanner (System.in);
		Scanner a = new Scanner (System.in);
		
		System.out.println("Qual é o valor do raio da esfera? \n");
		double raio = r.nextDouble();
		
		System.out.println("\nQual é o valor da arresta do cubo? \n");
		double arresta = a.nextDouble();
		
		double volumeesfera = (4 * Math.PI * Math.pow(raio, 3)) / 3;
		
		double volumecubo = Math.pow(arresta, 3);
		
		
		System.out.println("\nO Volume da esfera é de: \n" + volumeesfera);
		System.out.println("\nO Volume do cubo é de: \n" + volumecubo);
	}

}
