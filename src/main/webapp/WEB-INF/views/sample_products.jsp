<%@include file="/WEB-INF/views/_header.jsp" %>

<%@ page import="fil.sra.projet.model.Article" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
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
<ul class="articles">
	<%-- Iterate through articles ... --%>
	<% for (Article a : articles) { %>
		<li>
			<a href="#">
				<span class="price">

					<% double priceFloat = Double.valueOf(a.getPrice())/100;
						String res = String.format("%.2f", priceFloat).replace(".",",");
					%>
					<%= res %> &euro;
				</span>

				<img src="<%=a.getImg() %>"/><br/>
				<%= a.getName() %><br/>
			</a>

			<span class="glyphicon glyphicon-plus-sign addToCart" data-ref="<%= a.getId() %>"></span>

		</li>

	<%} %>

</ul>

<% 
jsList.add("cart.js");
%>
<%@include file="/WEB-INF/views/_footer.jsp" %>