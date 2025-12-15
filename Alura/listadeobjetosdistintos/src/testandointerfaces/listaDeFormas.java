package testandointerfaces;

import br.com.listadeobjetosdistintos.modelos.Cachorro;

import java.util.ArrayList;

public class listaDeFormas {
    public static void main(String[] args) {
        var quadrado1 = new Quadrado(6, 10);
        var quadrado2 = new Quadrado(5, 5);
        var circulo1 = new Circulo(6);

        ArrayList<Formas> listadeformas = new ArrayList<>();

        listadeformas.add(quadrado1);
        listadeformas.add(quadrado2);
        listadeformas.add(circulo1);

        for (Formas forma : listadeformas){
            if (forma instanceof Quadrado){
                ((Quadrado) forma).calcularArea();
                System.out.println("Á Área do " + forma.toString() + " é: " + forma.calcularArea());
            } else if (forma instanceof Circulo){
                System.out.println("Á Área do " + forma.toString() + " é: " + forma.calcularArea());
            }
        }
    }
}
