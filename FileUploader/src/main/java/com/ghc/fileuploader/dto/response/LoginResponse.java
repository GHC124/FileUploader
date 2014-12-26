package com.ghc.fileuploader.dto.response;

public class LoginResponse extends Response {
	public static final int ERROR_CODE_NO_ERROR = 0;
	public static final int ERROR_CODE_INVALID = 1;

	private int errorCode;
	private String tokenKey;
	private String displayName;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getTokenKey() {
		return tokenKey;
	}

	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
