package br.com.weg.api.model.input;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class AlunosInputDTO {

    @NotBlank
    String nome;

    @NotBlank
    String email;

    @NotBlank
    String telefone;

    @NotBlank
    String turma;

    @NotBlank
    String situacao;

}
