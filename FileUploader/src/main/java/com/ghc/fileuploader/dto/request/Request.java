package com.ghc.fileuploader.dto.request;

import com.ghc.fileuploader.dto.util.DtoUtil;

public class Request {
	private String authenUser;
	private String tokenKey;

	public String getAuthenUser() {
		return authenUser;
	}

	public void setAuthenUser(String authenUser) {
		this.authenUser = authenUser;
	}

	public String getTokenKey() {
		return tokenKey;
	}

	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}

	@Override
	public String toString() {
		return DtoUtil.toString(this);
	}
}
