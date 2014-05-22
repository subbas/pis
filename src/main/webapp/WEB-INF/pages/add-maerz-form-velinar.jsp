<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
<script src="<c:url value="/resources/js/script.js" />"></script>
<title>PIS Maerz</title>
<style>
body {
	background-color: rgb(255, 255, 176);
}

#hlavna-cast {
	background-color: white; border: 2px solid rgb(245,225,34); width: 1223px; margin-left: auto; margin-right: auto; font-family: Arial, Verdana; font-size: 14px;
}

#header {
	height: 50px; background-color: rgb(255, 255, 176);
}

.ciara {
	border: 1px solid rgb(245,225,34);
}
</style>

</head>
<body onload="noBack();" onunload="">
	<div id="hlavna-cast">

		<form:form  method="POST" commandName="formular" action="${pageContext.request.contextPath}/add-maerz-form-velinar.html">
			<div id="header">
				<button type="submit" class="uloz-button">
					<img src="<c:url value="/resources/images/uloz_velinar.png"/>" class="uloz-obrazok"/>
				</button>
				<a href="${pageContext.request.contextPath}/synchVelinar.html">
					<img src="<c:url value="/resources/images/synch_velinar.png"/>" class="synch-obrazok"/>
				</a> 
				<a href="<c:url value="/j_spring_security_logout" />"><img src="<c:url value="/resources/images/odhlas_velinar.png"/>" class="odhlas-obrazok"/></a>
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
							<td class="strojnik" colspan='5' rowspan='18'>${neodstranenePoruchy}</td>

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
							<td class="veduci" style="text-align: left;">Vypĺňa vedúci vápenky</td>
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
							<td class="velinar oramovanie1"><form:select class="velinar vstupv druhy-stlpec" path="zamMaerz.zamestnanec2" items="${majsterList}"
									itemValue="id" cssStyle="font-size:10px;" /></td>
							<td class="velinar oramovanie1">${formular.zamMaerz.zamestnanec2.osobneCislo}</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie-right">Velinár:</td>
							<td class="velinar oramovanie1"><form:select class="velinar vstupv druhy-stlpec" path="zamMaerz.zamestnanec1" items="${velinarList}"
									itemValue="id" cssStyle="font-size:10px;" /></td>
							<td class="velinar oramovanie1">${formular.zamMaerz.zamestnanec1.osobneCislo}</td>
							<td></td>
							<td></td>
						</tr>

						<tr>
							<td class="oramovanie-right">Strojník:</td>
							<td class="velinar oramovanie1"><form:select class="velinar vstupv druhy-stlpec" path="zamMaerz.zamestnanec3" items="${strojnikList}"
									itemValue="id" cssStyle="font-size:10px;" /></td>
							<td class="velinar oramovanie1">${formular.zamMaerz.zamestnanec3.osobneCislo}</td>
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
							<td class="velinar oramovanie1 druhy-stlpec">
								<form:input id="zasobnik1Druh" class="velinar sirka-velinar vstupv" path="maerz.zasobnik1Druh" /> 
									<spring:bind path="maerz.zasobnik1Druh">
										<c:if test="${status.error}">
											<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
										</c:if>
								   </spring:bind>
							</td>
							<td class="velinar oramovanie1">
								<form:input class="velinar sirka-velinar vstupv" path="maerz.zasobnik1Plnenie" /> 
								<spring:bind path="maerz.zasobnik1Plnenie">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
							<td class="vzorec oramovanie1">${D16}</td>
							<td></td>
						</tr>

						<tr>
							<td class="oramovanie1">Zásobník č.2</td>
							<td class="velinar oramovanie1">
								<form:input class="velinar sirka-velinar vstupv" path="maerz.zasobnik2Druh" /> 
								<spring:bind path="maerz.zasobnik2Druh">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
							<td class="velinar oramovanie1">
								<form:input class="velinar sirka-velinar vstupv" path="maerz.zasobnik2Plnenie" /> 
								<spring:bind path="maerz.zasobnik2Plnenie">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
							<td class="vzorec oramovanie1">${D17}</td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie1">Zásobník č.5</td>
							<td class="velinar oramovanie1">
								<form:input class="velinar sirka-velinar vstupv" path="maerz.zasobnik5Druh" />
								<spring:bind path="maerz.zasobnik5Druh">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
							<td class="velinar oramovanie1">
								<form:input class="velinar sirka-velinar vstupv" path="maerz.zasobnik5Plnenie" />
								<spring:bind path="maerz.zasobnik5Plnenie">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
							<td class="vzorec oramovanie1">${D18}</td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie1">Zásobník nová lanovka</td>
							<td class="velinar oramovanie1">
								<form:input class="velinar sirka-velinar vstupv" path="maerz.zasobnikNovaLanovkaDruh" />
								<spring:bind path="maerz.zasobnikNovaLanovkaDruh">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>" class="trojuholnik" title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
							<td class="velinar oramovanie1">
								<form:input class="velinar sirka-velinar vstupv" path="maerz.zasobnikNovaLanovkaPlnenie" />
								<spring:bind path="maerz.zasobnikNovaLanovkaPlnenie">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
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
							<td class="veduci oramovanie1">${vyrobaVapno6Plan}</td>
							<td class="velinar oramovanie1">
								<form:input class="velinar treti-stlpec vstupv" path="maerz.vyrobaVapno6Skut" />
								<spring:bind path="maerz.vyrobaVapno6Skut">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
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
							<td class="veduci oramovanie1">${vyrobaVapno17Plan}</td>
							<td class="velinar oramovanie1">
								<form:input class="velinar treti-stlpec vstupv" path="maerz.vyrobaVapno17Skut" />
								<spring:bind path="maerz.vyrobaVapno17Skut">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
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
							<td class="veduci oramovanie1">${vyrobaVapno35Plan}</td>
							<td class="velinar oramovanie1">
								<form:input class="velinar treti-stlpec vstupv" path="maerz.vyrobaVapno35Skut" />
								<spring:bind path="maerz.vyrobaVapno35Skut">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
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
							<td class="velinar oramovanie1">
								<form:input class="velinar treti-stlpec vstupv" path="maerz.vyrobaVapenecVsadzka6Skut" />
								<spring:bind path="maerz.vyrobaVapenecVsadzka6Skut">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
							<td class="velinar oramovanie1">
								<form:input class="velinar stvrty-stlpec vstupv" path="maerz.vyrobaVapenecVsadzka6FrakciaVapenca" />
								<spring:bind path="maerz.vyrobaVapenecVsadzka6FrakciaVapenca">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
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
							<td class="velinar oramovanie1">
								<form:input class="velinar treti-stlpec vstupv" path="maerz.vyrobaVapenecVsadzka17Skut" />
								<spring:bind path="maerz.vyrobaVapenecVsadzka17Skut">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
							<td class="velinar oramovanie1">
								<form:input class="velinar stvrty-stlpec vstupv" path="maerz.vyrobaVapenecVsadzka17FrakciaVapenca" />
								<spring:bind path="maerz.vyrobaVapenecVsadzka17FrakciaVapenca">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
							<td></td>
							<td colspan=2>Briketizačná linka</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie1">Vápenec vsádzka 35% v to</td>
							<td class="vzorec oramovanie1">${B31 }</td>
							<td class="velinar oramovanie1">
								<form:input class="velinar treti-stlpec vstupv" path="maerz.vyrobaVapenecVsadzka35Skut" />
								<spring:bind path="maerz.vyrobaVapenecVsadzka35Skut">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
							<td class="velinar oramovanie1">
								<form:input class="velinar stvrty-stlpec vstupv" path="maerz.vyrobaVapenecVsadzka35FrakciaVapenca" />
								<spring:bind path="maerz.vyrobaVapenecVsadzka35FrakciaVapenca">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
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
							<td class="velinar oramovanie1">
								<form:input class="velinar siesty-stlpec vstupv" path="maerz.briketizackaPocStav" />
								<spring:bind path="maerz.briketizackaPocStav">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
							<td class="velinar oramovanie1">
								<form:input class="velinar siedmy-stlpec vstupv" path="maerz.filter_M20_poc_stav" />
								<spring:bind path="maerz.filter_M20_poc_stav">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
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
							<td class="velinar oramovanie1">
								<form:input class="velinar siesty-stlpec vstupv" path="maerz.briketizackaKonStav" />
								<spring:bind path="maerz.briketizackaKonStav">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
							<td class="velinar oramovanie1">
								<form:input class="velinar siedmy-stlpec vstupv" path="maerz.filter_M20_kon_stav" />
								<spring:bind path="maerz.filter_M20_kon_stav">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td class="oramovanie1">Chod pece</td>
							<td class="velinar oramovanie1">
								<form:input class="velinar druhy-stlpec vstupv" path="maerz.chodPece" />
								<spring:bind path="maerz.chodPece">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
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
							<td class="velinar" colspan=4 rowspan=26>
								<form:textarea class="velinar" path="maerz.pracovnaSnimkaVelinar"
									cssStyle="border:2px solid rgb(253, 233,35);width:500px;height:100px;" />
								<spring:bind path="maerz.pracovnaSnimkaVelinar">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Prekročili ste maximálnu dĺžku!" />
									</c:if>
								</spring:bind>
							</td>
							<td class="strojnik label" colspan=2>Kontrola ochranných krytov:</td>
							<td class="strojnik" colspan=4>${kontrolaOchrannychKrytov}</td>
						</tr>

						<tr>
							<td class="strojnik label" colspan=2>Stav potrubia vzduchotechniky:</td>
							<td class="strojnik" colspan=4>${stavPotrubiaVzduchotechniky}</td>
						</tr>
						<tr>
							<td class="strojnik label" colspan=2>Stav obežných kolies ventilátorov:</td>
							<td class="strojnik" colspan=4>${stavObeznychKoliesVentilatorov}</td>
						</tr>
						<tr>
							<td class="strojnik label" colspan=2>Stav izolátorov ventilov:</td>
							<td class="strojnik" colspan=4>${stavIzolatorovVentilatorov}</td>
						</tr>
						<tr>
							<td class="strojnik label" colspan=6>Výsledok kontroly technologického zariadenia na začiatku zmeny:</td>
						</tr>
						<tr>
							<td class="strojnik" colspan=6>${vysledokKontrolyTechnologickehoZariadenia}</td>
						</tr>

						<tr>
							<td class="strojnik" colspan=6 rowspan=3>${pracovnaSnimkaStrojnik}</td>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<td class="strojnik label" colspan=6 style="font-size: 18px; text-decoration: underline;">Kontrola zdrojov, ktoré sa odprašujú:</td>
						</tr>
						<tr>
							<td class="strojnik label" colspan=3>Filter Scheuch, výduch K4</td>
							<td class="strojnik label" colspan=3>Filter M10, výduch V21</td>
						</tr>

						<tr>
							<td class="strojnik odprasovanie-label">Chod zariadenia</td>
							<td class="strojnik" colspan=2>${odprasovanie.scheuchCas}</td>
							<td class="strojnik odprasovanie-label">Chod zariadenia</td>
							<td class="strojnik" colspan=3>${odprasovanie.m10_cas}</td>
						</tr>

						<tr>
							<td class="strojnik odprasovanie-label">Otvárajú všetky membránové ventily</td>
							<td class="strojnik" colspan=2>${odprasovanie.scheuchMembranoveVentily}</td>
							<td class="strojnik odprasovanie-label">Podtlak</td>
							<td class="strojnik" colspan=3>${odprasovanie.m10_podtlak}</td>
						</tr>

						<tr>
							<td class="strojnik odprasovanie-label">Fungujú šneky pre vynášanie prachu</td>
							<td class="strojnik" colspan=2>${odprasovanie.scheuchSneky}</td>
							<td class="strojnik odprasovanie-label">Dátum zmeny hadíc filtra</td>
							<td class="strojnik" colspan=3>${odprasovanie.m10_datum_zmeny_hadic}</td>
						</tr>

						<tr>
							<td class="strojnik odprasovanie-label">Diferenčný podtlak</td>
							<td class="strojnik" colspan=2>${odprasovanie.scheuchPodtlak}</td>
							<td class="strojnik odprasovanie-label">Funkčnosť a tesnosť filtra</td>
							<td class="strojnik" colspan=3>${odprasovanie.m10_funkcnost_tesnost}</td>
						</tr>
						<tr>
							<td class="strojnik label" colspan=3>Filter M117.3, výduch V38</td>
							<td class="strojnik label" colspan=3>Filter M116.1, výduch V39</td>
						</tr>
						<tr>
							<td class="strojnik odprasovanie-label">Chod zariadenia</td>
							<td class="strojnik" colspan=2>${odprasovanie.m117_cas}</td>
							<td class="strojnik odprasovanie-label">Chod zariadenia</td>
							<td class="strojnik" colspan=3>${odprasovanie.m116_cas}</td>
						</tr>
						<tr>
							<td class="strojnik odprasovanie-label">Podtlak</td>
							<td class="strojnik" colspan=2>${odprasovanie.m117_podtlak}</td>
							<td class="strojnik odprasovanie-label">Podtlak</td>
							<td class="strojnik" colspan=3>${odprasovanie.m116_podtlak}</td>
						</tr>
						<tr>
							<td class="strojnik odprasovanie-label">Dátum zmeny hadíc filtra</td>
							<td class="strojnik" colspan=2>${odprasovanie.m117_datum_zmeny_hadic}</td>
							<td class="strojnik odprasovanie-label">Dátum zmeny hadíc filtra</td>
							<td class="strojnik" colspan=3>${odprasovanie.m116_datum_zmeny_hadic}</td>
						</tr>
						<tr>
							<td class="strojnik odprasovanie-label">Funkčnosť a tesnosť filtra</td>
							<td class="strojnik" colspan=2>${odprasovanie.m117_funkcnost_tesnost}</td>
							<td class="strojnik odprasovanie-label">Funkčnosť a tesnosť filtra</td>
							<td class="strojnik" colspan=3>${odprasovanie.m116_funkcnost_tesnost}</td>
						</tr>
						<tr>
							<td class="strojnik label" colspan=3>Filter M12, výduch V40</td>
							<td class="strojnik label" colspan=3>Filter M115, výduch V22</td>
						</tr>
						<tr>
							<td class="strojnik odprasovanie-label">Chod zariadenia</td>
							<td class="strojnik" colspan=2>${odprasovanie.m12_cas}</td>
							<td class="strojnik odprasovanie-label">Chod zariadenia</td>
							<td class="strojnik" colspan=3>${odprasovanie.m115_cas}</td>
						</tr>
						<tr>
							<td class="strojnik odprasovanie-label">Podtlak</td>
							<td class="strojnik" colspan=2>${odprasovanie.m12_podtlak}</td>
							<td class="strojnik odprasovanie-label">Funkčnosť oklepávacieho zariadenia</td>
							<td class="strojnik" colspan=3>${odprasovanie.m115_funkcnost_oklepavacieho_zariadenia}</td>
						</tr>
						<tr>
							<td class="strojnik odprasovanie-label">Dátum zmeny hadíc filtra</td>
							<td class="strojnik" colspan=2>${odprasovanie.m12_datum_zmeny_hadic}</td>
							<td class="strojnik odprasovanie-label">Chod zberneho snekoveho dopravnika</td>
							<td class="strojnik" colspan=3>${odprasovanie.m115_chod_snekoveho_dopravnika}</td>
						</tr>
						<tr>
							<td class="strojnik odprasovanie-label">Funkčnosť a tesnosť filtra</td>
							<td class="strojnik" colspan=2>${odprasovanie.m12_funkcnost_tesnost}</td>
							<td class="strojnik odprasovanie-label">Funkcnost a celistvost filtra a potrubia</td>
							<td class="strojnik" colspan=3>${odprasovanie.m115_funkcnost_celistvost}</td>
						</tr>
						<tr>
							<td class="strojnik label" colspan=6>Filter Herding TLF D 1500, výduch V54</td>
						</tr>
						<tr>
							<td class="velinar label vstupv">Vstup tepla:</td>
							<td class="velinar vstupv">
								<form:input class="velinar druhy-stlpec vstupv" path="maerz.vstupTepla" cssStyle="border:2px solid rgb(253, 233, 35);" />
								<spring:bind path="maerz.vstupTepla">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
							<td class="velinar vstupv" style="text-align:left;">kcal/kg</td>
							<td class="velinar vstupv"></td>
							<td class="strojnik odprasovanie-label">Chod zariadenia</td>
							<td class="strojnik" colspan=5>${odprasovanie.herdingCas}</td>
						</tr>
						<tr>
							<td class="velinar  vstupv label prvy-stlpec">Teplota pyrometra:</td>
							<td class="velinar vstupv">
								<form:input class="velinar druhy-stlpec vstupv" path="maerz.teplotaPyrometra"
									cssStyle="border:2px solid rgb(253, 233, 35);" />
								<spring:bind path="maerz.teplotaPyrometra">
									<c:if test="${status.error}">
										<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
									</c:if>
								</spring:bind>
							</td>
							<td class="velinar vstupv" style="text-align:left;">°C</td>
							<td class="velinar vstupv"></td>
							<td class="strojnik odprasovanie-label">Počuť čistiace impulzy</td>
							<td class="strojnik" colspan=5>${odprasovanie.herdingCistiaceImpulzy}</td>
						</tr>
						<tr>
							<td class="velinar" colspan=4></td>
							<td class="strojnik odprasovanie-label">Chod vyprázdňovacieho zariadenia</td>
							<td class="strojnik" colspan=5>${odprasovanie.herdingChodVyprazdnovaciehoZariadenia}</td>
						</tr>

					</tbody>

				</table>
			</div>

		</form:form>

	</div>

</body>
</html>