-- Selecciona el esquema
USE inscripciones_cursos;

-- Inserta al menos cinco nuevos estudiantes en la tabla «estudiantes».
INSERT INTO estudiantes (nombre, edad) VALUES
	('Camila Sepúlveda', 27),
	('Alonso Cerda', 34),
	('Javiera Antilef', 29),
	('Felipe Orellana', 38),
	('Constanza Varela', 26);

-- Inserta al menos cuatro nuevos cursos en la tabla «cursos». 
INSERT INTO cursos (nombre, duracion) VALUES
	('HTML', 20),
	('CSS', 40),
	('Algoritmos', 10),
	('JavaScript', 80);

-- Asociar a cuatro de los estudiantes a al menos dos de los cursos dados de alta.
INSERT INTO inscripciones (id_estudiante, id_curso) VALUES
	(2, 1), (2, 2),
	(3, 2), (3, 3),
	(4, 3), (4, 4),
	(5, 1), (5, 4);
    
-- Proyecta a todos los estudiantes y sus respectivos cursos.
SELECT estudiantes.nombre AS 'Estudiante', cursos.nombre AS 'Curso inscrito'
FROM estudiantes
LEFT JOIN inscripciones ON estudiantes.id = inscripciones.id_estudiante
LEFT JOIN cursos ON inscripciones.id_curso = cursos.id;

-- Proyecta todos los estudiantes que están inscritos en un curso específico, utilizando el nombre del curso como criterio de búsqueda.
SELECT estudiantes.nombre AS 'Estudiante', cursos.nombre AS 'Curso específico'
FROM estudiantes
INNER JOIN inscripciones ON estudiantes.id = inscripciones.id_estudiante
INNER JOIN cursos ON inscripciones.id_curso = cursos.id
WHERE cursos.nombre = 'JavaScript';

-- Proyecta todos los cursos en los que está inscrito un estudiante específico, utilizando su nombre como criterio de búsqueda.
SELECT cursos.nombre AS 'Curso inscrito', estudiantes.nombre AS 'Estudiante específico'
FROM estudiantes
INNER JOIN inscripciones ON estudiantes.id = inscripciones.id_estudiante
INNER JOIN cursos ON inscripciones.id_curso = cursos.id
WHERE estudiantes.nombre = 'Felipe Orellana';

-- Cuenta el número de estudiantes inscritos en cada curso y muestra el nombre del curso junto con el número de estudiantes inscritos.
SELECT	cursos.nombre AS 'Curso',
		COUNT(inscripciones.id_estudiante) AS 'Número de estudiantes'
FROM cursos
LEFT JOIN inscripciones ON cursos.id = inscripciones.id_curso
GROUP BY cursos.id, cursos.nombre;

-- Encuentra los estudiantes que no están inscritos en ningún curso.
SELECT estudiantes.nombre AS 'Estudiantes sin cursos'
FROM estudiantes
LEFT JOIN inscripciones ON estudiantes.id = inscripciones.id_estudiante
WHERE inscripciones.id_curso IS NULL;


