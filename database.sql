CREATE DATABASE tes_talenavi_be;

USE tes_talenavi_be;

CREATE TABLE movie (
    id INT(11) AUTO_INCREMENT NOT NULL,
    title VARCHAR(100) NOT NULL,
    director VARCHAR(255) NOT NULL,
    summary VARCHAR(100),
    PRIMARY KEY (id)
) ENGINE InnoDB;

CREATE TABLE genre (
    id INT(11) AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ENGINE InnoDB;

CREATE TABLE movie_genre (
    movie_id INT(11),
    genre_id INT(11),
    FOREIGN KEY (movie_id) REFERENCES movie (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES genre (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE InnoDB;