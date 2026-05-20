import br.com.zoologico.modelo.*;

public class listadeanimais {
    public static void main(String[] args) {
        var elefante = new Elefante();
        elefante.setNome("João");
        elefante.setIdade(33);
        elefante.setEspecie("Elefante");
        elefante.setPeso(410);

        var leao = new Leao();
        leao.setNome("Simba");
        leao.setIdade(21);
        leao.setEspecie("Leão");
        leao.setPeso(100);

        var passaro = new Passaro();
        passaro.setNome("Bemtevi");
        passaro.setIdade(5);
        passaro.setEspecie("bem-te-vi");
        passaro.setPeso(2);

        System.out.println("\n***************************\n" +
                "     Tabela de Animais     \n" +
                "***************************\n" +
                "Animal 01: \n" +
                "Nome: " + elefante.getNome() +
                "\nIdade: " + elefante.getIdade() +
                "\nEspecie: " + elefante.getEspecie() +
                "\nPeso (kg): " + elefante.getPeso() +
                "\nSom: " + elefante.fazersom() +
                "\nMovimentação: " + elefante.movimentacao() +
                "\nHabitat: " + elefante.habitat() +
                "\n***************************\n" +
                "Animal 02: \n" +
                "Nome: " + leao.getNome() +
                "\nIdade: " + leao.getIdade() +
                "\nEspecie: " + leao.getEspecie() +
                "\nPeso (kg): " + leao.getPeso() +
                "\nSom: " + leao.fazersom() +
                "\nMovimentação: " + leao.movimentacao() +
                "\nHabitat: " + leao.habitat() +
                "\n***************************\n" +
                "Animal 03: \n" +
                "Nome: " + passaro.getNome() +
                "\nIdade: " + passaro.getIdade() +
                "\nEspecie: " + passaro.getEspecie() +
                "\nPeso (kg): " + passaro.getPeso() +
                "\nSom: " + passaro.fazersom() +
                "\nMovimentação: " + passaro.movimentacao() +
                "\nHabitat: " + passaro.habitat() +
                "\n***************************\n");

    }
}
