package com.ghc.fileuploader.dto.response;

public class ValidateResponse extends Response {
	public static final int ERROR_CODE_NO_ERROR = 0;
	public static final int ERROR_CODE_SESSION_INVALID = 0;
	public static final int ERROR_CODE_SESSION_TIMEOUT = 0;
	
	private int errorCode;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
		
}
