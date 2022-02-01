package br.com.weg.domain.service;

import br.com.weg.domain.model.Alunos;
import br.com.weg.domain.model.Frequencia;
import br.com.weg.domain.repository.AlunosRepository;
import br.com.weg.domain.repository.FrequenciaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
@AllArgsConstructor
public class FrequenciaService {

    FrequenciaRepository frequenciaRepository;
    AlunosService alunosService;
    AlunosRepository alunosRepository;

    @Transactional
    public Frequencia registrar(long alunoId, String data, int presenca){
        Alunos alunos = alunosService.buscar(alunoId);

        return alunos.adicionarFrequencia(data, presenca);
    }

    public ResponseEntity<Frequencia> editar(@Valid @PathVariable Long frequenciaId, @RequestBody Frequencia frequencia) {

        if(!frequenciaRepository.existsById(frequenciaId)){
            return ResponseEntity.notFound().build();
        }
        frequencia.setId(frequenciaId);
        frequencia.setAlunos(alunosRepository.getAluno(frequenciaId).get(0));
        frequencia = frequenciaRepository.save(frequencia);

        return ResponseEntity.ok(frequencia);
    }

    @Transactional
    public void excluir(Long frequenciaId){
        frequenciaRepository.deleteById(frequenciaId);
    }
}
