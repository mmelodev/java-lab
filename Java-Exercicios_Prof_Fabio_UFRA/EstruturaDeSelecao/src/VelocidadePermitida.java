
import java.util.*;

public class VelocidadePermitida {

	public static void main(String[] args) {
		
		Scanner v1 = new Scanner (System.in);
		Scanner v2 = new Scanner (System.in);
		Scanner v3 = new Scanner (System.in);
		
		System.out.println("Digite a velocidade inicial: \n");
		double vi = v1.nextDouble();
		
		System.out.println("\nDigite a aceleração: \n");
		double a = v2.nextDouble();
		
		System.out.println("\nDigite o valor do tempo: \n");
		double t = v3.nextDouble();
		
		double vf = (vi + (a * t)) * 3.6;
		
		if (vf <= 40) {
			System.out.println("\nVeículo muito lento \n");
		} else if (vf <= 60) {
			System.out.println("\nVelocidade permitida \n");
		} else if(vf <= 80) {
			System.out.println("\nVelocidade de cruzeiro \n");
		} else if (vf <= 120) {
			System.out.println("\nVeículo rápido \n");
		} else {
			System.out.println("\nVeículo muito rápido \n");
		}

	}

}
