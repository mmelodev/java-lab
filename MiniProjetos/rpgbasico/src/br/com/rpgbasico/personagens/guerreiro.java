package br.com.rpgbasico.personagens;

public class guerreiro extends geral{
    private String arquetipo;
    private int armadura;
    private String tipoDeArma;
    private int arma;
    private int escudo;
    private int xpEscudo;

    public String getArquetipo() {
        return arquetipo;
    }

    public void setArquetipo(String arquetipo) {
        this.arquetipo = arquetipo;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public String getTipoDeArma() {
        return tipoDeArma;
    }

    public void setTipoDeArma(String tipoDeArma) {
        this.tipoDeArma = tipoDeArma;
    }

    public int getArma() {
        return arma;
    }

    public void setArma(int arma) {
        this.arma = arma;
    }

    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    public int getXpEscudo() {
        return xpEscudo;
    }

    public void setXpEscudo(int xpEscudo) {
        this.xpEscudo = xpEscudo;
    }
}
