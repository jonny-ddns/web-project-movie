USE myPro_movie;
DROP TABLE IF EXISTS members;
CREATE TABLE members (
	id VARCHAR(20),
	password VARCHAR(20),
	name VARCHAR(10),
   	email VARCHAR(30),
    birthyear INT,
    gender CHAR(1),
    interest VARCHAR(50),
    joinDate TIMESTAMP,
    updateDate TIMESTAMP,
    isActive CHAR(1),
    
    PRIMARY KEY(id)
);