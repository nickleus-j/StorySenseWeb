-- MySQL dump 10.13  Distrib 5.5.31, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: ontology
-- ------------------------------------------------------
-- Server version	5.5.31-0ubuntu0.13.04.1

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
-- Table structure for table `Notification`
--

DROP TABLE IF EXISTS `Notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Notification` (
  `NotificationId` int(11) NOT NULL AUTO_INCREMENT,
  `notifUser` int(11) DEFAULT NULL,
  `StartedOn` timestamp NULL DEFAULT NULL,
  `viewed` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`NotificationId`),
  KEY `accountNotification` (`notifUser`),
  CONSTRAINT `accountNotification` FOREIGN KEY (`notifUser`) REFERENCES `account` (`accountID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Notification`
--

LOCK TABLES `Notification` WRITE;
/*!40000 ALTER TABLE `Notification` DISABLE KEYS */;
INSERT INTO `Notification` VALUES (1,7,'2013-05-28 08:39:55',1),(2,3,'2013-05-29 06:11:00',1),(3,5,'2013-07-07 15:20:40',1),(4,7,'2013-07-07 15:21:02',1),(5,9,'2013-07-08 03:11:44',1),(6,11,'2013-07-08 03:12:50',1),(7,14,'2013-07-08 03:13:26',1),(8,8,'2013-07-08 13:05:08',1),(9,15,'2013-07-09 02:42:27',1),(10,6,'2013-07-09 06:11:11',1),(11,5,'2013-07-10 08:41:10',1),(12,17,'2013-07-10 08:58:31',1),(13,7,'2013-07-10 10:27:37',1),(14,7,'2013-07-10 10:47:10',1),(15,5,'2013-07-10 10:48:26',1),(16,11,'2013-07-10 10:55:02',1),(17,7,'2013-07-10 12:03:45',1),(18,3,'2013-07-11 05:16:16',1),(19,12,'2013-07-11 05:16:37',1),(20,3,'2013-07-11 05:23:47',1),(21,6,'2013-07-11 05:52:08',1),(22,5,'2013-07-11 05:52:32',1),(23,6,'2013-07-11 06:36:45',1),(24,11,'2013-07-11 06:40:01',1),(25,3,'2013-07-11 14:52:57',1),(26,6,'2013-07-11 14:53:51',1),(27,6,'2013-07-11 15:39:56',1),(28,14,'2013-07-11 15:40:34',1),(29,7,'2013-07-11 15:52:13',1),(30,5,'2013-07-11 15:57:16',1),(31,11,'2013-07-13 02:19:47',1),(32,6,'2013-07-13 07:15:38',1),(33,5,'2013-07-14 00:55:35',1),(34,5,'2013-07-15 14:36:52',1),(35,3,'2013-07-15 14:39:31',1),(36,11,'2013-07-15 15:34:43',1),(37,9,'2013-07-15 15:51:11',1),(38,5,'2013-07-17 18:13:57',1),(39,7,'2013-07-19 17:27:13',1),(40,11,'2013-07-19 17:27:48',0),(41,15,'2013-07-20 05:06:35',1),(42,3,'2013-07-20 05:06:42',1),(43,6,'2013-07-20 05:06:44',1),(44,6,'2013-07-20 05:46:33',1),(45,12,'2013-07-20 05:46:47',1),(46,6,'2013-07-20 05:48:09',1),(47,5,'2013-07-20 17:08:19',1),(48,5,'2013-07-20 17:09:15',1),(49,15,'2013-07-20 17:10:59',1),(50,20,'2013-07-22 12:20:17',1),(51,20,'2013-07-22 12:24:51',1),(52,21,'2013-07-22 12:40:22',1),(53,21,'2013-07-22 12:45:27',1),(54,20,'2013-07-22 12:48:56',1),(55,21,'2013-07-22 12:50:04',1),(56,21,'2013-07-22 12:51:13',1),(57,7,'2013-07-23 06:40:39',1);
/*!40000 ALTER TABLE `Notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Relation`
--

DROP TABLE IF EXISTS `Relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Relation` (
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
) ENGINE=InnoDB AUTO_INCREMENT=489 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Relation`
--

LOCK TABLES `Relation` WRITE;
/*!40000 ALTER TABLE `Relation` DISABLE KEYS */;
INSERT INTO `Relation` VALUES (1,'happy','emotion','Is-a',125,5,1,1,1),(2,'Hammer','Pounding','UsedFor',125,5,1,1,1),(3,'bottle','Object','Is-a',125,5,1,1,1),(4,'Saturday','Day','Is-a',70,1,0,1,1),(5,'Smashing','Pain','Causes',125,5,1,1,1),(6,'Smash','action','Is-a',70,1,0,1,1),(7,'green','Color','Is-a',70,1,0,2,1),(8,'grass','green','ColorOf',70,1,0,1,1),(9,'round','shape','Is-a',70,4,1,5,1),(10,'Round','Globe','ShapeOf',125,5,1,1,1),(11,'insults','Pain','Causes',70,1,0,1,1),(12,'Phone','Calling','UsedFor',70,9,2,1,1),(13,'Joyful','happy','Synonym',70,1,0,2,1),(14,'Victim','kill','ReceivesAction',70,1,0,1,1),(15,'Phone','Object','Is-a',70,1,0,1,1),(16,'Bottle','Containing','UsedFor',70,1,0,1,1),(17,'happy','Playing','Causes',70,5,2,1,0),(18,'well','happy','Causes',87,7,2,1,0),(19,'well','action','Is-A',70,4,1,1,0),(20,'house','location','Is-A',100,8,2,3,0),(21,'Phone','house','LocatedAt',70,8,2,1,0),(22,'black','color','Is-A',75,6,2,3,0),(23,'black','Phone','ColorOf',70,4,1,1,0),(24,'rectangle','shape','Is-A',87,14,4,2,0),(25,'rectangle','Phone','ShapeOf',70,8,2,1,0),(26,'Phone','find','ReceivesAction',70,4,1,1,0),(27,'Rizal Park','location','Is-a',62,5,2,2,1),(28,'Rizal statue','Rizal Park','LocatedAt',70,1,0,1,1),(29,'Playing','Rizal Park','DoneAt',70,1,0,1,1),(30,'Rizal statue','Object','Is-a',70,9,2,1,1),(31,'Rizal Monument','Object','Is-a',70,1,0,1,1),(32,'Rizal Monument','Rizal Park','LocatedAt',87,7,2,2,1),(33,'Jose Rizal Monument','object','Is-a',70,1,0,1,1),(34,'Jose Rizal Monument','Rizal Park','LocatedAt',70,1,0,1,1),(35,'happy','Smiling','Causes',70,8,2,1,0),(36,'running','happy','Causes',70,4,1,1,0),(37,'running','action','Is-A',100,12,3,2,0),(38,'glad','happy','Synonym',70,4,1,1,0),(39,'beach','location','Is-A',70,8,2,2,0),(40,'bottle','beach','LocatedAt',70,4,1,2,0),(41,'red','color','Is-A',70,4,1,2,0),(42,'red','bottle','ColorOf',70,4,1,1,0),(43,'cylyndrical','shape','Is-A',70,4,1,1,0),(44,'cylyndrical','bottle','ShapeOf',70,8,2,1,0),(45,'bottle','hold','ReceivesAction',70,4,1,2,0),(46,'grey','color','Is-A',70,4,1,1,0),(47,'grey','Rizal statue','ColorOf',70,4,1,1,0),(48,'Rizal statue','marble','MadeOf',70,8,2,1,0),(49,'Rizal statue','remembering','UsedFor',87,7,2,1,0),(50,'remembering','action','Is-A',70,4,1,1,0),(51,'rough','texture','Is-A',70,16,4,3,0),(52,'rough','Jose Rizal Monument','TextureOf',70,4,1,1,0),(53,'Jose Rizal Monument','stone','MadeOf',70,4,1,1,0),(54,'expensive','Jose Rizal Monument','PropertyOf',70,4,1,1,0),(55,'breakable','Jose Rizal Monument','PropertyOf',70,4,1,1,0),(56,'chair','house','LocatedAt',70,4,1,2,0),(57,'chair','object','Is-A',70,4,1,2,0),(58,'rest','action','Is-A',70,4,1,2,0),(59,'park','location','Is-A',70,12,3,2,0),(60,'happy','Jump','Causes',100,20,5,2,0),(61,'hopping','happy','Causes',83,10,3,1,0),(62,'hopping','action','Is-A',70,12,3,2,0),(63,'cheerful','happy','Synonym',70,8,2,1,0),(64,'sidewalk','location','Is-A',70,4,1,1,0),(65,'bottle','sidewalk','LocatedAt',70,4,1,1,0),(66,'green','bottle','ColorOf',41,5,3,1,0),(67,'round','bottle','ShapeOf',70,4,1,1,0),(68,'bottle','get','ReceivesAction',70,8,2,1,0),(69,'brown','color','Is-A',75,15,5,3,0),(70,'brown','Rizal statue','ColorOf',70,4,1,1,0),(71,'Rizal statue','rock','MadeOf',70,4,1,1,0),(72,'elegant','Rizal statue','PropertyOf',70,8,2,1,0),(73,'sand','beach','LocatedAt',70,4,1,1,0),(74,'sand','object','Is-A',70,4,1,1,0),(75,'surfing','action','Is-A',70,4,1,1,0),(76,'hut','location','Is-A',70,4,1,1,0),(77,'Repair man','person','Is-a',70,1,0,1,1),(78,'cloudy','day','PropertyOf',125,5,1,1,1),(79,'Niccolo','person','Is-A',70,4,1,1,0),(80,'warm','day','PropertyOf',70,4,1,1,0),(81,'mad','emotion','Is-A',70,4,1,1,0),(82,'barbershop','location','Is-A',70,4,1,1,0),(83,'PS3','object','Is-A',70,8,2,1,0),(84,'boy','Repair man','GenderOf',70,4,2,1,0),(85,'mad','Frown','Causes',70,7,2,1,0),(86,'hurt','mad','Causes',91,11,3,2,0),(87,'hurt','action','Is-A',70,8,2,2,0),(88,'angry','mad','Synonym',70,4,1,1,0),(89,'dump','location','Is-A',70,4,1,1,0),(90,'bottle','dump','LocatedAt',70,4,1,1,0),(91,'blue','color','Is-A',70,16,4,4,0),(92,'blue','bottle','ColorOf',70,8,2,3,0),(93,'have','shape','Is-A',70,4,1,1,0),(94,'have','bottle','ShapeOf',70,4,2,1,0),(95,'bottle','have','ReceivesAction',70,7,2,1,0),(96,'happy','positive feeling','Is-a',70,1,0,1,1),(97,'mad','negative feeling','Is-a',70,4,1,1,1),(98,'trouble','mad','Causes',70,8,2,1,0),(99,'mad','pout','Causes',70,4,1,1,0),(100,'pout','action','Is-A',70,8,2,1,0),(101,'jump','happy','Causes',87,7,2,1,0),(102,'happy','smile','Causes',100,8,2,3,0),(103,'smile','action','Is-A',91,11,3,3,0),(104,'doll','toy','Is-a',70,1,0,1,1),(105,'doll','Toy Store','LocatedAt',70,1,0,1,1),(106,'lady','person','Is-a',70,1,0,1,1),(107,'girl','lady','GenderOf',70,1,0,1,1),(108,'messy','infestation','LeadsTo',70,4,1,1,1),(109,'boy','Niccolo','GenderOf',70,1,0,2,1),(110,'box','dump','LocatedAt',70,4,1,1,0),(111,'box','object','Is-A',70,4,1,1,0),(112,'walking','action','Is-A',70,8,2,1,0),(113,'shower room','location','Is-A',70,4,1,1,0),(114,'high grades','happy','Causes',70,4,1,1,0),(115,'Toy Store','location','Is-a',70,9,2,2,1),(116,'teddy bear','Toy Store','LocatedAt',70,1,0,1,1),(117,'Cashier','person','Is-a',70,9,2,1,1),(118,'cashier','cash register','LocatedAt',70,1,0,1,1),(119,'Barber','person','Is-a',70,9,2,1,1),(120,'Barber','Barbershop','LocatedAt',70,1,0,1,1),(121,'Mirror','Object','Is-a',500,60,3,3,1),(122,'Mirror','Barbershop','LocatedAt',400,64,4,2,1),(123,'Monday','Day','Is-a',70,1,0,1,1),(124,'boy','Barber','LocatedAt',125,5,1,1,1),(125,'Tuesday','Day','Is-a',70,1,0,1,1),(126,'Niccolo','Barber','CanBe',125,5,1,1,1),(127,'Lady','Mother','CanBe',125,5,1,1,1),(128,'Lady','Saleslady','CanBe',70,1,0,1,1),(129,'person','Mother','CanBe',70,1,0,1,1),(130,'person','Barber','CanBe',70,1,0,1,1),(131,'resting','beach','DoneAt',70,4,1,1,0),(132,'Mother','caring','Does',70,8,2,1,0),(133,'note','box','LocatedNear',70,4,1,1,0),(134,'standing','sidewalk','DoneAt',70,4,1,1,0),(135,'Barber','shaving','Does',70,4,1,1,0),(136,'text','Rizal statue','LocatedNear',87,7,2,1,0),(137,'person','Mailman','CanBe',125,5,1,1,1),(138,'person','Traveler','CanBe',70,1,0,1,1),(139,'nurturing','Rizal Park','DoneAt',87,7,2,1,0),(140,'Mother','wire','Does',70,4,1,1,0),(141,'wire','Phone','LocatedNear',70,4,1,1,0),(142,'person','Mailman','CanBe',125,5,1,1,1),(143,'person','Traveler','CanBe',70,1,0,1,1),(144,'working','barbershop','DoneAt',70,4,1,1,0),(145,'Barber','cutting','Does',70,4,1,1,0),(146,'controller','PS3','LocatedNear',70,4,1,2,0),(147,'person','employee','CanBe',70,4,1,1,0),(148,'health','walking','PurposeOf',70,4,1,1,0),(149,'walking','sprint','LeadsTo',70,4,1,1,0),(150,'twig','object','Is-A',70,4,1,1,0),(151,'breakable','twig','PropertyOf',70,8,2,1,0),(152,'twig','park','LocatedAt',70,4,1,1,0),(153,'fine','feeling','Is-A',70,4,1,1,0),(154,'loved','happy','Causes',70,4,1,1,0),(155,'happy','encourage','Causes',70,4,1,1,0),(156,'encourage','action','Is-A',70,4,1,1,0),(157,'light','texture','Is-A',70,4,1,1,0),(158,'light','bottle','TextureOf',70,4,1,1,0),(159,'bottle','plastic','MadeOf',75,9,3,3,0),(160,'light','bottle','PropertyOf',87,7,2,2,0),(161,'breakable','bottle','PropertyOf',87,7,2,1,0),(162,'Sam','person','Is-A',70,4,1,1,0),(163,'spicy','day','PropertyOf',70,8,2,1,0),(164,'regret','emotion','Is-A',70,8,2,1,0),(165,'Naga','location','Is-A',70,4,1,1,0),(166,'pepper','object','Is-A',70,4,1,1,0),(167,'register','object','Is-A',70,4,1,1,0),(168,'breakable','register','PropertyOf',87,7,2,1,0),(169,'register','shower room','LocatedAt',70,4,1,1,0),(170,'stressed','feeling','Is-A',70,4,1,1,0),(171,'poster','park','LocatedAt',70,4,1,1,0),(172,'poster','object','Is-A',70,4,1,1,0),(173,'skating','action','Is-A',70,4,1,1,0),(174,'mad','pound','Causes',70,8,2,1,0),(175,'pound','action','Is-A',70,4,1,1,0),(176,'pain','mad','Causes',70,4,1,1,0),(177,'dove','park','LocatedAt',70,4,1,1,0),(178,'chill','action','Is-A',70,4,1,1,0),(179,'yard','location','Is-A',70,4,1,1,0),(180,'waiting','barbershop','DoneAt',70,8,2,2,0),(181,'employee','work','Does',70,4,1,2,0),(182,'flower','Jose Rizal Monument','LocatedNear',70,4,1,2,0),(183,'puppet','toy','Is-A',70,4,1,1,0),(184,'sitting','action','Is-A',70,4,1,1,0),(185,'school','location','Is-A',75,9,3,3,0),(186,'person','nurse','CanBe',70,8,2,1,0),(187,'surfing','cramps','Causes',70,4,1,1,0),(188,'surfing','eating','LeadsTo',87,7,2,1,0),(189,'person','diplomat','CanBe',70,4,1,1,0),(190,'preaching','remembering','PurposeOf',70,4,1,1,0),(191,'remembering','writting','LeadsTo',87,7,2,1,0),(192,'pan','hut','LocatedAt',70,4,1,1,0),(193,'hall','location','Is-A',83,10,3,2,0),(194,'Dirk','person','Is-A',70,4,1,1,0),(195,'pleasant','day','PropertyOf',75,9,3,2,0),(196,'shocked','emotion','Is-A',70,4,1,1,0),(197,'smartphone','object','Is-A',70,4,1,1,0),(198,'shell','object','Is-A',100,12,3,1,0),(199,'breakable','shell','PropertyOf',100,12,3,1,0),(200,'shell','beach','LocatedAt',100,12,3,1,0),(201,'Simba','person','Is-A',70,4,2,1,0),(202,'paranoid','emotion','Is-A',66,8,3,1,0),(203,'bench area','location','Is-A',62,5,2,1,0),(204,'show','object','Is-A',62,5,2,1,0),(205,'notebook','school','LocatedAt',70,8,2,1,0),(206,'learning','action','Is-A',70,8,2,1,0),(207,'shop','location','Is-A',70,8,2,1,0),(208,'paranoid','look','Causes',70,4,1,1,0),(209,'scared','paranoid','Causes',70,12,3,2,0),(210,'scared','action','Is-A',83,10,3,2,0),(211,'agitated','paranoid','Synonym',70,4,1,1,0),(212,'cylindrical','shape','Is-A',50,4,2,2,0),(213,'cylindrical','bottle','ShapeOf',70,4,1,1,0),(214,'life','happy','Causes',100,12,3,1,0),(215,'jump','action','Is-A',91,11,3,1,0),(216,'tired','feeling','Is-A',70,12,3,1,0),(217,'bread','barbershop','LocatedAt',91,11,3,1,0),(218,'edible','bread','PropertyOf',70,8,2,1,0),(219,'mad','stomp','Causes',70,8,2,1,0),(220,'stomp','action','Is-A',70,8,2,1,0),(221,'troubled','mad','Causes',70,8,2,1,0),(222,'person','lawyer','CanBe',66,16,6,2,0),(223,'bloodlust','hurt','PurposeOf',85,17,5,1,0),(224,'hurt','laugh','LeadsTo',75,12,4,1,0),(225,'person','waitress','CanBe',93,15,4,1,0),(226,'remembering','headaches','Causes',100,16,4,1,0),(227,'remembering','sitting','LeadsTo',93,15,4,1,0),(228,'Rough','Rizal Monument','TextureOf',70,12,3,1,0),(229,'Rizal Monument','stone','MadeOf',83,10,3,1,0),(230,'Rizal Monument','display','UsedFor',70,12,3,1,0),(231,'display','action','Is-A',91,11,3,1,0),(232,'weary','feeling','Is-A',95,23,6,1,0),(233,'sandwhich','Rizal Park','LocatedAt',85,17,5,1,0),(234,'edible','sandwhich','PropertyOf',90,18,5,1,0),(235,'person','tourist','CanBe',58,7,3,1,0),(236,'improvement','learning','PurposeOf',70,4,1,1,0),(237,'learning','knowledge','LeadsTo',70,4,1,1,0),(238,'test tube','object','Is-A',93,15,4,1,0),(239,'breakable','test tube','PropertyOf',87,14,4,1,0),(240,'test tube','shop','LocatedAt',91,11,3,1,0),(241,'bin','sidewalk','LocatedAt',87,7,2,1,0),(242,'dome','location','Is-A',70,4,1,2,0),(243,'smooth','texture','Is-A',70,4,1,1,0),(244,'smooth','Mirror','TextureOf',70,4,1,1,0),(245,'Mirror','glass','MadeOf',70,12,3,2,0),(246,'Mirror','Reflecting','UsedFor',70,4,1,1,0),(247,'Reflecting','action','Is-A',70,4,1,1,0),(248,'Relaxing','hut','DoneAt',91,11,3,1,0),(249,'diplomat','negotiate','Does',70,4,1,1,0),(250,'pen','box','LocatedNear',70,4,1,1,0),(251,'bug','yard','LocatedAt',87,14,4,1,0),(252,'glad','action','Is-A',80,16,5,1,0),(253,'relaxing','bench area','DoneAt',81,13,4,1,0),(254,'diplomat','understanding','Does',87,14,4,1,0),(255,'stage','show','LocatedNear',87,14,4,1,0),(256,'brown','sand','ColorOf',93,15,4,2,0),(257,'sand','dirt','MadeOf',91,11,3,1,0),(258,'sand','building sand castles','UsedFor',91,11,3,1,0),(259,'building sand castles','action','Is-A',91,11,3,1,0),(260,'chilled','feeling','Is-A',483,58,3,1,0),(261,'crab','bench area','LocatedAt',475,57,3,1,0),(262,'edible','crab','PropertyOf',475,57,3,1,0),(263,'building blocks','toy','Is-A',100,12,3,1,0),(264,'person','doctor','CanBe',95,19,5,3,0),(265,'glad','overjoyfulness','Causes',95,19,5,1,0),(266,'glad','jump','LeadsTo',95,19,5,1,0),(267,'mad','Rant','Causes',70,8,2,1,0),(268,'call center','location','Is-A',87,7,2,1,0),(269,'Phone','call center','LocatedAt',87,7,2,1,0),(270,'blue','Phone','ColorOf',70,8,2,1,0),(271,'rectangular','shape','Is-A',91,11,3,1,0),(272,'rectangular','Phone','ShapeOf',91,11,3,1,0),(273,'Phone','hold','ReceivesAction',70,8,2,2,0),(274,'paranoid','Panic','Causes',83,10,3,1,0),(275,'weary','paranoid','Synonym',91,11,3,1,0),(276,'gray','color','Is-A',37,6,4,2,0),(277,'gray','Rizal Monument','ColorOf',81,13,4,2,0),(278,'rectangle','Rizal Monument','ShapeOf',70,12,3,1,0),(279,'Rizal Monument','see','ReceivesAction',93,15,4,1,0),(280,'relaxing','hut','DoneAt',91,11,3,1,0),(281,'Traveler','explorating','Does',100,8,2,1,0),(282,'comb','Mirror','LocatedNear',87,7,2,1,0),(283,'person','Writer','CanBe',83,10,3,1,0),(284,'remembering','pain','Causes',100,12,3,1,0),(285,'remembering','drinking','LeadsTo',80,16,5,1,0),(286,'shocked','Shouting','Causes',62,5,2,1,0),(287,'off guard','shocked','Causes',70,8,2,1,0),(288,'off guard','action','Is-A',70,8,2,1,0),(289,'surprise','shocked','Synonym',70,8,2,1,0),(290,'resort','location','Is-A',87,7,2,1,0),(291,'sand','resort','LocatedAt',70,12,3,1,0),(292,'round','sand','ShapeOf',87,7,2,1,0),(293,'sand','arrange','ReceivesAction',70,8,2,1,0),(294,'energetic','feeling','Is-A',112,9,2,1,0),(295,'sandwhiches','bench area','LocatedAt',112,9,2,1,0),(296,'edible','sandwhiches','PropertyOf',112,9,2,1,0),(297,'stuck','dump','DoneAt',70,8,2,1,0),(298,'employee','follow','Does',91,11,3,1,0),(299,'ink','poster','LocatedNear',70,8,2,1,0),(300,'clear','color','Is-A',91,11,3,1,0),(301,'clear','Mirror','ColorOf',66,8,3,1,0),(302,'fragile','Mirror','PropertyOf',83,10,3,1,0),(303,'afraid','paranoid','Causes',91,11,3,1,0),(304,'paranoid','shake','Causes',70,8,2,1,0),(305,'shake','action','Is-A',91,11,3,1,0),(306,'sleepy','feeling','Is-A',91,11,3,1,0),(307,'corn','hut','LocatedAt',75,9,3,1,0),(308,'edible','corn','PropertyOf',91,11,3,1,0),(309,'laptop','object','Is-A',93,15,4,1,0),(310,'breakable','laptop','PropertyOf',87,14,4,1,0),(311,'laptop','call center','LocatedAt',100,16,4,1,0),(312,'ball','yard','LocatedAt',93,15,4,1,0),(313,'bedroom','location','Is-A',91,11,3,1,0),(314,'guilty','regret','Causes',91,11,3,1,0),(315,'regret','sit','Causes',83,10,3,1,0),(316,'sit','action','Is-A',93,15,4,2,0),(317,'learning','school','DoneAt',70,8,2,1,0),(318,'tourist','exploring','Does',70,8,2,1,0),(319,'watch','Mirror','LocatedNear',87,7,2,1,0),(320,'relaxing','energize','Causes',87,7,2,1,0),(321,'apples','hut','LocatedAt',70,8,2,1,0),(322,'edible','apples','PropertyOf',70,8,2,1,0),(323,'arch','dome','LocatedAt',100,12,3,1,0),(324,'arch','object','Is-A',87,14,4,1,0),(325,'viewing','action','Is-A',91,11,3,1,0),(326,'messy','problems','LeadsTo',75,15,5,1,0),(327,'death threat','paranoid','Causes',70,4,1,1,0),(328,'paranoid','stand','Causes',70,4,1,1,0),(329,'stand','action','Is-A',70,8,2,1,0),(330,'bird','park','LocatedAt',70,4,1,1,0),(331,'relaxing','action','Is-A',70,8,2,1,0),(332,'forest','location','Is-A',70,4,1,1,0),(333,'person','visitor','CanBe',50,4,2,1,0),(334,'thinking','sitting','PurposeOf',100,8,2,1,0),(335,'sitting','standing','LeadsTo',62,5,2,1,0),(336,'glad','emotion','Is-A',125,5,1,1,1),(337,'traffic sign','sidewalk','LocatedAt',100,8,2,1,0),(338,'traffic sign','object','Is-A',100,12,3,1,0),(339,'roam','action','Is-A',100,8,2,1,0),(340,'Edgar','person','Is-A',91,11,3,1,0),(341,'gloomy','day','PropertyOf',91,11,3,1,0),(342,'sorrowful','emotion','Is-A',70,16,4,1,0),(343,'basketball','object','Is-A',91,11,3,1,0),(344,'exploring','forest','DoneAt',70,16,4,1,0),(345,'Mailman','delivery','Does',95,23,6,1,0),(346,'bird','Rizal Monument','LocatedNear',81,13,4,1,0),(347,'glass','object','Is-A',90,18,5,1,0),(348,'breakable','glass','PropertyOf',70,20,5,1,0),(349,'glass','park','LocatedAt',81,13,4,1,0),(350,'remourseful','feeling','Is-A',70,20,5,1,0),(351,'person','pro gamer','CanBe',90,18,5,1,0),(352,'spreading joy','glad','PurposeOf',70,12,3,1,0),(353,'glad','enjoy','LeadsTo',91,11,3,1,0),(354,'game console','object','Is-A',100,16,4,1,0),(355,'breakable','game console','PropertyOf',100,16,4,1,0),(356,'game console','Toy Store','LocatedAt',100,16,4,1,0),(357,'bin','bench area','LocatedAt',100,12,3,1,0),(358,'bin','object','Is-A',100,16,4,1,0),(359,'sketching','action','Is-A',93,15,4,1,0),(360,'fields','location','Is-A',100,12,3,1,0),(361,'sketching','sprain','Causes',70,4,1,1,0),(362,'sketching','sleep','LeadsTo',70,4,1,1,0),(363,'rough','box','TextureOf',70,4,1,1,0),(364,'box','carton','MadeOf',70,4,1,1,0),(365,'small','box','PropertyOf',70,8,2,1,0),(366,'pencil','school','LocatedAt',70,8,2,1,0),(367,'pencil','object','Is-A',70,8,2,1,0),(368,'crying','Rizal Park','DoneAt',100,8,2,1,0),(369,'diplomat','negotiating','Does',100,8,2,1,0),(370,'television','PS3','LocatedNear',100,8,2,1,0),(371,'regret','frown','Causes',62,5,2,2,0),(372,'ashamed','regret','Causes',70,4,1,1,0),(373,'ashamed','action','Is-A',70,4,1,1,0),(374,'regretful','regret','Synonym',70,4,1,1,0),(375,'living room','location','Is-A',70,4,1,1,0),(376,'Mirror','living room','LocatedAt',70,4,1,1,0),(377,'white','color','Is-A',70,4,1,1,0),(378,'white','Mirror','ColorOf',70,4,1,1,0),(379,'round','Mirror','ShapeOf',70,4,1,1,0),(380,'Mirror','look at','ReceivesAction',70,4,1,1,0),(381,'messy','lost stuff','LeadsTo',70,8,2,1,0),(382,'standing','stay','Causes',91,11,3,1,0),(383,'waffers','sidewalk','LocatedAt',83,10,3,1,0),(384,'edible','waffers','PropertyOf',91,11,3,1,0),(385,'happy','play','Causes',70,4,1,1,0),(386,'free','happy','Causes',70,4,1,1,0),(387,'free','action','Is-A',70,4,1,1,0),(388,'office','location','Is-A',70,4,1,1,0),(389,'Phone','office','LocatedAt',70,4,1,1,0),(390,'red','Phone','ColorOf',70,4,1,1,0),(391,'round','Phone','ShapeOf',70,4,1,1,0),(392,'limb','object','Is-A',33,4,3,1,0),(393,'breakable','limb','PropertyOf',58,7,3,1,0),(394,'limb','yard','LocatedAt',75,9,3,1,0),(395,'ugly','feeling','Is-A',100,12,3,1,0),(396,'t-rex','yard','LocatedAt',70,4,1,1,0),(397,'sleeping','action','Is-A',70,4,1,1,0),(398,'mall','location','Is-A',70,4,1,1,0),(399,'Slim Shady','person','Is-A',70,4,1,1,0),(400,'wack','day','PropertyOf',70,4,1,1,0),(401,'dope','emotion','Is-A',70,4,1,1,0),(402,'Detroit','location','Is-A',70,4,1,1,0),(403,'Rap Battle Trophy','object','Is-A',70,4,1,1,0),(404,'crying','sob','Causes',100,8,2,1,0),(405,'ice cream','Rizal Park','LocatedAt',100,8,2,1,0),(406,'edible','ice cream','PropertyOf',100,8,2,1,0),(407,'worried','paranoid','Causes',100,12,3,1,0),(408,'paranoid','crunch','Causes',83,10,3,1,0),(409,'crunch','action','Is-A',91,11,3,1,0),(410,'learning','get high grades','Causes',70,4,1,1,0),(411,'hotdogs','school','LocatedAt',70,4,1,1,0),(412,'edible','hotdogs','PropertyOf',70,4,1,1,0),(413,'leg','object','Is-A',70,4,1,1,0),(414,'breakable','leg','PropertyOf',70,4,1,1,0),(415,'leg','resort','LocatedAt',70,4,1,1,0),(416,'beutifull','hall','DoneAt',70,4,1,1,0),(417,'Writer','writing','Does',70,4,1,1,0),(418,'ball','basketball','LocatedNear',70,4,1,1,0),(419,'razor','object','Is-A',70,4,1,1,0),(420,'breakable','razor','PropertyOf',70,4,1,1,0),(421,'razor','bench area','LocatedAt',70,4,1,1,0),(422,'strolling','Rizal Park','DoneAt',70,4,1,1,0),(423,'doctor','curing','Does',83,10,3,2,0),(424,'troubled','dope','Causes',100,8,2,1,0),(425,'dope','walk','Causes',87,7,2,1,0),(426,'walk','action','Is-A',75,6,2,1,0),(427,'black','bin','ColorOf',70,4,1,1,0),(428,'bin','plastic','MadeOf',70,4,1,1,0),(429,'dirty','bin','PropertyOf',70,4,1,1,0),(430,'sharp','texture','Is-A',100,20,5,1,0),(431,'sharp','razor','TextureOf',100,20,5,1,0),(432,'razor','blades','MadeOf',103,29,7,2,0),(433,'sharp','razor','PropertyOf',100,20,5,1,0),(434,'Yellow','color','Is-A',70,6,3,1,0),(435,'Yellow','pencil','ColorOf',70,6,3,1,0),(436,'pencil','wood','MadeOf',70,6,3,1,0),(437,'long','pencil','PropertyOf',70,6,3,1,0),(438,'losing','regret','Causes',62,5,2,1,0),(439,'losing','action','Is-A',62,5,2,1,0),(440,'Rizal Monument','School','LocatedAt',62,5,2,1,0),(441,'Human-Like','shape','Is-A',62,5,2,1,0),(442,'Human-Like','Rizal Monument','ShapeOf',62,5,2,1,0),(443,'Rizal Monument','look at','ReceivesAction',62,5,2,1,0),(444,'camping','forest','DoneAt',70,6,3,1,0),(445,'waitress','talking','Does',70,6,3,1,0),(446,'note','glass','LocatedNear',70,6,3,1,0),(447,'tent','Detroit','LocatedAt',83,10,3,1,0),(448,'moving','action','Is-A',83,10,3,1,0),(449,'San Antonio','location','Is-A',83,10,3,1,0),(450,'person','chef','CanBe',70,4,1,1,0),(451,'moving','cramps','Causes',70,4,1,1,0),(452,'moving','staring','LeadsTo',70,4,1,1,0),(453,'breakable','mirror','PropertyOf',393,63,4,2,0),(454,'sad','feeling','Is-A',393,63,4,1,0),(455,'resting','hut','DoneAt',83,10,3,1,0),(456,'spoon','pepper','LocatedNear',83,10,3,1,0),(457,'chill','inmovement','Causes',100,12,3,1,0),(458,'chill','exercise','LeadsTo',100,12,3,1,0),(459,'irregular','shape','Is-A',108,13,3,1,0),(460,'irregular','razor','ShapeOf',108,13,3,1,0),(461,'useful','razor','PropertyOf',108,13,3,1,0),(462,'Cylindrical','bin','ShapeOf',100,8,2,1,0),(463,'bin','rubber','MadeOf',50,8,2,1,0),(464,'black','bin','PropertyOf',100,8,2,1,0),(465,'accomplishment','happy','Causes',100,8,2,1,0),(466,'mirror','shop','LocatedAt',100,4,1,1,0),(467,'scared','feeling','Is-A',100,4,1,1,0),(468,'reflecting','dome','DoneAt',81,13,4,1,0),(469,'pro gamer','practice','Does',56,9,4,1,0),(470,'leaf','twig','LocatedNear',81,13,4,1,0),(471,'wondering','shop','DoneAt',100,8,2,1,0),(472,'Writer','thinking','Does',100,8,2,1,0),(473,'sand bag','shell','LocatedNear',100,8,2,1,0),(474,'person','student','CanBe',100,8,2,1,0),(475,'well','idle','Causes',100,8,2,1,0),(476,'well','tell','LeadsTo',50,4,2,1,0),(477,'pout','wrinkles','Causes',100,8,2,1,0),(478,'pout','rant','LeadsTo',100,8,2,1,0),(479,'black','bottle','ColorOf',100,8,2,1,0),(480,'bottle','water','UsedFor',62,5,2,1,0),(481,'water','action','Is-A',87,7,2,1,0),(482,'Poketwatch','object','Is-A',75,6,2,1,0),(483,'breakable','Poketwatch','PropertyOf',100,8,2,1,0),(484,'Poketwatch','park','LocatedAt',87,7,2,1,0),(485,'Sorry to the man','feeling','Is-A',100,8,2,1,0),(486,'Mongkey','forest','LocatedAt',100,8,2,1,0),(487,'create a tent ','action','Is-A',62,5,2,1,0),(488,'tent','location','Is-A',87,7,2,1,0);
/*!40000 ALTER TABLE `Relation` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'Admin','9f52829cd368a64b4da2511b3560f665',0,1,1,1),(2,'1Kid','2168c5915d5452d864f273c4536d8f9e',1,1,1,0),(3,'Simba','60d28e7d879c0dc48b9a593468cf11e5',1,1,3803,13),(4,'Observer','1b65e84b7aa724b3f34c7dede00d439c',2,1,1,0),(5,'nej','1e8e42b87a65326b98ced7d3af717a72',1,1,3481,12),(6,'Soap','ab99f8f1c87bb63eee8ddc8688ce329f',1,1,3990,14),(7,'DK','2e8d6dbf9112a879d4ceb15403d10a78',1,1,5938,20),(8,'CoolJ','b1f4f9a523e36fd969f4573e25af4540',1,1,1990,7),(9,'Egoist','37349f07c95879abf625e8e7ae56170c',1,1,3814,13),(10,'Egoistic','37349f07c95879abf625e8e7ae56170c',1,1,1,0),(11,'Shakespir','ecae13117d6f0584c25a9da6c8f8415e',1,1,3224,11),(12,'allanPow','6b1d24ff83a319070db95c6c84b9be31',1,1,3797,13),(13,'Evaluator','2eed1fe0db36d674643b5f84d2adf46e',2,1,0,0),(14,'balagtas','9a5aab71aac4028688f5eda14f55f1f0',1,1,2523,9),(15,'plaridel','1edf155136294fa9120b07f3b7ddb7e1',1,1,3159,11),(16,'critic','339d8d14024f2ae5c8dc2e07362eba1d',2,1,0,0),(17,'Batman','ec0e2603172c73a8b644bb9456c1ff6e',1,1,160,1),(18,'Melvin','81dc9bdb52d04dc20036dbd8313ed055',1,1,280,1),(19,'Bob','b303a631fa328c63135ffc89bd8e4802',2,1,0,1),(20,'Amplifier','9f39702a40ad1365b1caf5c58b096891',1,1,57,1),(21,'nicoloco','4c193eb3ec2ce5f02b29eba38621bea1',1,1,469,2);
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
  `picUrl` tinytext,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `achievement`
--

LOCK TABLES `achievement` WRITE;
/*!40000 ALTER TABLE `achievement` DISABLE KEYS */;
INSERT INTO `achievement` VALUES (1,'First Story','Completed the first of many stories','images/badges/storyCount1.png'),(2,'Approval','Somebody liked your story','https://lh6.googleusercontent.com/-3yhAz7Ydk_I/UY3P6T0-m_I/AAAAAAAAA4w/l5_CbiA1_a0/w287-h278-no/Capture_medal.JPG'),(3,'Got Popular','Got a Story that was displayed as most popular','images/badges/StoryOfTheDay.PNG'),(4,'A step forward','Level up to level 2','https://lh6.googleusercontent.com/-3yhAz7Ydk_I/UY3P6T0-m_I/AAAAAAAAA4w/l5_CbiA1_a0/w287-h278-no/Capture_medal.JPG'),(5,'10 Stories','Wrote 10 Stories','images/badges/storyCount10.png'),(6,'Story Of the Day','Have a story that became the story of the week','images/badges/StoryOfTheDay.png'),(7,'Eager Writer','Made 5 stories in one day','images/badges/eagerWriter.png'),(8,'Biggest Fan','Give the most likes to a User (at Least 5 likes)',' https://lh6.googleusercontent.com/-3yhAz7Ydk_I/UY3P6T0-m_I/AAAAAAAAA4w/l5_CbiA1_a0/w287-h278-no/Capture_medal.JPG'),(9,'Rising Up','Make it to Level 10','images/badges/10thLevel.png'),(10,'Soaring Learner','Make it to level 20','images/badges/20thLevel.png'),(11,'20 Stories','Make 20 Stories','images/badges/storyCount20.png'),(12,'50 Stories','Make 50 Stories','images/badges/storyCount50.png'),(13,'Leaderboard','Be at the top 10 leaderboard','images/badges/top10leaderboard.png'),(14,'5 Likes','Have a story with 5 likes','images/badges/countLikes5.png'),(15,'Top Scorer','Be the highest average scored story for a moment','images/badges/FullConfidence.png');
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
  `Frequency` int(11) DEFAULT '1',
  PRIMARY KEY (`ConceptID`)
) ENGINE=InnoDB AUTO_INCREMENT=298 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concept`
--

LOCK TABLES `concept` WRITE;
/*!40000 ALTER TABLE `concept` DISABLE KEYS */;
INSERT INTO `concept` VALUES (1,'happy',1),(2,'person',3),(3,'game',1),(4,'animal',1),(5,'Emotion',1),(6,'Day',1),(7,'Object',1),(8,'Playing',1),(9,'well',1),(10,'house',1),(11,'black',3),(12,'rectangle',1),(13,'find',1),(14,'location',1),(15,'Smiling',1),(16,'running',1),(17,'glad',1),(18,'beach',1),(19,'red',1),(20,'cylyndrical',1),(21,'hold',1),(22,'grey',1),(23,'marble',1),(24,'remembering',1),(25,'rough',1),(26,'stone',1),(27,'expensive',1),(28,'chair',1),(29,'rest',1),(30,'park',1),(31,'Jump',1),(32,'hopping',1),(33,'cheerful',1),(34,'sidewalk',1),(35,'green',1),(36,'round',1),(37,'get',1),(38,'brown',1),(39,'rock',1),(40,'elegant',1),(41,'fence',1),(42,'walk',1),(43,'zoo',1),(44,'sand',1),(45,'surfing',1),(46,'hut',1),(47,'Niccolo',1),(48,'warm',1),(49,'mad',1),(50,'barbershop',1),(51,'PS3',1),(52,'Frown',1),(53,'hurt',1),(54,'angry',1),(55,'dump',1),(56,'blue',1),(57,'have',1),(58,'reflective',1),(59,'trouble',1),(60,'pout',1),(61,'smile',2),(62,'box',1),(63,'walking',1),(64,'shower room',1),(65,'high grades',1),(66,'resting',2),(67,'caring',1),(68,'note',1),(69,'standing',1),(70,'shaving',1),(71,'text',1),(72,'nurturing',1),(73,'wire',1),(74,'working',1),(75,'cutting',1),(76,'controller',1),(77,'employee',1),(78,'health',1),(79,'sprint',1),(80,'twig',1),(81,'fine',1),(82,'loved',1),(83,'encourage',1),(84,'light',1),(85,'plastic',2),(86,'poster',1),(87,'skating',1),(88,'pound',1),(89,'pain',1),(90,'dove',1),(91,'chill',1),(92,'yard',1),(93,'Riza',1),(94,'waiting',1),(95,'work',1),(96,'flower',1),(97,'puppet',1),(98,'sitting',1),(99,'school',1),(100,'nurse',1),(101,'cramps',1),(102,'eating',1),(103,'diplomat',1),(104,'preaching',1),(105,'writting',1),(106,'pan',1),(107,'hall',1),(108,'Dirk',1),(109,'pleasant',1),(110,'shocked',1),(111,'smartphone',1),(112,'shell',1),(113,'Simba',1),(114,'paranoid',1),(115,'bench area',1),(116,'show',1),(117,'notebook',1),(118,'learning',1),(119,'shop',1),(120,'look',1),(121,'scared',2),(122,'agitated',1),(123,'cylindrical',2),(124,'life',1),(125,'tired',1),(126,'bread',1),(127,'stomp',1),(128,'troubled',1),(129,'lawyer',2),(130,'bloodlust',1),(131,'laugh',1),(132,'waitress',1),(133,'headaches',1),(134,'display',1),(135,'weary',1),(136,'sandwhich',1),(137,'tourist',1),(138,'test tube',1),(139,'bin',1),(140,'smooth',1),(141,'glass',1),(142,'negotiate',1),(143,'pen',1),(144,'bug',1),(145,'relaxing',1),(146,'understanding',1),(147,'stage',1),(148,'dirt',1),(149,'building sand castles',1),(150,'chilled',1),(151,'crab',1),(152,'building blocks',1),(153,'doctor',2),(154,'overjoyfulness',1),(155,'Rant',2),(156,'call center',1),(157,'rectangular',1),(158,'Panic',1),(159,'Rizal Park',1),(160,'gray',1),(161,'see',1),(162,'explorating',1),(163,'comb',1),(164,'Writer',1),(165,'drinking',1),(166,'Shouting',1),(167,'off guard',1),(168,'surprise',1),(169,'resort',1),(170,'arrange',1),(171,'energetic',1),(172,'sandwhiches',1),(173,'stuck',1),(174,'follow',1),(175,'ink',1),(176,'clear',1),(177,'fragile',1),(178,'afraid',1),(179,'shake',1),(180,'sleepy',1),(181,'corn',1),(182,'laptop',1),(183,'ball',1),(184,'bedroom',1),(185,'guilty',1),(186,'sit',1),(187,'exploring',1),(188,'watch',1),(189,'energize',1),(190,'apples',1),(191,'arch',1),(192,'viewing',1),(193,'problems',1),(194,'death threat',1),(195,'stand',1),(196,'bird',1),(197,'forest',1),(198,'visitor',1),(199,'thinking',2),(200,'traffic sign',1),(201,'roam',1),(202,'Edgar',1),(203,'gloomy',1),(204,'sorrowful',1),(205,'toy store',1),(206,'basketball',1),(207,'delivery',1),(208,'remourseful',1),(209,'Diana',1),(210,'Leah',1),(211,'Video Game',1),(212,'pro gamer',1),(213,'spreading joy',1),(214,'enjoy',1),(215,'game console',1),(216,'sketching',1),(217,'fields',1),(218,'sprain',1),(219,'sleep',1),(220,'carton',1),(221,'small',1),(222,'pencil',1),(223,'crying',1),(224,'negotiating',1),(225,'television',1),(226,'ashamed',1),(227,'regretful',1),(228,'living room',1),(229,'white',1),(230,'look at',1),(231,'lost stuff',1),(232,'stay',1),(233,'waffers',1),(234,'play',1),(235,'free',1),(236,'joyful',1),(237,'office',1),(238,'limb',1),(239,'ugly',1),(240,'t-rex',1),(241,'sleeping',1),(242,'mall',1),(243,'Slim Shady',1),(244,'wack',1),(245,'dope',1),(246,'Detroit',1),(247,'Rap Battle Trophy',1),(248,'sob',1),(249,'ice cream',1),(250,'worried',1),(251,'crunch',1),(252,'get high grades',1),(253,'hotdogs',1),(254,'leg',1),(255,'beutifull',1),(256,'writing',1),(257,'razor',1),(258,'strolling',1),(259,'curing',2),(260,'dirty',1),(261,'sharp',1),(262,'blades',2),(263,'Yellow',1),(264,'wood',1),(265,'long',1),(266,'losing',1),(267,'Human-Like',1),(268,'camping',1),(269,'talking',1),(270,'tent',2),(271,'moving',1),(272,'San Antonio',1),(273,'chef',1),(274,'staring',1),(275,'mirror',2),(276,'sad',1),(277,'spoon',1),(278,'inmovement',1),(279,'exercise',1),(280,'irregular',1),(281,'useful',1),(282,'rubber',1),(283,'accomplishment',1),(284,'reflecting',1),(285,'practice',1),(286,'leaf',1),(287,'wondering',1),(288,'sand bag',1),(289,'student',1),(290,'idle',1),(291,'tell',1),(292,'wrinkles',1),(293,'water',1),(294,'Poketwatch',1),(295,'Sorry to the man',1),(296,'Mongkey',1),(297,'create a tent ',1);
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
  `ObtainDate` date DEFAULT NULL,
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
INSERT INTO `learnerachievement` VALUES (1,3,'2013-05-11'),(1,5,'2013-05-11'),(2,3,'2013-05-11'),(2,5,'2013-05-11'),(1,6,'2013-05-11'),(1,7,'2013-05-12'),(2,7,'2013-05-12'),(1,8,'2013-05-12'),(3,7,'2013-05-12'),(1,14,'2013-05-13'),(2,11,'2013-05-14'),(2,12,'2013-05-15'),(1,9,'2013-07-04'),(1,15,'2013-07-04'),(5,7,'2013-07-05'),(1,11,'2013-07-05'),(8,3,'2013-07-05'),(2,15,'2013-07-07'),(2,14,'2013-07-08'),(2,8,'2013-07-08'),(2,6,'2013-07-09'),(2,17,'2013-07-10'),(14,7,'2013-07-10'),(9,3,'2013-07-11'),(5,5,'2013-07-11'),(5,3,'2013-07-11'),(5,6,'2013-07-11'),(9,6,'2013-07-11'),(9,7,'2013-07-11'),(10,7,'2013-07-11'),(9,11,'2013-07-13'),(9,9,'2013-07-13'),(9,15,'2013-07-13'),(9,5,'2013-07-14'),(4,5,'2013-07-15'),(4,9,'2013-07-15'),(2,9,'2013-07-15'),(4,14,'2013-07-16'),(14,6,'2013-07-20'),(3,6,'2013-07-20'),(3,5,'2013-07-21'),(4,15,'2013-07-21'),(15,15,'2013-07-21'),(1,20,'2013-07-22'),(1,21,'2013-07-22'),(4,21,'2013-07-22'),(2,20,'2013-07-22'),(3,20,'2013-07-22'),(2,21,'2013-07-22'),(3,21,'2013-07-22');
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
  `LikeTime` datetime DEFAULT NULL,
  PRIMARY KEY (`key`),
  KEY `userLike` (`userID`),
  KEY `likedStory` (`storyAccomID`),
  CONSTRAINT `likedStory` FOREIGN KEY (`storyAccomID`) REFERENCES `storyaccomplishment` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userLike` FOREIGN KEY (`userID`) REFERENCES `account` (`accountID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likedstory`
--

LOCK TABLES `likedstory` WRITE;
/*!40000 ALTER TABLE `likedstory` DISABLE KEYS */;
INSERT INTO `likedstory` VALUES (3,8,1,'2013-07-18 02:01:32'),(7,10,2,'2013-07-18 02:01:32'),(8,11,3,'2013-07-18 02:01:32'),(6,6,4,'2013-07-18 02:01:32'),(11,7,5,'2013-07-18 02:01:32'),(7,20,7,'2013-07-18 02:01:32'),(7,13,8,'2013-07-18 02:01:32'),(8,9,14,'2013-07-18 02:01:32'),(8,14,15,'2013-07-18 02:01:32'),(3,21,16,'2013-07-18 02:01:32'),(3,20,17,'2013-07-18 02:01:32'),(7,7,19,'2013-07-18 02:01:32'),(7,22,20,'2013-07-18 02:01:32'),(5,21,22,'2013-07-18 02:01:32'),(3,19,27,'2013-07-18 02:01:32'),(3,18,28,'2013-07-18 02:01:32'),(11,23,29,'2013-07-18 02:01:32'),(3,24,30,'2013-07-18 02:01:32'),(9,18,35,'2013-07-18 02:01:32'),(8,26,36,'2013-07-18 02:01:32'),(9,25,37,'2013-07-18 02:01:32'),(9,21,38,'2013-07-18 02:01:32'),(7,26,39,'2013-07-18 02:01:32'),(6,25,40,'2013-07-18 02:01:32'),(6,23,41,'2013-07-18 02:01:32'),(3,22,43,'2013-07-18 02:01:32'),(3,39,45,'2013-07-18 02:01:32'),(3,38,46,'2013-07-18 02:01:32'),(3,7,48,'2013-07-18 02:01:32'),(12,32,51,'2013-07-18 02:01:32'),(8,37,52,'2013-07-18 02:01:32'),(5,48,53,'2013-07-18 02:01:32'),(5,46,54,'2013-07-18 02:01:32'),(5,50,56,'2013-07-18 02:01:32'),(5,36,57,'2013-07-18 02:01:32'),(12,49,58,'2013-07-18 02:01:32'),(12,39,59,'2013-07-18 02:01:32'),(12,40,60,'2013-07-18 02:01:32'),(12,33,61,'2013-07-18 02:01:32'),(5,51,62,'2013-07-18 02:01:32'),(7,40,63,'2013-07-18 02:01:32'),(7,54,64,'2013-07-18 02:01:32'),(12,45,65,'2013-07-18 02:01:32'),(14,55,66,'2013-07-18 02:01:32'),(15,30,69,'2013-07-18 02:01:32'),(17,56,70,'2013-07-18 02:01:32'),(17,53,71,'2013-07-18 02:01:32'),(14,63,72,'2013-07-18 02:01:32'),(14,58,73,'2013-07-18 02:01:32'),(14,44,74,'2013-07-18 02:01:32'),(15,48,75,'2013-07-18 02:01:32'),(15,40,76,'2013-07-18 02:01:32'),(14,48,77,'2013-07-18 02:01:32'),(14,40,78,'2013-07-18 02:01:32'),(14,62,79,'2013-07-18 02:01:32'),(3,56,80,'2013-07-18 02:01:32'),(3,48,81,'2013-07-18 02:01:32'),(18,66,82,'2013-07-18 02:01:32'),(9,61,83,'2013-07-18 02:01:32'),(9,48,84,'2013-07-18 02:01:32'),(14,59,85,'2013-07-18 02:01:32'),(14,49,87,'2013-07-18 02:01:32'),(14,50,89,'2013-07-18 02:01:32'),(5,65,90,'2013-07-18 02:01:32'),(5,52,91,'2013-07-18 02:01:32'),(11,68,92,'2013-07-18 02:01:32'),(12,48,94,'2013-07-18 02:01:32'),(15,69,95,'2013-07-18 02:01:32'),(15,44,96,'2013-07-18 02:01:32'),(7,51,97,'2013-07-18 02:01:32'),(3,80,98,'2013-07-18 02:01:32'),(3,66,99,'2013-07-18 02:01:32'),(5,73,100,'2013-07-18 02:01:32'),(5,77,101,'2013-07-18 02:01:32'),(12,72,102,'2013-07-18 02:01:32'),(12,54,103,'2013-07-18 02:01:32'),(12,50,104,'2013-07-18 02:01:32'),(9,81,105,'2013-07-18 02:01:32'),(11,79,106,'2013-07-18 02:01:32'),(7,75,107,'2013-07-18 02:01:32'),(7,78,108,'2013-07-18 02:01:32'),(7,74,109,'2013-07-18 02:01:32'),(14,42,110,'2013-07-18 02:01:32'),(5,62,111,'2013-07-18 02:01:32'),(15,22,112,'2013-07-18 02:01:32'),(6,22,113,'2013-07-18 02:01:32'),(11,20,114,'2013-07-18 02:01:32'),(7,72,115,'2013-07-18 02:01:32'),(5,81,116,'2013-07-18 02:01:32'),(11,48,117,'2013-07-18 02:01:32'),(6,82,118,'2013-07-18 02:01:32'),(3,86,119,'2013-07-18 02:01:32'),(5,87,120,'2013-07-18 02:01:32'),(3,76,121,'2013-07-18 02:01:32'),(15,83,122,'2013-07-18 02:13:56'),(15,82,123,'2013-07-18 02:14:02'),(15,72,124,'2013-07-18 02:14:15'),(12,80,125,'2013-07-20 01:27:13'),(15,80,126,'2013-07-20 01:27:45'),(15,81,127,'2013-07-20 01:27:48'),(15,73,129,'2013-07-20 13:06:42'),(15,74,130,'2013-07-20 13:06:44'),(3,81,131,'2013-07-20 13:07:00'),(3,78,132,'2013-07-20 13:07:05'),(3,74,133,'2013-07-20 13:07:08'),(5,74,134,'2013-07-20 13:46:33'),(5,63,135,'2013-07-20 13:46:47'),(14,74,136,'2013-07-20 13:48:09'),(3,83,137,'2013-07-21 01:08:19'),(12,83,138,'2013-07-21 01:09:15'),(21,89,139,'2013-07-22 20:48:56'),(20,91,141,'2013-07-22 20:50:16'),(20,90,142,'2013-07-22 20:50:17'),(7,91,143,'2013-07-22 20:51:13'),(5,80,144,'2013-07-23 14:40:39');
/*!40000 ALTER TABLE `likedstory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifMessage`
--

DROP TABLE IF EXISTS `notifMessage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notifMessage` (
  `MsgID` int(11) NOT NULL AUTO_INCREMENT,
  `nType` int(11) DEFAULT NULL,
  `NotifID` int(11) DEFAULT NULL,
  `Message` text,
  `creationTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`MsgID`),
  KEY `notifType` (`nType`),
  KEY `SelectedNotification` (`NotifID`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifMessage`
--

LOCK TABLES `notifMessage` WRITE;
/*!40000 ALTER TABLE `notifMessage` DISABLE KEYS */;
INSERT INTO `notifMessage` VALUES (1,1,1,'You Achieved to get you Story to be Most popular','2013-07-07 00:17:26'),(2,2,1,'Simba Liked Your story Gloomy Dirk','2013-07-07 00:17:26'),(3,1,1,'You Earned the Approval Achievement from the Like of Simba','2013-07-07 00:17:26'),(4,4,2,'You made it to number 6 in the leaderboard','2013-07-07 00:17:26'),(5,2,3,'allanPowLiked your story Razor by the bench ','2013-07-07 15:20:40'),(6,2,4,'allanPowLiked your story Discovering School ','2013-07-07 15:21:02'),(7,2,2,'allanPowLiked your story Scary break ','2013-07-07 15:21:09'),(8,3,5,'Observer Gave a score of 173 for Yard trip  ','2013-07-08 03:11:44'),(9,2,6,'EgoistLiked your story The razor left to see ','2013-07-08 03:12:50'),(10,2,7,'ShakespirLiked your story Cloudy outside the hut ','2013-07-08 03:13:26'),(11,2,8,'DKLiked your story the stroll in the forest ','2013-07-08 13:05:08'),(12,3,6,'critic Gave a score of 180 for Artist on the bench  ','2013-07-09 02:07:47'),(13,2,9,'DK Liked your story Edgar with the barbers ','2013-07-09 02:42:27'),(14,2,10,'DK Liked your story Regret on this day ','2013-07-09 06:11:11'),(15,3,4,'critic Gave a score of 320 for The cutting Cashier  ','2013-07-09 07:31:32'),(16,3,10,'Observer Gave a score of 347 for Sam at work  ','2013-07-10 08:39:21'),(17,2,11,'balagtas Liked your story The paranoia effect ','2013-07-10 08:41:10'),(18,2,12,'nej Liked your story 8 Mile ','2013-07-10 08:58:31'),(19,2,6,'plaridel Liked your story Dirk and the Beach ','2013-07-10 10:27:09'),(20,2,13,'Soap Liked your story Gloomy Dirk ','2013-07-10 10:27:37'),(21,2,14,'Shakespir Liked your story Gloomy Dirk ','2013-07-10 10:47:10'),(22,2,15,'DK Liked your story Razor by the bench ','2013-07-10 10:48:26'),(23,2,16,'nej Liked your story The razor left to see ','2013-07-10 10:55:02'),(24,1,17,'You earned the 5 Likes achievement <img src=\'images/badges/countLikes5.png\'/>','2013-07-10 12:03:45'),(25,2,17,'Shakespir Liked your story Gloomy Dirk ','2013-07-10 12:03:45'),(26,3,18,'Observer Gave a score of 170 for Sidewalk discovery  ','2013-07-11 05:16:16'),(27,3,19,'Observer Gave a score of 367 for Sob in the park  ','2013-07-11 05:16:37'),(28,3,18,'Evaluator Gave a score of 93 for Spicy day  ','2013-07-11 05:17:11'),(29,3,20,'critic Gave a score of 400 for Scary break  ','2013-07-11 05:23:47'),(30,1,20,'You earned the Rising Up achievement  Keep it up<img src=\'images/badges/10thLevel.png\' width=\'30\' height=\'30\'/>','2013-07-11 05:23:47'),(31,1,21,'You earned the 10 Stories achievement Be ready to make more<img src=\'images/badges/storyCount10.png\' width=\'30\' height=\'30\'/>','2013-07-11 05:52:08'),(32,2,22,'Soap Liked your story Black Bin ','2013-07-11 05:52:32'),(33,2,23,'Simba Liked your story Dirk in the shop ','2013-07-11 06:36:45'),(34,3,24,'critic Gave a score of 77 for Simba the Mailman  ','2013-07-11 06:40:01'),(35,3,25,'Evaluator Gave a score of 70 for The story of today  ','2013-07-11 14:52:57'),(36,3,25,'Evaluator Gave a score of 347 for Scary break  ','2013-07-11 14:53:11'),(37,5,25,'You are now level 12','2013-07-11 14:53:11'),(38,3,26,'Evaluator Gave a score of 280 for Gloom in Dome  ','2013-07-11 14:53:51'),(39,5,26,'You are now level 10','2013-07-11 14:53:51'),(40,1,26,'You earned the Rising Up achievement  Keep it up <img src=\'images/badges/10thLevel.png\' width=\'30\' height=\'30\'/>','2013-07-11 14:53:51'),(41,3,26,'Evaluator Gave a score of 240 for Dirk in the shop  ','2013-07-11 14:54:04'),(42,5,26,'You are now level 11','2013-07-11 14:54:04'),(43,3,27,'Observer Gave a score of 267 for Sam and Niccolo  ','2013-07-11 15:39:57'),(44,5,27,'You are now level 12','2013-07-11 15:39:57'),(45,3,9,'Observer Gave a score of 400 for Edgar with the barbers  ','2013-07-11 15:40:16'),(46,5,9,'You are now level 8','2013-07-11 15:40:16'),(47,3,28,'Observer Gave a score of 307 for Author turned cashier  ','2013-07-11 15:40:34'),(48,5,28,'You are now level 7','2013-07-11 15:40:34'),(49,3,29,'Observer Gave a score of 67 for Cashier the fiendish friend  ','2013-07-11 15:52:13'),(50,1,29,'You earned the Rising Up achievement  Keep it up <img src=\'images/badges/10thLevel.png\' width=\'30\' height=\'30\'/>','2013-07-11 15:52:13'),(51,1,29,'You earned the Soaring Learner achievement You have done so much <img src=\'images/badges/20thLevel.png\' width=\'30\' height=\'30\'/>','2013-07-11 15:52:14'),(52,3,27,'Observer Gave a score of 267 for Gloom in Dome  ','2013-07-11 15:54:44'),(53,5,27,'You are now level 13','2013-07-11 15:54:44'),(54,3,30,'Observer Gave a score of 77 for The feels  ','2013-07-11 15:57:17'),(55,3,31,'Observer Gave a score of 83 for Spicy break  ','2013-07-13 02:19:48'),(56,5,31,'You are now level 10','2013-07-13 02:19:48'),(57,1,31,'You earned the Rising Up achievement  Keep it up <img src=\'images/badges/10thLevel.png\' width=\'30\' height=\'30\'/>','2013-07-13 02:19:48'),(58,3,30,'Observer Gave a score of 87 for Lady\'s meal  ','2013-07-13 02:23:37'),(59,3,30,'critic Gave a score of 63 for Black Bin  ','2013-07-13 03:33:19'),(60,3,27,'critic Gave a score of 347 for Gloom in Dome  ','2013-07-13 03:46:21'),(61,5,27,'You are now level 14','2013-07-13 03:46:21'),(62,3,31,'Evaluator Gave a score of 33 for Touring repair man  ','2013-07-13 06:59:04'),(63,3,5,'Evaluator Gave a score of 187 for Yard trip  ','2013-07-13 07:00:18'),(64,5,5,'You are now level 13','2013-07-13 07:00:18'),(65,1,5,'You earned the Rising Up achievement  Keep it up <img src=\'images/badges/10thLevel.png\' width=\'30\' height=\'30\'/>','2013-07-13 07:00:18'),(66,3,9,'Evaluator Gave a score of 467 for standing lady  ','2013-07-13 07:03:19'),(67,5,9,'You are now level 10','2013-07-13 07:03:19'),(68,1,9,'You earned the Rising Up achievement  Keep it up <img src=\'images/badges/10thLevel.png\' width=\'30\' height=\'30\'/>','2013-07-13 07:03:19'),(69,3,25,'Evaluator Gave a score of 165 for Dome Trip  ','2013-07-13 07:12:26'),(70,5,25,'You are now level 13','2013-07-13 07:12:26'),(71,2,32,'nej Liked your story Sam and Niccolo ','2013-07-13 07:15:38'),(72,3,31,'Observer Gave a score of 87 for Dirk and the Beach Your total score is 2780. Your are 6 in the Leader board ','2013-07-14 00:53:45'),(73,3,31,'Observer Gave a score of 167 for Sit now my friend Your total score is 2867. Your are 6 in the Leader board ','2013-07-14 00:54:06'),(74,5,31,'You are now level 11','2013-07-14 00:54:06'),(75,3,33,'Evaluator Gave a score of 87 for Traveler\'s meeting Your total score is 2684. Your are 8 in the Leader board ','2013-07-14 00:55:35'),(76,5,33,'You are now level 10','2013-07-14 00:55:35'),(77,1,33,'You earned the Rising Up achievement  Keep it up <img src=\'images/badges/10thLevel.png\' width=\'30\' height=\'30\'/>','2013-07-14 00:55:35'),(78,3,33,'Evaluator Gave a score of 280 for The aftermath of achievement Your total score is 2771. Your are 7 in the Leader board ','2013-07-14 00:55:50'),(79,5,33,'You are now level 11','2013-07-14 00:55:50'),(80,3,5,'Observer Gave a score of 80 for Cloud at the beach Your total score is 3647. Your are 5 in the Leader board ','2013-07-15 14:35:02'),(81,3,34,'Evaluator Gave a score of 93 for Lady\'s meal Your total score is 3051. Your are 6 in the Leader board ','2013-07-15 14:36:52'),(82,3,34,'Evaluator Gave a score of 87 for Lady\'s meal Your total score is 3144. Your are 6 in the Leader board ','2013-07-15 14:38:29'),(83,3,35,'Evaluator Gave a score of 100 for Cashier and the desire of toys Your total score is 3703. Your are 5 in the Leader board ','2013-07-15 14:39:31'),(84,3,28,'Evaluator Gave a score of 230 for Dope! Your total score is 2061. Your are 9 in the Leader board ','2013-07-15 14:43:49'),(85,5,28,'You are now level 8','2013-07-15 14:43:49'),(86,3,36,'Observer Gave a score of 190 for Artist on the bench Your total score is 3034. Your are 7 in the Leader board ','2013-07-15 15:34:43'),(87,3,34,'critic Gave a score of 250 for Dirk\'s Hut Your total score is 3231. Your are 6 in the Leader board ','2013-07-15 15:37:41'),(88,5,34,'You are now level 12','2013-07-15 15:37:41'),(89,1,34,'You earned the A step forward achievement  You have progressed <img src=\'https://lh6.googleusercontent.com/-3yhAz7Ydk_I/UY3P6T0-m_I/AAAAAAAAA4w/l5_CbiA1_a0/w287-h278-no/Capture_medal.JPG\' width=\'30\' height=\'30\'/>','2013-07-15 15:37:41'),(90,3,5,'Observer Gave a score of 87 for Painful Memories Your total score is 3727. Your are 5 in the Leader board ','2013-07-15 15:50:19'),(91,1,5,'You earned the A step forward achievement  You have progressed <img src=\'https://lh6.googleusercontent.com/-3yhAz7Ydk_I/UY3P6T0-m_I/AAAAAAAAA4w/l5_CbiA1_a0/w287-h278-no/Capture_medal.JPG\' width=\'30\' height=\'30\'/>','2013-07-15 15:50:19'),(92,2,37,'Simba Liked your story Detroit Trip ','2013-07-15 15:51:11'),(93,3,28,'Observer Gave a score of 232 for Paranoia effect Your total score is 2291. Your are 9 in the Leader board ','2013-07-15 17:19:04'),(94,5,28,'You are now level 9','2013-07-15 17:19:04'),(95,1,28,'You earned the A step forward achievement  You have progressed <img src=\'https://lh6.googleusercontent.com/-3yhAz7Ydk_I/UY3P6T0-m_I/AAAAAAAAA4w/l5_CbiA1_a0/w287-h278-no/Capture_medal.JPG\' width=\'30\' height=\'30\'/>','2013-07-15 17:19:04'),(96,2,38,'plaridel Liked your story The aftermath of achievement ','2013-07-17 18:13:57'),(97,2,38,'plaridel Liked your story Black Bin ','2013-07-17 18:14:03'),(98,2,38,'plaridel Liked your story Razor by the bench ','2013-07-17 18:14:15'),(99,2,39,'allanPow Liked your story The cutting Cashier ','2013-07-19 17:27:13'),(100,2,39,'plaridel Liked your story The cutting Cashier ','2013-07-19 17:27:45'),(101,2,40,'plaridel Liked your story The razor left to see ','2013-07-19 17:27:48'),(102,2,41,'plaridel Liked your story Edgar with the barbers ','2013-07-20 05:06:35'),(103,2,42,'plaridel Liked your story describing Pencils ','2013-07-20 05:06:42'),(104,2,43,'plaridel Liked your story Regret on this day ','2013-07-20 05:06:44'),(105,2,40,'Simba Liked your story The razor left to see ','2013-07-20 05:07:00'),(106,2,41,'Simba Liked your story Edgar with the barbers ','2013-07-20 05:07:05'),(107,2,43,'Simba Liked your story Regret on this day ','2013-07-20 05:07:08'),(108,2,44,'nej Liked your story Regret on this day ','2013-07-20 05:46:33'),(109,2,45,'nej Liked your story Sob in the park ','2013-07-20 05:46:47'),(110,2,46,'balagtas Liked your story Regret on this day ','2013-07-20 05:48:10'),(111,1,46,'You earned the 5 Likes achievement  <img src=\'images/badges/countLikes5.png\' width=\'30\' height=\'30\'/>','2013-07-20 05:48:10'),(112,1,46,'You earned the Got Popular achievement Your story is the most liked today <img src=\'images/badges/StoryOfTheDay.PNG\' width=\'30\' height=\'30\'/>','2013-07-20 05:48:10'),(113,2,47,'Simba Liked your story The aftermath of achievement ','2013-07-20 17:08:19'),(114,2,48,'allanPow Liked your story The aftermath of achievement ','2013-07-20 17:09:15'),(115,1,48,'You earned the Got Popular achievement Your story is the most liked today <img src=\'images/badges/StoryOfTheDay.PNG\' width=\'30\' height=\'30\'/>','2013-07-20 17:09:16'),(116,3,49,'Observer Gave a score of 402 for standing lady Your total score is 2757. Your are 8 in the Leader board ','2013-07-20 17:10:59'),(117,5,49,'You are now level 11','2013-07-20 17:11:00'),(118,1,49,'You earned the A step forward achievement  You have progressed <img src=\'https://lh6.googleusercontent.com/-3yhAz7Ydk_I/UY3P6T0-m_I/AAAAAAAAA4w/l5_CbiA1_a0/w287-h278-no/Capture_medal.JPG\' width=\'30\' height=\'30\'/>','2013-07-20 17:11:00'),(119,1,49,'You earned the Top Scorer achievement  <img src=\'images/badges/FullConfidence.png\' width=\'30\' height=\'30\'/>','2013-07-20 17:11:00'),(120,1,50,'You earned the First Story achievement Be ready to make more <img src=\'images/badges/storyCount1.png\' width=\'30\' height=\'30\'/>','2013-07-22 12:20:17'),(121,3,51,'Observer Gave a score of 57 for Bottle Your total score is 0. Your are 15 in the Leader board ','2013-07-22 12:24:51'),(122,1,52,'You earned the First Story achievement Be ready to make more <img src=\'images/badges/storyCount1.png\' width=\'30\' height=\'30\'/>','2013-07-22 12:40:22'),(123,3,52,'Observer Gave a score of 331 for The Broken Poketwatch Your total score is 0. Your are 16 in the Leader board ','2013-07-22 12:41:03'),(124,5,52,'You are now level 2','2013-07-22 12:41:03'),(125,1,52,'You earned the A step forward achievement  You have progressed <img src=\'https://lh6.googleusercontent.com/-3yhAz7Ydk_I/UY3P6T0-m_I/AAAAAAAAA4w/l5_CbiA1_a0/w287-h278-no/Capture_medal.JPG\' width=\'30\' height=\'30\'/>','2013-07-22 12:41:04'),(126,3,53,'Observer Gave a score of 138 for Trip to the forest Your total score is 331. Your are 11 in the Leader board ','2013-07-22 12:45:27'),(127,2,54,'nicoloco Liked your story Bottle ','2013-07-22 12:48:56'),(128,1,54,'You earned the Got Popular achievement Your story is the most liked today <img src=\'images/badges/StoryOfTheDay.PNG\' width=\'30\' height=\'30\'/>','2013-07-22 12:48:57'),(129,2,55,'nicoloco Liked your story Trip to the forest ','2013-07-22 12:50:05'),(130,2,55,'Amplifier Liked your story Trip to the forest ','2013-07-22 12:50:16'),(131,2,55,'Amplifier Liked your story The Broken Poketwatch ','2013-07-22 12:50:17'),(132,2,56,'DK Liked your story Trip to the forest ','2013-07-22 12:51:14'),(133,1,56,'You earned the Got Popular achievement Your story is the most liked today <img src=\'images/badges/StoryOfTheDay.PNG\' width=\'30\' height=\'30\'/>','2013-07-22 12:51:14'),(134,2,57,'nej Liked your story The cutting Cashier ','2013-07-23 06:40:39');
/*!40000 ALTER TABLE `notifMessage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificationType`
--

DROP TABLE IF EXISTS `notificationType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notificationType` (
  `typeID` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`typeID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificationType`
--

LOCK TABLES `notificationType` WRITE;
/*!40000 ALTER TABLE `notificationType` DISABLE KEYS */;
INSERT INTO `notificationType` VALUES (1,'Achievement Unlock'),(2,'Story Likes'),(3,'Story Checked'),(4,'Leader Board Update'),(5,'Level Change'),(6,'Featured Story');
/*!40000 ALTER TABLE `notificationType` ENABLE KEYS */;
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
INSERT INTO `profile` VALUES (1,'https://lh6.googleusercontent.com/-m9fg-PraoOQ/ToJBwdqN5oI/AAAAAAAAAvY/4MIdYdiGL-4/s900/go_on.png','2004-05-14','Unang','Bata'),(2,'https://lh5.googleusercontent.com/-5bWTfwJ0sGc/ToJBrESx7uI/AAAAAAAAAvU/ejJFyHQr3S4/s379/new-n.png','2006-03-07','Ronald','Makata'),(3,'https://lh5.googleusercontent.com/-2vDGOCmN6Oc/TsTlO4YsV5I/AAAAAAAAAyU/I0aqImK3Ch4/s700/Bg1.jpg','2002-04-26','Simba','Lionpride'),(4,'https://lh3.googleusercontent.com/-MrlVW_9Q9SI/ToJBkvamTTI/AAAAAAAAAvQ/qNa3xLCmWXM/w615-h560-p-k/n-eye.png','2003-06-19','Ray','Brighteye'),(5,'https://lh6.googleusercontent.com/-3DGGXrcDeFw/TerHo3ynfGI/AAAAAAAAAr4/Rr6Y7BiIHNM/s425/N-Stamp1.png','2003-02-07','Neji','Hyuga'),(6,'https://lh6.googleusercontent.com/-uUvi-LYD3bI/TnwMpoYHVUI/AAAAAAAAA3E/QY88r8bjcJE/w253-h252-n-k/grass_Field.png','2007-11-02','John','Mactavish'),(7,'https://lh3.googleusercontent.com/-OBoqr4-N46M/SM4frFVUP3I/AAAAAAAAACo/wdwOSRgs-CY/w246-h241-n-k/L.invader%2528deathknight%2529.JPG','2008-03-30','Death','Knight'),(8,'https://lh3.googleusercontent.com/-KwiBwCTn3tQ/SjtI245jGwI/AAAAAAAAAYM/GCWT_ahQ-kE/s700/BeNeat.png','2005-05-31','Jackster','Frostwave'),(9,'https://lh3.googleusercontent.com/-uGiDJ6FLvB8/SPn4gonP1lI/AAAAAAAAAFc/WLzjMuoYyak/w398-h316-n-k/Biohazard_quake.jpg','2008-09-04','Trenor','Kenway'),(10,'https://lh5.googleusercontent.com/-z04xeOdenEk/SpJL2u8hXAI/AAAAAAAAAdM/8E5si3TpDQw/s335/eye-c.png','2006-08-20','Norm','Dapirdefool'),(11,'https://lh5.googleusercontent.com/--C_MdqzZ4MI/S81DtEy985I/AAAAAAAAAnE/ppopQ19SbKU/s334/Logotemp1.png','2005-10-24','William','Owleye'),(12,'upPics/Red_Profile_1691706229.jpg','2007-04-05','Edgar Da','Poet'),(13,'https://lh3.googleusercontent.com/-MrlVW_9Q9SI/ToJBkvamTTI/AAAAAAAAAvQ/qNa3xLCmWXM/w615-h560-p-k/n-eye.png','1991-06-28','Brendan','The Bright'),(14,'upPics/dis_188257026.jpg','2005-09-15','Fransisco','Baltazar'),(15,'upPics/logo_992108506_806878564.png','2006-10-17','Marcelo','del Pillar'),(16,'upPics/AlbumArt_{4549601C-CD58-4F44-8568-3DCF3F2297C5}_Large_476665440.jpg','1990-05-01','Meta','Critic'),(17,'upPics/AlbumArt_{83E282C5-EE33-499C-A63F-04A3229DF427}_Large_1760411668.jpg','2010-07-19','Bruce','Wayne'),(18,'upPics/Screenshot from 2013-04-26 11:29:35_1907531395.png','2007-02-04','Melvin','Bautista'),(19,'upPics/NotificationsInStorySense_1085746325.png','2010-09-12','Tyrus','Shan'),(20,'upPics/MyEvilSister_390645313.jpg','2001-10-30','Ampy','Jimenez'),(21,'upPics/dorae_209637579.jpg','2005-08-01','nicolo','Jimenez');
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
  `Confidence` float DEFAULT '0.5',
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
INSERT INTO `rating` VALUES (7,4,10,0.5),(1,4,5,0.5),(17,4,10,0.5),(27,4,25,0.5),(4,4,40,0.5),(42,4,30,0.5),(10,4,30,0.5),(1,13,20,0.5),(6,13,30,0.5),(7,13,40,0.5),(48,13,180,0.5),(46,13,200,0.5),(12,4,220,0.5),(10,13,170,0.5),(37,13,110,0.5),(20,13,125,0.5),(13,16,105,0.5),(21,4,130,0.5),(19,4,65,0.5),(38,4,120,0.5),(35,16,115,0.5),(47,16,125,0.5),(15,16,95,0.5),(25,16,375,0.5),(26,16,375,0.5),(54,16,170,0.5),(8,16,145,0.5),(48,16,165,0.5),(4,13,135,0.5),(49,13,115,0.5),(48,4,160,0.5),(7,16,135,0.5),(21,16,220,0.5),(57,4,45,0.5),(60,16,90,0.5),(49,4,125,0.5),(39,4,120,0.5),(11,4,110,0.5),(19,13,75,0.5),(24,13,120,0.5),(64,13,135,0.5),(23,4,55,0.5),(29,4,385,0.5),(32,4,125,0.5),(50,4,135,0.5),(46,4,215,0.5),(31,4,125,0.5),(16,4,85,0.5),(6,16,120,0.5),(11,16,130,0.5),(32,13,145,0.5),(33,16,120,0.5),(12,16,190,0.5),(37,4,115,0.5),(28,16,110,0.5),(47,13,115,0.5),(14,16,115,0.5),(20,16,100,0.5),(34,4,100,0.5),(72,4,70,0.5),(72,16,80,0.5),(73,4,80,0.5),(1,16,64,0.5),(74,4,84,0.5),(73,13,100,0.5),(41,13,300,0.5),(75,4,293,0.5),(75,16,293,0.5),(72,13,80,0.5),(76,4,173,0.5),(9,16,73,0.5),(79,4,347,0.5),(78,16,400,0.5),(22,16,87,0.5),(76,13,173,0.5),(79,13,347,0.5),(78,13,400,0.5),(81,13,90,0.5),(30,16,73,0.5),(81,16,90,0.5),(55,13,347,0.5),(72,13,80,0.5),(80,13,293,0.5),(2,4,100,0.5),(41,4,240,0.5),(60,4,170,0.5),(36,4,173,0.5),(51,16,180,0.5),(80,16,320,0.5),(35,4,347,0.5),(45,4,170,0.5),(63,4,367,0.5),(2,13,93,0.5),(50,16,400,0.5),(24,16,77,0.5),(11,13,70,0.5),(50,13,347,0.5),(85,13,280,0.5),(86,13,240,0.5),(87,4,267,0.5),(78,4,400,0.5),(88,4,307,0.5),(9,4,67,0.5),(85,4,267,0.5),(6,4,77,0.5),(15,4,83,0.5),(13,4,87,0.5),(82,16,63,0.5),(85,16,347,0.5),(14,13,33,0.5),(36,13,187,0.5),(58,13,467,0.5),(40,13,165,0.5),(22,4,87,0.5),(44,4,167,0.5),(27,13,87,0.5),(83,13,280,0.5),(20,4,80,0.5),(13,13,87,0.866667),(23,13,100,1),(70,13,230,0.766667),(51,4,190,0.95),(34,16,250,0.833333),(28,4,87,0.866667),(64,4,232,0.766667),(58,4,402,0.8),(89,4,57,0.56),(90,4,331,0.825),(91,4,138,0.683333);
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relationship`
--

LOCK TABLES `relationship` WRITE;
/*!40000 ALTER TABLE `relationship` DISABLE KEYS */;
INSERT INTO `relationship` VALUES (1,'Is-a','is considered as a'),(2,'Causes','Results to '),(3,'LocatedAt','is located at'),(4,'UsedFor','is used for'),(5,'Synonym','is synonymous to'),(6,'ColorOf','is the color of'),(7,'ShapeOf','is in the shape of'),(8,'ReceivesAction','Recieves the action'),(9,'DoneAt','is Done at'),(10,'HasA','possesses'),(11,'Desires','wants'),(12,'CapableOf','can'),(13,'DefinedAs','is defined as'),(14,'LeadsTo','Leads to'),(15,'PropertyOf','is a property of'),(16,'MadeOf','is made of'),(17,'PartOf','is a part of'),(18,'CanBe','Can become'),(19,'Does','Does'),(20,'GenderOf','is the gender of'),(21,'LocatedNear','is located near'),(22,'PurposeOf','has the purpose of'),(23,'TextureOf','has the texture');
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
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storyaccomplishment`
--

LOCK TABLES `storyaccomplishment` WRITE;
/*!40000 ALTER TABLE `storyaccomplishment` DISABLE KEYS */;
INSERT INTO `storyaccomplishment` VALUES (1,1,3,'The introduction of Simba','uploadedFiles/The introduction of Simba522066365Simba.story','2013-01-23 16:00:00'),(2,2,3,'Spicy day','uploadedFiles/Spicy1844764482Simba.story','2013-01-24 09:18:33'),(4,2,7,'School trip','uploadedFiles/School trip1350866152DK.story','2013-01-25 06:28:53'),(6,1,5,'The feels','uploadedFiles/The feels1686661008Simba.story','2013-02-13 05:49:47'),(7,4,5,'Feed Dirk','uploadedFiles/Feed dirk615881354nej.story','2013-02-19 18:27:41'),(8,3,7,'The feels','uploadedFiles/Mad feelings1171126013DK.story','2013-02-19 18:53:01'),(9,1,7,'Cashier the fiendish friend','uploadedFiles/Cashier the fiendish friend1747797714DK.story','2013-02-19 18:54:46'),(10,1,3,'Bottle story','uploadedFiles/Bottle story1661603083Simba.story','2013-02-19 19:03:08'),(11,1,3,'The story of today','uploadedFiles/The story of today1925610500Simba.story','2013-02-20 03:44:20'),(12,1,7,'Me in the Park','uploadedFiles/Me in the Park470420369DK.story','2013-02-21 08:35:45'),(13,1,5,'Lady\'s meal','uploadedFiles/Lady\'s meal1607503622nej.story','2013-02-21 08:59:28'),(14,1,11,'Touring repair man','uploadedFiles/Touring repair man1726652230Shakespir.story','2013-02-21 09:01:32'),(15,1,11,'Spicy break','uploadedFiles/Spicy break516578976Shakespir.story','2013-02-21 09:02:45'),(16,1,8,'Sidewalk trip','uploadedFiles/Sidewalk trip24628589CoolJ.story','2013-02-21 09:07:44'),(17,1,8,'mirror on the barber\'s wall','uploadedFiles/mirror on the barber\'s wall1518269048CoolJ.story','2013-02-21 09:09:54'),(18,1,8,'Biag\'s Hut','uploadedFiles/Biag\'s Hut874318666CoolJ.story','2013-02-21 09:11:41'),(19,1,8,'The yard story','uploadedFiles/The yard story1534586655CoolJ.story','2013-02-21 09:12:45'),(20,1,9,'Cloud at the beach','uploadedFiles/Cloud at the beach1812684503Egoist.story','2013-02-21 09:21:22'),(21,1,7,'A walk in the beach','uploadedFiles/A walk in the beach92131486DK.story','2013-02-27 03:57:39'),(22,1,11,'Dirk and the Beach','uploadedFiles/Dirk and the Beach1894789253Shakespir.story','2013-03-04 03:17:33'),(23,1,3,'Cashier and the desire of toys','uploadedFiles/Cashier and the desire of toys90992946Simba.story','2013-03-04 07:46:40'),(24,1,11,'Simba the Mailman','uploadedFiles/Simba the Mailman1452303078Shakespir.story','2013-03-05 03:45:19'),(25,1,11,'Cloudy Monday','uploadedFiles/Cloudy Monday416911549Shakespir.story','2013-03-06 01:17:49'),(26,1,9,'Paranoid Saturday','uploadedFiles/Paranoid Saturday703901877Egoist.story','2013-03-06 03:56:13'),(27,1,5,'Traveler\'s meeting','uploadedFiles/Traveler\'s meeting1413808606nej.story','2013-03-07 04:09:54'),(28,1,9,'Painful Memories','uploadedFiles/Painful Memories1200837330Egoist.story','2013-03-07 04:15:00'),(29,1,9,'Shock and Sand','uploadedFiles/Shock and Sand2068104426Egoist.story','2013-03-07 12:36:41'),(30,1,6,'Hunger and other feelings','uploadedFiles/Hunger and other feelings1427040520Soap.story','2013-03-08 02:13:37'),(31,1,6,'To the dump Cashier','uploadedFiles/To the dump Cashier1911746326Soap.story','2013-03-08 02:15:48'),(32,1,8,'Fragile Sight','uploadedFiles/Fragile Sight442407635CoolJ.story','2013-03-08 12:00:17'),(33,1,6,'That feeling','uploadedFiles/That feeling1992367868Soap.story','2013-03-08 12:19:26'),(34,5,5,'Dirk\'s Hut','uploadedFiles/Dirk\'s Hut143506695nej.story','2013-03-08 12:48:57'),(35,9,6,'Sam at work','uploadedFiles/Sam at work1007987157Soap.story','2013-03-08 13:41:56'),(36,3,9,'Yard trip','uploadedFiles/Yard trip1527984414Egoist.story','2013-03-08 13:54:14'),(37,5,3,'Guilt and regret','uploadedFiles/Guilt and regret1693747156Simba.story','2013-03-08 15:24:06'),(38,7,7,'Dirk in School','uploadedFiles/Dirk in School633682062DK.story','2013-03-08 15:33:05'),(39,10,6,'Repair man and the day off','uploadedFiles/Repair man and the day off555158416Soap.story','2013-03-08 15:36:53'),(40,3,3,'Dome Trip','uploadedFiles/Dome Trip591865803Simba.story','2013-03-09 12:38:29'),(41,6,12,'Simba with Toys','uploadedFiles/Simba with Toys938701577allanPow.story','2013-03-10 06:31:46'),(42,5,5,'The paranoia effect','uploadedFiles/The paranoia effect1742983130nej.story','2013-03-11 08:42:10'),(43,3,8,'From Park to forest','uploadedFiles/From Park to forest1758978212CoolJ.story','2013-03-11 08:49:46'),(44,8,11,'Sit now my friend','uploadedFiles/Sit now my friend346657459Shakespir.story','2013-03-11 08:51:32'),(45,3,3,'Sidewalk discovery','uploadedFiles/Sidewalk discovery1218950115Simba.story','2013-03-11 09:05:58'),(46,4,12,'Meet Edgar','uploadedFiles/Meet Edgar1829516309allanPow.story','2013-03-13 01:49:26'),(47,7,12,'Boy goes to forest','uploadedFiles/Boy goes to forest1873939551allanPow.story','2013-03-13 02:48:46'),(48,9,7,'Gloomy Dirk','uploadedFiles/Gloomy Dirk287544367DK.story','2013-03-13 02:50:56'),(49,8,7,'pro gamer enjoy','uploadedFiles/pro gamer enjoy604861555DK.story','2013-03-13 03:01:10'),(50,9,3,'Scary break','uploadedFiles/Scary break322143325Simba.story','2013-03-13 03:01:42'),(51,3,11,'Artist on the bench','uploadedFiles/Artist on the bench2095045337Shakespir.story','2013-03-13 03:03:14'),(52,8,9,'sketch to sleep','uploadedFiles/sketch to sleep1748470493Egoist.story','2013-03-23 03:25:24'),(53,2,7,'Alex','uploadedFiles/Alex1502990697DK.story','2013-03-23 03:29:20'),(54,3,7,'Discovering School','uploadedFiles/Discovering School1636135812DK.story','2013-03-23 03:32:22'),(55,7,5,'Edgar in the Park','uploadedFiles/Edgar in the Park517512655nej.story','2013-03-30 10:32:07'),(56,1,12,'regretful reflection','uploadedFiles/regretful reflection1837809899allanPow.story','2013-04-12 06:02:48'),(57,6,14,'Pleasant day in toy store','uploadedFiles/Pleasant day in toy store1194683947balagtas.story','2013-04-14 09:29:41'),(58,10,15,'standing lady','uploadedFiles/standing lady555476753plaridel.story','2013-04-14 10:26:18'),(59,1,7,'Happy Monday','uploadedFiles/Happy Monday1337116182DK.story','2013-04-15 01:14:59'),(60,9,15,'Kobe Injury','uploadedFiles/Kobe Injury303250354plaridel.story','2013-04-15 05:05:51'),(61,3,14,'Trip to the yard','uploadedFiles/Trip to the yard954711124balagtas.story','2013-04-15 05:27:20'),(62,4,17,'8 Mile','uploadedFiles/8 Mile1049232025Batman.story','2013-04-15 05:56:25'),(63,10,12,'Sob in the park','uploadedFiles/Sob in the park1735959884allanPow.story','2013-04-15 06:05:03'),(64,5,14,'Paranoia effect','uploadedFiles/Paranoia effect1360292422balagtas.story','2013-04-16 09:19:27'),(65,10,6,'My Life','uploadedFiles/My Life2055354816Soap.story','2013-04-20 13:15:50'),(66,9,7,'Leg tragedy','uploadedFiles/Leg tragedy1109020026DK.story','2013-04-22 01:07:57'),(67,7,18,':) Juan','uploadedFiles/:) Juan1397979474Melvin.story','2013-04-26 03:31:12'),(68,9,7,'Barber the breaker','uploadedFiles/Barber the breaker1394942703DK.story','2013-05-13 13:32:53'),(69,7,12,'Sam in the Park','uploadedFiles/Sam in the Park1658418228allanPow.story','2013-05-13 13:33:57'),(70,5,14,'Dope!','uploadedFiles/Dope!339215583balagtas.story','2013-05-13 13:36:55'),(71,2,14,'Bin in sidewalk','uploadedFiles/Bin in sidewalk617866413balagtas.story','2013-05-13 13:37:36'),(72,2,5,'Razor by the bench','uploadedFiles/Razor by the bench1259612960nej.story','2013-07-03 10:16:47'),(73,2,3,'describing Pencils','uploadedFiles/describing Pencils1406974212Simba.story','2013-07-03 10:31:07'),(74,1,6,'Regret on this day','uploadedFiles/Regret on this day1473109418Soap.story','2013-07-03 20:52:07'),(75,7,8,'the stroll in the forest','uploadedFiles/the stroll in the forest714314452CoolJ.story','2013-07-04 01:33:24'),(76,3,9,'Detroit Trip','uploadedFiles/Detroit Trip2146582242Egoist.story','2013-07-04 04:41:42'),(77,8,15,'Move up','uploadedFiles/Move up889704614plaridel.story','2013-07-04 06:43:22'),(78,9,15,'Edgar with the barbers','uploadedFiles/Edgar with the barbers1017596716plaridel.story','2013-07-04 15:39:53'),(79,7,14,'Cloudy outside the hut','uploadedFiles/Cloudy outside the hut1947433183balagtas.story','2013-07-04 15:46:56'),(80,8,7,'The cutting Cashier','uploadedFiles/The cutting Cashier1767167439DK.story','2013-07-05 06:18:46'),(81,2,11,'The razor left to see','uploadedFiles/The razor left to see1104825593Shakespir.story','2013-07-05 10:45:04'),(82,2,5,'Black Bin','uploadedFiles/Black Bin1538886306nej.story','2013-07-11 05:31:30'),(83,5,5,'The aftermath of achievement','uploadedFiles/The aftermath of achievement15330920nej.story','2013-07-11 05:33:01'),(84,9,3,'Barber in a warm Day','uploadedFiles/Barber in a warm Day817612729Simba.story','2013-07-11 05:37:28'),(85,7,6,'Gloom in Dome','uploadedFiles/Gloom in Dome2131103432Soap.story','2013-07-11 05:48:32'),(86,7,6,'Dirk in the shop','uploadedFiles/Dirk in the shop535602728Soap.story','2013-07-11 05:51:17'),(87,8,6,'Sam and Niccolo','uploadedFiles/Sam and Niccolo1818120088Soap.story','2013-07-11 05:52:08'),(88,8,14,'Author turned cashier','uploadedFiles/Author turned cashier913633871balagtas.story','2013-07-11 15:39:02'),(89,2,20,'Bottle','uploadedFiles/Bottle1598159736Amplifier.story','2013-07-22 12:20:17'),(90,9,21,'The Broken Poketwatch','uploadedFiles/The Broken Poketwatch1469635989nicoloco.story','2013-07-22 12:40:22'),(91,3,21,'Trip to the forest','uploadedFiles/Trip to the forest512738354nicoloco.story','2013-07-22 12:44:49');
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `template`
--

LOCK TABLES `template` WRITE;
/*!40000 ALTER TABLE `template` DISABLE KEYS */;
INSERT INTO `template` VALUES (1,'StoryTemplates/StoryTemplate1.txt','RelationTemplates/RelationTemplate1.txt',1,1,'For the begginer',1),(2,'StoryTemplates/StoryTemplate2.txt','RelationTemplates/RelationTemplate2.txt',1,1,'For show',1),(3,'StoryTemplates/StoryTemplate3.txt','RelationTemplates/RelationTemplate3.txt',2,2,'Another one',1),(4,'StoryTemplates/StoryTemplate4.txt','RelationTemplates/RelationTemplate4.txt',2,2,'This',1),(5,'StoryTemplates/StoryTemplate5.txt','RelationTemplates/RelationTemplate5.txt',3,3,'This one',1),(6,'StoryTemplates/StoryTemplate6.txt','RelationTemplates/RelationTemplate6.txt',3,3,'This other thing',1),(7,'StoryTemplates/StoryTemplate7.txt','RelationTemplates/RelationTemplate7.txt',4,4,'A template to Remember',1),(8,'StoryTemplates/StoryTemplate8.txt','RelationTemplates/RelationTemplate8.txt',4,4,'What Must be Done',1),(9,'StoryTemplates/StoryTemplate9.txt','RelationTemplates/RelationTemplate9.txt',4,4,'Forward thinking',1),(10,'StoryTemplates/StoryTemplate10.txt','RelationTemplates/RelationTemplate10.txt',5,5,'Go go Go',1),(11,'StoryTemplates/StoryTemplate1 - Eph.txt','RelationTemplates/RelationTemplate1 - Eph.txt',1,1,'Eph1',1),(12,'StoryTemplates/StoryTemplate2 - Eph.txt','RelationTemplates/RelationTemplate2 - Eph.txt',3,2,'ppo',1),(13,'StoryTemplates/StoryTemplate3 - Eph.txt','RelationTemplates/RelationTemplate3 - Eph.txt',6,3,'Eph again',1),(14,'StoryTemplates/StoryTemplate4 - Eph.txt','RelationTemplates/RelationTemplate4 - Eph.txt',9,4,'plo',1),(15,'StoryTemplates/StoryTemplate5 - Eph.txt','RelationTemplates/RelationTemplate5 - Eph.txt',12,5,'sds',1),(16,'StoryTemplates/StoryTemplate1 - Gab.txt','RelationTemplates/RelationTemplate1 - Gab.txt',1,1,'drgd',1),(17,'StoryTemplates/StoryTemplate2 - Gab.txt','RelationTemplates/RelationTemplate2 - Gab.txt',3,2,'tdhd',1),(18,'StoryTemplates/StoryTemplate3 - Gab.txt','RelationTemplates/RelationTemplate3 - Gab.txt',6,3,'thdt',1),(19,'StoryTemplates/StoryTemplate1 - Kai.txt','RelationTemplates/RelationTemplate1 - Kai.txt',1,1,'ht',1),(20,'StoryTemplates/StoryTemplate2 - Kai.txt','RelationTemplates/RelationTemplate2 - Kai.txt',3,2,'hdh',1),(21,'StoryTemplates/StoryTemplate3 - Kai.txt','RelationTemplates/RelationTemplate3 - Kai.txt',6,3,'hrd',1),(22,'StoryTemplates/StoryTemplate4 - Kai.txt','RelationTemplates/RelationTemplate4 - Kai.txt',9,4,'greeg',1),(23,'StoryTemplates/StoryTemplate5 - Kai.txt','RelationTemplates/RelationTemplate5 - Kai.txt',12,5,'Kaiz',1),(24,'StoryTemplates/StoryTemplate6 - Kai.txt','RelationTemplates/RelationTemplate6 - Kai.txt',15,6,'Kai story',1);
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

-- Dump completed on 2013-07-23 15:42:48
