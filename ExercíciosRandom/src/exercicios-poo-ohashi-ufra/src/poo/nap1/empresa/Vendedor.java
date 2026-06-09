package poo.nap1.empresa;

public class Vendedor extends Funcionario {
 public int comissao;
 @Override
 public int calcular_salario (){
  return salario + comissao; 
 }
}
