-- MySQL dump 10.13  Distrib 5.5.31, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: ontology
-- ------------------------------------------------------
-- Server version	5.5.31-0ubuntu0.12.04.1

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
) ENGINE=InnoDB AUTO_INCREMENT=430 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Relation`
--

LOCK TABLES `Relation` WRITE;
/*!40000 ALTER TABLE `Relation` DISABLE KEYS */;
INSERT INTO `Relation` VALUES (1,'happy','emotion','Is-a',125,5,1,1,1),(2,'Hammer','Pounding','UsedFor',125,5,1,1,1),(3,'bottle','Object','Is-a',125,5,1,1,1),(4,'Saturday','Day','Is-a',100,1,0,1,1),(5,'Smashing','Pain','Causes',125,5,1,1,1),(6,'Smash','action','Is-a',100,1,0,1,1),(7,'green','Color','Is-a',100,1,0,2,1),(8,'grass','green','ColorOf',100,1,0,1,1),(9,'round','shape','Is-a',100,4,1,5,1),(10,'Round','Globe','ShapeOf',125,5,1,1,1),(11,'insults','Pain','Causes',100,1,0,1,1),(12,'Phone','Calling','UsedFor',100,9,2,1,1),(13,'Joyful','happy','Synonym',100,1,0,2,1),(14,'Victim','kill','ReceivesAction',100,1,0,1,1),(15,'Phone','Object','Is-a',100,1,0,1,1),(16,'Bottle','Containing','UsedFor',100,1,0,1,1),(17,'happy','Playing','Causes',100,5,2,1,0),(18,'well','happy','Causes',87,7,2,1,0),(19,'well','action','Is-A',100,4,1,1,0),(20,'house','location','Is-A',100,4,1,3,0),(21,'Phone','house','LocatedAt',100,8,2,1,0),(22,'black','color','Is-A',100,4,1,2,0),(23,'black','Phone','ColorOf',100,4,1,1,0),(24,'rectangle','shape','Is-A',87,14,4,2,0),(25,'rectangle','Phone','ShapeOf',100,8,2,1,0),(26,'Phone','find','ReceivesAction',100,4,1,1,0),(27,'Rizal Park','location','Is-a',62,5,2,2,1),(28,'Rizal statue','Rizal Park','LocatedAt',100,1,0,1,1),(29,'Playing','Rizal Park','DoneAt',100,1,0,1,1),(30,'Rizal statue','Object','Is-a',112,9,2,1,1),(31,'Rizal Monument','Object','Is-a',100,1,0,1,1),(32,'Rizal Monument','Rizal Park','LocatedAt',87,7,2,2,1),(33,'Jose Rizal Monument','object','Is-a',100,1,0,1,1),(34,'Jose Rizal Monument','Rizal Park','LocatedAt',100,1,0,1,1),(35,'happy','Smiling','Causes',100,8,2,1,0),(36,'running','happy','Causes',100,4,1,1,0),(37,'running','action','Is-A',100,4,1,2,0),(38,'glad','happy','Synonym',100,4,1,1,0),(39,'beach','location','Is-A',100,8,2,2,0),(40,'bottle','beach','LocatedAt',100,4,1,2,0),(41,'red','color','Is-A',100,4,1,2,0),(42,'red','bottle','ColorOf',100,4,1,1,0),(43,'cylyndrical','shape','Is-A',100,4,1,1,0),(44,'cylyndrical','bottle','ShapeOf',100,8,2,1,0),(45,'bottle','hold','ReceivesAction',100,4,1,2,0),(46,'grey','color','Is-A',100,4,1,1,0),(47,'grey','Rizal statue','ColorOf',100,4,1,1,0),(48,'Rizal statue','marble','MadeOf',100,8,2,1,0),(49,'Rizal statue','remembering','UsedFor',87,7,2,1,0),(50,'remembering','action','Is-A',100,4,1,1,0),(51,'rough','texture','Is-A',100,12,3,3,0),(52,'rough','Jose Rizal Monument','TextureOf',100,4,1,1,0),(53,'Jose Rizal Monument','stone','MadeOf',100,4,1,1,0),(54,'expensive','Jose Rizal Monument','PropertyOf',100,4,1,1,0),(55,'breakable','Jose Rizal Monument','PropertyOf',100,4,1,1,0),(56,'chair','house','LocatedAt',100,4,1,2,0),(57,'chair','object','Is-A',100,4,1,2,0),(58,'rest','action','Is-A',100,4,1,2,0),(59,'park','location','Is-A',100,12,3,2,0),(60,'happy','Jump','Causes',100,16,4,2,0),(61,'hopping','happy','Causes',83,10,3,1,0),(62,'hopping','action','Is-A',100,12,3,2,0),(63,'cheerful','happy','Synonym',100,8,2,1,0),(64,'sidewalk','location','Is-A',100,4,1,1,0),(65,'bottle','sidewalk','LocatedAt',100,4,1,1,0),(66,'green','bottle','ColorOf',41,5,3,1,0),(67,'round','bottle','ShapeOf',100,4,1,1,0),(68,'bottle','get','ReceivesAction',100,8,2,1,0),(69,'brown','color','Is-A',75,15,5,3,0),(70,'brown','Rizal statue','ColorOf',100,4,1,1,0),(71,'Rizal statue','rock','MadeOf',100,4,1,1,0),(72,'elegant','Rizal statue','PropertyOf',100,8,2,1,0),(73,'sand','beach','LocatedAt',100,4,1,1,0),(74,'sand','object','Is-A',100,4,1,1,0),(75,'surfing','action','Is-A',100,4,1,1,0),(76,'hut','location','Is-A',100,4,1,1,0),(77,'Repair man','person','Is-a',100,1,0,1,1),(78,'cloudy','day','PropertyOf',125,5,1,1,1),(79,'Niccolo','person','Is-A',100,4,1,1,0),(80,'warm','day','PropertyOf',100,4,1,1,0),(81,'mad','emotion','Is-A',100,4,1,1,0),(82,'barbershop','location','Is-A',100,4,1,1,0),(83,'PS3','object','Is-A',100,8,2,1,0),(84,'boy','Repair man','GenderOf',50,4,2,1,0),(85,'mad','Frown','Causes',100,7,2,1,0),(86,'hurt','mad','Causes',91,11,3,2,0),(87,'hurt','action','Is-A',100,8,2,2,0),(88,'angry','mad','Synonym',100,4,1,1,0),(89,'dump','location','Is-A',100,4,1,1,0),(90,'bottle','dump','LocatedAt',100,4,1,1,0),(91,'blue','color','Is-A',100,16,4,4,0),(92,'blue','bottle','ColorOf',100,8,2,3,0),(93,'have','shape','Is-A',100,4,1,1,0),(94,'have','bottle','ShapeOf',50,4,2,1,0),(95,'bottle','have','ReceivesAction',100,7,2,1,0),(96,'happy','positive feeling','Is-a',100,1,0,1,1),(97,'mad','negative feeling','Is-a',100,4,1,1,1),(98,'trouble','mad','Causes',100,8,2,1,0),(99,'mad','pout','Causes',100,4,1,1,0),(100,'pout','action','Is-A',100,8,2,1,0),(101,'jump','happy','Causes',87,7,2,1,0),(102,'happy','smile','Causes',100,4,1,2,0),(103,'smile','action','Is-A',100,8,2,2,0),(104,'doll','toy','Is-a',100,1,0,1,1),(105,'doll','Toy Store','LocatedAt',100,1,0,1,1),(106,'lady','person','Is-a',100,1,0,1,1),(107,'girl','lady','GenderOf',100,1,0,1,1),(108,'messy','infestation','LeadsTo',100,4,1,1,1),(109,'boy','Niccolo','GenderOf',100,1,0,2,1),(110,'box','dump','LocatedAt',100,4,1,1,0),(111,'box','object','Is-A',100,4,1,1,0),(112,'walking','action','Is-A',100,8,2,1,0),(113,'shower room','location','Is-A',100,4,1,1,0),(114,'high grades','happy','Causes',100,4,1,1,0),(115,'Toy Store','location','Is-a',112,9,2,2,1),(116,'teddy bear','Toy Store','LocatedAt',100,1,0,1,1),(117,'Cashier','person','Is-a',112,9,2,1,1),(118,'cashier','cash register','LocatedAt',100,1,0,1,1),(119,'Barber','person','Is-a',112,9,2,1,1),(120,'Barber','Barbershop','LocatedAt',100,1,0,1,1),(121,'Mirror','Object','Is-a',100,1,0,1,1),(122,'Mirror','Barbershop','LocatedAt',125,5,1,1,1),(123,'Monday','Day','Is-a',100,1,0,1,1),(124,'boy','Barber','LocatedAt',125,5,1,1,1),(125,'Tuesday','Day','Is-a',100,1,0,1,1),(126,'Niccolo','Barber','CanBe',125,5,1,1,1),(127,'Lady','Mother','CanBe',125,5,1,1,1),(128,'Lady','Saleslady','CanBe',100,1,0,1,1),(129,'person','Mother','CanBe',100,1,0,1,1),(130,'person','Barber','CanBe',100,1,0,1,1),(131,'resting','beach','DoneAt',100,4,1,1,0),(132,'Mother','caring','Does',100,8,2,1,0),(133,'note','box','LocatedNear',100,4,1,1,0),(134,'standing','sidewalk','DoneAt',100,4,1,1,0),(135,'Barber','shaving','Does',100,4,1,1,0),(136,'text','Rizal statue','LocatedNear',87,7,2,1,0),(137,'person','Mailman','CanBe',125,5,1,1,1),(138,'person','Traveler','CanBe',100,1,0,1,1),(139,'nurturing','Rizal Park','DoneAt',87,7,2,1,0),(140,'Mother','wire','Does',100,4,1,1,0),(141,'wire','Phone','LocatedNear',100,4,1,1,0),(142,'person','Mailman','CanBe',125,5,1,1,1),(143,'person','Traveler','CanBe',100,1,0,1,1),(144,'working','barbershop','DoneAt',100,4,1,1,0),(145,'Barber','cutting','Does',100,4,1,1,0),(146,'controller','PS3','LocatedNear',100,4,1,2,0),(147,'person','employee','CanBe',100,4,1,1,0),(148,'health','walking','PurposeOf',100,4,1,1,0),(149,'walking','sprint','LeadsTo',100,4,1,1,0),(150,'twig','object','Is-A',100,4,1,1,0),(151,'breakable','twig','PropertyOf',100,8,2,1,0),(152,'twig','park','LocatedAt',100,4,1,1,0),(153,'fine','feeling','Is-A',100,4,1,1,0),(154,'loved','happy','Causes',100,4,1,1,0),(155,'happy','encourage','Causes',100,4,1,1,0),(156,'encourage','action','Is-A',100,4,1,1,0),(157,'light','texture','Is-A',100,4,1,1,0),(158,'light','bottle','TextureOf',100,4,1,1,0),(159,'bottle','plastic','MadeOf',100,8,2,2,0),(160,'light','bottle','PropertyOf',87,7,2,2,0),(161,'breakable','bottle','PropertyOf',87,7,2,1,0),(162,'Sam','person','Is-A',100,4,1,1,0),(163,'spicy','day','PropertyOf',100,8,2,1,0),(164,'regret','emotion','Is-A',100,8,2,1,0),(165,'Naga','location','Is-A',100,4,1,1,0),(166,'pepper','object','Is-A',100,4,1,1,0),(167,'register','object','Is-A',100,4,1,1,0),(168,'breakable','register','PropertyOf',87,7,2,1,0),(169,'register','shower room','LocatedAt',100,4,1,1,0),(170,'stressed','feeling','Is-A',100,4,1,1,0),(171,'poster','park','LocatedAt',100,4,1,1,0),(172,'poster','object','Is-A',100,4,1,1,0),(173,'skating','action','Is-A',100,4,1,1,0),(174,'mad','pound','Causes',100,8,2,1,0),(175,'pound','action','Is-A',100,4,1,1,0),(176,'pain','mad','Causes',100,4,1,1,0),(177,'dove','park','LocatedAt',100,4,1,1,0),(178,'chill','action','Is-A',100,4,1,1,0),(179,'yard','location','Is-A',100,4,1,1,0),(180,'waiting','barbershop','DoneAt',100,8,2,2,0),(181,'employee','work','Does',100,4,1,2,0),(182,'flower','Jose Rizal Monument','LocatedNear',100,4,1,2,0),(183,'puppet','toy','Is-A',100,4,1,1,0),(184,'sitting','action','Is-A',100,4,1,1,0),(185,'school','location','Is-A',100,8,2,2,0),(186,'person','nurse','CanBe',100,8,2,1,0),(187,'surfing','cramps','Causes',100,4,1,1,0),(188,'surfing','eating','LeadsTo',87,7,2,1,0),(189,'person','diplomat','CanBe',100,4,1,1,0),(190,'preaching','remembering','PurposeOf',100,4,1,1,0),(191,'remembering','writting','LeadsTo',87,7,2,1,0),(192,'pan','hut','LocatedAt',100,4,1,1,0),(193,'hall','location','Is-A',100,4,1,2,0),(194,'Dirk','person','Is-A',100,4,1,1,0),(195,'pleasant','day','PropertyOf',100,8,2,2,0),(196,'shocked','emotion','Is-A',100,4,1,1,0),(197,'smartphone','object','Is-A',100,4,1,1,0),(198,'shell','object','Is-A',100,4,1,1,0),(199,'breakable','shell','PropertyOf',100,4,1,1,0),(200,'shell','beach','LocatedAt',100,4,1,1,0),(201,'Simba','person','Is-A',100,4,1,1,0),(202,'paranoid','emotion','Is-A',87,7,2,1,0),(203,'bench area','location','Is-A',100,4,1,1,0),(204,'show','object','Is-A',100,4,1,1,0),(205,'notebook','school','LocatedAt',100,8,2,1,0),(206,'learning','action','Is-A',100,8,2,1,0),(207,'shop','location','Is-A',100,8,2,1,0),(208,'paranoid','look','Causes',100,4,1,1,0),(209,'scared','paranoid','Causes',100,12,3,2,0),(210,'scared','action','Is-A',83,10,3,2,0),(211,'agitated','paranoid','Synonym',100,4,1,1,0),(212,'cylindrical','shape','Is-A',100,4,1,1,0),(213,'cylindrical','bottle','ShapeOf',100,4,1,1,0),(214,'life','happy','Causes',100,8,2,1,0),(215,'jump','action','Is-A',87,7,2,1,0),(216,'tired','feeling','Is-A',100,12,3,1,0),(217,'bread','barbershop','LocatedAt',91,11,3,1,0),(218,'edible','bread','PropertyOf',100,8,2,1,0),(219,'mad','stomp','Causes',100,8,2,1,0),(220,'stomp','action','Is-A',100,8,2,1,0),(221,'troubled','mad','Causes',100,8,2,1,0),(222,'person','lawyer','CanBe',87,7,2,1,0),(223,'bloodlust','hurt','PurposeOf',100,12,3,1,0),(224,'hurt','laugh','LeadsTo',87,7,2,1,0),(225,'person','waitress','CanBe',91,11,3,1,0),(226,'remembering','headaches','Causes',100,12,3,1,0),(227,'remembering','sitting','LeadsTo',91,11,3,1,0),(228,'Rough','Rizal Monument','TextureOf',100,8,2,1,0),(229,'Rizal Monument','stone','MadeOf',87,7,2,1,0),(230,'Rizal Monument','display','UsedFor',100,8,2,1,0),(231,'display','action','Is-A',100,8,2,1,0),(232,'weary','feeling','Is-A',91,11,3,1,0),(233,'sandwhich','Rizal Park','LocatedAt',87,7,2,1,0),(234,'edible','sandwhich','PropertyOf',87,7,2,1,0),(235,'person','tourist','CanBe',100,4,1,1,0),(236,'improvement','learning','PurposeOf',100,4,1,1,0),(237,'learning','knowledge','LeadsTo',100,4,1,1,0),(238,'test tube','object','Is-A',91,11,3,1,0),(239,'breakable','test tube','PropertyOf',83,10,3,1,0),(240,'test tube','shop','LocatedAt',87,7,2,1,0),(241,'bin','sidewalk','LocatedAt',87,7,2,1,0),(242,'dome','location','Is-A',100,4,1,2,0),(243,'smooth','texture','Is-A',100,4,1,1,0),(244,'smooth','Mirror','TextureOf',100,4,1,1,0),(245,'Mirror','glass','MadeOf',100,12,3,2,0),(246,'Mirror','Reflecting','UsedFor',100,4,1,1,0),(247,'Reflecting','action','Is-A',100,4,1,1,0),(248,'Relaxing','hut','DoneAt',100,8,2,1,0),(249,'diplomat','negotiate','Does',100,4,1,1,0),(250,'pen','box','LocatedNear',100,4,1,1,0),(251,'bug','yard','LocatedAt',87,14,4,1,0),(252,'glad','action','Is-A',80,16,5,1,0),(253,'relaxing','bench area','DoneAt',87,7,2,1,0),(254,'diplomat','understanding','Does',100,8,2,1,0),(255,'stage','show','LocatedNear',100,8,2,1,0),(256,'brown','sand','ColorOf',93,15,4,2,0),(257,'sand','dirt','MadeOf',91,11,3,1,0),(258,'sand','building sand castles','UsedFor',91,11,3,1,0),(259,'building sand castles','action','Is-A',91,11,3,1,0),(260,'chilled','feeling','Is-A',100,4,1,1,0),(261,'crab','bench area','LocatedAt',100,4,1,1,0),(262,'edible','crab','PropertyOf',100,4,1,1,0),(263,'building blocks','toy','Is-A',100,8,2,1,0),(264,'person','doctor','CanBe',91,11,3,2,0),(265,'glad','overjoyfulness','Causes',93,15,4,1,0),(266,'glad','jump','LeadsTo',93,15,4,1,0),(267,'mad','Rant','Causes',100,8,2,1,0),(268,'call center','location','Is-A',87,7,2,1,0),(269,'Phone','call center','LocatedAt',87,7,2,1,0),(270,'blue','Phone','ColorOf',100,8,2,1,0),(271,'rectangular','shape','Is-A',91,11,3,1,0),(272,'rectangular','Phone','ShapeOf',91,11,3,1,0),(273,'Phone','hold','ReceivesAction',100,8,2,2,0),(274,'paranoid','Panic','Causes',83,10,3,1,0),(275,'weary','paranoid','Synonym',91,11,3,1,0),(276,'gray','color','Is-A',41,5,3,1,0),(277,'gray','Rizal Monument','ColorOf',100,12,3,1,0),(278,'rectangle','Rizal Monument','ShapeOf',100,12,3,1,0),(279,'Rizal Monument','see','ReceivesAction',93,15,4,1,0),(280,'relaxing','hut','DoneAt',100,8,2,1,0),(281,'Traveler','explorating','Does',100,4,1,1,0),(282,'comb','Mirror','LocatedNear',100,4,1,1,0),(283,'person','Writer','CanBe',100,4,1,1,0),(284,'remembering','pain','Causes',100,4,1,1,0),(285,'remembering','drinking','LeadsTo',83,10,3,1,0),(286,'shocked','Shouting','Causes',62,5,2,1,0),(287,'off guard','shocked','Causes',100,8,2,1,0),(288,'off guard','action','Is-A',100,8,2,1,0),(289,'surprise','shocked','Synonym',100,8,2,1,0),(290,'resort','location','Is-A',87,7,2,1,0),(291,'sand','resort','LocatedAt',100,12,3,1,0),(292,'round','sand','ShapeOf',87,7,2,1,0),(293,'sand','arrange','ReceivesAction',100,8,2,1,0),(294,'energetic','feeling','Is-A',100,4,1,1,0),(295,'sandwhiches','bench area','LocatedAt',100,4,1,1,0),(296,'edible','sandwhiches','PropertyOf',100,4,1,1,0),(297,'stuck','dump','DoneAt',100,8,2,1,0),(298,'employee','follow','Does',91,11,3,1,0),(299,'ink','poster','LocatedNear',100,8,2,1,0),(300,'clear','color','Is-A',91,11,3,1,0),(301,'clear','Mirror','ColorOf',66,8,3,1,0),(302,'fragile','Mirror','PropertyOf',83,10,3,1,0),(303,'afraid','paranoid','Causes',91,11,3,1,0),(304,'paranoid','shake','Causes',100,8,2,1,0),(305,'shake','action','Is-A',91,11,3,1,0),(306,'sleepy','feeling','Is-A',100,4,1,1,0),(307,'corn','hut','LocatedAt',100,4,1,1,0),(308,'edible','corn','PropertyOf',100,4,1,1,0),(309,'laptop','object','Is-A',91,11,3,1,0),(310,'breakable','laptop','PropertyOf',83,10,3,1,0),(311,'laptop','call center','LocatedAt',100,12,3,1,0),(312,'ball','yard','LocatedAt',87,7,2,1,0),(313,'bedroom','location','Is-A',100,4,1,1,0),(314,'guilty','regret','Causes',87,7,2,1,0),(315,'regret','sit','Causes',87,7,2,1,0),(316,'sit','action','Is-A',100,12,3,2,0),(317,'learning','school','DoneAt',100,8,2,1,0),(318,'tourist','exploring','Does',100,8,2,1,0),(319,'watch','Mirror','LocatedNear',87,7,2,1,0),(320,'relaxing','energize','Causes',87,7,2,1,0),(321,'apples','hut','LocatedAt',100,8,2,1,0),(322,'edible','apples','PropertyOf',100,8,2,1,0),(323,'arch','dome','LocatedAt',100,4,1,1,0),(324,'arch','object','Is-A',100,8,2,1,0),(325,'viewing','action','Is-A',100,4,1,1,0),(326,'messy','problems','LeadsTo',83,10,3,1,0),(327,'death threat','paranoid','Causes',100,4,1,1,0),(328,'paranoid','stand','Causes',100,4,1,1,0),(329,'stand','action','Is-A',100,8,2,1,0),(330,'bird','park','LocatedAt',100,4,1,1,0),(331,'relaxing','action','Is-A',100,8,2,1,0),(332,'forest','location','Is-A',100,4,1,1,0),(333,'person','visitor','CanBe',100,4,1,1,0),(334,'thinking','sitting','PurposeOf',100,4,1,1,0),(335,'sitting','standing','LeadsTo',100,4,1,1,0),(336,'glad','emotion','Is-A',125,5,1,1,1),(337,'traffic sign','sidewalk','LocatedAt',100,4,1,1,0),(338,'traffic sign','object','Is-A',100,8,2,1,0),(339,'roam','action','Is-A',100,4,1,1,0),(340,'Edgar','person','Is-A',91,11,3,1,0),(341,'gloomy','day','PropertyOf',91,11,3,1,0),(342,'sorrowful','emotion','Is-A',100,16,4,1,0),(343,'basketball','object','Is-A',91,11,3,1,0),(344,'exploring','forest','DoneAt',100,12,3,1,0),(345,'Mailman','delivery','Does',100,20,5,1,0),(346,'bird','Rizal Monument','LocatedNear',83,10,3,1,0),(347,'glass','object','Is-A',90,18,5,1,0),(348,'breakable','glass','PropertyOf',100,20,5,1,0),(349,'glass','park','LocatedAt',81,13,4,1,0),(350,'remourseful','feeling','Is-A',100,20,5,1,0),(351,'person','pro gamer','CanBe',90,18,5,1,0),(352,'spreading joy','glad','PurposeOf',100,12,3,1,0),(353,'glad','enjoy','LeadsTo',91,11,3,1,0),(354,'game console','object','Is-A',100,8,2,1,0),(355,'breakable','game console','PropertyOf',100,8,2,1,0),(356,'game console','Toy Store','LocatedAt',100,8,2,1,0),(357,'bin','bench area','LocatedAt',100,4,1,1,0),(358,'bin','object','Is-A',100,8,2,1,0),(359,'sketching','action','Is-A',100,8,2,1,0),(360,'fields','location','Is-A',100,4,1,1,0),(361,'sketching','sprain','Causes',100,4,1,1,0),(362,'sketching','sleep','LeadsTo',100,4,1,1,0),(363,'rough','box','TextureOf',100,4,1,1,0),(364,'box','carton','MadeOf',100,4,1,1,0),(365,'small','box','PropertyOf',100,8,2,1,0),(366,'pencil','school','LocatedAt',100,8,2,1,0),(367,'pencil','object','Is-A',100,8,2,1,0),(368,'crying','Rizal Park','DoneAt',100,4,1,1,0),(369,'diplomat','negotiating','Does',100,4,1,1,0),(370,'television','PS3','LocatedNear',100,4,1,1,0),(371,'regret','frown','Causes',100,4,1,1,0),(372,'ashamed','regret','Causes',100,4,1,1,0),(373,'ashamed','action','Is-A',100,4,1,1,0),(374,'regretful','regret','Synonym',100,4,1,1,0),(375,'living room','location','Is-A',100,4,1,1,0),(376,'Mirror','living room','LocatedAt',100,4,1,1,0),(377,'white','color','Is-A',100,4,1,1,0),(378,'white','Mirror','ColorOf',100,4,1,1,0),(379,'round','Mirror','ShapeOf',100,4,1,1,0),(380,'Mirror','look at','ReceivesAction',100,4,1,1,0),(381,'messy','lost stuff','LeadsTo',100,8,2,1,0),(382,'standing','stay','Causes',100,4,1,1,0),(383,'waffers','sidewalk','LocatedAt',100,4,1,1,0),(384,'edible','waffers','PropertyOf',100,4,1,1,0),(385,'happy','play','Causes',100,4,1,1,0),(386,'free','happy','Causes',100,4,1,1,0),(387,'free','action','Is-A',100,4,1,1,0),(388,'office','location','Is-A',100,4,1,1,0),(389,'Phone','office','LocatedAt',100,4,1,1,0),(390,'red','Phone','ColorOf',100,4,1,1,0),(391,'round','Phone','ShapeOf',100,4,1,1,0),(392,'limb','object','Is-A',50,4,2,1,0),(393,'breakable','limb','PropertyOf',87,7,2,1,0),(394,'limb','yard','LocatedAt',62,5,2,1,0),(395,'ugly','feeling','Is-A',100,8,2,1,0),(396,'t-rex','yard','LocatedAt',100,4,1,1,0),(397,'sleeping','action','Is-A',100,4,1,1,0),(398,'mall','location','Is-A',100,4,1,1,0),(399,'Slim Shady','person','Is-A',100,4,1,1,0),(400,'wack','day','PropertyOf',100,4,1,1,0),(401,'dope','emotion','Is-A',100,4,1,1,0),(402,'Detroit','location','Is-A',100,4,1,1,0),(403,'Rap Battle Trophy','object','Is-A',100,4,1,1,0),(404,'crying','sob','Causes',100,4,1,1,0),(405,'ice cream','Rizal Park','LocatedAt',100,4,1,1,0),(406,'edible','ice cream','PropertyOf',100,4,1,1,0),(407,'worried','paranoid','Causes',100,8,2,1,0),(408,'paranoid','crunch','Causes',100,8,2,1,0),(409,'crunch','action','Is-A',100,8,2,1,0),(410,'learning','get high grades','Causes',100,4,1,1,0),(411,'hotdogs','school','LocatedAt',100,4,1,1,0),(412,'edible','hotdogs','PropertyOf',100,4,1,1,0),(413,'leg','object','Is-A',100,4,1,1,0),(414,'breakable','leg','PropertyOf',100,4,1,1,0),(415,'leg','resort','LocatedAt',100,4,1,1,0),(416,'beutifull','hall','DoneAt',100,4,1,1,0),(417,'Writer','writing','Does',100,4,1,1,0),(418,'ball','basketball','LocatedNear',100,4,1,1,0),(419,'razor','object','Is-A',100,4,1,1,0),(420,'breakable','razor','PropertyOf',100,4,1,1,0),(421,'razor','bench area','LocatedAt',100,4,1,1,0),(422,'strolling','Rizal Park','DoneAt',100,4,1,1,0),(423,'doctor','curing','Does',100,4,1,1,0),(424,'troubled','dope','Causes',100,4,1,1,0),(425,'dope','walk','Causes',100,4,1,1,0),(426,'walk','action','Is-A',100,4,1,1,0),(427,'black','bin','ColorOf',100,4,1,1,0),(428,'bin','plastic','MadeOf',100,4,1,1,0),(429,'dirty','bin','PropertyOf',100,4,1,1,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'Admin','9f52829cd368a64b4da2511b3560f665',0,1,1,1),(2,'1Kid','2168c5915d5452d864f273c4536d8f9e',1,1,1,0),(3,'Simba','60d28e7d879c0dc48b9a593468cf11e5',1,1,1640,5),(4,'Observer','1b65e84b7aa724b3f34c7dede00d439c',2,1,1,0),(5,'nej','1e8e42b87a65326b98ced7d3af717a72',1,1,1370,4),(6,'Soap','ab99f8f1c87bb63eee8ddc8688ce329f',1,1,2001,5),(7,'DK','2e8d6dbf9112a879d4ceb15403d10a78',1,1,4805,9),(8,'CoolJ','b1f4f9a523e36fd969f4573e25af4540',1,1,1111,4),(9,'Egoist','37349f07c95879abf625e8e7ae56170c',1,1,2521,6),(10,'Egoistic','37349f07c95879abf625e8e7ae56170c',1,1,1,0),(11,'Shakespir','ecae13117d6f0584c25a9da6c8f8415e',1,1,1910,5),(12,'allanPow','6b1d24ff83a319070db95c6c84b9be31',1,1,2360,6),(13,'Evaluator','2eed1fe0db36d674643b5f84d2adf46e',2,1,0,0),(14,'balagtas','9a5aab71aac4028688f5eda14f55f1f0',1,1,1060,4),(15,'plaridel','1edf155136294fa9120b07f3b7ddb7e1',1,1,920,3),(16,'critic','339d8d14024f2ae5c8dc2e07362eba1d',2,1,0,0),(17,'Batman','ec0e2603172c73a8b644bb9456c1ff6e',1,1,160,1),(18,'Melvin','81dc9bdb52d04dc20036dbd8313ed055',1,1,280,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `achievement`
--

LOCK TABLES `achievement` WRITE;
/*!40000 ALTER TABLE `achievement` DISABLE KEYS */;
INSERT INTO `achievement` VALUES (1,'First Story','Completed the first of many stories','images/badges/storyCount1.png'),(2,'Approval','Somebody liked your story','https://lh6.googleusercontent.com/-3yhAz7Ydk_I/UY3P6T0-m_I/AAAAAAAAA4w/l5_CbiA1_a0/w287-h278-no/Capture_medal.JPG'),(3,'Got Popular','Got a Story that was displayed as most popular','images/badges/StoryOfTheWeek.png'),(4,'A step forward','Level up to level 2','https://lh6.googleusercontent.com/-3yhAz7Ydk_I/UY3P6T0-m_I/AAAAAAAAA4w/l5_CbiA1_a0/w287-h278-no/Capture_medal.JPG'),(5,'Eager Writer','Wrote 10 Stories','images/badges/eagerWriter.png'),(6,'Story of the Week','Have a story that became the story of the week','images/badges/StoryOfTheWeek.png'),(7,'10 Stories','Made 10 Stories','images/badges/storyCount10.png');
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
) ENGINE=InnoDB AUTO_INCREMENT=261 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concept`
--

