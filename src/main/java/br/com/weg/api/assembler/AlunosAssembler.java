package br.com.weg.api.assembler;

import br.com.weg.api.model.AlunosDTO;
import br.com.weg.api.model.input.AlunosInputDTO;
import br.com.weg.domain.model.Alunos;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AlunosAssembler {

    private ModelMapper modelMapper;

    public AlunosDTO toModel(Alunos alunos) {
        return modelMapper.map(alunos, AlunosDTO.class);
    }

    public List<AlunosDTO> toCollectionModel(List<Alunos> entregases) {
        return entregases.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Alunos toEntity(AlunosInputDTO alunosInputDTO) {
        return modelMapper.map(alunosInputDTO, Alunos.class);
    }

    }
