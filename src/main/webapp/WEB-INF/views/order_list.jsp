<%@include file="_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h1>Liste des commandes</h1>
<ul>
<c:choose>
    <c:when test="${empty orders}">Aucune commande</c:when>
    <c:otherwise>
        <c:forEach items="${orders}" var="order">
            <li>
                <p>
                    Date : <fmt:formatDate pattern = "d/M/YY" value="${order.createdOn}"/><br/>
                    Amount : <fmt:formatNumber type="currency" pattern ="#,##" value="${order.amount}" currencySymbol="&euro; " />
                    <%-- Amount : <fmt:formatNumber type="number" value="${order.amount/100.0}" currencySymbol="&euro; " /> --%><br/>
                    Status : <c:out value = "${order.currentStatus}"/><br/>
                    <c:forEach items="${order.articles}" var="articleName">
                       * <c:out value = "${articleName}"/><br/>
                    </c:forEach>
                </p>
            </li>
        </c:forEach>
    </c:otherwise>
</c:choose>
</ul>

<%@include file="_footer.jsp" %>