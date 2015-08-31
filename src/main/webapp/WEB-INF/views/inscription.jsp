<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>inscription</title>
</head>
<body>
	<h3 align="center">inscription</h3>
	<form:form method="POST" action="">
		<table>
			<tr>
				<td>nom:</td>
				<td><form:input path="nom" /></td>
			</tr>
			<tr>
				<td>prenom:</td>
				<td><form:input path="prenom" /></td>
			</tr>

			<tr>
				<td>mail:</td>
				<td><form:input path="mail" /></td>
			</tr>
			<tr>
				<td colspan="5" align="center"><input type="submit"
					value="valider"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>