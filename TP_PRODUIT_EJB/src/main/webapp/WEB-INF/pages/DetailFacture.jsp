<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@ page import="java.util.ArrayList" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detail Facture</title>
<style>

	table {
	  	table-layout: fixed;
		width: 100px;
	}

</style>
<%@ include file="commons/header.jsp" %>
</head>
<body>
<%@ include file="commons/menu.jsp" %>

	<br>
	<h4> Detail Facture ${facture.numero} </h4>
	<br>

        <table class="striped">
     	    <thead>
	          	<tr>
	              	<th>Nom</th>
	              	<th>Code Barre</th>
	              	<th>Quantite</th>
	         		<th>Prix Unitaire</th>
	         		<th>Montant</th>
	         		<th>Prix Total</th>              
	        	</tr>
	        </thead>
	        <tr>
        <c:forEach var="lignefac" items="${lignefacture}">        
	        <tbody>
	          	
	          		<td>${lignefac.produit.nom}</td>
	          		<td>${lignefac.produit.codeBarre}</td>
					<td>${lignefac.qte}</td>
					<td>${lignefac.produit.prix} Euros</td>
		            <td>${lignefac.prix} Euros</td>
	        	
	        </c:forEach>
					
	        		

	          	
	        </tbody>
	        
		</table>
		
 		<table style="text-align: right; border: none;">
        
	        <tbody>
	          	<tr>
	          	<td></td><td> </td><td> </td><td> </td><td> </td>
	          		<td>${facture.prix} Euros</td>

	          	</tr>
	        </tbody>

		</table>
		
<%@ include file="commons/footer.jsp" %>
</body>
</html>