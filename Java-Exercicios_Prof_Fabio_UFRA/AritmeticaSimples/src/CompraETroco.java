
import java.util.*;

public class CompraETroco {

	public static void main(String[] args) {
		
		Scanner p1 = new Scanner (System.in);
		Scanner p2 = new Scanner (System.in);
		Scanner p3 = new Scanner (System.in);
		Scanner p4 = new Scanner (System.in);
		Scanner p5 = new Scanner (System.in);
		
		Scanner c = new Scanner (System.in);
		
		System.out.println("Digite o valor do primeiro produto: \n");
		double produto1 = p1.nextDouble();
		System.out.println("\nDigite o valor do segundo produto: \n");
		double produto2 = p2.nextDouble();
		System.out.println("\nDigite o valor do terceiro produto: \n");
		double produto3 = p3.nextDouble();
		System.out.println("\nDigite o valor do quarto produto: \n");
		double produto4 = p4.nextDouble();
		System.out.println("\nDigite o valor do quinto produto: \n");
		double produto5 = p5.nextDouble();
		
		double somageral = produto1 + produto2 + produto3 + produto4 + produto5;
		
		System.out.println("\nO valor dos produtos foi de: " + somageral);
		
		System.out.println("\nDigite o quanto você vai pagar: \n");
		double pagamento = c.nextDouble();
		
		double troco = pagamento - somageral;
		
		System.out.println("\nO seu troco foi de: " + troco);

	}

}
