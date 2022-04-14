drop table if exists book cascade;
drop table if exists author;

create table book
(
    id        bigint not null auto_increment primary key,

    publisher varchar(255),
    title     varchar(255),
    author_id BIGINT
) engine = InnoDB;

create table author
(
    id         bigint not null auto_increment primary key,
    first_name varchar(255),
    last_name  varchar(255)
) engine = InnoDB;

insert into author (first_name, last_name)
values ('Craig', 'Walls');



insert into author (first_name, last_name)
values ('Eric', 'Evans');



insert into author (first_name, last_name)
values ('Robert', 'Martin');

insert into book (publisher, title, author_id)
values ('Addison Wesley',
        'Clean Code', (select id from author where first_name = 'Robert' and last_name = 'Martin'));