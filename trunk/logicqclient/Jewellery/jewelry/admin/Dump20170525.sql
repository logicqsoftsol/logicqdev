-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: jewellery
-- ------------------------------------------------------
-- Server version	5.7.14

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
-- Table structure for table `catagory_details`
--

DROP TABLE IF EXISTS `catagory_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `catagory_details` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(200) NOT NULL,
  `DISPLAYNAME` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catagory_details`
--

LOCK TABLES `catagory_details` WRITE;
/*!40000 ALTER TABLE `catagory_details` DISABLE KEYS */;
INSERT INTO `catagory_details` VALUES (1,'Gold','GOLD'),(2,'Silver','SILVER'),(3,'diamond','DIAMOND');
/*!40000 ALTER TABLE `catagory_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gold rate`
--

DROP TABLE IF EXISTS `gold rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gold rate` (
  `gold_matid` int(11) NOT NULL,
  `gold_mattype` varchar(100) NOT NULL,
  `gold_rate_pergm` decimal(65,0) NOT NULL,
  PRIMARY KEY (`gold_matid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='Update Gold Rate';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gold rate`
--

LOCK TABLES `gold rate` WRITE;
/*!40000 ALTER TABLE `gold rate` DISABLE KEYS */;
INSERT INTO `gold rate` VALUES (1001,'Platinum',3350),(1002,'Silver',40),(1003,'Silver Bar',42),(1004,'Gold 24C 999',2900),(1005,'Gold 24C 995',2850),(1006,'Gold 23C',2805),(1007,'Gold 22C',2750),(1008,'Gold 18C',2720);
/*!40000 ALTER TABLE `gold rate` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`id`),
  KEY `menu_ref` (`displayname`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_details`
--

LOCK TABLES `menu_details` WRITE;
/*!40000 ALTER TABLE `menu_details` DISABLE KEYS */;
INSERT INTO `menu_details` VALUES (1,'gold','mainmenu','GOLD',1,''),(2,'silver','mainmenu','SILVER',1,''),(0,'home','mainmenu','HOME',0,''),(3,'aboutus','mainmenu','ABOUT US',0,''),(4,'contact','mainmenu','CONTACT',0,'');
/*!40000 ALTER TABLE `menu_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `popular_collections`
--

DROP TABLE IF EXISTS `popular_collections`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `popular_collections` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `collection_name` varchar(200) NOT NULL,
  `collection_image` varchar(200) NOT NULL,
  `collection_link` varchar(200) NOT NULL,
  `product_id` int(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COMMENT='popular collections';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `popular_collections`
--

LOCK TABLES `popular_collections` WRITE;
/*!40000 ALTER TABLE `popular_collections` DISABLE KEYS */;
INSERT INTO `popular_collections` VALUES (1,'BRACELETS','assets/images/3_largef441.png','collections/bracelets.html',1),(2,'EARRINGS','assets/images/2_largea971.png','collections/earrings.html',1),(3,'NACKLACES','assets/images/Necklaces.png','collections/nacklaces.html',1),(4,'RINGS','assets/images/4_large6125.png','collections/rings.html',1);
/*!40000 ALTER TABLE `popular_collections` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price_details`
--

DROP TABLE IF EXISTS `price_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price_details` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PRODUCT_ID` bigint(20) NOT NULL,
  `SELL_PRICE` decimal(10,2) DEFAULT NULL,
  `VENDOR_PRICE` decimal(10,0) NOT NULL,
  `MRP_PRICE` decimal(10,2) DEFAULT NULL,
  `HM_TAG_PRICE` decimal(10,2) DEFAULT NULL,
  `MAKING_PRICE` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `PRODUCT_ID` (`PRODUCT_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_details`
--

LOCK TABLES `price_details` WRITE;
/*!40000 ALTER TABLE `price_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `price_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prod_desc_details`
--

DROP TABLE IF EXISTS `prod_desc_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prod_desc_details` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PRODUCT_ID` bigint(20) NOT NULL,
  `DESC_TEXT` varchar(200) DEFAULT NULL,
  `DEGN_STYLE` varchar(200) NOT NULL,
  `AVAL_COLOR` varchar(100) NOT NULL,
  `APPLICABLE_GENDER` varchar(200) NOT NULL,
  `DESIGN_DESC` varchar(200) DEFAULT NULL,
  `TECHNICAL_SPEC` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `PRODUCT_ID` (`PRODUCT_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prod_desc_details`
--

LOCK TABLES `prod_desc_details` WRITE;
/*!40000 ALTER TABLE `prod_desc_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `prod_desc_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prod_document_details`
--

DROP TABLE IF EXISTS `prod_document_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prod_document_details` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PRODUCT_ID` bigint(20) NOT NULL,
  `IMAGE` varchar(200) NOT NULL,
  `RIGHT_IMAGE` varchar(200) DEFAULT NULL,
  `FRONT_IMAGE` varchar(200) DEFAULT NULL,
  `BACK_IMAGE` varchar(200) DEFAULT NULL,
  `LEFT_IMAGE` varchar(200) DEFAULT NULL,
  `OTHER_IMAGE` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `PRODUCT_ID` (`PRODUCT_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prod_document_details`
--

LOCK TABLES `prod_document_details` WRITE;
/*!40000 ALTER TABLE `prod_document_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `prod_document_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_details`
--

DROP TABLE IF EXISTS `product_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_details` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(200) NOT NULL,
  `CATAGORY_ID` bigint(20) NOT NULL,
  `SUB_CATAGORY_ID` bigint(20) NOT NULL,
  `BARCODE` bigint(20) NOT NULL,
  `VENDOR_ID` bigint(20) NOT NULL,
  `COLOR` varchar(200) DEFAULT NULL,
  `SIZE` varchar(200) DEFAULT NULL,
  `PRICE_ID` bigint(20) NOT NULL,
  `QUANTITY_ID` bigint(20) NOT NULL,
  `DOCUMENT_ID` bigint(20) NOT NULL,
  `DESCRIPTION_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `VENDOR_ID` (`VENDOR_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_details`
--

LOCK TABLES `product_details` WRITE;
/*!40000 ALTER TABLE `product_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quantity_details`
--

DROP TABLE IF EXISTS `quantity_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quantity_details` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PRODUCT_ID` bigint(20) NOT NULL,
  `PRODUCT_QUANTITY_TYPE` varchar(10) DEFAULT NULL,
  `PRODUCT_UNIT_TYPE` varchar(10) DEFAULT NULL,
  `NET_WT` decimal(10,2) DEFAULT NULL,
  `GROSS_WT` decimal(10,2) DEFAULT NULL,
  `MEENA_WT` decimal(10,2) DEFAULT NULL,
  `WASTAGE` bigint(10) DEFAULT NULL,
  `PURE_WT` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `PRODUCT_ID` (`PRODUCT_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quantity_details`
--

LOCK TABLES `quantity_details` WRITE;
/*!40000 ALTER TABLE `quantity_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `quantity_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stone_details`
--

DROP TABLE IF EXISTS `stone_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stone_details` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `QUANTITY_ID` bigint(20) NOT NULL,
  `STONE_WT` decimal(10,2) DEFAULT NULL,
  `STONE_COLOR` varchar(100) DEFAULT NULL,
  `STONE_PCS` bigint(20) DEFAULT NULL,
  `STONE_PRICE` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `QUANTITY_ID` (`QUANTITY_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stone_details`
--

LOCK TABLES `stone_details` WRITE;
/*!40000 ALTER TABLE `stone_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `stone_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_catagory`
--

DROP TABLE IF EXISTS `sub_catagory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub_catagory` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CATAGORY_ID` bigint(20) NOT NULL,
  `NAME` varchar(200) NOT NULL,
  `DISPLAY_NAME` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `CATAGORY_ID` (`CATAGORY_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_catagory`
--

LOCK TABLES `sub_catagory` WRITE;
/*!40000 ALTER TABLE `sub_catagory` DISABLE KEYS */;
INSERT INTO `sub_catagory` VALUES (1,1,'bracelets','BRACELETS'),(2,1,'earrings','EARRINGS'),(3,1,'necklaces','NECKLACES'),(4,1,'rings','RINGS'),(5,1,'mangalsutra','MANGAL SUTRA'),(6,2,'bracelets','BRACELETS'),(7,2,'earrings','EARRINGS'),(8,2,'necklaces','NECKLACES'),(9,2,'silverring','SILVER RINGs'),(10,2,'silverplate','SILVER PLATE');
/*!40000 ALTER TABLE `sub_catagory` ENABLE KEYS */;
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
INSERT INTO `sub_menu_details` VALUES (0,'bracelets','BRACELETS',1,'gold',0,'products/curabitur-cursus-dignis.html'),(1,'earrings','EARRINGS',1,'gold',0,'products/donec-aliquam-ante-non.html'),(2,'necklaces','NECKLACES',1,'gold',0,'products/donec-justo-condimentum.html'),(3,'rings','RINGS',1,'gold',0,'products/gravida-est-quis-euismod.html'),(4,'mangalsutra','MANGAL SUTRA',1,'gold',0,'products/curabitur-cursus-dignis.html'),(5,'bracelets','BRACELETS',2,'silver',1,'products/donec-aliquam-ante-non.html'),(6,'earrings','EARRINGS',2,'silver',1,'products/donec-justo-condimentum.html'),(7,'necklaces','NECKLACES',2,'slver',1,'products/gravida-est-quis-euismod.html'),(8,'silverring','SILVER RINGs',2,'silver',1,'products/SMenu.html'),(9,'silverplate','SILVER PLATE',2,'silver',1,'products/TestMenu1.html');
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
INSERT INTO `sub_menu_header` VALUES (0,'gold','GOLD',1,'gold'),(1,'silver','SILVER',2,'silver');
/*!40000 ALTER TABLE `sub_menu_header` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor_details`
--

DROP TABLE IF EXISTS `vendor_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor_details` (
  `ID` bigint(20) NOT NULL,
  `VENDOR_NAME` varchar(200) NOT NULL,
  `VENDOR_ADDR` varchar(400) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor_details`
--

LOCK TABLES `vendor_details` WRITE;
/*!40000 ALTER TABLE `vendor_details` DISABLE KEYS */;
INSERT INTO `vendor_details` VALUES (14118,'SSL Gold Suppliers','Balesore'),(53635,'SKP Gold & Silver Suppliers','Berhampur');
/*!40000 ALTER TABLE `vendor_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-25 10:31:40
