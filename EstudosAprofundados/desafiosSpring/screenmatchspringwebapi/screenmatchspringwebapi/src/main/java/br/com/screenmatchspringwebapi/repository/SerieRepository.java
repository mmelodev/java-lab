package br.com.screenmatchspringwebapi.repository;


import br.com.screenmatchspringwebapi.model.Categoria;
import br.com.screenmatchspringwebapi.model.Episodio;
import br.com.screenmatchspringwebapi.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long>{

    Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);

    List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoImdbGreaterThanEqual(String atores, double avaliacao);

    List<Serie> findTop5ByOrderByAvaliacaoImdbDesc();

    List<Serie> findByCategoria(Categoria categoria);

    //consultaTemporadaAvaliacao - uso com derived queries
    List<Serie> findByTotalTemporadaLessThanEqualAndAvaliacaoImdbGreaterThanEqualOrderByAvaliacaoImdbDesc(Integer totalTemporada, Double avaliacaoImdb);

    //consultaTemporadaAvaliacao - uso com JPQL
    @Query("select s from Serie s where s.totalTemporada <= :totalTemporada and s.avaliacaoImdb >= :avaliacaoImdb order by s.avaliacaoImdb desc")
    List<Serie> consultaTemporadaAvaliacao(Integer totalTemporada, Double avaliacaoImdb);

    //Podemos usar uma lista<Episodio> mas na query precisamos usar o FROM Serie pois estamos usando um repository para serie especificamente e existe esse atributo tipo List<> dentro de Serie
    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE e.tituloEpisodio ILIKE %:trechoEpisodio%")
    List<Episodio> consultaEpisodioPorTrecho(String trechoEpisodio);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie ORDER BY e.avaliacaoEpisodio DESC LIMIT 5")
    List<Episodio> consultaTopEpisodios(Serie serie);

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie AND YEAR(e.dataDeLancamento) >= :anoLancamento")
    List<Episodio> consultaEpisodiosPorSerieEData(Serie serie, int anoLancamento);

    @Query("SELECT s FROM Serie s JOIN s.episodios e GROUP BY s ORDER BY MAX(e.dataDeLancamento) DESC LIMIT 5")
    List<Serie> listarLancamentos();

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s.id = :id AND e.numeroTemporada = :numero")
    List<Episodio> temporadaPorNumero(Long id, Long numero);
}
