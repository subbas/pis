<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Zobraz</title>
</head>
<body>
<h1>Zobrazenie</h1>

<table border="1px" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th>id</th>
				<th>nazov</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="rola" items="${role}">
				<tr>
					<td>${rola.id}</td>
					<td>${rola.nazov}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

<p><a href="${pageContext.request.contextPath}/index.html">Domov</a></p>
</body>
</html>