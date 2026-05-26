public class Main {
  public static void main (String [] args){
    Desenvolvedor murilo = new Desenvolvedor("Murilo", 22, 111, "Java");

    System.out.println("Informaçẽos do Desenvolvedor: " + murilo.getNome() + murilo.getIdade() + murilo.getCpf() + murilo.getLinguagem());
  }
}
