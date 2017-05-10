-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: jewelry
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.9-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `email` varchar(250) DEFAULT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(150) NOT NULL,
  `fname` varchar(150) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `verification_code` varchar(50) NOT NULL,
  `mobilenumber` varchar(11) NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `login_attempts` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `mobilenumber` (`mobilenumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('admin@gmail.com','admin','admin','ADMIN','ADMIN','74458','',NULL,NULL);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_details`
--

DROP TABLE IF EXISTS `menu_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu_details` (
  `id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` varchar(100) NOT NULL,
  `displayname` varchar(100) NOT NULL,
  `submenulist` int(11) NOT NULL,
  `linkurl` varchar(100) NOT NULL,
  KEY `menu_ref` (`displayname`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_details`
--

LOCK TABLES `menu_details` WRITE;
/*!40000 ALTER TABLE `menu_details` DISABLE KEYS */;
INSERT INTO `menu_details` VALUES (1,'collection','mainmenu','COLLECTION',1,''),(2,'contact','mainmenu','CONTACT',0,''),(0,'home','mainmenu','HOME',0,''),(3,'aboutus','mainmenu','ABOUT US',0,'');
/*!40000 ALTER TABLE `menu_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_menu_details`
--

DROP TABLE IF EXISTS `sub_menu_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub_menu_details` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `displayname` varchar(45) DEFAULT NULL,
  `menu_id` int(11) NOT NULL,
  `menu_name` varchar(45) DEFAULT NULL,
  `sub_menu_header_id` int(11) NOT NULL,
  `linkurl` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_menu_details`
--

LOCK TABLES `sub_menu_details` WRITE;
/*!40000 ALTER TABLE `sub_menu_details` DISABLE KEYS */;
INSERT INTO `sub_menu_details` VALUES (0,'bracelets','BRACELETS',1,'collection',0,'products/curabitur-cursus-dignis.html'),(1,'earrings','EARRINGS',1,'collection',0,'products/donec-aliquam-ante-non.html'),(2,'necklaces','NECKLACES',1,'collection',0,'products/donec-justo-condimentum.html'),(3,'rings','RINGS',1,'collection',0,'products/gravida-est-quis-euismod.html'),(4,'mangalsutra','MANGAL SUTRA',1,'collection',0,'products/curabitur-cursus-dignis.html'),(5,'bracelets','BRACELETS',1,'collection',1,'products/donec-aliquam-ante-non.html'),(6,'earrings','EARRINGS',1,'collection',1,'products/donec-justo-condimentum.html'),(7,'necklaces','NECKLACES',1,'collection',1,'products/gravida-est-quis-euismod.html');
/*!40000 ALTER TABLE `sub_menu_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_menu_header`
--

DROP TABLE IF EXISTS `sub_menu_header`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub_menu_header` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `displayname` varchar(45) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `menu_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_menu_header`
--

LOCK TABLES `sub_menu_header` WRITE;
/*!40000 ALTER TABLE `sub_menu_header` DISABLE KEYS */;
INSERT INTO `sub_menu_header` VALUES (0,'gold','GOLD',1,'collection'),(1,'silver','SILVER',1,'collection'),(2,'diamond','DIAMOND',1,'collection');
/*!40000 ALTER TABLE `sub_menu_header` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-11  3:21:54
