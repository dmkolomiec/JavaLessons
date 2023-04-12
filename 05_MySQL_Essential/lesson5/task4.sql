/* Задание 4. 
Сделайте выборку при помощи вложенных запросов для таких заданий: 
	1) Получите контактные данные сотрудников (номера телефонов, место жительства). 
	2) Получите информацию о дате рождения всех холостых сотрудников и их номера. 
	3) Получите информацию обо всех менеджерах компании: дату рождения и номер телефона. 
*/
-- 	1) Получите контактные данные сотрудников (номера телефонов, место жительства). 
select p.*, (select c.address from contact c where c.personId = p.personId) "Адреса"
from person p;

-- 2) Получите информацию о дате рождения всех холостых сотрудников и их номера. 
select p.*, (select c.birthDate from contact c where c.personId = p.personId) "Дата народження",
            (select c.family from contact c where c.personId = p.personId) "Сім.стан"
from person p
 where p.personId in (select c.personId from contact c where c.family = 'Single' );

-- 3) Получите информацию обо всех менеджерах компании: дату рождения и номер телефона. 
select p.*, (select c.birthDate from contact c where c.personId = p.personId) "Дата народження",
			(select e.position from employee e where e.personId = p.personId) "Посада"

from person p
 where p.personId in (select e.personId from employee e where e.position = 'Manager' );

