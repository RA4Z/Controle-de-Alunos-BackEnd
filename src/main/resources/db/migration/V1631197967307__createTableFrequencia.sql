CREATE TABLE frequencia
(
    id            BIGINT NOT NULL auto_increment,
    alunos_id      BIGINT NOT NULL,
    data          VARCHAR(10) NOT NULL,
    presenca      INTEGER NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE frequencia
    ADD CONSTRAINT fk_frequencia_alunos FOREIGN KEY (alunos_id) REFERENCES alunos (id);