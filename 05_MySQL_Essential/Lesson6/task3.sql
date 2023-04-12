/*
 Задание 3. Задайте свои индексы на таблицах, созданных в предыдущем домашнем задании и обоснуйте их необходимость. 
*/
use `myjoinsdb`;

drop index `person_idx1` on `myjoinsdb`.`person`;
drop index `person_idx2` on `myjoinsdb`.`person`;
  drop index `contact_idx1` on `myjoinsdb`.`contact`;
  drop index `contact_idx2` on `myjoinsdb`.`contact`;
  drop index `contact_idx3` on `myjoinsdb`.`contact`;
drop index `employee_idx1` on `myjoinsdb`.`employee`;
drop index `employee_idx2` on `myjoinsdb`.`employee`;

ALTER TABLE `myjoinsdb`.`person` 
ADD INDEX `person_idx1` (`fullName` ASC) COMMENT 'Для сортування за ім\'ям' VISIBLE,
ADD UNIQUE INDEX `person_idx2` (`phone` ASC) COMMENT 'Для сортування за номером телефону, та припускаючи, що номер унікальний.' VISIBLE;

ALTER TABLE `myjoinsdb`.`contact` 
ADD INDEX `contact_idx1` (`birthDate` ASC) COMMENT 'Для сортування/пошуку за датою народження' VISIBLE,
ADD INDEX `contact_idx2` (`address` ASC) COMMENT 'Для сортування/пошуку за адресою' VISIBLE,
ADD INDEX `contact_idx3` (`family` ASC) COMMENT 'Для сортування/пошуку за сім.станом' VISIBLE;

ALTER TABLE `myjoinsdb`.`employee` 
ADD INDEX `employee_idx1` (`salary` ASC) COMMENT 'Для сортування/пошуку за з/п' VISIBLE,
ADD INDEX `employee_idx2` (`position` ASC) COMMENT 'Для сортування/пошуку за посадою' VISIBLE;
