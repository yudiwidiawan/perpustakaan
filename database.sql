-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: perpustakaan
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `_user`
--

DROP TABLE IF EXISTS `_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `_user` (
  `id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('ROLE_ADMIN','ROLE_USER') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_user`
--

LOCK TABLES `_user` WRITE;
/*!40000 ALTER TABLE `_user` DISABLE KEYS */;
INSERT INTO `_user` VALUES (1,'yudiadmin@gmail.com','Yudi','Admin','$2a$10$LBnf9U8r1S8qZCAB3oMG1OjdwfwOiKXnAhdzOVF9BTVnYeW79vRQu','ROLE_ADMIN');
/*!40000 ALTER TABLE `_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `_user_seq`
--

DROP TABLE IF EXISTS `_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_user_seq`
--

LOCK TABLES `_user_seq` WRITE;
/*!40000 ALTER TABLE `_user_seq` DISABLE KEYS */;
INSERT INTO `_user_seq` VALUES (51);
/*!40000 ALTER TABLE `_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `author` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `author_seq`
--

DROP TABLE IF EXISTS `author_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `author_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author_seq`
--

LOCK TABLES `author_seq` WRITE;
/*!40000 ALTER TABLE `author_seq` DISABLE KEYS */;
INSERT INTO `author_seq` VALUES (1);
/*!40000 ALTER TABLE `author_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `author_id` bigint DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `id` bigint NOT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKklnrv3weler2ftkweewlky958` (`author_id`),
  CONSTRAINT `FKklnrv3weler2ftkweewlky958` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (NULL,'2023-06-05 09:32:02.991000',1,'2023-06-05 09:32:02.991000','yudiadmin@gmail.com','string','yudiadmin@gmail.com','string','string');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_borrowers`
--

DROP TABLE IF EXISTS `book_borrowers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_borrowers` (
  `book_id` bigint DEFAULT NULL,
  `borrow_end_date` datetime(6) DEFAULT NULL,
  `borrow_start_date` datetime(6) DEFAULT NULL,
  `date_returned` datetime(6) DEFAULT NULL,
  `id` bigint NOT NULL,
  `recipient_id` bigint DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb7bf9m7pjmjnscg8r72qgd4ti` (`book_id`),
  KEY `FKewdoy63o4m8psii9cm97pvnny` (`recipient_id`),
  CONSTRAINT `FKb7bf9m7pjmjnscg8r72qgd4ti` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FKewdoy63o4m8psii9cm97pvnny` FOREIGN KEY (`recipient_id`) REFERENCES `recipient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_borrowers`
--

LOCK TABLES `book_borrowers` WRITE;
/*!40000 ALTER TABLE `book_borrowers` DISABLE KEYS */;
INSERT INTO `book_borrowers` VALUES (1,'2023-06-05 09:32:33.760000','2023-06-05 09:32:33.760000',NULL,1,1,'BORROWED');
/*!40000 ALTER TABLE `book_borrowers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_borrowers_seq`
--

DROP TABLE IF EXISTS `book_borrowers_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_borrowers_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_borrowers_seq`
--

LOCK TABLES `book_borrowers_seq` WRITE;
/*!40000 ALTER TABLE `book_borrowers_seq` DISABLE KEYS */;
INSERT INTO `book_borrowers_seq` VALUES (51);
/*!40000 ALTER TABLE `book_borrowers_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_publisher`
--

DROP TABLE IF EXISTS `book_publisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_publisher` (
  `book_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL,
  `publisher_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8ywuvxfycghsfmxvu363jllpq` (`book_id`),
  KEY `FKnihk8b6sfx2mvtstq87wpjsfu` (`publisher_id`),
  CONSTRAINT `FK8ywuvxfycghsfmxvu363jllpq` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FKnihk8b6sfx2mvtstq87wpjsfu` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_publisher`
--

LOCK TABLES `book_publisher` WRITE;
/*!40000 ALTER TABLE `book_publisher` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_publisher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_publisher_seq`
--

DROP TABLE IF EXISTS `book_publisher_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_publisher_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_publisher_seq`
--

LOCK TABLES `book_publisher_seq` WRITE;
/*!40000 ALTER TABLE `book_publisher_seq` DISABLE KEYS */;
INSERT INTO `book_publisher_seq` VALUES (1);
/*!40000 ALTER TABLE `book_publisher_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_seq`
--

DROP TABLE IF EXISTS `book_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_seq`
--

LOCK TABLES `book_seq` WRITE;
/*!40000 ALTER TABLE `book_seq` DISABLE KEYS */;
INSERT INTO `book_seq` VALUES (51);
/*!40000 ALTER TABLE `book_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisher`
--

DROP TABLE IF EXISTS `publisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publisher` (
  `created_date` datetime(6) DEFAULT NULL,
  `id` bigint NOT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher`
--

LOCK TABLES `publisher` WRITE;
/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;
/*!40000 ALTER TABLE `publisher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisher_seq`
--

DROP TABLE IF EXISTS `publisher_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publisher_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher_seq`
--

LOCK TABLES `publisher_seq` WRITE;
/*!40000 ALTER TABLE `publisher_seq` DISABLE KEYS */;
INSERT INTO `publisher_seq` VALUES (1);
/*!40000 ALTER TABLE `publisher_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipient`
--

DROP TABLE IF EXISTS `recipient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipient` (
  `birth_date` datetime(6) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `home_number` bigint DEFAULT NULL,
  `id` bigint NOT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `phone_number` bigint DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` enum('FEMALE','MALE') DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `sub_district` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipient`
--

LOCK TABLES `recipient` WRITE;
/*!40000 ALTER TABLE `recipient` DISABLE KEYS */;
INSERT INTO `recipient` VALUES (NULL,'2023-06-05 09:32:25.917000',NULL,1,'2023-06-05 09:32:25.917000',NULL,'Jl Teuku Umar Bl FA-3/45, Dki Jakarta','Indonesia','yudiadmin@gmail.com','-','angelinajolie@gmail.com','Angelina','FEMALE','yudiadmin@gmail.com','Voight','Jolie','DKI Jakarta','Jl Teuku Umar Bl FA-3/45, Dki Jakarta','-');
/*!40000 ALTER TABLE `recipient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipient_seq`
--

DROP TABLE IF EXISTS `recipient_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipient_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipient_seq`
--

LOCK TABLES `recipient_seq` WRITE;
/*!40000 ALTER TABLE `recipient_seq` DISABLE KEYS */;
INSERT INTO `recipient_seq` VALUES (51);
/*!40000 ALTER TABLE `recipient_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'perpustakaan'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-05  9:43:33
