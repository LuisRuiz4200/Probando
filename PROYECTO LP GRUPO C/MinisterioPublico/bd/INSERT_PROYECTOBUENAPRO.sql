-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyectobuenapro
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Dumping data for table `tb_actapropuesta`
--

LOCK TABLES `tb_actapropuesta` WRITE;
/*!40000 ALTER TABLE `tb_actapropuesta` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_actapropuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_apelacion`
--

LOCK TABLES `tb_apelacion` WRITE;
/*!40000 ALTER TABLE `tb_apelacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_apelacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_cep_pedido`
--

LOCK TABLES `tb_cep_pedido` WRITE;
/*!40000 ALTER TABLE `tb_cep_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_cep_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_evaluacionpropuesta`
--

LOCK TABLES `tb_evaluacionpropuesta` WRITE;
/*!40000 ALTER TABLE `tb_evaluacionpropuesta` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_evaluacionpropuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_objetopedido`
--

LOCK TABLES `tb_objetopedido` WRITE;
/*!40000 ALTER TABLE `tb_objetopedido` DISABLE KEYS */;
INSERT INTO `tb_objetopedido` VALUES (1,'Bien'),(2,'Servicio'),(3,'Obra');
/*!40000 ALTER TABLE `tb_objetopedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_participante`
--

LOCK TABLES `tb_participante` WRITE;
/*!40000 ALTER TABLE `tb_participante` DISABLE KEYS */;
INSERT INTO `tb_participante` VALUES ('PD001','PA001','Luis','12345678945212','luisruiz.com',987447092,'REGISTRADO'),('PD001','PA002','Klisman','12345678945212','luisruiz.com',987447092,'PROCESO'),('PD001','PA003','JeanPierre','12345678945212','luisruiz.com',987447092,'REGISTRADO'),('PD001','PA004','Daniel','12345678945212','luisruiz.com',987447092,'REGISTRADO'),('PD001','PA005','Julio','12345678945212','luisruiz.com',987447092,'REGISTRADO'),('PD002','PA006','Luis','784512135','luis ruiz',4784565,'REGISTRADO'),('PD002','PA007','Susana','784512135','luis ruiz',4784565,'REGISTRADO'),('PD002','PA008','Jasmin','784512135','luis ruiz',4784565,'REGISTRADO'),('PD002','PA009','Yuliana','784512135','luis ruiz',4784565,'REGISTRADO');
/*!40000 ALTER TABLE `tb_participante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_pedido`
--

LOCK TABLES `tb_pedido` WRITE;
/*!40000 ALTER TABLE `tb_pedido` DISABLE KEYS */;
INSERT INTO `tb_pedido` VALUES ('PD001','Gloria',2,1,'Mas vacas','2022-11-13','EN PROCESO'),('PD002','Claro',3,2,'Carcasas','2022-11-13','EN PROCESO'),('PD003','Cibertec',3,2,'Más computadoras','2022-11-13','REGISTRADO');
/*!40000 ALTER TABLE `tb_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_propuesta`
--

LOCK TABLES `tb_propuesta` WRITE;
/*!40000 ALTER TABLE `tb_propuesta` DISABLE KEYS */;
INSERT INTO `tb_propuesta` VALUES ('PD001','PR001','PA002','2022-11-08','Descripcion tecnica','Descripcion economica','REGISTRADO');
/*!40000 ALTER TABLE `tb_propuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_proyectopronunciamientoapelacion`
--

LOCK TABLES `tb_proyectopronunciamientoapelacion` WRITE;
/*!40000 ALTER TABLE `tb_proyectopronunciamientoapelacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_proyectopronunciamientoapelacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_tipopedido`
--

LOCK TABLES `tb_tipopedido` WRITE;
/*!40000 ALTER TABLE `tb_tipopedido` DISABLE KEYS */;
INSERT INTO `tb_tipopedido` VALUES (1,'Licitacion Publica'),(2,'Concurso Publica'),(3,'Adjudicacion Directa'),(4,'Adjudicacion Directa Selectiva'),(5,'Adjudicacion de Menor Cuantia');
/*!40000 ALTER TABLE `tb_tipopedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'proyectobuenapro'
--

--
-- Dumping routines for database 'proyectobuenapro'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-13 18:31:13
