<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h1>Panier</h1>
<c:choose>
    <c:when test="${empty cart }">Aucun article</c:when>
    
    <c:otherwise>
   
        <c:forEach items="${cart.articles}" var="art">
         <pre>
      ${art.value} - ${art.key.name} : <fmt:formatNumber type="currency" pattern="#,##" value="${art.key.price}" currencySymbol="&euro;"/>      
        </pre>
    </c:forEach>
    
    </c:otherwise>
</c:choose>

<a class="btn btn-primary" href="cart/1/validate.html">Commander</a>