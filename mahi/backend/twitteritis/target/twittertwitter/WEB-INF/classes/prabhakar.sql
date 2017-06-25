-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: springsocial
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

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
-- Table structure for table `Account`
--

DROP TABLE IF EXISTS `Account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Account` (
  `accountId` int(11) NOT NULL AUTO_INCREMENT,
  `accessToken` varchar(100) DEFAULT NULL,
  `accessTokenSecret` varchar(100) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `userForeign` int(11) DEFAULT NULL,
  PRIMARY KEY (`accountId`),
  UNIQUE KEY `unique_index` (`accessToken`,`userForeign`),
  KEY `fk_Account_1_idx` (`userForeign`),
  CONSTRAINT `fk_Account_1` FOREIGN KEY (`userForeign`) REFERENCES `User` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Message`
--

DROP TABLE IF EXISTS `Message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Message` (
  `messageId` int(11) NOT NULL AUTO_INCREMENT,
  `sentToHandle` varchar(45) DEFAULT NULL,
  `mes` varchar(45) DEFAULT NULL,
  `accountForeign` int(11) DEFAULT NULL,
  PRIMARY KEY (`messageId`),
  UNIQUE KEY `messageId_UNIQUE` (`messageId`),
  KEY `fk_Message_1_idx` (`accountForeign`),
  CONSTRAINT `fk_Message_1` FOREIGN KEY (`accountForeign`) REFERENCES `Account` (`accountId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Search`
--

DROP TABLE IF EXISTS `Search`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Search` (
  `idSearch` int(11) NOT NULL AUTO_INCREMENT,
  `query` varchar(45) DEFAULT NULL,
  `accountForeign` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSearch`),
  UNIQUE KEY `idSearch_UNIQUE` (`idSearch`),
  KEY `fk_Search_1_idx` (`accountForeign`),
  CONSTRAINT `fk_Search_1` FOREIGN KEY (`accountForeign`) REFERENCES `Account` (`accountId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Tweets`
--

DROP TABLE IF EXISTS `Tweets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tweets` (
  `idTweet` int(11) NOT NULL AUTO_INCREMENT,
  `tweet` varchar(45) DEFAULT NULL,
  `accountForeign` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTweet`),
  UNIQUE KEY `idTweets_UNIQUE` (`idTweet`),
  KEY `fk_Tweets_1_idx` (`accountForeign`),
  CONSTRAINT `fk_Tweets_1` FOREIGN KEY (`accountForeign`) REFERENCES `Account` (`accountId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `UserProfile`
--

DROP TABLE IF EXISTS `UserProfile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserProfile` (
  `idUserProfile` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `screenName` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `profileImageUrl` varchar(1000) DEFAULT NULL,
  `userUrl` varchar(1000) DEFAULT NULL,
  `twitterId` bigint(45) DEFAULT NULL,
  `followersCount` int(11) DEFAULT NULL,
  `getFriendsCount` int(11) DEFAULT NULL,
  `getFavouritesCount` int(11) DEFAULT NULL,
  `getTimeZone` varchar(45) DEFAULT NULL,
  `getStatusesCount` int(11) DEFAULT NULL,
  `getCreatedAt` date DEFAULT NULL,
  `accountForeign` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUserProfile`),
  UNIQUE KEY `idUserProfile_UNIQUE` (`idUserProfile`),
  KEY `fk_UserProfile_1_idx` (`accountForeign`),
  CONSTRAINT `fk_UserProfile_1` FOREIGN KEY (`accountForeign`) REFERENCES `Account` (`accountId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `masters`
--

DROP TABLE IF EXISTS `masters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `masters` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(250) DEFAULT NULL,
  `value` varchar(250) DEFAULT NULL,
  `type` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-23 15:47:41
