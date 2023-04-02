-- Задание 7. Используя MySQL Workbench создать пустую базу данных автомобилей. 
-- Заполнить таблицу данными (id(Autoincrement), марка, модель, объем двигателя, цена, макс. скорость).

use myDB;
DROP TABLE IF EXISTS cars;
CREATE TABLE cars (
  id smallint PRIMARY KEY AUTO_INCREMENT,
  Manufacturer VARCHAR(50) NOT NULL,
  model VARCHAR(50) NOT NULL,
  eng_volume smallint NOT NULL,
  price int NOT NULL,
  max_speed smallint  NOT NULL
);
ALTER TABLE cars
ADD INDEX cars_idx1 (Manufacturer ASC) VISIBLE;

-- Заполняем таблицу cars данными
INSERT INTO cars (Manufacturer, model, eng_volume, price, max_speed)
VALUES ('Toyota', 'Corolla', 1800, 20000, 180),
       ('Honda', 'Civic', 1500, 22000, 190),
       ('KIA', 'Sportage', 2000, 30000, 180),
       ('Renault', 'Duster', 1600, 18000, 170),
       ('Skoda', 'Octavia', 1400, 23000, 220),
       ('BMW', 'M5', 30000, 100000, 305),
       ('Mercedes-Benz', 'S-Class', 4000, 120000, 250),
       ('Audi', 'RS7', 4000, 130000, 280),
       ('Nissan', 'Qashqai', 1400, 30000, 190),
       ('Hyundai', 'Accent', 1400, 20000, 180);
--
select * from cars
order by 2;
