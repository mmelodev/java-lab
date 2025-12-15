package br.com.rpgbasico.personagens;

public class elfo extends geral{
    private String subraca;
    private String idioma;
    private int qntdIdiomas;
    private int arco;
    private int adaga;
    private int armadura;

    public String getSubraca() {
        return subraca;
    }

    public void setSubraca(String subraca) {
        this.subraca = subraca;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getQntdIdiomas() {
        return qntdIdiomas;
    }

    public void setQntdIdiomas(int qntdIdiomas) {
        this.qntdIdiomas = qntdIdiomas;
    }

    public int getArco() {
        return arco;
    }

    public void setArco(int arco) {
        this.arco = arco;
    }

    public int getAdaga() {
        return adaga;
    }

    public void setAdaga(int adaga) {
        this.adaga = adaga;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    @Override
    public void setSexo(String sexo) {
        this.setSexo(sexo);
        System.out.println("\nApesar da sua escolha, os elfos não tem sexo definido.\n");
    }

    @Override
    public String getSexo() {
        return "Não tem sexo definido";
    }
}
