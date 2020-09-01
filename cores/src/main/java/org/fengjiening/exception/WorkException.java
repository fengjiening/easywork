package org.fengjiening.exception;

public class WorkException extends Exception {
	private static final long serialVersionUID = 1L;

	public WorkException(String message){
		super(message);
	}
	
	public WorkException(Throwable cause)
	{
		super(cause);
	}
	
	public WorkException(String message, Throwable cause)
	{
		super(message,cause);
	}
}
