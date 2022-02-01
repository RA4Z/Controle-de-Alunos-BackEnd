package br.com.weg.api.controller;

import br.com.weg.api.assembler.AlunosAssembler;
import br.com.weg.api.model.AlunosDTO;
import br.com.weg.api.model.input.AlunosInputDTO;
import br.com.weg.domain.model.Alunos;
import br.com.weg.domain.service.AlunosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@SuppressWarnings("unused")
@AllArgsConstructor
@RestController
@RequestMapping("/alunos")
public class AlunosController {

    private AlunosService alunosService;
    private AlunosAssembler alunosAssembler;

    @GetMapping()
    public List<AlunosDTO> listar(){
        return alunosService.listar();
    }

    @GetMapping("/{alunoId}")
    public ResponseEntity<AlunosDTO> buscar(@PathVariable Long alunoId){
        return alunosService.pesquisa(alunoId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AlunosDTO cadastrar(@Valid @RequestBody AlunosInputDTO alunosInputDTO){
        Alunos novaAlunos = alunosAssembler.toEntity(alunosInputDTO);
        Alunos alunos = alunosService.cadastrar(novaAlunos);

        return alunosAssembler.toModel(alunos);
    }

    @PutMapping("/{alunoId}")
    @ResponseStatus(HttpStatus.CREATED)
    public AlunosDTO editar(@Valid @RequestBody AlunosInputDTO alunosInputDTO, @PathVariable Long alunoId){
        Alunos novaAlunos = alunosAssembler.toEntity(alunosInputDTO);
        ResponseEntity<Alunos> pessoaResponseEntity = alunosService.editar(alunoId, novaAlunos);

        return alunosAssembler.toModel(pessoaResponseEntity.getBody());
    }

    @DeleteMapping("/{alunoId}")
    public ResponseEntity<AlunosDTO> remover(@Valid @PathVariable Long alunoId) {

        alunosService.excluir(alunoId);

        return ResponseEntity.noContent().build();
    }

}