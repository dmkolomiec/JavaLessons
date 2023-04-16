/*
 Задание 4 
Создайте функции / процедуры для таких заданий:
*/
delimiter | 

use MyFunkDB; 
|
drop function if exists `MyFunkDB`.`getPersonAddress`; 
|
CREATE FUNCTION `MyFunkDB`.`getPersonAddress`(PersonId int) RETURNS varchar(45) CHARSET utf8mb4
    READS SQL DATA
BEGIN
	DECLARE address varchar(45);
    
    select c.address
    into address
    from `MyFunkDB`.`contact` c
    where c.PersonId = PersonId;
   
    SET address = IFNULL(address, '?');
 
	RETURN address;
END;
|
drop function if exists `MyFunkDB`.`getPersonBirthDate`; 
|
CREATE FUNCTION `MyFunkDB`.`getPersonBirthDate`(PersonId int) RETURNS varchar(45) CHARSET utf8mb4
    READS SQL DATA
BEGIN
	DECLARE birthdate date;
    
    select c.birthdate
    into birthdate
    from `MyFunkDB`.`contact` c
    where c.PersonId = PersonId;
   
    SET birthdate = IFNULL(birthdate, DATE('1-1-1'));
 
	RETURN birthdate;
END;
|
-- 1) Требуется узнать контактные данные сотрудников (номера телефонов, место жительства).
-- v1 - select в процедуре
drop PROCEDURE if exists `Task4_1v1`
|
CREATE PROCEDURE `Task4_1v1`()
    READS SQL DATA
BEGIN
	SELECT 
        p.personId AS personId,
        p.fullName AS fullName,
        p.phone AS Телефон,
        GETPERSONADDRESS(p.personId) AS Адреса
    FROM
        `myFunkDB`.`person` p
    ORDER BY p.personId;

END;
|
-- Пример вызова Task4_1v1
call myfunkdb.Task4_1v1();
|
-- 1) Требуется узнать контактные данные сотрудников (номера телефонов, место жительства).
-- v2 - Процедура по одному клиенту
drop PROCEDURE if exists `MyFunkDB`.`Task4_1v2`;
|
CREATE PROCEDURE `MyFunkDB`.`Task4_1v2`(in personId_ int, out Phone_ varchar(12), out Address_ varchar(45))
    READS SQL DATA
BEGIN

	select p.phone
    into Phone_
    FROM `myFunkDB`.`person` p
    where p.PersonId = PersonId_;
    SET phone_ = IFNULL(phone_, '?');
    
    select c.address
    into address_
    from `myfunkdb`.`contact` c
    where c.PersonId = PersonId_;
    SET address_ = IFNULL(address_, '?');

END;
|
-- Пример вызова Task4_1v2
set @Phone_ = '0';
set @Address_ = '0';
call myfunkdb.Task4_1v2(4, @Phone_, @Address_);
select @Phone_, @Address_;
|
-- 2) Требуется узнать информацию о дате рождения всех не женатых сотрудников и номера телефонов этих сотрудников.
drop PROCEDURE if exists `MyFunkDB`.`Task4_2`
|
CREATE  PROCEDURE `MyFunkDB`.`Task4_2`()
    READS SQL DATA
BEGIN

	select p.*, c.birthDate "Дата нар.", c.family "Сім.стан"
	from `MyFunkDB`.`person` p
	join contact c on c.personId = p.personId AND c.Family != 'Married';
END;
|
-- Пример вызова
call Task4_2();
|
-- 3) Требуется узнать информацию о дате рождения всех сотрудников с должностью менеджер и номера телефонов этих сотрудников.
drop PROCEDURE if exists `MyFunkDB`.`Task4_3`
|
CREATE PROCEDURE `MyFunkDB`.`Task4_3`()
    READS SQL DATA
BEGIN
	select p.*, getPersonBirthDate(p.PersonId) "Дата нар.", e.position "Посада"
	from `MyFunkDB`.`person` p
	join employee e on e.personId = p.personId AND e.position = 'Manager';
END
|
call Task4_3();
