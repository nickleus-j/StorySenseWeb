-- MySQL dump 10.13  Distrib 5.5.12, for Win32 (x86)
--
-- Host: localhost    Database: ontology
-- ------------------------------------------------------
-- Server version	5.5.12

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `accountID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) NOT NULL,
  `Password` char(32) DEFAULT NULL,
  `role` int(11) DEFAULT '1',
  `Active` tinyint(1) DEFAULT '1',
  `Points` int(11) DEFAULT '0',
  `Level` int(11) DEFAULT '1',
  PRIMARY KEY (`accountID`),
  UNIQUE KEY `Name_UNIQUE` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'Admin','9f52829cd368a64b4da2511b3560f665',0,1,1,1),(2,'1Kid','2168c5915d5452d864f273c4536d8f9e',1,1,1,1),(3,'Simba','60d28e7d879c0dc48b9a593468cf11e5',1,1,1,1),(4,'Observer','1b65e84b7aa724b3f34c7dede00d439c',2,1,1,1),(5,'nej','1e8e42b87a65326b98ced7d3af717a72',1,1,1,1),(6,'Soap','8ce4b16b22b58894aa86c421e8759df3',1,1,1,1),(7,'DK','2e8d6dbf9112a879d4ceb15403d10a78',1,1,1,1),(8,'CoolJ','b1f4f9a523e36fd969f4573e25af4540',1,1,1,1),(9,'Egoist','37349f07c95879abf625e8e7ae56170c',1,1,1,1),(10,'Egoistic','37349f07c95879abf625e8e7ae56170c',1,1,1,1),(11,'Shakespir','ecae13117d6f0584c25a9da6c8f8415e',1,1,1,1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `achievement`
--

DROP TABLE IF EXISTS `achievement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `achievement` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(75) NOT NULL,
  `Decription` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `achievement`
--

