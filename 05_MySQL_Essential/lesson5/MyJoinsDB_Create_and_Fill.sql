/******************
   Создание схемы
*******************/
drop DATABASE IF EXISTS `MyJoinsDB`;
CREATE SCHEMA IF NOT EXISTS `MyJoinsDB` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `MyJoinsDB`;

-- -----------------------------------------------------
-- Table `MyJoinsDB`.`Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyJoinsDB`.`Person` (
  `personId` INT NOT NULL auto_increment,
  `fullName` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(12) NULL,
  PRIMARY KEY (`personId`));

-- -----------------------------------------------------
-- Table `MyJoinsDB`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyJoinsDB`.`Employee` (
  `personId` INT NOT NULL,
  `Salary` DECIMAL(12,2) NULL,
  `position` VARCHAR(45) NULL,
  INDEX `Employee_fk1_idx` (`personId` ASC) VISIBLE,
  CONSTRAINT `Employee_fk1`
    FOREIGN KEY (`personId`)
    REFERENCES `MyJoinsDB`.`Person` (`personId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

-- -----------------------------------------------------
-- Table `MyJoinsDB`.`Contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyJoinsDB`.`Contact` (
  `personId` INT NOT NULL,
  `birthDate` DATE NULL,
  `address` VARCHAR(45) NULL,
  `family` VARCHAR(45) NULL,
  INDEX `contact_fk1_idx` (`personId` ASC) VISIBLE,
  CONSTRAINT `contact_fk1`
    FOREIGN KEY (`personId`)
    REFERENCES `MyJoinsDB`.`Person` (`personId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
/******************
 Заполнение таблиц
*******************/
INSERT INTO Person (personId, fullName, phone)
VALUES 
(1, 'John Doe', '123-456-7890'),
(2, 'Jane Smith', '555-555-5555'),
(3, 'Bob Johnson', '555-123-4567'),
(4, 'Puss in Boots', '444-321-7777');


INSERT INTO MyJoinsDB.Employee (personId, Salary, position)
VALUES 
(1, 50000.00, 'Director'),
(2, 30000.00, 'Manager'),
(3, 15000.00, 'Worker'),
(4, 19000.00, 'Manager');


INSERT INTO Contact (personId, birthDate, address, family)
VALUES 
(1, '1970-01-01', '123 Main St', 'Married'),
(2, '1980-01-01', '234 Second St', 'Married'),
(3, '1990-01-01', '123 Third St', 'Single'),
(4, '1920-01-01', '456 Cat''s Square', 'Single');
