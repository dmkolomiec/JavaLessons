drop database if exists `library2`;
CREATE DATABASE `library2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci; 
use `library2`;

create table if not exists author
(
    authorId bigint auto_increment primary key,
    name      varchar(255) null,
    last_name varchar(255) null
) comment 'Авторы';

create table if not exists book
(
    bookId bigint auto_increment primary key,
    name   varchar(255) null
) comment 'Книги';

create table if not exists bookauthor
(
    relationId bigint auto_increment primary key,
    authorId   bigint not null,
    bookId     bigint not null,
    constraint bookauthor_fk1 foreign key (authorId) references author (authorId),
    constraint bookauthor_fk2 foreign key (bookId) references book (bookId) on update cascade on delete cascade
) comment 'Связи аторов и книг';

INSERT INTO author (authorId, name, last_name)  VALUES 
(1, 'Герберт', 'Шилдт'),
(2, 'Брюс', 'Еккєль'),
(3, 'Джошуа', 'Блох'),
(4, 'Гари', 'Корнелл');

INSERT INTO book (bookId, name) VALUES 
(1, 'Java 8. Полное руководство'),
(2, 'Java Руководство для начинающих'),
(3, 'Java. Библиотека профессионала, том 1'),
(4, 'Java. Библиотека профессионала, том 2'),
(5, 'Java Эффективное программирование');

INSERT INTO bookauthor(relationId, authorId, bookId) values
(1, 1, 1),
(2, 1, 2),
(3, 2, 3),
(4, 2, 4),
(5, 4, 4),
(6, 3, 5);

select b.*, a.*
from author a
join bookauthor ba on ba.authorId = a.authorId
join book b on b.bookId = ba.bookId
order by b.bookId;
