CREATE DATABASE IF NOT EXISTS crud_jdbc;

USE crud_jdbc;

CREATE TABLE user (
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    gender VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL,
    PRIMARY KEY (id));
    
SELECT * FROM USER;