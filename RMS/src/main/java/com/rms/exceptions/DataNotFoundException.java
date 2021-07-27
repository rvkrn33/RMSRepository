package com.rms.exceptions;

public class DataNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {
		System.out.println(message);
	}
}
