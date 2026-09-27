create table proprietario (
    id bigint not null auto_increment,
    nome varchar(200) not null,
    telefone varchar(20) not null,
    email varchar (200) not null,
    primary key (id)
);

alter table proprietario
add constraint uk_proprietario unique (email);