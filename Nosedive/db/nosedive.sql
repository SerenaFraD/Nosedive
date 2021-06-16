DROP DATABASE IF EXISTS Nosedive;

CREATE DATABASE Nosedive;
USE Nosedive;

DROP USER IF EXISTS 'nosedive'@'localhost';
CREATE USER 'nosedive'@'localhost' IDENTIFIED BY 'Admin';
GRANT ALL ON Nosedive.* TO 'nosedive'@'localhost';

CREATE TABLE Utente ( 
	id_utente INT NOT NULL AUTO_INCREMENT,
	email VARCHAR(25) NOT NULL,
    pwd VARCHAR(255) NOT NULL,
    sup BOOL NOT NULL DEFAULT FALSE,

    PRIMARY KEY(id_utente)
);

CREATE TABLE Informazione (
	id_utente INT NOT NULL AUTO_INCREMENT,
	compleanno DATE NOT NULL,
    punteggio INT NOT NULL, -- Da modificare con il valore di default
	id_relazione INT NOT NULL,
	id_lavoro INT NULL,
	propic BLOB, -- Vedere meglio per le immagini
    sesso BOOL NOT NULL DEFAULT FALSE, -- Definire cos è false
	deceduto BOOL NOT NULL DEFAULT FALSE,

	FOREIGN KEY(id_utente) REFERENCES Utente(id_utente)
);

CREATE TABLE Azione (
	id_azione INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    punteggio INT NOT NULL,
    
    PRIMARY KEY(id_azione)
);

CREATE TABLE Relazione (
	id_relazione INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    punteggio INT NOT NULL,
    
    PRIMARY KEY(id_relazione)
);
	
CREATE TABLE Lavoro (
	id_lavoro INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    punteggio INT NOT NULL,
    
    PRIMARY KEY(id_lavoro)
);

CREATE TABLE UtenteAzione (
	id_utente INT NOT NULL,
    id_azione INT NOT NULL,

    PRIMARY KEY(id_utente, id_azione),
    FOREIGN KEY(id_utente) REFERENCES Utente(id_utente),
    FOREIGN KEY(id_azione) REFERENCES Azione(id_azione)
);

CREATE TABLE Post (
	id_post INT NOT NULL,
    id_utente INT NOT NULL,
    datapubb DATETIME NOT NULL,
    postpic BLOB, -- modificare con tipo di dato adeguato
    testo VARCHAR(255) NOT NULL,

    PRIMARY KEY(id_post, id_utente),
    FOREIGN KEY(id_utente) REFERENCES Utente(id_utente)
);

CREATE TABLE Commento (
	id_commento INT NOT NULL,
    id_commentatore INT NOT NULL,
	id_post INT NOT NULL,
    id_utente INT NOT NULL,
    datapubb DATETIME NOT NULL,
    testo VARCHAR(255) NOT NULL,

    PRIMARY KEY(id_commento),
    UNIQUE (id_post, id_commento, id_utente, id_commentatore),
    FOREIGN KEY(id_post) REFERENCES Post(id_post),
    FOREIGN KEY(id_commentatore) REFERENCES Utente(id_utente),
    FOREIGN KEY(id_utente) REFERENCES Utente(id_utente)
);

CREATE TABLE UtenteSeguito (
	id_utente INT NOT NULL,
    id_seguito INT NOT NULL,
    
    FOREIGN KEY(id_seguito) REFERENCES Utente(id_utente),
    FOREIGN KEY(id_utente) REFERENCES Utente(id_utente)
);
