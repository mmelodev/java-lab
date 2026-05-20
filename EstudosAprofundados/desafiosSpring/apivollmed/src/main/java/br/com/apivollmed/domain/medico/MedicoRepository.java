package br.com.apivollmed.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
             select m from Medico m
                 where
             m.ativo = true
                 and
             m.especialidade = :especialidade
                 and
             m.id not in
                 (
                 select c.medico.id from Consulta c\s
                 where
                 c.data = :data
                 )
                 order by rand()
            """)
        //sintaxe JPQL - Java Persistence Query Language
    Page<Medico> escolherMedicoAleatorioPorData(Especialidade especialidade, LocalDateTime data, Pageable pageable);

    @Query("select m.ativo from Medico m where m.id = :id")
    boolean findAtivoById(Long id);

    boolean existsById(Long id);
}
