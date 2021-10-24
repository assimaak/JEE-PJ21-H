<%@include file="/WEB-INF/views/_header.jsp" %>
<%-- import required classes --%>

<h1>Les promos de la semaine !</h1>

<script language="javascript">
//var x = document.getElementById("qte").value;
function myfun(){
var x= 	document.getElementsByClassName('glyphicon glyphicon-plus-sign addToCart')[0];
x.data-qte="10";

}

</script>

<ul class="articles">
<%-- Iterate through articles ... --%>
<li>
	<a href="#">
		<span class="price">
			4,50 &euro;</span>
		<img src="https://static1.chronodrive.com/img/PM/P/0/20/0P_195420.gif"/><br/>
		420g Fromage à raclette <br/>
		
	</a>
	<span class="glyphicon glyphicon-plus-sign addToCart"  
	  data-ref="195420"></span>
	<input class="myInput" type="text" value=15/>
	</li>
<li>
	<a href="#">
		<span class="price">
			1,74 &euro;</span>
		<img src="https://static1.chronodrive.com/img/PM/P/0/09/0P_165609.gif"/><br/>
		6 tranches Jambon Serrano <br/>
		
	</a>
	<span class="glyphicon glyphicon-plus-sign addToCart"data-qte ="5"  data-ref="165609"></span>
		<input id="myInput" type="text" value=15/>
	
</li>

<li>
	<a href="#">
		<span class="price">
			1,69 &euro;</span>
		<img src="https://static1.chronodrive.com/img/PM/P/0/74/0P_120574.gif"/><br/>
		2,5 kg Pomme de terre Cat 1 <br/>
	</a>
	
	<span class="glyphicon glyphicon-plus-sign addToCart"data-qte ="5"  data-ref="120574"></span>
		<input id="myInput" type="text" value=15/>
	
</li>

<li>
	<a href="#">
		<span class="price">
			2,99 &euro;</span>
		<img src="https://static1.chronodrive.com/img/PM/P/0/76/0P_61276.gif"/><br/>
		Boisson énergétique <br/>
		
	</a>
	<span class="glyphicon glyphicon-plus-sign addToCart"data-qte ="5"  data-ref="10101010"></span>
		<input class="myInput" type="text" value=15/>
	
</li>

<li>
	<a href="#">
		<span class="price">
			1,50 &euro;</span>
		<img src="https://static1.chronodrive.com/img/PM/P/0/72/0P_348972.gif"/><br/>
		Papier Cadeau <br/>
	</a>
	<span class="glyphicon glyphicon-plus-sign addToCart" data-qte ="5" data-ref="10101012"></span>
			<input class="myInput" type="text" value=15/>
	
</li>
</ul>

<% 
jsList.add("cart.js");
%>
<%@include file="/WEB-INF/views/_footer.jsp" %>