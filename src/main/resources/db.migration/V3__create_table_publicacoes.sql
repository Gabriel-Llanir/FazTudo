create table publicacoes(
    usuario_id bigint not null auto_increment,
    titulo varchar(100) not null,
    descricao varchar(255) not null,
    primary key(usuario_id, titulo),
    constraint fk_publicacoes_usuarios
        foreign key (usuario_id)
        references usuarios(id)
        on delete cascade
        on update cascade
);
