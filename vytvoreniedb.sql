ALTER database pisdb default character set utf8 default collate utf8_slovak_ci;

CREATE TABLE rola(
	id INT NOT NULL AUTO_INCREMENT,
	nazov VARCHAR(30),
	PRIMARY KEY(id)
)ENGINE=INNODB  CHARACTER SET utf8 COLLATE utf8_slovak_ci;

CREATE TABLE zamestnanec(
	id INT NOT NULL AUTO_INCREMENT,
	meno VARCHAR(20),
	priezvisko VARCHAR(50) COLLATE utf8_slovak_ci,
	rola INT,
	aktivny INT,
	login VARCHAR(100),
	heslo VARCHAR(200),
	osobne_cislo INT,
	PRIMARY KEY (id),
	FOREIGN KEY (rola)
		REFERENCES rola(id)
)ENGINE=INNODB DEFAULT CHARSET utf8 COLLATE utf8_slovak_ci ;


CREATE TABLE maerz(
	id INT NOT NULL AUTO_INCREMENT,
	neodstranene_poruchy VARCHAR(1000),
	-- zasoby
	zasobnik_1_druh INT,
	zasobnik_1_plnenie INT,
	zasobnik_2_druh INT,
	zasobnik_2_plnenie INT,
	zasobnik_5_druh INT,
	zasobnik_5_plnenie INT,
	zasobnik_nova_lanovka_druh INT,
	zasobnik_nova_lanovka_plnenie INT,
	-- vyroba
	vyroba_vapno_6_plan FLOAT,
	vyroba_vapno_6_skut FLOAT,
	vyroba_vapno_17_plan FLOAT,
	vyroba_vapno_17_skut FLOAT,
	vyroba_vapno_35_plan FLOAT,
	vyroba_vapno_35_skut FLOAT,
	vyroba_vapenec_vsadzka_6_skut FLOAT,
	vyroba_vapenec_vsadzka_6_frakcia_vapenca VARCHAR(15),
	vyroba_vapenec_vsadzka_17_skut FLOAT,
	vyroba_vapenec_vsadzka_17_frakcia_vapenca VARCHAR(15),
	vyroba_vapenec_vsadzka_35_skut FLOAT,
	vyroba_vapenec_vsadzka_35_frakcia_vapenca VARCHAR(15),
	
	chod_pece FLOAT,
	
	briketizacka_poc_stav FLOAT,
	briketizacka_kon_stav FLOAT,
	filter_M20_poc_stav FLOAT,
	filter_M20_kon_stav FLOAT,

	kontrola_ochrannych_krytov VARCHAR(150),
	stav_potrubia_vzduchotechniky VARCHAR(150),
	stav_obeznych_kolies_ventilatorov VARCHAR(150),
	stav_izolatorov_ventilatorov VARCHAR(150),
	vysledok_kontroly_technologickeho_zariadenia VARCHAR(300),
	
	vstup_tepla VARCHAR(100),
	teplota_pyrometra VARCHAR(100),
	
	pracovna_snimka_strojnik VARCHAR(1000),
	pracovna_snimka_velinar VARCHAR(1000),
	
	stav_lekarnicky VARCHAR(300),
	
	PRIMARY KEY (id)
)ENGINE=INNODB  CHARACTER SET utf8 COLLATE utf8_slovak_ci ;

CREATE TABLE zam_maerz(
	id INT NOT NULL AUTO_INCREMENT,
	datum DATE,
	zmena INT,
	id_velinar INT,
	FOREIGN KEY (id_velinar)
		REFERENCES zamestnanec(id),
	id_majster INT,
	FOREIGN KEY (id_majster)
		REFERENCES zamestnanec(id),
	id_strojnik INT,
	FOREIGN KEY (id_strojnik)
		REFERENCES zamestnanec(id),
	id_maerz INT NOT NULL,
	FOREIGN KEY (id_maerz)
		REFERENCES maerz(id),
	PRIMARY KEY(id)
)ENGINE=INNODB  CHARACTER SET utf8 COLLATE utf8_slovak_ci;

