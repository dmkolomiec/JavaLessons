CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `emp_exdata`
--

DROP TABLE IF EXISTS `emp_exdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_exdata` (
  `employee_id` smallint unsigned NOT NULL,
  `family_status` varchar(45) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `res_City` varchar(20) DEFAULT NULL,
  `res_address` varchar(50) DEFAULT NULL,
  KEY `emplyee_id` (`employee_id`),
  CONSTRAINT `FK_emp_extdata` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_exdata`
--

LOCK TABLES `emp_exdata` WRITE;
/*!40000 ALTER TABLE `emp_exdata` DISABLE KEYS */;
INSERT INTO `emp_exdata` VALUES (1,'Женат','1955-05-19','Пало-Альто','758 Лома-Верде-авеню'),(2,'Женат','1956-01-31','Лос-Алтос','498 Santa Barbara Drive'),(3,'married','1985-06-15','New York City','123 Main St. Apt 10'),(4,'single','1990-02-09','Los Angeles','456 Oak St. Apt 15'),(5,'married','1982-11-24','Chicago','789 Elm St. Apt 30'),(6,'married','1988-04-08','Houston','1010 Main St. Apt 25'),(7,'single','1983-02-17','Miami','456 Pine St. Apt 10'),(8,'single','1992-07-30','San Francisco','789 Market St. Apt 40'),(9,'married','1979-09-11','Seattle','1111 Pine St. Apt 60'),(10,'married','1995-05-27','Atlanta','222 Peachtree St. Apt 12');
/*!40000 ALTER TABLE `emp_exdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_position`
--

DROP TABLE IF EXISTS `emp_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_position` (
  `employee_id` smallint unsigned NOT NULL,
  `Position` varchar(45) DEFAULT NULL,
  `Salary` decimal(10,2) DEFAULT NULL,
  `since` date DEFAULT NULL,
  UNIQUE KEY `employee_id_idx2` (`employee_id`,`since`),
  KEY `employee_id_idx1` (`employee_id`),
  CONSTRAINT `employee_id_FK` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_position`
--

LOCK TABLES `emp_position` WRITE;
/*!40000 ALTER TABLE `emp_position` DISABLE KEYS */;
INSERT INTO `emp_position` VALUES (1,'Big boss',10000.00,'2017-05-22'),(2,'Super boss',15000.00,'2020-01-11'),(3,'truck driver',5000.00,'2010-10-02'),(4,'logistics coordinator',6000.00,'2011-03-14'),(5,'long-haul truck driver',7500.00,'2010-10-28'),(6,'dispatcher',5500.00,'2012-03-02'),(7,'mechanic-driver',6500.00,'2018-10-16'),(8,'sales representative',7000.00,'2019-08-08'),(9,'loader-packer',4500.00,'2015-11-03'),(10,'dispatcher',5000.00,'2020-12-20');
/*!40000 ALTER TABLE `emp_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` smallint unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `emp_id_UNIQUE` (`employee_id`),
  KEY `lastname_idx` (`lastname`,`firstname`),
  KEY `phone_idx` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COMMENT='Company employees';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Джеймс','Гослинг','+123123123'),(2,'Гвидо ван','Россум','+1000001'),(3,'John','Anderson','+1(555)123-4567'),(4,'Sarah','Brown','+1(555)234-5678'),(5,'David','Johnson','+1(555) 345-6789'),(6,'Emily','Davis','+1(555) 456-7890'),(7,'James','Martinez','+1(555)567-8901'),(8,'Laura','Hernandez','+1(555)678-9012'),(9,'Robert','Jackson','+1(555)789-0123'),(10,'Samantha','Thompson','+(555)890-1234');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-02 17:15:28
