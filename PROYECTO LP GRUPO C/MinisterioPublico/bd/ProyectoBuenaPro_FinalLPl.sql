CREATE DATABASE  IF NOT EXISTS `proyectobuenapro` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `proyectobuenapro`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: proyectobuenapro
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
-- Table structure for table `tb_actapropuesta`
--

DROP TABLE IF EXISTS `tb_actapropuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_actapropuesta` (
  `id_actaProp` char(10) NOT NULL,
  `id_prop` char(10) NOT NULL,
  `fecha_actaProp` date DEFAULT NULL,
  `descripcion_actaProp` varchar(500) DEFAULT NULL,
  `tipo_actaProp` varchar(25) DEFAULT NULL,
  `estado_actaProp` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_actaProp`),
  UNIQUE KEY `id_prop` (`id_prop`),
  KEY `id_prop_2` (`id_prop`),
  CONSTRAINT `tb_actapropuesta_ibfk_1` FOREIGN KEY (`id_prop`) REFERENCES `tb_propuesta` (`id_prop`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_actapropuesta`
--

LOCK TABLES `tb_actapropuesta` WRITE;
/*!40000 ALTER TABLE `tb_actapropuesta` DISABLE KEYS */;
INSERT INTO `tb_actapropuesta` VALUES ('AC001','PR003','2022-12-03','Falta copia de su RNP','Observaciones','REGISTRADO'),('AC002','PR002','2022-12-03','No cumple con el personal clave','Resultados','REGISTRADO');
/*!40000 ALTER TABLE `tb_actapropuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_apelacion`
--

DROP TABLE IF EXISTS `tb_apelacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_apelacion` (
  `id_apel` char(10) NOT NULL,
  `id_prop` char(10) NOT NULL,
  `fecha_apel` date DEFAULT NULL,
  `descripcion_apel` varchar(500) DEFAULT NULL,
  `estado_apel` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_apel`),
  UNIQUE KEY `id_prop` (`id_prop`),
  KEY `id_apel` (`id_apel`),
  CONSTRAINT `tb_apelacion_ibfk_1` FOREIGN KEY (`id_prop`) REFERENCES `tb_propuesta` (`id_prop`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_apelacion`
--

LOCK TABLES `tb_apelacion` WRITE;
/*!40000 ALTER TABLE `tb_apelacion` DISABLE KEYS */;
INSERT INTO `tb_apelacion` VALUES ('AP001','PR003','2022-12-03','El comité no cumplió con el plazo establecido para subsanar','NO FUNDADO');
/*!40000 ALTER TABLE `tb_apelacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cep_pedido`
--

DROP TABLE IF EXISTS `tb_cep_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cep_pedido` (
  `id_ped` char(10) NOT NULL,
  `id_miembroCEP` char(10) NOT NULL,
  `nombre_miembroCEP` varchar(25) DEFAULT NULL,
  `apellido_miemborCEP` varchar(25) DEFAULT NULL,
  `dni_miembroCEP` varchar(25) DEFAULT NULL,
  `funcion_miembroCEP` varchar(25) DEFAULT NULL,
  `dependencia_miembroCEP` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_ped`,`id_miembroCEP`),
  CONSTRAINT `tb_cep_pedido_ibfk_1` FOREIGN KEY (`id_ped`) REFERENCES `tb_pedido` (`id_ped`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cep_pedido`
--

LOCK TABLES `tb_cep_pedido` WRITE;
/*!40000 ALTER TABLE `tb_cep_pedido` DISABLE KEYS */;
INSERT INTO `tb_cep_pedido` VALUES ('PD002','MC001','Ricardo','Torres Montes','78961002','Presidente','logistica'),('PD002','MC002','Klisman','Santillan','45682115','Segundo miembro','SSGG'),('PD002','MC003','Leonel','Messi','74521360','Tercer  Miembro','Patrimonio'),('PD003','MC004','Pedro','Castillo','65412351','Presidente','Logistica');
/*!40000 ALTER TABLE `tb_cep_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_evaluacionpropuesta`
--

DROP TABLE IF EXISTS `tb_evaluacionpropuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_evaluacionpropuesta` (
  `id_prop` char(10) NOT NULL,
  `id_evaProp` char(10) NOT NULL,
  `puntTecnica_evaProp` decimal(10,0) DEFAULT NULL,
  `puntEconomica_evaProp` decimal(10,0) DEFAULT NULL,
  `fecha_evaProp` date DEFAULT NULL,
  `estado_evaProp` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_evaProp`),
  UNIQUE KEY `id_prop` (`id_prop`),
  CONSTRAINT `tb_evaluacionpropuesta_ibfk_1` FOREIGN KEY (`id_prop`) REFERENCES `tb_propuesta` (`id_prop`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_evaluacionpropuesta`
--

LOCK TABLES `tb_evaluacionpropuesta` WRITE;
/*!40000 ALTER TABLE `tb_evaluacionpropuesta` DISABLE KEYS */;
INSERT INTO `tb_evaluacionpropuesta` VALUES ('PR001','EVPR001',100,100,'2022-12-03','REGISTRADO'),('PR004','EVPR002',90,100,'2022-12-03','REGISTRADO');
/*!40000 ALTER TABLE `tb_evaluacionpropuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_objetopedido`
--

DROP TABLE IF EXISTS `tb_objetopedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_objetopedido` (
  `id_objetoPedido` int NOT NULL,
  `des_objetoPedido` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_objetoPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_objetopedido`
--

LOCK TABLES `tb_objetopedido` WRITE;
/*!40000 ALTER TABLE `tb_objetopedido` DISABLE KEYS */;
INSERT INTO `tb_objetopedido` VALUES (1,'Bien'),(2,'Servicio'),(3,'Obra');
/*!40000 ALTER TABLE `tb_objetopedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_participante`
--

DROP TABLE IF EXISTS `tb_participante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_participante` (
  `id_ped` char(10) NOT NULL,
  `codigo_parti` char(10) NOT NULL,
  `empresa_parti` varchar(25) DEFAULT NULL,
  `ruc_parti` varchar(25) DEFAULT NULL,
  `correo_parti` varchar(50) DEFAULT NULL,
  `telefono_parti` int DEFAULT NULL,
  `estado_parti` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_ped`,`codigo_parti`),
  KEY `codigo_parti` (`codigo_parti`),
  CONSTRAINT `tb_participante_ibfk_1` FOREIGN KEY (`id_ped`) REFERENCES `tb_pedido` (`id_ped`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_participante`
--

LOCK TABLES `tb_participante` WRITE;
/*!40000 ALTER TABLE `tb_participante` DISABLE KEYS */;
INSERT INTO `tb_participante` VALUES ('PD002','PA001','AirePeru SAC','20101337261','aireperu@gmail.com',999999999,'PROCESO'),('PD002','PA002','Gaseoducto SAC','20101337451','gases@outlook.com',958623145,'PROCESO'),('PD002','PA003','Ambiente SAC','20458632145','ambiente@hotmail,com',987456582,'PROCESO'),('PD002','PA004','GuadalupeSAC','45123658954','guadaluoe@hotmail.com',965235874,'REGISTRADO');
/*!40000 ALTER TABLE `tb_participante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pedido`
--

DROP TABLE IF EXISTS `tb_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_pedido` (
  `id_ped` char(10) NOT NULL,
  `entidad_ped` varchar(25) DEFAULT NULL,
  `ruc_ped` varchar(25) DEFAULT NULL,
  `id_tipoPedido` int NOT NULL,
  `id_objetoPedido` int NOT NULL,
  `descripcion_ped` varchar(300) DEFAULT NULL,
  `fecha_ped` date DEFAULT NULL,
  `estado_ped` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_ped`),
  KEY `id_tipoPedido` (`id_tipoPedido`),
  KEY `id_objetoPedido` (`id_objetoPedido`),
  CONSTRAINT `tb_pedido_ibfk_1` FOREIGN KEY (`id_tipoPedido`) REFERENCES `tb_tipopedido` (`id_tipoPedido`),
  CONSTRAINT `tb_pedido_ibfk_2` FOREIGN KEY (`id_objetoPedido`) REFERENCES `tb_objetopedido` (`id_objetoPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pedido`
--

LOCK TABLES `tb_pedido` WRITE;
/*!40000 ALTER TABLE `tb_pedido` DISABLE KEYS */;
INSERT INTO `tb_pedido` VALUES ('PD001','MINISTERIO Pï¿½BLICO','20131370301',2,1,'Adquisición de 1000 lapiceros','2022-12-03','REGISTRADO'),('PD002','MINISTERIO PUBLICO','20131370301',2,2,'Servicio de mantenimiento de aire acondicionado de la red norte del ministerio publico','2022-12-03','EN PROCESO'),('PD003','MINISTERIO PUBLICO','20131370301',3,3,'construccion de sede del ministerio publico en la provincia de huallaga','2022-12-03','REGISTRADO');
/*!40000 ALTER TABLE `tb_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_propuesta`
--

DROP TABLE IF EXISTS `tb_propuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_propuesta` (
  `id_ped` char(10) NOT NULL,
  `id_prop` char(10) NOT NULL,
  `codigo_parti` char(10) NOT NULL,
  `fecha_prop` date DEFAULT NULL,
  `desTecnica_prop` varchar(500) DEFAULT NULL,
  `desEconomica_prop` varchar(500) DEFAULT NULL,
  `estado_prop` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_ped`,`id_prop`),
  UNIQUE KEY `codigo_parti` (`codigo_parti`),
  KEY `id_prop` (`id_prop`),
  CONSTRAINT `tb_propuesta_ibfk_1` FOREIGN KEY (`id_ped`) REFERENCES `tb_pedido` (`id_ped`),
  CONSTRAINT `tb_propuesta_ibfk_2` FOREIGN KEY (`codigo_parti`) REFERENCES `tb_participante` (`codigo_parti`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_propuesta`
--

LOCK TABLES `tb_propuesta` WRITE;
/*!40000 ALTER TABLE `tb_propuesta` DISABLE KEYS */;
INSERT INTO `tb_propuesta` VALUES ('PD002','PR001','PA001','2022-12-03','Por declarion jurada DDJJ','Precio de S/.70000 al contado','EVALUADA'),('PD002','PR002','PA002','2022-12-03','Por declarion jurada DDJJ','Monto de S/ 80000','NO ADMITIDA'),('PD002','PR003','PA003','2022-12-03','Por declaracion jurada DDJJ','Monto de S/ 55000','OBSERVADO'),('PD002','PR004','PA004','2022-12-03','Cumple con declaracion jurada las especificaciones tecnicas ','Monto total de S/. 60000 soles','EVALUADA');
/*!40000 ALTER TABLE `tb_propuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_proyectopronunciamientoapelacion`
--

DROP TABLE IF EXISTS `tb_proyectopronunciamientoapelacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_proyectopronunciamientoapelacion` (
  `id_pronApel` char(10) NOT NULL,
  `id_apel` char(10) NOT NULL,
  `nomGerenteAJ_pronApel` varchar(25) DEFAULT NULL,
  `dniGerenteAJ_pronApel` varchar(25) DEFAULT NULL,
  `fecha_pronApel` date DEFAULT NULL,
  `descripcion_pronApel` varchar(500) DEFAULT NULL,
  `estado_pronApel` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_pronApel`),
  UNIQUE KEY `id_apel` (`id_apel`),
  CONSTRAINT `tb_proyectopronunciamientoapelacion_ibfk_1` FOREIGN KEY (`id_apel`) REFERENCES `tb_apelacion` (`id_apel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_proyectopronunciamientoapelacion`
--

LOCK TABLES `tb_proyectopronunciamientoapelacion` WRITE;
/*!40000 ALTER TABLE `tb_proyectopronunciamientoapelacion` DISABLE KEYS */;
INSERT INTO `tb_proyectopronunciamientoapelacion` VALUES ('PA001','AP001','Nicol Trujillo Valle','78565412','2022-12-03','Se declara no fundada la apelacion AP001 segun INFORME N° 01-NTV','NO FUNDADO');
/*!40000 ALTER TABLE `tb_proyectopronunciamientoapelacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipopedido`
--

DROP TABLE IF EXISTS `tb_tipopedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipopedido` (
  `id_tipoPedido` int NOT NULL,
  `des_tipoPedido` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id_tipoPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipopedido`
--

LOCK TABLES `tb_tipopedido` WRITE;
/*!40000 ALTER TABLE `tb_tipopedido` DISABLE KEYS */;
INSERT INTO `tb_tipopedido` VALUES (1,'Licitacion Publica'),(2,'Concurso Publica'),(3,'Adjudicacion Directa'),(4,'Adjudicacion Directa Selectiva'),(5,'Adjudicacion de Menor Cuantia');
/*!40000 ALTER TABLE `tb_tipopedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipouser`
--

DROP TABLE IF EXISTS `tb_tipouser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipouser` (
  `id_tipoUser` int NOT NULL,
  `des_tipoUser` varchar(25) NOT NULL,
  PRIMARY KEY (`id_tipoUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipouser`
--

LOCK TABLES `tb_tipouser` WRITE;
/*!40000 ALTER TABLE `tb_tipouser` DISABLE KEYS */;
INSERT INTO `tb_tipouser` VALUES (1,'Administrador'),(2,'Miembro del CEP'),(3,'Asistente de logistica'),(4,'Asesor juricio');
/*!40000 ALTER TABLE `tb_tipouser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `codigo_user` int NOT NULL,
  `nombre_user` varchar(25) DEFAULT NULL,
  `apellido_user` varchar(25) DEFAULT NULL,
  `usuario_user` char(10) NOT NULL,
  `clave_user` char(10) DEFAULT NULL,
  `fechaNac_user` date DEFAULT NULL,
  `tipo_user` int DEFAULT NULL,
  `estado_user` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`codigo_user`),
  KEY `tipo_user` (`tipo_user`),
  CONSTRAINT `tb_usuario_ibfk_1` FOREIGN KEY (`tipo_user`) REFERENCES `tb_tipouser` (`id_tipoUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,'Luis','Machaca Ruiz','admin','1234','2000-07-27',1,'REGISTRADO'),(2,'Klisman','Santillan','comite','1234','1980-12-09',2,'REGISTRADO'),(3,'JeanPier','Magiña','logistica','1234','1970-06-08',3,'REGISTRADO'),(4,'Nicol','Trujillo Valle','juridico','1234','2021-07-12',4,'REGISTRADO'),(5,'Luis','Ruiz','admin2','1234','2022-12-07',1,'REGISTRADO');
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
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

-- Dump completed on 2022-12-03 21:53:20
