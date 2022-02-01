package br.com.weg.domain.service;

import br.com.weg.api.assembler.AlunosAssembler;
import br.com.weg.api.model.AlunosDTO;
import br.com.weg.domain.exception.NegocioException;
import br.com.weg.domain.model.Alunos;
import br.com.weg.domain.repository.AlunosRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Service
public class AlunosService {

    private AlunosRepository alunosRepository;
    private AlunosAssembler alunosAssembler;

    @Transactional
    public Alunos cadastrar(Alunos alunos){
        return alunosRepository.save(alunos);
    }

    @Transactional
    public ResponseEntity<Object> excluir(Long pessoaId){

        if(!alunosRepository.existsById(pessoaId)){
            return ResponseEntity.notFound().build();
        }

        alunosRepository.deleteById(pessoaId);
        return ResponseEntity.ok(pessoaId);
    }

    public List<AlunosDTO> listar(){
        return alunosAssembler.toCollectionModel(alunosRepository.findAll());
    }

    public ResponseEntity<AlunosDTO> pesquisa(Long pessoaId){
        return alunosRepository.findById(pessoaId).map(entrega ->
                ResponseEntity.ok(alunosAssembler.toModel(entrega))
        ).orElse(ResponseEntity.notFound().build());
    }
    public Alunos buscar(Long alunoId){
        return alunosRepository.findById(alunoId).orElseThrow(() -> new NegocioException("Aluno não encontrado."));
    }

    public ResponseEntity<Alunos> editar(@Valid @PathVariable Long pessoaId, @RequestBody Alunos alunos) {

        if(!alunosRepository.existsById(pessoaId)){
            return ResponseEntity.notFound().build();
        }
        alunos.setId(pessoaId);
        alunos = alunosRepository.save(alunos);

        return ResponseEntity.ok(alunos);
    }
}