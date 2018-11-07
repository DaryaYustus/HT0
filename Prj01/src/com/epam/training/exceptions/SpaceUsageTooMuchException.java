package com.epam.training.exceptions;

public class SpaceUsageTooMuchException extends Exception {
	private final static String ERROR_MESSAGE = "Space usage too much";

	public SpaceUsageTooMuchException() {
		super(ERROR_MESSAGE);
	}
}
