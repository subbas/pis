INSERT INTO rola VALUES(1,'velinar');
INSERT INTO rola VALUES(2,'strojnik');
INSERT INTO rola VALUES(3,'veduci_vapenky');
INSERT INTO rola VALUES(4,'majster');
INSERT INTO rola VALUES(5,'ROLE_MAJSTER');

INSERT INTO zamestnanec VALUES(1,'Ján','Boka',4,1,'heslo');
INSERT INTO zamestnanec VALUES(2,'Miroslav','Bučkuliak',1,1,'heslo');
INSERT INTO zamestnanec VALUES(3,'Ján','Zbynovský',2,1,'heslo');
INSERT INTO zamestnanec VALUES(4,'Rudolf','Hošták',4,1,'heslo');
INSERT INTO zamestnanec VALUES(5,'Pavol','Hotera',1,1,'heslo');
INSERT INTO zamestnanec VALUES(6,'Ján','Matej',4,1,'heslo');
INSERT INTO zamestnanec VALUES(7,'Martin','Daniš',1,1,'heslo');
INSERT INTO zamestnanec VALUES(8,'Rudolf','Kmec',2,1,'heslo');
INSERT INTO zamestnanec VALUES(9,'Rudolf','A',5,1,'heslo');

INSERT INTO maerz VALUES(1,'nic',35,70,17,0,6,55,5,100,0,0,0,0,0,22.1,38.1,'40-80',0,null,0,null,1.7,20311.1,20312.7,20311.1,20312.7,'bez zavad','bez zavad','bez zavad','bez zavad','zariadenie schopne prevadzky','bez zavad');
INSERT INTO maerz VALUES(2,'nic',35,68,17,10,6,74,5,100,0,0,0,17.8,0,15.6,57.6,'40-80',0,null,0,null,2.7,20312.7,20316.3,20312.7,20316.3,'bez zavad','bez zavad','bez zavad','bez zavad','zariadenie schopne prevadzky','bez zavad');
INSERT INTO maerz VALUES(3,'nic',35,68,6,40,6,70,5,80,0,112.9,0,3.0,0,0,0,null,199.8,'40-80',0,null,10,20316.3,20319.6,20316.3,20319.6,'bez zavad','bez zavad','bez zavad','bez zavad','zariadenie schopne prevadzky','bez zavad');

INSERT INTO zam_maerz VALUES(1,20140101,1,4,1);
INSERT INTO zam_maerz VALUES(2,20140101,1,5,1);
INSERT INTO zam_maerz VALUES(3,20140101,2,6,2);
INSERT INTO zam_maerz VALUES(4,20140101,2,7,2);
INSERT INTO zam_maerz VALUES(5,20140102,1,1,3);
INSERT INTO zam_maerz VALUES(6,20140102,1,2,3);
INSERT INTO zam_maerz VALUES(7,20140102,1,8,3);

INSERT INTO pracovna_snimka VALUES(1,'06:00:00','07:00:00','kontrola',1,1);
INSERT INTO pracovna_snimka VALUES(2,'07:00:00','08:00:00','nieco',1,1);
INSERT INTO pracovna_snimka VALUES(3,'08:00:00','09:00:00','nieco',1,1);
INSERT INTO pracovna_snimka VALUES(4,'09:00:00','10:00:00','nieco',1,1);
INSERT INTO pracovna_snimka VALUES(5,'10:00:00','11:00:00','nieco',1,1);
INSERT INTO pracovna_snimka VALUES(6,'11:00:00','12:00:00','nieco',1,1);
INSERT INTO pracovna_snimka VALUES(7,'12:00:00','13:00:00','nieco',1,1);
INSERT INTO pracovna_snimka VALUES(8,'06:00:00','07:00:00','kontrola',1,2);
INSERT INTO pracovna_snimka VALUES(9,'07:00:00','08:00:00','nieco',1,2);
INSERT INTO pracovna_snimka VALUES(10,'08:00:00','09:00:00','nieco',1,2);
INSERT INTO pracovna_snimka VALUES(11,'09:00:00','10:00:00','nieco',1,2);
INSERT INTO pracovna_snimka VALUES(12,'10:00:00','11:00:00','nieco',1,2);
INSERT INTO pracovna_snimka VALUES(13,'11:00:00','12:00:00','nieco',1,2);
INSERT INTO pracovna_snimka VALUES(14,'12:00:00','13:00:00','nieco',1,2);

INSERT INTO odprasovanie VALUES(1,1,1.7,6.9,'otvaraju vsetky','funkcne',2.5,0.42,null,'funkcne',0.0,0.61,null,'funkcne',2.0,0.49,null,'funkcne',0,0.58,null,'funkcne',1.1,'funkcne','bez zavad','bez zavad',1.6,'funkcne','funkcne');
INSERT INTO odprasovanie VALUES(2,2,2.7,6.9,'otvaraju vsetky','funkcne',24.1,0.42,null,'funkcne',0.8,0.61,null,'funkcne',24.1,0.49,null,'funkcne',1.8,0.58,null,'funkcne',4.1,'funkcne','bez zavad','bez zavad',3.6,'funkcne','funkcne');
INSERT INTO odprasovanie VALUES(3,3,10,6.9,'otvaraju vsetky','funkcne',10.6,0.42,null,'funkcne',1.5,0.60,null,'funkcne',10.6,0.51,null,'funkcne',8.8,0.54,null,'funkcne',11,'funkcne','bez zavad','bez zavad',3.3,'funkcne','funkcne');

INSERT INTO kontrola_1zmena VALUES(1,1,0,1,0);
INSERT INTO kontrola_1zmena VALUES(2,1,0,1,0);
INSERT INTO kontrola_1zmena VALUES(3,1,0,1,0);
INSERT INTO kontrola_1zmena VALUES(4,1,0,1,0);
INSERT INTO kontrola_1zmena VALUES(5,1,0,1,0);
INSERT INTO kontrola_1zmena VALUES(6,1,0,1,0);
INSERT INTO kontrola_1zmena VALUES(7,1,0,1,0);
INSERT INTO kontrola_1zmena VALUES(8,1,0,1,0);

INSERT INTO pracovna_snimka_1zmena VALUES(1,1,1,2,3,4,5,6,7,8);





