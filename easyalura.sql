drop database easyalura;

create database easyalura;

use easyalura;

create table cursos (
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    descricao varchar(500) not null,
    slug varchar(50) not null,
    carga_horaria int not null,
    data_criacao date not null,
    data_atualizacao date,
    primary key (id)
);

create table instrutores (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    descricao varchar(500) not null,
    linkedin_url varchar(100),
    primary key (id)
);

-- alter table cursos add column instrutor_id bigint not null;
-- alter table cursos add foreign key (instrutor_id) references instrutores(id);

create table cursos_instrutores (
       cursos_id bigint not null,
        instrutores_id bigint not null
);

alter table cursos_instrutores 
       add constraint cursos_instrutores_instrutores 
       foreign key (instrutores_id) 
       references instrutores (id);
    
    alter table cursos_instrutores 
       add constraint cursos_instrutores_cursos 
       foreign key (cursos_id) 
       references cursos (id);

-- DDL (Data Definition Language): create, alter, drop table e create, drop database

select * from instrutores;
select * from cursos;
select * from cursos_instrutores;

-- DML (Data Manipulation Language): insert, update, delete, select