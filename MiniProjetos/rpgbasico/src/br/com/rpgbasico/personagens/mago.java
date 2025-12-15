package br.com.rpgbasico.personagens;

import br.com.rpgbasico.acoes.acoeselfo;
import br.com.rpgbasico.acoes.*;

public class mago extends geral implements acoesmago {
    private boolean senioridade;
    private String escolaArcana;
    private String habilidadePrimaria;
    private String habilidadeSecundaria;

    public boolean getSenioridade() {
        return senioridade;
    }

    public void setSenioridade(boolean senioridade) {
        this.senioridade = senioridade;
    }

    public String getEscolaArcana() {
        return escolaArcana;
    }

    public void setEscolaArcana(String escolaArcana) {
        this.escolaArcana = escolaArcana;
    }

    public String getHabilidadePrimaria() {
        return habilidadePrimaria;
    }

    public void setHabilidadePrimaria(String habilidadePrimaria) {
        this.habilidadePrimaria = habilidadePrimaria;
    }

    public String getHabilidadeSecundaria() {
        return habilidadeSecundaria;
    }

    public void setHabilidadeSecundaria(String habilidadeSecundaria) {
        this.habilidadeSecundaria = habilidadeSecundaria;
    }

    @Override
    public void lancarmagia() {
        //minha ideia é ao lançar magia eu conseguir diminuir o Xp com -1 número. Como implementar isso aqui. Não sei se estou usando as interfaces da maneira certa para esse contexto.
    }
}
