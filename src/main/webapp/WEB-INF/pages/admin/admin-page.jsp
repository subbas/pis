<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>PIS Maerz</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/list-of-zam.html">Zobraz zamestnancov</a>
	<a href="${pageContext.request.contextPath}/list-of-maerz.html">Zobraz maerz</a>
	
	<a href="<c:url value="/j_spring_security_logout" />">Odhlásiť</a>
</body>
</html>