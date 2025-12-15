import java.sql.Array;
import java.util.*;

public class MainTitulo {
    public static void main(String[] args) {
        var StarWars = new Titulo("Star Wars");
        var SenhorDosAneis = new Titulo("Senhor Dos Aneis");
        var PoderosoChefao = new Titulo("Poderoso Chefao");
        var JurassicPark = new Titulo("Jurassic Park");

        List <Titulo> listadetitulos = new LinkedList<>();

        listadetitulos.add(StarWars);
        listadetitulos.add(SenhorDosAneis);
        listadetitulos.add(PoderosoChefao);
        listadetitulos.add(JurassicPark);

        System.out.println("antes: " + listadetitulos);

        Collections.sort(listadetitulos);

        System.out.println("depois: " + listadetitulos);

        // var HowIMetYourMother = new ArrayList<>();  -> criar um lista dentro de uma variavel

        var HowIMetYourMother = new Titulo("How I Met Your Mother");
        var Dexter = new Titulo("Dexter");
        var DrHouse = new Titulo("DrHouse");

        List<Titulo> listadeseries = new ArrayList<>();
        listadeseries.add(HowIMetYourMother);
        listadeseries.add(Dexter);
        listadeseries.add(DrHouse);

        System.out.println("antes: " + listadeseries);

        Collections.sort(listadeseries);

        System.out.println("depois: " + listadeseries);

        var novosFilmes = new ArrayList<Titulo>();

        novosFilmes.add(new Titulo("Soldado Invernal"));
        novosFilmes.add(new Titulo("Branca de Neve"));
        novosFilmes.add(new Titulo("Homem de Ferro")); //-> adicionamento de novo classe dentro do .add do ArrayList (isso é legal, low codes e parentes)

        System.out.println("antes: " + novosFilmes);

        Collections.sort(novosFilmes);

        System.out.println("depois: " + novosFilmes);

        //varias formas diferentes de fazer a mesma merda
    }
}
