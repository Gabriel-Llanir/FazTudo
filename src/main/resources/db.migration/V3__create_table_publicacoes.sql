create table publicacoes(

    id bigint not null auto_increment,
    usuario_id bigint not null,
    usuId bigint not null,
    titulo varchar(100),
    descricao varchar(300),
    primary key(id)
);
