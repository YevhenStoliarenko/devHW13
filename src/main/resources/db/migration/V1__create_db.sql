CREATE DATABASE IF NOT EXISTS spacetravel;
DROP TABLE IF EXISTS spacetravel.client;
CREATE TABLE spacetravel.client
(
    id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(200),

    CONSTRAINT name_check CHECK (LENGTH(name) >= 3)
);



DROP TABLE IF EXISTS spacetravel.planet;
CREATE TABLE spacetravel.planet
(
    id   VARCHAR(10) PRIMARY KEY NOT NULL,
    name VARCHAR(500),

    CONSTRAINT planetname_check CHECK (LENGTH(name) >= 1),
    CONSTRAINT id_check CHECK (BINARY id = UPPER(id) and id RLIKE '^[A-Z]+[A-Z0-9]+|^[0-9]+[A-Z]+[A-Z0-9]*')
);



DROP TABLE IF EXISTS spacetravel.ticket;
CREATE TABLE spacetravel.ticket
(
    id             INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    created_at     DATETIME           NOT NULL,
    client_id      INT             NOT NULL,
    from_planet_id VARCHAR(10)        NOT NULL,
    to_planet_id   VARCHAR(10)        NOT NULL,
    CONSTRAINT from_planet_check FOREIGN KEY (from_planet_id) REFERENCES spacetravel.planet (id),
    CONSTRAINT to_planet_check FOREIGN KEY (to_planet_id) REFERENCES spacetravel.planet (id),
    CONSTRAINT client_id_check FOREIGN KEY (client_id) REFERENCES spacetravel.client (id)
);


