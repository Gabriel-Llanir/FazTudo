create table publicacoes(
    usuario_id bigint not null auto_increment,
    titulo varchar(100),
    descricao varchar(255),
    primary key(usuario_id, titulo),
    constraint fk_publicacoes_usuarios
        foreign key (usuario_id)
        references usuarios(id)
        on delete cascade
        on update cascade
);
