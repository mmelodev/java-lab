import exceptions.ErrorCasoZero;

import java.util.Scanner;

public class MainNumeros {
    public static void main(String[] args) {
        try {
            Scanner n1 = new Scanner(System.in);
            Scanner n2 = new Scanner(System.in);

            System.out.println("Divisão de Números\n");

            System.out.println("Digite o primeiro número: ");
            double numero1 = n1.nextDouble();

            System.out.println("\nDigite o segundo número: ");
            double numero2 = n2.nextDouble();

            if (numero2 == 0){
                throw new ErrorCasoZero("\nNão se pode dividir um número por zero");
            }

            double divisao = numero1 / numero2;
            System.out.println("\nO resultado é: " + divisao);

        } catch (ErrorCasoZero e){
            System.out.println(e.getMessage());
        }
    }
}
