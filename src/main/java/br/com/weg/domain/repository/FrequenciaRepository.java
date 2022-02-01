package br.com.weg.domain.repository;

import br.com.weg.domain.model.Frequencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FrequenciaRepository extends JpaRepository<Frequencia, Long> {
}
