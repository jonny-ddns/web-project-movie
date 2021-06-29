---- DROP DATABASE IF EXISTS myPro_movie;
---- CREATE DATABASE myPro_movie;

USE myPro_movie;
DROP TABLE IF EXISTS movies;
CREATE TABLE movies (
	movieCode INT,
	title VARCHAR(20),
    director VARCHAR(20),
    actors VARCHAR(50),
    genre VARCHAR(15),
    content TEXT,
    runningTime smallint,
    rating VARCHAR(10),
    score SMALLINT,
    moviePoster VARCHAR(30),
    
    PRIMARY KEY(movieCode)
);