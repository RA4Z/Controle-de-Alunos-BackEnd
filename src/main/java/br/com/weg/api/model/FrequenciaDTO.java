package br.com.weg.api.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class FrequenciaDTO {

    private long id;
    private String data;
    private int presenca;
}
