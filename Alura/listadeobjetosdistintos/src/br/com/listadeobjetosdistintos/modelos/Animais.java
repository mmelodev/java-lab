package br.com.listadeobjetosdistintos.modelos;

import javax.security.auth.callback.CallbackHandler;
import java.util.ArrayList;

public class Animais {
    public static void main(String[] args) {
        var rex = new Cachorro("Rex", 7, "viralata", true);

        var caramelo = new Cachorro("Caramelo", 3, "viralata", false);

        ArrayList<Cachorro> listadecachrros = new ArrayList<>();

        listadecachrros.add(rex);
        listadecachrros.add(caramelo);

//        System.out.println(listadecachrros);

        Animal solo = new Cachorro("Han Solo", 7, "Dalmata", true); //casting explicito

        if (solo instanceof Cachorro){
            Animal animal = (Animal) solo; //acredito que isso seja um downcasting, estou pegando um objeto da superclasse e jogando nele um objeto da classe filho
            System.out.println(animal);
        } else {
            System.out.println("Não é o mesmo tipo de objeto");
        }
    }
}
