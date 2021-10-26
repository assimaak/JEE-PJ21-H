
$(function() {


	$(".addToCart").click(function(e) {
		var ref = $(this).data("ref");
	//	var quantite = $(this).data("qte");
	//	var quantite2 = $(this).document.getElementById('myInput');
		//var quantite2 = document.getElementById('myInput');

		$.ajax({
			method: 'POST',
			url: "../cart/1/add.json",
			dataType: "json",
			contentType: 'application/json',
			data: JSON.stringify({ id: ref, qty: 1 })
		}).done(function() {
			$.ajax({
				url: "../cart/1.html"
			}).done(function(data) {
				JSON.stringify($('#cartInHeader').html(data))
			});

		});
	});

	$.ajax({
		url: "../cart/1.html"
	}).done(function(data) {
		JSON.stringify($('#cartInHeader').html(data))
	});
});