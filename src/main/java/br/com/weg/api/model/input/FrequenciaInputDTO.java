package br.com.weg.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FrequenciaInputDTO {

    @NotBlank
    private String data;

    @NotNull
    private int presenca;
}
