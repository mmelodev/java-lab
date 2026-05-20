package poo.array;

public class Animais {
    private String animal;
    private int idade;
    private Boolean selvagem;

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Boolean getSelvagem() {
        return selvagem;
    }

    public void setSelvagem(Boolean selvagem) {
        this.selvagem = selvagem;
    }

    @Override
    public String toString() {
        return "Animal: " + animal + '\n' +
                "Idade: " + idade + " anos \n" +
                "É Selvagem? " + selvagem + "\n";
    }
}
