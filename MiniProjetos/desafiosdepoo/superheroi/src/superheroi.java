import br.com.superheroi.modelos.*;

public class superheroi {
    public static void main(String[] args) {
        var homemaranha = new HomemAranha();

        homemaranha.setEnergia(0);
        System.out.println(homemaranha.getEnergia());

        homemaranha.gastoenergia();
        System.out.println(homemaranha.getEnergia());

        homemaranha.gastoenergia();
        System.out.println(homemaranha.getEnergia());

        //agora só fazer visualização bonita de para cada super heroi, posso criar tipo um jogo de texto que o usuário digita para atacar e os pontos diminuem e aparecem na tela atualizados conforme cada ataque
    }
}
