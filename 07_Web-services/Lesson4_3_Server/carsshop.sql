drop database carsshop; 

create database carsshop; 

use carsshop; 


create table marks(
   id int not null auto_increment primary key,
   mark varchar(20) unique
); 

create table cars(
  id INT NOT NULL auto_increment primary key,
  mark_id INT NOT NULL,
  model varchar(20) NOT NULL,
  price INT NOT NULL,
  foreign key(mark_id) references marks(id)
); 

CREATE TABLE clients
(
	 id INT AUTO_INCREMENT NOT NULL,
     name VARCHAR(30),
     age TINYINT,
     phone VARCHAR(15),
     PRIMARY KEY (id)
); 

create table orders(
     id int not null primary key auto_increment,
     car_id int not null,
     client_id int not null,
     foreign key(car_id) references cars(id),
     foreign key(client_id) references clients(id)
); 

INSERT into marks(mark) values('Audi');
INSERT into marks(mark) values('Porsche'); 

insert into cars(mark_id, model, price) values (1, 'A5', 50000); 
insert into cars(mark_id, model, price) values (2, 'Panamera', 100000); 
insert into cars(mark_id, model, price) values (2, 'Cayman S', 88000); 

insert into clients(name, age, phone) values ('petro', 20, '111-22-33'), ('vasya', 25, '333-22-11'), ('vitaly', 75, '000-55-11'); 

insert into orders(car_id, client_id) values(1, 1), (2, 2), (1, 3); 