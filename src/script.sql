DROP TABLE IF EXISTS notas;
DROP TABLE IF EXISTS genero;
DROP TABLE IF EXISTS materia;
DROP TABLE IF EXISTS persona;

CREATE TABLE persona (
    id     INTEGER      PRIMARY KEY AUTOINCREMENT
                        NOT NULL,
    nombre VARCHAR (60) UNIQUE
                        NOT NULL
);

INSERT INTO persona (nombre) VALUES ('armando');
INSERT INTO persona (nombre) VALUES ('nicolas');
INSERT INTO persona (nombre) VALUES ('daniel');
INSERT INTO persona (nombre) VALUES ('maria');
INSERT INTO persona (nombre) VALUES ('marcela');
INSERT INTO persona (nombre) VALUES ('alexandra');

CREATE TABLE materia (
    id     INTEGER      PRIMARY KEY AUTOINCREMENT
                        NOT NULL,
    nombre VARCHAR (60) UNIQUE
                        NOT NULL
);

INSERT INTO materia (nombre) VALUES ('idiomas');
INSERT INTO materia (nombre) VALUES ('historia');
INSERT INTO materia (nombre) VALUES ('literatura');

CREATE TABLE genero (
    id     INTEGER      PRIMARY KEY
                        NOT NULL,
    codigo VARCHAR (1)  UNIQUE
                        NOT NULL,
    nombre VARCHAR (60) NOT NULL
);

INSERT INTO genero (id, codigo, nombre) VALUES (0, 'm', 'masculino');
INSERT INTO genero (id, codigo, nombre) VALUES (1, 'f', 'femenino');

CREATE TABLE notas (
    id         INTEGER        PRIMARY KEY AUTOINCREMENT
                              NOT NULL,
    persona_id INTEGER        NOT NULL
                              REFERENCES persona (id) ON DELETE RESTRICT,
    materia_id INTEGER        NOT NULL
                              REFERENCES materia (id) ON DELETE RESTRICT,
    genero_id  INTEGER        NOT NULL
                              REFERENCES genero (id) ON DELETE RESTRICT,
    nota       DECIMAL (5, 2) NOT NULL
);

INSERT INTO notas (persona_id, genero_id, materia_id, nota) VALUES (1, 0, 1, 5.7);
INSERT INTO notas (persona_id, genero_id, materia_id, nota) VALUES (1, 0, 2, 0.2);
INSERT INTO notas (persona_id, genero_id, materia_id, nota) VALUES (1, 0, 3, 5.0);
INSERT INTO notas (persona_id, genero_id, materia_id, nota) VALUES (2, 0, 1, 7.5);
INSERT INTO notas (persona_id, genero_id, materia_id, nota) VALUES (2, 0, 2, 9.9);
INSERT INTO notas (persona_id, genero_id, materia_id, nota) VALUES (2, 0, 3, 3.5);
INSERT INTO notas (persona_id, genero_id, materia_id, nota) VALUES (3, 0, 1, 2.2);
INSERT INTO notas (persona_id, genero_id, materia_id, nota) VALUES (3, 0, 2, 5.5);
INSERT INTO notas (persona_id, genero_id, materia_id, nota) VALUES (3, 0, 3, 2.2);
INSERT INTO notas (persona_id, genero_id, materia_id, nota) VALUES (4, 1, 1, 7.9);
INSERT INTO notas (persona_id, genero_id, materia_id, nota) VALUES (4, 1, 2, 2.2);
INSERT INTO notas (persona_id, genero_id, materia_id, nota) VALUES (4, 1, 3, 9.9);
INSERT INTO notas (persona_id, genero_id, materia_id, nota) VALUES (5, 1, 1, 9.3);
INSERT INTO notas (persona_id, genero_id, materia_id, nota) VALUES (5, 1, 2, 9.8);
INSERT INTO notas (persona_id, genero_id, materia_id, nota) VALUES (5, 1, 3, 5.8);
INSERT INTO notas (persona_id, genero_id, materia_id, nota) VALUES (6, 1, 1, 9.5);
INSERT INTO notas (persona_id, genero_id, materia_id, nota) VALUES (6, 1, 2, 7.2);
INSERT INTO notas (persona_id, genero_id, materia_id, nota) VALUES (6, 1, 3, 6.6);
