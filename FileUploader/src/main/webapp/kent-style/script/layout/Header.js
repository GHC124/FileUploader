function Header() {
	
};

Header.prototype.init = function(loggedin) {
	log('init: Header');
	$.get("views/layout/Header.html", function(htmlText){
		// Append to main container
		$(Constants.HEADER_BAR_HEADER).html(htmlText);
		if (loggedin) {
			
		} else {
			
		}
	});
};