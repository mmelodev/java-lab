import java.util.Scanner;

public class DesafioDois {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite um número: ");
        int numero = input.nextInt();

        System.out.println("\nDigite outro para fazermos a divisão: ");
        int numero2 = input.nextInt();

        IVerificarPrimo primo = (a, b) -> a % b;

        int resto = primo.primo(numero, numero2);

        if (numero % numero == 0 && numero % 1 == 0){
            System.out.println("\nO número é primo");
        }

        //ainda ta errado -> pendente

        System.out.println("\nA divisão de " + numero + " por " + numero2 + " tem resto: " + resto);

    }
}
