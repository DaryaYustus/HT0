package com.epam.training.furniture;

public abstract class Furniture {
	private double area;

	public Furniture(double area) {
		this.area = area;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

}
