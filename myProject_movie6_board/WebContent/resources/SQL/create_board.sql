USE myPro_movie;
DROP TABLE IF EXISTS board;
CREATE TABLE board (
	artiNum	INT,
	artiTitle VARCHAR(50),
	writer VARCHAR(20),
	artiDate TIMESTAMP,
	openPublic CHAR(1),
	image VARCHAR(30),
	content TEXT,
	isActive char(1),
    
    PRIMARY KEY(artiNum)
);