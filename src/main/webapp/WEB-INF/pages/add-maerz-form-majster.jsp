<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<?xml version="1.0" encoding="UTF-8" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>PIS Maerz</title>
<style>
table {
	border-collapse: collapse;
}

table,td,th {
	border: 1px solid #CCFFCC;
}
</style>
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
</head>
<body onload="noBack();" onunload="">

	<h1>PIS pece Maerz</h1>
	<br />
	<a href="<c:url value="/j_spring_security_logout" />"> Logout</a>
	<form:form method="POST" commandName="formular" action="${pageContext.request.contextPath}/add-maerz-form-majster.html">
		<table>
			<tbody>
				<tr>
					<td></td>
					<td colspan='3'>PIS - Prevádzkový informačný systém pece Maerz</td>
					<td></td>
					<td colspan='3'>Neodstranene poruchy</td>
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
					<td colspan='5' rowspan='11'><form:textarea path="maerz.neodstranenePoruchy" /></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td>Vyplna strojnik</td>
					<td></td>
				</tr>
				<tr>
					<td>Datum</td>
					<td>dnes</td>
					<td></td>
					<td>Vyplna velinar</td>
					<td></td>
				</tr>
				<tr>
					<td>Zmena</td>
					<td><form:select path="zamMaerz.zmena" items="${zmenaList}" /></td>
					<td></td>
					<td>Vyplna veduci vapenky</td>
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
					<td>Druh</td>
					<td>Plnenie v %</td>
					<td>Prepocet na tony</td>
					<td></td>
				</tr>
				<tr>
					<td>Zásobník č.1:</td>
					<td><form:input path="maerz.zasobnik1Druh" /></td>
					<td><form:input path="maerz.zasobnik1Plnenie" /></td>
					<td>text</td>
					<td></td>
				</tr>
				<tr>
					<td>Zásobník č.2:</td>
					<td><form:input path="maerz.zasobnik2Druh" /></td>
					<td><form:input path="maerz.zasobnik2Plnenie" /></td>
					<td>text</td>
					<td></td>
				</tr>
				<tr>
					<td>Zásobník č.5:</td>
					<td><form:input path="maerz.zasobnik5Druh" /></td>
					<td><form:input path="maerz.zasobnik5Plnenie" /></td>
					<td>text</td>
					<td></td>
				</tr>
				<tr>
					<td>Zásobník nová lanovka:</td>
					<td><form:input path="maerz.zasobnikNovaLanovkaDruh" /></td>
					<td><form:input path="maerz.zasobnikNovaLanovkaPlnenie" /></td>
					<td>text</td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td>Výroba</td>
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
					<td>Plán</td>
					<td>Skutočnosť</td>
					<td>Percentualne plnenie</td>
					<td>Frakcia 0/16</td>
					<td>Frakcia 10/50</td>
					<td>Od zaciatku mesiaca</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Vápna 6% v to:</td>
					<td><form:input path="maerz.vyrobaVapno6Plan" /></td>
					<td><form:input path="maerz.vyrobaVapno6Skut" /></td>
					<td>text</td>
					<td>text</td>
					<td>text</td>
					<td>text</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Vápna 17% v to:</td>
					<td><form:input path="maerz.vyrobaVapno17Plan" /></td>
					<td><form:input path="maerz.vyrobaVapno17Skut" /></td>
					<td>text</td>
					<td>text</td>
					<td>text</td>
					<td>text</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Vápna 35% v to:</td>
					<td><form:input path="maerz.vyrobaVapno35Plan" /></td>
					<td><form:input path="maerz.vyrobaVapno35Skut" /></td>
					<td>text</td>
					<td>text</td>
					<td>text</td>
					<td>text</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Vápno spolu v to:</td>
					<td>text</td>
					<td>text</td>
					<td>text</td>
					<td></td>
					<td></td>
					<td>text</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td>Skutočnosť</td>
					<td>Frakcia vápenca</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Vápenec vsádzka 6% v to:</td>
					<td>text</td>
					<td><form:input path="maerz.vyrobaVapenecVsadzka6Skut" /></td>
					<td><form:input path="maerz.vyrobaVapenecVsadzka6FrakciaVapenca" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Vápenec vsádzka 17% v to:</td>
					<td>text</td>
					<td><form:input path="maerz.vyrobaVapenecVsadzka17Skut" /></td>
					<td><form:input path="maerz.vyrobaVapenecVsadzka17FrakciaVapenca" /></td>
					<td></td>
					<td colspan=2>Briketizacna linka:</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Vápenec vsádzka 35% v to:</td>
					<td></td>
					<td><form:input path="maerz.vyrobaVapenecVsadzka35Skut" /></td>
					<td><form:input path="maerz.vyrobaVapenecVsadzka35FrakciaVapenca" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Vapenec spolu</td>
					<td></td>
					<td>text</td>
					<td></td>
					<td></td>
					<td>Briketizacka</td>
					<td>Filter M20</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>Pociatocny stav</td>
					<td><form:input path="maerz.briketizackaPocStav" /></td>
					<td><form:input path="maerz.filter_M20_poc_stav" /></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td>V hodinách</td>
					<td></td>
					<td></td>
					<td>Konecny stav</td>
					<td><form:input path="maerz.briketizackaKonStav" /></td>
					<td><form:input path="maerz.filter_M20_kon_stav" /></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Chod pece:</td>
					<td><form:input path="maerz.chodPece" /></td>
					<td></td>
					<td></td>
					<td>Chod zariadenia</td>
					<td>text</td>
					<td>text</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Prestoje spolu v hod:</td>
					<td>text</td>
					<td></td>
					<td></td>
					<td>za mesiac</td>
					<td>text</td>
					<td>text</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Stav lekarnicky</td>
					<td>text</td>
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
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td colspan=2>Pracovna snimka dna</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>VELINAR</td>
					<td></td>
					<td></td>
					<td></td>
					<td>STROJNIK</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Od</td>
					<td>Do</td>
					<td colspan=2>druh cinnosti (kotrola,zavada,odstranenie poruch a pod.)</td>
					<td>Od</td>
					<td>Do</td>
					<td colspan=5>druh cinnosti (kontrola, udrzba, mazanie, opravy a pod.)</td>
				</tr>
				<tr>
				<%-- 	<fmt:formatDate value="${form.pracSnimka.odkedy}" pattern="hh:mm" var="fmtTime" type="time"/> --%>
					<td><form:input path="pracSnimka.odkedy" type="time" pattern="hh:mm"/></td>
					<td><form:input path="pracSnimka.dokedy" type="time" pattern="hh:mm"/></td>
					<td colspan=2><form:input path="pracSnimka.popis" /></td>
				</tr>
				<tr>
					<td><input type="button" value="dalsi zaznam" action=""/></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td><input type="submit" value="Pridať" /></td>
					<td></td>
				</tr>
			</tfoot>
		</table>
	</form:form>
	<p>${message}</p>
	<p>
		<a href="${pageContext.request.contextPath}/index.html">Domov</a>
	</p>

</body>
</html>