package br.com.weg.api.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class AlunosDTO {

    long id;
    String nome;
    String email;
    String telefone;
    String turma;
    String situacao;
}
