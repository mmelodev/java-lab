
import java.util.*;

public class EstudoGetSetExe {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		EstudoGetSet novoCurso = new EstudoGetSet();
		
		System.out.printf("\nO nome do curso atual é: %s\n", novoCurso.getNomeCurso()); //retorna a variavel vazia -> devo entender melhor sobre a funcionalidade dessa linha
		
		System.out.printf("Digite o nome do seu curso: \n");
		String meuCurso = input.nextLine();
		
		novoCurso.setNomeCurso(meuCurso); //armazenou a variavel
		
		novoCurso.Mensagem(); //como já defini o conteudo da mensagem, aqui só preciso acionar

	}

}
