package com.epam.training.illumination;

public class Lightbulb extends Illumination {

	String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Lightbulb(int illumination) {
		super(illumination);
	}

	public Lightbulb(int illumination, String color) {
		super(illumination);
		this.color = color;
	}
	

	@Override
	public String toString() {
		return "\n\t\tЛампочка с освещением " + getIllumination() + " лк";
	}

}
