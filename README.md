# Nosedive
Progetto di **Tecnologie Software per lo Sviluppo Web** per il **Corso di Laurea in Informatica** dell'**Università degli Studi di
Salerno**.

***

Studente 			 | Matricola
---------------|-----------
Serena D'Urso  | 0512105709
Riccardo Amaro | 051210

***

## Indice
1. [Obiettivo del progetto](#obiettivo-del-progetto)
2. [Analisi di siti esistenti](#analisi-di-siti-esistenti)
3. [Funzionalità del sito](#funzionalità-del-sito)
4. [Utenti del sito](#utenti-del-sito)
5. [Diagramma navigazionale](#diagramma-navigazionale)
6. [Mappa dei contenuti](#mappa-dei-contenuti)
7. [La base di dati](#la-base-di-dati)
8. [Layout](#layout)
9. [Tema](#tema)
10. [Scelta dei colori](#scelta-dei-colori)
11. [Diagramma navigazionale con le Servlet](#diagramma-navigazionale-con-Servlet)

***

## 1.  Obiettivo del progetto

La piattaforma ‘Nosedive” è un social network rivolto a tutta la popolazione maggiorenne, con lo scopo di monitorare il punteggio relativo ad ogni individuo, basandosi sulle azioni intraprese e lo stile di vita che conduce. Gli utenti presenti iscritti su Nosedive inseriscono le informazioni personali, le azioni intraprese quotidianamente e assegnare votazioni ad altri utenti e il sistema si occuperà di aggiornare il punteggio e di assegnare le penalità, se necessario.
Ogni singolo individuo, in base al punteggio correntemente collegato al suo profilo, deve essere inserito in una categoria della società. 
In base alla categoria alla quale l’individuo è stato assegnato saranno proposti collegamenti (amicizie) differenziati.

***

## 2. Analisi di siti esistenti
Il sito ‘**Nosedive**’ non fa riferimento a nessun sito esistente, ma alla puntata ‘Nosedive’
(episodio 1, stagione 3) della serie Tv ‘Black Mirror’: durante tutto il corso della puntata si possono notare particolari sul funzionamento del sito. 

Ogni utente ha un profilo nel quale è presente la foto profilo, il nome utente e il punteggio corrente. L’utente può caricare foto e creare post sul suo profilo ai quali può essere lasciato un punteggio da una a cinque stelle. Ogni utente può anche lasciare un punteggio ad un utente, indipendentemente da un post o un’immagine. In base al punteggio corrente, l’utente può rientrare in una determinata categoria e relativamente a questo verranno mostrati utenti appartenenti alla stessa categoria. 

Nella serie tv, il punteggio viene utilizzato anche per discriminare la fruizione di servizi da parte dell’utente (aspetto che non verrà implementato).

Il punteggio corrente è calcolato in base al peso relativo ad ogni stella: con un punteggio di una o due stelle vengono sottratti punti, mentre con un punteggio della tre stelle alle cinque vengono aggiunti punti.

Al momento della scrittura di questa proposta di progetto esiste un’app per iphone che implementa la proposta di progetto qui presentata (https://nosediveapp.com/).

***

## 3. Funzionalità del sito	
Il sito Nosedive deve supportare:
- Gestione degli utenti;
- Modifica dei dati personali;
- Mantenimento di una pagina di profilo;
- Gestione del sistema delle amicizie, tramite ‘Follow’;
- Gestione dei post;
- Gestione del punteggio personale;

***

## 4. Utenti del sito	
Gli utenti a cui è rivolto il sito sono:
- **Utente base**: può avere un profilo, caricare post e lasciare votazioni;
- **Utente supervisore (amministratore)**: può visualizzare le statistiche degli utenti e decidere azioni sugli utenti base; La modifica e l’eliminazione degli utenti registrati sul sito. L’admin del sito non necessita di conoscenze di programmazione informatica, in quanto potrà avvalersi di questa interfaccia per gestire gli utenti;
- **Utente non registrato (guest)**: può registrarsi e visualizzare versioni semplificate dei profili degli utenti;

***

## 5. Diagramma navigazionale	

***

## 6. Mappa dei contenuti	

***

## 7. La base di dati	
Il sito Nosedive ha al suo interno alcuni dati che devono essere mantenuti, affinché il suo funzionamento sia valido. 
La persistenza di questi, è stata scelta di dargliela, memorizzando essi in un database relazionale nel quale i dati persistenti vengono rappresentati attraverso delle tabelle, ognuna delle quali è composta da righe (gli elementi, le istanze di ogni dato) e le colonne (attributi, descrizioni di ogni istanza di dato). 
I dati vengono gestiti attraverso MySQL che è un DBMS (Data Base Management System) che permette di manipolare le informazioni che si vogliono controllare sulla base di dati.

![Image text](/Documentazione/ScreenShoot/er.png)

L'immagine sopra presente, descrive quello che è lo schema dei dati che dovranno essere mantenuti nel nostro database in maniera persistente.

All'interno del nostro Data Base, inoltre, sono state salvate anche tutte le immagini che il sito contiene in modo tale da avere una locazione unica dei dati e una "maniera" unica per gestire le stesse.

- Utente

![Image text](/Documentazione/ScreenShoot/utente.jpg)

- Azione

![Image text](/Documentazione/ScreenShoot/azione.jpg)

- UtenteAzione

![Image text](/Documentazione/ScreenShoot/utenteazione.jpg)

- Informazione

![Image text](/Documentazione/ScreenShoot/informazione.jpg)

- Post

![Image text](/Documentazione/ScreenShoot/post.jpg)

- Commento

![Image text](/Documentazione/ScreenShoot/commento.jpg)

- Lavoro

![Image text](/Documentazione/ScreenShoot/lavoro.jpg)

- Relazione

![Image text](/Documentazione/ScreenShoot/relazione.jpg)

***

## 8. Layout

***

## 9. Tema
![Image text](/Documentazione/ScreenShoot/tema.jpg)

***

## 10. Scelta dei colori
![Image text](/Documentazione/ScreenShoot/colori.jpg)

***

## 11. Diagramma navigazionale con le Servlet	

***

#### Documentazione convertita in formato [PDF](Documentazione).
