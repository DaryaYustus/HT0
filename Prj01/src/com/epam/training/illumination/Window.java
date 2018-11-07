package com.epam.training.illumination;

public class Window extends Illumination {
	final static int DEFAULT_ILLUMINATION = 700;

	public Window(int illumination) {
		super(illumination);
	}

	public Window() {
		super(DEFAULT_ILLUMINATION);
	}

	@Override
	public String toString() {
		return "\n\t\tОкно с освещением " + getIllumination() + "лк";
	}
}
				