package poo.nap1;

import poo.nap1.empresa.Funcionario;
import poo.nap1.empresa.Vendedor;
import poo.nap1.transferencias.CartaoDeCredito;
import poo.nap1.transferencias.Debito;
import poo.nap1.transferencias.Pix;

public class Main {
  public static void main(String[] args) {
    Pix pix = new Pix();
    pix.realizarPagamento(150);
    CartaoDeCredito cartaoDeCredito = new CartaoDeCredito();
    cartaoDeCredito.realizarPagamento(30);
    Debito debito = new Debito();
    debito.realizarPagamento(40);
  
  }
}
