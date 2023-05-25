-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.11.2-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para desarrollo2
CREATE DATABASE IF NOT EXISTS `desarrollo2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `desarrollo2`;

-- Volcando estructura para tabla desarrollo2.movimientos
CREATE TABLE IF NOT EXISTS `movimientos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `producto` varchar(50) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla desarrollo2.movimientos: ~17 rows (aproximadamente)
INSERT INTO `movimientos` (`id`, `producto`, `cantidad`, `tipo`) VALUES
	(1, 'Mouse', 25, 'Ingreso'),
	(2, 'Teclado', 20, 'Ingreso'),
	(3, 'Laptop', 5, 'Ingreso'),
	(4, 'Monitor', 2, 'Ingreso'),
	(5, 'Funda Celular', 20, 'Ingreso'),
	(6, 'Teclado', 1, 'Salida'),
	(7, 'Mochila Laptop', 5, 'Ingreso'),
	(8, 'Calcomanias', 100, 'Ingreso'),
	(9, 'Pluma Azul', 1000, 'Ingreso'),
	(10, 'Pluma Negra', 1500, 'Ingreso'),
	(11, 'Tocador', 2, 'Ingreso'),
	(12, 'Jabon Axion', 600, 'Ingreso'),
	(13, 'Maquillaje', 30, 'Ingreso'),
	(14, 'Patineta', 30, 'Ingreso'),
	(15, 'Patines', 10, 'Ingreso'),
	(16, 'Vitropiso', 2000, 'Ingreso'),
	(17, 'Maquillaje', 2, 'Robo');

-- Volcando estructura para tabla desarrollo2.productos
CREATE TABLE IF NOT EXISTS `productos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla desarrollo2.productos: ~17 rows (aproximadamente)
INSERT INTO `productos` (`ID`, `nombre`, `precio`) VALUES
	(1, 'Mouse', 250),
	(4, 'Teclado', 300),
	(5, 'Laptop', 14000),
	(6, 'Monitor', 1500),
	(7, 'Funda Celular', 500),
	(8, 'Teclado', 300),
	(9, 'Mochila Laptop', 1350),
	(10, 'Calcomanias', 9),
	(11, 'Pluma Azul', 5),
	(12, 'Pluma Negra', 5),
	(13, 'Tocador', 899),
	(14, 'Jabon Axion', 40),
	(15, 'Maquillaje', 100),
	(16, 'Patineta', 500),
	(17, 'Patines', 1500),
	(18, 'Vitropiso', 900),
	(19, 'Maquillaje', 100);

-- Volcando estructura para tabla desarrollo2.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `permiso` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla desarrollo2.usuarios: ~4 rows (aproximadamente)
INSERT INTO `usuarios` (`id`, `user`, `password`, `permiso`) VALUES
	(1, 'Admin', 'admin123', 'Administrador'),
	(2, 'Joy', '123456', 'Edición'),
	(3, 'Aelin', 'porquesi123', 'Solo lectura'),
	(4, 'Tomoe', 'NanamiKamisama', 'Edición');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
