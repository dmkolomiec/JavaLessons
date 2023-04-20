/*
  Задание 4 
  Выполните ряд записей вставки в виде транзакции в хранимой процедуре. Если такой сотрудник имеется откатите базу данных обратно. 
*/

USE `myfunkdb`;
DROP procedure IF EXISTS `myfunkdb`.`addPerson`;

DELIMITER //

CREATE PROCEDURE `addPerson`(personid_ int, FullName_ varchar(45), phone varchar(12))
    READS SQL DATA
	MODIFIES SQL DATA
    COMMENT 'Вставка субъекта в таблицу person'
BEGIN

	declare errMsg varchar(100);
    set errMsg = concat('В таблице person уже имеется субъект именем \'', FullName_, '\'');

	START TRANSACTION;

	insert into person (personId, fullName, phone) values(personid_ , FullName_ , phone);

    -- При грамотной реализации правильнее добавить уникальный индекс для person.fullName или проверять наличие ПЕРЕД вставкой, а не ПОСЛЕ.
    -- Но сделаем тупо, как треюуется в задании.
    if exists (select 1 from person p where p.personId != personId_ AND p.FullName = FullName_ ) then
        rollback;
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = errMsg, MYSQL_ERRNO = 20001;
	else
		COMMIT;
	end if;
    
END

//
DELIMITER ;
;

SET autocommit = 0;
SET GLOBAL TRANSACTION ISOLATION LEVEL SERIALIZABLE;

-- На вс.случай удалим
delete from person where personId > 4;
commit;
SELECT * FROM person;

call addPerson(5, 'Джон Рик'  , '134222211100');  -- № телефона д.б. уникальный

SELECT * FROM person;

-- не должно добавиться из-за дублирования PK
call addPerson(5, 'Джон Рик-2', '134222211101');

-- не должно добавиться из-за польз.проверки
call addPerson(6, 'Джон Рик'  , '134222211102');

SELECT * FROM person;
