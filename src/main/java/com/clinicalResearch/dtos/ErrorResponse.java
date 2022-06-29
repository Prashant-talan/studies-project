package com.clinicalResearch.dtos;

public class ErrorResponse implements Response {

	private int code;
	private String message;

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	private String stackTrace;

	@Override
	public String toString() {
		return "ErrorResponse [code=" + code + ", message=" + message + ", stackTrace=" + stackTrace + "]";
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
