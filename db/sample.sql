-- MariaDB dump 10.18  Distrib 10.5.8-MariaDB, for osx10.16 (x86_64)
--
-- Host: localhost    Database: general_reading_system
-- ------------------------------------------------------
-- Server version	10.5.8-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account_book_index`
--

DROP TABLE IF EXISTS `account_book_index`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_book_index` (
  `id` varchar(128) NOT NULL,
  `account_id` varchar(128) NOT NULL,
  `book_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_book_index`
--

LOCK TABLES `account_book_index` WRITE;
/*!40000 ALTER TABLE `account_book_index` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_book_index` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_user`
--

DROP TABLE IF EXISTS `account_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_user` (
  `id` varchar(128) NOT NULL,
  `user_name` varchar(64) DEFAULT NULL,
  `user_certification` varchar(1024) DEFAULT NULL,
  `user_type` varchar(8) DEFAULT NULL,
  `user_security_key` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_user`
--

LOCK TABLES `account_user` WRITE;
/*!40000 ALTER TABLE `account_user` DISABLE KEYS */;
INSERT INTO `account_user` VALUES ('10000','Shuheng Zhang',NULL,'admin',NULL);
/*!40000 ALTER TABLE `account_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_bookmark_index`
--

DROP TABLE IF EXISTS `book_bookmark_index`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_bookmark_index` (
  `id` varchar(128) NOT NULL,
  `book_id` varchar(128) DEFAULT NULL,
  `bookmark_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_bookmark_index`
--

LOCK TABLES `book_bookmark_index` WRITE;
/*!40000 ALTER TABLE `book_bookmark_index` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_bookmark_index` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_config_index`
--

DROP TABLE IF EXISTS `book_config_index`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_config_index` (
  `id` varchar(128) NOT NULL,
  `book_id` varchar(128) DEFAULT NULL,
  `config_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_config_index`
--

LOCK TABLES `book_config_index` WRITE;
/*!40000 ALTER TABLE `book_config_index` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_config_index` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_progress_index`
--

DROP TABLE IF EXISTS `book_progress_index`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_progress_index` (
  `id` varchar(128) NOT NULL,
  `book_id` varchar(128) DEFAULT NULL,
  `progress_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_progress_index`
--

LOCK TABLES `book_progress_index` WRITE;
/*!40000 ALTER TABLE `book_progress_index` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_progress_index` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `general_book`
--

DROP TABLE IF EXISTS `general_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `general_book` (
  `id` varchar(128) NOT NULL,
  `book_title` varchar(512) DEFAULT NULL,
  `book_authors` varchar(512) DEFAULT NULL,
  `book_description` longtext DEFAULT NULL,
  `book_cover_url` longtext DEFAULT NULL,
  `book_size` varchar(32) DEFAULT NULL,
  `book_pushed_time` varchar(32) DEFAULT NULL,
  `book_file_url` longtext DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `general_book`
--

LOCK TABLES `general_book` WRITE;
/*!40000 ALTER TABLE `general_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `general_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `general_bookmark`
--

DROP TABLE IF EXISTS `general_bookmark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `general_bookmark` (
  `id` varchar(128) NOT NULL,
  `bookmark_title` varchar(64) DEFAULT NULL,
  `bookmark_created_time` varchar(32) DEFAULT NULL,
  `bookmark_location_index` longtext DEFAULT NULL,
  `bookmark_location_content` longtext DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `general_bookmark`
--

LOCK TABLES `general_bookmark` WRITE;
/*!40000 ALTER TABLE `general_bookmark` DISABLE KEYS */;
/*!40000 ALTER TABLE `general_bookmark` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `general_reading_config`
--

DROP TABLE IF EXISTS `general_reading_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `general_reading_config` (
  `id` varchar(128) NOT NULL,
  `config_font_family` varchar(32) DEFAULT NULL,
  `config_font_size` varchar(32) DEFAULT NULL,
  `config_font_style` varchar(32) DEFAULT NULL,
  `config_theme` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `general_reading_config`
--

LOCK TABLES `general_reading_config` WRITE;
/*!40000 ALTER TABLE `general_reading_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `general_reading_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `general_reading_progress`
--

DROP TABLE IF EXISTS `general_reading_progress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `general_reading_progress` (
  `id` varchar(128) NOT NULL,
  `progress_title` varchar(64) DEFAULT NULL,
  `progress_location_index` longtext DEFAULT NULL,
  `progress_location_content` longtext DEFAULT NULL,
  `progress_created_time` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `general_reading_progress`
--

LOCK TABLES `general_reading_progress` WRITE;
/*!40000 ALTER TABLE `general_reading_progress` DISABLE KEYS */;
/*!40000 ALTER TABLE `general_reading_progress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'general_reading_system'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-01 23:06:38