LOCK TABLES `concept` WRITE;
/*!40000 ALTER TABLE `concept` DISABLE KEYS */;
INSERT INTO `concept` VALUES (1,'happy',1),(2,'person',3),(3,'game',1),(4,'animal',1),(5,'Emotion',1),(6,'Day',1),(7,'Object',1),(8,'Playing',1),(9,'well',1),(10,'house',1),(11,'black',1),(12,'rectangle',1),(13,'find',1),(14,'location',1),(15,'Smiling',1),(16,'running',1),(17,'glad',1),(18,'beach',1),(19,'red',1),(20,'cylyndrical',1),(21,'hold',1),(22,'grey',1),(23,'marble',1),(24,'remembering',1),(25,'rough',1),(26,'stone',1),(27,'expensive',1),(28,'chair',1),(29,'rest',1),(30,'park',1),(31,'Jump',1),(32,'hopping',1),(33,'cheerful',1),(34,'sidewalk',1),(35,'green',1),(36,'round',1),(37,'get',1),(38,'brown',1),(39,'rock',1),(40,'elegant',1),(41,'fence',1),(42,'walk',1),(43,'zoo',1),(44,'sand',1),(45,'surfing',1),(46,'hut',1),(47,'Niccolo',1),(48,'warm',1),(49,'mad',1),(50,'barbershop',1),(51,'PS3',1),(52,'Frown',1),(53,'hurt',1),(54,'angry',1),(55,'dump',1),(56,'blue',1),(57,'have',1),(58,'reflective',1),(59,'trouble',1),(60,'pout',1),(61,'smile',1),(62,'box',1),(63,'walking',1),(64,'shower room',1),(65,'high grades',1),(66,'resting',1),(67,'caring',1),(68,'note',1),(69,'standing',1),(70,'shaving',1),(71,'text',1),(72,'nurturing',1),(73,'wire',1),(74,'working',1),(75,'cutting',1),(76,'controller',1),(77,'employee',1),(78,'health',1),(79,'sprint',1),(80,'twig',1),(81,'fine',1),(82,'loved',1),(83,'encourage',1),(84,'light',1),(85,'plastic',1),(86,'poster',1),(87,'skating',1),(88,'pound',1),(89,'pain',1),(90,'dove',1),(91,'chill',1),(92,'yard',1),(93,'Riza',1),(94,'waiting',1),(95,'work',1),(96,'flower',1),(97,'puppet',1),(98,'sitting',1),(99,'school',1),(100,'nurse',1),(101,'cramps',1),(102,'eating',1),(103,'diplomat',1),(104,'preaching',1),(105,'writting',1),(106,'pan',1),(107,'hall',1),(108,'Dirk',1),(109,'pleasant',1),(110,'shocked',1),(111,'smartphone',1),(112,'shell',1),(113,'Simba',1),(114,'paranoid',1),(115,'bench area',1),(116,'show',1),(117,'notebook',1),(118,'learning',1),(119,'shop',1),(120,'look',1),(121,'scared',1),(122,'agitated',1),(123,'cylindrical',1),(124,'life',1),(125,'tired',1),(126,'bread',1),(127,'stomp',1),(128,'troubled',1),(129,'lawyer',1),(130,'bloodlust',1),(131,'laugh',1),(132,'waitress',1),(133,'headaches',1),(134,'display',1),(135,'weary',1),(136,'sandwhich',1),(137,'tourist',1),(138,'test tube',1),(139,'bin',1),(140,'smooth',1),(141,'glass',1),(142,'negotiate',1),(143,'pen',1),(144,'bug',1),(145,'relaxing',1),(146,'understanding',1),(147,'stage',1),(148,'dirt',1),(149,'building sand castles',1),(150,'chilled',1),(151,'crab',1),(152,'building blocks',1),(153,'doctor',1),(154,'overjoyfulness',1),(155,'Rant',1),(156,'call center',1),(157,'rectangular',1),(158,'Panic',1),(159,'Rizal Park',1),(160,'gray',1),(161,'see',1),(162,'explorating',1),(163,'comb',1),(164,'Writer',1),(165,'drinking',1),(166,'Shouting',1),(167,'off guard',1),(168,'surprise',1),(169,'resort',1),(170,'arrange',1),(171,'energetic',1),(172,'sandwhiches',1),(173,'stuck',1),(174,'follow',1),(175,'ink',1),(176,'clear',1),(177,'fragile',1),(178,'afraid',1),(179,'shake',1),(180,'sleepy',1),(181,'corn',1),(182,'laptop',1),(183,'ball',1),(184,'bedroom',1),(185,'guilty',1),(186,'sit',1),(187,'exploring',1),(188,'watch',1),(189,'energize',1),(190,'apples',1),(191,'arch',1),(192,'viewing',1),(193,'problems',1),(194,'death threat',1),(195,'stand',1),(196,'bird',1),(197,'forest',1),(198,'visitor',1),(199,'thinking',1),(200,'traffic sign',1),(201,'roam',1),(202,'Edgar',1),(203,'gloomy',1),(204,'sorrowful',1),(205,'toy store',1),(206,'basketball',1),(207,'delivery',1),(208,'remourseful',1),(209,'Diana',1),(210,'Leah',1),(211,'Video Game',1),(212,'pro gamer',1),(213,'spreading joy',1),(214,'enjoy',1),(215,'game console',1),(216,'sketching',1),(217,'fields',1),(218,'sprain',1),(219,'sleep',1),(220,'carton',1),(221,'small',1),(222,'pencil',1),(223,'crying',1),(224,'negotiating',1),(225,'television',1),(226,'ashamed',1),(227,'regretful',1),(228,'living room',1),(229,'white',1),(230,'look at',1),(231,'lost stuff',1),(232,'stay',1),(233,'waffers',1),(234,'play',1),(235,'free',1),(236,'joyful',1),(237,'office',1),(238,'limb',1),(239,'ugly',1),(240,'t-rex',1),(241,'sleeping',1),(242,'mall',1),(243,'Slim Shady',1),(244,'wack',1),(245,'dope',1),(246,'Detroit',1),(247,'Rap Battle Trophy',1),(248,'sob',1),(249,'ice cream',1),(250,'worried',1),(251,'crunch',1),(252,'get high grades',1),(253,'hotdogs',1),(254,'leg',1),(255,'beutifull',1),(256,'writing',1),(257,'razor',1),(258,'strolling',1),(259,'curing',1),(260,'dirty',1);
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
INSERT INTO `learnerachievement` VALUES (1,3,'2013-05-11'),(1,5,'2013-05-11'),(2,3,'2013-05-11'),(2,5,'2013-05-11'),(1,6,'2013-05-11'),(1,7,'2013-05-12'),(2,7,'2013-05-12'),(1,8,'2013-05-12'),(3,7,'2013-05-12'),(1,14,'2013-05-13'),(2,11,'2013-05-14'),(2,12,'2013-05-15');
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
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likedstory`
--

LOCK TABLES `likedstory` WRITE;
/*!40000 ALTER TABLE `likedstory` DISABLE KEYS */;
INSERT INTO `likedstory` VALUES (3,8,1),(7,10,2),(8,11,3),(6,6,4),(11,7,5),(7,20,7),(7,13,8),(8,9,14),(8,14,15),(3,21,16),(3,20,17),(7,7,19),(7,22,20),(5,21,22),(3,19,27),(3,18,28),(11,23,29),(3,24,30),(9,18,35),(8,26,36),(9,25,37),(9,21,38),(7,26,39),(6,25,40),(6,23,41),(3,22,43),(3,39,45),(3,38,46),(3,7,48),(12,32,51),(8,37,52),(5,48,53),(5,46,54),(5,50,56),(5,36,57),(12,49,58),(12,39,59),(12,40,60),(12,33,61),(5,51,62),(7,40,63),(7,54,64),(12,45,65),(14,55,66),(15,30,69),(17,56,70),(17,53,71),(14,63,72),(14,58,73),(14,44,74),(15,48,75),(15,40,76),(14,48,77),(14,40,78),(14,62,79),(3,56,80),(3,48,81),(18,66,82),(9,61,83),(9,48,84),(14,59,85),(14,49,87),(14,50,89),(5,65,90),(5,52,91),(11,68,92),(12,48,94),(15,69,95),(15,44,96);
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
INSERT INTO `profile` VALUES (1,'https://lh6.googleusercontent.com/-m9fg-PraoOQ/ToJBwdqN5oI/AAAAAAAAAvY/4MIdYdiGL-4/s900/go_on.png','2004-05-14','Unang','Bata'),(2,'https://lh5.googleusercontent.com/-5bWTfwJ0sGc/ToJBrESx7uI/AAAAAAAAAvU/ejJFyHQr3S4/s379/new-n.png','2006-03-07','Ronald','Makata'),(3,'https://lh5.googleusercontent.com/-2vDGOCmN6Oc/TsTlO4YsV5I/AAAAAAAAAyU/I0aqImK3Ch4/s700/Bg1.jpg','2002-04-26','Simba','Lionpride'),(4,'https://lh3.googleusercontent.com/-MrlVW_9Q9SI/ToJBkvamTTI/AAAAAAAAAvQ/qNa3xLCmWXM/w615-h560-p-k/n-eye.png','2003-06-19','Ray','Brighteye'),(5,'https://lh6.googleusercontent.com/-3DGGXrcDeFw/TerHo3ynfGI/AAAAAAAAAr4/Rr6Y7BiIHNM/s425/N-Stamp1.png','2003-02-07','Neji','Hyuga'),(6,'https://lh6.googleusercontent.com/-uUvi-LYD3bI/TnwMpoYHVUI/AAAAAAAAA3E/QY88r8bjcJE/w253-h252-n-k/grass_Field.png','2007-11-02','John','Mactavish'),(7,'https://lh3.googleusercontent.com/-OBoqr4-N46M/SM4frFVUP3I/AAAAAAAAACo/wdwOSRgs-CY/w246-h241-n-k/L.invader%2528deathknight%2529.JPG','2008-03-30','Death','Knight'),(8,'https://lh3.googleusercontent.com/-KwiBwCTn3tQ/SjtI245jGwI/AAAAAAAAAYM/GCWT_ahQ-kE/s700/BeNeat.png','2005-05-31','Jack','Frost'),(9,'https://lh3.googleusercontent.com/-uGiDJ6FLvB8/SPn4gonP1lI/AAAAAAAAAFc/WLzjMuoYyak/w398-h316-n-k/Biohazard_quake.jpg','2008-09-04','Trenor','Kenway'),(10,'https://lh5.googleusercontent.com/-z04xeOdenEk/SpJL2u8hXAI/AAAAAAAAAdM/8E5si3TpDQw/s335/eye-c.png','2006-08-20','Norm','Dapirdefool'),(11,'https://lh5.googleusercontent.com/--C_MdqzZ4MI/S81DtEy985I/AAAAAAAAAnE/ppopQ19SbKU/s334/Logotemp1.png','2005-10-24','William','Owleye'),(12,'upPics/Red_Profile_1691706229.jpg','2007-04-05','Edgar Da','Poet'),(13,'https://lh3.googleusercontent.com/-MrlVW_9Q9SI/ToJBkvamTTI/AAAAAAAAAvQ/qNa3xLCmWXM/w615-h560-p-k/n-eye.png','1991-06-28','Brendan','The Bright'),(14,'upPics/dis_188257026.jpg','2005-09-15','Fransisco','Baltazar'),(15,'upPics/logo_992108506_806878564.png','2006-10-17','Marcelo','del Pillar'),(16,'upPics/AlbumArt_{4549601C-CD58-4F44-8568-3DCF3F2297C5}_Large_476665440.jpg','1990-05-01','Meta','Critic'),(17,'upPics/AlbumArt_{83E282C5-EE33-499C-A63F-04A3229DF427}_Large_1760411668.jpg','2010-07-19','Bruce','Wayne'),(18,'upPics/Screenshot from 2013-04-26 11:29:35_1907531395.png','2007-02-04','Melvin','Bautista');
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
INSERT INTO `rating` VALUES (7,4,10),(1,4,5),(17,4,10),(27,4,25),(4,4,40),(42,4,30),(10,4,30),(1,13,20),(6,13,30),(7,13,40),(48,13,180),(46,13,200),(12,4,220),(10,13,170),(37,13,110),(20,13,125),(13,16,105),(21,4,130),(19,4,65),(38,4,120),(35,16,115),(47,16,125),(15,16,95),(25,16,375),(26,16,375),(54,16,170),(8,16,145),(48,16,165),(4,13,135),(49,13,115),(48,4,160),(7,16,135),(21,16,220),(57,4,45),(60,16,90),(49,4,125),(39,4,120),(11,4,110),(19,13,75),(24,13,120),(64,13,135),(23,4,55),(29,4,385),(32,4,125),(50,4,135),(46,4,215),(31,4,125),(16,4,85),(6,16,120),(11,16,130),(32,13,145),(33,16,120);
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
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storyaccomplishment`
--

