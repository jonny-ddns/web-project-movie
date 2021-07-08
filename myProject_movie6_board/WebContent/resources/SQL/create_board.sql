USE myPro_movie;
DROP TABLE IF EXISTS board;
CREATE TABLE board (
	artiNum	INT NOT NULL AUTO_INCREMENT,
	artiTitle VARCHAR(50),
	writer VARCHAR(20),
	artiDate TIMESTAMP,
	openPublic CHAR(1),
	image VARCHAR(30),
	content TEXT,
	isActive CHAR(1),
    
    PRIMARY KEY(artiNum)
);