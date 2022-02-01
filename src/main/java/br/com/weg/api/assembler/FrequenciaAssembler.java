package br.com.weg.api.assembler;

import br.com.weg.api.model.input.FrequenciaInputDTO;
import br.com.weg.domain.model.Frequencia;
import br.com.weg.api.model.FrequenciaDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class FrequenciaAssembler {

    private ModelMapper modelMapper;

    public FrequenciaDTO toModel(Frequencia frequencia){
        return modelMapper.map(frequencia, FrequenciaDTO.class);
    }

    public List<FrequenciaDTO> toCollectionModel(List<Frequencia> frequencias){
        return frequencias.stream()
                .map((this::toModel))
                        .collect(Collectors.toList());
    }
    public Frequencia toEntity(FrequenciaInputDTO frequenciaInputDTO) {
        return modelMapper.map(frequenciaInputDTO, Frequencia.class);
    }

}
