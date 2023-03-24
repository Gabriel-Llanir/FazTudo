create table prestadores(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    senha varchar(100) not null,
    cpf varchar(14) not null unique,
    idade Integer(2) not null,
    status tinyint not null,
    ativo tinyint not null,
    primary key(id)
);
