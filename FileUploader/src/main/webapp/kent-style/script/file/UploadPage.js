function UploadPage() {
	
};

UploadPage.prototype.init = function() {
	log('init: UploadPage');
	$.get("views/file/UploadPage.html", function(htmlText){
		// Append to main container
		$(Constants.MAIN_CONTENT).html(htmlText);
		
	});
};