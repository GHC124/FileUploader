function Footer() {
	
};

Footer.prototype.init = function() {
	console.log('init: Footer');
	$.get("views/layout/Footer.html", function(htmlText){
		// Append to main container
		$(Constants.FOOTER_BAR_FOOTER).html(htmlText);
	});
};