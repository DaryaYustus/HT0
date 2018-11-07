package com.epam.training;

import java.util.ArrayList;
import java.util.List;

public class Building {

	private String buildingNumber;

	private List<Room> rooms;

	public Building(String buildingNumber) {
		this.buildingNumber = buildingNumber;
		rooms = new ArrayList<Room>();
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Здание " + buildingNumber + "\n");
		for (Room room : rooms) {
			result.append(room.toString());
		}
		return result.toString();

	}
}
