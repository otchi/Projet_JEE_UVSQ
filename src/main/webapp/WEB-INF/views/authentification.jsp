<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>autentification</title>
</head>
<body>
	<h2 align="center"> Bienvenue sur la plateforme d'inscription de Agriotes Info</h2>
	<div align="left" style="background-color: aqua; margin-left:
	 20% ;margin-right: 40%; border-style: solid; ">
		<form:form method="POST" action="" >
			<table>
				<thead align="center" > 
					<tr><td colspan="5"> <b>Autentification</b></tr>
				</thead>
				<tr>
					<td>Email :</td>
					<td><form:input path="email"/> </td>
				</tr>
				 <tr >
					<td>mot de passe:</td>
					<td><form:password path="password"/></td>
				</tr> 
				<tr align="center" >
					<td colspan="5"> <input type="submit" value="valider">  </td>
				</tr>
			</table>
		</form:form>
		<h4 align="center" style="color: red;"><c:out value="${errorAutentification}"></c:out></h4>
	</div><br>
	
	<br>
<a href="${context}authentification/newPass"> cliqué ici pour avoir un nouveau mot de pass</a>
<a href="${context}authentification/inscription"> cliqué ici pour avoir un nouveau mot de pass</a>
	
</body>
</html>