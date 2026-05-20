package modelos;

import records.UsuarioComApi;

public class Usuario {
    private String nome;
    private String nomeLogin;
    private String localizacao;
    private String bio;
    private String seguidores;

    public Usuario(String nome, String nomeLogin, String localizacao, String bio, String seguidores) {
        this.nome = nome;
        this.nomeLogin = nomeLogin;
        this.localizacao = localizacao;
        this.bio = bio;
        this.seguidores = seguidores;
    }

    public Usuario (UsuarioComApi meuUsuarioComApi){
        this.nome = meuUsuarioComApi.name();
        this.nomeLogin = meuUsuarioComApi.login();
        this.localizacao = meuUsuarioComApi.location();
        this.bio = meuUsuarioComApi.bio();
        this.seguidores = meuUsuarioComApi.followers();
    }

    public String getSeguidores() {
        return seguidores;
    }

    public String getBio() {
        return bio;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getNomeLogin() {
        return nomeLogin;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "\n(Nome: " + getNome() + '\n' +
                "Nome de Usuário: " + getNomeLogin() + '\n' +
                "Localização: " + getLocalizacao() + '\n' +
                "Bio: " + getBio() + '\n' +
                "Seguidores: " + getSeguidores() + ")\n";
    }
}
