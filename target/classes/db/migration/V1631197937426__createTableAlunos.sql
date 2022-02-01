CREATE TABLE alunos(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null,
    telefone varchar(45) not null,
    turma varchar(10) not null,
    situacao varchar(45) not null,
    primary key (id)
);
INSERT INTO alunos
VALUES (null, "RAZ", "RAZ@gmail.com", "(47)999565738","C209","Regular"),
(null, "João", "jao@gmail.com", "(51)40028922","D101","Péssimo"),
(null, "Lívia", "livia@bo.com.br", "(47)988772255","B307","Avançado"),
(null, "Pedro", "pedro@hotmail.com", "(47)984256743","C204","Bom");