USE mydb;

INSERT INTO 
Postnumre (postnummer, bynavn)
VALUES
(2750,'Ballerup'),
(2000,'Frederiksberg'),
(2800, 'Kongens Lyngby');

INSERT INTO 
Bruger (email, navn, efternavn, telefonNummer, adresse, postnummer)
VALUES 
('test1@test.dk','Hans','Hansen',11223344,'Torskevej 1',2750),
('test2@test.dk','Tom','Tomsen',44332211,'Sildevej 2',2000),
('test3@test.dk','Hanne','Hannesen',11112233,'Makrelvej 3',2800),
('test4@test.dk','Pernille','Pernillesen',44443322,'Spættevej 4',2800);

INSERT INTO
Forespørgsel (id,carportHøjde,carportLængde,carportBredde,redskabsRumBredde,redskabsRumLængde,tagType,hældning,kommentarKunde,kommentarAnsat,tidsHorisont,`status`,email)
VALUES
(1,320,420,320,320,120,'fladt',null,null,null,null,'ny','test1@test.dk'),
(2,320,470,360,360,220,'fladt',null,'Kan der vælges andre tag-materialer end det viste?',null,'2017-12-24','ny','test2@test.dk'),
(1,320,420,320,null,null,'rejsning','15',null,null,null,'behandlet','test3@test.dk'),
(1,320,570,410,null,null,'fladt',null,null,'Kontakt vedr. valg af trætype','2017-07-14','behandlet','test1@test.dk');

INSERT INTO
Vare (varenummer,navn,kategori,pris,længde,bredde,højde)
VALUES
(0001,'søjle','søjle',500,510,20,20),
(0002,'bræt','bræt',203,470,50,35),
(0003,'skrue','skrue',1.5,2,0.5,3),
(0004,'tagsten','tagsten',3,5,5,5),
(0005,'Søm','Søm',0.5,2,0.5,3),
(0006,'Hammer','Værktøj',240,20,5,7);