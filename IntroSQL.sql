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


/* 
	DML -> Data Manipulation Language
			Definisce tutte le istruzioni SQL per la creazione e gestione di dati nelle tabelle di un DB
	
    -- INSERT | UPDATE | DELETE
    -- INSERT INTO db_name.table_name (column_name1, column_name2, ...., column_nameN) 
							VALUES (value1, value2, ...., valueN)
    
	-- UPDATE db_name.table_name 
							SET column_name1 = newvalue1, column_name2 = newvalue2, ..., column_nameN = newvalueN
                            WHERE column_name = value
                            
	-- DELETE FROM db_name.table_name WHERE column_name = value
*/

/*
	DQL -> Data Query Language
			Definisce tutte le istruzioni SQL per la lettura di dati in un DB
            
	-- SELECT 	-> Definisce un elenco di campi o tutto(*) da restituire in un resultset di dati
    -- FROM 	-> Indica la sorgente di dati da cui leggere le informazioni(La tabella/le tabelle)
    -- WHERE	-> Search Condition, applica un filtro sulle righe della tabella indicata nel FROM
    -- GROUP BY	-> Aggrega dei dati rispetto alla combinazione univoca data dalla group list
    -- HAVING	-> Search Condition, applica un filtro sulle righe della tabella filtrate e aggregate dal GROUP BY
    -- ORDER BY	-> Consente di definire un ordinamento preciso
    -- LIMIT	-> Consente di selezionare un numero definito di record
    
    7 SELECT [DISTINCT] column_name1, column_name2, ...., column_nameN | * | aggregate function(expression)
	1	FROM db_name.table_name
    2    [WHERE Search Condition]
    3    [GROUP BY]
    4    [HAVING Search Condition]
    5    [ORDER BY]
    6    [LIMIT]
    
    -- Operatori di confronto della Search Condition
    = (uguale) 
    > (maggiore di) 
    < (minore di)
    >= (maggiore uguale)
    <= (minore di)
    <> | != (diverso da)
    !< (non minore di)
    !> (non maggiore di)
    
    -- Operatori logici della Search Condition
    AND (restituisce TRUE se entrambe le condizione sono vere)
    OR (restiruisce TRUE se almeno una condizione è vera)
    LIKE (contiene -> caratteri jolly -> _ %)
    BETWEEN (restituisce tutti i valori compresi tra >= AND <= del range specificato)
    IN | NOT IN (restituisce tutti i valori contenuti in un elenco di dati da cui individuare una corrispondenza)
    
    Function SQL
    
    String function
    https://dev.mysql.com/doc/refman/8.4/en/string-functions.html
    CONCAT(column_name1, " - ", column_name2) -> Funzione che permette di concatenare due o più colonne di tipo string
    UPPER("Stringa" | column_name) -> Funzione che permette di trasformare un valore testuale in maiuscolo
    LOWER("Stringa" | column_name) -> Funzione che permette di trasformare un valore testuale in minuscolo
    LENGTH("Stringa" | column_name) -> Funzione che restituisce la lunghezza di una stringa o di un valore
    TRIM("Stringa" | column_name) -> Funzione che restituisce un valore senza spazi vuoti ad inizio o fine stringa
    
    Numeric function
    https://dev.mysql.com/doc/refman/8.4/en/numeric-functions.html
    COUNT(* | DISTINCT column_name) -> Funzione che restituisce il numero di record di una query
    FORMAT(number | column_name, 2) -> Funzione che restituisce un numero decimale formattato
    TRUNCATE(number | column_name, 2) -> Funzione che restituisce un numero decimale troncato
    ABS(number | column_name) -> Funzione che restituisce un valore assoluto (senza segno -)
    AVG(column_name) -> Funzione che restituisce la media dei valori contenuti in una colonna
    CEIL(column_name) -> Funzione che restituisce un valore arrotondato per eccesso
    FLOOR(column_name) -> Funzione che restituisce un valore arrotondato per difetto
    ROUND(column_name) -> Funzione che restituisce un valore arrotondato per al numero intero più vicino
    RAND(column_name) -> Funzione che restituisce un valore casuale da 0 a 1
    MAX(column_name) -> Funzione che restituisce il valore massimo contenuto nella colonna
    MIN(column_name) -> Funzione che restituisce il valore minimo contenuto nella colonna
    SUM(column_name) -> Funzione che restituisce la somma dei valori presenti in una colonna
    
    Date function
    https://dev.mysql.com/doc/refman/8.4/en/date-and-time-functions.html
    ADDDATE(data, n) -> Funzione che aggiunge n ad una data
    ADDTIME(time, n) -> Funzione che aggiunge n ad una valore orario
    CURRENT_DATE() -> Funzione che restituisce una data in formato YYYY-MM-DD (String)
    CURRENT_TIME() -> Funzione che restituisce un orario in formato HH-MM-SS (String)
    CURRENT_TIMESTAMP() -> Funzione che restituisce data e orario di quel momento
    DATEDIFF(data1, data2) -> Funzione che calcola la differenza in giorni tra due date
    DAY(data) -> Funzione che restituisce il giorno da una data completa
    MONTH(data) -> Funzione che restituisce il mese da una data completa
    YEAR(data) -> Funzione che restituisce l'anno da una data completa
    HOUR(data) -> Funzione che restituisce l'ora da una data completa
    MINUTE(data) -> Funzione che restituisce i minuti da una data completa
    SECOND(data) -> Funzione che restituisce i secondi da una data completa
    
    Advanced function
    ISNULL(column_name) -> Funzione che restitisce true o false in base al valore null presente in una colonna
    LAST_INSERT_ID() -> Funzione che restitisce l'ultimo valore ID inserito in una tabella
    
  */
  
  /*
	INNER JOIN | LEFT JOIN | RIGHT JOIN | CROSS JOIN
    
    SELECT [DISTINCT] column_name1, column_name2, ...., column_nameN | * | aggregate function(expression)
		FROM db_name.table_name1 INNER JOIN db_name.table_name2 ON db_name.table_name1.column_name = db_name.table_name2.column_name
        [WHERE Search Condition]
        [GROUP BY]
        [HAVING Search Condition]
        [ORDER BY]
        [LIMIT]
        
	SELECT [DISTINCT] column_name1, column_name2, ...., column_nameN | * | aggregate function(expression)
		FROM db_name.table_name1 LEFT JOIN db_name.table_name2 ON db_name.table_name1.column_name = db_name.table_name2.column_name
        [WHERE Search Condition]
        [GROUP BY]
        [HAVING Search Condition]
        [ORDER BY]
        [LIMIT]
        
	SELECT [DISTINCT] column_name1, column_name2, ...., column_nameN | * | aggregate function(expression)
		FROM db_name.table_name1 RIGHT JOIN db_name.table_name2 ON db_name.table_name1.column_name = db_name.table_name2.column_name
        [WHERE Search Condition]
        [GROUP BY]
        [HAVING Search Condition]
        [ORDER BY]
        [LIMIT]
        
	SELECT [DISTINCT] column_name1, column_name2, ...., column_nameN | * | aggregate function(expression)
		FROM db_name.table_name1 CROSS JOIN db_name.table_name2 ON db_name.table_name1.column_name = db_name.table_name2.column_name
        [WHERE Search Condition]
        [GROUP BY]
        [HAVING Search Condition]
        [ORDER BY]
        [LIMIT]
     
	-- views
	CREATE [OR REPLACE] VIEW db_name.view_name AS
		SELECT [DISTINCT] column_name1, column_name2, ...., column_nameN | * | aggregate function(expression)
		FROM db_name.table_name1 INNER JOIN db_name.table_name2 ON db_name.table_name1.column_name = db_name.table_name2.column_name
        [WHERE Search Condition]
        [GROUP BY]
        [HAVING Search Condition]
        [ORDER BY]
        [LIMIT]
        
	SELECT * FROM db_name.view_name
    DROP VIEW [IF EXISTS] db_name.view_name
    
    -- Stored porcedures
    DELIMITER &&
		CREATE PROCEDURE db_name.procedure_name [[IN | OUT | INOUT] parameter_name datatype ....]
			BEGIN
				....
			END &&
    DELIMITER;
    
    CALL db_name.procedure_name (parameter/s)
    DROP PROCEDURE [IF EXISTS] db_name.procedure_name
    
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
-- ALTER TABLE agrop053_intro.users DROP COLUMN city;
ALTER TABLE agrop053_intro.users RENAME COLUMN name TO firstname;
ALTER TABLE agrop053_intro.users MODIFY COLUMN fiscal_code CHAR(16);
ALTER TABLE agrop053_intro.users ADD CONSTRAINT fiscal_code_uk UNIQUE(fiscal_code);
-- ALTER TABLE agrop053_intro.users DROP CONSTRAINT email_uk;

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
    car_license_plate CHAR(7) NOT NULL UNIQUE,
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

-- Operazioni DDL
INSERT INTO agrop053_intro.users (firstname, lastname, age, email, phone, fiscal_code, city) 
						VALUES  ("Mario", "Rossi", 25, "m.rossi@example.com", "321.654983", "AB123CD2E5F6548A", "Roma"),
								("Giuseppe", "Verdi", 49, "g.verdi@example.com", "369.456123", "AB456CD2E5F6548B", "Napoli"),
                                ("Francesca", "Neri", 32, "f.neri@example.com", "987.412365", "AB987CD2E5F6548C", "Roma"),
                                ("Antonio", "Bianchi", 22, "a.bianchi@example.com", "369.236128", "AB147CD2E5F6548D", null),
                                ("Marta", "Viola", 37, "m.viola@example.com", "987.369361", "AB852CD2E5F6548F", "Milano"),
                                ("Luigi", "Gialli", 19, "l.gialli@example.com", "321.459678", "CD147CD2E5F6548P", "Napoli");

INSERT INTO agrop053_intro.signin (username, password, user_id) 
						VALUES  ("mariorossi", "Qwerty", 1),
								("francescaneri", "Pa$$w0rd!", 3);
                                
INSERT INTO agrop053_intro.cars (car_name, car_license_plate, user_id) 
						VALUES  ("Fiat Panda", "AB123CD", 1),
								("Ford Fiesta", "AC654RE", 2),
                                ("Renault Clio", "AG852GB", 1);
			
INSERT INTO agrop053_intro.courses 	(course_name, course_hours)
						VALUES		("Java", 250), ("Python", 100), 
									("SQL", 50), ("Javascript", 150), ("Php", 100);

INSERT INTO agrop053_intro.users_courses(user_id, course_id) 
						VALUES (1,5), (3,5), (1,4), (2, 1), (3, 2), (2, 3);
                        
INSERT INTO agrop053_intro.users_courses(user_id, course_id) 
						VALUES (1,2);
                        
-- UPDATE agrop053_intro.cars SET car_name = "Fiat Punto" WHERE car_id = 1;

-- DELETE FROM agrop053_intro.signin WHERE user_id = 1;
-- DELETE FROM agrop053_intro.courses WHERE course_id = 2;
-- DELETE FROM agrop053_intro.users WHERE user_id = 1;
                        
-- SELECT * FROM agrop053_intro.users;
-- SELECT * FROM agrop053_intro.signin;
-- SELECT * FROM agrop053_intro.cars;
-- SELECT * FROM agrop053_intro.courses;
-- SELECT * FROM agrop053_intro.users_courses;

-- SELECT * FROM agrop053_intro.users;
-- SELECT firstname, lastname FROM agrop053_intro.users;
-- SELECT firstname, lastname, age FROM agrop053_intro.users WHERE age > 30;
-- SELECT city, count(*) FROM agrop053_intro.users GROUP BY city;
-- SELECT city, count(*) FROM agrop053_intro.users GROUP BY city HAVING count(*) > 1;
/*  city, count(*) 
		FROM agrop053_intro.users 
        WHERE NOT ISNULL(city) 
        GROUP BY city 
        HAVING count(*) > 1
        ORDER BY city
        LIMIT 1;
*/

