package Alura.condicionais;

import java.util.Scanner;

public class AprovacaoDisciplina {
    static void main() {
        double mediaFinal = 7.0;

        Scanner m = new Scanner(System.in);

        System.out.println("Digite a média do aluno(a): ");
        double media = m.nextDouble();

        if (media >= mediaFinal){
            System.out.println("O estudante teve média " + media + " e foi aprovado");
        } else if(media >= 5.0 && media < mediaFinal) {
            System.out.println("O estudante teve média " + media + " e está recuperação");
        } else{
            System.out.println("O estudante teve média " + media + " e foi reprovado");
        }
    }
}
