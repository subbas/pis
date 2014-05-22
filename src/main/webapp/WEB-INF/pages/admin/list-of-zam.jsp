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
<body id="list-of-zam-page" class="admin-pages">
	<div class="admin-wrapper">
	<div id="admin-header">
		<h1>Zoznam zamestnancov</h1>
		<div class="ciara"></div>
		<nav>
		<li><a href="${pageContext.request.contextPath}/list-of-zam.html">Zobraz zamestnancov</a></li>
		<li><a href="${pageContext.request.contextPath}/list-of-maerz.html">Zobraz maerz</a></li>
		<li><a href="<c:url value="/j_spring_security_logout" />">Odhlásiť</a></li>
		</nav>
	</div>
	<div class="ciara"></div>
	<a href="${pageContext.request.contextPath}/add.html" class="druhe-menu">Pridaj zamestnanca</a>
	<div class="ciara"></div>
	<div id="admin-body">
		<table border="1px" cellpadding="0" cellspacing="0">
			<thead>
				<tr>
					<th>Osobné číslo</th>
					<th>Meno</th>
					<th>Priezvisko</th>
					<th>Rola</th>
					<th>Prihlasovacie meno</th>
					<th>Edituj</th>
					<th>Vymaž</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="zam" items="${zamList}">
					<tr>
						<td>${zam.osobneCislo}</td>
						<td>${zam.meno}</td>
						<td>${zam.priezvisko}</td>
						<td>${zam.rolaBean}</td>
						<td>${zam.login}</td>
						<td><a href="${pageContext.request.contextPath}/zam/edit/${zam.id}.html">Edituj</a></td>
						<td><a href="${pageContext.request.contextPath}/zam/delete/${zam.id}.html">Vymaž</a></td> 
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
</body>
</html>