LOCK TABLES `storyaccomplishment` WRITE;
/*!40000 ALTER TABLE `storyaccomplishment` DISABLE KEYS */;
INSERT INTO `storyaccomplishment` VALUES (1,1,3,'The introduction of Simba','uploadedFiles/The introduction of Simba522066365Simba.story','2013-01-23 16:00:00'),(2,2,3,'Spicy day','uploadedFiles/Spicy1844764482Simba.story','2013-01-24 09:18:33'),(4,2,7,'School trip','uploadedFiles/School trip1350866152DK.story','2013-01-25 06:28:53'),(6,1,5,'The feels','uploadedFiles/The feels1686661008Simba.story','2013-02-13 05:49:47'),(7,4,5,'Feed Dirk','uploadedFiles/Feed dirk615881354nej.story','2013-02-19 18:27:41'),(8,3,7,'The feels','uploadedFiles/Mad feelings1171126013DK.story','2013-02-19 18:53:01'),(9,1,7,'Cashier the fiendish friend','uploadedFiles/Cashier the fiendish friend1747797714DK.story','2013-02-19 18:54:46'),(10,1,3,'Bottle story','uploadedFiles/Bottle story1661603083Simba.story','2013-02-19 19:03:08'),(11,1,3,'The story of today','uploadedFiles/The story of today1925610500Simba.story','2013-02-20 03:44:20'),(12,1,7,'Me in the Park','uploadedFiles/Me in the Park470420369DK.story','2013-02-21 08:35:45'),(13,1,5,'Lady\'s meal','uploadedFiles/Lady\'s meal1607503622nej.story','2013-02-21 08:59:28'),(14,1,11,'Touring repair man','uploadedFiles/Touring repair man1726652230Shakespir.story','2013-02-21 09:01:32'),(15,1,11,'Spicy break','uploadedFiles/Spicy break516578976Shakespir.story','2013-02-21 09:02:45'),(16,1,8,'Sidewalk trip','uploadedFiles/Sidewalk trip24628589CoolJ.story','2013-02-21 09:07:44'),(17,1,8,'mirror on the barber\'s wall','uploadedFiles/mirror on the barber\'s wall1518269048CoolJ.story','2013-02-21 09:09:54'),(18,1,8,'Biag\'s Hut','uploadedFiles/Biag\'s Hut874318666CoolJ.story','2013-02-21 09:11:41'),(19,1,8,'The yard story','uploadedFiles/The yard story1534586655CoolJ.story','2013-02-21 09:12:45'),(20,1,9,'Cloud at the beach','uploadedFiles/Cloud at the beach1812684503Egoist.story','2013-02-21 09:21:22'),(21,1,7,'A walk in the beach','uploadedFiles/A walk in the beach92131486DK.story','2013-02-27 03:57:39'),(22,1,11,'Dirk and the Beach','uploadedFiles/Dirk and the Beach1894789253Shakespir.story','2013-03-04 03:17:33'),(23,1,3,'Cashier and the desire of toys','uploadedFiles/Cashier and the desire of toys90992946Simba.story','2013-03-04 07:46:40'),(24,1,11,'Simba the Mailman','uploadedFiles/Simba the Mailman1452303078Shakespir.story','2013-03-05 03:45:19'),(25,1,11,'Cloudy Monday','uploadedFiles/Cloudy Monday416911549Shakespir.story','2013-03-06 01:17:49'),(26,1,9,'Paranoid Saturday','uploadedFiles/Paranoid Saturday703901877Egoist.story','2013-03-06 03:56:13'),(27,1,5,'Traveler\'s meeting','uploadedFiles/Traveler\'s meeting1413808606nej.story','2013-03-07 04:09:54'),(28,1,9,'Painful Memories','uploadedFiles/Painful Memories1200837330Egoist.story','2013-03-07 04:15:00'),(29,1,9,'Shock and Sand','uploadedFiles/Shock and Sand2068104426Egoist.story','2013-03-07 12:36:41'),(30,1,6,'Hunger and other feelings','uploadedFiles/Hunger and other feelings1427040520Soap.story','2013-03-08 02:13:37'),(31,1,6,'To the dump Cashier','uploadedFiles/To the dump Cashier1911746326Soap.story','2013-03-08 02:15:48'),(32,1,8,'Fragile Sight','uploadedFiles/Fragile Sight442407635CoolJ.story','2013-03-08 12:00:17'),(33,1,6,'That feeling','uploadedFiles/That feeling1992367868Soap.story','2013-03-08 12:19:26'),(34,5,5,'Dirk\'s Hut','uploadedFiles/Dirk\'s Hut143506695nej.story','2013-03-08 12:48:57'),(35,9,6,'Sam at work','uploadedFiles/Sam at work1007987157Soap.story','2013-03-08 13:41:56'),(36,3,9,'Yard trip','uploadedFiles/Yard trip1527984414Egoist.story','2013-03-08 13:54:14'),(37,5,3,'Guilt and regret','uploadedFiles/Guilt and regret1693747156Simba.story','2013-03-08 15:24:06'),(38,7,7,'Dirk in School','uploadedFiles/Dirk in School633682062DK.story','2013-03-08 15:33:05'),(39,10,6,'Repair man and the day off','uploadedFiles/Repair man and the day off555158416Soap.story','2013-03-08 15:36:53'),(40,3,3,'Dome Trip','uploadedFiles/Dome Trip591865803Simba.story','2013-03-09 12:38:29'),(41,6,12,'Simba with Toys','uploadedFiles/Simba with Toys938701577allanPow.story','2013-03-10 06:31:46'),(42,5,5,'The paranoia effect','uploadedFiles/The paranoia effect1742983130nej.story','2013-03-11 08:42:10'),(43,3,8,'From Park to forest','uploadedFiles/From Park to forest1758978212CoolJ.story','2013-03-11 08:49:46'),(44,8,11,'Sit now my friend','uploadedFiles/Sit now my friend346657459Shakespir.story','2013-03-11 08:51:32'),(45,3,3,'Sidewalk discovery','uploadedFiles/Sidewalk discovery1218950115Simba.story','2013-03-11 09:05:58'),(46,4,12,'Meet Edgar','uploadedFiles/Meet Edgar1829516309allanPow.story','2013-03-13 01:49:26'),(47,7,12,'Boy goes to forest','uploadedFiles/Boy goes to forest1873939551allanPow.story','2013-03-13 02:48:46'),(48,9,7,'Gloomy Dirk','uploadedFiles/Gloomy Dirk287544367DK.story','2013-03-13 02:50:56'),(49,8,7,'pro gamer enjoy','uploadedFiles/pro gamer enjoy604861555DK.story','2013-03-13 03:01:10'),(50,9,3,'Scary break','uploadedFiles/Scary break322143325Simba.story','2013-03-13 03:01:42'),(51,3,11,'Artist on the bench','uploadedFiles/Artist on the bench2095045337Shakespir.story','2013-03-13 03:03:14'),(52,8,9,'sketch to sleep','uploadedFiles/sketch to sleep1748470493Egoist.story','2013-03-23 03:25:24'),(53,2,7,'Alex','uploadedFiles/Alex1502990697DK.story','2013-03-23 03:29:20'),(54,3,7,'Discovering School','uploadedFiles/Discovering School1636135812DK.story','2013-03-23 03:32:22'),(55,7,5,'Edgar in the Park','uploadedFiles/Edgar in the Park517512655nej.story','2013-03-30 10:32:07'),(56,1,12,'regretful reflection','uploadedFiles/regretful reflection1837809899allanPow.story','2013-04-12 06:02:48'),(57,6,14,'Pleasant day in toy store','uploadedFiles/Pleasant day in toy store1194683947balagtas.story','2013-04-14 09:29:41'),(58,10,15,'standing lady','uploadedFiles/standing lady555476753plaridel.story','2013-04-14 10:26:18'),(59,1,7,'Happy Monday','uploadedFiles/Happy Monday1337116182DK.story','2013-04-15 01:14:59'),(60,9,15,'Kobe Injury','uploadedFiles/Kobe Injury303250354plaridel.story','2013-04-15 05:05:51'),(61,3,14,'Trip to the yard','uploadedFiles/Trip to the yard954711124balagtas.story','2013-04-15 05:27:20'),(62,4,17,'8 Mile','uploadedFiles/8 Mile1049232025Batman.story','2013-04-15 05:56:25'),(63,10,12,'Sob in the park','uploadedFiles/Sob in the park1735959884allanPow.story','2013-04-15 06:05:03'),(64,5,14,'Paranoia effect','uploadedFiles/Paranoia effect1360292422balagtas.story','2013-04-16 09:19:27'),(65,10,6,'My Life','uploadedFiles/My Life2055354816Soap.story','2013-04-20 13:15:50'),(66,9,7,'Leg tragedy','uploadedFiles/Leg tragedy1109020026DK.story','2013-04-22 01:07:57'),(67,7,18,':) Juan','uploadedFiles/:) Juan1397979474Melvin.story','2013-04-26 03:31:12'),(68,9,7,'Barber the breaker','uploadedFiles/Barber the breaker1394942703DK.story','2013-05-13 13:32:53'),(69,7,12,'Sam in the Park','uploadedFiles/Sam in the Park1658418228allanPow.story','2013-05-13 13:33:57'),(70,5,14,'Dope!','uploadedFiles/Dope!339215583balagtas.story','2013-05-13 13:36:55'),(71,2,14,'Bin in sidewalk','uploadedFiles/Bin in sidewalk617866413balagtas.story','2013-05-13 13:37:36');
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

-- Dump completed on 2013-05-23 22:35:36
