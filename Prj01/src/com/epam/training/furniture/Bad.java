package com.epam.training.furniture;

public class Bad extends Furniture {

	private int countPlaces;

	public int getCountPlaces() {
		return countPlaces;
	}

	public void setCountPlaces(int countPlaces) {
		this.countPlaces = countPlaces;
	}

	public Bad(int countPlaces, double area) {
		super(area);
		this.countPlaces = countPlaces;
	}

	public Bad(double area) {
		super(area);
	}
	@Override
	public String toString() {
		return "\n\t\tКровать на " + getCountPlaces() + "человек и площадью " + getArea() + "m2";
	}

}
