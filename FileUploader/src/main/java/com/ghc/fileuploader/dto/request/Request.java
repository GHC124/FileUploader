package com.ghc.fileuploader.dto.request;

import com.ghc.fileuploader.dto.util.DtoUtil;

public class Request {
	private String username;
	private String tokenKey;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
