<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
<title>PIS Maerz</title>
<style>
body {
	background-color: rgb(200, 255, 255);
}

#hlavna-cast {
	background-color: white; border: 2px solid rgb(0,217,217); width: 1223px; margin-left: auto; margin-right: auto; font-family: Arial, Verdana; font-size: 14px;
}

#header {
	height: 50px;background-color: rgb(200, 255, 255);
}

.ciara {
	border: 1px solid rgb(0,217,217);
}

</style>
<script type="text/javascript">
	window.history.forward();
	var id=0;
	function noBack() {
		id=1;
		window.history.forward();
	}
</script>
</head>
<body id="trends-page" onload="noBack();" onunload="">
	<div id="hlavna-cast">
		<div id="header">
			<a href="${pageContext.request.contextPath}/add-maerz-form-veduci.html">Späť</a>
			<a href="<c:url value="/j_spring_security_logout" />">Odhlásiť</a>
		</div>
		<div class="ciara"></div>
		<h3>Štatistiky výroby:</h3>
		<div id="plan-chart"> 
			<img src="graf1.jpg"></img>
			<img src="graf2.jpg"></img>
		</div>

	</div>

</body>
</html>