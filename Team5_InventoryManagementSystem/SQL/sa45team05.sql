CREATE DATABASE  IF NOT EXISTS `sa45team05` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sa45team05`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: sa45team05
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `orderDate` date NOT NULL,
  `userId` varchar(30) NOT NULL,
  `supplierId` int(11) NOT NULL,
  PRIMARY KEY (`orderId`),
  UNIQUE KEY `orderId_UNIQUE` (`orderId`),
  KEY `userId_idx` (`userId`),
  KEY `supplierId_idx` (`supplierId`),
  CONSTRAINT `orderSupplierId` FOREIGN KEY (`supplierId`) REFERENCES `supplier` (`supplierId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `orderUserId` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderdetail` (
  `orderId` int(11) NOT NULL,
  `partNo` varchar(20) NOT NULL,
  `orderQty` int(11) NOT NULL,
  PRIMARY KEY (`orderId`,`partNo`),
  KEY `orderPartId_idx` (`partNo`),
  CONSTRAINT `orderId` FOREIGN KEY (`orderId`) REFERENCES `order` (`orderId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `orderPartNo` FOREIGN KEY (`partNo`) REFERENCES `product` (`partNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `partNo` varchar(20) NOT NULL,
  `carDealer` varchar(45) DEFAULT NULL,
  `partDescription` varchar(80) DEFAULT NULL,
  `availableQty` int(11) NOT NULL,
  `color` varchar(20) DEFAULT NULL,
  `dimension` varchar(30) DEFAULT NULL,
  `reorderLevel` int(11) NOT NULL,
  `shelfLocation` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`partNo`),
  UNIQUE KEY `PartNo_UNIQUE` (`partNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('01234-01','Toyota','fender',15,'black','23 (h) x 24 (w)',10,'B002-023'),('01234-02','Toyota','fender',12,'blue','23 (h) x 24 (w)',10,'B002-025'),('01234-03','Toyota','fender',10,'yellow','23 (h) x 24 (w) ',10,'B002-024'),('01236MNHL','Mini Cooper','headlight',9,'clear','21 (h) x 16 (w)',10,'B004-123'),('02367VW-B03','Volkswagon','fender',16,'blue-green','24 (h) x 24 (w)',10,'B002-034'),('21566VW-B01','Volkswagon','fender',15,'blue','25 (h) x 26 (w)',10,'B003-025'),('2345HB-BLK','Hyundai',NULL,0,NULL,NULL,0,NULL),('2345HB-SIL','Hyundai','hub cap',23,'silver','4\" (d)',15,'C004-022'),('2458HB-SIL','Hyundai','hub cap ',9,'silver','6\" (d)',10,'C005-025'),('2460HC-SIL','Hyundai','hub cap',6,'silver','10\" (d)',10,'C006-034'),('CB03VW','Volkswagon','bumper',12,'silver','25 (h) x 26 (w)',10,'D003-022'),('CD022VWK','Volkswagon','headlight',5,'clear','21 (h) x 23 (w)',8,'B001-120'),('MN0234B-SIL','Mini Cooper','bumper',10,'silver','25 (h) x 26 (w)',8,'B003-120');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productsupplier`
--

DROP TABLE IF EXISTS `productsupplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productsupplier` (
  `partNo` varchar(20) NOT NULL,
  `supplierId` int(11) NOT NULL,
  `unitPrice` double NOT NULL,
  `minimumReorderQty` int(11) NOT NULL,
  PRIMARY KEY (`partNo`,`supplierId`),
  KEY `supplierId_idx` (`supplierId`),
  CONSTRAINT `ProductPartNo` FOREIGN KEY (`partNo`) REFERENCES `product` (`partNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ProductSupplierId` FOREIGN KEY (`supplierId`) REFERENCES `supplier` (`supplierId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productsupplier`
--

LOCK TABLES `productsupplier` WRITE;
/*!40000 ALTER TABLE `productsupplier` DISABLE KEYS */;
INSERT INTO `productsupplier` VALUES ('01234-01',2,15,15),('01234-01',7,10,25),('01234-02',2,17,15),('01234-02',3,16,16),('01234-02',4,15,20),('01234-03',2,15,15),('01236MNHL',4,20,30),('02367VW-B03',7,20,20),('21566VW-B01',6,56,10),('21566VW-B01',7,50,15),('2345HB-BLK',5,14,18),('2345HB-SIL',4,16,15),('2345HB-SIL',5,14,18),('2458HB-SIL',1,23,10),('2460HC-SIL',1,24,15),('CB03VW',6,25,10),('CD022VWK',5,12,15),('MN0234B-SIL',2,19,50),('MN0234B-SIL',4,13,20);
/*!40000 ALTER TABLE `productsupplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return`
--

DROP TABLE IF EXISTS `return`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `return` (
  `returnId` int(11) NOT NULL AUTO_INCREMENT,
  `partNo` varchar(20) NOT NULL,
  `returnQty` int(11) NOT NULL,
  `returnDate` date NOT NULL,
  PRIMARY KEY (`returnId`),
  UNIQUE KEY `returnId_UNIQUE` (`returnId`),
  KEY `partNo_idx` (`partNo`),
  CONSTRAINT `partNo` FOREIGN KEY (`partNo`) REFERENCES `product` (`partNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return`
--

LOCK TABLES `return` WRITE;
/*!40000 ALTER TABLE `return` DISABLE KEYS */;
INSERT INTO `return` VALUES (1,'2345HB-SIL',2,'2017-02-23'),(2,'MN0234B-SIL',4,'2017-02-26');
/*!40000 ALTER TABLE `return` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `supplierId` int(11) NOT NULL AUTO_INCREMENT,
  `supplierName` varchar(50) NOT NULL,
  `supplierContactNo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`supplierId`),
  UNIQUE KEY `supplierId_UNIQUE` (`supplierId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'L.Mix Industries','92341524'),(2,'CL Autos','22913701'),(3,'Demi.L Spare Parts','64823321'),(4,'David G. Service & N.M Auto Parts','24331161'),(5,'Karmin Autos Accessories','45829352'),(6,'Charli XCX Supplier Co.','34455352'),(7,'R.Paul Autos Industries','31981417');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `transactionId` int(11) NOT NULL AUTO_INCREMENT,
  `transactionDate` date NOT NULL,
  `userId` varchar(30) NOT NULL,
  `customerName` varchar(50) NOT NULL,
  PRIMARY KEY (`transactionId`),
  UNIQUE KEY `transactionId_UNIQUE` (`transactionId`),
  KEY `userId_idx` (`userId`),
  CONSTRAINT `transactionUserId` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,'2017-02-23','runzz23','Mdm. Zanne'),(2,'2017-02-23','kk234','I.M.Sam'),(3,'2017-02-25','runzz23','Esma Samanda'),(4,'2017-02-26','sunm23',' HRH Magical Princess'),(5,'2017-02-27','kk234','JorJor'),(6,'2017-02-28','sunm23','Edwin');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactiondetail`
--

DROP TABLE IF EXISTS `transactiondetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactiondetail` (
  `transactionId` int(11) NOT NULL,
  `partNo` varchar(20) NOT NULL,
  `transactionQty` int(11) NOT NULL,
  PRIMARY KEY (`transactionId`,`partNo`),
  KEY `TransactionPartNo_idx` (`partNo`),
  CONSTRAINT `TransactionPartNo` FOREIGN KEY (`partNo`) REFERENCES `product` (`partNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `transactionId` FOREIGN KEY (`transactionId`) REFERENCES `transaction` (`transactionId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactiondetail`
--

LOCK TABLES `transactiondetail` WRITE;
/*!40000 ALTER TABLE `transactiondetail` DISABLE KEYS */;
INSERT INTO `transactiondetail` VALUES (1,'01234-01',3),(1,'MN0234B-SIL',1),(2,'01236MNHL',2),(3,'01234-01',2),(3,'MN0234B-SIL',3),(4,'CD022VWK',2),(5,'21566VW-B01',1),(5,'2460HC-SIL',2),(6,'MN0234B-SIL',3);
/*!40000 ALTER TABLE `transactiondetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` varchar(30) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `userRole` varchar(15) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userId_UNIQUE` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('kk234','Kiruthika','234kk','mechanic'),('momozzz','Momo','momo222','administrator'),('runzz23','Runze','pa55w0rd','mechanic'),('sunm23','Sun Ming','sming23','mechanic'),('yimonz','Yimon Soe','password','administrator');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-09 19:08:47
