CREATE DATABASE  IF NOT EXISTS `estacionamento` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `estacionamento`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: estacionamento
-- ------------------------------------------------------
-- Server version	5.6.27-log

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
-- Table structure for table `tbl_movimentacao`
--

DROP TABLE IF EXISTS `tbl_movimentacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_movimentacao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_entrada` varchar(255) DEFAULT NULL,
  `data_saida` varchar(255) DEFAULT NULL,
  `horario_entrada` varchar(255) DEFAULT NULL,
  `horario_saida` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `placa` varchar(255) DEFAULT NULL,
  `tempo` varchar(255) DEFAULT NULL,
  `valor_pago` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_movimentacao`
--

LOCK TABLES `tbl_movimentacao` WRITE;
/*!40000 ALTER TABLE `tbl_movimentacao` DISABLE KEYS */;
INSERT INTO `tbl_movimentacao` VALUES (9,'21/10/2021',NULL,'22:21:29',NULL,'324324324','4353454',NULL,0),(10,'21/10/2021',NULL,'22:21:35',NULL,'324324','6546546',NULL,0),(11,'21/10/2021','21/10/2021','22:21:38','22:21:56','353tgre6t4','3123ytry5','1',6),(12,'21/10/2021','21/10/2021','22:21:42','22:21:47','e545345','65765dfyd4','1',6);
/*!40000 ALTER TABLE `tbl_movimentacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuario`
--

DROP TABLE IF EXISTS `tbl_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuario`
--

LOCK TABLES `tbl_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_usuario` DISABLE KEYS */;
INSERT INTO `tbl_usuario` VALUES (1,'admin','admin','123456');
/*!40000 ALTER TABLE `tbl_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_valor`
--

DROP TABLE IF EXISTS `tbl_valor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_valor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `valor_demais_horas` double DEFAULT NULL,
  `valor_primeira_hora` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_valor`
--

LOCK TABLES `tbl_valor` WRITE;
/*!40000 ALTER TABLE `tbl_valor` DISABLE KEYS */;
INSERT INTO `tbl_valor` VALUES (1,4,6);
/*!40000 ALTER TABLE `tbl_valor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'estacionamento'
--

--
-- Dumping routines for database 'estacionamento'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-25 13:39:50
