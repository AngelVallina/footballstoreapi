use heroku_39ff215dc57dc12
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: pdaw2
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `detallespedidos`
--

DROP TABLE IF EXISTS `detallespedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `detallespedidos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `talla` varchar(255) DEFAULT NULL,
  `pedido_id` int DEFAULT NULL,
  `producto_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6763sx22lpkx1gh55m3pjg2gp` (`pedido_id`),
  KEY `FKapo5g4y166uw7l5kgmm91iii8` (`producto_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallespedidos`
--

LOCK TABLES `detallespedidos` WRITE;
/*!40000 ALTER TABLE `detallespedidos` DISABLE KEYS */;
INSERT INTO `detallespedidos` VALUES (1,1,'L',1,12),(2,1,'39',1,20);
/*!40000 ALTER TABLE `detallespedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direcciones`
--

DROP TABLE IF EXISTS `direcciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `direcciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cp` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `notas` varchar(255) DEFAULT NULL,
  `provincia` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direcciones`
--

LOCK TABLES `direcciones` WRITE;
/*!40000 ALTER TABLE `direcciones` DISABLE KEYS */;
INSERT INTO `direcciones` VALUES (1,'33314','Camino de la corolla 28 Quintueles','Angel Vallina Carbajal','Notas','Asturias','637812199');
/*!40000 ALTER TABLE `direcciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagenesproductos`
--

DROP TABLE IF EXISTS `imagenesproductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `imagenesproductos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `producto_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKogtq4td5ao1d580nug9i26vyg` (`producto_id`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagenesproductos`
--

LOCK TABLES `imagenesproductos` WRITE;
/*!40000 ALTER TABLE `imagenesproductos` DISABLE KEYS */;
INSERT INTO `imagenesproductos` VALUES (2,'https://www.futbolemotion.com/imagesarticulos/168287/750/bota-adidas-x-speedflow-.3-mg-nino-azul-cielo-0.webp',4),(4,'https://img01.ztat.net/article/spp-media-p1/ab0ef0b7a18641d78704b9105a1956cc/4e1b1be1236b4615acb58a14a9193673.jpg?imwidth=1800&filter=packshot',7),(5,'https://img01.ztat.net/article/spp-media-p1/7900c780f8864c82a33f635c3baaa105/8f97fd46f45b4ec8a2f9ff5a45eeb4b8.jpg?imwidth=1800&filter=packshot',6),(6,'https://www.futbolemotion.com/imagesarticulos/171339/750/camiseta-puma-ess-logo-rosa-0.jpg',9),(7,'https://img01.ztat.net/article/spp-media-p1/630b708083d04d169913f12cd5bdb845/63cafff46ecd42cda43fd8bd04c6ec9a.jpg?',8),(8,'https://img01.ztat.net/article/spp-media-p1/9c1fea8535e5448aa48fe0e36f2225b1/e016685c22704741a89eaffde67e1aa6.jpg?',10),(9,'https://www.futbolemotion.com/imagesarticulos/165978/330/malla-nike-club-legging-mujer-matte-olive-0.jpg',11),(10,'https://www.futbolemotion.com/imagesarticulos/170622/330/sudadera-nike-dri-fit-pacer-top-hz-black-0.jpg',12),(11,'https://www.futbolemotion.com/imagesarticulos/170639/330/camiseta-nike-miler-top-black-0.jpg',13),(12,'https://www.futbolemotion.com/imagesarticulos/153837/330/calcetines-nike-sportswear-essential-stripe-crew-3-pares-white-game-royal-0.jpg',14),(13,'https://www.futbolemotion.com/imagesarticulos/170790/330/pantalon-corto-adidas-condivo-22-matchday-black-white-0.jpg',15),(14,'https://www.futbolemotion.com/imagesarticulos/170796/330/pantalon-corto-adidas-condivo-22-matchday-nino-power-red-white-0.jpg',16),(15,'https://www.futbolemotion.com/imagesarticulos/169284/330/guante-nike-mercurial-vapor-grip3-light-marine-white-blackened-blue-0.jpg',17),(16,'https://www.futbolemotion.com/imagesarticulos/167790/330/guante-nike-vapor-grip3-siren-red-team-red-dynamic-blue-0.jpg',18),(17,'https://www.futbolemotion.com/imagesarticulos/168100/330/guante-nike-vapor-grip-3-promo-20-cm-negro-0.jpg',19),(18,'https://www.futbolemotion.com/imagesarticulos/168236/330/zapatilla-adidas-x-speedflow-messi-.3-in-nino-gold-black-yellow-0.jpg',20),(19,'https://www.futbolemotion.com/imagesarticulos/168343/330/zapatilla-adidas-predator-edge-.3-in-nino-blanco-0.jpg',21),(20,'https://www.futbolemotion.com/imagesarticulos/157350/330/zapatilla-nike-jr-vapor-14-academy-ic-amarillo-0.jpg',22),(21,'https://www.futbolemotion.com/imagesarticulos/168507/330/espinillera-adidas-messi-match-nino-solar-gold-bright-yellow-black-0.jpg',23),(22,'https://www.futbolemotion.com/imagesarticulos/168529/330/balon-adidas-messi-club-solar-gold-bright-yellow-black-0.jpg',24),(23,'https://www.futbolemotion.com/imagesarticulos/165640/330/espinillera-puma-ultra-twist-sleeve-naranja-0.jpg',25),(24,'https://www.futbolemotion.com/imagesarticulos/167540/330/mochila-puma-individualrise-backpack-neon-citrus-puma-black-0.jpg',26),(25,'https://www.futbolemotion.com/imagesarticulos/167891/330/bota-nike-phantom-gt2-academy-df-fgmg-naranja-0.jpg',26),(26,'https://img01.ztat.net/article/spp-media-p1/1003f451141e3c5f8448f07399495c82/d46eab85f41c4fb8896d9a90abe4e0c5.jpg?',64),(27,'https://img01.ztat.net/article/spp-media-p1/aecc1a0a82e146098365746006dc7d1e/e1c8a675f8a745b3a04019c65fa03938.jpg?',51),(28,'https://img01.ztat.net/article/spp-media-p1/132b12a89edb3337a6362dbbea257323/18684b921ba041fdb5c289fccd7a71de.jpg?',2);
/*!40000 ALTER TABLE `imagenesproductos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opiniones`
--

DROP TABLE IF EXISTS `opiniones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `opiniones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comentario` varchar(255) DEFAULT NULL,
  `valoracion` float NOT NULL,
  `producto_id` int DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa1p36le3uu8nm42amuo7qs5bq` (`producto_id`),
  KEY `FK1bwdrdpu4y0c6rk2smkyo4175` (`usuario_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opiniones`
--

LOCK TABLES `opiniones` WRITE;
/*!40000 ALTER TABLE `opiniones` DISABLE KEYS */;
INSERT INTO `opiniones` VALUES (1,'Muy buena camiseta',4,10,2),(2,'Alta calidad de zapatillas',5,21,2);
/*!40000 ALTER TABLE `opiniones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `pedidos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `total` double NOT NULL,
  `direccion_id` int DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4hgxx8rrb926a17rbmtoh23qa` (`direccion_id`),
  KEY `FKpfoceigjvyas04u9bhcllnjol` (`usuario_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,'2022-06-12',117.97999999999999,1,2);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL,
  `tallas` varchar(255) DEFAULT NULL,
  `valoracion` float NOT NULL,
  `tipo_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt7vja3fxtw59hrfvwt9a5cta9` (`tipo_id`)
) ENGINE=MyISAM AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (6,'La camiseta de manga corta Converse Star Chrevron presenta un diseño minimalista con la fuerza del logotipo en el pecho.','A','Converse Star Chevron',30.49,'XS,S,M,L,XL,XXL',4,1),(7,'','A','Fila Tenis',19.99,'XS,S,M,L,XL,XXL',0,1),(8,'','A','Puma Ferrari\n',29.99,'XS,S,M,L,XL,XXL',0,1),(9,'','A','Camiseta Puma\n',11.99,'XS,S,M,L,XL,XXL',0,1),(10,'Camisetas Hombre Disney','A','Camiseta Spiderman\n',12.99,'XS,S,M,L,XL,XXL',4,1),(11,'Atrévete con la protección de talle alto de los leggings Nike Sportswear Club. Con un llamativo diseño Swoosh y un patrón gráfico de logotipos en la cintura, están diseñados para mantener la comodidad durante todo el día.','A','MALLA NIKE CLUB LEGGING MUJER\n',31.99,'XS,S,M,L,XL,XXL',0,2),(12,'SUAVIDAD Y TRANSPIRABILIDAD, POR DENTRO Y POR FUERA.\nProtégete con la camiseta Nike Pacer. Esta camiseta de manga larga con cuello alto con cremallera de 1/2 te envuelve con calidez ligera para correr en días fríos.','A','SUDADERA NIKE DRI-FIT PACER TOP HZ\n',37.99,'XS,S,M,L,XL,XXL',0,2),(14,'','A','CALCETINES NIKE NSW EVERYDAY ESSENTIAL ANKLE (3 PARES)\n',9.99,'XS,S,M,L,XL,XXL',0,2),(15,'','A','PANTALÓN CORTO ADIDAS CONDIVO 22 MATCHDAY\n',12.99,'XS,S,M,L,XL,XXL',0,2),(16,'','A','PANTALÓN CORTO ADIDAS CONDIVO 22 MATCHDAY NIÑO\n',22.99,'XS,S,M,L,XL,XXL',0,2),(20,'Zapatilla de fútbol adidas X Speedflow Messi.3 IN para adultos. Zapatillas de microfibra sintética para utilizar en campos de moqueta o cemento. Zapatillas de gama baja en color Gold-Black-Yellow','A','ZAPATILLA ADIDAS X SPEEDFLOW MESSI .3 IN\n',79.99,'36,37,38,39,40,41,42,43,44,45',0,4),(21,'Zapatilla de fútbol sala adidas Predator Predator Edge.3 IN para adultos. Zapatillas de hilo con calcetín para utilizar en pistas indoor y outdoor. Zapatillas de gama baja en color Core Black-White-Vivid Red, para jugadores de control.','A','ZAPATILLA ADIDAS PREDATOR EDGE .3 IN\n',75.99,'36,37,38,39,40,41,42,43,44,45',5,4),(22,'Zapatilla de fútbol sala Nike Mercurial Vapor 14 Academy IC para niños. Zapatilla de corte sintético para utilizar en pistas indoor. Zapatilla de gama baja en color Black-Metallic Gold-Metallic Silver para jugadores de velocidad.\n','A','ZAPATILLA NIKE MERCURIAL VAPOR 14 ACADEMY IC NIÑO\n',55.99,'28,29,30,31,32,33,34,35',0,4),(24,'','A','BALÓN ADIDAS MESSI CLUB\n',25.99,'Talla Única',5,5),(25,'descricpion','A','ESPINILLERA PUMA STANDALONE\n',15.98,'S,M,L,XL',0,5),(26,'','A','MOCHILA PUMA INDIVIDUALRISE BACKPACK\n',25,'Talla Única',0,5),(64,'Camisetas Hombre Disney','A','Camiseta Batman\n',12.99,'XS,S,M,L,XL,XXL',0,1);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rols`
--

DROP TABLE IF EXISTS `rols`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `rols` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rols`
--

LOCK TABLES `rols` WRITE;
/*!40000 ALTER TABLE `rols` DISABLE KEYS */;
INSERT INTO `rols` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `rols` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos`
--

DROP TABLE IF EXISTS `tipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `tipos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos`
--

LOCK TABLES `tipos` WRITE;
/*!40000 ALTER TABLE `tipos` DISABLE KEYS */;
INSERT INTO `tipos` VALUES (1,'Ropa de fútból'),(2,'Entrenamiento'),(3,'Portero'),(4,'Fútból sala'),(5,'Otros');
/*!40000 ALTER TABLE `tipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKrnh6am5kxuj163kwqcdkmrlmi` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1),(2,1),(3,1),(3,2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Vallina','2022-06-12 10:43:55','angel@gmail.com',NULL,'Angel','$2a$10$A6eePU/6g5GZmMzY3MaLE.jUCchd3RooFYuNu/cxPmKL5ETCE52Ly','2022-06-12 10:43:55','angel@gmail.com'),(2,'Vallina','2022-06-12 10:47:27','angel1@gmail.com',NULL,'Angel','$2a$10$S6bRCZif8IQHumWS7pJhauniUjFSbHCXffHGaJs6Y584XbUuTQgaW','2022-06-12 10:47:27','angel1@gmail.com'),(3,'Admin Admin','2022-06-12 10:57:18','admin@admin.es',NULL,'Administrador','$2a$10$o8J0TFq4LVTRgSCrQ00P0O5CkTptRh.PTB0VvLR.JCUkaSUKVWy1G','2022-06-12 10:57:18','admin@admin.es');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-12 13:38:39
