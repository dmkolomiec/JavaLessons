use myDB;
-- Задание 4. Из задания 3 таблицы 2 получить id сотрудников, зарплата которых больше 10000. 
SELECT e.employee_id, e.firstname, e.lastname, p.salary "Зарплатка"
FROM emp_position p 
inner join employee e on p.employee_id = e.employee_id
where p.salary > 10000;
--
update emp_exdata e 
set e.family_status = 'Холост'
where e.employee_id = 2;
-- Задание 5. Из задания 3 сотрудник по id 1 был не женат, женился изменить данные в третьей таблице о семейном положении. 
update emp_exdata d 
set d.family_status = 'Женат'
where d.employee_id = 2;
-- вывод результата
SELECT e.employee_id, e.firstname, e.lastname, d.family_status
FROM emp_exdata d
inner join mydb.employee e on d.employee_id = e.employee_id
where d.employee_id = 2;

