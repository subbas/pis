<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>PIS Maerz</title>
</head>
<body>
	<h1>PIS pece Maerz</h1>
	<br />
	<form:form method="POST" commandName="formular" action="${pageContext.request.contextPath}/add.html">
		<table>
			<tbody>
			<th>Neodstránené poruchy</th>
			<tr>
				<td><form:textarea path="maerz.neodstranenePoruchy" /></td>
			</tr>
			<tr>
				<td>Zmena</td>
				<td><form:select path="zamMaerz.zmena" items="${zmenaList}"/></td>
			</tr>
			<th>Zásoby</th>
				<tr>
					<td></td>
					<td>Druh</td>
					<td>Plnenie v %</td>
				</tr>
				<tr>
					<td>Zásobník č.1:</td>
					<td><form:input path="maerz.zasobnik1Druh" /></td>
					<td><form:input path="maerz.zasobnik1Plnenie" /></td>
				</tr>
				<tr>
					<td>Zásobník č.2:</td>
					<td><form:input path="maerz.zasobnik2Druh" /></td>
					<td><form:input path="maerz.zasobnik2Plnenie" /></td>
				</tr>
				<tr>
					<td>Zásobník č.5:</td>
					<td><form:input path="maerz.zasobnik5Druh" /></td>
					<td><form:input path="maerz.zasobnik5Plnenie" /></td>
				</tr>
				<tr>
					<td>Zásobník nová lanovka:</td>
					<td><form:input path="maerz.zasobnikNovaLanovkaDruh" /></td>
					<td><form:input path="maerz.zasobnikNovaLanovkaPlnenie" /></td>
				</tr>
				<th>Výroba</th>
				<tr>
					<td></td>
					<td>Plán</td>
					<td>Skutočnosť</td>
				</tr>
				<tr>
					<td>Vápna 6% v to: </td>
					<td><form:input path="maerz.vyrobaVapno6Plan" /></td>
					<td><form:input path="maerz.vyrobaVapno6Skut" /></td>
				</tr>
				<tr>
					<td>Vápna 17% v to: </td>
					<td><form:input path="maerz.vyrobaVapno17Plan" /></td>
					<td><form:input path="maerz.vyrobaVapno17Skut" /></td>
				</tr>
				<tr>
					<td>Vápna 35% v to: </td>
					<td><form:input path="maerz.vyrobaVapno35Plan" /></td>
					<td><form:input path="maerz.vyrobaVapno35Skut" /></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td>Skutočnosť</td>
					<td>Frakcia vápenca</td>
				</tr>
				<tr>
					<td>Vápenec vsádzka 6% v to: </td>
					<td></td>
					<td><form:input path="maerz.vyrobaVapenecVsadzka6Skut" /></td>
					<td><form:input path="maerz.vyrobaVapenecVsadzka6FrakciaVapenca" /></td>
				</tr>
				<tr>
					<td>Vápenec vsádzka 17% v to: </td>
					<td></td>
					<td><form:input path="maerz.vyrobaVapenecVsadzka17Skut" /></td>
					<td><form:input path="maerz.vyrobaVapenecVsadzka17FrakciaVapenca" /></td>
				</tr>
				<tr>
					<td>Vápenec vsádzka 35% v to: </td>
					<td></td>
					<td><form:input path="maerz.vyrobaVapenecVsadzka35Skut" /></td>
					<td><form:input path="maerz.vyrobaVapenecVsadzka35FrakciaVapenca" /></td>
				</tr>
				<tr>
					<td></td>
					<td>V hodinách</td>
				</tr>
				<tr>
					<td>Chod pece: </td>
					<td><form:input path="maerz.chodPece" /></td>
				</tr>
				<th>Briketizačná linka</th>
				<tr>
					<td></td>
					<td>Briketizačka</td>
					<td>Filter M20</td>
				</tr>
				<tr>
					<td>Počiatočný stav</td>
					<td><form:input path="maerz.briketizackaPocStav" /></td>
					<td><form:input path="maerz.filter_M20_poc_stav"/></td>
				</tr>
				<tr>
					<td>Konečný stav</td>
					<td><form:input path="maerz.briketizackaKonStav" /></td>
					<td><form:input path="maerz.filter_M20_kon_stav"/></td>
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