-- MySQL dump 10.13  Distrib 8.0.46, for Linux (x86_64)
--
-- Host: metro.proxy.rlwy.net    Database: armazem_db
-- ------------------------------------------------------
-- Server version	9.4.0

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cpf` varchar(14) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Arthur Beraldo','13789459640','35998000575','arthur@gmail.com'),(2,'Jorge Felipe','12345678910','3598000512','jorge@gmail.com'),(3,'Mathes Guedes','04080965555','35998000547','matheus@gmail.com'),(4,'Julia Maria','13748596540','35998065968','julia@gmail.com'),(5,'Maria Antônio','12345698540','35998000562','maria@gmail.com');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estoque_movimento`
--

DROP TABLE IF EXISTS `estoque_movimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estoque_movimento` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `produto_id` bigint NOT NULL,
  `tipo` enum('ENTRADA','SAIDA') COLLATE utf8mb4_unicode_ci NOT NULL,
  `quantidade` int NOT NULL,
  `data_validade` date DEFAULT NULL COMMENT 'Validade do lote na entrada',
  `lote` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `motivo` varchar(120) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Ex: Compra, Devolução, Ajuste, Venda',
  `observacao` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `criado_em` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_mov_produto` (`produto_id`),
  CONSTRAINT `fk_mov_produto` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`) ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estoque_movimento`
--

LOCK TABLES `estoque_movimento` WRITE;
/*!40000 ALTER TABLE `estoque_movimento` DISABLE KEYS */;
INSERT INTO `estoque_movimento` VALUES (1,1,'ENTRADA',50,'2026-06-01','L001','Compra',NULL,'2026-06-03 18:07:21'),(2,2,'ENTRADA',40,'2026-06-01','L002','Compra',NULL,'2026-06-03 18:07:21'),(3,3,'ENTRADA',60,'2027-01-01','L003','Compra',NULL,'2026-06-03 18:07:21'),(4,4,'ENTRADA',30,'2026-12-01','L004','Compra',NULL,'2026-06-03 18:07:21'),(5,8,'ENTRADA',36,'2026-09-01','L005','Compra',NULL,'2026-06-03 18:07:21'),(6,1,'SAIDA',10,NULL,NULL,'Venda',NULL,'2026-06-03 17:08:35'),(7,5,'SAIDA',35,NULL,NULL,'Venda',NULL,'2026-06-03 17:09:20'),(8,8,'SAIDA',36,NULL,NULL,'Venda',NULL,'2026-06-03 17:10:03'),(9,5,'ENTRADA',50,NULL,NULL,NULL,'','2026-06-03 17:18:32'),(10,1,'SAIDA',1,NULL,NULL,'Venda',NULL,'2026-06-03 17:19:04'),(11,10,'SAIDA',50,NULL,NULL,'Venda',NULL,'2026-06-03 17:20:04'),(12,11,'ENTRADA',50,NULL,NULL,NULL,'','2026-06-03 17:26:25'),(13,1,'SAIDA',39,NULL,NULL,'Venda',NULL,'2026-06-03 20:39:29'),(14,13,'ENTRADA',100,NULL,NULL,NULL,'','2026-06-08 16:28:51'),(15,13,'SAIDA',10,NULL,NULL,NULL,'','2026-06-08 16:29:54'),(16,13,'SAIDA',10,NULL,NULL,NULL,'','2026-06-08 16:33:46'),(17,13,'SAIDA',10,NULL,NULL,NULL,'','2026-06-08 16:35:32'),(18,2,'SAIDA',10,NULL,NULL,'Venda',NULL,'2026-06-08 16:48:42'),(19,2,'ENTRADA',50,'2027-02-10','L002',NULL,'','2026-06-08 17:00:20'),(20,1,'ENTRADA',50,'2026-06-10','L002',NULL,'','2026-06-08 17:00:44'),(21,12,'ENTRADA',100,'2027-02-09','LR20',NULL,'','2026-06-08 17:12:09'),(22,12,'SAIDA',20,NULL,NULL,'Venda',NULL,'2026-06-08 17:25:00'),(23,12,'SAIDA',42,NULL,NULL,'Venda',NULL,'2026-06-08 17:25:33'),(24,12,'ENTRADA',10,'2027-02-08','LR20',NULL,'','2026-06-08 17:26:10'),(25,8,'ENTRADA',21,'2026-06-26','LT10',NULL,'','2026-06-08 17:27:09'),(26,1,'SAIDA',10,NULL,NULL,'Venda',NULL,'2026-06-18 00:05:57'),(27,4,'SAIDA',5,NULL,NULL,'Venda',NULL,'2026-06-18 00:17:25'),(28,7,'SAIDA',8,NULL,NULL,'Venda',NULL,'2026-06-18 00:26:02'),(29,1,'SAIDA',5,NULL,NULL,'Venda',NULL,'2026-06-18 00:26:44'),(30,4,'SAIDA',5,NULL,NULL,'Venda',NULL,'2026-06-18 00:26:44'),(31,6,'SAIDA',4,NULL,NULL,'Venda',NULL,'2026-06-18 00:26:45'),(32,1,'SAIDA',5,NULL,NULL,'Venda',NULL,'2026-06-18 00:29:47'),(33,8,'SAIDA',1,NULL,NULL,'Venda',NULL,'2026-06-18 00:29:47'),(34,12,'SAIDA',8,NULL,NULL,'Venda',NULL,'2026-06-18 00:29:48'),(35,1,'SAIDA',1,NULL,NULL,'Venda',NULL,'2026-06-18 00:30:11'),(36,1,'ENTRADA',1,NULL,NULL,'Estorno de Venda','Cancelamento da Venda #15','2026-06-18 00:38:35'),(37,1,'SAIDA',5,NULL,NULL,'Venda',NULL,'2026-06-18 00:39:14'),(38,1,'ENTRADA',5,NULL,NULL,'Estorno de Venda','Cancelamento da Venda #16','2026-06-18 00:39:35'),(39,4,'ENTRADA',50,'2028-02-08','OS9001',NULL,'','2026-06-18 01:10:38'),(40,1,'SAIDA',5,NULL,NULL,'Venda',NULL,'2026-06-18 16:11:00'),(41,4,'SAIDA',20,NULL,NULL,'Venda',NULL,'2026-06-18 16:12:50'),(42,6,'ENTRADA',70,'2028-06-13','RC2L2',NULL,'','2026-06-20 21:56:48'),(43,4,'SAIDA',2,NULL,NULL,'Venda',NULL,'2026-06-20 22:27:50'),(44,13,'SAIDA',20,NULL,NULL,'Venda',NULL,'2026-06-23 22:14:14'),(45,14,'ENTRADA',150,'2028-01-03','BBN01',NULL,'','2026-06-23 22:15:28'),(46,4,'ENTRADA',98,'2026-06-18','OLS02',NULL,'','2026-06-23 23:12:42'),(47,12,'ENTRADA',10,'2026-06-23','SCK01',NULL,'','2026-06-23 23:22:46'),(48,4,'ENTRADA',10,'2026-06-24','OLJ02',NULL,'','2026-06-23 23:23:27'),(49,1,'SAIDA',5,NULL,'',NULL,'','2026-06-25 19:31:20');
/*!40000 ALTER TABLE `estoque_movimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornecedor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cnpj` varchar(18) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(120) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `endereco` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  `criado_em` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cnpj` (`cnpj`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (1,'Distribuidora Central Ltda','12.345.678/0001-90','(35) 99999-0001','contato@distcentral.com','',1,'2026-06-03 18:07:05'),(2,'Alimento do Vale S/A','98.765.432/0001-10','(35) 98888-0002','vendas@alimentosvale.com','',1,'2026-06-03 18:07:05'),(3,'Bebidas Minas Gerais','11.222.333/0001-44','(35) 97777-0003','pedidos@bebidasmg.com',NULL,1,'2026-06-03 18:07:05'),(4,'Teste 2','02.629.336/0001-43','(35) 99800-0000','teste@gmail.com','Rua Douglas Conçalves, 69',1,'2026-06-03 16:16:32');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descricao` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `codigo_barras` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `categoria` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `unidade_medida` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'UN',
  `preco_custo` decimal(10,2) NOT NULL DEFAULT '0.00',
  `preco_venda` decimal(10,2) NOT NULL DEFAULT '0.00',
  `estoque_atual` int NOT NULL DEFAULT '0',
  `estoque_minimo` int NOT NULL DEFAULT '5',
  `validade_dias` int DEFAULT NULL COMMENT 'Prazo padrão de validade em dias',
  `fornecedor_id` bigint DEFAULT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  `criado_em` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `atualizado_em` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_barras` (`codigo_barras`),
  KEY `fk_produto_fornecedor` (`fornecedor_id`),
  CONSTRAINT `fk_produto_fornecedor` FOREIGN KEY (`fornecedor_id`) REFERENCES `fornecedor` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Arroz Tipo 1 5kg','Arroz branco tipo 1',NULL,'Grãos','PCT',12.50,18.70,20,10,365,1,1,'2026-06-03 18:07:14','2026-06-25 19:31:20'),(2,'Feijão Carioca 1kg','Feijão carioca selecionado',NULL,'Grãos','PCT',5.80,9.50,80,10,365,1,1,'2026-06-03 18:07:14','2026-06-08 17:00:20'),(3,'Açúcar Refinado 1kg','Açúcar refinado especial',NULL,'Açúcar','PCT',3.20,5.49,60,15,730,1,1,'2026-06-03 18:07:14','2026-06-03 18:07:14'),(4,'Óleo de Soja 900ml','Óleo de soja refinado',NULL,'Óleos','UN',4.50,7.99,156,8,365,2,1,'2026-06-03 18:07:14','2026-06-23 23:23:27'),(5,'Macarrão Espaguete','Espaguete 500g',NULL,'Massas','PCT',2.10,3.89,50,10,365,2,1,'2026-06-03 18:07:14','2026-06-03 17:18:32'),(6,'Refrigerante Cola 2L','Refrigerante cola 2L',NULL,'Bebidas','UN',4.00,7.49,90,6,180,3,1,'2026-06-03 18:07:14','2026-06-20 21:56:48'),(7,'Água Mineral 1,5L','Água mineral sem gás',NULL,'Bebidas','UN',1.20,2.49,40,12,730,3,1,'2026-06-03 18:07:14','2026-06-18 00:26:02'),(8,'Leite Integral 1L','Leite integral longa vida',NULL,'Laticínios','CX',3.50,5.99,20,8,180,2,1,'2026-06-03 18:07:14','2026-06-18 00:29:47'),(10,'Detergente Ypê 500 ml',NULL,NULL,'Limpeza','UN',1.50,2.99,50,5,NULL,NULL,1,'2026-06-03 17:17:58','2026-06-03 17:20:04'),(11,'Sal 5Kg',NULL,NULL,'Sal','UN',2.80,4.50,100,5,NULL,1,1,'2026-06-03 17:25:32','2026-06-23 23:14:29'),(12,'Snickers 45g',NULL,NULL,'Chocolates','UN',1.50,5.99,50,5,NULL,1,1,'2026-06-08 16:25:14','2026-06-23 23:22:46'),(13,'Refrigerante Guaraná Antarctica',NULL,NULL,'Bebidas','UN',3.80,7.50,50,5,NULL,3,1,'2026-06-08 16:28:29','2026-06-23 22:14:14'),(14,'Bolacha Bono Nestlé',NULL,NULL,'Bolachas','UN',1.20,3.99,150,5,NULL,2,1,'2026-06-23 22:12:25','2026-06-23 22:15:28');
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `senha` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `perfil` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','admin123','ADMIN'),(2,'caixa','caixa123','OPERADOR_CAIXA');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venda` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `total` decimal(10,2) NOT NULL DEFAULT '0.00',
  `desconto` decimal(10,2) NOT NULL DEFAULT '0.00',
  `total_final` decimal(10,2) NOT NULL DEFAULT '0.00',
  `forma_pagamento` enum('DINHEIRO','CARTAO_DEBITO','CARTAO_CREDITO','PIX') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'DINHEIRO',
  `observacao` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `criado_em` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cliente_id` bigint DEFAULT NULL,
  `status` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT 'CONCLUIDA',
  PRIMARY KEY (`id`),
  KEY `fk_venda_cliente` (`cliente_id`),
  CONSTRAINT `fk_venda_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (1,189.00,0.00,189.00,'DINHEIRO',NULL,'2026-06-03 17:08:35',NULL,'CONCLUIDA'),(2,136.15,10.00,126.15,'PIX',NULL,'2026-06-03 17:09:20',NULL,'CONCLUIDA'),(3,215.64,5.00,210.64,'DINHEIRO',NULL,'2026-06-03 17:10:04',NULL,'CONCLUIDA'),(4,18.90,0.00,18.90,'DINHEIRO',NULL,'2026-06-03 17:19:04',NULL,'CONCLUIDA'),(5,149.50,0.00,149.50,'CARTAO_DEBITO',NULL,'2026-06-03 17:20:04',NULL,'CONCLUIDA'),(6,737.10,0.00,737.10,'DINHEIRO',NULL,'2026-06-03 20:39:29',NULL,'CONCLUIDA'),(7,95.00,10.00,85.00,'PIX',NULL,'2026-06-08 16:48:42',NULL,'CONCLUIDA'),(8,119.80,10.00,109.80,'PIX',NULL,'2026-06-08 17:25:00',NULL,'CONCLUIDA'),(9,251.58,0.00,251.58,'DINHEIRO',NULL,'2026-06-08 17:25:34',NULL,'CONCLUIDA'),(10,187.00,0.00,187.00,'DINHEIRO',NULL,'2026-06-18 00:05:57',NULL,'CONCLUIDA'),(11,39.95,0.00,39.95,'PIX',NULL,'2026-06-18 00:17:25',1,'CONCLUIDA'),(12,19.92,0.00,19.92,'CARTAO_CREDITO',NULL,'2026-06-18 00:26:02',1,'CONCLUIDA'),(13,163.41,10.00,153.41,'CARTAO_DEBITO',NULL,'2026-06-18 00:26:45',1,'CONCLUIDA'),(14,147.41,0.00,147.41,'DINHEIRO',NULL,'2026-06-18 00:29:48',1,'CONCLUIDA'),(15,18.70,8.70,10.00,'DINHEIRO',NULL,'2026-06-18 00:30:12',NULL,'CANCELADA'),(16,93.50,90.00,3.50,'DINHEIRO',NULL,'2026-06-18 00:39:14',1,'CANCELADA'),(17,93.50,3.50,90.00,'DINHEIRO',NULL,'2026-06-18 16:11:01',1,'CONCLUIDA'),(18,159.80,50.00,109.80,'DINHEIRO',NULL,'2026-06-18 16:12:51',2,'CONCLUIDA'),(19,15.98,5.00,10.98,'CARTAO_DEBITO',NULL,'2026-06-20 22:27:51',3,'CONCLUIDA'),(20,150.00,50.00,100.00,'DINHEIRO',NULL,'2026-06-23 22:14:14',4,'CONCLUIDA');
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda_item`
--

DROP TABLE IF EXISTS `venda_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venda_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `venda_id` bigint NOT NULL,
  `produto_id` bigint NOT NULL,
  `quantidade` int NOT NULL,
  `preco_unitario` decimal(10,2) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_item_venda` (`venda_id`),
  KEY `fk_item_produto` (`produto_id`),
  CONSTRAINT `fk_item_produto` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_item_venda` FOREIGN KEY (`venda_id`) REFERENCES `venda` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda_item`
--

LOCK TABLES `venda_item` WRITE;
/*!40000 ALTER TABLE `venda_item` DISABLE KEYS */;
INSERT INTO `venda_item` VALUES (1,1,1,10,18.90,189.00),(2,2,5,35,3.89,136.15),(3,3,8,36,5.99,215.64),(4,4,1,1,18.90,18.90),(5,5,10,50,2.99,149.50),(6,6,1,39,18.90,737.10),(7,7,2,10,9.50,95.00),(8,8,12,20,5.99,119.80),(9,9,12,42,5.99,251.58),(10,10,1,10,18.70,187.00),(11,11,4,5,7.99,39.95),(12,12,7,8,2.49,19.92),(13,13,1,5,18.70,93.50),(14,13,4,5,7.99,39.95),(15,13,6,4,7.49,29.96),(16,14,1,5,18.70,93.50),(17,14,8,1,5.99,5.99),(18,14,12,8,5.99,47.92),(19,15,1,1,18.70,18.70),(20,16,1,5,18.70,93.50),(21,17,1,5,18.70,93.50),(22,18,4,20,7.99,159.80),(23,19,4,2,7.99,15.98),(24,20,13,20,7.50,150.00);
/*!40000 ALTER TABLE `venda_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'armazem_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-29 17:29:57
