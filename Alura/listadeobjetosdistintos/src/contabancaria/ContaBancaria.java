package contabancaria;

public class ContaBancaria {
    private static int proximonumero = 1001;
    private int numerodaconta;
    private double saldo;

    public ContaBancaria(double saldo){
        this.saldo = saldo;
        numerodaconta += proximonumero++;
    }

    public int getNumerodaconta() {
        return numerodaconta;
    }

    public double getSaldo() {
        return saldo;
    }
}
