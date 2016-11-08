<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
form .erreur {
    color: #900;
}
</style>
</head>
<body>
	<form action="SaisieInscription" method="POST">
	<label for="nom">Nom : </label>
	<input type="text" value="" name="nom" />
	<span class="erreur">${erreur}</span>
	<br>
	
	<label for="prenom">Prenom : </label>
	<input type="text" value="" name="prenom" /><br>
	
	<label for="age">Age : </label>
	<input type="text" value="" name="age" /><br>
	
	<input type="submit" value="Valider" name="valider" /><br>
</form>
</body>
</html>