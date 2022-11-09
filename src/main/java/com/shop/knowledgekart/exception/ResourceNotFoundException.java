package com.shop.knowledgekart.exception;

public class ResourceNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String code;
	private String userMessage;
	private String systemMessage;
	private String httpcode;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	public String getSystemMessage() {
		return systemMessage;
	}
	public void setSystemMessage(String systemMessage) {
		this.systemMessage = systemMessage;
	}
	public String getHttpcode() {
		return httpcode;
	}
	public void setHttpcode(String httpcode) {
		this.httpcode = httpcode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ResourceNotFoundException(String code, String userMessage, String systemMessage, String httpcode) {
		super();
		this.code = code;
		this.userMessage = userMessage;
		this.systemMessage = systemMessage;
		this.httpcode = httpcode;
	}
	public ResourceNotFoundException() {
		super();
	}
	
	public ResourceNotFoundException(String userMessage) {
		super(userMessage);
		this.userMessage = userMessage;
	}
	
}
