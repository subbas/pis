<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin_style.css" />" />
<title>PIS Maerz</title>
</head>
<body id="edit-zam-page" class="admin-pages">
<div class="admin-wrapper" >
	<div id="admin-header">
		<h1>Edituj zamestnanca</h1>
		<div class="ciara"></div>
		<nav>
		<li><a href="${pageContext.request.contextPath}/list-of-zam.html">Zobraz zamestnancov</a></li>
		<li><a href="${pageContext.request.contextPath}/list-of-maerz.html">Zobraz maerz</a></li>
		<li><a href="<c:url value="/j_spring_security_logout" />">Odhlásiť</a></li>
		</nav>
	</div>
	<div class="ciara"></div>
	<div id="admin-body">
	<form:form method="POST" commandName="zam" action="${pageContext.request.contextPath}/zam/edit/${zam.id}.html">
		<table>
			<tbody>
				<tr>
					<td>Osobné číslo:</td>
					<td>
						<form:input path="osobneCislo" />
						<spring:bind path="osobneCislo">
							<c:if test="${status.error}">
								<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
							</c:if>
						</spring:bind>
					</td>
				</tr>
				<tr>
					<td>Meno:</td>
					<td>
						<form:input path="meno" />
						<spring:bind path="meno">
							<c:if test="${status.error}">
								<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
							</c:if>
						</spring:bind>
					</td>
				</tr>
				<tr>
					<td>Priezvisko:</td>
					<td>
						<form:input path="priezvisko" />
						<spring:bind path="priezvisko">
							<c:if test="${status.error}">
								<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
							</c:if>
						</spring:bind></td>
				</tr>
				<tr>
					<td>Rola:</td>
					<td><form:select path="rolaBean" items="${rolaList}" itemValue="id"/></td>
				</tr>
				<tr>
					<td>Prihlasovacie meno:</td>
					<td>
						<form:input path="login" />
						<spring:bind path="login">
							<c:if test="${status.error}">
								<img src="<c:url value="/resources/images/warning1.png"/>"  class="trojuholnik"  title="Musí byť zadané číslo!" />
							</c:if>
						</spring:bind>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Edituj" /></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	</div>
	</div>

</body>
</html>