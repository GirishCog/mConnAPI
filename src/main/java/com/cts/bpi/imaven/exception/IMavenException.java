package com.cts.bpi.imaven.exception;

public class IMavenException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public IMavenException() {
		super();
	}

	public IMavenException(String message, Throwable cause) {
		super(message, cause);
	}

	public IMavenException(String message) {
		super(message);
	}

	public IMavenException(Throwable cause) {
		super(cause);
	}
}
