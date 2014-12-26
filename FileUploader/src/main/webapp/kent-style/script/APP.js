// create the main module
$(function() {
	Authenticator.isValid(successHandler, errorHandler);	
});

var page = new MainPage();

function successHandler(response) {
	if (response.status == 0) {
		page.init(true);
		page.setCurrentPage(Constants.PAGES.HOME_PAGE);
	} else {
		page.init(false);
	}
};

function errorHandler(error) {
	// Show login page
};