/*
    Задание 5 
    Создайте триггер, который будет удалять записи со 2-й и 3-й таблиц перед удалением записей из таблиц сотрудников (1-й таблицы), чтобы не нарушить целостность данных.
    
    *При грамотной реализации в таком триггере нет необходимости, т.к. достаточно указать ON UPDATE/DELETE CASCADE для FK на соотв.таблицах
*/
DELIMITER //
SET autocommit = 1;
//
CREATE TRIGGER `person_BEFORE_DELETE` BEFORE DELETE ON `person` FOR EACH ROW BEGIN
	delete from  `myfunkdb`.`contact` c where c.personId = OLD.personId;
	delete from  `myfunkdb`.`employee` e where e.personId = OLD.personId;
END

//  -- Добавить тестовые записи
insert into person(fullName, phone)
values('Бен Ганн', '440001111103');
//
insert into contact (personId, birthDate, address, family)
values (@@IDENTITY, '1730-10-20', 'Бристоль', 'Single');

insert into employee (personId, salary, position)
values (@@IDENTITY, 20, 'Привратник в парке');

select p.*, c.*, e.*
from person p
left join contact c on c.personId = p.personId
left join employee e on e.personId = p.personId
where p.personId = @@IDENTITY;

// -- Удалить тестовую запись
delete from person where fullName = 'Бен Ганн';

//  -- проверить 
select p.*, c.*, e.*
from person p
left join contact c on c.personId = p.personId
left join employee e on e.personId = p.personId;
  union
select p.*, c.*, e.*
from person p
right join contact c on c.personId = p.personId
right join employee e on e.personId = p.personId;


