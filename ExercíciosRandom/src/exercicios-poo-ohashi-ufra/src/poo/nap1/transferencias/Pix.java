package poo.nap1.transferencias;

public class Pix implements Pagamento {
  @Override
  public void realizarPagamento(double valor){
    System.out.println("Pagamento de R$ " + valor + " realizar com PIX.");
  }
}
