import java.util.ArrayList;
import java.util.Objects;

public class primeirotesteforeach {
    public static void main(String[] args) {

        var uno = new Carro();
        uno.setModelo("Uno");
        uno.setMarca("Fiat");
        uno.setAnoDeLancamento(1983);
        var corolla = new Carro();
        corolla.setModelo("Corolla");
        corolla.setMarca("Toyota");
        corolla.setAnoDeLancamento(1966);
        var palio = new Carro();
        palio.setModelo("Palio");
        palio.setMarca("Fiat");
        palio.setAnoDeLancamento(1996);

        ArrayList<Carro> listadecarros = new ArrayList<>();

        listadecarros.add(uno);
        listadecarros.add(corolla);
        listadecarros.add(palio);

        for (Object carro : listadecarros){
            System.out.println(carro);
        }

    }
}