LOCK TABLES `achievement` WRITE;
/*!40000 ALTER TABLE `achievement` DISABLE KEYS */;
/*!40000 ALTER TABLE `achievement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concept`
--

DROP TABLE IF EXISTS `concept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `concept` (
  `ConceptID` int(11) NOT NULL AUTO_INCREMENT,
  `Word_phrase` tinytext,
  PRIMARY KEY (`ConceptID`)
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concept`
--

LOCK TABLES `concept` WRITE;
/*!40000 ALTER TABLE `concept` DISABLE KEYS */;
INSERT INTO `concept` VALUES (1,'happy'),(2,'person'),(3,'game'),(4,'animal'),(5,'Emotion'),(6,'Day'),(7,'Object'),(8,'Playing'),(9,'well'),(10,'house'),(11,'black'),(12,'rectangle'),(13,'find'),(14,'location'),(15,'Smiling'),(16,'running'),(17,'glad'),(18,'beach'),(19,'red'),(20,'cylyndrical'),(21,'hold'),(22,'grey'),(23,'marble'),(24,'remembering'),(25,'rough'),(26,'stone'),(27,'expensive'),(28,'chair'),(29,'rest'),(30,'park'),(31,'Jump'),(32,'hopping'),(33,'cheerful'),(34,'sidewalk'),(35,'green'),(36,'round'),(37,'get'),(38,'brown'),(39,'rock'),(40,'elegant'),(41,'fence'),(42,'walk'),(43,'zoo'),(44,'sand'),(45,'surfing'),(46,'hut'),(47,'Niccolo'),(48,'warm'),(49,'mad'),(50,'barbershop'),(51,'PS3'),(52,'Frown'),(53,'hurt'),(54,'angry'),(55,'dump'),(56,'blue'),(57,'have'),(58,''),(59,'trouble'),(60,'pout'),(61,'smile'),(62,'box'),(63,'walking'),(64,'shower room'),(65,'high grades'),(66,'resting'),(67,'caring'),(68,'note'),(69,'standing'),(70,'shaving'),(71,'text'),(72,'nurturing'),(73,'wire'),(74,'working'),(75,'cutting'),(76,'controller'),(77,'employee'),(78,'health'),(79,'sprint'),(80,'twig'),(81,'fine'),(82,'loved'),(83,'encourage'),(84,'light'),(85,'plastic'),(86,'poster'),(87,'skating'),(88,'pound'),(89,'pain'),(90,'dove'),(91,'chill'),(92,'yard'),(93,NULL),(94,'waiting'),(95,'work'),(96,'flower'),(97,'puppet'),(98,'sitting'),(99,'school'),(100,'nurse'),(101,'cramps'),(102,'eating'),(103,'diplomat'),(104,'preaching'),(105,'writting'),(106,'pan'),(107,'hall'),(108,'Dirk'),(109,'pleasant'),(110,'shocked'),(111,'smartphone'),(112,'shell'),(113,'Simba'),(114,'paranoid'),(115,'bench area'),(116,'show'),(117,'notebook'),(118,'learning'),(119,'shop'),(120,'look'),(121,'scared'),(122,'agitated'),(123,'cylindrical'),(124,'life'),(125,'tired'),(126,'bread'),(127,'stomp'),(128,'troubled'),(129,'lawyer'),(130,'bloodlust'),(131,'laugh'),(132,'waitress'),(133,'headaches'),(134,'display'),(135,'weary'),(136,'sandwhich'),(137,'tourist'),(138,'test tube'),(139,'bin'),(140,'smooth'),(141,'glass'),(142,'negotiate'),(143,'pen'),(144,'bug'),(145,'relaxing'),(146,'understanding'),(147,'stage');
/*!40000 ALTER TABLE `concept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `learnerachievement`
--

DROP TABLE IF EXISTS `learnerachievement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `learnerachievement` (
  `AchievementID` int(11) NOT NULL,
  `learnerID` int(11) DEFAULT NULL,
  KEY `AchievementRef` (`AchievementID`),
  KEY `learnerAchievement` (`learnerID`),
  CONSTRAINT `AchievementRef` FOREIGN KEY (`AchievementID`) REFERENCES `achievement` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `learnerAchievement` FOREIGN KEY (`learnerID`) REFERENCES `account` (`accountID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `learnerachievement`
--

LOCK TABLES `learnerachievement` WRITE;
/*!40000 ALTER TABLE `learnerachievement` DISABLE KEYS */;
/*!40000 ALTER TABLE `learnerachievement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likedstory`
--

DROP TABLE IF EXISTS `likedstory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `likedstory` (
  `userID` int(11) NOT NULL DEFAULT '1',
  `storyAccomID` int(11) DEFAULT '1',
  `key` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`key`),
  KEY `userLike` (`userID`),
  KEY `likedStory` (`storyAccomID`),
  CONSTRAINT `likedStory` FOREIGN KEY (`storyAccomID`) REFERENCES `storyaccomplishment` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userLike` FOREIGN KEY (`userID`) REFERENCES `account` (`accountID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likedstory`
--

LOCK TABLES `likedstory` WRITE;
/*!40000 ALTER TABLE `likedstory` DISABLE KEYS */;
INSERT INTO `likedstory` VALUES (3,8,1),(7,5,2);
/*!40000 ALTER TABLE `likedstory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profile` (
  `Account` int(11) NOT NULL,
  `picUrl` text,
  `Birthday` date DEFAULT NULL,
  `Firstname` varchar(75) DEFAULT NULL,
  `Surname` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`Account`),
  KEY `profileAccount` (`Account`),
  CONSTRAINT `profileAccount` FOREIGN KEY (`Account`) REFERENCES `account` (`accountID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES (1,'https://lh6.googleusercontent.com/-m9fg-PraoOQ/ToJBwdqN5oI/AAAAAAAAAvY/4MIdYdiGL-4/s900/go_on.png','2004-05-14','Unang','Bata'),(2,'https://lh5.googleusercontent.com/-5bWTfwJ0sGc/ToJBrESx7uI/AAAAAAAAAvU/ejJFyHQr3S4/s379/new-n.png','2006-03-07','Ronald','Makata'),(3,'https://lh5.googleusercontent.com/-2vDGOCmN6Oc/TsTlO4YsV5I/AAAAAAAAAyU/I0aqImK3Ch4/s700/Bg1.jpg','2002-04-26','Simba','Lionpride'),(4,'https://lh3.googleusercontent.com/-MrlVW_9Q9SI/ToJBkvamTTI/AAAAAAAAAvQ/qNa3xLCmWXM/w615-h560-p-k/n-eye.png','2003-06-19','Ray','Brighteye'),(5,'https://lh6.googleusercontent.com/-3DGGXrcDeFw/TerHo3ynfGI/AAAAAAAAAr4/Rr6Y7BiIHNM/s425/N-Stamp1.png','2003-02-07','Neji','Hyuga'),(6,'https://lh6.googleusercontent.com/-uUvi-LYD3bI/TnwMpoYHVUI/AAAAAAAAA3E/QY88r8bjcJE/w253-h252-n-k/grass_Field.png','2007-11-02','John','Mactavish'),(7,'https://lh3.googleusercontent.com/-OBoqr4-N46M/SM4frFVUP3I/AAAAAAAAACo/wdwOSRgs-CY/w246-h241-n-k/L.invader%2528deathknight%2529.JPG','2008-03-30','Death','Knight'),(8,'https://lh3.googleusercontent.com/-KwiBwCTn3tQ/SjtI245jGwI/AAAAAAAAAYM/GCWT_ahQ-kE/s700/BeNeat.png','2005-05-31','Jerome','Smith'),(9,'https://lh3.googleusercontent.com/-uGiDJ6FLvB8/SPn4gonP1lI/AAAAAAAAAFc/WLzjMuoYyak/w398-h316-n-k/Biohazard_quake.jpg','2008-09-04','Trenor','Kenway'),(10,'https://lh5.googleusercontent.com/-z04xeOdenEk/SpJL2u8hXAI/AAAAAAAAAdM/8E5si3TpDQw/s335/eye-c.png','2006-08-20','Norm','Dapirdefool'),(11,'https://lh5.googleusercontent.com/--C_MdqzZ4MI/S81DtEy985I/AAAAAAAAAnE/ppopQ19SbKU/s334/Logotemp1.png','2005-10-24','William','Owleye');
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rating` (
  `accomplishmentID` int(11) DEFAULT NULL,
  `readerID` int(11) DEFAULT NULL,
  `Score` int(11) DEFAULT '1',
  KEY `storyRating` (`accomplishmentID`),
  KEY `reader` (`readerID`),
  CONSTRAINT `reader` FOREIGN KEY (`readerID`) REFERENCES `account` (`accountID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `storyRating` FOREIGN KEY (`accomplishmentID`) REFERENCES `storyaccomplishment` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relation`
--

DROP TABLE IF EXISTS `relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relation` (
  `RelationID` int(11) NOT NULL AUTO_INCREMENT,
  `Concept1` varchar(50) DEFAULT NULL,
  `Concept2` varchar(50) DEFAULT NULL,
  `Relationship` varchar(50) DEFAULT NULL,
  `Confidence_percentage` int(11) DEFAULT '50',
  `Total_score` int(11) DEFAULT '1',
  `Times_validated` int(11) DEFAULT '0',
  `Frequency_count` int(11) DEFAULT '1',
  `Is_meaningless` int(11) DEFAULT '1',
  PRIMARY KEY (`RelationID`)
) ENGINE=InnoDB AUTO_INCREMENT=256 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relation`
--

LOCK TABLES `relation` WRITE;
/*!40000 ALTER TABLE `relation` DISABLE KEYS */;
INSERT INTO `relation` VALUES (1,'happy','emotion','Is-a',100,1,0,1,1),(2,'Hammer','Pounding','UsedFor',100,1,0,1,1),(3,'bottle','Object','Is-a',100,1,0,1,1),(4,'Saturday','Day','Is-a',100,1,0,1,1),(5,'Smashing','Pain','Causes',100,1,0,1,1),(6,'Smash','action','Is-a',100,1,0,1,1),(7,'green','Color','Is-a',100,1,0,2,1),(8,'grass','green','ColorOf',100,1,0,1,1),(9,'round','shape','Is-a',100,1,0,2,1),(10,'Round','Globe','ShapeOf',100,1,0,1,1),(11,'insults','Pain','Causes',100,1,0,1,1),(12,'Phone','Calling','UsedFor',112,9,2,1,1),(13,'Joyful','happy','Synonym',100,1,0,1,1),(14,'Victim','kill','ReceivesAction',100,1,0,1,1),(15,'Phone','Object','Is-a',100,1,0,1,1),(16,'Bottle','Containing','UsedFor',100,1,0,1,1),(17,'happy','Playing','Causes',62,5,2,1,0),(18,'well','happy','Causes',100,4,1,1,0),(19,'well','action','Is-A',100,4,1,1,0),(20,'house','location','Is-A',100,4,1,2,0),(21,'Phone','house','LocatedAt',100,4,1,1,0),(22,'black','color','Is-A',100,4,1,1,0),(23,'black','Phone','ColorOf',100,4,1,1,0),(24,'rectangle','shape','Is-A',100,8,2,1,0),(25,'rectangle','Phone','ShapeOf',100,4,1,1,0),(26,'Phone','find','ReceivesAction',100,4,1,1,0),(27,'Rizal Park','location','Is-a',100,1,0,1,1),(28,'Rizal statue','Rizal Park','LocatedAt',100,1,0,1,1),(29,'Playing','Rizal Park','DoneAt',100,1,0,1,1),(30,'Rizal statue','Object','Is-a',125,5,1,1,1),(31,'Rizal Monument','Object','Is-a',100,1,0,1,1),(32,'Rizal Monument','Rizal Park','LocatedAt',100,1,0,1,1),(33,'Jose Rizal Monument','object','Is-a',100,1,0,1,1),(34,'Jose Rizal Monument','Rizal Park','LocatedAt',100,1,0,1,1),(35,'happy','Smiling','Causes',100,8,2,1,0),(36,'running','happy','Causes',100,4,1,1,0),(37,'running','action','Is-A',100,4,1,1,0),(38,'glad','happy','Synonym',100,4,1,1,0),(39,'beach','location','Is-A',100,4,1,2,0),(40,'bottle','beach','LocatedAt',100,4,1,2,0),(41,'red','color','Is-A',100,4,1,1,0),(42,'red','bottle','ColorOf',100,4,1,1,0),(43,'cylyndrical','shape','Is-A',100,4,1,1,0),(44,'cylyndrical','bottle','ShapeOf',100,4,1,1,0),(45,'bottle','hold','ReceivesAction',100,4,1,2,0),(46,'grey','color','Is-A',100,4,1,1,0),(47,'grey','Rizal statue','ColorOf',100,4,1,1,0),(48,'Rizal statue','marble','MadeOf',100,4,1,1,0),(49,'Rizal statue','remembering','UsedFor',100,4,1,1,0),(50,'remembering','action','Is-A',100,4,1,1,0),(51,'rough','texture','Is-A',100,4,1,2,0),(52,'rough','Jose Rizal Monument','TextureOf',100,4,1,1,0),(53,'Jose Rizal Monument','stone','MadeOf',100,4,1,1,0),(54,'expensive','Jose Rizal Monument','PropertyOf',100,4,1,1,0),(55,'breakable','Jose Rizal Monument','PropertyOf',100,4,1,1,0),(56,'chair','house','LocatedAt',100,4,1,2,0),(57,'chair','object','Is-A',100,4,1,2,0),(58,'rest','action','Is-A',100,4,1,2,0),(59,'park','location','Is-A',100,4,1,1,0),(60,'happy','Jump','Causes',100,8,2,2,0),(61,'hopping','happy','Causes',100,4,1,1,0),(62,'hopping','action','Is-A',100,4,1,2,0),(63,'cheerful','happy','Synonym',100,8,2,1,0),(64,'sidewalk','location','Is-A',100,4,1,1,0),(65,'bottle','sidewalk','LocatedAt',100,4,1,1,0),(66,'green','bottle','ColorOf',62,5,2,1,0),(67,'round','bottle','ShapeOf',100,4,1,1,0),(68,'bottle','get','ReceivesAction',100,4,1,1,0),(69,'brown','color','Is-A',100,8,2,1,0),(70,'brown','Rizal statue','ColorOf',100,4,1,1,0),(71,'Rizal statue','rock','MadeOf',100,4,1,1,0),(72,'elegant','Rizal statue','PropertyOf',100,4,1,1,0),(73,'sand','beach','LocatedAt',100,4,1,1,0),(74,'sand','object','Is-A',100,4,1,1,0),(75,'surfing','action','Is-A',100,4,1,1,0),(76,'hut','location','Is-A',100,4,1,1,0),(77,'Repair man','person','Is-a',100,1,0,1,1),(78,'cloudy','day','PropertyOf',100,1,0,1,1),(79,'Niccolo','person','Is-A',100,4,1,1,0),(80,'warm','day','PropertyOf',100,4,1,1,0),(81,'mad','emotion','Is-A',100,4,1,1,0),(82,'barbershop','location','Is-A',100,4,1,1,0),(83,'PS3','object','Is-A',100,4,1,1,0),(84,'boy','Repair man','GenderOf',100,4,1,1,0),(85,'mad','Frown','Causes',87,7,2,1,0),(86,'hurt','mad','Causes',100,8,2,1,0),(87,'hurt','action','Is-A',100,4,1,1,0),(88,'angry','mad','Synonym',100,4,1,1,0),(89,'dump','location','Is-A',100,4,1,1,0),(90,'bottle','dump','LocatedAt',100,4,1,1,0),(91,'blue','color','Is-A',100,4,1,3,0),(92,'blue','bottle','ColorOf',100,4,1,3,0),(93,'have','shape','Is-A',100,4,1,1,0),(94,'have','bottle','ShapeOf',100,4,1,1,0),(95,'bottle','have','ReceivesAction',87,7,2,1,0),(96,'happy','positive feeling','Is-a',100,1,0,1,1),(97,'mad','negative feeling','Is-a',100,1,0,1,1),(98,'trouble','mad','Causes',100,4,1,1,0),(99,'mad','pout','Causes',100,4,1,1,0),(100,'pout','action','Is-A',100,8,2,1,0),(101,'jump','happy','Causes',100,4,1,1,0),(102,'happy','smile','Causes',100,4,1,2,0),(103,'smile','action','Is-A',100,8,2,2,0),(104,'doll','toy','Is-a',100,1,0,1,1),(105,'doll','Toy Store','LocatedAt',100,1,0,1,1),(106,'lady','person','Is-a',100,1,0,1,1),(107,'girl','lady','GenderOf',100,1,0,1,1),(108,'messy','infestation','LeadsTo',100,1,0,1,1),(109,'boy','Niccolo','GenderOf',100,1,0,2,1),(110,'box','dump','LocatedAt',100,4,1,1,0),(111,'box','object','Is-A',100,4,1,1,0),(112,'walking','action','Is-A',100,8,2,1,0),(113,'shower room','location','Is-A',100,4,1,1,0),(114,'high grades','happy','Causes',100,4,1,1,0),(115,'Toy Store','location','Is-a',100,1,0,1,1),(116,'teddy bear','Toy Store','LocatedAt',100,1,0,1,1),(117,'Cashier','person','Is-a',100,1,0,1,1),(118,'cashier','cash register','LocatedAt',100,1,0,1,1),(119,'Barber','person','Is-a',125,5,1,1,1),(120,'Barber','Barbershop','LocatedAt',100,1,0,1,1),(121,'Mirror','Object','Is-a',100,1,0,1,1),(122,'Mirror','Barbershop','LocatedAt',100,1,0,1,1),(123,'Monday','Day','Is-a',100,1,0,1,1),(124,'boy','Barber','LocatedAt',100,1,0,1,1),(125,'Tuesday','Day','Is-a',100,1,0,1,1),(126,'Niccolo','Barber','CanBe',100,1,0,1,1),(127,'Lady','Mother','CanBe',100,1,0,1,1),(128,'Lady','Saleslady','CanBe',100,1,0,1,1),(129,'person','Mother','CanBe',100,1,0,1,1),(130,'person','Barber','CanBe',100,1,0,1,1),(131,'resting','beach','DoneAt',100,4,1,1,0),(132,'Mother','caring','Does',100,4,1,1,0),(133,'note','box','LocatedNear',100,4,1,1,0),(134,'standing','sidewalk','DoneAt',100,4,1,1,0),(135,'Barber','shaving','Does',100,4,1,1,0),(136,'text','Rizal statue','LocatedNear',100,4,1,1,0),(137,'person','Mailman','CanBe',100,1,0,1,1),(138,'person','Traveler','CanBe',100,1,0,1,1),(139,'nurturing','Rizal Park','DoneAt',100,4,1,1,0),(140,'Mother','wire','Does',100,4,1,1,0),(141,'buttons','Phone','LocatedNear',100,4,1,1,0),(142,'person','Mailman','CanBe',100,1,0,1,1),(143,'person','Traveler','CanBe',100,1,0,1,1),(144,'working','barbershop','DoneAt',100,4,1,1,0),(145,'Barber','cutting','Does',100,4,1,1,0),(146,'controller','PS3','LocatedNear',100,4,1,1,0),(147,'person','employee','CanBe',100,4,1,1,0),(148,'health','walking','PurposeOf',100,4,1,1,0),(149,'walking','sprint','LeadsTo',100,4,1,1,0),(150,'twig','object','Is-A',100,4,1,1,0),(151,'breakable','twig','PropertyOf',100,4,1,1,0),(152,'twig','park','LocatedAt',100,4,1,1,0),(153,'fine','feeling','Is-A',100,4,1,1,0),(154,'loved','happy','Causes',100,4,1,1,0),(155,'happy','encourage','Causes',100,4,1,1,0),(156,'encourage','action','Is-A',100,4,1,1,0),(157,'light','texture','Is-A',100,4,1,1,0),(158,'light','bottle','TextureOf',100,4,1,1,0),(159,'bottle','plastic','MadeOf',100,4,1,2,0),(160,'light','bottle','PropertyOf',100,4,1,2,0),(161,'breakable','bottle','PropertyOf',100,4,1,1,0),(162,'John','person','Is-A',100,4,1,1,0),(163,'spicy','day','PropertyOf',100,4,1,1,0),(164,'depressed','emotion','Is-A',100,4,1,1,0),(165,'Naga','location','Is-A',100,4,1,1,0),(166,'pepper','object','Is-A',100,4,1,1,0),(167,'register','object','Is-A',100,4,1,1,0),(168,'breakable','register','PropertyOf',100,4,1,1,0),(169,'register','shower room','LocatedAt',100,4,1,1,0),(170,'stressed','feeling','Is-A',100,4,1,1,0),(171,'poster','park','LocatedAt',100,4,1,1,0),(172,'poster','object','Is-A',100,4,1,1,0),(173,'skating','action','Is-A',100,4,1,1,0),(174,'mad','pound','Causes',100,4,1,1,0),(175,'pound','action','Is-A',100,4,1,1,0),(176,'pain','mad','Causes',100,4,1,1,0),(177,'dove','park','LocatedAt',100,4,1,1,0),(178,'chill','action','Is-A',100,4,1,1,0),(179,'yard','location','Is-A',100,4,1,1,0),(180,'waiting','barbershop','DoneAt',100,4,1,2,0),(181,'employee','work','Does',100,4,1,2,0),(182,'flower','Jose Rizal Monument','LocatedNear',100,4,1,2,0),(183,'puppet','toy','Is-A',100,4,1,1,0),(184,'sitting','action','Is-A',100,4,1,1,0),(185,'school','location','Is-A',100,4,1,2,0),(186,'person','nurse','CanBe',100,4,1,1,0),(187,'surfing','cramps','Causes',100,4,1,1,0),(188,'surfing','eating','LeadsTo',100,4,1,1,0),(189,'person','diplomat','CanBe',100,4,1,1,0),(190,'preaching','remembering','PurposeOf',100,4,1,1,0),(191,'remembering','writting','LeadsTo',100,4,1,1,0),(192,'pan','hut','LocatedAt',100,4,1,1,0),(193,'hall','location','Is-A',100,4,1,1,0),(194,'Dirk','person','Is-A',100,4,1,1,0),(195,'pleasant','day','PropertyOf',100,4,1,2,0),(196,'shocked','emotion','Is-A',100,4,1,1,0),(197,'smartphone','object','Is-A',100,4,1,1,0),(198,'shell','object','Is-A',100,4,1,1,0),(199,'breakable','shell','PropertyOf',100,4,1,1,0),(200,'shell','beach','LocatedAt',100,4,1,1,0),(201,'Simba','person','Is-A',100,4,1,1,0),(202,'paranoid','emotion','Is-A',100,4,1,1,0),(203,'bench area','location','Is-A',100,4,1,1,0),(204,'show','object','Is-A',100,4,1,1,0),(205,'notebook','school','LocatedAt',100,4,1,1,0),(206,'learning','action','Is-A',100,4,1,1,0),(207,'shop','location','Is-A',100,4,1,1,0),(208,'paranoid','look','Causes',100,4,1,1,0),(209,'scared','paranoid','Causes',100,4,1,1,0),(210,'scared','action','Is-A',100,4,1,1,0),(211,'agitated','paranoid','Synonym',100,4,1,1,0),(212,'cylindrical','shape','Is-A',100,4,1,1,0),(213,'cylindrical','bottle','ShapeOf',100,4,1,1,0),(214,'life','happy','Causes',100,4,1,1,0),(215,'jump','action','Is-A',100,4,1,1,0),(216,'tired','feeling','Is-A',100,4,1,1,0),(217,'bread','barbershop','LocatedAt',100,4,1,1,0),(218,'edible','bread','PropertyOf',100,4,1,1,0),(219,'mad','stomp','Causes',100,4,1,1,0),(220,'stomp','action','Is-A',100,4,1,1,0),(221,'troubled','mad','Causes',100,4,1,1,0),(222,'person','lawyer','CanBe',100,4,1,1,0),(223,'bloodlust','hurt','PurposeOf',100,4,1,1,0),(224,'hurt','laugh','LeadsTo',100,4,1,1,0),(225,'person','waitress','CanBe',100,4,1,1,0),(226,'remembering','headaches','Causes',100,4,1,1,0),(227,'remembering','sitting','LeadsTo',100,4,1,1,0),(228,'Rough','Rizal Monument','TextureOf',100,4,1,1,0),(229,'Rizal Monument','stone','MadeOf',100,4,1,1,0),(230,'Rizal Monument','display','UsedFor',100,4,1,1,0),(231,'display','action','Is-A',100,4,1,1,0),(232,'weary','feeling','Is-A',100,4,1,1,0),(233,'sandwhich','Rizal Park','LocatedAt',100,4,1,1,0),(234,'edible','sandwhich','PropertyOf',100,4,1,1,0),(235,'person','tourist','CanBe',100,4,1,1,0),(236,'Curiosity','learning','PurposeOf',100,4,1,1,0),(237,'learning','knowing','LeadsTo',100,4,1,1,0),(238,'test tube','object','Is-A',100,4,1,1,0),(239,'breakable','test tube','PropertyOf',100,4,1,1,0),(240,'test tube','shop','LocatedAt',100,4,1,1,0),(241,'bin','sidewalk','LocatedAt',100,4,1,1,0),(242,'bay','location','Is-A',100,4,1,2,0),(243,'smooth','texture','Is-A',100,4,1,1,0),(244,'smooth','Mirror','TextureOf',100,4,1,1,0),(245,'Mirror','glass','MadeOf',100,4,1,1,0),(246,'Mirror','inspection','UsedFor',100,4,1,1,0),(247,'ride','action','Is-A',100,4,1,1,0),(248,'sleep','hut','DoneAt',100,4,1,1,0),(249,'diplomat','negotiate','Does',100,4,1,1,0),(250,'pen','box','LocatedNear',100,4,1,1,0),(251,'bug','yard','LocatedAt',100,4,1,1,0),(252,'glad','action','Is-A',100,4,1,1,0),(253,'relaxing','bench area','DoneAt',100,4,1,1,0),(254,'diplomat','understanding','Does',100,4,1,1,0),(255,'stage','show','LocatedNear',100,4,1,1,0);
/*!40000 ALTER TABLE `relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relationship`
--

DROP TABLE IF EXISTS `relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relationship` (
  `RelationshipID` int(11) NOT NULL AUTO_INCREMENT,
  `Relationship` varchar(50) DEFAULT NULL,
  `Sentence_pattern` tinytext,
  PRIMARY KEY (`RelationshipID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relationship`
--

LOCK TABLES `relationship` WRITE;
/*!40000 ALTER TABLE `relationship` DISABLE KEYS */;
INSERT INTO `relationship` VALUES (1,'Is-a','is considered as a'),(2,'Causes','Results to '),(3,'LocatedAt','is located at'),(4,'UsedFor','is used for'),(5,'Synonym','is synonymous to'),(6,'ColorOf','has the color'),(7,'ShapeOf','is in the shape of'),(8,'ReceivesAction','Recieves the action'),(9,'DoneAt','is Done at'),(10,'HasA','possesses'),(11,'Desires','wants'),(12,'CapableOf','can'),(13,'DefinedAs','is defined as'),(14,'LeadsTo','Leads to'),(15,'PropertyOf','is a property of'),(16,'MadeOf','is made of'),(17,'PartOf','is a part of');
/*!40000 ALTER TABLE `relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storyaccomplishment`
--

DROP TABLE IF EXISTS `storyaccomplishment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storyaccomplishment` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `templateID` int(11) DEFAULT NULL,
  `AccountID` int(11) DEFAULT NULL,
  `Name` varchar(80) DEFAULT NULL,
  `fileURL` text,
  `finishTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `templateUsed` (`templateID`),
  KEY `authorID` (`AccountID`),
  CONSTRAINT `authorID` FOREIGN KEY (`AccountID`) REFERENCES `account` (`accountID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `templateUsed` FOREIGN KEY (`templateID`) REFERENCES `template` (`TemplateID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storyaccomplishment`
--

LOCK TABLES `storyaccomplishment` WRITE;
/*!40000 ALTER TABLE `storyaccomplishment` DISABLE KEYS */;
INSERT INTO `storyaccomplishment` VALUES (1,1,3,'The introduction of Simba','uploadedFiles/The introduction of Simba522066365Simba.story',NULL),(2,2,3,'Spicy day','uploadedFiles/Spicy1844764482Simba.story',NULL),(4,2,7,'School trip','uploadedFiles/School trip1350866152DK.story',NULL),(5,1,5,'Beach Paranoia','BeachNej.story',NULL),(6,1,5,'The feels','uploadedFiles/The feels1686661008Simba.story','2013-02-13 05:49:47'),(7,4,5,'Feed Dirk','uploadedFiles/Feed dirk615881354nej.story','2013-02-19 18:27:41'),(8,3,7,'The feels','uploadedFiles/Mad feelings1171126013DK.story','2013-02-19 18:53:01'),(9,1,7,'Cashier the fiendish friend','uploadedFiles/Cashier the fiendish friend1747797714DK.story','2013-02-19 18:54:46'),(10,1,3,'Bottle story','uploadedFiles/Bottle story1661603083Simba.story','2013-02-19 19:03:08'),(11,1,3,'The story of today','uploadedFiles/The story of today1925610500Simba.story','2013-02-20 03:44:20'),(12,1,7,'Me in the Park','uploadedFiles/Me in the Park470420369DK.story','2013-02-21 08:35:45'),(13,1,5,'Lady\'s meal','uploadedFiles/Lady\'s meal1607503622nej.story','2013-02-21 08:59:28'),(14,1,11,'Touring repair man','uploadedFiles/Touring repair man1726652230Shakespir.story','2013-02-21 09:01:32'),(15,1,11,'Spicy break','uploadedFiles/Spicy break516578976Shakespir.story','2013-02-21 09:02:45'),(16,1,8,'Sidewalk trip','uploadedFiles/Sidewalk trip24628589CoolJ.story','2013-02-21 09:07:44'),(17,1,8,'mirror on the barber\'s wall','uploadedFiles/mirror on the barber\'s wall1518269048CoolJ.story','2013-02-21 09:09:54'),(18,1,8,'Biag\'s Hut','uploadedFiles/Biag\'s Hut874318666CoolJ.story','2013-02-21 09:11:41'),(19,1,8,'The yard story','uploadedFiles/The yard story1534586655CoolJ.story','2013-02-21 09:12:45'),(20,1,9,'Cloud at the beach','uploadedFiles/Cloud at the beach1812684503Egoist.story','2013-02-21 09:21:22');
/*!40000 ALTER TABLE `storyaccomplishment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `template`
--

DROP TABLE IF EXISTS `template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `template` (
  `TemplateID` int(11) NOT NULL AUTO_INCREMENT,
  `StoryURL` text,
  `RelationURL` text,
  `LevelReq` int(11) DEFAULT '1',
  `plusScore` int(11) DEFAULT '10',
  `Name` varchar(50) DEFAULT NULL,
  `authorID` int(11) DEFAULT '1',
  PRIMARY KEY (`TemplateID`),
  KEY `templatreAuthor` (`authorID`),
  CONSTRAINT `templatreAuthor` FOREIGN KEY (`authorID`) REFERENCES `account` (`accountID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `template`
--

LOCK TABLES `template` WRITE;
/*!40000 ALTER TABLE `template` DISABLE KEYS */;
INSERT INTO `template` VALUES (1,'StoryTemplates/StoryTemplate1.txt','RelationTemplates/RelationTemplate1.txt',1,20,'For the begginer',1),(2,'StoryTemplates/StoryTemplate2.txt','RelationTemplates/RelationTemplate2.txt',1,40,'For show',1),(3,'StoryTemplates/StoryTemplate3.txt','RelationTemplates/RelationTemplate3.txt',2,60,'Another one',1),(4,'StoryTemplates/StoryTemplate4.txt','RelationTemplates/RelationTemplate4.txt',2,80,'This',1),(5,'StoryTemplates/StoryTemplate5.txt','RelationTemplates/RelationTemplate5.txt',3,100,'This one',1),(6,'StoryTemplates/StoryTemplate6.txt','RelationTemplates/RelationTemplate6.txt',3,100,'This other thing',1),(7,'StoryTemplates/StoryTemplate7.txt','RelationTemplates/RelationTemplate7.txt',4,140,'hmmmmm',1),(8,'StoryTemplates/StoryTemplate8.txt','RelationTemplates/RelationTemplate8.txt',4,160,'tffffmmmmm',1),(9,'StoryTemplates/StoryTemplate9.txt','RelationTemplates/RelationTemplate9.txt',4,170,'tffffmmmmm',1),(10,'StoryTemplates/StoryTemplate10.txt','RelationTemplates/RelationTemplate10.txt',5,200,'tzzzzz',1);
/*!40000 ALTER TABLE `template` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-02-24 13:32:38
