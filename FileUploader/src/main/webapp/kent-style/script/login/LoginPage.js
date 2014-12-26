function LoginPage() {
	
};

LoginPage.prototype.init = function() {
	console.log('init:LoginPage');
	this.initContent();
	return this;
};

LoginPage.prototype.initContent = function() {	
	var that = this;
	
	$.get("views/login/LoginPage.html", function(htmlText){
		// Append to main container
		$(Constants.BODY).html(htmlText);
		
		// Binding event for login page
		$(Constants.BODY).find("input[type=submit]").click(that.login);
	});
};

LoginPage.prototype.successHandler = function(response) {
	if (response.status == 0) {			
		page.init(true);
		page.setCurrentPage(Constants.PAGES.HOME_PAGE);
	} else {
		alert(response.message );
	}
};

LoginPage.prototype.errorHandler = function(error) {
	alert(error);
};

LoginPage.prototype.login = function() {
	var loginArea = $("#frmLogin");
	var authenUser = loginArea.find("input[name=username]").val();
	var password = loginArea.find("input[name=password]").val();
	
	Authenticator.login(authenUser, password, LoginPage.prototype.successHandler, LoginPage.prototype.errorHandler);
};