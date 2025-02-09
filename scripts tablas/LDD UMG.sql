CREATE TABLE facultad(
    codigo_Facultad VARCHAR(5),
    nombre_Facultad VARCHAR(45),
    estatus_Facultad VARCHAR (1),
    PRIMARY KEY(codigo_Facultad))
    ENGINE= INNODB CHARACTER SET =latin1;


CREATE TABLE carreras(
    codigo_Carrera VARCHAR(5),
    nombre_Carrera VARCHAR(45),
    codigo_Facultad VARCHAR(5),
    estatus_Carrera VARCHAR (1),
    PRIMARY KEY(codigo_Carrera),
	FOREIGN KEY (codigo_Facultad)
    REFERENCES facultad(codigo_Facultad))
    ENGINE= INNODB CHARACTER SET =latin1;

CREATE TABLE cursos(
    codigo_Cursos VARCHAR(5),
    nombre_Cursos VARCHAR(45),
    estatus_Cursos VARCHAR (1),
    PRIMARY KEY(codigo_Cursos))
    ENGINE= INNODB CHARACTER SET =latin1;

CREATE TABLE jornadas(
    codigo_Jornadas VARCHAR(5),
    nombre_Jornadas VARCHAR(45),
    estatus_Jornadas VARCHAR (1),
    PRIMARY KEY(codigo_Jornadas))
    ENGINE= INNODB CHARACTER SET =latin1;


CREATE TABLE aulas(
    codigo_Aulas VARCHAR(5),
    nombre_Aulas VARCHAR(45),
    estatus_Aulas VARCHAR (1),
    PRIMARY KEY(codigo_Aulas))
    ENGINE= INNODB CHARACTER SET =latin1;


CREATE TABLE secciones(
    codigo_Secciones VARCHAR(5),
    nombre_Secciones VARCHAR(45),
    estatus_Secciones VARCHAR (1),
    PRIMARY KEY(codigo_Secciones))
    ENGINE= INNODB CHARACTER SET =latin1;


CREATE TABLE sedes(
    codigo_Sedes VARCHAR(5),
    nombre_Sedes VARCHAR(45),
    estatus_Sedes VARCHAR (1),
    PRIMARY KEY(codigo_Sedes))
    ENGINE= INNODB CHARACTER SET =latin1;




CREATE TABLE alumnos(
    carnet_Alumno VARCHAR(15),
    nombre_Alumno VARCHAR(45),
    direccion_Alumno VARCHAR(45),
    telefono_Alumno VARCHAR(45),
    email_Alumno VARCHAR(20),
    estatus_Alumno VARCHAR (1),
    PRIMARY KEY(carnet_Alumno))
    ENGINE= INNODB CHARACTER SET =latin1;

CREATE TABLE maestros(
    codigo_Maestro VARCHAR(5),
    nombre_Maestro VARCHAR(45),
    direccion_Maestro VARCHAR(45),
    telefono_Maestro VARCHAR(45),
    email_Maestro VARCHAR(20),
    estatus_Maestro VARCHAR (1),
    PRIMARY KEY(codigo_Maestro))
    ENGINE= INNODB CHARACTER SET =latin1;


CREATE TABLE asignacion_cursos_alumnos (
    codigo_Carrera VARCHAR(5),
    codigo_Sede VARCHAR(5),
    codigo_Seccion VARCHAR(5),
    codigo_Jornada VARCHAR(5),
    codigo_Aula VARCHAR(5),
    codigo_Curso VARCHAR(5),
    carnet_Alumno VARCHAR(15),
    nota_asignaciones_cursos_alumnos FLOAT(10,2),
    
    -- Definición de claves foráneas
    PRIMARY KEY (codigo_Carrera,codigo_Sede,codigo_Seccion,codigo_Jornada,codigo_Aula,codigo_Curso, carnet_Alumno),

    FOREIGN KEY (codigo_Carrera) REFERENCES carreras(codigo_Carrera),
    FOREIGN KEY (codigo_Sede) REFERENCES sedes(codigo_Sedes),
    FOREIGN KEY (codigo_Jornada) REFERENCES jornadas(codigo_Jornadas),
    FOREIGN KEY (codigo_Seccion) REFERENCES secciones(codigo_Secciones),
    FOREIGN KEY (codigo_Aula) REFERENCES aulas(codigo_Aulas),
    FOREIGN KEY (codigo_Curso) REFERENCES cursos(codigo_Cursos),
    FOREIGN KEY (carnet_Alumno) REFERENCES alumnos(carnet_Alumno)
)
ENGINE=INNODB CHARACTER SET = latin1;


CREATE TABLE asignacion_cursos_maestros(
    codigo_carrera VARCHAR(5),
    codigo_sede VARCHAR(5),
    codigo_seccion VARCHAR(5),
    codigo_jornada VARCHAR(5),
    codigo_aula VARCHAR(5),
    codigo_curso VARCHAR(5),
    codigo_maestro VARCHAR(5),

    PRIMARY KEY (codigo_carrera, codigo_sede, codigo_seccion, codigo_jornada, codigo_aula, codigo_curso, codigo_maestro),

    FOREIGN KEY (codigo_carrera) REFERENCES carreras(codigo_carrera),
    FOREIGN KEY (codigo_sede) REFERENCES sedes(codigo_sede),
    FOREIGN KEY (codigo_jornada) REFERENCES jornadas(codigo_jornada),
    FOREIGN KEY (codigo_seccion) REFERENCES secciones(codigo_seccion),
    FOREIGN KEY (codigo_aula) REFERENCES aulas(codigo_aula),
    FOREIGN KEY (codigo_curso) REFERENCES cursos(codigo_curso),
    FOREIGN KEY (codigo_maestro) REFERENCES maestros(codigo_maestro)
) ENGINE=INNODB CHARACTER SET=latin1;