-- SELECT * FROM agrop053_intro.users;
SELECT firstname, lastname FROM agrop053_intro.users;
SELECT firstname, lastname, age, city FROM agrop053_intro.users WHERE city = "Roma";
SELECT firstname, lastname, age FROM agrop053_intro.users WHERE age > 30;
SELECT firstname, lastname, age, city FROM agrop053_intro.users WHERE city != "Roma";
SELECT firstname, lastname, age, city FROM agrop053_intro.users WHERE city != "Roma" AND age > 30;
SELECT firstname, lastname, age, city FROM agrop053_intro.users WHERE city != "Roma" OR age > 30;
SELECT * FROM agrop053_intro.users WHERE lastname LIKE "V%";
SELECT * FROM agrop053_intro.users WHERE email LIKE "%.com";
SELECT * FROM agrop053_intro.users WHERE email LIKE "m%.com";
SELECT * FROM agrop053_intro.users WHERE email LIKE "_.v%@%.c_m";
SELECT firstname, lastname, age FROM agrop053_intro.users WHERE age BETWEEN 25 AND 40;
SELECT firstname, lastname, age, city FROM agrop053_intro.users WHERE city IN ("Roma", "Torino", "Milano");
SELECT firstname, lastname, age, city FROM agrop053_intro.users WHERE city NOT IN ("Roma", "Torino", "Milano");
SELECT UPPER(firstname), LOWER(lastname) FROM agrop053_intro.users;
SELECT * FROM agrop053_intro.users WHERE LENGTH(city) > 5;
SELECT CONCAT(firstname, " ", lastname, " age:", age)  FROM agrop053_intro.users;
SELECT COUNT(*) FROM agrop053_intro.users WHERE LENGTH(city) > 5;
SELECT MAX(age) FROM agrop053_intro.users;
SELECT MIN(age) FROM agrop053_intro.users;
SELECT SUM(age) FROM agrop053_intro.users;
SELECT AVG(age) FROM agrop053_intro.users;
SELECT FORMAT(AVG(age),2) FROM agrop053_intro.users;
SELECT TRUNCATE(AVG(age),2) FROM agrop053_intro.users;
SELECT COUNT(LAST_INSERT_ID()) FROM agrop053_intro.users;

