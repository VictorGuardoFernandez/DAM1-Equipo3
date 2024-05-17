-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: acex_dam1_equipo3
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `actividades`
--

DROP TABLE IF EXISTS `actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividades` (
  `idactividad` int NOT NULL,
  `titulo_actividad` varchar(255) NOT NULL,
  `tipo_actividad` varchar(255) NOT NULL,
  `departamento` int NOT NULL,
  `previsto` tinyint NOT NULL,
  `medio_transporte` varchar(50) DEFAULT NULL,
  `fechaini` date NOT NULL,
  `horaini` time NOT NULL,
  `fechafn` date NOT NULL,
  `horafn` time NOT NULL,
  `numeroalumnos` int NOT NULL,
  `alojamiento` tinyint NOT NULL,
  `comentarios` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idactividad`),
  KEY `fk_departamento_idx` (`departamento`),
  CONSTRAINT `fk_Actividades_Solicitudes_Actividades1` FOREIGN KEY (`idactividad`) REFERENCES `solicitudes` (`idsolicitud`),
  CONSTRAINT `fk_departamento0` FOREIGN KEY (`departamento`) REFERENCES `departamentos` (`idDepartamentos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividades`
--

LOCK TABLES `actividades` WRITE;
/*!40000 ALTER TABLE `actividades` DISABLE KEYS */;
/*!40000 ALTER TABLE `actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actividades_grupos`
--

DROP TABLE IF EXISTS `actividades_grupos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividades_grupos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idactividad` int NOT NULL,
  `idgrupo` int NOT NULL,
  `num_alumnos` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Actividades_has_Grupo_Grupo1_idx` (`idgrupo`),
  KEY `fk_Actividades_has_Grupo_Actividades1_idx` (`idactividad`),
  CONSTRAINT `fk_Actividades_has_Grupo_Actividades1` FOREIGN KEY (`idactividad`) REFERENCES `actividades` (`idactividad`),
  CONSTRAINT `fk_Actividades_has_Grupo_Grupo1` FOREIGN KEY (`idgrupo`) REFERENCES `grupo` (`idgrupo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividades_grupos`
--

LOCK TABLES `actividades_grupos` WRITE;
/*!40000 ALTER TABLE `actividades_grupos` DISABLE KEYS */;
/*!40000 ALTER TABLE `actividades_grupos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actividades_has_cursos`
--

DROP TABLE IF EXISTS `actividades_has_cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividades_has_cursos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idactividad` int NOT NULL,
  `idcurso` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Actividades_has_Cursos_Actividades1_idx` (`idactividad`),
  KEY `fk_Actividades_has_Cursos_Cursos1` (`idcurso`),
  CONSTRAINT `fk_Actividades_has_Cursos_Actividades1` FOREIGN KEY (`idactividad`) REFERENCES `actividades` (`idactividad`),
  CONSTRAINT `fk_Actividades_has_Cursos_Cursos1` FOREIGN KEY (`idcurso`) REFERENCES `cursos` (`idcurso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividades_has_cursos`
--

LOCK TABLES `actividades_has_cursos` WRITE;
/*!40000 ALTER TABLE `actividades_has_cursos` DISABLE KEYS */;
/*!40000 ALTER TABLE `actividades_has_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `idcurso` int NOT NULL AUTO_INCREMENT,
  `codcurso` varchar(5) NOT NULL,
  `desc_curso` varchar(255) DEFAULT NULL,
  `etapa` varchar(255) NOT NULL,
  `activo` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`idcurso`),
  UNIQUE KEY `codcurs_UNIQUE` (`codcurso`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'ESO1','Educacion Secundaria Obligatoria - 1º','ESO',1),(2,'ESO2','Educacion Secundaria Obligatoria - 2º','ESO',1),(3,'ESO3','Educacion Secundaria Obligatoria - 3º','ESO',1),(4,'ESO4','Educacion Secundaria Obligatoria - 4º','ESO',1),(5,'BCH1','Bachillerato 1º','Bachillerato',1),(6,'BCH2','Bachillerato 2º','Bachillerato',1),(7,'FM1','Fabricacion y montaje - 1º','FPGM',1),(9,'MV1','Mantenimiento de Vehiculos - 1º','FPGM',1),(10,'MV2','Mantenimiento de Vehiculos - 2º','FPGM',1),(11,'CAR1','Carroceria - 1º','FPGM',1),(12,'CAR2','Carroceria - 2º','FPGM',1),(13,'EVA1','Electromeca¡nica de Vehiculos Automoviles - 1º','FPGM',1),(14,'EVA2','Electromeca¡nica de Vehiculos Automoviles - 2º','FPGM',1),(15,'SMR1','Sistemas Microinforma¡ticos y Redes - 1º','FPGM',1),(16,'SMR2','Sistemas Microinforma¡ticos y Redes - 2º','FPGM',1),(17,'AF1','Administracion y Finanzas - 1º','FPGS',1),(18,'AF2','Administracion y Finanzas - 2º','FPGS',1),(19,'DAM1','Desarrollo de Aplicaciones Multiplataforma - 1º','FPGS',1),(20,'DAM2','Desarrollo de Aplicaciones Multiplataforma - 2º','FPGS',1),(21,'DAW1','Desarrollo de Aplicaciones Web - 1º','FPGS',1),(22,'DAW2','Desarrollo de Aplicaciones Web - 2º','FPGS',1),(23,'DFM1','Diseño en Fabricacion Meca¡nica - 1º','FPGS',1),(24,'DFM23','Diseño en Fabricacion Meca¡nica - 2º','FPGS',1);
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamentos` (
  `idDepartamentos` int NOT NULL AUTO_INCREMENT,
  `cod_departamento` char(3) NOT NULL,
  `nom_departamento` varchar(45) NOT NULL,
  `idjefe_departamento` int DEFAULT NULL,
  PRIMARY KEY (`idDepartamentos`),
  KEY `FK_jefedepar_idx` (`idjefe_departamento`),
  CONSTRAINT `FK_jefedepar` FOREIGN KEY (`idjefe_departamento`) REFERENCES `profesores` (`idprofesores`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamentos`
--

LOCK TABLES `departamentos` WRITE;
/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
INSERT INTO `departamentos` VALUES (1,'BG','Biologia y Geologia',NULL),(2,'DIB','Dibujo',NULL),(3,'ECO','Economia',11),(4,'EF','Educacion Fisica',NULL),(5,'FIL','Filosofia',14),(6,'FQ','Fisica y Quimica',9),(7,'FRA','Frances',NULL),(8,'GH','Geografia e Historia',15),(9,'ING','Ingles',1),(10,'LAT','Latin',NULL),(11,'LEN','Lengua castellana y literatura',7),(12,'MAT','Matematicas',2),(13,'MUS','Musica',NULL),(14,'TEC','Tecnologia',NULL),(15,'AG','Administracion y Gestion',NULL),(16,'FOL','Formacion y orientaqcion laboral',NULL),(17,'INF','Informatica y comunicaciones',4),(18,'FM','Fabricacion mecanica',NULL);
/*!40000 ALTER TABLE `departamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foto_actividad`
--

DROP TABLE IF EXISTS `foto_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `foto_actividad` (
  `idfoto_actividad` int NOT NULL,
  `url_foto` longtext NOT NULL,
  `descripcion_foto` varchar(255) NOT NULL,
  `idactividad_programada` int NOT NULL,
  PRIMARY KEY (`idfoto_actividad`),
  KEY `fk_actividades_idx` (`idactividad_programada`),
  CONSTRAINT `fk_actividades` FOREIGN KEY (`idactividad_programada`) REFERENCES `foto_actividad` (`idfoto_actividad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto_actividad`
--

LOCK TABLES `foto_actividad` WRITE;
/*!40000 ALTER TABLE `foto_actividad` DISABLE KEYS */;
/*!40000 ALTER TABLE `foto_actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fotos_actividad_programada`
--

DROP TABLE IF EXISTS `fotos_actividad_programada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fotos_actividad_programada` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idfoto` int NOT NULL,
  `id_solicitud` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_actividad programada_has_Foto_actividad_Foto_actividad1_idx` (`idfoto`),
  KEY `fk_fotos actividad programada_Solicitudes_Actividades1_idx` (`id_solicitud`),
  CONSTRAINT `fk_actividad programada_has_Foto_actividad_Foto_actividad1` FOREIGN KEY (`idfoto`) REFERENCES `foto_actividad` (`idfoto_actividad`),
  CONSTRAINT `fk_fotos actividad programada_Solicitudes_Actividades1` FOREIGN KEY (`id_solicitud`) REFERENCES `solicitudes` (`idsolicitud`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fotos_actividad_programada`
--

LOCK TABLES `fotos_actividad_programada` WRITE;
/*!40000 ALTER TABLE `fotos_actividad_programada` DISABLE KEYS */;
/*!40000 ALTER TABLE `fotos_actividad_programada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupo` (
  `idgrupo` int NOT NULL AUTO_INCREMENT,
  `idcurso` int NOT NULL,
  `num_alumnos` int NOT NULL,
  `activo` tinyint NOT NULL DEFAULT '1',
  `codgrupo` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idgrupo`),
  KEY `FK_Grupo_curso_idx` (`idcurso`),
  CONSTRAINT `FK_Grupo_curso` FOREIGN KEY (`idcurso`) REFERENCES `cursos` (`idcurso`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` VALUES (1,1,22,1,'ESO1A'),(2,1,21,1,'ESO1B'),(3,1,20,1,'ESO1C'),(4,1,22,1,'ESO1D'),(5,2,19,1,'ESO2A'),(6,2,21,1,'ESO2B'),(7,2,20,1,'ESO2C'),(8,2,19,1,'ESO2D'),(9,3,25,1,'ESO3A'),(10,3,24,1,'ESO3B'),(11,3,25,1,'ESO3C'),(12,4,19,1,'ESO4A'),(13,4,18,1,'ESO4B'),(14,4,18,1,'ESO4C'),(15,4,17,1,'ESO4D'),(16,5,21,1,'BCH1HCS'),(17,5,22,1,'BCH1CT'),(18,6,20,1,'BCH2HCS'),(19,6,19,1,'BDH2CT'),(20,7,24,1,'FM1'),(22,9,25,1,'MV1'),(23,10,15,1,'MV2'),(24,11,25,1,'CAR1'),(25,12,16,1,'CAR2'),(26,13,24,1,'EVA1'),(27,14,14,1,'EVA2'),(28,15,28,1,'SMR1'),(29,16,19,1,'SMR2'),(30,17,24,1,'AF1'),(31,18,23,1,'AF2'),(32,19,28,1,'DAM1'),(33,20,35,1,'DAM2'),(34,21,24,1,'DAW1'),(35,22,18,1,'DAW2'),(36,23,16,1,'DFM1'),(37,24,9,1,'DFM2');
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medio_transporte`
--

DROP TABLE IF EXISTS `medio_transporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medio_transporte` (
  `id` int NOT NULL,
  `tipo` enum('andando','bici','bus','taxi','barco','tren','avion') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medio_transporte`
--

LOCK TABLES `medio_transporte` WRITE;
/*!40000 ALTER TABLE `medio_transporte` DISABLE KEYS */;
INSERT INTO `medio_transporte` VALUES (1,'andando'),(2,'bici'),(3,'tren'),(4,'bus'),(5,'taxi'),(6,'barco'),(7,'avion');
/*!40000 ALTER TABLE `medio_transporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medio_transporte_has_actividades`
--

DROP TABLE IF EXISTS `medio_transporte_has_actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medio_transporte_has_actividades` (
  `id` int NOT NULL AUTO_INCREMENT,
  `medio_transporte_id` int NOT NULL,
  `actividades_idactividad` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_medio_transporte_has_actividades_medio_transporte1_idx` (`medio_transporte_id`),
  KEY `fk_medio_transporte_has_actividades_actividades1_idx` (`actividades_idactividad`),
  CONSTRAINT `fk_medio_transporte_has_actividades_actividades1` FOREIGN KEY (`actividades_idactividad`) REFERENCES `actividades` (`idactividad`),
  CONSTRAINT `fk_medio_transporte_has_actividades_medio_transporte1` FOREIGN KEY (`medio_transporte_id`) REFERENCES `medio_transporte` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medio_transporte_has_actividades`
--

LOCK TABLES `medio_transporte_has_actividades` WRITE;
/*!40000 ALTER TABLE `medio_transporte_has_actividades` DISABLE KEYS */;
/*!40000 ALTER TABLE `medio_transporte_has_actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medio_transporte_has_solicitudes_actividades`
--

DROP TABLE IF EXISTS `medio_transporte_has_solicitudes_actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medio_transporte_has_solicitudes_actividades` (
  `id` int NOT NULL AUTO_INCREMENT,
  `medio_transporte_id` int NOT NULL,
  `solicitudes_actividades_idsolicitud` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_medio_transporte_has_solicitudes_actividades_medio_trans_idx` (`medio_transporte_id`),
  KEY `fk_medio_transporte_has_solicitudes_actividades_solicitudes_idx` (`solicitudes_actividades_idsolicitud`),
  CONSTRAINT `fk_medio_transporte_has_solicitudes_actividades_medio_transpo1` FOREIGN KEY (`medio_transporte_id`) REFERENCES `medio_transporte` (`id`),
  CONSTRAINT `fk_medio_transporte_has_solicitudes_actividades_solicitudes_a1` FOREIGN KEY (`solicitudes_actividades_idsolicitud`) REFERENCES `solicitudes` (`idsolicitud`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medio_transporte_has_solicitudes_actividades`
--

LOCK TABLES `medio_transporte_has_solicitudes_actividades` WRITE;
/*!40000 ALTER TABLE `medio_transporte_has_solicitudes_actividades` DISABLE KEYS */;
/*!40000 ALTER TABLE `medio_transporte_has_solicitudes_actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil_acceso`
--

DROP TABLE IF EXISTS `perfil_acceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfil_acceso` (
  `idprofesor` int NOT NULL,
  `tipo` enum('superusuario','administrador','equipo  directivo','profesor') NOT NULL,
  `correo` varchar(255) NOT NULL,
  `password` char(32) NOT NULL,
  PRIMARY KEY (`idprofesor`),
  UNIQUE KEY `correo_UNIQUE` (`correo`),
  KEY `fk_perfil_acceso_profesores1_idx` (`idprofesor`),
  CONSTRAINT `fk_perfil_acceso_profesores1` FOREIGN KEY (`idprofesor`) REFERENCES `profesores` (`idprofesores`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil_acceso`
--

LOCK TABLES `perfil_acceso` WRITE;
/*!40000 ALTER TABLE `perfil_acceso` DISABLE KEYS */;
INSERT INTO `perfil_acceso` VALUES (1,'profesor','pablo.sanzcampo@educantabria.es','81dc9bdb52d04dc20036dbd8313ed055'),(2,'profesor','luism.serranoceballos@educantabria.es','81dc9bdb52d04dc20036dbd8313ed055'),(3,'profesor','olatz.sanmiguelmart@educantabria.es','81dc9bdb52d04dc20036dbd8313ed055'),(4,'profesor','alejandro.carreraruiz@educantabria.es','81dc9bdb52d04dc20036dbd8313ed055'),(5,'profesor','lulu.ortiz01@educantabria.es','81dc9bdb52d04dc20036dbd8313ed055'),(6,'profesor','rreigadasfo01@educantabria.es','81dc9bdb52d04dc20036dbd8313ed055'),(7,'profesor','marcos.fernandezvallejo@educantabria.es','81dc9bdb52d04dc20036dbd8313ed055'),(8,'profesor','joheviaort01@educantabria.es','81dc9bdb52d04dc20036dbd8313ed055'),(9,'profesor','mgomezarro01@educantabria.es','81dc9bdb52d04dc20036dbd8313ed055'),(10,'profesor','yescuderova01@educantabria.es','81dc9bdb52d04dc20036dbd8313ed055'),(11,'profesor','david.benitoalmeida@educantabria.es','81dc9bdb52d04dc20036dbd8313ed055'),(12,'profesor','fjtruebaroja01@educantabria.es','81dc9bdb52d04dc20036dbd8313ed055'),(13,'profesor','mgutierrez95@educantabria.es','81dc9bdb52d04dc20036dbd8313ed055'),(14,'profesor','david.sanchezjunco@educantabria.es','81dc9bdb52d04dc20036dbd8313ed055'),(15,'administrador','vmartinezba01@educantabria.es','81dc9bdb52d04dc20036dbd8313ed055');
/*!40000 ALTER TABLE `perfil_acceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor_participantes`
--

DROP TABLE IF EXISTS `profesor_participantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor_participantes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idsolicitud` int NOT NULL,
  `idprofesores` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_profesor responsable_Solicitudes_Actividades1_idx` (`idsolicitud`),
  KEY `fk_profesor responsable_Profesores1_idx` (`idprofesores`),
  CONSTRAINT `fk_profesor responsable_Profesores1` FOREIGN KEY (`idprofesores`) REFERENCES `profesores` (`idprofesores`),
  CONSTRAINT `fk_profesor responsable_Solicitudes_Actividades1` FOREIGN KEY (`idsolicitud`) REFERENCES `solicitudes` (`idsolicitud`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor_participantes`
--

LOCK TABLES `profesor_participantes` WRITE;
/*!40000 ALTER TABLE `profesor_participantes` DISABLE KEYS */;
/*!40000 ALTER TABLE `profesor_participantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor_respo`
--

DROP TABLE IF EXISTS `profesor_respo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor_respo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idsolicitud` int NOT NULL,
  `idprofesores` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fksoli_idx` (`idsolicitud`),
  KEY `fkprofe_idx` (`idprofesores`),
  CONSTRAINT `fkprofe` FOREIGN KEY (`idprofesores`) REFERENCES `profesores` (`idprofesores`),
  CONSTRAINT `fksoli` FOREIGN KEY (`idsolicitud`) REFERENCES `solicitudes` (`idsolicitud`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor_respo`
--

LOCK TABLES `profesor_respo` WRITE;
/*!40000 ALTER TABLE `profesor_respo` DISABLE KEYS */;
INSERT INTO `profesor_respo` VALUES (1,2,3),(2,2,4),(3,2,3),(4,2,4),(5,2,5),(6,3,3),(7,3,4),(8,3,3),(9,3,4),(10,3,5),(11,4,3),(12,4,4),(13,4,3),(14,4,4),(15,4,5),(16,5,5),(17,5,5);
/*!40000 ALTER TABLE `profesor_respo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesores`
--

DROP TABLE IF EXISTS `profesores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesores` (
  `idprofesores` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `dni` char(9) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `departamento` int NOT NULL,
  PRIMARY KEY (`idprofesores`),
  UNIQUE KEY `DNI_UNIQUE` (`dni`),
  UNIQUE KEY `correo_UNIQUE` (`correo`),
  KEY `FK_depart_profs_idx` (`departamento`),
  CONSTRAINT `FK_depart_profs` FOREIGN KEY (`departamento`) REFERENCES `departamentos` (`idDepartamentos`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3 PACK_KEYS=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesores`
--

LOCK TABLES `profesores` WRITE;
/*!40000 ALTER TABLE `profesores` DISABLE KEYS */;
INSERT INTO `profesores` VALUES (1,'Pablo','Sanz Campo','22221940W','pablo.sanzcampo@educantabria.es',9),(2,'Luis Manuel','Serrano Ceballos','84434964K','luism.serranoceballos@educantabria.es',12),(3,'Olatz2','San Miguel Martinez','04266894X','olatz.sanmiguelmart@educantabria.es',12),(4,'Alejandro','Carrera Ruiz','21156345S','alejandro.carreraruiz@educantabria.es',17),(5,'Lulu','Ortiz Royuela','63568530G','lulu.ortiz01@educantabria.es',17),(6,'Raul','Reigadas Fonfria','17394999M','rreigadasfo01@educantabria.es',12),(7,'Marcos','Fernandez Vallejo','58388245M','marcos.fernandezvallejo@educantabria.es',11),(8,'Jonatan','Hevia Ortiz','52821689C','joheviaort01@educantabria.es',9),(9,'Manuel','Gomez Arronte','78117930Y','mgomezarro01@educantabria.es',6),(10,'Yolanda','Escudero Valdes','08845506','yescuderova01@educantabria.es',17),(11,'David','Benito Almeida','65003264B','david.benitoalmeida@educantabria.es',3),(12,'Francisco Jose','Trueba Rojas','55452491Y','fjtruebaroja01@educantabria.es',12),(13,'Maria','Gutierrez Castañeda','68567981Z','mgutierrez95@educantabria.es',17),(14,'David','Sanchez Junco','03719263F','david.sanchezjunco@educantabria.es',5),(15,'Victor','Martinez Balbas','53554206S','vmartinezba01@educantabria.es',8);
/*!40000 ALTER TABLE `profesores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesores_participantes_actividades`
--

DROP TABLE IF EXISTS `profesores_participantes_actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesores_participantes_actividades` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idprofesores` int NOT NULL,
  `idactividad` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Profesores_has_Actividades_Profesores1_idx` (`idprofesores`),
  KEY `fk_Profesores_has_Actividades_Actividades1_idx` (`idactividad`),
  CONSTRAINT `fk_Profesores_has_Actividades_Actividades1` FOREIGN KEY (`idactividad`) REFERENCES `actividades` (`idactividad`),
  CONSTRAINT `fk_Profesores_has_Actividades_Profesores1` FOREIGN KEY (`idprofesores`) REFERENCES `profesores` (`idprofesores`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesores_participantes_actividades`
--

LOCK TABLES `profesores_participantes_actividades` WRITE;
/*!40000 ALTER TABLE `profesores_participantes_actividades` DISABLE KEYS */;
/*!40000 ALTER TABLE `profesores_participantes_actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesores_responsables_actividades`
--

DROP TABLE IF EXISTS `profesores_responsables_actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesores_responsables_actividades` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idprofesores_responsables` int NOT NULL,
  `idactividad_responsable` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_profesores_responsables_Profesores1_idx` (`idprofesores_responsables`),
  KEY `fk_profesores_responsables_Actividades1_idx` (`idactividad_responsable`),
  CONSTRAINT `fk_profesores_responsables_Actividades1` FOREIGN KEY (`idactividad_responsable`) REFERENCES `actividades` (`idactividad`),
  CONSTRAINT `fk_profesores_responsables_Profesores1` FOREIGN KEY (`idprofesores_responsables`) REFERENCES `profesores` (`idprofesores`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesores_responsables_actividades`
--

LOCK TABLES `profesores_responsables_actividades` WRITE;
/*!40000 ALTER TABLE `profesores_responsables_actividades` DISABLE KEYS */;
/*!40000 ALTER TABLE `profesores_responsables_actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitudes`
--

DROP TABLE IF EXISTS `solicitudes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitudes` (
  `idsolicitud` int NOT NULL AUTO_INCREMENT,
  `titulo_actividad` varchar(255) NOT NULL,
  `tipo_actividad` varchar(255) NOT NULL,
  `departamento` int NOT NULL,
  `previsto` tinyint NOT NULL,
  `medio_transporte` tinyint DEFAULT NULL,
  `fechaini` date NOT NULL,
  `horaini` time NOT NULL,
  `fechafn` date NOT NULL,
  `horafn` time NOT NULL,
  `numeroalumnos` int NOT NULL,
  `alojamiento` tinyint NOT NULL,
  `comentarios` varchar(255) DEFAULT NULL,
  `estado` enum('solicitado','aprobado','denegado','realizado') NOT NULL,
  `idprofesores_solicitante` int NOT NULL,
  PRIMARY KEY (`idsolicitud`),
  KEY `fk_departamento_idx` (`departamento`),
  KEY `fk_solicitudes_actividades_profesores1_idx` (`idprofesores_solicitante`),
  CONSTRAINT `fk_departamento` FOREIGN KEY (`departamento`) REFERENCES `departamentos` (`idDepartamentos`),
  CONSTRAINT `fk_solicitudes_actividades_profesores1` FOREIGN KEY (`idprofesores_solicitante`) REFERENCES `profesores` (`idprofesores`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudes`
--

LOCK TABLES `solicitudes` WRITE;
/*!40000 ALTER TABLE `solicitudes` DISABLE KEYS */;
INSERT INTO `solicitudes` VALUES (1,'a','a',1,1,1,'2024-07-31','12:30:00','2024-08-01','12:30:00',24,0,'sad','solicitado',1),(2,'a','a',4,0,0,'2024-05-17','17:30:00','2024-05-20','17:30:00',24,1,'a','solicitado',3),(3,'a','a',4,0,0,'2024-05-17','17:30:00','2024-05-20','17:30:00',24,1,'a','solicitado',3),(4,'a','a',4,0,0,'2024-05-17','17:30:00','2024-05-20','17:30:00',24,1,'a','solicitado',3),(5,'prueba','prueba',4,0,0,'2024-05-17','17:30:00','2024-05-21','17:30:00',12,1,'prueba','solicitado',5),(6,'a','a',1,1,0,'2024-05-17','17:30:00','2024-05-17','17:30:00',12,1,'a','solicitado',5),(7,'a','a',1,1,1,'2024-05-17','17:30:00','2024-05-17','17:30:00',12,1,'a','solicitado',1),(8,'a','a',1,1,1,'2024-05-17','17:30:00','2024-05-24','17:30:00',12,0,'a','aprobado',1),(9,'vc','vc',1,1,1,'2024-05-17','17:30:00','2024-05-24','17:30:00',43,0,'vc','solicitado',3),(10,'a','a',1,1,1,'2024-05-17','17:30:00','2024-05-20','17:30:00',12,0,'a','solicitado',4),(11,'hola','hola',6,1,1,'2024-05-17','17:30:00','2024-05-21','17:30:00',12,0,'prueba2','solicitado',5),(12,'a','a',7,1,1,'2024-05-17','17:30:00','2024-05-17','17:30:00',12,1,'a','solicitado',5),(13,'a','a',5,1,1,'2024-05-17','14:30:00','2024-05-17','17:30:00',54,0,'a','solicitado',1);
/*!40000 ALTER TABLE `solicitudes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitudes_cursos`
--

DROP TABLE IF EXISTS `solicitudes_cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitudes_cursos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idsolicitud` int NOT NULL,
  `cursos_idcursos` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Solicitudes_Actividades_has_Cursos_Solicitudes_Actividad_idx` (`idsolicitud`),
  KEY `fk_Solicitudes_Actividades_has_Cursos_Cursos1_idx` (`cursos_idcursos`),
  CONSTRAINT `fk_Solicitudes_Actividades_has_Cursos_Cursos1` FOREIGN KEY (`cursos_idcursos`) REFERENCES `cursos` (`idcurso`),
  CONSTRAINT `fk_Solicitudes_Actividades_has_Cursos_Solicitudes_Actividades1` FOREIGN KEY (`idsolicitud`) REFERENCES `solicitudes` (`idsolicitud`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudes_cursos`
--

LOCK TABLES `solicitudes_cursos` WRITE;
/*!40000 ALTER TABLE `solicitudes_cursos` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitudes_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitudes_grupo`
--

DROP TABLE IF EXISTS `solicitudes_grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitudes_grupo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idsolicitud` int NOT NULL,
  `grupo_idgrupo` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Solicitudes_Actividades_has_Grupo_Solicitudes_Actividade_idx` (`idsolicitud`),
  KEY `fk_Solicitudes_Actividades_has_Grupo_Grupo1_idx` (`grupo_idgrupo`),
  CONSTRAINT `fk_Solicitudes_Actividades_has_Grupo_Grupo1` FOREIGN KEY (`grupo_idgrupo`) REFERENCES `grupo` (`idgrupo`),
  CONSTRAINT `fk_Solicitudes_Actividades_has_Grupo_Solicitudes_Actividades1` FOREIGN KEY (`idsolicitud`) REFERENCES `solicitudes` (`idsolicitud`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudes_grupo`
--

LOCK TABLES `solicitudes_grupo` WRITE;
/*!40000 ALTER TABLE `solicitudes_grupo` DISABLE KEYS */;
INSERT INTO `solicitudes_grupo` VALUES (1,4,5),(2,4,6),(3,4,7),(4,4,8),(5,5,1);
/*!40000 ALTER TABLE `solicitudes_grupo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-17  5:59:43
