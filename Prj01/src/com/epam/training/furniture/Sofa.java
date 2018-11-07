package com.epam.training.furniture;

public class Sofa extends Furniture {

	private int placeCount;

	public Sofa(double area, int placeCount) {
		super(area);
		this.placeCount = placeCount;
	}

	public Sofa(double area) {
		super(area);
	}

	public int getPlaceCount() {
		return placeCount;
	}

	public void setPlaceCount(int placeCount) {
		this.placeCount = placeCount;
	}

	@Override
	public String toString() {
		return "\n\t\tДиван на  " + getPlaceCount() + " человек и  площадью  "
				+ getArea() + " m2";
	}

}
