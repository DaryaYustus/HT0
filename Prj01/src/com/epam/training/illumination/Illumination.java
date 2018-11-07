package com.epam.training.illumination;

public abstract class Illumination {
	private int illumination;

	public int getIllumination() {
		return illumination;
	}

	public void setIllumination(int illumination) {
		this.illumination = illumination;
	}

	public Illumination(int illumination) {
		super();
		this.illumination = illumination;
	}
	
	

}
