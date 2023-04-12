/*
Задание 4 
	Создайте представления для таких заданий: 
*/
use `myjoinsdb`;

DROP VIEW IF EXISTS task4_part1;
DROP VIEW IF EXISTS task4_part2;
DROP VIEW IF EXISTS task4_part3;

-- 1. Необходимо узнать контактные данные сотрудников (номера телефонов, место жительства). 
create view task4_part1 as
select p.*, c.address
from person p
join contact c on c.personId = p.personId;

-- 2. Необходимо узнать информацию о дате рождения всех не женатых сотрудников и номера телефонов этих сотрудников. 
create view task4_part2 as
select p.*, c.birthDate
from person p
join contact c on c.personId = p.personId AND c.family != 'Married';

-- 3. Необходимо узнать информацию о дате рождения всех сотрудников с должностью менеджер и номера телефонов этих сотрудников. 
create view task4_part3 as
select p.*,  c.birthDate, e.position
from person p
join employee e on e.personId = p.personId AND e.position = 'Manager'
join contact c on c.personId = p.personId;
