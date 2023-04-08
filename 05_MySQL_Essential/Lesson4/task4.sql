/*
	Задание 4 
	Сделайте выборку при помощи JOIN’s для таких заданий: 
*/
-- 1) Получите контактные данные сотрудников (номера телефонов, место жительства). 
select p.*, c.birthDate, c.address, c.family
from person p
inner join contact c on c.personId = p.personId;

-- 2) Получите информацию о дате рождения всех холостых сотрудников и их номера. 
select p.*, c.birthDate
from person p
inner join contact c on c.personId = p.personId and c.family = 'Single';

-- 3) Получите информацию обо всех менеджерах компании: дату рождения и номер телефона. 
select p.*, c.birthDate
from person p
inner join employee e on e.personId = p.personId and e.position = 'Manager'
inner join contact c on c.personId = p.personId;

