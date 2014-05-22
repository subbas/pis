<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
<script src="<c:url value="/resources/js/script.js" />"></script>
<title>PIS Maerz</title>
<style>
body {
	background-color: rgb(204, 255, 204);
}

#hlavna-cast {
	background-color: white; border: 2px solid rgb(132, 207, 132); width: 1223px; margin-left: auto; margin-right: auto; font-family: Arial, Verdana; font-size: 14px;
}

#header {
	height: 50px; background-color: rgb(204, 255, 204);
}

.ciara {
	border: 1px solid rgb(132, 207, 132);
}
</style>

</head>
<body onload="noBack();" onunload="">
	<div id="hlavna-cast">

		<form:form id="formular" method="POST" commandName="formular" action="${pageContext.request.contextPath}/add-maerz-form-strojnik.html">
			<div id="header">
			<button type="submit" class="uloz-button">
				<img src="<c:url value="/resources/images/uloz_strojnik.png"/>" class="uloz-obrazok"/>
			</button>
			<a href="${pageContext.request.contextPath}/synchStrojnik.html"><img src="<c:url value="/resources/images/synch_strojnik.png"/>" class="synch-obrazok"/></a>
			<a href="<c:url value="/j_spring_security_logout" />"><img src="<c:url value="/resources/images/odhlas_strojnik.png"/>" class="odhlas-obrazok"/></a>
			
			</div>
			<div class="ciara"></div>
			<div id="obsah">
				<table id="tabulka">
					<tbody id="teloTabulky">
						<tr>
							<td class="prvy-stlpec"></td>
							<td colspan='3' style="font-size: 15px; color: white; background-color: rgb(153, 51, 0);">PIS - Prevádzkový informačný systém pece Maerz</td>
							<td></td>
							<td class="label" colspan='3' style="font-size: 18px;">Neodstránené poruchy</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td class="druhy-stlpec"></td>
							<td class="treti-stlpec"></td>
							<td class="stvrty-stlpec"></td>
							<td class="piaty-stlpec"></td>
							<td class="strojnik" colspan='5' rowspan='18'>
								<form:textarea class="strojnik" path="maerz.neodstranenePoruchy"		cssStyle="width:489px;height:415px;" />
								<spring:bind path="maerz.neodstranenePoruchy">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Prekročili ste dĺžku!" />
										</c:if>
								   </spring:bind>
							</td>

						</tr>
						<tr>
							<td></td>
							<td class="oramovanie-bottom"></td>
							<td></td>
							<td class="strojnik">Vypĺňa strojník</td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie-right">Dátum:</td>
							<td class="velinar oramovanie1">${datum}</td>
							<td></td>
							<td class="velinar" style="text-align: left;">Vypĺňa velinár</td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie-right">Zmena:</td>
							<td class="velinar oramovanie1">${zmena}</td>
							<td></td>
							<td class="veduci" style="text-align:left;">Vypĺňa vedúci vápenky</td>
							<td></td>
						</tr>
						 
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td class="vzorec" style="text-align: left;">Vzorce</td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td class="oramovanie-bottom">Meno</td>
							<td class="oramovanie-bottom">Osobné č.</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie-right">Majster:</td>
							<td class="velinar oramovanie1">${zamMaerz.zamestnanec2}</td>
							<td class="velinar oramovanie1">${zamMaerz.zamestnanec2.osobneCislo}</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie-right">Velinár:</td>
							<td class="velinar oramovanie1">${zamMaerz.zamestnanec1}</td>
							<td class="velinar oramovanie1">${zamMaerz.zamestnanec1.osobneCislo}</td>
							<td></td>
							<td></td>
						</tr>

						<tr>
							<td class="oramovanie-right">Strojník:</td>
							<td class="velinar oramovanie1">${zamMaerz.zamestnanec3}</td>
							<td class="velinar oramovanie1">${zamMaerz.zamestnanec3.osobneCislo}</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td>Zásoby</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td class="oramovanie-bottom"></td>
							<td class="oramovanie-bottom"></td>
							<td class="oramovanie-bottom"></td>
							<td></td>
						</tr>

						<tr>
							<td class="oramovanie-bottom oramovanie-right"></td>
							<td class="oramovanie1">Druh</td>
							<td class="oramovanie1">Plnenie v %</td>
							<td class="oramovanie1">Prepočet na tony</td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie1">Zásobník č.1</td>
							<td class="velinar oramovanie1">${maerz.zasobnik1Druh}</td>
							<td class="velinar oramovanie1">${maerz.zasobnik1Plnenie}</td>
							<td class="vzorec oramovanie1">${D16}</td>
							<td></td>
						</tr>
						
						<tr>
							<td class="oramovanie1">Zásobník č.2</td>
							<td class="velinar oramovanie1">${maerz.zasobnik2Druh}</td>
							<td class="velinar oramovanie1">${maerz.zasobnik2Plnenie}</td>
							<td class="vzorec oramovanie1">${D17}</td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie1">Zásobník č.5</td>
							<td class="velinar oramovanie1">${maerz.zasobnik5Druh}</td>
							<td class="velinar oramovanie1">${maerz.zasobnik5Plnenie}</td>
							<td class="vzorec oramovanie1">${D18}</td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie1">Zásobník nová lanovka</td>
							<td class="velinar oramovanie1">${maerz.zasobnikNovaLanovkaDruh}</td>
							<td class="velinar oramovanie1">${maerz.zasobnikNovaLanovkaPlnenie}</td>
							<td class="vzorec oramovanie1"></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>

						</tr>
						<tr>
							<td></td>
							<td class="oramovanie-bottom"></td>
							<td class="oramovanie-bottom">Výroba</td>
							<td class="oramovanie-bottom"></td>
							<td class="oramovanie-bottom"></td>
							<td class="siesty-stlpec oramovanie-bottom"></td>
							<td class="siedmy-stlpec oramovanie-bottom"></td>
							<td class="osmy-stlpec"></td>
							<td class="deviaty-stlpec"></td>
							<td class="desiaty-stlpec"></td>

						</tr>
						<tr>
							<td class="oramovanie-bottom oramovanie-right"></td>
							<td class="oramovanie1">Plán</td>
							<td class="oramovanie1">Skutočnosť</td>
							<td class="oramovanie1">Percentuálne plnenie</td>
							<td class="oramovanie1">Frakcia 0/16</td>
							<td class="oramovanie1">Frakcia 10/50</td>
							<td class="oramovanie1">Od začiatku mesiaca</td>
							<td></td>
							<td></td>
							<td></td>

						</tr>
						
						<tr>
							<td class="oramovanie1">Vápna 6% v to</td>
							<td class="veduci oramovanie1">${maerz.vyrobaVapno6Plan}</td>
							<td class="velinar oramovanie1">${maerz.vyrobaVapno6Skut}</td>
							<td class="oramovanie1"></td>
							<td class="vzorec oramovanie1">${E23 }</td>
							<td class="vzorec oramovanie1">${F23 }</td>
							<td class="vzorec oramovanie1">${G23 }</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie1">Vápna 17% v to</td>
							<td class="veduci oramovanie1">${maerz.vyrobaVapno17Plan}</td>
							<td class="velinar oramovanie1">${maerz.vyrobaVapno17Skut}</td>
							<td class="oramovanie1"></td>
							<td class="vzorec oramovanie1">${E24 }</td>
							<td class="vzorec oramovanie1">${F24 }</td>
							<td class="vzorec oramovanie1">${G24 }</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie1">Vápna 35% v to</td>
							<td class="veduci oramovanie1">${maerz.vyrobaVapno35Plan}</td>
							<td class="velinar oramovanie1">${maerz.vyrobaVapno35Skut}</td>
							<td class="oramovanie1"></td>
							<td class="vzorec oramovanie1">${E25 }</td>
							<td class="vzorec oramovanie1">${F25 }</td>
							<td class="vzorec oramovanie1">${G25 }</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie1">Vápno spolu v to</td>
							<td class="vzorec oramovanie1">${B26 }</td>
							<td class="vzorec oramovanie1">${C26 }</td>
							<td class="vzorec oramovanie1">${D26 }</td>
							<td></td>
							<td class="oramovanie-right"></td>
							<td class="vzorec oramovanie1">${G26 }</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td class="oramovanie-bottom"></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie-bottom"></td>
							<td class="oramovanie-bottom"></td>
							<td class="oramovanie-bottom oramovanie-right"></td>
							<td class="oramovanie1">Frakcia vápenca</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						
						<tr>
							<td class="oramovanie1">Vápenec vsádzka 6% v to</td>
							<td class="vzorec oramovanie1">${B29 }</td>
							<td class="velinar oramovanie1">${maerz.vyrobaVapenecVsadzka6Skut}</td>
							<td class="velinar oramovanie1">${maerz.vyrobaVapenecVsadzka6FrakciaVapenca}</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie1">Vápenec vsádzka 17% v to</td>
							<td class="vzorec oramovanie1">${B30 }</td>
							<td class="velinar oramovanie1">${maerz.vyrobaVapenecVsadzka17Skut}</td>
							<td class="velinar oramovanie1">${maerz.vyrobaVapenecVsadzka17FrakciaVapenca}</td>
							<td></td>
							<td colspan=2>Briketizačná linka</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie1">Vápenec vsádzka 35% v to</td>
							<td class="vzorec oramovanie1">${B31 }</td>
							<td class="velinar oramovanie1">${maerz.vyrobaVapenecVsadzka35Skut}</td>
							<td class="velinar oramovanie1">${maerz.vyrobaVapenecVsadzka35FrakciaVapenca}</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie1">Vápenec spolu</td>
							<td class="oramovanie1"></td>
							<td class="vzorec oramovanie1">${C32 }</td>
							<td></td>
							<td></td>
							<td class="label oramovanie-bottom">Briketizačka</td>
							<td class="label oramovanie-bottom">Filter M20</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td class="oramovanie-bottom"></td>
							<td></td>
							<td colspan=2 class="oramovanie-right" style="text-align: right;">Počiatočný stav</td>
							<td class="velinar oramovanie1">${maerz.briketizackaPocStav}</td>
							<td class="velinar oramovanie1">${maerz.filter_M20_poc_stav}</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie-bottom oramovanie-right"></td>
							<td class="oramovanie1">V hodinách</td>
							<td></td>
							<td></td>
							<td class="oramovanie-right" style="text-align: right;">Konečný stav</td>
							<td class="velinar oramovanie1">${maerz.briketizackaKonStav}</td>
							<td class="velinar oramovanie1">${maerz.filter_M20_kon_stav}</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie1">Chod pece</td>
							<td class="velinar oramovanie1">${maerz.chodPece}</td>
							<td></td>
							<td colspan=2 class="oramovanie-right" style="text-align: right;">Chod zariadenia</td>
							<td class="vzorec oramovanie1">${F35 }</td>
							<td class="vzorec oramovanie1">${G35 }</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						
						<tr>
							<td class="oramovanie1">Prestoje spolu v hod</td>
							<td class="vzorec oramovanie1">${B36 }</td>
							<td></td>
							<td></td>
							<td class="oramovanie-right" style="text-align: right;">za mesiac</td>
							<td class="vzorec oramovanie1">${F36 }</td>
							<td class="vzorec oramovanie1">${G36 }</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie1 lekarnicka">Stav lekárničky</td>
							<td class="lekarnicka oramovanie1"></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>

						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>

						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>

						</tr>
						<tr>
							<td></td>
							<td></td>
							<td colspan=2>Pracovná snímka dňa</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>

						</tr>
						<tr>
							<td>VELINÁR</td>
							<td></td>
							<td></td>
							<td></td>
							<td>STROJNÍK</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>

						</tr>
						<tr>
							<td>Od</td>
							<td>Do</td>
							<td colspan=2>druh činnosti</td>
							<td>Od</td>
							<td>Do</td>
							<td colspan=4>druh činnosti</td>
						</tr>
						<tr>
							<td class="velinar" colspan=4 rowspan=27 style="text-align:left;">${maerz.pracovnaSnimkaVelinar}</td>
							<td class="strojnik label" colspan=2>Kontrola ochranných krytov:</td>
							<td class="strojnik" colspan=4>
								<form:input class="strojnik vstup sirka2" path="maerz.kontrolaOchrannychKrytov"/>
								<spring:bind path="maerz.kontrolaOchrannychKrytov">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Prekročili ste dĺžku!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>
						
						<tr>
							<td class="strojnik label" colspan=2>Stav potrubia vzduchotechniky:</td>
							<td class="strojnik" colspan=4>
								<form:input class="strojnik vstup sirka2" path="maerz.stavPotrubiaVzduchotechniky"/>
								<spring:bind path="maerz.stavPotrubiaVzduchotechniky">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Prekročili ste dĺžku!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>
						<tr>
							<td class="strojnik label" colspan=2>Stav obežných kolies ventilátorov:</td>
							<td class="strojnik" colspan=4>
								<form:input class="strojnik vstup sirka2" path="maerz.stavObeznychKoliesVentilatorov"/>
								<spring:bind path="maerz.stavObeznychKoliesVentilatorov">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Prekročili ste dĺžku!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>
						<tr>
							<td class="strojnik label" colspan=2>Stav izolátorov ventilov:</td>
							<td class="strojnik" colspan=4>
								<form:input class="strojnik vstup sirka2" path="maerz.stavIzolatorovVentilatorov"/>
								<spring:bind path="maerz.stavIzolatorovVentilatorov">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Prekročili ste dĺžku!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>
						<tr>
							<td class="strojnik label" colspan=6>Výsledok kontroly technologického zariadenia na začiatku zmeny:</td>
						</tr>
						
						<tr>
							<td class="strojnik" colspan=6>
								<form:input class="strojnik vstup" path="maerz.vysledokKontrolyTechnologickehoZariadenia"
									cssStyle="width:545px;" />
								<spring:bind path="maerz.vysledokKontrolyTechnologickehoZariadenia">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Prekročili ste dĺžku!" />
									</c:if>
							   </spring:bind>
							</td>
						</tr>
						<tr>
							<td class="strojnik" colspan=6 rowspan=3>
								<form:textarea class="strojnik vstup" path="maerz.pracovnaSnimkaStrojnik" cssStyle="width:545px;"/>
								<spring:bind path="maerz.pracovnaSnimkaStrojnik">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Prekročili ste dĺžku!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<td class="strojnik" colspan=6></td>
						</tr>
						<tr>
							<td class="strojnik label" colspan=6 style="font-size: 18px; text-decoration: underline;">Kontrola zdrojov, ktoré sa odprašujú:</td>
						</tr>
						<tr>
							<td class="strojnik label" colspan=3>Filter Scheuch, výduch K4</td>
							<td class="strojnik label" colspan=3>Filter M10, výduch V21</td>
						</tr>
						
						<tr>
							<td class="strojnik odprasovanie-label">Chod zariadenia</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.scheuchCas" />
								<spring:bind path="odprasovanie.scheuchCas">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
										</c:if>
								   </spring:bind>
							</td>
							<td class="strojnik odprasovanie-label">Chod zariadenia</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m10_cas" />
								<spring:bind path="odprasovanie.m10_cas">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>
						
						<tr>
							<td class="strojnik odprasovanie-label">Otvárajú všetky membránové ventily</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.scheuchMembranoveVentily" />
								<spring:bind path="odprasovanie.scheuchMembranoveVentily">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Prekročili ste dĺžku!" />
										</c:if>
								   </spring:bind>
							</td>
							<td class="strojnik odprasovanie-label">Podtlak</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m10_podtlak" />
								<spring:bind path="odprasovanie.m10_podtlak">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>
						
						<tr>
							<td class="strojnik odprasovanie-label">Fungujú šneky pre vynášanie prachu</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.scheuchSneky" />
								<spring:bind path="odprasovanie.scheuchSneky">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Prekročili ste dĺžku!" />
										</c:if>
								   </spring:bind>
							</td>
							<td class="strojnik odprasovanie-label">Dátum zmeny hadíc filtra</td>
							
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m10_datum_zmeny_hadic" value="01.01.2014"/>
								<spring:bind path="odprasovanie.m10_datum_zmeny_hadic">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadaný dátum v tvare 01.01.2014!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>
						
						<tr>
							<td class="strojnik odprasovanie-label">Diferenčný podtlak</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.scheuchPodtlak" />
								<spring:bind path="odprasovanie.scheuchPodtlak">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
										</c:if>
								   </spring:bind>
							</td>
							<td class="strojnik odprasovanie-label">Funkčnosť a tesnosť filtra</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m10_funkcnost_tesnost" />
								<spring:bind path="odprasovanie.m10_funkcnost_tesnost">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Prekročili ste dĺžku!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>
						<tr>
							<td class="strojnik label" colspan=3>Filter M117.3, výduch V38</td>
							<td class="strojnik label" colspan=3>Filter M116.1, výduch V39</td>
						</tr>
						<tr>
							<td class="strojnik odprasovanie-label">Chod zariadenia</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m117_cas" />
								<spring:bind path="odprasovanie.m117_cas">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
										</c:if>
								   </spring:bind>
							</td>
							<td class="strojnik odprasovanie-label">Chod zariadenia</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m116_cas" />
								<spring:bind path="odprasovanie.m116_cas">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>
						<tr>
							<td class="strojnik odprasovanie-label">Podtlak</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m117_podtlak" />
								<spring:bind path="odprasovanie.m117_podtlak">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
										</c:if>
								   </spring:bind>
							</td>
							<td class="strojnik odprasovanie-label">Podtlak</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m116_podtlak" />
								<spring:bind path="odprasovanie.m116_podtlak">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>
						<tr>
							<td class="strojnik odprasovanie-label">Dátum zmeny hadíc filtra</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m117_datum_zmeny_hadic"  value="01.01.2014" />
								<spring:bind path="odprasovanie.m117_datum_zmeny_hadic">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadaný dátum v tvare 01.01.2014!" />
										</c:if>
								   </spring:bind>
							</td>
							<td class="strojnik odprasovanie-label">Dátum zmeny hadíc filtra</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m116_datum_zmeny_hadic"  value="01.01.2014"/>
								<spring:bind path="odprasovanie.m116_datum_zmeny_hadic">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadaný dátum v tvare 01.01.2014!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>
						<tr>
							<td class="strojnik odprasovanie-label">Funkčnosť a tesnosť filtra</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m117_funkcnost_tesnost" />
								<spring:bind path="odprasovanie.m117_funkcnost_tesnost">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Prekročili ste dĺžku!" />
										</c:if>
								   </spring:bind>
							</td>
							<td class="strojnik odprasovanie-label">Funkčnosť a tesnosť filtra</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m116_funkcnost_tesnost" />
								<spring:bind path="odprasovanie.m116_funkcnost_tesnost">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Prekročili ste dĺžku!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>
						<tr>
							<td class="strojnik label" colspan=3>Filter M12, výduch V40</td>
							<td class="strojnik label" colspan=3>Filter M115, výduch V22</td>
						</tr>
						<tr>
							<td class="strojnik odprasovanie-label">Chod zariadenia</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m12_cas" />
								<spring:bind path="odprasovanie.m12_cas">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
										</c:if>
								   </spring:bind>
							</td>
							<td class="strojnik odprasovanie-label">Chod zariadenia</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m115_cas" />
								<spring:bind path="odprasovanie.m115_cas">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>
						<tr>
							<td class="strojnik odprasovanie-label">Podtlak</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m12_podtlak" />
								<spring:bind path="odprasovanie.m12_podtlak">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
										</c:if>
								   </spring:bind>
							</td>
							<td class="strojnik odprasovanie-label">Funkčnosť oklepávacieho zariadenia</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m115_funkcnost_oklepavacieho_zariadenia" />
								<spring:bind path="odprasovanie.m115_funkcnost_oklepavacieho_zariadenia">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Prekročili ste dĺžku!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>
						<tr>
							<td class="strojnik odprasovanie-label">Dátum zmeny hadíc filtra</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m12_datum_zmeny_hadic"  value="01.01.2014"/>
								<spring:bind path="odprasovanie.m12_datum_zmeny_hadic">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadaný dátum v tvare 01.01.2014!" />
										</c:if>
								   </spring:bind>
							</td>
							<td class="strojnik odprasovanie-label">Chod zberneho snekoveho dopravnika</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m115_chod_snekoveho_dopravnika" />
								<spring:bind path="odprasovanie.m115_chod_snekoveho_dopravnika">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Prekročili ste dĺžku!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>
						<tr>
							<td class="strojnik odprasovanie-label">Funkčnosť a tesnosť filtra</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m12_funkcnost_tesnost" />
								<spring:bind path="odprasovanie.m12_funkcnost_tesnost">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Prekročili ste dĺžku!" />
										</c:if>
								   </spring:bind>
							</td>
							<td class="strojnik odprasovanie-label">Funkcnost a celistvost filtra a potrubia</td>
							<td class="strojnik" colspan=2>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.m115_funkcnost_celistvost" />
								<spring:bind path="odprasovanie.m115_funkcnost_celistvost">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Prekročili ste dĺžku!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>
						<tr>
							<td class="strojnik label" colspan=6>Filter Herding TLF D 1500, výduch V54</td>
						</tr>
						<tr>
							<td class="velinar label vstupv">Vstup tepla: </td>
							<td class="velinar vstupv">${maerz.vstupTepla}</td>
							<td class="velinar vstupv" style="text-align:left;">kcal/kg</td>
							<td class="velinar vstupv"></td>
							<td class="strojnik odprasovanie-label">Chod zariadenia</td>
							<td class="strojnik" colspan=5>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.herdingCas" />
								<spring:bind path="odprasovanie.herdingCas">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>
						<tr>
							<td class="velinar label vstupv">Teplota pyrometra: </td>
							<td class="velinar vstupv">${maerz.teplotaPyrometra}</td>
							<td class="velinar vstupv" style="text-align:left;">°C</td>
							<td class="velinar vstupv"></td>
							<td class="strojnik odprasovanie-label">Počuť čistiace impulzy</td>
							<td class="strojnik" colspan=5>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.herdingCistiaceImpulzy" />
								<spring:bind path="odprasovanie.herdingCistiaceImpulzy">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Prekročili ste dĺžku!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>
						<tr>
							<td class="velinar" colspan=4></td>
							<td class="strojnik odprasovanie-label">Chod vyprázdňovacieho zariadenia</td>
							<td class="strojnik" colspan=5>
								<form:input class="strojnik vstup sirka1" path="odprasovanie.herdingChodVyprazdnovaciehoZariadenia" />
								<spring:bind path="odprasovanie.herdingChodVyprazdnovaciehoZariadenia">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Prekročili ste dĺžku!" />
										</c:if>
								   </spring:bind>
							</td>
						</tr>

					</tbody>
				
				</table>
			</div>
			
		</form:form>

	</div>

</body>
</html>