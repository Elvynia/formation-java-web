<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${ ok }">
		<h2>Les données du formulaire ont été traitées.</h2>
	</c:if>
	<c:if test="${ not ok }">
		<h2>Impossible de créer l'utilisateur : les données saisies ne
			sont pas valides.</h2>
	</c:if>
	<c:url value="/welcome" var="welcomeUrl" />
	<h3>
		<a href="${ welcomeUrl }">Revenir à l'accueil</a>
	</h3>
</body>
</html>