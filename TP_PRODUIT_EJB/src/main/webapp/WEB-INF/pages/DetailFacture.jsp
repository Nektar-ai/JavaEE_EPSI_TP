<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@ page import="java.util.ArrayList" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detail Facture</title>
</head>
<body>
	Numero : ${facture.numero}
	<br/>
	Date : ${Facture.date}
	<br>
	Client : ${Facture.client.nom}
	<br>
	Prix : ${Facture.prix}
</body>
</html>