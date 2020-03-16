package com.rogersamson.apiclient;


public class BaseResponse {
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getEncodedFile() {
		return encodedFile;
	}
	public void setEncodedFile(String encodedFile) {
		this.encodedFile = encodedFile;
	}
	private String encodedFile ;
}
