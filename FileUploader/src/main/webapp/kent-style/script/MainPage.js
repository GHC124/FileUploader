function MainPage() {

};

MainPage.prototype._currentPageId = null;

MainPage.prototype._pages = null;

MainPage.prototype.loggedin = false;

MainPage.prototype.header = new Header();
MainPage.prototype.footer = new Footer();

MainPage.prototype.homePage = new HomePage();
MainPage.prototype.loginPage = new LoginPage();

MainPage.prototype.init = function(loggedin) {
	console.log('init-MainPage');
	this.loggedin = loggedin;
	
	this.header.init(this.loggedin);
	this.footer.init();
	
	if (this.loggedin) {
		// show menu
	} else {
		// show login page
		this.loginPage.init();
	}
	
	this._pages = new Array();
	
	this._pages.push(this.homePage);
	
	return this;
};

MainPage.prototype.setCurrentPage = function(pageId) {
	if (this._currentPageId == null) {
		var layout = new Layout();
		layout.init();
	}

	this.header.init(this.loggedin);
	this.footer.init();
	
	if (this.loggedin) {
	} else {
		this.loginPage.init();
	}
	
	if (this._currentPageId == pageId) {
		return false;
	}
	
	this._pages[pageId].init();
};