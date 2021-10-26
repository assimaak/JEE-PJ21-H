<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="fil.sra.projet.web.dto.SimpleResponse" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Web Drive Admin</title>
    <meta http-equiv='Content-Type' content='text/html'/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.min.css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min.js"></script>
    <script src="https://unpkg.com/bootstrap-datepicker@1.9.0/dist/locales/bootstrap-datepicker.fr.min.js"
            charset="UTF-8"></script>

</head>
<body>

<div class="container p-3 my-3 bg-primary text-white">
    <h1>Web Drive : Admin</h1>
    <p>Ajoutez des promotions temporaires au Web Drive.</p>
</div>

<div class="container p-3 my-3 bg-light text-dark">
	<c:choose>
		<c:when test = "${promotionGroupe.typeReduc=='valeur'}">
		   <c:set var = "prix" scope = "session" value = "${promotionGroupe.getValeur()}"/>
	       <c:set var = "signe" scope = "session" value = "${'cts'}"/>
	   </c:when>
	   <c:when test = "${promotionGroupe.typeReduc=='pourcentage'}">
	   	   <c:set var = "prix" scope = "session" value = "${promotionGroupe.getValeur()}"/>
	       <c:set var = "signe" scope = "session" value = "${'%'}"/>
	   </c:when>
	</c:choose>
	<c:choose>
		<c:when test = "${promotionGroupe.isCategory()}">
	       <c:set var = "type" scope = "session" value = "${'catégorie'}"/>
	       <c:set var = "nom" scope = "session" value = "${a.getCategory(promotionGroupe.getGroupPromo().substring(1,2)).getName()}"/>
	   </c:when>
	   <c:when test = "${promotionGroupe.isBrand()}">
	       <c:set var = "type" scope = "session" value = "${'marque'}"/>
	       <c:set var = "nom" scope = "session" value = "${a.getBrand(promotionGroupe.getGroupPromo().substring(1,2)).getName()}"/>
	   </c:when>
	</c:choose>
 	<c:choose>
	<c:when test = "${response.status=='ERROR'}">
       <h2>Votre promo n'a pas été ajoutée.<h2>
       <p> "${response.message}" </p>
   </c:when>
   <c:otherwise>
	   <h2> Votre promo a bien été ajoutée. <h2>
	   <p> La ${type} ${nom} a désormais une promotion de ${prix}${signe} </p>
   </c:otherwise>
   </c:choose>
	
</div>


</body>
</html>