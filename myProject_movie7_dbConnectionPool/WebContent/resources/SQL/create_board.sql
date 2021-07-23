USE myPro_movie;
DROP TABLE IF EXISTS board;
CREATE TABLE board (
	artiNum	INT AUTO_INCREMENT,
	artiTitle VARCHAR(50),
	writer VARCHAR(20),
	writeDate TIMESTAMP,
	modifyDate TIMESTAMP,
	openPublic CHAR(1),
	image VARCHAR(30),
	content TEXT,
	isActive CHAR(1),
    
    PRIMARY KEY(artiNum)
);