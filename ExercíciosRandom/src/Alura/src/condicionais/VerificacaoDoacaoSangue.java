package Alura.condicionais;

import java.util.Scanner;

public class VerificacaoDoacaoSangue {
    static void main() {
        Scanner i = new Scanner(System.in);

        System.out.println("Digite a idade do doador: ");
        int idade = i.nextInt();
        System.out.println("Digite o peso do doador (em kg): ");
        int peso = i.nextInt();

        if (idade >= 18 && idade <= 65){
            if (peso > 50){
                System.out.println("Doador é compatível");
            } else {
                System.out.println("O doador não é compatível.  \n" +
                        "Motivo: O Peso deve ser acima de 50kg \n");
            }
        } else{
            System.out.println("O doador não é compatível.  \n" +
                    "Motivo: Deve ter entre 18 e 65 anos. \n");
        }
    }
}
