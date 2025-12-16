package br.com.screenmatchspringjpa.model;

import br.com.screenmatchspringjpa.services.ConsultaMyMemory;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name = "series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;
    private Double avaliacaoImdb;
    private Integer totalTemporada;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    //esse enumerated vai ajudar a não criar inconsistencias na hora de ordenar as categorias, existem outras maneiras de usar esse enumerated
    @Column(length = 500)
    private String descricao;
    private String atores;
    private String poster;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //para que ao atualizar dar update na série os episodios também sejam adicionados no banco
    List<Episodio> episodios = new ArrayList<>();

    public Serie(DadosSerie dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.totalTemporada = dadosSerie.totalTemporada();
        this.avaliacaoImdb = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacaoImdb())).orElse(0);
        this.categoria = Categoria.fromString(dadosSerie.categoria().split(",")[0].trim());
        this.descricao = ConsultaMyMemory.obterTraducao(dadosSerie.descricao()).trim();
        this.atores = dadosSerie.atores().split(",")[0].trim();
        this.poster = dadosSerie.poster();
    }

    public Serie() {
    //O construtor sem argumentos não precisa fazer nada, ele só precisa existir para que o JPA possa usá-lo.
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        episodios.forEach(e -> e.setSerie(this));
        this.episodios = episodios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getAvaliacaoImdb() {
        return avaliacaoImdb;
    }

    public void setAvaliacaoImdb(Double avaliacaoImdb) {
        this.avaliacaoImdb = avaliacaoImdb;
    }

    public Integer getTotalTemporada() {
        return totalTemporada;
    }

    public void setTotalTemporada(Integer totalTemporada) {
        this.totalTemporada = totalTemporada;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "Categoria: " + categoria + "\n" +
                "Titulo: " + titulo + '\n' +
                "Sinopse: " + descricao + "\n" +
                "Atores: " + atores + "\n" +
                "Avaliação: " + avaliacaoImdb + "\n" +
                "Nº Temporadas: " + totalTemporada + "\n" +
                "Episodios: " + episodios + "\n" +
                "Poster: " + poster + "\n";
    }
}
