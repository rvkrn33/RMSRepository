package com.rms.exceptions;

public class BusinessException extends Exception{

	private static final long serialVersionUID = 1L;

	public BusinessException(String message) {
		System.out.println(message);
	}
}
