DROP DATABASE IF EXISTS Nosedive;

CREATE DATABASE Nosedive;
USE Nosedive;

DROP USER IF EXISTS 'nosedive'@'localhost';
CREATE USER 'nosedive'@'localhost' IDENTIFIED BY 'Admin';
GRANT ALL ON Nosedive.* TO 'nosedive'@'localhost';

CREATE TABLE Utente ( 
	id_utente INT NOT NULL AUTO_INCREMENT,
	email VARCHAR(25) NOT NULL,
	nome VARCHAR(25) NOT NULL,
    pwd VARCHAR(255) NOT NULL,
    sup BOOL NOT NULL DEFAULT FALSE,

    PRIMARY KEY(id_utente)
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

CREATE TABLE Informazione (
	id_utente INT NOT NULL AUTO_INCREMENT,
	compleanno DATE,
    punteggio INT NOT NULL DEFAULT '1000', 
	id_relazione INT NOT NULL,
	id_lavoro INT NULL,
	propic MEDIUMBLOB, 
    sesso BOOL NOT NULL DEFAULT FALSE, -- false = maschio
	deceduto BOOL NOT NULL DEFAULT FALSE, -- false = utente in vita

	FOREIGN KEY(id_utente) REFERENCES Utente(id_utente)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE Azione (
	id_azione INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    punteggio INT NOT NULL,
    
    PRIMARY KEY(id_azione)
);

CREATE TABLE UtenteAzione (
	id_utente INT NOT NULL,
    id_azione INT NOT NULL,

    FOREIGN KEY(id_utente) REFERENCES Utente(id_utente)
		ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY(id_azione) REFERENCES Azione(id_azione)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE Post (
	id_post INT NOT NULL AUTO_INCREMENT,
    id_utente INT NOT NULL,
    timestamp datetime not null,
    postpic MEDIUMBLOB,
    testo VARCHAR(255) NOT NULL,

    PRIMARY KEY(id_post, id_utente),
    FOREIGN KEY(id_utente) REFERENCES Utente(id_utente)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE Commento (
	id_commento INT NOT NULL AUTO_INCREMENT,
    id_commentatore INT NOT NULL,
	id_post INT NOT NULL,
    id_utente INT NOT NULL,
    timestamp datetime not null,
    testo VARCHAR(255) NOT NULL,

    PRIMARY KEY(id_commento),
    UNIQUE (id_post, id_commento, id_utente, id_commentatore),
    FOREIGN KEY(id_post) REFERENCES Post(id_post)
		ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY(id_commentatore) REFERENCES Utente(id_utente)
		ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY(id_utente) REFERENCES Utente(id_utente)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE UtenteSeguito (
	id_utente INT NOT NULL,
    id_seguito INT NOT NULL,
    
    FOREIGN KEY(id_seguito) REFERENCES Utente(id_utente)
		ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY(id_utente) REFERENCES Utente(id_utente)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);
    
-- Inserimento Utenti
INSERT INTO Utente(email,nome,pwd,sup) VALUES ('risi@gmail.com','Prof. Michele Risi',sha1("prova"),0);
INSERT INTO Utente(email,nome,pwd,sup) VALUES ('serena@gmail.com','Serena',sha1("prova"),1);
INSERT INTO Utente(email,nome,pwd,sup) VALUES ('paolo@gmail.com','Paolo',sha1("prova"),0);
INSERT INTO Utente(email,nome,pwd,sup) VALUES ('riccardo@gmail.com','Riccardo',sha1("prova"),1);
INSERT INTO Utente(email,nome,pwd,sup) VALUES ('Vincenzo@gmail.com','Vincenzo',sha1("prova"),0);

-- Inserimento relazioni
INSERT INTO Relazione(nome, punteggio) VALUES ('sposato', 150);
INSERT INTO Relazione(nome, punteggio) VALUES ('fidanzato', 100);
INSERT INTO Relazione(nome, punteggio) VALUES ('single', 10);

-- Inserimento lavori   
INSERT INTO Lavoro(nome, punteggio) VALUES ('Docente', 200);
INSERT INTO Lavoro(nome, punteggio) VALUES ('Disoccupato', 10);
INSERT INTO Lavoro(nome, punteggio) VALUES ('Studente', 100);
INSERT INTO Lavoro(nome, punteggio) VALUES ('Impiegato', 150);

-- Inserimento informazioni
INSERT INTO Informazione(id_utente,compleanno,punteggio,id_relazione,id_lavoro,propic,sesso,deceduto) VALUES (1,NULL, 2000, 1, 1, NULL, 0, 0);
INSERT INTO Informazione(id_utente,compleanno,punteggio,id_relazione,id_lavoro,propic,sesso,deceduto) VALUES (2,NULL, 2000, 2, 3, NULL, 1, 0);
INSERT INTO Informazione(id_utente,compleanno,punteggio,id_relazione,id_lavoro,propic,sesso,deceduto) VALUES (3,NULL, 2000, 3, 3, NULL, 0, 0);
INSERT INTO Informazione(id_utente,compleanno,punteggio,id_relazione,id_lavoro,propic,sesso,deceduto) VALUES (4,NULL, 2000, 2, 4, NULL, 0, 0);
INSERT INTO Informazione(id_utente,compleanno,punteggio,id_relazione,id_lavoro,propic,sesso,deceduto) VALUES (5,NULL, 2000, 1, 2, NULL, 0, 0);

-- Inserimento Azioni
INSERT INTO Azione(nome, punteggio) VALUES ('Acquisto casa', 200);
INSERT INTO Azione(nome, punteggio) VALUES ('Conseguimento Laurea', 150);
INSERT INTO Azione(nome, punteggio) VALUES ('Furto auto', -100);
INSERT INTO Azione(nome, punteggio) VALUES ('Gioco d/azzardo', -150);
INSERT INTO Azione(nome, punteggio) VALUES ('Volonatariato', 50);
INSERT INTO Azione(nome, punteggio) VALUES ('Aiuto bisognosi', 150);
INSERT INTO Azione(nome, punteggio) VALUES ('Lasciato una buona recensione', 10);

-- Inserimento utente  Azione
INSERT INTO UtenteAzione(id_utente, id_azione) VALUES (1, 1);
INSERT INTO UtenteAzione(id_utente, id_azione) VALUES (1, 2);
INSERT INTO UtenteAzione(id_utente, id_azione) VALUES (1, 5);
INSERT INTO UtenteAzione(id_utente, id_azione) VALUES (3, 3);
INSERT INTO UtenteAzione(id_utente, id_azione) VALUES (3, 2);
INSERT INTO UtenteAzione(id_utente, id_azione) VALUES (2, 2);
INSERT INTO UtenteAzione(id_utente, id_azione) VALUES (4, 4);
INSERT INTO UtenteAzione(id_utente, id_azione) VALUES (4, 3);
INSERT INTO UtenteAzione(id_utente, id_azione) VALUES (4, 3);
INSERT INTO UtenteAzione(id_utente, id_azione) VALUES (4, 3);

-- Inserimento Post
INSERT INTO Post(id_utente, timestamp, postpic, testo) VALUES (1, '2021-07-20 16:04:56', NULL, '30L a questo progetto');
INSERT INTO Post(id_utente, timestamp, postpic, testo) VALUES (1, '2019-12-28 19:00:25', NULL, 'Questo progetto ?? fantastico');
INSERT INTO Post(id_utente, timestamp, postpic, testo) VALUES (2, '2019-12-27 16:04:56', NULL, 'Oggi ?? una bella giornata.');
INSERT INTO Post(id_utente, timestamp, postpic, testo) VALUES (2, '2021-07-20 11:58', NULL, 'Ulisse dorme sul letto.');
INSERT INTO Post(id_utente, timestamp, postpic, testo) VALUES (3, '2021-07-19 01:26', NULL, 'Non riesco a dormire.');
INSERT INTO Post(id_utente, timestamp, postpic, testo) VALUES (4, '2021-07-19 01:26', NULL, 'Odio Nosedive.');

-- Inserimento Commenti
INSERT INTO Commento(id_commentatore, id_post, id_utente, timestamp, testo) VALUES (2, 1, 1, '2021-07-19 09:30', 'Grazie Prof.');
INSERT INTO Commento(id_commentatore, id_post, id_utente, timestamp, testo) VALUES (3, 1, 1, '2021-07-19 09:31', 'Per fortuna');
INSERT INTO Commento(id_commentatore, id_post, id_utente, timestamp, testo) VALUES (4, 2, 4, '2021-07-19 11:59', 'Ulisse mi graffia sempre.');
INSERT INTO Commento(id_commentatore, id_post, id_utente, timestamp, testo) VALUES (4, 1, 1, '2021-07-19 09:30', 'Assolutamente!');

-- Inserimento UtenteSeguito
INSERT INTO UtenteSeguito(id_utente, id_seguito) VALUES (1, 2);
INSERT INTO UtenteSeguito(id_utente, id_seguito) VALUES (1, 3);
INSERT INTO UtenteSeguito(id_utente, id_seguito) VALUES (3, 4);
INSERT INTO UtenteSeguito(id_utente, id_seguito) VALUES (2, 1);
INSERT INTO UtenteSeguito(id_utente, id_seguito) VALUES (3, 1);
INSERT INTO UtenteSeguito(id_utente, id_seguito) VALUES (4, 3);
