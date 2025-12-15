package br.com.rpgbasico.personagens;

public abstract class geral {
    //quais atributos que todos os personagens devem ter?

    private String nome;
    private int idade;
    private int xp;
    private String etnia;
    private String classe;
    private int fisico;
    private int mental;
    private int inteligencia;
    private int forca;
    private int carisma;
    private String sexo;
    private int pontosDeVida;
    private String motivacaoPessoal;
    private String backgroundPessoal;
    private String fraquezaPessoal;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getFisico() {
        return fisico;
    }

    public void setFisico(int fisico) {
        this.fisico = fisico;
    }

    public int getMental() {
        return mental;
    }

    public void setMental(int mental) {
        this.mental = mental;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public String getMotivacaoPessoal() {
        return motivacaoPessoal;
    }

    public void setMotivacaoPessoal(String motivacaoPessoal) {
        this.motivacaoPessoal = motivacaoPessoal;
    }

    public String getBackgroundPessoal() {
        return backgroundPessoal;
    }

    public void setBackgroundPessoal(String backgroundPessoal) {
        this.backgroundPessoal = backgroundPessoal;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public String getFraquezaPessoal() {
        return fraquezaPessoal;
    }

    public void setFraquezaPessoal(String fraquezaPessoal) {
        this.fraquezaPessoal = fraquezaPessoal;
    }

}
