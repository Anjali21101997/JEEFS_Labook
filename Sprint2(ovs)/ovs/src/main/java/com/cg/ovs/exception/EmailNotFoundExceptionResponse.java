package com.cg.ovs.exception;

public class EmailNotFoundExceptionResponse {
	private String emailResponse;

	public String getEmailResponse() {
		return emailResponse;
	}

	public void setEmailResponse(String emailResponse) {
		this.emailResponse = emailResponse;
	}

	public EmailNotFoundExceptionResponse(String emailResponse) {
		super();
		this.emailResponse = emailResponse;
	}
	

}
