-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-04-2025 a las 02:53:30
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prototipop2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cleintes`
--

CREATE TABLE `cleintes` (
  `id_cliente` int(11) NOT NULL,
  `nombre_cliente` varchar(10) NOT NULL,
  `apellido_cliente` varchar(10) NOT NULL,
  `edad_cliente` varchar(10) NOT NULL,
  `correo_cliente` varchar(25) NOT NULL,
  `direccion_cliente` varchar(25) NOT NULL,
  `telefono_cliente` varchar(25) NOT NULL,
  `dpi_cliente` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cleintes`
--

INSERT INTO `cleintes` (`id_cliente`, `nombre_cliente`, `apellido_cliente`, `edad_cliente`, `correo_cliente`, `direccion_cliente`, `telefono_cliente`, `dpi_cliente`) VALUES
(6, 'aaa', 'aaa', 'aa', 'aaa', 'aaa', 'aaa', 'aaa'),
(7, 'AA', 'AAA', 'AA', 'AA', 'AAA', 'AA', 'AAA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dvd`
--

CREATE TABLE `dvd` (
  `id_video` int(10) NOT NULL,
  `nombre_video` varchar(10) NOT NULL,
  `clasificacion_video` varchar(10) NOT NULL,
  `valor_video` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dvd`
--

INSERT INTO `dvd` (`id_video`, `nombre_video`, `clasificacion_video`, `valor_video`) VALUES
(5, 'aaa', 'aaa', 10),
(6, 'AAA', 'AAAA', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_registrosatrasados`
--

CREATE TABLE `tbl_registrosatrasados` (
  `Id_cliente` int(11) NOT NULL,
  `id_video` int(10) NOT NULL,
  `FechaAlquiler` varchar(10) NOT NULL,
  `FechaCaducidad` varchar(10) NOT NULL,
  `Total` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `tbl_registrosatrasados`
--

INSERT INTO `tbl_registrosatrasados` (`Id_cliente`, `id_video`, `FechaAlquiler`, `FechaCaducidad`, `Total`) VALUES
(6, 5, '11', '11', '11'),
(7, 6, '10-04-2025', '15-04-2025', '50');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `username` varchar(60) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `username`, `password`) VALUES
(84, 'NUEVO', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
(85, 'NUEVO2', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
(87, 'ESDUARDO', 'b2b2f104d32c638903e151a9b20d6e27b41d8c0c84cf8458738f83ca2f1dd744'),
(2026, 'admin', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cleintes`
--
ALTER TABLE `cleintes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `dvd`
--
ALTER TABLE `dvd`
  ADD PRIMARY KEY (`id_video`);

--
-- Indices de la tabla `tbl_registrosatrasados`
--
ALTER TABLE `tbl_registrosatrasados`
  ADD PRIMARY KEY (`id_video`,`Id_cliente`),
  ADD KEY `Id_cliente` (`Id_cliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cleintes`
--
ALTER TABLE `cleintes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `dvd`
--
ALTER TABLE `dvd`
  MODIFY `id_video` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_registrosatrasados`
--
ALTER TABLE `tbl_registrosatrasados`
  ADD CONSTRAINT `tbl_registrosatrasados_ibfk_1` FOREIGN KEY (`Id_cliente`) REFERENCES `cleintes` (`id_cliente`),
  ADD CONSTRAINT `tbl_registrosatrasados_ibfk_2` FOREIGN KEY (`id_video`) REFERENCES `dvd` (`id_video`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
