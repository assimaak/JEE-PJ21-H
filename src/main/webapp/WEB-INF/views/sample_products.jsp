<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="fil.sra.projet.model.Article" %>
<%@ page import="fil.sra.projet.model.PromotionOneArticle" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="fil.sra.projet.model.Cart" %>
<%-- import required classes --%>

<h1>Les promos de la semaine !</h1>

<script language="javascript">
//var x = document.getElementById("qte").value;
//function myfun(){
//var x= 	document.getElementsByClassName('glyphicon glyphicon-plus-sign addToCart')[0];
//x.data-qte="10";

//}

</script>


<% List<Article> articles = (List<Article>) request.getAttribute("listArticle"); %>
<% List<PromotionOneArticle> promotions = (List<PromotionOneArticle>) request.getAttribute("listPromotion"); %>
<% Cart cart = (Cart) request.getAttribute("cart"); %>
<% Map<Article, Integer> mapCart = cart.getArticles(); %>
<ul class="articles">
	<%-- Iterate through articles ... --%>
	<% for (Article a : articles) { %>
		<li id="<%= a.getId() %>" >
			<a href="#">
				<span class="price">
					<% double priceFloat = Double.valueOf(a.getPrice())/100;%>
					<% double priceRemiser = priceFloat;%>
					<% for (PromotionOneArticle p : promotions){
						if(p.getReference().equals(a.getId())){
							if(p.getTypeReduc().equals("pourcentage")){
								priceRemiser = priceRemiser*(1-(Double.parseDouble(p.getValeur())/100));
							}
							else{
								priceRemiser = priceRemiser-(Double.parseDouble(p.getValeur())/100);
							}
						}
					}%>

					<%if(priceFloat==priceRemiser){
						if (priceFloat <=0) priceFloat = 0;
						String res = String.format("%.2f", priceFloat).replace(".",",");%>
						<%= res %> &euro;
					<%}
					else{
						if (priceRemiser <=0) priceRemiser = 0;
						if (priceFloat <=0) priceFloat = 0;
						String res1 = String.format("%.2f", priceFloat).replace(".",",");
						String res2 = String.format("%.2f", priceRemiser).replace(".",",");%>
						<strike><%= res1 %> &euro;</strike>
						<%= res2 %> &euro;
					<%}%>

				</span>

				<img src="<%=a.getImg() %>"/><br/>
				<%= a.getName() %><br/>
			</a>
			
			<span class="glyphicon glyphicon-plus-sign addToCart" data-ref="<%= a.getId() %>"></span>
			<% if( mapCart.get(a)!=null ) {%>
				<p>Ajout?? au panier</p>
			<%}%>
		</li>

	<%} %>

</ul>

<% 
jsList.add("cart.js");
%>
<%@include file="/WEB-INF/views/_footer.jsp" %>