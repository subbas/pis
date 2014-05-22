<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin_style.css" />" />
<title>PIS Maerz</title>
</head>
<body id="list-of-maerz-page" class="admin-pages">
	<div class="admin-wrapper">
	<div id="admin-header">
		<h1>Zoznam záznamov Maerz</h1>
		<div class="ciara"></div>
		<nav>
		<li><a href="${pageContext.request.contextPath}/list-of-zam.html">Zobraz zamestnancov</a></li>
		<li><a href="${pageContext.request.contextPath}/list-of-maerz.html">Zobraz maerz</a></li>
		<li><a href="<c:url value="/j_spring_security_logout" />">Odhlásiť</a></li>
		</nav>
	</div>
	<div class="ciara"></div>
	<div id="admin-body">

		<table border="1px" cellpadding="0" cellspacing="0">
			<thead>
				<tr>
					<th>Id</th>
					<th>Dátum</th>
					<th>Zmena</th>
					<th>Majster</th>
					<th>Strojník</th>
					<th>Velinár</th>
					<th>Akcia</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="zamMaerz" items="${zamMaerzList}">
					<tr>
						<td>${zamMaerz.maerz.id}</td>
						<td>${zamMaerz.datum}</td>
						<td>${zamMaerz.zmena}</td>
						<td>${zamMaerz.zamestnanec2}</td>
						<td>${zamMaerz.zamestnanec3}</td>
						<td>${zamMaerz.zamestnanec1}</td>
						<td><a href="${pageContext.request.contextPath}/maerz/edit/${zamMaerz.maerz.id}.html">Edituj</a><br />
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>

</body>
</html>