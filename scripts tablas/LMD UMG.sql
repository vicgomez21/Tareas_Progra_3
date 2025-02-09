
INSERT INTO `facultad`(`codigo_Facultad`, `nombre_Facultad`, `estatus_Facultad`)
VALUES ('00001','Facultad Ingenieria en Sist. y C.C','1')


INSERT INTO `carreras`(`codigo_Carrera`, `nombre_Carrera`, `codigo_Facultad`, `estatus_Carrera`) 
VALUES ('0901','Ing. en sistemas','00001','1'),
('9959','Ing. en sistemas','00001','1'),
('5235','Ing. de software','00001','1'),
('1059','Ing. de software','00001','1'),
('0903','Ing. electrico','00001','1');

INSERT INTO `aulas`(`codigo_Aulas`, `nombre_Aulas`, `estatus_Aulas`)
VALUES ('0101','C-05','1'),
	('0102','C-05','1'),
    ('0103','C-09','1'),
    ('0104','C-7','1'),
    ('0105','C-10','1')

INSERT INTO `maestros`(`codigo_Maestro`, `nombre_Maestro`, `direccion_Maestro`, `telefono_Maestro`, `email_Maestro`, `estatus_Maestro`) 
VALUES ('57985','Luis Enrique','zona 5','15126487','[enrique@gmail.com]','1'),
        ('57986','Federico','zona 7','16128987','[Federico@gmail.com]','1'),
        ('57985¿9','Donald','zona 10','21206487','[Dpoz@gmail.com]','1')


INSERT INTO `alumnos`(`carnet_Alumno`, `nombre_Alumno`, `direccion_Alumno`, `telefono_Alumno`, `email_Alumno`, `estatus_Alumno`) 
VALUES ('10733','Victor','zona 16','35922120','vgomez@gmai.com','1'),
		('2817','carlos','zona 18','47567508','ccalderon@gmai.com','1'),
        ('108956','cristian','zona 18','35925375','csipac@gmai.com','1')