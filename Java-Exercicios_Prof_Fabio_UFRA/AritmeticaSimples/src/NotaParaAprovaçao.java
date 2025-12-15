
import java.util.*;

public class NotaParaAprovaçao {

	public static void main(String[] args) {
		
		Scanner p1 = new Scanner (System.in);
		
		System.out.println("Digite o valor da sua primeira nota: \n");
		double nota1 = p1.nextDouble();
		
		double nota2 = (15 - nota1) / 2;
		
		double quantofalta = nota2 - nota1;
		
		System.out.println("\nPara você passar de ano falta: " + quantofalta + " pontos");
		
		//Esse não tenho certeza se está 100% correto também, não queria usar if/else para deixar mais completo, a tarefa era apenas usar operadores aritméticos.

	}

}
