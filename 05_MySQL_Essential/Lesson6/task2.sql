/*
  Задание 2 
  Зайдите в базу данных “MyJoinsDB”, под созданным в предыдущем уроке пользователем. 
  Проанализируйте, какие типы индексов заданы на созданных в предыдущем домашнем задании таблицах. 
*/
select iss.*
from information_schema.statistics iss
where lower(iss.table_schema) = 'shopdb'
order by iss.table_name, iss.index_name, iss.seq_in_index;

-- Error Code: 1235. This version of MySQL doesn't yet support '<window function>(DISTINCT ..)'
