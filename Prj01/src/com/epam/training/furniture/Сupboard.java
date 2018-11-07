package com.epam.training.furniture;

public class Ñupboard extends Furniture {

	private int countOfSection;
	private CupboardType type;

	public Ñupboard(double area, int countOfSection, CupboardType type) {
		super(area);
		this.countOfSection = countOfSection;
		this.type = type;
	}

	public Ñupboard(double area) {
		super(area);
	}

	public int getCountOfSection() {
		return countOfSection;
	}

	public void setCountOfSection(int countOfSection) {
		this.countOfSection = countOfSection;
	}

	public CupboardType getType() {
		return type;
	}

	public void setType(CupboardType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "\n\t\tØêàô òèïà " + getType() + "ñ " + getCountOfSection()
				+ " ñåêöèÿìè è ïëîùàäüş  " + getArea() + " m2";
	}

}
