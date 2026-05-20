package poo.array;

import java.util.ArrayList;
import java.util.List;

public class main {
    static void main() {
        Animais cachorro = new Animais();
        cachorro.setAnimal("Cachorro");
        cachorro.setIdade(3);
        cachorro.setSelvagem(false);

        Animais gatoDoMato = new Animais();
        gatoDoMato.setAnimal("Gato do Mato");
        gatoDoMato.setIdade(5);
        gatoDoMato.setSelvagem(true);

        Animais cavalo = new Animais();
        cavalo.setAnimal("Cavalo");
        cavalo.setIdade(7);
        cavalo.setSelvagem(false);

        //5 elementos

        Animais porco = new Animais();
        porco.setAnimal("Porco");
        porco.setIdade(10);
        porco.setSelvagem(true);

        Animais zebra = new Animais();
        zebra.setAnimal("Zebra");
        zebra.setIdade(6);
        zebra.setSelvagem(true);

        List<Animais> listaDeAnimais = new ArrayList<>();
        listaDeAnimais.add(cavalo);
        listaDeAnimais.add(cachorro);
        listaDeAnimais.add(gatoDoMato);
        listaDeAnimais.add(zebra);
        listaDeAnimais.add(porco);

        for (Animais a : listaDeAnimais){
            System.out.println(a.toString());
        }
    }
}
