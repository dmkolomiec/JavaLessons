DROP DATABASE if exists `myfunkdb`;
CREATE SCHEMA `myfunkdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
use `myfunkdb`;

-- Table structure for table `person`
CREATE TABLE `person` (
  `personId` int NOT NULL AUTO_INCREMENT,
  `fullName` varchar(45)  NOT NULL,
  `phone`varchar(12)  DEFAULT NULL,
  PRIMARY KEY (`personId`),
  UNIQUE KEY `person_idx2` (`phone`) COMMENT 'Для сортування за номером телефону, та припускаючи, що номер унікальний.',
  KEY `person_idx1` (`fullName`) COMMENT 'Для сортування за ім''ям'
);

-- Dumping data for table `person`
INSERT INTO `person` VALUES (1,'John Doe','123-456-7890'),(2,'Jane Smith','555-555-5555'),(3,'Bob Johnson','555-123-4567'),(4,'Puss in Boots','444-321-7777');

-- Table structure for table `contact`
CREATE TABLE `contact` (
  `personId` int NOT NULL,
  `birthDate` date DEFAULT NULL,
  `address` varchar(45)  DEFAULT NULL,
  `family` varchar(45)  DEFAULT NULL,
  KEY `contact_fk1_idx` (`personId`),
  KEY `contact_idx1` (`birthDate`) COMMENT 'Для сортування/пошуку за датою народження',
  KEY `contact_idx2` (`address`) COMMENT 'Для сортування/пошуку за адресою',
  KEY `contact_idx3` (`family`) COMMENT 'Для сортування/пошуку за сім.станом',
  CONSTRAINT `contact_fk1` FOREIGN KEY (`personId`) REFERENCES `person` (`personId`) on update cascade on delete cascade
);

-- Dumping data for table `contact`
INSERT INTO `contact` VALUES (1,'1970-01-01','123 Main St','Married'),(2,'1980-01-01','234 Second St','Married'),(3,'1990-01-01','123 Third St','Single'),(4,'1920-01-01','456 Cat\'s Square','Single');

-- Table structure for table `employee`
CREATE TABLE `employee` (
  `personId` int NOT NULL,
  `Salary` decimal(12,2) DEFAULT NULL,
  `position` varchar(45)  DEFAULT NULL,
  KEY `Employee_fk1_idx` (`personId`),
  KEY `employee_idx1` (`Salary`) COMMENT 'Для сортування/пошуку за з/п',
  KEY `employee_idx2` (`position`) COMMENT 'Для сортування/пошуку за посадою',
  CONSTRAINT `Employee_fk1` FOREIGN KEY (`personId`) REFERENCES `person` (`personId`) on update cascade on delete cascade
);

-- Dumping data for table `employee`
INSERT INTO `employee` VALUES (1,50000.00,'Director'),(2,30000.00,'Manager'),(3,15000.00,'Worker'),(4,19000.00,'Manager');
