package br.com.weg.api.controller;

import br.com.weg.api.assembler.FrequenciaAssembler;
import br.com.weg.api.model.input.FrequenciaInputDTO;
import br.com.weg.domain.model.Alunos;
import br.com.weg.domain.model.Frequencia;
import br.com.weg.api.model.FrequenciaDTO;
import br.com.weg.domain.repository.FrequenciaRepository;
import br.com.weg.domain.service.FrequenciaService;
import br.com.weg.domain.service.AlunosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("frequencia/{alunoId}")
public class FrequenciaController {

    FrequenciaService frequenciaService;
    FrequenciaAssembler frequenciaAssembler;
    FrequenciaRepository frequenciaRepository;
    AlunosService alunosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FrequenciaDTO registrar(@PathVariable Long alunoId, @Valid @RequestBody FrequenciaInputDTO frequenciaInputDTO){
        int restricao = 0;
        List<FrequenciaDTO> frequenciaDTOS = listar(alunoId);

        for(int i=0; i<frequenciaDTOS.size(); i++){
            if(frequenciaDTOS.get(i).getData().equals(frequenciaInputDTO.getData())){ restricao = 1;}
        }
        if(restricao == 0) {
            Frequencia frequenciaRegistrada = frequenciaService.registrar(alunoId, frequenciaInputDTO.getData(),
                    frequenciaInputDTO.getPresenca());
            return frequenciaAssembler.toModel(frequenciaRegistrada);
        }else{
            return null;
        }
    }

    @GetMapping
    public List<FrequenciaDTO> listar(@PathVariable Long alunoId){
        Alunos alunos = alunosService.buscar(alunoId);

        return frequenciaAssembler.toCollectionModel(alunos.getFrequencias());
    }

    @PutMapping("/{frequenciaId}")
    @ResponseStatus(HttpStatus.CREATED)
    public FrequenciaDTO editar(@PathVariable Long alunoId, @Valid @RequestBody FrequenciaInputDTO frequenciaInputDTO, @PathVariable Long frequenciaId){
        int restricao = 0;
        List<FrequenciaDTO> frequenciaDTOS = listar(alunoId);

        for(int i=0; i<frequenciaDTOS.size(); i++){
            if(frequenciaDTOS.get(i).getData().equals(frequenciaInputDTO.getData())){ restricao = 1;}
        }

        if(restricao == 0) {
            Frequencia novaFrequencia = frequenciaAssembler.toEntity(frequenciaInputDTO);
            ResponseEntity<Frequencia> frequenciaResponseEntity = frequenciaService.editar(frequenciaId, novaFrequencia);

            return frequenciaAssembler.toModel(frequenciaResponseEntity.getBody());
        }else{
            return null;
        }
    }

    @DeleteMapping("/{frequenciaId}")
    public ResponseEntity<FrequenciaDTO> deletarFrequencia(@PathVariable Long frequenciaId){
        if(!frequenciaRepository.existsById(frequenciaId)){
            return ResponseEntity.notFound().build();
        }
        frequenciaService.excluir(frequenciaId);

        return ResponseEntity.noContent().build();
    }
}
