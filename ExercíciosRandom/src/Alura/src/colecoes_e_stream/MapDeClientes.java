
import java.util.HashMap;
import java.util.Map;

public class MapDeClientes {
      public static void main(String[] args) {
            Map<Integer, String> clientes = new HashMap<>();
            clientes.put(1, "Andréia");
            clientes.put(2, "Marcos");
            clientes.put(3, "João");
            System.out.println("O nome do cliente com ID 2 é: " + clientes.get(2));
      }
}
