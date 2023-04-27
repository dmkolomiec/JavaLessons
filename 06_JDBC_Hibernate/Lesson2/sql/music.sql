/* 5. Звукозапись. Определить иерархию музыкальных композиций. 
		1. Записать на диск сборку. 
        2. Подсчитать продолжительность. 
        3. Провести перестановку композиций диска на основе принадлежности к стилю. 
        4. Найти композицию, соответствующую заданному диапазону длины треков.
*/
/************
*************/
drop schema if exists music;
create schema music DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

drop table if exists genre;

create table genre (
	genreId int auto_increment primary key,
	descr varchar(30) unique
);

insert into genre (genreId, descr) values
( 1, 'Art (classical)'),
( 2, 'Avant-garde and experimental'),
( 3, 'Blues'),
( 4, 'Country'),
( 5, 'Easy listening'),
( 6, 'Electronic'),
( 7, 'Contemporary folk'),
( 8, 'Hip hop'),
( 9, 'Jazz'),
(10, 'Pop'),
(11, 'R&B and soul'),
(12, 'Rock'),
(13, 'Metal'),
(14, 'Punk'),
(15, 'Regional');

select * from genre;

/************
*************/
drop table if exists author;

create table author (
	authorId int auto_increment primary key,
	fullName varchar(30) unique
);

insert into author (authorId, fullName) values
( 1, 'Kim Petras'),
( 2, 'Ed Sheeran'),
( 3, 'Bree Runway'),
( 4, 'The Kid LAROI'),
( 5, 'Peso Pluma'),
( 6, 'Florence + The Machine'),
( 7, 'redveil'),
( 8, 'Moneybagg Yo'),
( 9, 'Iann Dior'),
(10, 'Foo Fighters');

select * from author;
/************
*************/
drop table if exists track;

create table track(
	trackId int auto_increment primary key,
	trackName 	varchar(30),
    authorId 	int not null,
    genreId 	int not null,
    duration 	time comment 'Длительность чч.мм.сс',
    
    constraint track_fk1 foreign key (genreid) references genre(genreid) on delete no action on update no action,
    constraint track_fk2 foreign key (authorid) references author(authorid) on delete no action on update no action
);

insert into track (trackId, trackName, authorId, genreId, duration) values
( 1,'Alone (feat. Nicki Minaj)',	1,10,  '00:03:06'),
( 2,'Boat',						 	2,10,	'00:03:16'),
( 3,'Be The One',					3,11,	'00:03:19'),
( 4,'WHERE DOES YOUR SPIRIT GO?',	4, 8,	'00:03:23'),
( 5,'Rosa Pastel', 				 	5,15,	'00:03:29'),
( 6,'Mermaids', 					6,10,	'00:04:36'),
( 7,'captain',						7, 8,	'00:03:28'),
( 8,'Motion God', 					8, 8,	'00:02:29'),
( 9,'start again',					9, 8,	'00:02:52'),
(10,'Rescued',						10,12,	'00:04:20');
select * from track;

select t.trackId, t.trackName, t.duration, a.fullName, g.descr
from track t
inner join author a on a.authorId = t.authorID
inner join genre g on g.genreId = t.genreId;

drop table if exists album;

create table album(
	trackId int not null,
    trackNumber int unique not null,
    constraint album_fk1 foreign key (trackId) references track(trackId) on delete no action on update no action
);

insert into album (trackId, trackNumber)
select t.trackId, row_Number() over() rn
--		t.trackName, t.duration,
--        time(sum(t.duration) over ()) AllDuration
from track t
inner join genre g on g.genreId = t.genreId AND g.descr = 'Hip hop';

select * from album a;
select a.*, t.trackName, t.duration, au.fullName, g.descr
from album a
join track t on t.trackId = a.trackId
join genre g on g.genreId = t.genreId
join author au on au.authorId = t.authorId;

