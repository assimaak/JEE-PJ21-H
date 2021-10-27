<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h1>Panier</h1>
<c:choose>
    <c:when test="${empty cart }">Aucun article</c:when>
    
    <c:otherwise>
   
        <c:forEach items="${cart.articles}" var="art">
         <pre>
      ${art.value} - ${art.key.name} : <fmt:formatNumber type="currency"  value="${art.key.price/100}" currencySymbol="&euro;"/>      
      
        </pre>
    </c:forEach>
    
    </c:otherwise>
</c:choose>
<form action="1/validate.html" method="POST" class="form-example">
  <div class="form-example">
    <label for="code">Code promo (optionnel) </label>
    <input type="text" name="code" id="code">
  </div>
  <div class="form-example">
    <input class="btn btn-primary" type="submit" value="Commander">
  </div>
</form>