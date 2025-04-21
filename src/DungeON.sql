CREATE DATABASE IF NOT EXISTS Dungeon;
USE Dungeon;

CREATE TABLE IF NOT EXISTS Partida (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_jugador VARCHAR(50),
	clase_personaje VARCHAR(30),
    fecha_inicio DATETIME,
    hora_fin DATETIME,
    duracion TIME,
    resultado VARCHAR(20),
    ultima_sala INT,
    enemigos_derrotados INT,
    daño_infligido INT,
    daño_recibido INT,
    habilidades_usadas INT,
    objetos_usados INT
);	

INSERT INTO Partida VALUES (
    'Partidaprueba', 'HECHICERO', '2025-04-21 15:30:00', '2025-04-21 15:50:00', '00:20:00', 'VICTORIA',
    6, 12, 450, 300,
    5, 4
);
