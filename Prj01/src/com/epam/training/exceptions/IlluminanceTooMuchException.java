package com.epam.training.exceptions;

public class IlluminanceTooMuchException extends Exception {
	private final static String ERROR_MESSAGE = "Illuminance too much";
	
	public IlluminanceTooMuchException() {
		super(ERROR_MESSAGE);
	}

}
