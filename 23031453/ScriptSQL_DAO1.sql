CREATE DATABASE escuelaTAP;

USE escuelaTAP;

CREATE TABLE alumnos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    carrera VARCHAR(100),
    edad INT
);

INSERT INTO alumnos(nombre,carrera,edad)
VALUES
('Carlos','Sistemas',21),
('Ana','Industrial',22),
('Luis','Electrónica',20);