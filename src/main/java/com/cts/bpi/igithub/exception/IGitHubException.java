package com.cts.bpi.igithub.exception;

public class IGitHubException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public IGitHubException() {
		super();
	}

	public IGitHubException(String message, Throwable cause) {
		super(message, cause);
	}

	public IGitHubException(String message) {
		super(message);
	}

	public IGitHubException(Throwable cause) {
		super(cause);
	}
}
