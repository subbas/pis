<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>PIS Maerz</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/admin-page.html">Späť na úvodnú stránku</a>
	<table border="1px" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th>Osobné číslo</th>
				<th>Meno</th>
				<th>Priezvisko</th>
				<th>Rola</th>
				<th>Prihlasovacie meno</th>
				<th>Akcia</th>
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
					<td><a href="${pageContext.request.contextPath}/zam/edit/${zam.id}.html">Edituj</a><br /> <a
						href="${pageContext.request.contextPath}/zam/delete/${zam.id}.html">Vymaž</a><br /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>