CREATE DATABASE  IF NOT EXISTS `warehouse` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `warehouse`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: warehouse
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
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS contact;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE contact (
  partyid smallint unsigned NOT NULL,
  country varchar(30) NOT NULL,
  city varchar(30) NOT NULL,
  address varchar(60) NOT NULL,
  phone varchar(15) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  KEY contact_idx1 (partyid),
  CONSTRAINT contact_fk1 FOREIGN KEY (partyid) REFERENCES party (partyid) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='Party contacts - address, phone, e-mail, etc.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES contact WRITE;
/*!40000 ALTER TABLE contact DISABLE KEYS */;
INSERT INTO contact VALUES (1,'Japan','Sasebo','1913 Hanoi Way','28303384290','MARY.SMITH@sakilacustomer.org'),(2,'United States','San Bernardino','1121 Loja Avenue','838635286649','PATRICIA.JOHNSON@sakilacustomer.org'),(3,'Greece','Athenai','692 Joliet Street','448477190408','LINDA.WILLIAMS@sakilacustomer.org'),(4,'Myanmar','Myingyan','1566 Inegl Manor','705814003527','BARBARA.JONES@sakilacustomer.org'),(5,'Taiwan','Nantou','53 Idfu Parkway','10655648674','ELIZABETH.BROWN@sakilacustomer.org'),(6,'United States','Laredo','1795 Santiago de Compostela Way','860452626434','JENNIFER.DAVIS@sakilacustomer.org'),(7,'Yugoslavia','Kragujevac','900 Santiago de Compostela Parkway','716571220373','MARIA.MILLER@sakilacustomer.org'),(8,'New Zealand','Hamilton','478 Joliet Way','657282285970','SUSAN.WILSON@sakilacustomer.org'),(9,'Oman','Masqat','613 Korolev Drive','380657522649','MARGARET.MOORE@sakilacustomer.org'),(10,'Iran','Esfahan','1531 Sal Drive','648856936185','DOROTHY.TAYLOR@sakilacustomer.org'),(11,'Japan','Sagamihara','1542 Tarlac Parkway','635297277345','LISA.ANDERSON@sakilacustomer.org'),(12,'India','Yamuna Nagar','808 Bhopal Manor','465887807014','NANCY.THOMAS@sakilacustomer.org'),(13,'Turkey','Osmaniye','270 Amroha Parkway','695479687538','KAREN.JACKSON@sakilacustomer.org'),(14,'United States','Citrus Heights','770 Bydgoszcz Avenue','517338314235','BETTY.WHITE@sakilacustomer.org'),(15,'India','Bhopal','419 Iligan Lane','990911107354','HELEN.HARRIS@sakilacustomer.org'),(16,'United Kingdom','Southend-on-Sea','360 Toulouse Parkway','949312333307','SANDRA.MARTIN@sakilacustomer.org'),(17,'Russian Federation','Elista','270 Toulon Boulevard','407752414682','DONNA.THOMPSON@sakilacustomer.org'),(18,'Nigeria','Kaduna','320 Brest Avenue','747791594069','CAROL.GARCIA@sakilacustomer.org'),(19,'South Africa','Kimberley','1417 Lancaster Avenue','272572357893','RUTH.MARTINEZ@sakilacustomer.org'),(20,'Pakistan','Mardan','1688 Okara Way','144453869132','SHARON.ROBINSON@sakilacustomer.org'),(21,'Bangladesh','Tangail','262 A Corua (La Corua) Parkway','892775750063','MICHELLE.CLARK@sakilacustomer.org'),(22,'Morocco','Salé','28 Charlotte Amalie Street','161968374323','LAURA.RODRIGUEZ@sakilacustomer.org'),(23,'Latvia','Liepaja','1780 Hino Boulevard','902731229323','SARAH.LEWIS@sakilacustomer.org'),(24,'Argentina','Córdoba','96 Tafuna Way','934730187245','KIMBERLY.LEE@sakilacustomer.org'),(25,'Pakistan','Shikarpur','934 San Felipe de Puerto Plata Street','196495945706','DEBORAH.WALKER@sakilacustomer.org'),(26,'Holy See (Vatican City State)','Città del Vaticano','18 Duisburg Boulevard','998009777982','JESSICA.HALL@sakilacustomer.org'),(27,'Philippines','Davao','217 Botshabelo Place','665356572025','SHIRLEY.ALLEN@sakilacustomer.org'),(28,'India','Munger (Monghyr)','1425 Shikarpur Manor','678220867005','CYNTHIA.YOUNG@sakilacustomer.org'),(29,'Japan','Shimonoseki','786 Aurora Avenue','18461860151','ANGELA.HERNANDEZ@sakilacustomer.org'),(30,'Taiwan','Lungtan','1668 Anpolis Street','525255540978','MELISSA.KING@sakilacustomer.org'),(31,'India','Kamarhati','33 Gorontalo Way','745994947458','BRENDA.WRIGHT@sakilacustomer.org'),(32,'India','Jhansi','176 Mandaluyong Place','627705991774','AMY.LOPEZ@sakilacustomer.org'),(33,'Italy','Alessandria','127 Purnea (Purnia) Manor','911872220378','ANNA.HILL@sakilacustomer.org'),(34,'Japan','Kurashiki','61 Tama Street','708403338270','REBECCA.SCOTT@sakilacustomer.org'),(35,'France','Toulouse','391 Callao Drive','440512153169','VIRGINIA.GREEN@sakilacustomer.org'),(36,'Iran','Arak','334 Munger (Monghyr) Lane','481183273622','KATHLEEN.ADAMS@sakilacustomer.org'),(37,'China','Nanyang','1440 Fukuyama Loop','912257250465','PAMELA.BAKER@sakilacustomer.org'),(38,'Moldova','Chisinau','269 Cam Ranh Parkway','489783829737','MARTHA.GONZALEZ@sakilacustomer.org'),(39,'Brazil','Vila Velha','306 Antofagasta Place','378318851631','DEBRA.NELSON@sakilacustomer.org'),(40,'Morocco','Nador','671 Graz Street','680768868518','AMANDA.CARTER@sakilacustomer.org'),(41,'Armenia','Yerevan','42 Brindisi Place','42384721397','STEPHANIE.MITCHELL@sakilacustomer.org'),(42,'Thailand','Pak Kret','1632 Bislig Avenue','471675840679','CAROLYN.PEREZ@sakilacustomer.org'),(43,'French Polynesia','Faaa','1447 Imus Way','539758313890','CHRISTINE.ROBERTS@sakilacustomer.org'),(44,'Russian Federation','Lipetsk','1998 Halifax Drive','177727722820','MARIE.TURNER@sakilacustomer.org'),(45,'Chile','Antofagasta','1718 Valencia Street','675292816413','JANET.PHILLIPS@sakilacustomer.org'),(46,'Russian Federation','Moscow','46 Pjatigorsk Lane','262076994845','CATHERINE.CAMPBELL@sakilacustomer.org'),(47,'Brazil','Juazeiro do Norte','686 Garland Manor','69493378813','FRANCES.PARKER@sakilacustomer.org'),(48,'Russian Federation','Niznekamsk','909 Garland Manor','705800322606','ANN.EVANS@sakilacustomer.org'),(49,'Saudi Arabia','Jedda','725 Isesaki Place','876295323994','JOYCE.EDWARDS@sakilacustomer.org'),(50,'Sudan','Omdurman','115 Hidalgo Parkway','307703950263','DIANE.COLLINS@sakilacustomer.org'),(51,'United States','Fontana','1135 Izumisano Parkway','171822533480','ALICE.STEWART@sakilacustomer.org'),(52,'Spain','A Coruña (La Coruña)','939 Probolinggo Loop','680428310138','JULIE.SANCHEZ@sakilacustomer.org'),(53,'Japan','Nagareyama','17 Kabul Boulevard','697760867968','HEATHER.MORRIS@sakilacustomer.org'),(54,'Japan','Iwakuni','1964 Allappuzha (Alleppey) Street','920811325222','TERESA.ROGERS@sakilacustomer.org'),(55,'Russian Federation','Balašiha','1697 Kowloon and New Kowloon Loop','499352017190','DORIS.REED@sakilacustomer.org'),(56,'French Polynesia','Papeete','1668 Saint Louis Place','347487831378','GLORIA.COOK@sakilacustomer.org'),(57,'Liechtenstein','Vaduz','943 Tokat Street','889318963672','EVELYN.MORGAN@sakilacustomer.org'),(58,'Malaysia','Kuching','1114 Liepaja Street','212869228936','JEAN.BELL@sakilacustomer.org'),(59,'India','Mysore','1213 Ranchi Parkway','800024380485','CHERYL.MURPHY@sakilacustomer.org'),(60,'India','Jaipur','81 Hodeida Way','250767749542','MILDRED.BAILEY@sakilacustomer.org'),(61,'Switzerland','Basel','915 Ponce Place','1395251317','KATHERINE.RIVERA@sakilacustomer.org'),(62,'United States','Saint Louis','1717 Guadalajara Lane','914090181665','JOAN.COOPER@sakilacustomer.org'),(63,'United States','Lincoln','1214 Hanoi Way','491001136577','ASHLEY.RICHARDSON@sakilacustomer.org'),(64,'China','Daxian','1966 Amroha Avenue','333489324603','JUDITH.COX@sakilacustomer.org'),(65,'French Guiana','Cayenne','698 Otsu Street','409983924481','ROSE.HOWARD@sakilacustomer.org'),(66,'Sweden','Malmö','1150 Kimchon Manor','663449333709','JANICE.WARD@sakilacustomer.org'),(67,'China','Xi´angtan','1586 Guaruj Place','947233365992','KELLY.TORRES@sakilacustomer.org'),(68,'India','Shivapuri','57 Arlington Manor','990214419142','NICOLE.PETERSON@sakilacustomer.org'),(69,'Algeria','Béchar','1031 Daugavpils Parkway','107137400143','JUDY.GRAY@sakilacustomer.org');
/*!40000 ALTER TABLE contact ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `customers_emp_v`
--

DROP TABLE IF EXISTS customers_emp_v;
/*!50001 DROP VIEW IF EXISTS customers_emp_v*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `customers_emp_v` AS SELECT 
 1 AS counterpartid,
 1 AS ptName,
 1 AS partyid,
 1 AS firstname,
 1 AS lastname,
 1 AS gender,
 1 AS birthdate,
 1 AS country,
 1 AS city,
 1 AS address,
 1 AS phone,
 1 AS email*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `customers_v`
--

DROP TABLE IF EXISTS customers_v;
/*!50001 DROP VIEW IF EXISTS customers_v*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `customers_v` AS SELECT 
 1 AS counterpartid,
 1 AS State,
 1 AS startdate,
 1 AS ptName,
 1 AS country,
 1 AS city,
 1 AS address,
 1 AS phone,
 1 AS email*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS department;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE department (
  DepartmentId smallint NOT NULL AUTO_INCREMENT,
  DepartmentName varchar(60) NOT NULL,
  Descr varchar(80) DEFAULT NULL,
  PRIMARY KEY (DepartmentId)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3 COMMENT='Підрозділи';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES department WRITE;
/*!40000 ALTER TABLE department DISABLE KEYS */;
INSERT INTO department VALUES (1,'Procurement and Purchasing Department','Отдел снабжения и закупок'),(2,'Warehouse Management Department','Отдел складского хозяйства'),(3,'Logistics and Transportation Department','Отдел логистики и транспорта'),(4,'Inventory Management Department','Отдел управления запасами'),(5,'Quality Management and Certification Department','Отдел управления качеством и сертификации'),(6,'Risk Management and Safety Department','Отдел управления рисками и безопасностью'),(7,'Marketing and Sales Department','Отдел маркетинга и продаж'),(8,'Finance and Accounting Department','Отдел финансов и бухгалтерии'),(9,'Human Resources Management Department','Отдел управления персоналом'),(10,'Information Technology and Software Development Department','Отдел информационных технологий и разработки программного обеспечения');
/*!40000 ALTER TABLE department ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `deps_emp_v`
--

DROP TABLE IF EXISTS deps_emp_v;
/*!50001 DROP VIEW IF EXISTS deps_emp_v*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `deps_emp_v` AS SELECT 
 1 AS DepartmentName,
 1 AS КількісьСпівр,
 1 AS FirstName,
 1 AS LastName,
 1 AS Посада*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `dirs`
--

DROP TABLE IF EXISTS dirs;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE dirs (
  dirid smallint unsigned NOT NULL,
  valid smallint unsigned NOT NULL,
  `value` varchar(20) NOT NULL,
  Descr varchar(50) DEFAULT NULL,
  UNIQUE KEY list_idx1 (dirid,valid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='Universal auxiliary lists';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dirs`
--

LOCK TABLES dirs WRITE;
/*!40000 ALTER TABLE dirs DISABLE KEYS */;
INSERT INTO dirs VALUES (1,1,'Active',NULL),(1,2,'Closed',NULL),(2,1,'Male',NULL),(2,2,'Female',NULL),(3,1,'Working','Работает'),(3,2,'On vacation','В отпуске'),(3,3,'On leave','В отпуске/отсутствует по личным причинам'),(3,4,'Sick leave','На больничном'),(3,5,'Maternity leave','В декретном отпуске'),(3,6,'Paternity leave','В отпуске по уходу за ребенком'),(3,7,'Study leave','В отпуске на обучении'),(3,8,'Sabbatical leave','В отпуске на период отдыха/увольнения');
/*!40000 ALTER TABLE dirs ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `emp_pr_v`
--

DROP TABLE IF EXISTS emp_pr_v;
/*!50001 DROP VIEW IF EXISTS emp_pr_v*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `emp_pr_v` AS SELECT 
 1 AS empId,
 1 AS firstname,
 1 AS lastname,
 1 AS postName,
 1 AS EmpState,
 1 AS startdate,
 1 AS enddate,
 1 AS PeriodStare,
 1 AS salary*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `emp_ts_v`
--

DROP TABLE IF EXISTS emp_ts_v;
/*!50001 DROP VIEW IF EXISTS emp_ts_v*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `emp_ts_v` AS SELECT 
 1 AS empId,
 1 AS firstname,
 1 AS lastname,
 1 AS postName,
 1 AS state,
 1 AS startdate,
 1 AS enddate,
 1 AS value*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `employees_v`
--

DROP TABLE IF EXISTS employees_v;
/*!50001 DROP VIEW IF EXISTS employees_v*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `employees_v` AS SELECT 
 1 AS partyid,
 1 AS empid,
 1 AS firstname,
 1 AS lastname,
 1 AS gender,
 1 AS birthdate,
 1 AS postname,
 1 AS state,
 1 AS startdate,
 1 AS salary,
 1 AS country,
 1 AS city,
 1 AS address,
 1 AS phone,
 1 AS email*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `party`
--

DROP TABLE IF EXISTS party;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE party (
  partyid smallint unsigned NOT NULL AUTO_INCREMENT COMMENT 'Unique subject id',
  kind tinyint unsigned NOT NULL COMMENT 'subject''s kind',
  ptname varchar(45) DEFAULT NULL COMMENT 'Subject''s name',
  notes varchar(100) DEFAULT NULL COMMENT 'Notes',
  PRIMARY KEY (partyid),
  KEY party_fk1_idx (kind),
  CONSTRAINT party_fk1 FOREIGN KEY (kind) REFERENCES ptkind (kindid)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb3 COMMENT='All subjects main table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party`
--

LOCK TABLES party WRITE;
/*!40000 ALTER TABLE party DISABLE KEYS */;
INSERT INTO party VALUES (1,1,'Our company','warehouse'),(2,1,'Supplier №2','Supplier'),(3,1,'Supplier №3','Supplier'),(4,1,'Supplier №4','Supplier'),(5,1,'Supplier №5','Supplier'),(6,1,'Supplier №6','Supplier'),(7,1,'Supplier №7','Supplier'),(8,1,'Supplier №8','Supplier'),(9,1,'Supplier №9','Supplier'),(10,1,'Supplier №10','Supplier'),(11,1,'Customer №1','Customer'),(12,1,'Customer №2','Customer'),(13,1,'Customer №3','Customer'),(14,1,'Customer №4','Customer'),(15,1,'Customer №5','Customer'),(16,1,'Customer №6','Customer'),(17,1,'Customer №7','Customer'),(18,1,'Customer №8','Customer'),(19,1,'Customer №9','Customer'),(20,1,'Customer №10','Customer'),(21,2,'MICHELLE CLARK','Person'),(22,2,'LAURA RODRIGUEZ','Person'),(23,2,'SARAH LEWIS','Person'),(24,2,'KIMBERLY LEE','Person'),(25,2,'DEBORAH WALKER','Person'),(26,2,'JESSICA HALL','Person'),(27,2,'SHIRLEY ALLEN','Person'),(28,2,'CYNTHIA YOUNG','Person'),(29,2,'ANGELA HERNANDEZ','Person'),(30,2,'MELISSA KING','Person'),(31,2,'BRENDA WRIGHT','Person'),(32,2,'AMY LOPEZ','Person'),(33,2,'ANNA HILL','Person'),(34,2,'REBECCA SCOTT','Person'),(35,2,'VIRGINIA GREEN','Person'),(36,2,'KATHLEEN ADAMS','Person'),(37,2,'PAMELA BAKER','Person'),(38,2,'MARTHA GONZALEZ','Person'),(39,2,'DEBRA NELSON','Person'),(40,2,'AMANDA CARTER','Person'),(41,2,'STEPHANIE MITCHELL','Person'),(42,2,'CAROLYN PEREZ','Person'),(43,2,'CHRISTINE ROBERTS','Person'),(44,2,'MARIE TURNER','Person'),(45,2,'JANET PHILLIPS','Person'),(46,2,'CATHERINE CAMPBELL','Person'),(47,2,'FRANCES PARKER','Person'),(48,2,'ANN EVANS','Person'),(49,2,'JOYCE EDWARDS','Person'),(50,2,'DIANE COLLINS','Person'),(51,2,'ALICE STEWART','Person'),(52,2,'JULIE SANCHEZ','Person'),(53,2,'HEATHER MORRIS','Person'),(54,2,'TERESA ROGERS','Person'),(55,2,'DORIS REED','Person'),(56,2,'GLORIA COOK','Person'),(57,2,'EVELYN MORGAN','Person'),(58,2,'JEAN BELL','Person'),(59,2,'CHERYL MURPHY','Person'),(60,2,'MILDRED BAILEY','Person'),(61,2,'KATHERINE RIVERA','Person'),(62,2,'JOAN COOPER','Person'),(63,2,'ASHLEY RICHARDSON','Person'),(64,2,'JUDITH COX','Person'),(65,2,'ROSE HOWARD','Person'),(66,2,'JANICE WARD','Person'),(67,2,'KELLY TORRES','Person'),(68,2,'NICOLE PETERSON','Person'),(69,2,'JUDY GRAY','Person');
/*!40000 ALTER TABLE party ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payroll`
--

DROP TABLE IF EXISTS payroll;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE payroll (
  empid smallint unsigned NOT NULL,
  startdate date NOT NULL,
  enddate date NOT NULL,
  salary decimal(12,2) NOT NULL,
  KEY payroll (empid),
  CONSTRAINT payroll_fk1 FOREIGN KEY (empid) REFERENCES staff (empId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='з/п ведомость';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payroll`
--

LOCK TABLES payroll WRITE;
/*!40000 ALTER TABLE payroll DISABLE KEYS */;
INSERT INTO payroll VALUES (1,'2023-03-01','2023-03-31',5000.00),(1,'2023-02-01','2023-02-28',5000.00),(2,'2023-03-01','2023-03-31',3000.00),(2,'2023-02-01','2023-02-28',3000.00),(3,'2023-03-01','2023-03-31',2500.00),(4,'2023-03-01','2023-03-31',4000.00),(4,'2023-02-01','2023-02-28',4000.00),(5,'2023-03-01','2023-03-31',4000.00),(6,'2023-03-01','2023-03-31',2500.00),(6,'2023-02-01','2023-02-28',2500.00),(7,'2023-03-01','2023-03-31',5000.00),(8,'2023-03-01','2023-03-31',7500.00),(8,'2023-02-01','2023-02-28',7500.00),(9,'2023-03-01','2023-03-31',5000.00),(10,'2023-03-01','2023-03-31',3000.00),(10,'2023-02-01','2023-02-28',3000.00),(11,'2023-03-01','2023-03-31',5000.00),(11,'2023-02-01','2023-02-28',5000.00);
/*!40000 ALTER TABLE payroll ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS person;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE person (
  partyid smallint unsigned NOT NULL,
  LastName varchar(30) NOT NULL,
  FirstName varchar(30) NOT NULL,
  Gender tinyint unsigned DEFAULT '0',
  BirthDate date DEFAULT NULL,
  UNIQUE KEY partyid (partyid),
  CONSTRAINT person_fk1 FOREIGN KEY (partyid) REFERENCES party (partyid) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='Individuals';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES person WRITE;
/*!40000 ALTER TABLE person DISABLE KEYS */;
INSERT INTO person VALUES (21,'CLARK','MICHELLE',2,'2013-06-16'),(22,'RODRIGUEZ','LAURA',2,'2011-05-15'),(23,'LEWIS','SARAH',2,'2009-04-14'),(24,'LEE','KIMBERLY',2,'2013-03-13'),(25,'WALKER','DEBORAH',2,'2016-02-12'),(26,'HALL','JESSICA',2,'2014-01-11'),(27,'ALLEN','SHIRLEY',2,'2011-12-10'),(28,'YOUNG','CYNTHIA',2,'2009-11-09'),(29,'HERNANDEZ','ANGELA',2,'2007-10-08'),(30,'KING','MELISSA',2,'2016-09-07'),(31,'WRIGHT','BRENDA',2,'2014-08-06'),(32,'LOPEZ','AMY',2,'2012-07-05'),(33,'HILL','ANNA',2,'2010-06-04'),(34,'SCOTT','REBECCA',2,'2008-05-03'),(35,'GREEN','VIRGINIA',2,'2011-04-02'),(36,'ADAMS','KATHLEEN',2,'2015-03-01'),(37,'BAKER','PAMELA',2,'2013-01-28'),(38,'GONZALEZ','MARTHA',2,'2010-12-27'),(39,'NELSON','DEBRA',2,'2008-11-26'),(40,'CARTER','AMANDA',2,'2011-10-25'),(41,'MITCHELL','STEPHANIE',2,'2009-09-24'),(42,'PEREZ','CAROLYN',2,'2013-08-23'),(43,'ROBERTS','CHRISTINE',2,'2011-07-22'),(44,'TURNER','MARIE',2,'2009-06-21'),(45,'PHILLIPS','JANET',2,'2012-05-20'),(46,'CAMPBELL','CATHERINE',2,'2010-04-19'),(47,'PARKER','FRANCES',2,'2008-03-18'),(48,'EVANS','ANN',2,'2012-02-17'),(49,'EDWARDS','JOYCE',2,'2010-01-16'),(50,'COLLINS','DIANE',2,'2012-12-15'),(51,'STEWART','ALICE',1,'2010-11-14'),(52,'SANCHEZ','JULIE',2,'2008-10-13'),(53,'MORRIS','HEATHER',2,'2006-09-12'),(54,'ROGERS','TERESA',2,'2010-08-11'),(55,'REED','DORIS',2,'2013-07-10'),(56,'COOK','GLORIA',2,'2011-06-09'),(57,'MORGAN','EVELYN',2,'2009-05-08'),(58,'BELL','JEAN',1,'2007-04-07'),(59,'MURPHY','CHERYL',2,'2005-03-06'),(60,'BAILEY','MILDRED',2,'2014-02-05'),(61,'RIVERA','KATHERINE',2,'2012-01-04'),(62,'COOPER','JOAN',2,'2009-12-03'),(63,'RICHARDSON','ASHLEY',2,'2007-11-02'),(64,'COX','JUDITH',2,'2005-10-01'),(65,'HOWARD','ROSE',2,'2008-08-31'),(66,'WARD','JANICE',2,'2012-07-30'),(67,'TORRES','KELLY',1,'2010-06-29'),(68,'PETERSON','NICOLE',2,'2008-05-28'),(69,'GRAY','JUDY',1,'2006-04-27');
/*!40000 ALTER TABLE person ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS post;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE post (
  Postid smallint unsigned NOT NULL COMMENT 'Unique id',
  Postname varchar(45) NOT NULL COMMENT 'Position''s description',
  Descr varchar(60) NOT NULL,
  State tinyint NOT NULL COMMENT 'state of poposition.  Active or closed.',
  Startdate date NOT NULL COMMENT 'Beginnig date',
  Enddate date DEFAULT NULL COMMENT 'Closing date',
  SalaryMin decimal(12,2) DEFAULT NULL COMMENT 'Salary rqate',
  SalaryMax decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (Postid),
  UNIQUE KEY Postid_UNIQUE (Postid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='Jobs(positions) directory';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES post WRITE;
/*!40000 ALTER TABLE post DISABLE KEYS */;
INSERT INTO post VALUES (1,'Logistics Coordinator','координатор логистики',1,'2021-04-06',NULL,3000.00,5000.00),(2,'Supply Chain Manager','менеджер цепей поставок',1,'2021-04-06',NULL,5000.00,10000.00),(3,'Freight Forwarder','экспедитор грузовых перевозок',1,'2021-04-06',NULL,3000.00,6000.00),(4,'Truck Driver','водитель грузовика',1,'2021-04-06',NULL,2500.00,5000.00),(5,'Warehouse Manager','менеджер склада',1,'2021-04-06',NULL,4000.00,7000.00),(6,'Customs Broker','таможенный брокер',1,'2021-04-06',NULL,4000.00,8000.00),(7,'Shipping/Receiving Clerk','клерк по приему и отправке грузов',1,'2021-04-06',NULL,2500.00,4500.00),(8,'Fleet Manager','менеджер автопарка',1,'2021-04-06',NULL,5000.00,9000.00),(9,'Traffic Controller','диспетчер воздушного движения',1,'2021-04-06',NULL,7500.00,11000.00),(10,'Pilot','пилот',1,'2021-04-06',NULL,5000.00,15000.00);
/*!40000 ALTER TABLE post ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptkind`
--

DROP TABLE IF EXISTS ptkind;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE ptkind (
  kindid tinyint unsigned NOT NULL COMMENT 'Unique kind id',
  descr varchar(30) NOT NULL COMMENT 'Kind description',
  PRIMARY KEY (kindid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='Subject kinds';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptkind`
--

LOCK TABLES ptkind WRITE;
/*!40000 ALTER TABLE ptkind DISABLE KEYS */;
INSERT INTO ptkind VALUES (1,'Company'),(2,'Person');
/*!40000 ALTER TABLE ptkind ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptrole`
--

DROP TABLE IF EXISTS ptrole;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE ptrole (
  partyid smallint unsigned NOT NULL COMMENT 'party id',
  roleid tinyint unsigned NOT NULL COMMENT 'role id',
  counterpartid smallint unsigned NOT NULL,
  state tinyint unsigned NOT NULL,
  startdate date NOT NULL,
  enddate date DEFAULT NULL,
  KEY ptrole_idx2 (counterpartid) /*!80000 INVISIBLE */,
  KEY ptrole_idx3 (roleid),
  KEY ptrole_idx1 (partyid),
  CONSTRAINT ptrole_fk1 FOREIGN KEY (partyid) REFERENCES party (partyid) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT ptrole_fk2 FOREIGN KEY (counterpartid) REFERENCES party (partyid) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT ptrole_fk3 FOREIGN KEY (roleid) REFERENCES ptroletype (roleid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='Roles of subjects';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptrole`
--

LOCK TABLES ptrole WRITE;
/*!40000 ALTER TABLE ptrole DISABLE KEYS */;
INSERT INTO ptrole VALUES (1,0,1,1,'2023-04-06',NULL),(1,1,2,1,'2023-04-06',NULL),(1,1,3,1,'2023-04-06',NULL),(1,1,4,1,'2023-04-06',NULL),(1,1,5,1,'2023-04-06',NULL),(1,1,6,1,'2023-04-06',NULL),(1,1,7,1,'2023-04-06',NULL),(1,1,8,1,'2023-04-06',NULL),(1,1,9,1,'2023-04-06',NULL),(1,1,10,1,'2023-04-06',NULL),(1,2,11,1,'2023-04-06',NULL),(1,2,12,1,'2023-04-06',NULL),(1,2,13,1,'2023-04-06',NULL),(1,2,14,1,'2023-04-06',NULL),(1,2,15,1,'2023-04-06',NULL),(1,2,16,1,'2023-04-06',NULL),(1,2,17,1,'2023-04-06',NULL),(1,2,18,1,'2023-04-06',NULL),(1,2,19,1,'2023-04-06',NULL),(1,2,20,1,'2023-04-06',NULL),(1,3,21,1,'2023-04-06',NULL),(1,3,22,1,'2023-04-06',NULL),(1,3,23,1,'2023-04-06',NULL),(1,3,24,1,'2023-04-06',NULL),(1,3,25,1,'2023-04-06',NULL),(1,3,26,1,'2023-04-06',NULL),(1,3,27,1,'2023-04-06',NULL),(1,3,28,1,'2023-04-06',NULL),(1,3,29,1,'2023-04-06',NULL),(1,3,30,1,'2023-04-06',NULL),(1,3,31,1,'2023-04-06',NULL),(2,3,32,1,'2023-04-04',NULL),(2,3,33,1,'2023-04-04',NULL),(3,3,34,1,'2023-04-03',NULL),(3,3,35,1,'2023-04-03',NULL),(4,3,36,1,'2023-04-02',NULL),(4,3,37,1,'2023-04-02',NULL),(5,3,38,1,'2023-04-01',NULL),(5,3,39,1,'2023-04-01',NULL),(6,3,40,1,'2023-03-31',NULL),(6,3,41,1,'2023-03-31',NULL),(7,3,42,1,'2023-03-30',NULL),(7,3,43,1,'2023-03-30',NULL),(8,3,44,1,'2023-03-29',NULL),(8,3,45,1,'2023-03-29',NULL),(9,3,46,1,'2023-03-28',NULL),(9,3,47,1,'2023-03-28',NULL),(10,3,48,1,'2023-03-27',NULL),(10,3,49,1,'2023-03-27',NULL),(11,3,50,1,'2023-03-26',NULL),(11,3,51,1,'2023-03-26',NULL),(12,3,52,1,'2023-03-25',NULL),(12,3,53,1,'2023-03-25',NULL),(13,3,54,1,'2023-03-24',NULL),(13,3,55,1,'2023-03-24',NULL),(14,3,56,1,'2023-03-23',NULL),(14,3,57,1,'2023-03-23',NULL),(15,3,58,1,'2023-03-22',NULL),(15,3,59,1,'2023-03-22',NULL),(16,3,60,1,'2023-03-21',NULL),(16,3,61,1,'2023-03-21',NULL),(17,3,62,1,'2023-03-20',NULL),(17,3,63,1,'2023-03-20',NULL),(18,3,64,1,'2023-03-19',NULL),(18,3,65,1,'2023-03-19',NULL),(19,3,66,1,'2023-03-18',NULL),(19,3,67,1,'2023-03-18',NULL),(20,3,68,1,'2023-03-17',NULL),(20,3,69,1,'2023-03-17',NULL);
/*!40000 ALTER TABLE ptrole ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ptroletype`
--

DROP TABLE IF EXISTS ptroletype;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE ptroletype (
  roleid tinyint unsigned NOT NULL COMMENT 'Unique role id',
  descr varchar(30) NOT NULL COMMENT 'Role description',
  PRIMARY KEY (roleid),
  UNIQUE KEY roleid_UNIQUE (roleid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='Role types of subjects in subject relations';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ptroletype`
--

LOCK TABLES ptroletype WRITE;
/*!40000 ALTER TABLE ptroletype DISABLE KEYS */;
INSERT INTO ptroletype VALUES (0,'Our company'),(1,'Supplier'),(2,'Customer'),(3,'Employee');
/*!40000 ALTER TABLE ptroletype ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS staff;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE staff (
  empId smallint unsigned NOT NULL AUTO_INCREMENT COMMENT 'Unique worker''s id',
  partyId smallint unsigned NOT NULL COMMENT 'Reference on subject',
  postId smallint unsigned NOT NULL,
  DepartmentId smallint NOT NULL DEFAULT '0',
  state tinyint unsigned NOT NULL COMMENT 'Job state. Active or closed.',
  startDate date NOT NULL,
  endDate date DEFAULT NULL,
  salary decimal(12,2) unsigned NOT NULL,
  PRIMARY KEY (empId),
  UNIQUE KEY empId_UNIQUE (empId),
  KEY staff_idx1 (postId),
  KEY staff_idx2 (partyId),
  CONSTRAINT staff_fk1 FOREIGN KEY (postId) REFERENCES post (Postid),
  CONSTRAINT staff_fk2 FOREIGN KEY (partyId) REFERENCES party (partyid) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COMMENT='Company workers';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES staff WRITE;
/*!40000 ALTER TABLE staff DISABLE KEYS */;
INSERT INTO staff VALUES (1,21,2,3,1,'2021-04-06',NULL,5000.00),(2,22,3,1,1,'2020-04-06',NULL,3000.00),(3,23,4,3,1,'2019-04-06',NULL,2500.00),(4,24,5,2,1,'2018-04-06',NULL,4000.00),(5,25,6,4,1,'2017-04-06',NULL,4000.00),(6,26,7,1,1,'2016-04-06',NULL,2500.00),(7,27,8,10,1,'2015-04-06',NULL,5000.00),(8,28,9,8,1,'2014-04-06',NULL,7500.00),(9,29,10,9,1,'2013-04-06',NULL,5000.00),(10,30,1,3,1,'2022-04-06',NULL,3000.00),(11,31,2,3,1,'2021-04-06',NULL,5000.00);
/*!40000 ALTER TABLE staff ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `suppliers_emp_v`
--

DROP TABLE IF EXISTS suppliers_emp_v;
/*!50001 DROP VIEW IF EXISTS suppliers_emp_v*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `suppliers_emp_v` AS SELECT 
 1 AS counterpartid,
 1 AS ptName,
 1 AS partyid,
 1 AS firstname,
 1 AS lastname,
 1 AS gender,
 1 AS birthdate,
 1 AS country,
 1 AS city,
 1 AS address,
 1 AS phone,
 1 AS email*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `suppliers_v`
--

DROP TABLE IF EXISTS suppliers_v;
/*!50001 DROP VIEW IF EXISTS suppliers_v*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `suppliers_v` AS SELECT 
 1 AS counterpartid,
 1 AS Status,
 1 AS startdate,
 1 AS ptName,
 1 AS country,
 1 AS city,
 1 AS address,
 1 AS phone,
 1 AS email*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `timesheet`
--

DROP TABLE IF EXISTS timesheet;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE timesheet (
  empid smallint unsigned NOT NULL COMMENT 'Employee id',
  startdate date NOT NULL,
  enddate date NOT NULL,
  state tinyint unsigned NOT NULL COMMENT 'worker''s status for this period',
  KEY timesheet_fk1_idx (empid),
  CONSTRAINT timesheet_fk1 FOREIGN KEY (empid) REFERENCES staff (empId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='Simplified form of personfl workig calendar (timesheet)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timesheet`
--

LOCK TABLES timesheet WRITE;
/*!40000 ALTER TABLE timesheet DISABLE KEYS */;
INSERT INTO timesheet VALUES (1,'2023-03-01','2023-03-31',1),(1,'2023-02-01','2023-02-28',1),(2,'2023-03-01','2023-03-31',1),(2,'2023-02-01','2023-02-28',2),(3,'2023-03-01','2023-03-31',1),(3,'2023-02-01','2023-02-28',4),(4,'2023-03-01','2023-03-31',1),(4,'2023-02-01','2023-02-28',2),(5,'2023-03-01','2023-03-31',1),(5,'2023-02-01','2023-02-28',4),(6,'2023-03-01','2023-03-31',1),(6,'2023-02-01','2023-02-28',2),(7,'2023-03-01','2023-03-31',1),(7,'2023-02-01','2023-02-28',4),(8,'2023-03-01','2023-03-31',1),(8,'2023-02-01','2023-02-28',1),(9,'2023-03-01','2023-03-31',1),(9,'2023-02-01','2023-02-28',4),(10,'2023-03-01','2023-03-31',1),(10,'2023-02-01','2023-02-28',1),(11,'2023-03-01','2023-03-31',1),(11,'2023-02-01','2023-02-28',1);
/*!40000 ALTER TABLE timesheet ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'warehouse'
--
/*!50003 DROP FUNCTION IF EXISTS getDirVal */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost FUNCTION getDirVal(dirid_ smallint, valid_ smallint) RETURNS varchar(20) CHARSET utf8mb3
    READS SQL DATA
BEGIN
	declare retval varchar(20);
    
	select d.value
    into retval 
    from dirs d
    where d.dirid = dirid_ AND d.valid = valid_;
  
    SET retval = IFNULL(retval, '?');
    
	RETURN retval;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS GetSelfId */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost FUNCTION GetSelfId() RETURNS int
    READS SQL DATA
BEGIN
	declare selfId smallint default 0;
    
	select r.partyid
    into selfid
    from ptrole r
    where r.roleid = 0;
    
	RETURN selfid;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `customers_emp_v`
--

/*!50001 DROP VIEW IF EXISTS customers_emp_v*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=root@localhost SQL SECURITY DEFINER */
/*!50001 VIEW customers_emp_v AS select r.counterpartid AS counterpartid,p.ptname AS ptName,ps.partyid AS partyid,ps.FirstName AS firstname,ps.LastName AS lastname,GETDIRVAL(2,ps.Gender) AS gender,ps.BirthDate AS birthdate,c.country AS country,c.city AS city,c.address AS address,c.phone AS phone,c.email AS email from ((((ptrole r join party p on((p.partyid = r.counterpartid))) left join ptrole re on(((re.partyid = p.partyid) and (re.roleid = 3) and (re.state = 1)))) left join person ps on((ps.partyid = re.counterpartid))) left join contact c on((c.partyid = ps.partyid))) where ((r.partyid = GETSELFID()) and (r.roleid = 2) and (r.state = 1)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `customers_v`
--

/*!50001 DROP VIEW IF EXISTS customers_v*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=root@localhost SQL SECURITY DEFINER */
/*!50001 VIEW customers_v AS select r.counterpartid AS counterpartid,getDirVal(1,r.state) AS State,r.startdate AS startdate,p.ptname AS ptName,c.country AS country,c.city AS city,c.address AS address,c.phone AS phone,c.email AS email from ((ptrole r join party p on((p.partyid = r.counterpartid))) join contact c on((c.partyid = p.partyid))) where ((r.partyid = GETSELFID()) and (r.roleid = 2) and (r.state = 1)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `deps_emp_v`
--

/*!50001 DROP VIEW IF EXISTS deps_emp_v*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=root@localhost SQL SECURITY DEFINER */
/*!50001 VIEW deps_emp_v AS select d.DepartmentName AS DepartmentName,count(s.empId) OVER (PARTITION BY s.DepartmentId )  AS `КількісьСпівр`,ps.FirstName AS FirstName,ps.LastName AS LastName,p.Postname AS `Посада` from (((department d left join staff s on((s.DepartmentId = d.DepartmentId))) left join post p on((p.Postid = s.postId))) left join person ps on((ps.partyid = s.partyId))) order by d.DepartmentId */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `emp_pr_v`
--

/*!50001 DROP VIEW IF EXISTS emp_pr_v*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=root@localhost SQL SECURITY DEFINER */
/*!50001 VIEW emp_pr_v AS select s.empId AS empId,prs.FirstName AS firstname,prs.LastName AS lastname,ps.Postname AS postName,GETDIRVAL(1,s.state) AS EmpState,ts.startdate AS startdate,ts.enddate AS enddate,d1.`value` AS PeriodStare,pr.salary AS salary from (((((staff s join post ps on((ps.Postid = s.postId))) join person prs on((prs.partyid = s.partyId))) left join timesheet ts on((ts.empid = s.empId))) left join dirs d1 on(((d1.dirid = 3) and (d1.valid = ts.state)))) left join payroll pr on(((pr.empid = ts.empid) and (pr.startdate = ts.startdate) and (pr.enddate = ts.enddate)))) where (s.state = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `emp_ts_v`
--

/*!50001 DROP VIEW IF EXISTS emp_ts_v*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=root@localhost SQL SECURITY DEFINER */
/*!50001 VIEW emp_ts_v AS select s.empId AS empId,prs.FirstName AS firstname,prs.LastName AS lastname,ps.Postname AS postName,GETDIRVAL(1,s.state) AS state,ts.startdate AS startdate,ts.enddate AS enddate,d1.`value` AS `value` from ((((staff s join post ps on((ps.Postid = s.postId))) join person prs on((prs.partyid = s.partyId))) left join timesheet ts on((ts.empid = s.empId))) left join dirs d1 on(((d1.dirid = 3) and (d1.valid = ts.state)))) where (s.state = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `employees_v`
--

/*!50001 DROP VIEW IF EXISTS employees_v*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=root@localhost SQL SECURITY DEFINER */
/*!50001 VIEW employees_v AS select s.partyId AS partyid,s.empId AS empid,pr.FirstName AS firstname,pr.LastName AS lastname,GETDIRVAL(2,pr.Gender) AS gender,pr.BirthDate AS birthdate,ps.Postname AS postname,GETDIRVAL(1,s.state) AS state,s.startDate AS startdate,s.salary AS salary,c.country AS country,c.city AS city,c.address AS address,c.phone AS phone,c.email AS email from ((((staff s join person pr on((pr.partyid = s.partyId))) join post ps on((ps.Postid = s.postId))) join party p on((p.partyid = s.partyId))) join contact c on((c.partyid = p.partyid))) where (s.state = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `suppliers_emp_v`
--

/*!50001 DROP VIEW IF EXISTS suppliers_emp_v*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=root@localhost SQL SECURITY DEFINER */
/*!50001 VIEW suppliers_emp_v AS select r.counterpartid AS counterpartid,p.ptname AS ptName,ps.partyid AS partyid,ps.FirstName AS firstname,ps.LastName AS lastname,GETDIRVAL(2,ps.Gender) AS gender,ps.BirthDate AS birthdate,c.country AS country,c.city AS city,c.address AS address,c.phone AS phone,c.email AS email from ((((ptrole r join party p on((p.partyid = r.counterpartid))) left join ptrole re on(((re.partyid = p.partyid) and (re.roleid = 3) and (re.state = 1)))) left join person ps on((ps.partyid = re.counterpartid))) left join contact c on((c.partyid = ps.partyid))) where ((r.partyid = GETSELFID()) and (r.roleid = 1) and (r.state = 1)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `suppliers_v`
--

/*!50001 DROP VIEW IF EXISTS suppliers_v*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=root@localhost SQL SECURITY DEFINER */
/*!50001 VIEW suppliers_v AS select r.counterpartid AS counterpartid,getDirVal(1,r.state) AS `Status`,r.startdate AS startdate,p.ptname AS ptName,c.country AS country,c.city AS city,c.address AS address,c.phone AS phone,c.email AS email from ((ptrole r join party p on((p.partyid = r.counterpartid))) join contact c on((c.partyid = p.partyid))) where ((r.partyid = GETSELFID()) and (r.roleid = 1) and (r.state = 1)) */;
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

-- Dump completed on 2023-04-08  2:13:15
