/*
   Задание 5
Используя базу данных carsshop создайте функцию для нахождения минимального возраста клиента, затем сделайте выборку всех машин, которые он купил.
*/
DELIMITER |
use carsshop; |
drop function if exists `carsshop`.`GetMinAgeClientId`;
|
-- Функция возвращает ID клиента с минимальным возрастом
CREATE FUNCTION `carsshop`.`GetMinAgeClientId`() RETURNS int
    READS SQL DATA
BEGIN
	declare ClientId int;
    
	with s1 as (
		SELECT c.id, c.age, min(c.age) over() MinAge
		FROM `carsshop`.clients c
    )
	select s1.id 
    into ClientId
	from s1
	where age = minAge;
    
    set clientID = ifnull(clientID, 0);

RETURN clientId;
END
|
-- Пример вызова
SELECT 
	cl.name AS "Клієнт",
	cl.age AS "Вік",
	m.mark AS "Марка",
	c.model AS "Модель",
	c.price AS "Ціна"
FROM
	(((`carsshop`.orders o
	JOIN `carsshop`.clients cl ON ((cl.id = o.client_id)))
	JOIN `carsshop`.cars c ON ((c.id = o.car_id)))
	JOIN `carsshop`.marks m ON ((m.id = c.mark_id)))
WHERE
	(o.client_id = GETMINAGECLIENTID());
        
        