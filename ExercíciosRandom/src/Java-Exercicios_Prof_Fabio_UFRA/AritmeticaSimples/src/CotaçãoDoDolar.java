
import java.util.*;

public class CotaçãoDoDolar {

	public static void main(String[] args) {

		System.out.println("Cotação do Dola Atual :') \n");
		
		Scanner d = new Scanner (System.in);
		Scanner qd = new Scanner (System.in);
		
		System.out.println("Se eu tenho um dólar, quantos reais ele vale hoje? \n");
		double dolar = d.nextDouble();
		
		System.out.println("Quantos dólares você tem para converter em reais: \n");
		double qntddolar = qd.nextDouble();
		
		double qntdreais = qntddolar * dolar;
		
		System.out.println("\nA quantidade de Reais que você têm é de: \n" + qntdreais);
		
		//Essa solução não sei se está 100% correta, mas tentei seguir a lógica.

	}

}
