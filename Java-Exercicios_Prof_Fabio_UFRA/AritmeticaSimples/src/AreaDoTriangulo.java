import java.util.*;

public class AreaDoTriangulo {

    public static void main(String[] args) {

        Scanner b = new Scanner(System.in);
        Scanner a = new Scanner(System.in);

        System.out.println("Qual valor da base? \n");
        double base = b.nextDouble();

        System.out.println("Qual valor da altura? \n");
        double altura = a.nextDouble();

        double area = (base * altura) / 2;

        System.out.println("\nO valor da área do triangulo é de: " + area);
    }

}
