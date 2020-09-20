-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: servicecalldb
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `audit_log`
--

DROP TABLE IF EXISTS `audit_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `audit_log` (
  `id_service_call` int NOT NULL,
  `account_no` int DEFAULT NULL,
  `account_no_receive` int DEFAULT NULL,
  `account_no_send` int DEFAULT NULL,
  `service_type` varchar(255) DEFAULT NULL,
  `timestamp` datetime(6) DEFAULT NULL,
  `transfer_amount` double DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id_service_call`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_log`
--

LOCK TABLES `audit_log` WRITE;
/*!40000 ALTER TABLE `audit_log` DISABLE KEYS */;
INSERT INTO `audit_log` VALUES (19,NULL,456456456,12123123,'fundTransferOther',NULL,500,NULL),(20,NULL,456456456,123123123,'fundTransferOther',NULL,500,NULL),(21,NULL,456456456,123123123,'fundTransferOther','2020-09-20 23:37:20.673000',500,NULL),(22,NULL,456456456,123123123,'fundTransferOther','2020-09-20 23:47:54.545000',500,111),(23,NULL,456456456,123123123,'fundTransferOther','2020-09-20 23:54:52.009000',500,111),(24,NULL,456456456,123123123,'fundTransferOwn','2020-09-20 23:55:13.270000',500,111),(25,NULL,456456456,123123123,'fundTransferOwn','2020-09-20 23:59:39.181000',500,111),(26,123123123,NULL,NULL,'getAccount','2020-09-20 23:59:49.443000',NULL,111),(27,123123123,NULL,NULL,'getAccountBalance','2020-09-21 00:00:29.706000',NULL,NULL),(28,NULL,NULL,NULL,'getTotalAccountBalance','2020-09-21 00:01:05.198000',NULL,NULL),(29,NULL,NULL,NULL,'getTotalAccountBalance','2020-09-21 00:02:47.550000',NULL,NULL),(30,NULL,NULL,NULL,'getTotalAccountBalance','2020-09-21 00:03:57.484000',NULL,NULL),(31,123123123,NULL,NULL,'getAccountBalance','2020-09-21 00:04:08.509000',NULL,NULL),(32,123123123,NULL,NULL,'getAccount','2020-09-21 00:04:21.851000',NULL,111);
/*!40000 ALTER TABLE `audit_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (33);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_call`
--

DROP TABLE IF EXISTS `service_call`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_call` (
  `id_service_call` int NOT NULL,
  `account_no` int DEFAULT NULL,
  `account_no_receive` int DEFAULT NULL,
  `account_no_send` int DEFAULT NULL,
  `service_type` varchar(255) DEFAULT NULL,
  `transfer_amount` double DEFAULT NULL,
  PRIMARY KEY (`id_service_call`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_call`
--

LOCK TABLES `service_call` WRITE;
/*!40000 ALTER TABLE `service_call` DISABLE KEYS */;
INSERT INTO `service_call` VALUES (1,123123123,NULL,NULL,NULL,NULL),(2,123123123,NULL,NULL,NULL,NULL),(3,123123123,NULL,NULL,'getAccount',NULL),(4,NULL,456456456,123123123,'fundTransferOwn',500),(5,NULL,456456456,123123123,'fundTransferOwn',500),(6,123123123,NULL,NULL,'getAccount',NULL),(7,123123123,NULL,NULL,'getAccountBalance',NULL),(8,123123123,NULL,NULL,'getAccount',NULL),(9,NULL,NULL,NULL,'getTotalAccountBalance',NULL),(10,123123123,NULL,NULL,'getAccount',NULL),(11,123123123,NULL,NULL,'getAccount',NULL),(12,NULL,456456456,123123123,'fundTransferOwn',500),(13,NULL,456456456,12312312,'fundTransferOwn',500),(14,NULL,456456456,12312312,'fundTransferOwn',500),(15,NULL,789789789,123123123,'fundTransferOwn',500),(16,123123123,NULL,NULL,'getAccount',NULL),(17,NULL,456456456,123123123,'fundTransferOther',500),(18,NULL,456456456,12123123,'fundTransferOther',500);
/*!40000 ALTER TABLE `service_call` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicecall`
--

DROP TABLE IF EXISTS `servicecall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicecall` (
  `idServiceCall` int NOT NULL AUTO_INCREMENT,
  `serviceType` varchar(45) DEFAULT NULL,
  `accountNo` int DEFAULT NULL,
  `accountNoSend` int DEFAULT NULL,
  `accountNoReceive` int DEFAULT NULL,
  `transferAmount` double DEFAULT NULL,
  PRIMARY KEY (`idServiceCall`),
  UNIQUE KEY `idServiceCall_UNIQUE` (`idServiceCall`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicecall`
--

LOCK TABLES `servicecall` WRITE;
/*!40000 ALTER TABLE `servicecall` DISABLE KEYS */;
/*!40000 ALTER TABLE `servicecall` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-21  2:27:49
