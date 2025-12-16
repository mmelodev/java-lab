package br.com.screenmatchspringjpa.repository;


import br.com.screenmatchspringjpa.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long>{
    Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);

    List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoImdbGreaterThanEqual(String atores, double avaliacao);
    /* Preciso entender mais como funciona o uso da linha acima
    No mais, eu uso 'titulo' pois se queremos apenas analisar o titulo por enquanto
    E ignorecase também, mas como apenas isso faz funcionar a parada toda ja que esse metodo é original do meu codigo?
    * */
}
