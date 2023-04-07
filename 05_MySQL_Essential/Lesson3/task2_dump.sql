CREATE DATABASE  IF NOT EXISTS `lesson3` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `lesson3`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: lesson3
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
-- Table structure for table `armory`
--

DROP TABLE IF EXISTS `armory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `armory` (
  `weaponId` smallint NOT NULL AUTO_INCREMENT,
  `wpnType` tinyint DEFAULT NULL,
  `serialNumber` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`weaponId`),
  UNIQUE KEY `serialNumber` (`serialNumber`),
  KEY `Armory_fk1` (`wpnType`),
  CONSTRAINT `Armory_fk1` FOREIGN KEY (`wpnType`) REFERENCES `weapontype` (`wpnTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Cклад(сховище) зброї';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `armory`
--

LOCK TABLES `armory` WRITE;
/*!40000 ALTER TABLE `armory` DISABLE KEYS */;
INSERT INTO `armory` VALUES (1,1,'0100000001'),(2,1,'0100000002'),(3,1,'0100000003'),(4,1,'0100000004'),(5,1,'0100000005'),(6,2,'0200000001'),(7,2,'0200000002'),(8,2,'0200000003'),(9,2,'0200000004'),(10,2,'0200000005');
/*!40000 ALTER TABLE `armory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `office`
--

DROP TABLE IF EXISTS `office`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `office` (
  `officeId` smallint NOT NULL AUTO_INCREMENT,
  `officeNumber` int NOT NULL,
  PRIMARY KEY (`officeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Якісь офіси';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `office`
--

LOCK TABLES `office` WRITE;
/*!40000 ALTER TABLE `office` DISABLE KEYS */;
INSERT INTO `office` VALUES (1,205),(2,221),(3,201);
/*!40000 ALTER TABLE `office` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `officer`
--

DROP TABLE IF EXISTS `officer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `officer` (
  `officerId` smallint NOT NULL AUTO_INCREMENT,
  `fullName` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`officerId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Війсковослужбовець';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `officer`
--

LOCK TABLES `officer` WRITE;
/*!40000 ALTER TABLE `officer` DISABLE KEYS */;
INSERT INTO `officer` VALUES (1,'Петров В.А.'),(2,'Лодарев П.С.'),(3,'Леонтьев К.В.'),(4,'Духов Р.М.'),(5,'Буров О.С.'),(6,'Рыбаков Н.Г.'),(7,'Деребанов В.Я.');
/*!40000 ALTER TABLE `officer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `officerrankhist`
--

DROP TABLE IF EXISTS `officerrankhist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `officerrankhist` (
  `officerId` smallint NOT NULL,
  `rankId` tinyint DEFAULT NULL,
  `since` date NOT NULL,
  UNIQUE KEY `officerId` (`officerId`,`since`),
  KEY `OfficerRankHist_fk2` (`rankId`),
  CONSTRAINT `OfficerRankHist_fk1` FOREIGN KEY (`officerId`) REFERENCES `officer` (`officerId`),
  CONSTRAINT `OfficerRankHist_fk2` FOREIGN KEY (`rankId`) REFERENCES `ranks` (`rankId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Звання війсковослужбовця';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `officerrankhist`
--

LOCK TABLES `officerrankhist` WRITE;
/*!40000 ALTER TABLE `officerrankhist` DISABLE KEYS */;
INSERT INTO `officerrankhist` VALUES (1,1,'2020-11-07'),(2,2,'2020-07-07'),(3,3,'2020-09-07'),(4,4,'2020-05-07'),(5,11,'2012-07-07'),(6,11,'2013-04-07'),(7,12,'2012-05-07');
/*!40000 ALTER TABLE `officerrankhist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platoon`
--

DROP TABLE IF EXISTS `platoon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `platoon` (
  `platoonId` smallint NOT NULL AUTO_INCREMENT COMMENT 'Id взвода',
  `plNumber` int DEFAULT NULL COMMENT '№ взвода',
  PRIMARY KEY (`platoonId`),
  KEY `plNumber` (`plNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Взвод';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platoon`
--

LOCK TABLES `platoon` WRITE;
/*!40000 ALTER TABLE `platoon` DISABLE KEYS */;
INSERT INTO `platoon` VALUES (4,200),(3,212),(1,222),(2,232);
/*!40000 ALTER TABLE `platoon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platoonstaff`
--

DROP TABLE IF EXISTS `platoonstaff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `platoonstaff` (
  `staffId` smallint NOT NULL AUTO_INCREMENT,
  `platoonId` smallint NOT NULL,
  `officerId` smallint NOT NULL,
  `officeId` smallint DEFAULT NULL,
  `startdate` date NOT NULL,
  `enddate` date DEFAULT NULL,
  PRIMARY KEY (`staffId`),
  UNIQUE KEY `platoonId` (`platoonId`,`officerId`,`startdate`),
  KEY `PlatoonStaff_fk2` (`officerId`),
  KEY `PlatoonStaff_fk3` (`officeId`),
  CONSTRAINT `PlatoonStaff_fk1` FOREIGN KEY (`platoonId`) REFERENCES `platoon` (`platoonId`),
  CONSTRAINT `PlatoonStaff_fk2` FOREIGN KEY (`officerId`) REFERENCES `officer` (`officerId`),
  CONSTRAINT `PlatoonStaff_fk3` FOREIGN KEY (`officeId`) REFERENCES `office` (`officeId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Особовий склад взводу';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platoonstaff`
--

LOCK TABLES `platoonstaff` WRITE;
/*!40000 ALTER TABLE `platoonstaff` DISABLE KEYS */;
INSERT INTO `platoonstaff` VALUES (1,1,1,1,'2021-11-07',NULL),(2,2,2,2,'2021-10-07',NULL),(3,3,3,2,'2021-12-07',NULL),(4,4,4,NULL,'2022-01-07',NULL),(5,4,5,NULL,'2014-12-07',NULL),(6,4,6,NULL,'2015-04-07',NULL),(7,4,7,NULL,'2014-06-07',NULL);
/*!40000 ALTER TABLE `platoonstaff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ranks`
--

DROP TABLE IF EXISTS `ranks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ranks` (
  `rankId` tinyint NOT NULL AUTO_INCREMENT,
  `rankName` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`rankId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Звання';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ranks`
--

LOCK TABLES `ranks` WRITE;
/*!40000 ALTER TABLE `ranks` DISABLE KEYS */;
INSERT INTO `ranks` VALUES (1,'солдат'),(2,'старший солдат'),(3,'сержант'),(4,'старший сержант'),(5,'старшина'),(6,'прапорщик'),(7,'молодший лейтенант'),(8,'лейтенант'),(9,'старший лейтенант'),(10,'капітан'),(11,'майор'),(12,'підполковник'),(13,'полковник');
/*!40000 ALTER TABLE `ranks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `report`
--

DROP TABLE IF EXISTS `report`;
/*!50001 DROP VIEW IF EXISTS `report`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `report` AS SELECT 
 1 AS `ФИО`,
 1 AS `Оф`,
 1 AS `Взвод`,
 1 AS `Зброя`,
 1 AS `№`,
 1 AS `Зброю видав`,
 1 AS `Коли`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `weaponbook`
--

DROP TABLE IF EXISTS `weaponbook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weaponbook` (
  `bookId` smallint NOT NULL AUTO_INCREMENT,
  `staffId` smallint DEFAULT NULL COMMENT 'Кому выдано',
  `issuedStaffId` smallint DEFAULT NULL COMMENT 'Кем выдано',
  `weaponId` smallint DEFAULT NULL COMMENT 'Что выдано',
  `startdate` date NOT NULL COMMENT 'Когда выдано',
  `enddate` date DEFAULT NULL,
  PRIMARY KEY (`bookId`),
  UNIQUE KEY `weaponId` (`weaponId`,`startdate`),
  KEY `weaponBook_fk1` (`staffId`),
  KEY `weaponBook_fk2` (`issuedStaffId`),
  CONSTRAINT `weaponBook_fk1` FOREIGN KEY (`staffId`) REFERENCES `platoonstaff` (`staffId`),
  CONSTRAINT `weaponBook_fk2` FOREIGN KEY (`issuedStaffId`) REFERENCES `platoonstaff` (`staffId`),
  CONSTRAINT `weaponBook_fk3` FOREIGN KEY (`weaponId`) REFERENCES `armory` (`weaponId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Книга обліку зброї';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weaponbook`
--

LOCK TABLES `weaponbook` WRITE;
/*!40000 ALTER TABLE `weaponbook` DISABLE KEYS */;
INSERT INTO `weaponbook` VALUES (1,1,5,1,'2023-02-07',NULL),(2,1,6,6,'2022-11-07',NULL),(3,2,7,2,'2022-06-07',NULL),(4,2,6,7,'2022-07-07',NULL),(5,3,5,3,'2022-10-07',NULL),(6,3,6,8,'2023-01-07',NULL),(7,4,5,4,'2022-09-07',NULL);
/*!40000 ALTER TABLE `weaponbook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weapontype`
--

DROP TABLE IF EXISTS `weapontype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weapontype` (
  `wpnTypeId` tinyint NOT NULL AUTO_INCREMENT,
  `wpnTypeName` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`wpnTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Типи зброї';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weapontype`
--

LOCK TABLES `weapontype` WRITE;
/*!40000 ALTER TABLE `weapontype` DISABLE KEYS */;
INSERT INTO `weapontype` VALUES (1,'АК-47'),(2,'Глок20');
/*!40000 ALTER TABLE `weapontype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'lesson3'
--
/*!50003 DROP FUNCTION IF EXISTS `OldDate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `OldDate`(y integer) RETURNS date
    NO SQL
BEGIN
	declare old_date date;
    set old_date = date_add(curdate(), interval -y year);
    set old_Date = date_add(old_Date, interval -FLOOR(RAND() * 12) month);
	return old_date;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `ReportDate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `ReportDate`() RETURNS date
    NO SQL
    COMMENT 'Використвується для встановлення дати формування звіту'
BEGIN
	declare repDate date default curdate();
    
--    set repDate = date_add(repdate, interval -5 month);
    
	return repDate;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `report`
--

/*!50001 DROP VIEW IF EXISTS `report`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `report` AS with `s1` as (select `o`.`fullName` AS `fullName`,`ofc`.`officeNumber` AS `officeNumber`,`p`.`plNumber` AS `plNumber`,`wt`.`wpnTypeName` AS `wpnTypeName`,`a`.`serialNumber` AS `serialNumber`,concat(`o2`.`fullName`,', ',`r2`.`rankName`) AS `who`,`wb`.`startdate` AS `startdate`,`rh2`.`since` AS `since`,min(`rh2`.`since`) OVER (PARTITION BY `rh2`.`officerId` )  AS `minRankDate` from ((((((((((`weaponbook` `wb` join `platoonstaff` `ps` on(((`ps`.`staffId` = `wb`.`staffId`) and (`ReportDate`() >= `ps`.`startdate`) and ((`ps`.`enddate` is null) or (`ReportDate`() <= `ps`.`enddate`))))) join `officer` `o` on((`o`.`officerId` = `ps`.`officerId`))) join `platoon` `p` on((`p`.`platoonId` = `ps`.`platoonId`))) left join `office` `ofc` on((`ofc`.`officeId` = `ps`.`officeId`))) join `armory` `a` on((`a`.`weaponId` = `wb`.`weaponId`))) join `weapontype` `wt` on((`wt`.`wpnTypeId` = `a`.`wpnType`))) join `platoonstaff` `ps2` on(((`ps2`.`staffId` = `wb`.`issuedStaffId`) and (`ReportDate`() >= `ps2`.`startdate`) and ((`ps2`.`enddate` is null) or (`ReportDate`() <= `ps2`.`enddate`))))) join `officer` `o2` on((`o2`.`officerId` = `ps2`.`officerId`))) left join `officerrankhist` `rh2` on(((`rh2`.`officerId` = `o2`.`officerId`) and (`ReportDate`() >= `rh2`.`since`)))) left join `ranks` `r2` on((`r2`.`rankId` = `rh2`.`rankId`))) where ((`ReportDate`() >= `wb`.`startdate`) and ((`wb`.`enddate` is null) or (`ReportDate`() <= `wb`.`enddate`))) order by `o`.`officerId`,`wt`.`wpnTypeId`) select `s1`.`fullName` AS `ФИО`,`s1`.`officeNumber` AS `Оф`,`s1`.`plNumber` AS `Взвод`,`s1`.`wpnTypeName` AS `Зброя`,`s1`.`serialNumber` AS `№`,`s1`.`who` AS `Зброю видав`,`s1`.`startdate` AS `Коли` from `s1` where (`s1`.`since` <= `s1`.`minRankDate`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-07 17:42:11
