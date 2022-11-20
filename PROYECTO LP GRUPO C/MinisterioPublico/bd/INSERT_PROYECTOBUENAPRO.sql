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
-- Dumping data for table `tb_actapropuesta`
--

LOCK TABLES `tb_actapropuesta` WRITE;
/*!40000 ALTER TABLE `tb_actapropuesta` DISABLE KEYS */;
INSERT INTO `tb_actapropuesta` VALUES ('AC001','PR001','2022-11-20','Propuesta no cumple con las normas de las bases administrativas','Resultados','REGISTRADO'),('AC002','PR002','2022-11-20','Propuesta le falta la documentacion necesario para pasar a evaluar','Observaciones','REGISTRADO');
/*!40000 ALTER TABLE `tb_actapropuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_apelacion`
--

LOCK TABLES `tb_apelacion` WRITE;
/*!40000 ALTER TABLE `tb_apelacion` DISABLE KEYS */;
INSERT INTO `tb_apelacion` VALUES ('AP001','PR002','2022-11-20','Reitero mi solicitud de revision de documentos, pues se entregaron todos conforme a ley.','REGISTRADO');
/*!40000 ALTER TABLE `tb_apelacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_cep_pedido`
--

LOCK TABLES `tb_cep_pedido` WRITE;
/*!40000 ALTER TABLE `tb_cep_pedido` DISABLE KEYS */;
INSERT INTO `tb_cep_pedido` VALUES ('PD001','MC001','Jean Pierre','Magiña','73206631','Presidente','Equipamiento'),('PD001','MC002','Toribio','Mendoza','73445511','Primer miembro','Logistica');
/*!40000 ALTER TABLE `tb_cep_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_evaluacionpropuesta`
--

LOCK TABLES `tb_evaluacionpropuesta` WRITE;
/*!40000 ALTER TABLE `tb_evaluacionpropuesta` DISABLE KEYS */;
INSERT INTO `tb_evaluacionpropuesta` VALUES ('PR003','EVPR001',100,60,'2022-11-20','REGISTRADO');
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
INSERT INTO `tb_participante` VALUES ('PD001','PA004','Fibra Activos SAC','20549714356','FibraActivos@hotmail.com',956856241,'PROCESO'),('PD001','PA005','Fibra Com Peru SAC','20601395241','FibraComPeru@outlook.com',996521458,'PROCESO'),('PD002','PA001','Roca SAC','20101337261','Roca@hotmail.com',987256134,'REGISTRADO'),('PD002','PA002','Draeger Peru SAC','20538597121','Drager@gmail.com',987563211,'REGISTRADO'),('PD002','PA003','Vitaltec SAC','20501645517','Vitaltec@outlook.com',956321847,'REGISTRADO');
/*!40000 ALTER TABLE `tb_participante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_pedido`
--

LOCK TABLES `tb_pedido` WRITE;
/*!40000 ALTER TABLE `tb_pedido` DISABLE KEYS */;
INSERT INTO `tb_pedido` VALUES ('PD001','Diris LN','20602217508',1,2,'Solicitud de balances prematales para el área de obstetricia.','2022-11-19','REGISTRADO'),('PD002','Ministerio Publico','20131360301',2,2,'Servicio de transporte especializado en seguridad.','2022-11-19','REGISTRADO'),('PD003','MTC','20131379944',3,1,'Solicitud de mil metros de Fibra Optica.','2022-11-19','REGISTRADO');
/*!40000 ALTER TABLE `tb_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_propuesta`
--

LOCK TABLES `tb_propuesta` WRITE;
/*!40000 ALTER TABLE `tb_propuesta` DISABLE KEYS */;
INSERT INTO `tb_propuesta` VALUES ('PD001','PR001','PA004','2022-11-19','Declaracion jurada de especificacion técnica de fibra óptica ','Valor del bien 25000 soles.','NO ADMITIDA'),('PD001','PR002','PA005','2022-11-19','Fibra monomodo \nRango de longitud de onda de 1310nm.\nLongitudes de onda  de 1550nm.\nAtenuación máxima de:\n0,35 dB/km a 1310 nm.\n0,25 dB/km a 1550 nm.\nDiámetro del campo modal.\nEl valor nominal del campo modal a 1310 nm. será de: 9,3 +/- 0,5 μm.\nDiámetro del revestimiento.\nEl diámetro del revestimiento será de: 125 μm. +/- 1 μm','Valor del Bien 8000 nuevos soles.','OBSERVADO'),('PD002','PR003','PA001','2022-11-20','20 transporte publicos con altos standares de seguridad','5 mil nuevos soles por cada unidad de transporte','EVALUADO');
/*!40000 ALTER TABLE `tb_propuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_proyectopronunciamientoapelacion`
--

LOCK TABLES `tb_proyectopronunciamientoapelacion` WRITE;
/*!40000 ALTER TABLE `tb_proyectopronunciamientoapelacion` DISABLE KEYS */;
INSERT INTO `tb_proyectopronunciamientoapelacion` VALUES ('PA002','AP001','Klisman Santillan','75963001','2022-11-20','No entrega la sustentacion necesaria para defenderse','No fundado');
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
-- Dumping data for table `tb_tipouser`
--

LOCK TABLES `tb_tipouser` WRITE;
/*!40000 ALTER TABLE `tb_tipouser` DISABLE KEYS */;
INSERT INTO `tb_tipouser` VALUES (1,'Administrador'),(2,'Miembro del CEP'),(3,'Asistente de logistica'),(4,'Asesor juricio');
/*!40000 ALTER TABLE `tb_tipouser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,'Luis Alberto ','Machaca Ruiz','luis27','1234','2020-07-27',1,'REGISTRADO'),(2,'Jean Pierre','Maguiña ','JP1987','1894','1993-06-23',2,'REGISTRADO'),(3,'Klisman','Santillan','tubebito','4321','1988-09-16',3,'REGISTRADO'),(4,'Nicol','Trujillo Valle','nicol12','1234','2021-10-13',4,'REGISTRADO'),(5,'Luis','Ruiz','admin','1234','2022-11-20',1,'ELIMINADO');
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

-- Dump completed on 2022-11-20  9:36:02
