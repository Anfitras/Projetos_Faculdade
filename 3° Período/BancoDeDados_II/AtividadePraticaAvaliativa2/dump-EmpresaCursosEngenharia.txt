-- MySQL dump 10.13  Distrib 8.0.45, for Linux (x86_64)
--
-- Host: localhost    Database: EmpresaCursosEngenharia
-- ------------------------------------------------------
-- Server version	8.0.45-0ubuntu0.24.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Aluno`
--

DROP TABLE IF EXISTS `Aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Aluno` (
  `id_aluno` int NOT NULL AUTO_INCREMENT,
  `matricula` varchar(20) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `data_nascimento` date NOT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `data_modificacao` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_aluno`),
  UNIQUE KEY `matricula` (`matricula`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Aluno`
--

LOCK TABLES `Aluno` WRITE;
/*!40000 ALTER TABLE `Aluno` DISABLE KEYS */;
INSERT INTO `Aluno` VALUES (1,'AL001','Arthur','2000-05-15','111.111.111-11','arthur@email.com','2026-05-30 20:49:18'),(2,'AL002','Luan','1999-08-22','222.222.222-22','luan@email.com','2026-05-30 20:49:16'),(3,'AL003','Reivedd','2001-02-10','333.333.333-33','reivedd@email.com','2026-05-30 20:49:14'),(4,'AL004','Gustav','1998-11-30','444.444.444-44','gustav@email.com','2026-05-30 20:49:11'),(5,'AL005','Mariana','2002-03-05','555.555.555-55','mariana@email.com','2026-05-30 20:49:06');
/*!40000 ALTER TABLE `Aluno` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 */ /*!50003 TRIGGER `trg_Atualizar_Data_Modificacao` BEFORE UPDATE ON `Aluno` FOR EACH ROW BEGIN
    SET NEW.data_modificacao = NOW();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 */ /*!50003 TRIGGER `trg_Log_Aluno_Update` AFTER UPDATE ON `Aluno` FOR EACH ROW BEGIN
    INSERT INTO Log_Sistema (tabela_afetada, acao, detalhes)
    VALUES ('Aluno', 'UPDATE', CONCAT('Matricula: ', OLD.matricula, ' | Nome Antigo: ', OLD.nome, ' -> Novo: ', NEW.nome));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `Curso`
--

DROP TABLE IF EXISTS `Curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Curso` (
  `id_curso` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` text,
  PRIMARY KEY (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Curso`
--

LOCK TABLES `Curso` WRITE;
/*!40000 ALTER TABLE `Curso` DISABLE KEYS */;
INSERT INTO `Curso` VALUES (1,'Formação Completa em Engenharia de Software','Capacitação do básico ao avançado em desenvolvimento e arquitetura');
/*!40000 ALTER TABLE `Curso` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 */ /*!50003 TRIGGER `trg_Log_Curso_Update` AFTER UPDATE ON `Curso` FOR EACH ROW BEGIN
    INSERT INTO Log_Sistema (tabela_afetada, acao, detalhes)
    VALUES ('Curso', 'UPDATE', CONCAT('ID: ', OLD.id_curso, ' | Nome Antigo: ', OLD.nome, ' -> Novo: ', NEW.nome));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `Instrutor`
--

DROP TABLE IF EXISTS `Instrutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Instrutor` (
  `id_instrutor` int NOT NULL AUTO_INCREMENT,
  `codigo_instrutor` varchar(20) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `titulacao` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_instrutor`),
  UNIQUE KEY `codigo_instrutor` (`codigo_instrutor`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Instrutor`
--

LOCK TABLES `Instrutor` WRITE;
/*!40000 ALTER TABLE `Instrutor` DISABLE KEYS */;
INSERT INTO `Instrutor` VALUES (1,'INST001','Alan Turing','111.111.111-11','Doutor em Ciência da Computação'),(2,'INST002','Ada Lovelace','222.222.222-22','Mestre em Arquitetura de Software');
/*!40000 ALTER TABLE `Instrutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Instrutor_Topico`
--

DROP TABLE IF EXISTS `Instrutor_Topico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Instrutor_Topico` (
  `id_instrutor` int NOT NULL,
  `id_topico` int NOT NULL,
  PRIMARY KEY (`id_instrutor`,`id_topico`),
  KEY `id_topico` (`id_topico`),
  CONSTRAINT `Instrutor_Topico_ibfk_1` FOREIGN KEY (`id_instrutor`) REFERENCES `Instrutor` (`id_instrutor`),
  CONSTRAINT `Instrutor_Topico_ibfk_2` FOREIGN KEY (`id_topico`) REFERENCES `Topico` (`id_topico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Instrutor_Topico`
--

LOCK TABLES `Instrutor_Topico` WRITE;
/*!40000 ALTER TABLE `Instrutor_Topico` DISABLE KEYS */;
INSERT INTO `Instrutor_Topico` VALUES (1,1),(2,2),(1,3),(1,4),(2,5);
/*!40000 ALTER TABLE `Instrutor_Topico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Log_Sistema`
--

DROP TABLE IF EXISTS `Log_Sistema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Log_Sistema` (
  `id_log` int NOT NULL AUTO_INCREMENT,
  `tabela_afetada` varchar(50) NOT NULL,
  `acao` varchar(20) NOT NULL,
  `detalhes` text,
  `data_acao` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_log`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Log_Sistema`
--

LOCK TABLES `Log_Sistema` WRITE;
/*!40000 ALTER TABLE `Log_Sistema` DISABLE KEYS */;
INSERT INTO `Log_Sistema` VALUES (1,'Aluno','UPDATE','Matricula: AL005 | Nome Antigo: Mariana -> Novo: Mariana','2026-05-30 20:49:06'),(2,'Aluno','UPDATE','Matricula: AL004 | Nome Antigo: Gustav -> Novo: Gustav','2026-05-30 20:49:11'),(3,'Aluno','UPDATE','Matricula: AL003 | Nome Antigo: Reivedd -> Novo: Reivedd','2026-05-30 20:49:14'),(4,'Aluno','UPDATE','Matricula: AL002 | Nome Antigo: Luan -> Novo: Luan','2026-05-30 20:49:16'),(5,'Aluno','UPDATE','Matricula: AL001 | Nome Antigo: Arthur -> Novo: Arthur','2026-05-30 20:49:18');
/*!40000 ALTER TABLE `Log_Sistema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Matricula_Curso`
--

DROP TABLE IF EXISTS `Matricula_Curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Matricula_Curso` (
  `id_aluno` int NOT NULL,
  `id_curso` int NOT NULL,
  PRIMARY KEY (`id_aluno`,`id_curso`),
  KEY `id_curso` (`id_curso`),
  CONSTRAINT `Matricula_Curso_ibfk_1` FOREIGN KEY (`id_aluno`) REFERENCES `Aluno` (`id_aluno`),
  CONSTRAINT `Matricula_Curso_ibfk_2` FOREIGN KEY (`id_curso`) REFERENCES `Curso` (`id_curso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Matricula_Curso`
--

LOCK TABLES `Matricula_Curso` WRITE;
/*!40000 ALTER TABLE `Matricula_Curso` DISABLE KEYS */;
INSERT INTO `Matricula_Curso` VALUES (1,1),(2,1),(3,1),(4,1),(5,1);
/*!40000 ALTER TABLE `Matricula_Curso` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 */ /*!50003 TRIGGER `trg_Validar_Limite_Cursos` BEFORE INSERT ON `Matricula_Curso` FOR EACH ROW BEGIN
    DECLARE v_cpf VARCHAR(14);
    DECLARE v_qtd_cursos INT;
    
    SELECT cpf INTO v_cpf FROM Aluno WHERE id_aluno = NEW.id_aluno;
    
    SELECT COUNT(*) INTO v_qtd_cursos
    FROM Matricula_Curso mc
    JOIN Aluno a ON mc.id_aluno = a.id_aluno
    WHERE a.cpf = v_cpf;
    
    IF v_qtd_cursos >= 2 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Erro: Aluno ja atingiu o limite maximo de 2 cursos simultaneos.';
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 */ /*!50003 TRIGGER `trg_Log_Matricula_Curso_Update` AFTER UPDATE ON `Matricula_Curso` FOR EACH ROW BEGIN
    INSERT INTO Log_Sistema (tabela_afetada, acao, detalhes)
    VALUES ('Matricula_Curso', 'UPDATE', CONCAT('Aluno ID: ', OLD.id_aluno, ' | Curso Antigo: ', OLD.id_curso, ' -> Novo: ', NEW.id_curso));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `Matricula_Step`
--

DROP TABLE IF EXISTS `Matricula_Step`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Matricula_Step` (
  `id_aluno` int NOT NULL,
  `id_step` int NOT NULL,
  PRIMARY KEY (`id_aluno`,`id_step`),
  KEY `id_step` (`id_step`),
  CONSTRAINT `Matricula_Step_ibfk_1` FOREIGN KEY (`id_aluno`) REFERENCES `Aluno` (`id_aluno`),
  CONSTRAINT `Matricula_Step_ibfk_2` FOREIGN KEY (`id_step`) REFERENCES `Step` (`id_step`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Matricula_Step`
--

LOCK TABLES `Matricula_Step` WRITE;
/*!40000 ALTER TABLE `Matricula_Step` DISABLE KEYS */;
INSERT INTO `Matricula_Step` VALUES (1,1),(4,1),(1,2),(4,2),(2,3),(4,3),(2,4),(5,4),(3,5),(5,5);
/*!40000 ALTER TABLE `Matricula_Step` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Matricula_Topico_Avulso`
--

DROP TABLE IF EXISTS `Matricula_Topico_Avulso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Matricula_Topico_Avulso` (
  `id_aluno` int NOT NULL,
  `id_topico` int NOT NULL,
  PRIMARY KEY (`id_aluno`,`id_topico`),
  KEY `id_topico` (`id_topico`),
  CONSTRAINT `Matricula_Topico_Avulso_ibfk_1` FOREIGN KEY (`id_aluno`) REFERENCES `Aluno` (`id_aluno`),
  CONSTRAINT `Matricula_Topico_Avulso_ibfk_2` FOREIGN KEY (`id_topico`) REFERENCES `Topico` (`id_topico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Matricula_Topico_Avulso`
--

LOCK TABLES `Matricula_Topico_Avulso` WRITE;
/*!40000 ALTER TABLE `Matricula_Topico_Avulso` DISABLE KEYS */;
INSERT INTO `Matricula_Topico_Avulso` VALUES (3,2),(1,5);
/*!40000 ALTER TABLE `Matricula_Topico_Avulso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Step`
--

DROP TABLE IF EXISTS `Step`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Step` (
  `id_step` int NOT NULL AUTO_INCREMENT,
  `id_curso` int DEFAULT NULL,
  `numero_semana` int NOT NULL,
  PRIMARY KEY (`id_step`),
  KEY `id_curso` (`id_curso`),
  CONSTRAINT `Step_ibfk_1` FOREIGN KEY (`id_curso`) REFERENCES `Curso` (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Step`
--

LOCK TABLES `Step` WRITE;
/*!40000 ALTER TABLE `Step` DISABLE KEYS */;
INSERT INTO `Step` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5);
/*!40000 ALTER TABLE `Step` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Step_Topico`
--

DROP TABLE IF EXISTS `Step_Topico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Step_Topico` (
  `id_step` int NOT NULL,
  `id_topico` int NOT NULL,
  PRIMARY KEY (`id_step`,`id_topico`),
  KEY `id_topico` (`id_topico`),
  CONSTRAINT `Step_Topico_ibfk_1` FOREIGN KEY (`id_step`) REFERENCES `Step` (`id_step`),
  CONSTRAINT `Step_Topico_ibfk_2` FOREIGN KEY (`id_topico`) REFERENCES `Topico` (`id_topico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Step_Topico`
--

LOCK TABLES `Step_Topico` WRITE;
/*!40000 ALTER TABLE `Step_Topico` DISABLE KEYS */;
INSERT INTO `Step_Topico` VALUES (1,1),(2,2),(3,3),(4,4),(5,5);
/*!40000 ALTER TABLE `Step_Topico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Topico`
--

DROP TABLE IF EXISTS `Topico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Topico` (
  `id_topico` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` text,
  PRIMARY KEY (`id_topico`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Topico`
--

LOCK TABLES `Topico` WRITE;
/*!40000 ALTER TABLE `Topico` DISABLE KEYS */;
INSERT INTO `Topico` VALUES (1,'Lógica de Programação e Algoritmos','Fundamentos iniciais'),(2,'Modelagem de Dados e MySQL','Criação de schemas e queries'),(3,'Programação Orientada a Objetos com C#','Classes, herança e polimorfismo'),(4,'Ecossistema Java e APIs','Spring Boot e microsserviços'),(5,'Engenharia de Requisitos e UML','Documentação e levantamento');
/*!40000 ALTER TABLE `Topico` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 */ /*!50003 TRIGGER `trg_Log_Topico_Update` AFTER UPDATE ON `Topico` FOR EACH ROW BEGIN
    INSERT INTO Log_Sistema (tabela_afetada, acao, detalhes)
    VALUES ('Topico', 'UPDATE', CONCAT('ID: ', OLD.id_topico, ' | Nome Antigo: ', OLD.nome, ' -> Novo: ', NEW.nome));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary view structure for view `vw_Alunos_Cursos_Topicos`
--

DROP TABLE IF EXISTS `vw_Alunos_Cursos_Topicos`;
/*!50001 DROP VIEW IF EXISTS `vw_Alunos_Cursos_Topicos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_Alunos_Cursos_Topicos` AS SELECT 
 1 AS `Aluno`,
 1 AS `Curso`,
 1 AS `Step_Semana`,
 1 AS `Topico`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_Instrutores_Disciplinas`
--

DROP TABLE IF EXISTS `vw_Instrutores_Disciplinas`;
/*!50001 DROP VIEW IF EXISTS `vw_Instrutores_Disciplinas`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_Instrutores_Disciplinas` AS SELECT 
 1 AS `Instrutor`,
 1 AS `titulacao`,
 1 AS `Topico`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_Matriz_Curricular_Curso`
--

DROP TABLE IF EXISTS `vw_Matriz_Curricular_Curso`;
/*!50001 DROP VIEW IF EXISTS `vw_Matriz_Curricular_Curso`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_Matriz_Curricular_Curso` AS SELECT 
 1 AS `Curso`,
 1 AS `Semana`,
 1 AS `Topico`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_Total_Alunos_Por_Curso`
--

DROP TABLE IF EXISTS `vw_Total_Alunos_Por_Curso`;
/*!50001 DROP VIEW IF EXISTS `vw_Total_Alunos_Por_Curso`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_Total_Alunos_Por_Curso` AS SELECT 
 1 AS `Curso`,
 1 AS `Total_Alunos`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'EmpresaCursosEngenharia'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_Atualizar_Info_Aluno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `sp_Atualizar_Info_Aluno`(
    IN p_matricula VARCHAR(20),
    IN p_nome VARCHAR(100),
    IN p_data_nascimento DATE,
    IN p_email VARCHAR(100),
    IN p_cpf VARCHAR(14)
)
BEGIN
    UPDATE Aluno
    SET nome = p_nome,
        data_nascimento = p_data_nascimento,
        email = p_email,
        cpf = p_cpf
    WHERE matricula = p_matricula;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Listar_Alunos_Por_Topico` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `sp_Listar_Alunos_Por_Topico`(
    IN p_id_topico INT
)
BEGIN
    SELECT DISTINCT 
        a.matricula AS Matricula,
        a.nome AS Nome_Aluno,
        a.email AS Email
    FROM Aluno a
    LEFT JOIN Matricula_Topico_Avulso mta ON a.id_aluno = mta.id_aluno
    LEFT JOIN Matricula_Step ms ON a.id_aluno = ms.id_aluno
    LEFT JOIN Step_Topico st ON ms.id_step = st.id_step
    WHERE mta.id_topico = p_id_topico OR st.id_topico = p_id_topico;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Listar_Topicos_Por_Step` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `sp_Listar_Topicos_Por_Step`(
    IN p_id_curso INT
)
BEGIN
    SELECT 
        s.numero_semana AS Semana,
        t.id_topico AS Codigo_Topico,
        t.nome AS Nome_Topico,
        t.descricao AS Descricao_Topico
    FROM Step S
    JOIN Step_Topico st ON s.id_step = st.id_step
    JOIN Topico t ON st.id_topico = t.id_topico
    WHERE s.id_curso = p_id_curso
    ORDER BY s.numero_semana, t.nome;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_Matricular_Aluno_Topicos_Step` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE  PROCEDURE `sp_Matricular_Aluno_Topicos_Step`(
    IN p_matricula VARCHAR(20),
    IN p_id_step INT
)
BEGIN
    DECLARE v_id_aluno INT;
    
    SELECT id_aluno INTO v_id_aluno FROM Aluno WHERE matricula = p_matricula;
    
    IF v_id_aluno IS NOT NULL THEN
        INSERT IGNORE INTO Matricula_Step (id_aluno, id_step)
        VALUES (v_id_aluno, p_id_step);
        
        INSERT IGNORE INTO Matricula_Topico_Avulso (id_aluno, id_topico)
        SELECT v_id_aluno, id_topico
        FROM Step_Topico
        WHERE id_step = p_id_step;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `vw_Alunos_Cursos_Topicos`
--

/*!50001 DROP VIEW IF EXISTS `vw_Alunos_Cursos_Topicos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013  SQL SECURITY DEFINER */
/*!50001 VIEW `vw_Alunos_Cursos_Topicos` AS select `A`.`nome` AS `Aluno`,`C`.`nome` AS `Curso`,`S`.`numero_semana` AS `Step_Semana`,`T`.`nome` AS `Topico` from ((((((`Aluno` `A` join `Matricula_Curso` `MC` on((`A`.`id_aluno` = `MC`.`id_aluno`))) join `Curso` `C` on((`MC`.`id_curso` = `C`.`id_curso`))) join `Step` `S` on((`C`.`id_curso` = `S`.`id_curso`))) join `Matricula_Step` `MS` on(((`A`.`id_aluno` = `MS`.`id_aluno`) and (`S`.`id_step` = `MS`.`id_step`)))) join `Step_Topico` `ST` on((`S`.`id_step` = `ST`.`id_step`))) join `Topico` `T` on((`ST`.`id_topico` = `T`.`id_topico`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_Instrutores_Disciplinas`
--

/*!50001 DROP VIEW IF EXISTS `vw_Instrutores_Disciplinas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013  SQL SECURITY DEFINER */
/*!50001 VIEW `vw_Instrutores_Disciplinas` AS select `I`.`nome` AS `Instrutor`,`I`.`titulacao` AS `titulacao`,`T`.`nome` AS `Topico` from ((`Instrutor` `I` join `Instrutor_Topico` `IT` on((`I`.`id_instrutor` = `IT`.`id_instrutor`))) join `Topico` `T` on((`IT`.`id_topico` = `T`.`id_topico`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_Matriz_Curricular_Curso`
--

/*!50001 DROP VIEW IF EXISTS `vw_Matriz_Curricular_Curso`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013  SQL SECURITY DEFINER */
/*!50001 VIEW `vw_Matriz_Curricular_Curso` AS select `C`.`nome` AS `Curso`,`S`.`numero_semana` AS `Semana`,`T`.`nome` AS `Topico` from (((`Curso` `C` join `Step` `S` on((`C`.`id_curso` = `S`.`id_curso`))) join `Step_Topico` `ST` on((`S`.`id_step` = `ST`.`id_step`))) join `Topico` `T` on((`ST`.`id_topico` = `T`.`id_topico`))) order by `C`.`nome`,`S`.`numero_semana` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_Total_Alunos_Por_Curso`
--

/*!50001 DROP VIEW IF EXISTS `vw_Total_Alunos_Por_Curso`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013  SQL SECURITY DEFINER */
/*!50001 VIEW `vw_Total_Alunos_Por_Curso` AS select `C`.`nome` AS `Curso`,count(`MC`.`id_aluno`) AS `Total_Alunos` from (`Curso` `C` left join `Matricula_Curso` `MC` on((`C`.`id_curso` = `MC`.`id_curso`))) group by `C`.`id_curso`,`C`.`nome` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-30 17:54:02
