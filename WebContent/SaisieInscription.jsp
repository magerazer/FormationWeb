<%@ taglib uri ="" prefix="" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.erreur {
    color: #900;
}
</style>
</head>
<body>
	<span class="erreur">${erreurs}</span>

	<form action="SaisieInscription" method="POST">
	<label for="nom">Nom : </label>
	<input type="text" value="${param.nom}" name="nom" />
	<span class="erreur">${erreurs['nom']}</span>
	<br>
	
	<label for="prenom">Prenom : </label>
	<input type="text" value="${param.prenom}" name="prenom" /><br>
	
	<label for="age">Age : </label>
	<input type="text" value="${param.age}" name="age" />
	<span class="erreur">${erreurs['age']}</span>
	<br>
	<input type="submit" value="Valider" name="valider" /><br>
	<span class="erreur">${ message }</span>
</form>
</body>
</html>