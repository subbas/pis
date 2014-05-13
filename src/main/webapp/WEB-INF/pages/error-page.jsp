<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
<title>PIS Maerz</title>
</head>
<body id="error-page">
	<div class="error-wrapper">
		<div id="error-info">
			<h2>Niekde nastala chyba</h2>
			<p>${errorMessage }</p>
			<a href="${pageContext.request.contextPath}/login.html">Späť na úvodnú stránku</a>
		</div>
	</div>
</body>
</html>