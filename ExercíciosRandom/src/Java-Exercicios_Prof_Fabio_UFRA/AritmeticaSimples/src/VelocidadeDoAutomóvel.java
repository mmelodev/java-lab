
import java.util.*;

public class VelocidadeDoAutomóvel {

	public static void main(String[] args) {
		Scanner vi = new Scanner(System.in);
		Scanner a = new Scanner(System.in);
		Scanner t = new Scanner(System.in);
		
		System.out.println("Digite o valor da velocidade inicial em m/s: \n");
		double velocidadeinicial = vi.nextDouble();
		System.out.println("Digite o valor da aceleração em m/s ao quadrado: \n");
		double aceleracao = a.nextDouble();
		System.out.println("Digite o valor do tempo em s: \n");
		double tempo = t.nextDouble();
		
		double vf = (velocidadeinicial + (aceleracao * tempo)) * 3.6;
		
		System.out.println("\nO valor da velocidade final é de: \n" + vf);
	}

}
