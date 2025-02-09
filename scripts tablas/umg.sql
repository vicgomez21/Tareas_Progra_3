-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-02-2025 a las 20:52:12
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
-- Base de datos: `umg`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `carnet_Alumno` varchar(15) NOT NULL,
  `nombre_Alumno` varchar(45) DEFAULT NULL,
  `direccion_Alumno` varchar(45) DEFAULT NULL,
  `telefono_Alumno` varchar(45) DEFAULT NULL,
  `email_Alumno` varchar(20) DEFAULT NULL,
  `estatus_Alumno` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`carnet_Alumno`, `nombre_Alumno`, `direccion_Alumno`, `telefono_Alumno`, `email_Alumno`, `estatus_Alumno`) VALUES
('10733', 'Victor', 'zona 16', '35922120', 'vgomez@gmai.com', '1'),
('108956', 'cristian', 'zona 18', '35925375', 'csipac@gmai.com', '1'),
('2817', 'carlos', 'zona 18', '47567508', 'ccalderon@gmai.com', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignacion_cursos_alumnos`
--

CREATE TABLE `asignacion_cursos_alumnos` (
  `codigo_Carrera` varchar(5) NOT NULL,
  `codigo_Sede` varchar(5) NOT NULL,
  `codigo_Seccion` varchar(5) NOT NULL,
  `codigo_Jornada` varchar(5) NOT NULL,
  `codigo_Aula` varchar(5) NOT NULL,
  `codigo_Curso` varchar(5) NOT NULL,
  `carnet_Alumno` varchar(15) NOT NULL,
  `nota_asignaciones_cursos_alumnos` float(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignacion_cursos_maestros`
--

CREATE TABLE `asignacion_cursos_maestros` (
  `codigo_Carrera` varchar(5) NOT NULL,
  `codigo_Sede` varchar(5) NOT NULL,
  `codigo_Seccion` varchar(5) NOT NULL,
  `codigo_Jornada` varchar(5) NOT NULL,
  `codigo_Aula` varchar(5) NOT NULL,
  `codigo_Curso` varchar(5) NOT NULL,
  `codigo_Maestro` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aulas`
--

CREATE TABLE `aulas` (
  `codigo_Aulas` varchar(5) NOT NULL,
  `nombre_Aulas` varchar(45) DEFAULT NULL,
  `estatus_Aulas` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `aulas`
--

INSERT INTO `aulas` (`codigo_Aulas`, `nombre_Aulas`, `estatus_Aulas`) VALUES
('0101', 'C-05', '1'),
('0102', 'C-05', '1'),
('0103', 'C-09', '1'),
('0104', 'C-7', '1'),
('0105', 'C-10', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carreras`
--

CREATE TABLE `carreras` (
  `codigo_Carrera` varchar(5) NOT NULL,
  `nombre_Carrera` varchar(45) DEFAULT NULL,
  `codigo_Facultad` varchar(5) DEFAULT NULL,
  `estatus_Carrera` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `carreras`
--

INSERT INTO `carreras` (`codigo_Carrera`, `nombre_Carrera`, `codigo_Facultad`, `estatus_Carrera`) VALUES
('0901', 'Ing. en sistemas', '00001', '1'),
('0903', 'Ing. electrico', '00001', '1'),
('1059', 'Ing. de software', '00001', '1'),
('5235', 'Ing. de software', '00001', '1'),
('9959', 'Ing. en sistemas', '00001', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `codigo_Cursos` varchar(5) NOT NULL,
  `nombre_Cursos` varchar(45) DEFAULT NULL,
  `estatus_Cursos` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`codigo_Cursos`, `nombre_Cursos`, `estatus_Cursos`) VALUES
('019', 'Calculo-2', '1'),
('021', 'Programacion-3', '1'),
('022', 'Metodos-Numericos', '1'),
('023', 'Electronica analogica', '1'),
('024', 'Estadistica-2', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facultad`
--

CREATE TABLE `facultad` (
  `codigo_Facultad` varchar(5) NOT NULL,
  `nombre_Facultad` varchar(45) DEFAULT NULL,
  `estatus_Facultad` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `facultad`
--

INSERT INTO `facultad` (`codigo_Facultad`, `nombre_Facultad`, `estatus_Facultad`) VALUES
('00001', 'Facultad Ingenieria en Sist. y C.C', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jornadas`
--

CREATE TABLE `jornadas` (
  `codigo_Jornadas` varchar(5) NOT NULL,
  `nombre_Jornadas` varchar(45) DEFAULT NULL,
  `estatus_Jornadas` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `jornadas`
--

INSERT INTO `jornadas` (`codigo_Jornadas`, `nombre_Jornadas`, `estatus_Jornadas`) VALUES
('001', 'Matutina', '1'),
('002', 'Vespertina', '1'),
('003', 'Nocturna', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maestros`
--

CREATE TABLE `maestros` (
  `codigo_Maestro` varchar(5) NOT NULL,
  `nombre_Maestro` varchar(45) DEFAULT NULL,
  `direccion_Maestro` varchar(45) DEFAULT NULL,
  `telefono_Maestro` varchar(45) DEFAULT NULL,
  `email_Maestro` varchar(20) DEFAULT NULL,
  `estatus_Maestro` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `maestros`
--

INSERT INTO `maestros` (`codigo_Maestro`, `nombre_Maestro`, `direccion_Maestro`, `telefono_Maestro`, `email_Maestro`, `estatus_Maestro`) VALUES
('57985', 'Luis Enrique', 'zona 5', '15126487', '[enrique@gmail.com]', '1'),
('57986', 'Federico', 'zona 7', '16128987', '[Federico@gmail.com]', '1'),
('57989', 'Donald', 'zona 10', '21206487', '[Dpoz@gmail.com]', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `secciones`
--

CREATE TABLE `secciones` (
  `codigo_Secciones` varchar(5) NOT NULL,
  `nombre_Secciones` varchar(45) DEFAULT NULL,
  `estatus_Secciones` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `secciones`
--

INSERT INTO `secciones` (`codigo_Secciones`, `nombre_Secciones`, `estatus_Secciones`) VALUES
('5102', 'A', '1'),
('5103', 'B', '1'),
('5104', 'C', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sedes`
--

CREATE TABLE `sedes` (
  `codigo_Sedes` varchar(5) NOT NULL,
  `nombre_Sedes` varchar(45) DEFAULT NULL,
  `estatus_Sedes` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `sedes`
--

INSERT INTO `sedes` (`codigo_Sedes`, `nombre_Sedes`, `estatus_Sedes`) VALUES
('2120', 'Portales', '1'),
('2124', 'Naranjo', '1'),
('2125', 'Central', '1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`carnet_Alumno`);

--
-- Indices de la tabla `asignacion_cursos_alumnos`
--
ALTER TABLE `asignacion_cursos_alumnos`
  ADD PRIMARY KEY (`codigo_Carrera`,`codigo_Sede`,`codigo_Seccion`,`codigo_Jornada`,`codigo_Aula`,`codigo_Curso`,`carnet_Alumno`),
  ADD KEY `codigo_Sede` (`codigo_Sede`),
  ADD KEY `codigo_Jornada` (`codigo_Jornada`),
  ADD KEY `codigo_Seccion` (`codigo_Seccion`),
  ADD KEY `codigo_Aula` (`codigo_Aula`),
  ADD KEY `codigo_Curso` (`codigo_Curso`),
  ADD KEY `carnet_Alumno` (`carnet_Alumno`);

--
-- Indices de la tabla `asignacion_cursos_maestros`
--
ALTER TABLE `asignacion_cursos_maestros`
  ADD PRIMARY KEY (`codigo_Carrera`,`codigo_Sede`,`codigo_Seccion`,`codigo_Jornada`,`codigo_Aula`,`codigo_Curso`,`codigo_Maestro`),
  ADD KEY `codigo_Sede` (`codigo_Sede`),
  ADD KEY `codigo_Jornada` (`codigo_Jornada`),
  ADD KEY `codigo_Seccion` (`codigo_Seccion`),
  ADD KEY `codigo_Aula` (`codigo_Aula`),
  ADD KEY `codigo_Curso` (`codigo_Curso`),
  ADD KEY `codigo_Maestro` (`codigo_Maestro`);

--
-- Indices de la tabla `aulas`
--
ALTER TABLE `aulas`
  ADD PRIMARY KEY (`codigo_Aulas`);

--
-- Indices de la tabla `carreras`
--
ALTER TABLE `carreras`
  ADD PRIMARY KEY (`codigo_Carrera`),
  ADD KEY `codigo_Facultad` (`codigo_Facultad`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`codigo_Cursos`);

--
-- Indices de la tabla `facultad`
--
ALTER TABLE `facultad`
  ADD PRIMARY KEY (`codigo_Facultad`);

--
-- Indices de la tabla `jornadas`
--
ALTER TABLE `jornadas`
  ADD PRIMARY KEY (`codigo_Jornadas`);

--
-- Indices de la tabla `maestros`
--
ALTER TABLE `maestros`
  ADD PRIMARY KEY (`codigo_Maestro`);

--
-- Indices de la tabla `secciones`
--
ALTER TABLE `secciones`
  ADD PRIMARY KEY (`codigo_Secciones`);

--
-- Indices de la tabla `sedes`
--
ALTER TABLE `sedes`
  ADD PRIMARY KEY (`codigo_Sedes`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asignacion_cursos_alumnos`
--
ALTER TABLE `asignacion_cursos_alumnos`
  ADD CONSTRAINT `asignacion_cursos_alumnos_ibfk_1` FOREIGN KEY (`codigo_Carrera`) REFERENCES `carreras` (`codigo_Carrera`),
  ADD CONSTRAINT `asignacion_cursos_alumnos_ibfk_2` FOREIGN KEY (`codigo_Sede`) REFERENCES `sedes` (`codigo_Sedes`),
  ADD CONSTRAINT `asignacion_cursos_alumnos_ibfk_3` FOREIGN KEY (`codigo_Jornada`) REFERENCES `jornadas` (`codigo_Jornadas`),
  ADD CONSTRAINT `asignacion_cursos_alumnos_ibfk_4` FOREIGN KEY (`codigo_Seccion`) REFERENCES `secciones` (`codigo_Secciones`),
  ADD CONSTRAINT `asignacion_cursos_alumnos_ibfk_5` FOREIGN KEY (`codigo_Aula`) REFERENCES `aulas` (`codigo_Aulas`),
  ADD CONSTRAINT `asignacion_cursos_alumnos_ibfk_6` FOREIGN KEY (`codigo_Curso`) REFERENCES `cursos` (`codigo_Cursos`),
  ADD CONSTRAINT `asignacion_cursos_alumnos_ibfk_7` FOREIGN KEY (`carnet_Alumno`) REFERENCES `alumnos` (`carnet_Alumno`);

--
-- Filtros para la tabla `asignacion_cursos_maestros`
--
ALTER TABLE `asignacion_cursos_maestros`
  ADD CONSTRAINT `asignacion_cursos_maestros_ibfk_1` FOREIGN KEY (`codigo_Carrera`) REFERENCES `carreras` (`codigo_Carrera`),
  ADD CONSTRAINT `asignacion_cursos_maestros_ibfk_2` FOREIGN KEY (`codigo_Sede`) REFERENCES `sedes` (`codigo_Sedes`),
  ADD CONSTRAINT `asignacion_cursos_maestros_ibfk_3` FOREIGN KEY (`codigo_Jornada`) REFERENCES `jornadas` (`codigo_Jornadas`),
  ADD CONSTRAINT `asignacion_cursos_maestros_ibfk_4` FOREIGN KEY (`codigo_Seccion`) REFERENCES `secciones` (`codigo_Secciones`),
  ADD CONSTRAINT `asignacion_cursos_maestros_ibfk_5` FOREIGN KEY (`codigo_Aula`) REFERENCES `aulas` (`codigo_Aulas`),
  ADD CONSTRAINT `asignacion_cursos_maestros_ibfk_6` FOREIGN KEY (`codigo_Curso`) REFERENCES `cursos` (`codigo_Cursos`),
  ADD CONSTRAINT `asignacion_cursos_maestros_ibfk_7` FOREIGN KEY (`codigo_Maestro`) REFERENCES `maestros` (`codigo_Maestro`);

--
-- Filtros para la tabla `carreras`
--
ALTER TABLE `carreras`
  ADD CONSTRAINT `carreras_ibfk_1` FOREIGN KEY (`codigo_Facultad`) REFERENCES `facultad` (`codigo_Facultad`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
