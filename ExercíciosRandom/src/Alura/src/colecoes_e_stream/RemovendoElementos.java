import java.util.ArrayList;
import java.util.List;

public class RemovendoElementos {
      public static void main(String[] args) {
            List<String> funcionarios = new ArrayList<>();
            funcionarios.add("Joana");
            funcionarios.add("Lucas");
            funcionarios.add("Pedro");
            funcionarios.add("Antonio");
            System.out.println("Lista inicial: " + funcionarios);
            funcionarios.remove(2);
            System.out.println("Lista inicial: " + funcionarios);
      }
}
