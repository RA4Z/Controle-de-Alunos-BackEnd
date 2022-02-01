package br.com.weg.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import static lombok.AccessLevel.PRIVATE;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Getter
@Setter
@Entity
public class Alunos {

    @NotNull
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    long id;

    @NotBlank
    @Size(max = 60)
    String nome;

    @NotBlank
    @Email
    @Size(min = 5)
    String email;

    @NotBlank
    @Size(min = 8)
    String telefone;

    @NotBlank
    String turma;

    @NotBlank
    String situacao;

    @OneToMany(mappedBy = "alunos", cascade = CascadeType.ALL)
    private List<Frequencia> frequencias = new ArrayList<>();

    public Frequencia adicionarFrequencia(String data, int presenca){

        Frequencia frequencia = new Frequencia();

        frequencia.setData(data);
        frequencia.setPresenca(presenca);
        frequencia.setAlunos(this);

        this.getFrequencias().add(frequencia);

        return frequencia;
    }
}