SELECT * FROM agrop053_intro.users;
SELECT * FROM agrop053_intro.signin;

-- SELECT * FROM agrop053_intro.users AS u, agrop053_intro.signin AS s WHERE u.user_id = s.user_id;
SELECT u.firstname, u.lastname, u.email, s.username, s.password
	FROM agrop053_intro.users AS u 
	INNER JOIN agrop053_intro.signin AS s
    ON u.user_id = s.user_id
    WHERE u.age > 30;
    
SELECT *
	FROM agrop053_intro.users AS u 
	LEFT JOIN agrop053_intro.signin AS s
    ON u.user_id = s.user_id;
    
SELECT *
	FROM agrop053_intro.signin AS s
	RIGHT JOIN agrop053_intro.users AS u 
    ON u.user_id = s.user_id;
    
SELECT *
	FROM agrop053_intro.users AS u 
	CROSS JOIN agrop053_intro.signin AS s
    ON u.user_id = s.user_id;
    
SELECT * 
	FROM agrop053_intro.users AS u 
    LEFT JOIN agrop053_intro.signin AS s ON u.user_id = s.user_id
    LEFT JOIN agrop053_intro.cars AS c ON u.user_id = c.user_id;
 
SELECT firstname, lastname, fiscal_code, COUNT(*) AS NumeroCorsi
	FROM agrop053_intro.users_courses AS uc
    LEFT JOIN agrop053_intro.users AS u ON u.user_id = uc.user_id
    LEFT JOIN agrop053_intro.courses as c ON c.course_id = uc.course_id
    WHERE c.course_name IN ("Php", "SQL", "Java", "Python")
    GROUP BY fiscal_code
    HAVING COUNT(*) > 1;
    