--CREATE TABLE pracovna_snimka(
--	id INT NOT NULL AUTO_INCREMENT,
--	odkedy TIME,
--	dokedy TIME,
--    popis VARCHAR(1000),
--	id_maerz INT NOT NULL,
--	FOREIGN KEY (id_maerz)
--		REFERENCES maerz(id),
--	id_rola INT NOT NULL,
--	FOREIGN KEY (id_rola)
--		REFERENCES rola(id),
--	PRIMARY KEY(id)
--)ENGINE=INNODB;

CREATE TABLE odprasovanie(
	id INT NOT NULL AUTO_INCREMENT,
	id_maerz INT NOT NULL,
	FOREIGN KEY (id_maerz)
		REFERENCES maerz(id),
		
	scheuch_cas FLOAT,
	scheuch_podtlak FLOAT,
	scheuch_membranove_ventily VARCHAR(150),
	scheuch_sneky VARCHAR(150),
	
	M10_cas FLOAT,
	M10_podtlak FLOAT,
	M10_datum_zmeny_hadic DATE,
	M10_funkcnost_tesnost VARCHAR(150),
	
	M117_cas FLOAT,
    M117_podtlak FLOAT,
	M117_datum_zmeny_hadic DATE,
	M117_funkcnost_tesnost VARCHAR(150),
	
	M116_cas FLOAT,
	M116_podtlak FLOAT,
	M116_datum_zmeny_hadic DATE,
    M116_funkcnost_tesnost VARCHAR(150),
	
	M12_cas FLOAT,
	M12_podtlak FLOAT,
	M12_datum_zmeny_hadic DATE,
	M12_funkcnost_tesnost VARCHAR(150),
	
	M115_cas FLOAT,
	M115_funkcnost_oklepavacieho_zariadenia VARCHAR(150),
	M115_chod_snekoveho_dopravnika VARCHAR(150),
	M115_funkcnost_celistvost VARCHAR(150),
	
	herding_cas FLOAT,
	herding_cistiace_impulzy VARCHAR(150),
	herding_chod_vyprazdnovacieho_zariadenia VARCHAR(150),	
	
	PRIMARY KEY(id)
)ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_slovak_ci ;

--CREATE TABLE kontrola_1zmena (
--	id INT NOT NULL AUTO_INCREMENT,
--	poistny_ventil_kontrola INT,
--	poistny_ventil_zavada INT,
--	tlakomer_kontrola INT,
--	tlakomer_zavada INT,
--	PRIMARY KEY (id)
--)ENGINE=INNODB;
--
--CREATE TABLE pracovna_snimka_1zmena(
--	id INT NOT NULL AUTO_INCREMENT,
--	id_maerz INT NOT NULL,
--	FOREIGN KEY (id_maerz)
--		REFERENCES maerz(id),
--	tlak_nadoba_62384 INT,
--	FOREIGN KEY (tlak_nadoba_62384)
--		REFERENCES kontrola_1zmena(id),
--	tlak_nadoba_62400 INT,
--	FOREIGN KEY (tlak_nadoba_62400)
--		REFERENCES kontrola_1zmena(id),
--	tlak_nadoba_susica INT,
--	FOREIGN KEY (tlak_nadoba_susica)
--		REFERENCES kontrola_1zmena(id),
--	tlak_nadoba_vs_776 INT,
--	FOREIGN KEY (tlak_nadoba_vs_776)
--		REFERENCES kontrola_1zmena(id),
--	tlak_nadoba_vzduch_delo_5269 INT,
--	FOREIGN KEY (tlak_nadoba_vzduch_delo_5269)
--		REFERENCES kontrola_1zmena(id),
--	tlak_nadoba_vzduch_delo_5270 INT,
--	FOREIGN KEY (tlak_nadoba_vzduch_delo_5270)
--		REFERENCES kontrola_1zmena(id),
--	tlak_nadoba_vzduch_delo_5271 INT,
--	FOREIGN KEY (tlak_nadoba_vzduch_delo_5271)
--		REFERENCES kontrola_1zmena(id),
--	tlak_nadoba_vzduch_delo_5272 INT,
--	FOREIGN KEY (tlak_nadoba_vzduch_delo_5272)
--		REFERENCES kontrola_1zmena(id),
--	PRIMARY KEY(id)
--)ENGINE=INNODB;


