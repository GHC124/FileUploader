package com.ghc.fileuploader.dto.response;

import com.ghc.fileuploader.dto.util.DtoUtil;

public class Response {
	public static final int STATUS_SUCCESS = 0;
	public static final int STATUS_FAIL = 1;
	
	private int status;
	private String message;
	
	public Response(){
		
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString(){
		return DtoUtil.toString(this);
	}
}
