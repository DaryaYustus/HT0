package com.epam.training;

import java.util.ArrayList;
import java.util.List;

import com.epam.training.exceptions.IlluminanceTooMuchException;
import com.epam.training.exceptions.SpaceUsageTooMuchException;
import com.epam.training.furniture.Furniture;
import com.epam.training.illumination.Illumination;
import com.epam.training.illumination.Window;

public class Room implements Illuminated, Area {

	String name;
	double areaRoom;

	List<Furniture> furnitures;
	List<Illumination> illuminations;

	public Room(String name, double areaRoom) {
		furnitures = new ArrayList<Furniture>();
		illuminations = new ArrayList<Illumination>();

		this.areaRoom = areaRoom;
		if (areaRoom == 0) {
			areaRoom = 1;
		}
	}

	public Room(String name, double areaRoom, int windowsCount)
			throws IlluminanceTooMuchException {
		furnitures = new ArrayList<Furniture>();
		illuminations = new ArrayList<Illumination>();
		this.name = name;

		// min area of the room 1 м^2
		this.areaRoom = areaRoom;
		if (areaRoom == 0) {
			areaRoom = 1;
		}
		
		//add the several default windows
		for (int i = 0; i < windowsCount; i++) {
			addIllumination(new Window());
		}

	}
	
	//add any type of furniture to the room
	public void addFurniture(Furniture furniture)
			throws SpaceUsageTooMuchException {
		double filledArea = (calculateArea() + furniture.getArea()) / areaRoom;
		if (filledArea < 0.7) {
			furnitures.add(furniture);
		} else {
			throw new SpaceUsageTooMuchException();
		}
	}
	//add any type of illumination (window or Lightbulb) to the room
	public void addIllumination(Illumination illumination)
			throws IlluminanceTooMuchException {
		int filledIllumination = calculateIllumination()
				+ illumination.getIllumination();
		if (filledIllumination > 4000) {
			throw new IlluminanceTooMuchException();
		} else if (filledIllumination < 300) {
			System.out.println("Add more illumination");
			illuminations.add(illumination);
		} else {
			illuminations.add(illumination);
		}
	}

	//calculate area of furniture
	@Override
	public double calculateArea() {
		double countFurnit = 0;
		for (Furniture furn : furnitures) {
			countFurnit += furn.getArea();
		}
		return countFurnit;
	}

	//calculate the illumination in the room
	@Override
	public int calculateIllumination() {
		int countIllumin = 0;
		for (Illumination illum : illuminations) {
			countIllumin += illum.getIllumination();
		}
		return countIllumin;
	}

	//calculate the count of windows
	private int countOfWindows() {
		int count = 0;
		for (Illumination illum : illuminations) {
			if (illum instanceof Window) {
				count++;
			}
		}
		return count;
	}

	public double getAreaRoom() {
		return areaRoom;
	}

	public void setAreaRoom(double areaRoom) {
		this.areaRoom = areaRoom;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//provide necessary presentation of room
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Комната ");
		result.append(getName());
		result.append("\n\tОсвещенность = ");
		result.append(calculateIllumination());
		result.append("\n\tПлощадь комнаты= ");
		result.append(getAreaRoom());
		result.append(" из которых занято ");
		result.append(calculateArea());
		result.append("\n\tМебель:");
		for (Furniture furniture : furnitures) {
			result.append(furniture.toString());
		}
		result.append("\n\tИсточники света:");
		for (Illumination illumination : illuminations) {
			result.append(illumination.toString());
		}
		return result.toString();
	}
}
