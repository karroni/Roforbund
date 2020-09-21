

# Dette trenger kun å kjøre om dere ikke har en schema (en database partisjon.)
#lager databasen om den ikke finnes. navnet er bare tilfeldig.
CREATE DATABASE if not EXISTS otra;


#denne må dere kjøre for at skript filen skal skjønne at
# <otra> er databasen dere vil lage tables og inserte data i.
USE otra;


#alt under her må kjøres for at eksemplet jeg har lagd skal kunne kjøre.

#lager table Users i databasen otra
create table if not EXISTS otra.users
(
    User_id        integer UNIQUE auto_increment,
    Klubb_id       int(20),
    User_firstName varchar(255),
    User_lastName  varchar(255),
    User_email     varchar(255),
    User_password  varchar(255),
    User_role      int(1),
    CONSTRAINT U_User_ID_PK PRIMARY KEY (User_id),
    FOREIGN KEY (Klubb_id) REFERENCES klubber(Klubb_id)
);


create table if not EXISTS otra.ovelser
(
    Ovelse_ID      integer UNIQUE auto_increment,
    Ovelse_navn    varchar(255),
    CONSTRAINT U_User_ID_PK PRIMARY KEY (Ovelse_ID)
);

create table if not EXISTS otra.klubber
(
    Klubb_id    integer UNIQUE auto_increment,
    Navn        varchar(255),
    Adresse     varchar(255),
    Postnr      int(255),
    Poststed    varchar(255),
    Tlf         varchar(255),
    CONSTRAINT U_User_ID_PK PRIMARY KEY (Klubb_id)
);

create table if not EXISTS otra.resultater
(
    ResultatID      integer UNIQUE auto_increment,
    OvelseID        int,
    TestID          int,
    UserID          int,
    TidSekunder     int(5),
    Watt            int(5),
    Kg              int(5),
    Repetisjoner    int(5),
    CONSTRAINT U_User_ID_PK PRIMARY KEY (resultatID),
    FOREIGN KEY (OvelseID) REFERENCES ovelser(Ovelse_ID),
    FOREIGN KEY (TestID) REFERENCES tester(TestID),
    FOREIGN KEY (UserID) REFERENCES users(User_id)
);

create table if not EXISTS otra.tester
(
    TestID      integer UNIQUE auto_increment,
    Godkjent    boolean,
    Dato        long,
    CONSTRAINT U_User_ID_PK PRIMARY KEY (TestID)
);


#inserter en record av en bruker inn i databasen otra.
insert into otra.users (Klubb_id,User_firstName,User_lastName,User_email,User_password,User_role)
values (1,'Johan','Svartdal','johan@roing.no','root',0);

insert into otra.users (Klubb_id,User_firstName,User_lastName,User_email,User_password,User_role)
values (1,'Sanna','Hullbakviken','sanna@roing.no','root',0);

insert into otra.users (Klubb_id,User_firstName,User_lastName,User_email,User_password,User_role)
values (2,'Jørgen','Myrbråten','jorgenmyr@roing.no','root',0);

insert into otra.users (Klubb_id,User_firstName,User_lastName,User_email,User_password,User_role)
values (1,'Torgeir','Hansen','torgeir@roing.no','root',1);

insert into otra.users (Klubb_id,User_firstName,User_lastName,User_email,User_password,User_role)
values (2,'Jan','Teigen','teigen@roing.no','root',1);

insert into otra.users (Klubb_id,User_firstName,User_lastName,User_email,User_password,User_role)
values (null,'Superuser','Super','superuser@roing.no','root',2);



insert into otra.klubber(Navn, Adresse, Postnr, Poststed, Tlf)
values ('Sarpsborg roklubb', 'Sarpsborgveien 13', 3412, 'Sarpsborg', '40640382');

insert into otra.klubber(Navn, Adresse, Postnr, Poststed, Tlf)
values ('Drammen Roforening', 'Cappelens Gate 61', 3015, 'Drammen', '46968676');



insert into otra.resultater (OvelseID, TestID, userID, TidSekunder, Watt, Kg, Repetisjoner)
values (1, 1, 1, 840, 10, 80, 1);

insert into otra.resultater (OvelseID, TestID, userID, TidSekunder, Watt, Kg, Repetisjoner)
values (3, 1, 1, 40, 9, 15, 17);

insert into otra.resultater (OvelseID, TestID, userID, TidSekunder, Watt, Kg, Repetisjoner)
values (4, 1, 1, 10, 7, 10, 1);

insert into otra.resultater (OvelseID, TestID, userID, TidSekunder, Watt, Kg, Repetisjoner)
values (1, 1, 2, 900, 9, 70, 1);

insert into otra.resultater (OvelseID, TestID, userID, TidSekunder, Watt, Kg, Repetisjoner)
values (3, 1, 2, 40, 9, 15, 17);

insert into otra.resultater (OvelseID, TestID, userID, TidSekunder, Watt, Kg, Repetisjoner)
values (4, 1, 2, 10, 7, 10, 1);

insert into otra.resultater (OvelseID, TestID, userID, TidSekunder, Watt, Kg, Repetisjoner)
values (2, 2, 3, 30, 15, 5, 20);



insert into otra.ovelser (Ovelse_navn)
values ('3000m');

insert into otra.ovelser (Ovelse_navn)
values ('Pushups');

insert into otra.ovelser (Ovelse_navn)
values ('Spensthopp');

insert into otra.ovelser (Ovelse_navn)
values ('Spurting');


insert into otra.tester (Godkjent, Dato)
values (true, 1700);

insert into otra.tester (Godkjent, Dato)
values (true, 1800);