<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h1>Panier</h1>
<c:choose>
    <c:when test="${cart.getArticles().size()==0 }">Aucun article</c:when>
    
    <c:otherwise>
   	
        <c:forEach items="${cart.articles}" var="art">
         <pre>
      ${art.value} - ${art.key.name} : <fmt:formatNumber type="currency"  value="${art.key.price/100}" currencySymbol="&euro;"/>      
      
        </pre>
    </c:forEach>
	<c:choose>
	    <c:when test="${codepromo.getCodePromo()!=null}">
	    		<c:choose>
					<c:when test = "${codepromo.typeReduc=='valeur'}">
				       <c:set var = "prix" scope = "session" value = "${(total-codepromo.getValeur())/100}"/>
				   </c:when>
				   <c:when test = "${codepromo.typeReduc=='pourcentage'}">
				        <c:set var = "prix" scope = "session" value = "${(total-(total*(codepromo.getValeur()/100)))/100 }"/>
				        <c:out value = "${}"/>
				   </c:when>
				</c:choose>
				Le code promo "${codepromo.getCodePromo()}" a bien été appliqué.
				Votre panier d'un montant de <strike><fmt:formatNumber type="currency"  value="${total/100}" currencySymbol="&euro;"/></strike> <fmt:formatNumber type="currency"  value="${prix}" currencySymbol="&euro;"/> a bien été commandé.
	    </c:when>
	  
	    <c:otherwise>
	    Votre panier d'un montant de <fmt:formatNumber type="currency"  value="${total/100}" currencySymbol="&euro;"/> a bien été commandé.
	    </c:otherwise>
	</c:choose>
    </c:otherwise>
</c:choose>

