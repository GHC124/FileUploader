function Header() {
	
};

Header.prototype.init = function(loggedin) {
	log('init: Header');
	var that = this;
	$.get("views/layout/Header.html", function(htmlText){
		$(Constants.HEADER_BAR).html(htmlText);
		if (loggedin) {
			that.initUserControl();
			that.initNavigator();
		} else {
			
		}
	});
};

Header.prototype.initUserControl = function(){
	log('init: UserControl');
	var currentUser = Authenticator.getCurrentUser();
	var headerBarUserControl = $(Constants.HEADER_BAR_USER_CONTROL);
	headerBarUserControl.find('#userControl_userName').text(currentUser.authenUser);
	headerBarUserControl.find('#userControl_logout').click(function(){
		Authenticator.logout();
		page.setLogin(false);
	});	
};

Header.prototype.initNavigator = function(){
	log('init: Navigator');
	var navigator = $(Constants.HEADER_BAR_NAVIGATOR);
	navigator.find('#navigator_home').click(function(){
		page.setCurrentPage(Constants.PAGES.HOME_PAGE);
	});	
	navigator.find('#navigator_upload').click(function(){
		page.setCurrentPage(Constants.PAGES.UPLOAD_PAGE);
	});
};