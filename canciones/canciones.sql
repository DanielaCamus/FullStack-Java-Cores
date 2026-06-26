CREATE DATABASE IF NOT EXISTS canciones_db;

USE canciones_db;

INSERT INTO canciones (titulo, artista, album, genero, idioma, fecha_creacion, fecha_actualizacion) 
VALUES 
('There Is a Light That Never Goes Out', 'The Smiths', 'The Queen Is Dead', 'Jangle Pop', 'Inglés', NOW(), NOW()),
('Carcasse', 'Olivier Faubert', 'Mes ombres', 'Pop', 'Francés', NOW(), NOW()),
('Dearest Man', 'Ohashi Trio', 'PRETAPORTER', 'J-Pop', 'Japonés', NOW(), NOW());

SELECT * FROM canciones;