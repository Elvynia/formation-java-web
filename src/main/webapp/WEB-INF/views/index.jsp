<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:url value="/css/index.css" var="indexCssUrl" />
<link rel="stylesheet" href="${ indexCssUrl }">
</head>
<body>
	<header>
		<div class="brand">
			SUPERWEBAPP
		</div>
		<div class="user">
			${ user.name }
		</div>
	</header>
	<h1>Super page de test !</h1>
	<p>${ welcome }</p>
	
	<form method="post" action="">
		<div>
			<label for="name">Nom :</label>
			<input id="name" name="user_name">
		</div>
		<div>
			<label for="age">Age :</label>
			<input id="age" name="user_age">
		</div>
		<div>
			<label for="email">Mail :</label>
			<input type="email" id="email" name="user_email">
		</div>
		<button>Valider</button>
	</form>
	
	<h2>Liste des utilisateurs :</h2>
	<ul>
		<c:forEach items="${ userList }" var="item">
			<li>${ item.name } : age=${ item.age } et email=${ item.email }</li>
		</c:forEach>
	</ul>
</body>
</html>