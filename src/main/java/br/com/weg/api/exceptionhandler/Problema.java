package br.com.weg.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class Problema {

    Integer status;
    LocalDateTime dataHora;
    String titulo;
    List<Campo> campos;

    @AllArgsConstructor
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Campo{
        final String nome;
        final String mensagem;
    }
}
