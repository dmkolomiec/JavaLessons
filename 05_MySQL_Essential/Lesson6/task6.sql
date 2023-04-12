/* Задание 6
   Используя базу данных ShopDB и страницу Customers 
   (удалите таблицу, если есть и создайте заново первый раз без первичного ключа затем – с первичным) 
   и затем добавьте индексы и проанализируйте выборку данных
*/
use `ShopDB`;

alter table orders DROP CONSTRAINT FK_Orders_Customers;

-- удалите таблицу, если есть
drop table if exists customers;

-- и создайте заново первый раз без первичного ключа
CREATE TABLE `customers` (
  `CustomerNo` int NOT NULL, -- AUTO_INCREMENT,
  `FName` varchar(15)  NOT NULL,
  `LName` varchar(15) NOT NULL,
  `MName` varchar(15)  DEFAULT NULL,
  `Address1` varchar(50)  NOT NULL,
  `Address2` varchar(50)  DEFAULT NULL,
  `City` char(10)  NOT NULL,
  `Phone` char(12) NOT NULL,
  `DateInSystem` date DEFAULT NULL -- ,
--  PRIMARY KEY (`CustomerNo`)
);

drop table if exists customers;

-- затем – с первичным
CREATE TABLE `customers` (
  `CustomerNo` int NOT NULL AUTO_INCREMENT,
  `FName` varchar(15)  NOT NULL,
  `LName` varchar(15) NOT NULL,
  `MName` varchar(15)  DEFAULT NULL,
  `Address1` varchar(50)  NOT NULL,
  `Address2` varchar(50)  DEFAULT NULL,
  `City` char(10)  NOT NULL,
  `Phone` char(12) NOT NULL,
  `DateInSystem` date DEFAULT NULL,
  PRIMARY KEY (`CustomerNo`)
);

--  и затем добавьте индексы
alter table customers 
add index customers_idx1(LName),
add index customers_idx2(Address1),
add index customers_idx3(City),
add unique index customers_idx4(Phone);

INSERT INTO `customers` VALUES 
(1,'Анатолий','Круковский','Петрович','Лужная 15',NULL,'Харьков','(092)3212211','2009-11-20'),
(2,'Виктор','Дурнев','Викторович','Зелинская 10',NULL,'Киев','(067)4242132','2009-11-20'),
(3,'Зигмунд','Унакий','федорович','Дихтяревская 5',NULL,'Киев','(092)7612343','2009-11-20'),
(4,'Виталий','Левченко','Викторович','Глущенка 5','Драйзера 12','Киев','(053)3456788','2009-11-20'),
(5,'Олег','Выжлецов','Евстафьевич','Киевская 3','Одесская 8','Чернигов','(044)2134212','2009-11-20');

alter table orders 
add CONSTRAINT `FK_Orders_Customers` FOREIGN KEY (`CustomerNo`) REFERENCES `customers` (`CustomerNo`) ON DELETE SET NULL ON UPDATE CASCADE;

--  ...и проанализируйте выборку данных.
select c.* from customers c order by c.LName;
select c.* from customers c order by c.Address1;
select c.* from customers c order by c.City;
select c.* from customers c order by c.Phone;
