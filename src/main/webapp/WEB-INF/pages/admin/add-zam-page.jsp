<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>PIS Maerz</title>
</head>
<body>
	<h1>Pridaj zamestnanca</h1>

	<form:form method="POST" commandName="zam" action="${pageContext.request.contextPath}/add.html">
		<table>
			<tbody>
				<tr>
					<td>Meno:</td>
					<td><form:input path="meno" /></td>
				</tr>
				<tr>
					<td>Priezvisko:</td>
					<td><form:input path="priezvisko" /></td>
				</tr>
				<tr>
					<td>Rola:</td>
					<td><form:select path="rolaBean" items="${rolaList}" itemValue="id" /></td>
				</tr>
				<tr>
					<td>Prihlasovacie meno:</td>
					<td><form:input path="login" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add" /></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>

	<p>
		<a href="${pageContext.request.contextPath}/admin-page.html">Home page</a>
	</p>
</body>
</html>