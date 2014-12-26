package com.ghc.fileuploader.dto.request;


public class LoginRequest extends Request{
	private String username;
	private String password;

	public String getAuthenUser() {
		return username;
	}

	public void setAuthenUser(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}