-- Views

CREATE VIEW agrop053_intro.mia_vista AS 
	SELECT firstname, lastname, fiscal_code, COUNT(*) AS NumeroCorsi
	FROM agrop053_intro.users_courses AS uc
    LEFT JOIN agrop053_intro.users AS u ON u.user_id = uc.user_id
    LEFT JOIN agrop053_intro.courses as c ON c.course_id = uc.course_id
    WHERE c.course_name IN ("Php", "SQL", "Java", "Python")
    GROUP BY fiscal_code
    HAVING COUNT(*) > 1;
    
SELECT * FROM agrop053_intro.mia_vista;

-- Stored Procedures
DELIMITER &&
	CREATE PROCEDURE agrop053_intro.getUsers()
		BEGIN
			SELECT * FROM agrop053_intro.users;
		END &&
DELIMITER ;

CALL agrop053_intro.getUsers();

-- Stored Procedures con parametri di INPUT
DELIMITER &&
	CREATE PROCEDURE agrop053_intro.getUsersOverAge(IN myage INT, IN mycity VARCHAR(100))
		BEGIN
			SELECT * FROM agrop053_intro.users WHERE age > myage AND city = mycity;
		END &&
DELIMITER ;
-- DROP PROCEDURE agrop053_intro.getUsersOverAge;

CALL agrop053_intro.getUsersOverAge(20, "Roma");
CALL agrop053_intro.getUsersOverAge(30, "Napoli");
CALL agrop053_intro.getUsersOverAge(40, "Milano");

-- Stored Procedures con parametri di OUTPUT
DELIMITER &&
	CREATE PROCEDURE agrop053_intro.countUsers(OUT usercount INT)
		BEGIN
			SELECT COUNT(*) INTO usercount FROM agrop053_intro.users;
		END &&
DELIMITER ;
CALL agrop053_intro.countUsers(@usercount);
SELECT @usercount;

-- Stored Procedures con parametri di INPUT e OUTPUT
DELIMITER &&
	CREATE PROCEDURE agrop053_intro.getAVGuserCity(IN mycity VARCHAR(100), OUT avgage DOUBLE )
		BEGIN
			SELECT AVG(age) INTO avgage FROM agrop053_intro.users WHERE city = mycity;
		END &&
DELIMITER ;

SET @mycity = "Milano";
CALL agrop053_intro.getAVGuserCity(@mycity, @avgage);
SELECT @avgage;

-- Stored Procedures con parametri di INOUT
DELIMITER &&
	CREATE PROCEDURE agrop053_intro.countOverAge(INOUT num INT)
		BEGIN
			SELECT COUNT(*) INTO num FROM agrop053_intro.users WHERE age > num;
		END &&
DELIMITER ;
SET @num = 20;
CALL agrop053_intro.countOverAge(@num);
SELECT @num;