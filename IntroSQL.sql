-- Commento a singola riga
/*
	Commento
    multiriga
*/

/* 
	SQL ha diverse categoria di statment
    DDL -> Data Definition Language
			Definisce tutte le istruzioni SQL per la creazione e gestione di un DB
	DML -> Data Manipulation Language
			Definisce tutte le istruzioni SQL per la creazione e gestione di dati nelle tabelle di un DB
	DQL -> Data Query Language
			Definisce tutte le istruzioni SQL per la lettura di dati in un DB
	DCL -> Data Control Language
			Definisce tutte le istruzioni SQL per la gestione dei permessi di un DB
*/

/* 
	DDL -> Data Definition Language
			Definisce tutte le istruzioni SQL per la creazione e gestione di un DB
		
	-- DB
	-- CREATE | USE | DROP | SHOW
		
        --> CREATE DATABASE(SCHEMA) [IF NOT EXISTS] db_name;
        --> SHOW DATABASES;
        --> USE db_name;
        --> DROP DATABASE [IF EXISTS] db_name;
        --> RENAME DATABASE old_db_name TO new_db_name; (Deprecata)
        --> ALTER DATABASE old_db_name MODIFY NAME = new_db_name; (Deprecata)
        
	-- TABLE
    -- CREATE | ALTER | DROP
    -- CREATE TABLE [IF NOT EXISTS] db_name.table_name (
		column_name datatype column_constraints,
        column_name datatype column_constraints,
        ......
        column_name datatype column_constraints
        [constraint_name] table constraints
	  )
	-- ALTER TABLE db_name.table_name ADD COLUMN column_name datatype column_constraints;
    -- ALTER TABLE db_name.table_name DROP COLUMN column_name [CASCADE | RESTRICT]
    -- ALTER TABLE db_name.table_name RENAME COLUMN old_column_name TO new_column_name;
    -- ALTER TABLE db_name.table_name MODIFY COLUMN column_name new_datatype;
    -- ALTER TABLE db_name.table_name ADD CONSTRAINT [constraint_name] column_constraint;
    -- ALTER TABLE db_name.table_name DROP CONSTRAINT constraint_name;
    
    -- RELAZIONI -> OneToOne | OneToMany/ManyToOne | ManyToMany
*/
DROP DATABASE IF EXISTS agrop053_intro;
CREATE DATABASE IF NOT EXISTS agrop053_intro;
-- SHOW DATABASES;
USE agrop053_intro;


CREATE TABLE IF NOT EXISTS agrop053_intro.users (
	user_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(25) NOT NULL,
    lastname VARCHAR(25) NOT NULL,
    age INT UNSIGNED NULL DEFAULT 18,
    city VARCHAR(50) NULL,
    fiscal_code VARCHAR(16) NOT NULL,
    email VARCHAR(50) NOT NULL,
    CONSTRAINT email_uk UNIQUE(email),
    CONSTRAINT user_pk PRIMARY KEY(user_id)
);

ALTER TABLE agrop053_intro.users ADD COLUMN phone VARCHAR(10) NOT NULL UNIQUE;
ALTER TABLE agrop053_intro.users DROP COLUMN city;
ALTER TABLE agrop053_intro.users RENAME COLUMN name TO firstname;
ALTER TABLE agrop053_intro.users MODIFY COLUMN fiscal_code CHAR(16);
ALTER TABLE agrop053_intro.users ADD CONSTRAINT fiscal_code_uk UNIQUE(fiscal_code);
ALTER TABLE agrop053_intro.users DROP CONSTRAINT email_uk;

-- Relazione OneToOne
CREATE TABLE IF NOT EXISTS agrop053_intro.signin (
	signin_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    user_id INT NOT NULL UNIQUE,
    CONSTRAINT signin_users_fk 
		FOREIGN KEY(user_id) 
        REFERENCES users(user_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);
-- Relazione OneToOne
/*CREATE TABLE IF NOT EXISTS agrop053_intro.signin (
	signin_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    CONSTRAINT signin_users_fk FOREIGN KEY(signin_id) REFERENCES users(user_id)
);*/

-- Relazione OneToMany
CREATE TABLE IF NOT EXISTS agrop053_intro.cars (
	car_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    car_name VARCHAR(50) NOT NULL,
    car_lecense_plate CHAR(7) NOT NULL UNIQUE,
    user_id INT NOT NULL,
    CONSTRAINT cars_users_fk 
    FOREIGN KEY(user_id) REFERENCES users(user_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS agrop053_intro.courses (
	course_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    course_hours INT NULL DEFAULT 250
);
-- Relazione ManyToMany
CREATE TABLE IF NOT EXISTS agrop053_intro.users_courses (
	user_id INT NOT NULL,
    course_id INT NOT NULL,
    CONSTRAINT course_users_fk1 FOREIGN KEY(user_id) REFERENCES users(user_id) 
		ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT course_users_fk2 FOREIGN KEY(course_id) REFERENCES courses(course_id) 
		ON DELETE CASCADE ON UPDATE CASCADE
);