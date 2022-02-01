package br.com.weg.domain.repository;

import br.com.weg.domain.model.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Long> {

    @Query(value ="select * FROM alunos where alunos.id = (select alunos_id from frequencia where frequencia.id = ?1)", nativeQuery = true)
    List<Alunos> getAluno(Long idFrequencia);
}
