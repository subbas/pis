<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin_style.css" />" />
<title>PIS Maerz</title>
</head>
<body id="admin-page" class="admin-pages">
	<div class="admin-wrapper">
		<div id="admin-header">
			<h1>Domovská stránka</h1>
			<div class="ciara"></div>
			<nav>
				<li>
					<a href="${pageContext.request.contextPath}/list-of-zam.html">Zobraz zamestnancov</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/list-of-maerz.html">Zobraz maerz</a>
				</li>
				<li>
					<a href="<c:url value="/j_spring_security_logout" />">Odhlásiť</a>
				</li>
			</nav>
		</div>
		<div class="ciara"></div>
		<div id="admin-body"> 
		Vitajte na administrátorských podstránkach. :)
		</div>
	</div>
	
	
	
</body>
</html>