<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>PIS Maerz</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
</head>
<body id="login-page" onload="document.f.j_username.focus();noBack();" onunload="">

	<div class="login-wrapper">
		<div id="login-form">
			<h1>Prevádzkový informačný systém</h1>

			
			<form name='f' action="<c:url value='j_spring_security_check' />" method=post>

				<table>
					<tr>
						<td>Prihlasovacie meno:</td>
						<td><input type='text' name='j_username'/></td>
					</tr>
					<tr>
						<td>Heslo:</td>
						<td><input type='password' name='j_password' value='heslo' /></td>
					</tr>
					<tr>
						<td colspan='2'><input name="submit" type="submit" value="Prihlásiť" /></td>
					</tr>
				</table>
			</form>
			<p class="error-message">${message}</p>
		</div>
	</div>
</body>
</html>